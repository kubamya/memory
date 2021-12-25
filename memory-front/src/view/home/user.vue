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
            <el-dropdown-item @click="goMySpace()">个人资料</el-dropdown-item>
            <el-dropdown-item @click="logout()">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
    <div class="user-notice">
      <el-tooltip
        class="item"
        effect="dark"
        content="发布文章"
        placement="bottom"
      >
        <el-icon @click="goEdit()"><promotion /></el-icon>
      </el-tooltip>
    </div>
    <div class="user-notice">
      <el-tooltip
        class="item"
        effect="dark"
        content="消息提醒"
        placement="bottom"
      >
        <el-icon><bell-filled /></el-icon>
      </el-tooltip>
    </div>

  </div>
</template>
<script>
import { ArrowDown, BellFilled, Promotion } from '@element-plus/icons'
import { ElMessageBox } from 'element-plus'
import _ from 'lodash'
export default {
  components: {
    ArrowDown,
    BellFilled,
    Promotion
  },
  data () {
    return {
      userName: 'admin'
    }
  },
  mounted () {
    this.getUserInfo()
  },
  methods: {

    // 跳转个人资料页
    goMySpace () {
      window.open("/mySpace")
    },

    // 从vuex获取用户信息
    getUserInfo () {
      const userInfoJsonStr = window.localStorage.getItem("userInfo");
      const userName = _.isEmpty(userInfoJsonStr)
        ? null
        : JSON.parse(userInfoJsonStr).name;
      if(_.isEmpty(userName)){
        this.userName = 'please sign in'
      } else {
        this.userName = userName
      }
    },

    // 跳转文章编辑页
    goEdit () {
      window.localStorage.removeItem("userInfo");
      window.open("/edit")
    },

    // 退出登录
    logout () {
      ElMessageBox.confirm(
        '确认退出当前账号？',
        '提示',
        {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
        }).then(() => {
          this.$router.push({path: '/login'})
        })
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
    margin: 0px 10px;
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