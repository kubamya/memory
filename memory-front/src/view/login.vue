<template>
  <div class="login-container">
    <div class="login-sys-logo">
      <img src="@/assets/imgs/logo3.png">
    </div>
    
    <div class="form-container">
      <div class="sign-form sign-up-form" :style="signUpStyle">
        <div class="sign-title" :style="signUpTitleStyle">Sign Up</div>
        <el-input @focus="focusForm('signUp')" placeholder="username" v-model="register.username"></el-input>
        <el-input @focus="focusForm('signUp')" type="password" placeholder="password" v-model="register.password"></el-input>
        <el-input @focus="focusForm('signUp')" type="password" placeholder="password" v-model="register.confirmPass"></el-input>
        <el-input @focus="focusForm('signUp')" placeholder="Email" v-model="register.email"></el-input>
        <el-button type="primary" :disabled="currentForm != 'signUp' " @click="doSignUp()">sign up</el-button>
      </div>
      <div class="sign-form sign-in-form" :style="signInStyle">
        <div class="sign-title" :style="signInTitleStyle">Sign In</div>
        <el-input @focus="focusForm('signIn')" placeholder="username" v-model="user.username"></el-input>
        <el-input @focus="focusForm('signIn')" type="password" placeholder="password" v-model="user.password"></el-input>
        <el-button type="primary" :disabled="currentForm != 'signIn' " @click="doSignIn()">sign in</el-button>
      </div>
    </div>
  </div>
</template>
<script>
import { signIn, signUp } from '@/api/userApi.js'
import {mapMutations, mapState} from "vuex"
import { ElNotification } from 'element-plus'
import _ from 'lodash'
export default {
  data () {
    return {
      user: {
        username: 'admin',
        password: '123'
      },
      register: {
        username: '',
        password: '',
        confirmPass: '',
        email: ''
      },
      currentForm: 'signUp',
      signInStyle: {},
      signUpStyle: {},
      signInTitleStyle: {
        lineHeight: `150px`
      },
      signUpTitleStyle: {
        lineHeight: `200px`
      }
    }
  },
  computed:{
    ...mapState(['userInfo'])
  },
  methods: {
    ...mapMutations(['setUser']),

    // 注册方法
    doSignUp () {
      // 用户名，密码，邮箱不能为空
      if (_.isEmpty(this.register.username ) || _.isEmpty(this.register.password ) || _.isEmpty(this.register.email )) {
        ElNotification({
            title: 'Warning',
            message: `username/password/Email can't be empty! `,
            type: 'warning',
          })
        return
      }
      // 两次密码必须一致
      if ( !_.isEqual(this.register.password, this.register.confirmPass) ) {
        ElNotification({
            title: 'Warning',
            message: `Passwords do not match !`,
            type: 'warning',
          })
        return
      }
      // 邮箱需要符合正确格式
      let reg = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
      if (!reg.test(this.register.email)) {
        ElNotification({
            title: 'Warning',
            message: `Email is illegal `,
            type: 'warning',
          })
        return
      }
      signUp({
        cLoginId: this.register.username,
        cPassword: this.register.password,
        cEmail: this.register.email
      }).then(res => {
        if (res.code == 200) {
          if (res.data.success) {
            ElNotification({
              title: 'Success',
              message: `${res.data.msg}`,
              type: 'success',
            })
          } else {
            ElNotification({
              title: '警告',
              message: `${res.data.msg}`,
              type: 'warning',
            })
          }
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
    },
    // 登录方法
    doSignIn () {
      if ( _.isEmpty(this.user.username )) {
        ElNotification({
            title: 'Warning',
            message: `username can't be empty! `,
            type: 'warning',
          })
        return
      }
      signIn(this.user).then(res => {
        if (res.code == 200) {
          this.setUser({
            id: res.data.userId,
            loginId: res.data.loginId,
            name: res.data.userName,
            token: res.data.token
          })
          window.localStorage.setItem('userInfo', JSON.stringify({
            id: res.data.userId,
            loginId: res.data.loginId,
            name: res.data.userName,
            token: res.data.token
          }))
          this.$router.push('/')
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
    },

    // 表单切换动画
    focusForm (formName) {

      if (this.currentForm == formName) {
        return
      }

      this.currentForm = formName

      if (formName == 'signIn') {
        this.signInStyle = {
          backgroundColor: `rgba(255, 255, 255, 0.2)`,
          width: `535px`,
          height: `600px`,
          animationName: `flipInY`,
          animationDuration: `1s`
        }
        this.signInTitleStyle = {
          lineHeight: `250px`
        }

        this.signUpStyle = {
          backgroundColor: `rgba(255, 255, 255, 0.1)`,
          width: `335px`,
          height: `400px`,
          animationName: `flipInX`,
          animationDuration: `1s`
        }
        this.signUpTitleStyle = {
          lineHeight: `100px`
        }
      } else if (formName == 'signUp') {
        this.signInStyle = {          
          backgroundColor: `rgba(255, 255, 255, 0.1)`,
          width: `335px`,
          height: `400px`,
          animationName: `flipInX`,
          animationDuration: `1s`
        }
        this.signInTitleStyle = {
          lineHeight: `150px`
        }

        this.signUpStyle = {
          backgroundColor: `rgba(255, 255, 255, 0.2)`,
          width: `535px`,
          height: `600px`,
          animationName: `flipInY`,
          animationDuration: `1s`
        }
        this.signUpTitleStyle = {
          lineHeight: `200px`
        }
      }
    },

  }
}
</script>
<style lang="less" scoped>
.login-container{
  width: 100%;
  height: 100%;
  background-color: #1f1d2b;

  .form-container{
    width: 1000px;
    height: 600px;
    position: absolute;
    top: calc(50% - 300px);
    left: calc(50% - 500px);
    display: flex;
    justify-content: space-between;
    align-items: center;
    .sign-form{
      border-radius: 10px;
      padding: 0px 30px;
      position: relative;
      .el-button{
        position: absolute;
        width: calc(100% - 40px);
        bottom: 10px;
        left: 20px;
      }
      .sign-title{
        color: #fff;
        text-align: center;
        font-size: 30px;
        line-height: 100px;
      }
    }
    .sign-up-form{      
      background-color: rgba(255, 255, 255, 0.2);
      width: 535px;
      height: 600px;
    }
    .sign-in-form{
      background-color: rgba(255, 255, 255, 0.1);
      width: 335px;
      height: 400px;
    }
  }

  .login-sys-logo{
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    text-align: center;
    position: absolute;
    top: 0;
    left: 0;
    img{
      width: 98%;
      opacity: 0.1;
    }
  }

}

/deep/ .el-input__inner{
  background-color: rgba(255, 255, 255, 0.1);
  color: #fff;
  text-align: center;
}
/deep/ .el-input{
  margin-bottom: 20px;
}
/deep/ .el-button--primary {
  width: 100%;
}
</style>
