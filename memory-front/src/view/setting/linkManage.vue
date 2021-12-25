<template>
  <div class="link-container">
    <div class="link-btn-container">
      <el-button type="primary" size="mini" round @click="addLink()">新增链接</el-button>
    </div>
    <el-table 
      :data="linkData"
      v-loading="loading"
      element-loading-text="Loading..."
      :element-loading-spinner="svg"
      element-loading-svg-view-box="-10, -10, 50, 50"
      element-loading-background="rgba(0, 0, 0, 0.8)"
      height="500"
      style="width: 100%">
      <el-table-column prop="cname" label="名称"></el-table-column>
      <el-table-column prop="ctarget" label="链接"></el-table-column>
      <el-table-column prop="cvalid" label="是否有效"></el-table-column>
      <el-table-column prop="dcreatetime" label="创建时间"></el-table-column>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button type="text" size="small" @click="edit(scope.row)">编辑</el-button>
          <el-button type="text" size="small" v-if="scope.row.cvalid == '是'" @click="toggleEnable(scope.row)">置无效</el-button>
          <el-button type="text" size="small" v-if="scope.row.cvalid == '否'" @click="toggleEnable(scope.row)">置有效</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-pagination
      layout="prev, pager, next"
      @current-change="pageChange"
      :page-size="pageInfo.pageSize"
      :total="pageInfo.total">
    </el-pagination>

    <el-dialog
      v-model="dialogVisible"
      title="新增链接"
      width="50%"
    >
      <el-form ref="linkForm" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="名称" prop="cName">
          <el-input v-model="form.cName"></el-input>
        </el-form-item>
        <el-form-item label="链接" prop="cName">
          <el-input v-model="form.cTarget"></el-input>
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
import { saveLink, getLinks, getLinkById, unableLink } from '@/api/settingApi.js'
import { ElNotification, ElMessageBox } from 'element-plus'
export default {
  data () {
    return {
      linkData: [],
      form: {
        cId: '',
        cName: '',
        cTarget: ''
      },
      rules: {
        cName: [{required: true,message: '名称不能为空',trigger: 'blur'}],
        cTarget: [{required: true,message: '链接不能为空',trigger: 'blur'}]
      },
      pageInfo: {
        current: 1,
        pageSize: 20,
        total: 0
      },
      dialogVisible: false,
      loading: false,
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
    this.initLinks()
  },
  methods: {
    // 新增链接
    addLink () {
      this.form = {
        cId: '',
        cName: '',
        cTarget: ''
      }
      this.dialogVisible = true
    },
    // 置无效/有效
    toggleEnable (row) {
      ElMessageBox.confirm(
        `确定将此链接置为${row.cvalid == '是' ? '有' : '无' }效？`,
        '警告',
        {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
        }
      ).then(() => {
        getLinkById({id: row.cid}).then(res => {
          if (res.code == 200) {
            let link = res.data
            unableLink(link).then(res2 => {
              if (res2.code == 200) {
                ElNotification({
                  title: '提示',
                  message: '操作成功',
                  type: 'success',
                })
                this.initLinks()
                this.emitter.emit('restLinks')
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
      })
    },
    // 编辑按钮点击事件
    edit (row) {
      getLinkById({id: row.cid}).then(res => {
        if (res.code == 200) {
          this.form.cId = res.data.cId,
          this.form.cName = res.data.cName,
          this.form.cTarget = res.data.cTarget

          this.dialogVisible = true
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
    // 翻页事件
    pageChange (current) {
      this.pageInfo.current = current
      this.initLinks()
    },
    // 获取标签列表
    initLinks () {
      this.loading = true
      getLinks({current: this.pageInfo.current, pageSize: this.pageInfo.pageSize}).then(res => {
        this.loading = false
        if (res.code == 200) {
            this.linkData = res.data.records
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
    // 保存标签
    save () {
      this.$refs['linkForm'].validate((valid) => {
        if (valid) {
          saveLink(this.form).then(res => {
            if (res.code == 200) {
              ElNotification({
                title: '提示',
                message: '保存成功',
                type: 'success',
              })
              this.dialogVisible = false
              this.initLinks()
              this.emitter.emit('restLinks')
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
<style lang="less" scoped>
.link-container{
  .link-btn-container{
    height: 50px;
    line-height: 40px;
  }
}
</style>