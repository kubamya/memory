<template>
  <div class="setting-container">
    <el-tabs v-model="activeName" stretch>
      <el-tab-pane label="待审核文章" name="reviewList">User</el-tab-pane>
      <el-tab-pane label="全部文章" name="passageList">User</el-tab-pane>
      <el-tab-pane label="标签管理" name="labelManage">
        <Label></Label>
      </el-tab-pane>
      <el-tab-pane label="链接管理" name="linkManage">
        <Link></Link>
      </el-tab-pane>
      <el-tab-pane label="主题管理" name="themeManage">
        <Theme></Theme>
      </el-tab-pane>
      <el-tab-pane label="发布统计" name="publishManage">User</el-tab-pane>
      <el-tab-pane label="审批记录" name="approvalRecord">User</el-tab-pane>
      <el-tab-pane label="用户管理" name="userManage">User</el-tab-pane>
    </el-tabs>
  </div>
</template>
<script>
import Link from './linkManage.vue'
import Label from './labelManage.vue'
import Theme from './themeManage.vue'
export default {
  components: {
    'Link': Link,
    'Label': Label,
    'Theme': Theme
  },
  data () {
    return {
      activeName: 'themeManage'
    }
  }
}
</script>