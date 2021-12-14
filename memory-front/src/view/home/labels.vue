<template>
  <div class="label-container">
    <div class="label-title">标签</div>
    <div class="label-item-container">
      <div
        class="label-item"
        v-for="item in labelData"
        :style="{backgroundColor: item.bgc}"
        :key="item.id" >
        {{item.label}}
      </div>
    </div>
    <div class="label-more" @click="more = !more">
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
      labelData: []
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
    // 初始化数据
    init () {
      getAllLabels().then(res => {
        if (res.code == 200) {
          this.labelData = res.data
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