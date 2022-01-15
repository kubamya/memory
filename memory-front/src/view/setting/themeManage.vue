<template>
  <div class="theme-container"> 
    <div class="theme-btn-container">
      <el-button type="primary" size="mini" round @click="dialogVisible = true">添加主题</el-button>
    </div>

    <el-table
      :data="themeData"
      v-loading="loading"
      element-loading-text="Loading..."
      :element-loading-spinner="svg"
      element-loading-svg-view-box="-10, -10, 50, 50"
      element-loading-background="rgba(0, 0, 0, 0.8)"
      height="500"
      style="width: 100%"
    >
      <el-table-column prop="cName" label="名称"></el-table-column>
      <el-table-column prop="cIcon" label="图标"></el-table-column>
      <el-table-column prop="cReviewer" label="审批人"></el-table-column>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button type="text" size="small" @click="edit(scope.row)">编辑</el-button>
          <el-button type="text" size="small" @click="del(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      layout="prev, pager, next"
      @current-change="pageChange"
      :total="pageInfo.total">
    </el-pagination>

    <el-dialog
      v-model="dialogVisible"
      title="新增主题"
      width="50%"
    >
      <el-form ref="themeForm" :model="themeForm" :rules="themeRules" label-width="120px">
        <el-form-item label="名称" prop="cName">
          <el-input v-model="themeForm.cName"></el-input>
        </el-form-item>
        <el-form-item label="图标" prop="cIcon">
          <el-input v-model="themeForm.cIcon"></el-input>
        </el-form-item>
        <el-form-item label="审批人" prop="cReviewer">
          <el-input v-model="themeForm.cReviewer"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">取消</el-button>
          <el-button type="primary" @click="save()">保存</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import { saveTheme, getThemeData } from '@/api/settingApi.js'
import { ElNotification, ElMessageBox } from 'element-plus'
export default {
  data () {
    return {
      loading: false,
      dialogVisible: false,
      themeData: [],
      themeRules: [
        {cName: [{required: true,message: '名称不能为空',trigger: 'blur'}]}
      ],
      themeForm: {
        cId: '',
        cName: '',
        cIcon: '',
        cReviewer: '',
        cValid: '1'
      },
      pageInfo: {
        current: 1,
        pageSize: 10,
        total: 0
      },
      svg: `
        <path class="path" d="
          M 30 15
          L 28 17
          M 25.61 25.61
          A 15 15, 0, 0, 1, 15 30
          A 15 15, 0, 1, 1, 27.99 7.5
          L 15 15
        " style="stroke-width: 4px; fill: rgba(0, 0, 0, 0)"/>
      `
    }
  },
  mounted () {
    this.getData()
  },
  methods: {
    // 编辑主题
    edit (theme) {
      this.dialogVisible = true
      this.themeForm = theme
    },
    // 删除主题
    del (theme) {
      ElMessageBox.confirm(
      '确认删除？',
      '警告',
      {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      }
    ).then(() => {
      theme.cValid = '2'
      debugger
      saveTheme(theme).then(res => {
        if (res.code == 200) {
          ElNotification({
            title: '提示',
            message: '删除成功',
            type: 'success',
          })
          this.getData()
        } else {
          ElNotification({
            title: '警告',
            message: `${res.msg}`,
            type: 'warning',
          })
        }
      }).catch(err => {
        console.log(err);
          ElNotification({
            title: '错误',
            message: `${JSON.stringify(err)}`,
            type: 'error',
          })
      })
    })
    },
    // 重置添加保存
    resetThemeForm () {
      this.themeForm = {
        cId: '',
        cName: '',
        cIcon: '',
        cReviewer: '',
        cValid: '1'
      }
    },
    // 翻页事件
    pageChange (current) {
      this.pageInfo.current = current
      this.getData()
    },
    // 分页获取所有的主题
    getData () {
      this.loading = true
      getThemeData(this.pageInfo).then(res => {
        this.loading = false
        if (res.code == 200) {
            this.themeData = res.data.records
            this.pageInfo.total = res.data.total
        } else {
          ElNotification({
            title: '警告',
            message: `${res.msg}`,
            type: 'warning',
          })
        }
      }).catch(err => {
        this.loading = false
        console.log(err);
        ElNotification({
          title: '错误',
          message: `${JSON.stringify(err)}`,
          type: 'error',
        })
      })
    },
    // 保存主题
    save () {
      this.$refs['themeForm'].validate((valid) => {
        if (valid) {
          saveTheme(this.themeForm).then(res => {
            if (res.code == 200) {
              ElNotification({
                title: '提示',
                message: '保存成功',
                type: 'success',
              })
              this.dialogVisible = false
              this.getData()
              this.resetThemeForm()
            } else {
              ElNotification({
                title: '警告',
                message: `${res.msg}`,
                type: 'warning',
              })
            }
          }).catch(err => {
            console.log(err);
            ElNotification({
              title: '错误',
              message: `${JSON.stringify(err)}`,
              type: 'error',
            })
          })
        } else {
          return
        }
      })
    }
  }
}
</script>