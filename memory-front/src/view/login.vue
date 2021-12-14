<template>
  <div class="login-container">
    <el-input v-model="user.username"></el-input>
    <el-input v-model="user.password"></el-input>
    <el-button type="primary" @click="doLogin">login</el-button>
  </div>
</template>
<script>
import { login } from '@/api/userApi.js'
import {mapMutations, mapState} from "vuex"
import { ElNotification } from 'element-plus'
export default {
  data () {
    return {
      user: {
        username: 'admin',
        password: '123'
      }
    }
  },
  computed:{
    ...mapState(['userInfo'])
  },
  methods: {
    ...mapMutations(['setUser']),
    doLogin () {
      login(this.user).then(res => {
        if (res.code == 200) {
          this.setUser({
            id: res.data.userId,
            loginId: res.data.loginId,
            name: res.data.userName,
            token: res.data.token
          })
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
    }
  }
}
</script>