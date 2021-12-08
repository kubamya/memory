<template>
  <div class="menu-container">
    <div class="menu-title">菜单</div>
    <div class="menu-item"
      v-for="item in menuData"
      :key="item.id"
      @click="handleClick(item)">
      <div class="menu-item-icon" :style="item.focus ? {background: item.bgcFocus} : {background: item.bgcDefault}">
        <img :src="item.focus ? item.iconFocus : item.iconDefault">
      </div>
      <div class="menu-item-label" :style="item.focus ? {color: '#fff'} : {color: '#666'}">{{item.label}}</div>
    </div>
    <hr width="210">
  </div>
</template>
<script>
import menu from './menu'
export default {
  data () {
    return {
      path: require('@/assets/icons/myPassage.png'),
      menuData: menu
    }
  },
  methods: {
    // 菜单点击事件
    handleClick (item) {
      // 菜单点击时修改菜单项样式
      for (let i = 0; i < this.menuData.length; i++) {
        if (this.menuData[i].id == item.id) {
          this.menuData[i].focus = true
        } else {
          this.menuData[i].focus = false
        }
      }
    }
  }
}
</script>
<style lang="less" scoped>
.menu-container{
  width: 100%;
  margin-top: 120px;
  hr{
    margin: 0 auto;
    margin-top: 40px;
    margin-bottom: 40px;
    border: 1px solid rgba(255, 255, 255, 0.1);
  }
  .menu-item{
    display: flex;
    margin-top: 20px;
    cursor: pointer;
    .menu-item-label{
      color: #666;
      line-height: 40px;
      font-weight: 600;
    }
    .menu-item-icon{
      width: 40px;
      height: 40px;
      border-radius: 10px;
      background-color: rgba(255, 255, 255, 0.2);
      margin: 0px 20px 0px 20px;
      img{
        width: 20px;
        height: 20px;
        margin: 10px 0px 0px 10px;
      }
    }
  }
  .menu-title{
    padding-left: 20px;
    color: #999;
  }
}
</style>