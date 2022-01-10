<template>
  <div class="me-container">
    <Personal></Personal>
    <Title main="专业技能" sub="Professional skills" bgc="#67C23A"></Title>
    <Skill></Skill>

    <Title main="工作经历" sub="work experience" bgc="#409EFF"></Title>
    <Work></Work>

    <Title main="项目经历" sub="Project experience" bgc="#E6A23C"></Title>
    <Project></Project>

    <Title main="兴趣爱好" sub="Hobby" bgc="#F56C6C"></Title>
    <Hobby></Hobby>
  </div>
</template>
<script>
import personal from './personalInfo.vue'
import title from './title.vue'
import work from './work.vue'
import project from './project.vue'
import skill from './skill.vue'
import hobby from './hobby.vue'
export default {
  components: {
    'Title': title,
    'Personal': personal,
    'Work': work,
    'Project': project,
    'Skill': skill,
    'Hobby': hobby
  }
}
</script>
<style lang="less" scoped>
.me-container{
  width: 21cm;
  margin: 0 auto;
  padding: 20px;
  background-image: url('../../assets/imgs/resumeBg2.jpg');
  background-size: 100%;
  background-repeat: no-repeat;
  // border: 1px solid #ccc;
}
/deep/ .el-timeline-item__timestamp.is-top{
  color: #666;
  font-weight: 600;
}
</style>