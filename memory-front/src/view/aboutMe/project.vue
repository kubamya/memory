<template>
  <el-timeline>
    <el-timeline-item
      v-for="project in projectData"
      :timestamp="project.date"
      placement="top"
      :key="project.id">
      <el-card>
        <h4>{{project.name}}</h4>
        <h5 style="color: #666">{{project.role}}</h5>
        <p style="color: #555">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{project.decription}}</p>
      </el-card>
    </el-timeline-item>
  </el-timeline>
</template>
<script>
import projectData from './projectData.js'
export default {
  data () {
    return {
      projectData: projectData
    }
  }
}
</script>