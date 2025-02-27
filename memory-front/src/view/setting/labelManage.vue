<template>
  <div class="label-container">
    <div class="label-btn-container">
      <el-button type="primary" size="mini" round @click="dialogVisible = true">新增标签</el-button>
    </div>
    <el-table 
      :data="labelData"
      v-loading="loading"
      element-loading-text="Loading..."
      :element-loading-spinner="svg"
      element-loading-svg-view-box="-10, -10, 50, 50"
      element-loading-background="rgba(0, 0, 0, 0.8)"
      height="500"
      style="width: 100%">
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
          <el-select v-model="form.cPid" clearable filterable placeholder="请选择">
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
import { addLabel, getLabels, getLabelById, updateLabel, deleteLabel, getAllLabels } from '@/api/settingApi.js'
import { ElNotification, ElMessageBox } from 'element-plus'
export default {
  data () {
    return {
      labelData: [],
      parentLables: [],
      dialogVisible: false,
      loading: false,
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
    this.getLabels()
    this.initParentLabels()
  },
  methods: {
    // 初始化父级标签数据
    initParentLabels () {
      getAllLabels().then(res => {
        if (res.code == 200) {
          this.parentLables = []
          let retData = res.data
          retData.forEach(item => {
            this.parentLables.push({
              label: item.label,
              value: item.id
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
            this.initParentLabels()
            ElNotification({
              title: '提示',
              message: '删除成功',
              type: 'success',
            })
            this.getLabels()
            this.emitter.emit('restLabel')
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
          this.initParentLabels()
          this.emitter.emit('restLabel')
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
      this.loading = true
      getLabels({current: this.pageInfo.current, pageSize: this.pageInfo.pageSize}).then(res => {
        this.loading = false
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
      this.$refs['labelForm'].validate((valid) => {
        if (valid) {
          if (this.form.cId == '' || this.form.cId == undefined) {
            addLabel(this.form).then(res => {
              if (res.code == 200) {
                this.initParentLabels()
                this.emitter.emit('restLabel')
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
                this.initParentLabels()
                this.emitter.emit('restLabel')
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