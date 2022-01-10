<template>
  <div class="hobby-container">
    <p>
      <el-tag class="ml-2" type="success">摄影</el-tag>
      假期出门时会带相机拍拍风景
    </p>
    <p>
      <el-tag class="ml-2" type="warning">做视频</el-tag>
      偶尔做做视频，记录一下自己的生活
    </p>
    <p>
      <el-tag>打游戏</el-tag>
      业余期间打打游戏，steam平台为主，epic平台为次
    </p>
    <p>
      <el-tag class="ml-2" type="error">看美剧</el-tag>
      <el-tag class="ml-2" type="warning">维护维护自己的github</el-tag>
      <el-tag class="ml-2" type="success">翻翻一些技术方向公众号</el-tag>
    </p>
  </div>
</template>
<style lang="less" scoped>
.hobby-container{
  p{
    font-size: 14px;
    color: #333;
    .el-tag{
      margin: 5px;
    }
  }
}
</style>