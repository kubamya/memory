<template>
  <div class="home-container">
    <div class="home-left-container">
      <Title></Title>
      <Menu></Menu>
      <Labels></Labels>
      <Links></Links>
    </div>
    <div class="home-right-container"></div>
  </div>
</template>
<script>
import Title from './title.vue'
import Menu from './menu/menu.vue'
import Labels from './labels.vue'
import Links from './links.vue'
export default {
  components: {
    'Title': Title,
    'Menu': Menu,
    'Labels': Labels,
    'Links': Links
  }
}
</script>
<style lang="less" scoped>
.home-container{
  width: 100%;
  height: 100%;
  background-color: #1f1d2b;
  .home-right-container{
    width: calc(100% - 250px);
    height: 100%;
    position: absolute;
    right: 0;
  }
  .home-left-container{
    width: 250px;
    height: 100%;
    position: absolute;
    left: 0;
  }
}
</style>