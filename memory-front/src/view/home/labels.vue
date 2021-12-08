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
export default {
  data () {
    return {
      more: false,
      moreIcon: {
        more: require('@/assets/icons/more.png'),
        less: require('@/assets/icons/less.png'),
      },
      labelData: [
        {id: '1', bgc: '#409EFF', label: 'Artery5'},
        {id: '2', bgc: '#67C23A', label: 'Artery6'},
        {id: '3', bgc: '#E6A23C', label: 'ArteryBase'},
        {id: '4', bgc: '#F56C6C', label: 'Nginx'},
        {id: '5', bgc: '#409EFF', label: 'Redis'},
        {id: '6', bgc: '#67C23A', label: 'Vue'},
        {id: '7', bgc: '#E6A23C', label: 'Docker'},
        {id: '8', bgc: '#F56C6C', label: 'SpringBoot'},
        {id: '9', bgc: '#409EFF', label: 'SpringCloud'},
      ]
    }
  },
  methods: {
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