<template>
  <div class="login-container">
    <el-input v-model="user.username"></el-input>
    <el-input v-model="user.password"></el-input>
    <el-button type="primary" @click="login">login</el-button>
  </div>
</template>
<script>
export default {
  data () {
    return {
      user: {
        username: 'admin',
        password: '123'
      }
    }
  },
  methods: {
    login () {
      
    }
  }
}
</script>