<template>
  <div class="edit-container">
    <div class="edit-title">Edit Memory</div>
    <div id="editer"></div>
  </div>
</template>
<script>
import E from 'wangeditor'
export default {
  data () {
    return {
      passage: {
        title: ''
      }
    }
  },
  mounted () {
    this.initEditer()
  },
  methods: {
    initEditer () {
      const editor = new E('#editer')
      editor.config.height = 500
      editor.create()
    }
  }
}
</script>
<style lang="less" scoped>
.edit-container{
  width: calc(100% - 40px);
  height: calc(100% - 40px);
  background-color: #1f1d2b;
  padding: 20px;

  .edit-title{
    font-size: 30px;
    line-height: 100px;
    color: #fff;
  }
}
</style>