<template>
  <div class="title-container">
    <span :style="style" class="main">{{main}}</span>
    <span class="sub">{{sub}}</span>
  </div>
</template>
<script>
export default {
  props: {
    main: {
      type: String,
      default: () => {''}
    },
    sub: {
      type: String,
      default: () => {''}
    },
    bgc: {
      type: String,
      default: () => {'#67C23A'}
    }
  },
  data () {
    return {
      style: {
        background: ''
      }
    }
  },
  mounted () {
    this.style.background = this.bgc
  }
}
</script>
<style lang="less" scoped>
.title-container{
  margin: 20px 0px;
  .main{
    padding: 5px 20px;
    border-radius: 0px 20px 0px 20px;
    color: #fff;
  }
  .sub{
    color: #ddd;
    font-size: 10px;
    margin-left: 10px;
  }
}
</style>