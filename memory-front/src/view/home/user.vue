<template>
  <div class="user-container">
    <div class="user-avatar">
      <img src="@/assets/imgs/default-avatar.jpg">
    </div>
    <div class="user-operation">
      <el-dropdown trigger="click">
        <span class="el-dropdown-link">
          {{userName}}
          <el-icon class="el-icon--right">
            <arrow-down />
          </el-icon>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item>个人资料</el-dropdown-item>
            <el-dropdown-item>退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
    <div class="user-notice">
      <el-icon><bell-filled /></el-icon>
    </div>

  </div>
</template>
<script>
import { ArrowDown, BellFilled } from '@element-plus/icons'
export default {
  components: {
    ArrowDown,
    BellFilled
  },
  data () {
    return {
      userName: 'admin'
    }
  }
}
</script>
<style lang="less" scoped>
.user-container{
  width: 50%;
  height: 100px;
  line-height: 75px;
  position: absolute;
  right: 0;
  top: 0;
  display: flex;
  justify-content: right;
  .user-avatar{
    width: 50px;
    height: 100px;
    padding-top: 15px;
    img{
      width: 50px;
      height: 50px;
      border-radius: 25px;
    }
  }
  .user-operation{
    height: 100px;
    margin: 0px 0px 0px 20px;
    text-align: right;
  }
  .user-notice{
    width: 50px;
    height: 100px;
    text-align: center;
    line-height: 90px;
    margin: 0px 20px;
    .el-icon{
      font-size: 25px;
      color: rgba(255, 255, 255, 0.5);
      cursor: pointer;
    }
    .el-icon:hover{
      transform: scale(1.2);
    }
  }
}
</style>