<template>
  <div class="search-container">
    <el-input v-model="keywords" placeholder="Type something">
      <template #prefix>
        <el-icon class="el-input__icon"><search /></el-icon>
      </template>
    </el-input>
  </div>
</template>
<script>
import { Search } from '@element-plus/icons'
export default {
  components: {
    Search
  },
  data () {
    return {
      keywords: ''
    }
  }
}
</script>
<style lang="less" scoped>
.search-container {
  width: 50%;
  height: 100px;
  line-height: 75px;
  position: absolute;
  left: 0;
  top: 0;
}
</style>