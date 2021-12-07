<template>
  <div class="links-container">
    <div class="links-title">友情链接</div>
    <div class="links-item" v-for="item in linkData" :key="item.id">
      {{item.name}}
    </div>
    <hr width="210">
  </div>
</template>
<script>
export default {
  data () {
    return {
      linkData: [
        {id: '1', name: 'Artery', target: 'http://artery.thunisoft.com'},
        {id: '1', name: 'TSTC', target: 'http://tstc.thunisoft.com'},
        {id: '1', name: '开发必会', target: 'http://www.baidu.com'},
      ]
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