<template>
  <div class="personal-container">
    <div class="name-container">
      王浩 | Java全栈开发工程师
    </div>
    <el-form class="base-info-form" :inline="true">
      <el-form-item label="Tel：">18340873070</el-form-item>
      <el-form-item label="E-mail：">1607037747@qq.com</el-form-item>
      <el-form-item label="Birthday：">1996.08.22</el-form-item>
      <el-form-item label="School：">2014.09 - 2018.07 | 大连工业大学 | 信息科学与工程学院 | 计算机科学与技术 | 本科</el-form-item>
      <el-form-item label="GitHub：">https://github.com/kubamya/memory</el-form-item>
    </el-form>
  </div>
</template>
<script>
import './aboutMe.less'
export default {

}
</script>
<style lang="less" scoped>
.personal-container{
  .name-container{
    font-size: 24px;
    color: #fff;
  }
}
/deep/ .el-form{
  margin-top: 10px;
}
/deep/ .el-form-item{
  margin-bottom: 0px
}
/deep/ .el-form--inline .el-form-item{
  margin-right: 30px;
}
/deep/ .el-form-item__label{
  padding: 0 3px 0 0;
}
</style>