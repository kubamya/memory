<template>
  <div class="label-container">
    <div class="label-title">标签</div>
    <div
      v-loading="loading"
      element-loading-text="Loading..."
      :element-loading-spinner="svg"
      element-loading-svg-view-box="-10, -10, 50, 50"
      element-loading-background="rgba(0, 0, 0, 0.8)"
      class="label-item-container">
      <div
        class="label-item"
        v-for="item in showLabelData"
        :style="{backgroundColor: item.bgc}"
        :key="item.id" >
        {{item.label}}
      </div>
    </div>
    <div class="label-more" v-if="labelData.length > 10" @click="toggle()">
      <img :src="more ? moreIcon.less : moreIcon.more">
    </div>
    <hr width="210">
  </div>
</template>
<script>
import { getAllLabels } from '@/api/settingApi.js'
import { ElNotification } from 'element-plus'
export default {
  data () {
    return {
      more: false,
      moreIcon: {
        more: require('@/assets/icons/more.png'),
        less: require('@/assets/icons/less.png'),
      },
      labelData: [],
      showLabelData: [],
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
    this.init()
    this.$nextTick(() => {
      this.emitter.on('restLabel', () => {
        this.init()
      })
    })
  },
  methods: {
    toggle () {
      if (!this.more) {
        // 展示全部标签
        this.showLabelData = this.labelData
        this.more = !this.more
      } else {
        // 展示前10个标签
        this.showLabelData = []
        
        for (let i = 0; i < 10; i++) {
          this.showLabelData.push({...this.labelData[i]}) ;
        }

        this.more = !this.more
      }
    },
    // 初始化数据
    init () {
      this.loading = true
      getAllLabels().then(res => {
        this.loading = false
        if (res.code == 200) {
          this.labelData = res.data

          if (this.labelData.length > 10) {
            this.showLabelData = []
            
            for (let i = 0; i < 10; i++) {
              this.showLabelData.push({...this.labelData[i]}) ;
            }
          }
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
.label-container{
  .label-more{
    width: calc(100% - 40px);
    height: 30px;
    background-color: rgba(255, 255, 255, 0.2);
    margin: 0 auto;
    margin-top: 20px;
    border-radius: 8px;
    position: relative;
    cursor: pointer;
    img{
      width: 20px;
      height: 20px;
      position: absolute;
      top: 5px;
      left: calc(50% - 10px);
    }
  }
  .label-item-container{
    padding: 0px 20px;
    display: flex;
    flex-flow: row wrap;
    .label-item:hover{
      transform: scale(1.1);
    }
    .label-item{
      background-color: rgba(255, 255, 255, 0.2);
      color: #fff;
      padding: 10px;
      margin: 10px 10px 0px 0px;
      border-radius: 10px;
      font-size: 12px;
      cursor: pointer;
    }
  }
  hr{
    margin: 0 auto;
    margin-top: 40px;
    margin-bottom: 40px;
    border: 1px solid rgba(255, 255, 255, 0.1);
  }
  .label-title{
    padding-left: 20px;
    margin-bottom: 10px;
    color: #999;
  }
}
</style>