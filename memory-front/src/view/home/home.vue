<template>
  <div class="home-container">
    <div class="home-left-container">
      <Title></Title>
      <Menu @menuClick="menuClick"></Menu>
      <Labels></Labels>
      <Links></Links>
    </div>
    <div class="home-right-container">
      <div class="home-top-container">
        <Search v-if="currentPage == 'home'"></Search>
        <User></User>
      </div>
      <div class="home-content-container">
        <Content v-if="currentPage == 'home'"></Content>
        <MyPassage v-if="currentPage == 'myPassage'"></MyPassage>
        <Collectons v-if="currentPage == 'collections'"></Collectons>
        <Settings v-if="currentPage == 'settings'"></Settings>
      </div>
    </div>
  </div>
</template>
<script>
import Title from './title.vue'
import Menu from './menu/menu.vue'
import Labels from './labels.vue'
import Links from './links.vue'
import Search from './search.vue'
import User from './user.vue'
import Content from '../content/content.vue'
import Collectons from '../collections.vue'
import MyPassage from '../myPassage.vue'
import Settings from '../setting/settings.vue'
export default {
  components: {
    'Title': Title,
    'Menu': Menu,
    'Labels': Labels,
    'Links': Links,
    'Search': Search,
    'User': User,
    'Content': Content,
    'Collectons': Collectons,
    'MyPassage': MyPassage,
    'Settings': Settings
  },
  data () {
    return {
      currentPage: 'home'
    }
  },
  methods: {
    menuClick (item) {
      this.currentPage = item.target
    }
  }
}
</script>
<style lang="less" scoped>
.home-container{
  width: 100%;
  height: 100%;
  background-color: #1f1d2b;
  .home-right-container{
    width: calc(100% - 300px);
    height: 100%;
    position: absolute;
    right: 0;
    .home-top-container{
      width: 100%;
      height: 100px;
      position: relative;
    }
    .home-content-container{
      width: 100%;
      height: calc(100% - 100px);
      overflow: auto;
    }
  }
  .home-left-container{
    width: 250px;
    height: 100%;
    margin-right: 50px;
    overflow-y: auto;
    position: absolute;
    left: 0;
  }
}
/deep/ .el-input__inner{
  background-color: rgba(255, 255, 255, 0.1);
}
</style>