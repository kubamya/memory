<template>
  <div class="links-container">
    <div class="links-title">友情链接</div>
    <div
      v-loading="loading"
      element-loading-text="Loading..."
      :element-loading-spinner="svg"
      element-loading-svg-view-box="-10, -10, 50, 50"
      element-loading-background="rgba(0, 0, 0, 0.8)">
      <div class="links-item" v-for="item in linkData" :key="item.id">      
        <a :href="item.ctarget" target="_blank">{{item.cname}}</a>
      </div>
    </div>
    <hr width="210">
  </div>
</template>
<script>
import { getAllLinks } from '@/api/settingApi.js'
import { ElNotification } from 'element-plus'
export default {
  data () {
    return {
      linkData: [],
      loading: false,
      svg: `
        <path class="path" d="
          M 30 15
          L 28 17
          M 25.61 25.61
          A 15 15, 0, 0, 1, 15 30
          A 15 15, 0, 1, 1, 27.99 7.5
          L 15 15
        " style="stroke-width: 4px; fill: rgba(0, 0, 0, 0)"/>
      `
    }
  },
  mounted () {
    this.initLables()
    this.$nextTick(() => {
      this.emitter.on('restLinks', () => {
        this.initLables()
      })
    })
  },
  methods: {
    initLables () {
      this.loading = true
      getAllLinks().then(res => {
        this.loading = false
        if (res.code == 200) {
          this.linkData = res.data
        } else {
          ElNotification({
            title: '警告',
            message: `${res.msg}`,
            type: 'warning',
          })
        }
      }).catch(err => {
        this.loading = false
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
.links-container{
  .links-item{
    padding: 10px 0px 0px 20px;
    color: rgba(255, 255, 255, 0.3);
    cursor: pointer;
    a{
      color: rgba(255, 255, 255, 0.3);
      text-decoration: none;
    }
  }
  .links-item:hover{
    color: rgba(255, 255, 255, 0.5);
  }
  hr{
    margin: 0 auto;
    margin-top: 40px;
    margin-bottom: 40px;
    border: 1px solid rgba(255, 255, 255, 0.1);
  }
  .links-title{
    padding: 0px 0px 20px 20px;
    color: #999;
  }
}
</style>