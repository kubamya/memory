<template>
  <div class="title-container">
    <div class="title-content">MEMORY</div>
    <div class="title-version">v1.0.0</div>
  </div>
</template>
<script>
export default {
  data () {

  }
}
</script>
<style lang="less" scoped>
.title-container{
  width: 250px;
  height: 120px;
  position: fixed;
  top: 0;
  z-index: 999;
  background-color: #1f1d2b;
  .title-content{
    width: 100%;
    text-align: center;
    line-height: 80px;
    font-size: 36px;
    color: #fff;
  }
  .title-version{
    width: 100%;
    text-align: center;
    color: #666;
    line-height: 0;
  }
}
</style>