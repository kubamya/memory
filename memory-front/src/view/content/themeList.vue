<template>
  <div class="content-themes-container">
    <div class="content-theme" v-for="theme in themes" :key="theme.id">
      <div class="theme-title">{{theme.name}}</div>
      <div class="theme-icon">
        <img :src="theme.img">
      </div>
      <div class="theme-info">
        <p>浏览：{{theme.count}}</p>
        <p>上次更新：{{theme.lastedUpdate}}</p>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      themes: [
        {id: '1', count: 100, lastedUpdate: '2021-12-11', name: '业务知识', img: require('@/assets/icons/knowledge.png')},
        {id: '2', count: 100, lastedUpdate: '2021-12-11', name: '技术案例', img: require('@/assets/icons/codes.png')},
        {id: '3', count: 100, lastedUpdate: '2021-12-11', name: '技术规范', img: require('@/assets/icons/rules.png')},
        {id: '4', count: 100, lastedUpdate: '2021-12-11', name: 'TAP', img: require('@/assets/icons/tap.png')},
        {id: '1', count: 100, lastedUpdate: '2021-12-11', name: '业务知识', img: require('@/assets/icons/knowledge.png')},
        {id: '2', count: 100, lastedUpdate: '2021-12-11', name: '技术案例', img: require('@/assets/icons/codes.png')},
        {id: '3', count: 100, lastedUpdate: '2021-12-11', name: '技术规范', img: require('@/assets/icons/rules.png')},
        {id: '4', count: 100, lastedUpdate: '2021-12-11', name: 'TAP', img: require('@/assets/icons/tap.png')},
      ] 
    }
  }
}
</script>
<style lang="less" scoped>
.content-themes-container{
  width: 100%;
  .content-theme:hover {
    animation: flip 0.5s;
  }
  .content-theme{
    background-color: #252936;
    width: 220px;
    height: 100px;
    display: inline-block;
    margin-right: 20px;
    margin-bottom: 20px;
    border-radius: 20px;
    position: relative;
    cursor: pointer;
    .theme-title{
      padding-left: 80px;
      font-size: 18px;
      height: 50px;
      line-height: 75px;
      color: #fff;
    }
    .theme-info{
      padding-left: 80px;
      line-height: 18px;
      font-size: 12px;
      p{          
        color: #747480;
      }
    }
    .theme-icon{
      width: 50px;
      height: 50px;
      border-radius: 25px;
      border: 1px solid #eee;
      text-align: center;
      overflow: hidden;
      position: absolute;
      top: 25px;
      left: 15px;
      img{
        width: 50px;
        height: 50px;
      }
    }
  }
}
</style>