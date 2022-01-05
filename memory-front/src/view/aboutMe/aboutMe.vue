<template>
  <div class="me-container">
    <Personal></Personal>
    <Title main="专业技能" sub="Professional skills" bgc="#67C23A"></Title>

    <Title main="工作经历" sub="work experience" bgc="#409EFF"></Title>
    <Work></Work>

    <Title main="项目经历" sub="Project skills" bgc="#E6A23C"></Title>
    <Project></Project>

    <Title main="自我评价" sub="Self evaluation" bgc="#F56C6C"></Title>
  </div>
</template>
<script>
import personal from './personalInfo.vue'
import title from './title.vue'
import work from './work.vue'
import project from './project.vue'
export default {
  components: {
    'Title': title,
    'Personal': personal,
    'Work': work,
    'Project': project
  }
}
</script>
<style lang="less" scoped>
.me-container{
  width: 21cm;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
}
</style>