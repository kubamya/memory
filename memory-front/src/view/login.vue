<template>
  <div class="login-container">
    <div class="sign-in">
      <div class="sign-in-title">登 录</div>
      <div class="fast-sign-in">
        <div class="fast-sign-in-item"><img src="@/assets/icons/qq.png"></div>
        <div class="fast-sign-in-item"><img src="@/assets/icons/wechat.png"></div>
        <div class="fast-sign-in-item"><img src="@/assets/icons/phone.png"></div>
      </div>
      <div class="sign-in-tips">
        使用账号密码登录：
      </div>
      <div class="sign-in-form">
        <div class="sign-in-form-item">
          <img src="@/assets/icons/account.png">
          <input type="text" placeholder="Username" v-model="signIn.username">
        </div>
        <div class="sign-in-form-item">
          <img src="@/assets/icons/password.png">
          <input type="password" placeholder="Password" v-model="signIn.password">
        </div>
      </div>
      <div class="sign-in-tips">
        <span class="sign-in-tips-link">忘记密码？</span>
      </div>
      <div class="sign-in-btn">登 录</div>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      signIn: {
        username: '',
        password: ''
      }
    }
  }
}
</script>

<style lang="less" scoped>
.login-container{
  width: 100%;
  height: 100%;
  background-color: #eee;
  .sign-in-btn{
    width: 200px;
    height: 50px;
    text-align: center;
    font-weight: 600;
    color: #fff;
    line-height: 50px;
    border-radius: 25px;
    background: linear-gradient(45deg, rgb(156, 87, 246), rgb(202, 127, 216));
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    margin: 0 auto;
    cursor: pointer;
  }
  .sign-in-form{
    .sign-in-form-item{
      width: 300px;
      height: 50px;
      margin: 0 auto;
      margin-bottom: 20px;
      background-color: #eee;
      border-radius: 10px;
      display: flex;
      input{
        background: none;
        border: none;
        outline: none;
        padding-left: 10px;
      }
      img{
        width: 25px;
        height: 25px;
        margin-top: 10px;
        margin-left: 10px;
      }
    }
  }
  .sign-in{
    background-color: #fff;
    width: 500px;
    height: 600px;
    border-radius: 20px;
    position: absolute;
    box-shadow: 0 4px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
    top: 20%;
    left: 30%;
    .sign-in-title{
      text-align: center;
      font-size: 35px;
      line-height: 100px;
      font-weight: 600;
      color: rgb(102, 21, 209);
    }
    .fast-sign-in{
      display: flex;
      justify-content: center;
      .fast-sign-in-item{
        width: 50px;
        height: 50px;
        border: 1px solid #707070;
        border-radius: 25px;
        position: relative;
        margin: 0px 10px;
        overflow: hidden;
        cursor: pointer;
        img{
          width: 60%;
          height: 60%;
          position: absolute;
          left: 20%;
          top: 20%;
        }
      }
    }
    .sign-in-tips-link{
      cursor: pointer;
    }
    .sign-in-tips{
      text-align: center;
      color: #333;
      font-size: 10px;
      line-height: 70px;
    }
  }
}
</style>