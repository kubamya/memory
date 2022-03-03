<template>
  <div class="content-themes-container">
    <div class="content-theme" v-for="theme in themes" :key="theme.id">
      <div class="theme-title">{{theme.name}}</div>
      <div class="theme-icon">
        <img :src="theme.img == '' ? require('@/assets/icons/codes.png') : theme.img ">
      </div>
      <div class="theme-info">
        <p>浏览：{{theme.count}}</p>
        <p>上次更新：{{theme.lastupdate == null ? '暂无' : theme.lastupdate}}</p>
      </div>
    </div>
  </div>
</template>
<script>
import { getThemeList } from '@/api/passageApi.js'
import { ElNotification } from 'element-plus'
export default {
  data () {
    return {
      themes: [] 
    }
  },
  mounted () {
    this.getData()
  },
  methods: {
    getData () {
      getThemeList().then(res => {
        if (res.code == 200) {
          this.themes = res.data
        } else {
          ElNotification({
            title: '警告',
            message: `${res.msg}`,
            type: 'warning',
          })
        }
      }).catch(err => {
        console.log(err);
        ElNotification({
          title: '错误',
          message: `${JSON.stringify(err)}`,
          type: 'error',
        })
      })
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