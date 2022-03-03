<template>
  <div class="content-container">
    <!-- 主题 -->
    <ThemeList></ThemeList>

    <!-- 文章列表 -->
    <PassageList></PassageList>

  </div>
</template>
<script>
import ThemeList from './themeList.vue'
import PassageList from './passageList.vue'
export default {
  components: {
    'ThemeList': ThemeList,
    'PassageList': PassageList
  }
}
</script>