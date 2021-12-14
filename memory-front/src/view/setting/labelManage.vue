<template>
  <div class="label-container">
    <div class="label-btn-container">
      <el-button type="primary" size="mini" round @click="dialogVisible = true">新增标签</el-button>
    </div>
    <el-table :data="labelData" height="500" style="width: 100%">
      <el-table-column prop="name" label="名称"></el-table-column>
      <el-table-column prop="pName" label="父级名称"></el-table-column>
      <el-table-column prop="bgc" label="标签颜色">
        <template #default="scope">
          <div :style="{width: '50px',height: '30px',background: scope.row.bgc}"></div>
        </template>
      </el-table-column>
      <el-table-column prop="description" label="描述"></el-table-column>
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
      title="新增标签"
      width="50%"
    >
      <el-form ref="labelForm" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="父级标签">
          <el-select v-model="form.cPid" placeholder="请选择">
            <el-option
              v-for="label in parentLables"
              :label="label.label"
              :value="label.value"
              :key="label.value">              
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="名称" prop="cName">
          <el-input v-model="form.cName"></el-input>
        </el-form-item>
        <el-form-item label="描述">
          <el-input type="textarea" row="3" v-model="form.cDescription"></el-input>
        </el-form-item>
        <el-form-item label="标签颜色">
          <el-input type="color" v-model="form.cBgc"></el-input>
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
import { addLabel, getLabels, getLabelById, updateLabel, deleteLabel } from '@/api/settingApi.js'
import { ElNotification, ElMessageBox } from 'element-plus'
export default {
  data () {
    return {
      labelData: [],
      parentLables: [
        {label: '前端', value: '1'},
        {label: '后端', value: '2'},
      ],
      dialogVisible: false,
      form: {
        cId: '',
        cPid: '',
        cName: '',
        cDescription: '',
        cBgc: '#409EFF'
      },
      rules: {
        cName: [{required: true,message: '名称不能为空',trigger: 'blur'}]
      },
      pageInfo: {
        current: 1,
        pageSize: 10,
        total: 100
      }
    }
  },
  mounted () {
    this.getLabels()
  },
  methods: {
    // 删除
    del (row) {
      ElMessageBox.confirm(
        '此操作将永久删除此标签，是否继续？',
        '警告',
        {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
        }
      ).then(() => {
        deleteLabel({id: row.id}).then(res => {
          if (res.code == 200) {
            ElNotification({
              title: '提示',
              message: '删除成功',
              type: 'success',
            })
            this.getLabels()
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
    // 编辑
    edit (row) {
      getLabelById({id: row.id}).then(res => {
        if (res.code == 200) {
          this.form = {
            cId: res.data.cId,
            cPid: res.data.cPid,
            cName: res.data.cName,
            cDescription: res.data.cDescription,
            cBgc: res.data.cBgc
          }
          this.dialogVisible = true
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
    },
    // 跳页
    pageChange (current) {
      this.pageInfo.current = current
      this.getLabels()
    },
    // 获取标签列表数据
    getLabels () {
      getLabels({current: this.pageInfo.current, pageSize: this.pageInfo.pageSize}).then(res => {
        if (res.code == 200) {
          let retData = res.data.records
          this.pageInfo.total = res.data.total
          this.labelData = []
          retData.forEach(element => {
            this.labelData.push({
              id: element.cid,
              name: element.name,
              pName: element.pname,
              pid: element.cpid,
              bgc: element.bgc,
              description: element.description
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
      this.$refs['labelForm'].validate((valid) => {
        if (valid) {
          if (this.form.cId == '' || this.form.cId == undefined) {
            addLabel(this.form).then(res => {
              if (res.code == 200) {
                ElNotification({
                  title: '提示',
                  message: '保存成功',
                  type: 'success',
                })
                this.dialogVisible = false
                this.form = {
                  cPid: '',
                  cName: '',
                  cDescription: '',
                  cBgc: '#409EFF'
                }
                this.getLabels()
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
            updateLabel(this.form).then(res => {
              if (res.code == 200) {
                ElNotification({
                  title: '提示',
                  message: '保存成功',
                  type: 'success',
                })
                this.dialogVisible = false
                this.form = {
                  cPid: '',
                  cName: '',
                  cDescription: '',
                  cBgc: '#409EFF'
                }
                this.getLabels()
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
          }

        } else {
          return
        }
      })
    }
  }
}
</script>
<style lang="less" scoped>
.label-container{
  .label-btn-container{
    height: 50px;
    line-height: 40px;
  }
}
</style>