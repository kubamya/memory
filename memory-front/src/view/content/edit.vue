<template>
  <div class="edit-container">
    <div class="edit-title">Edit Memory</div>
    <el-form ref="passageForm" :model="passageForm" label-position="top" :rules="passageRules" label-width="120px">
      <el-form-item label="标题" prop="cTitle">
        <el-input v-model="passageForm.cTitle"></el-input>
      </el-form-item>
      
    </el-form>

    <div id="editer"></div>

    <el-form ref="passageSubForm" :model="passageForm" label-position="left" inline :rules="passageRules" label-width="60px">
      <el-form-item label="主题" prop="cTheme">
        <el-select v-model="passageForm.cTheme" placeholder="请选择主题" clearable>
          <el-option
            v-for="item in themeOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          >
        </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="标签" prop="cLabels">
        <el-select v-model="passageForm.cLabels" multiple placeholder="请选择标签" clearable>
          <el-option
            v-for="item in labelOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
            >
          </el-option>
        </el-select>
      </el-form-item>
    </el-form>
    <el-button class="pub-btn" type="primary" @click="publish()">发布</el-button>
  </div>
</template>
<script>
import E from 'wangeditor'
import _ from 'lodash'
import { getAllThemes, getAllLabels } from '@/api/settingApi.js'
import { publishPassage } from '@/api/passageApi.js'
import { ElNotification } from 'element-plus'
export default {
  data () {
    return {
      editor: {},
      passageForm: {
        cTitle: '',
        cContent: '',
        cTheme: '',
        cLabels: '',
        cText: '',
        cId: ''
      },
      passageRules: {
        cTitle: [{required: true,message: '标题不能为空',trigger: 'blur'}],
        cTheme: [{required: true,message: '主题不能为空',trigger: 'blur'}],
        cLabels: [{required: true,message: '标签不能为空',trigger: 'blur'}]
      },
      themeOptions: [],
      labelOptions: []
    }
  },
  mounted () {
    this.initEditer()
    this.getThemeOptions()
    this.getLabelOptions()
  },
  methods: {
    // 发布按钮事件
    publish () {
      this.passageForm.cContent = this.editor.txt.html()
      this.passageForm.cText = this.editor.txt.text()
      this.passageForm.cLabels = JSON.stringify(this.passageForm.cLabels)

      this.$refs['passageForm'].validate((valid) => {
        if (valid) {
          this.$refs['passageSubForm'].validate((subValid) => {
            if (subValid) {
              if (_.isEmpty(this.passageForm.cContent) || _.isEmpty(this.passageForm.cText)) {
                ElNotification({
                  title: '警告',
                  message: `文章内容不能为空`,
                  type: 'warning',
                })
                return
              } else {
                publishPassage(this.passageForm).then(res => {
                  if (res.code == 200) {
                    ElNotification({
                      title: '提示',
                      message: '保存成功，审核后给予显示',
                      type: 'success',
                    })
                    window.setTimeout(() => {
                      this.$router.push({
                        path: '/'
                      })
                    }, 1000)
                  }  else {
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
              ElNotification({
                title: '警告',
                message: `请检查主题标签和标签是否选择`,
                type: 'warning',
              })
              return
            }
          })
        } else {
          return
        }
      })

    },
    // 获取所有有效的标签
    getLabelOptions () {
      getAllLabels().then(res => {
        if (res.code == 200) {
          res.data.forEach(label => {
            this.labelOptions.push({
              label: label.label,
              value: label.id
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
    // 获取所有有效的主题
    getThemeOptions () {
      getAllThemes().then(res => {
        if (res.code == 200) {
          res.data.forEach(theme => {
            this.themeOptions.push({
              label: theme.cName,
              value: theme.cId
            })
          });
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
    // 编辑器初始化
    initEditer () {
      this.editor = new E('#editer')
      this.editor.config.height = 500
      this.editor.create()
    }
  }
}
</script>
<style lang="less" scoped>
.edit-container{
  width: calc(100% - 40px);
  height: calc(100% - 40px);
  background-color: #1f1d2b;
  padding: 20px;

  #editer{
    margin-bottom: 20px;
  }

  .edit-title{
    font-size: 30px;
    line-height: 100px;
    color: #fff;
  }
}
</style>