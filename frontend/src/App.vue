<template>
  <div id="app">
    <router-view :hellomsg="msg"></router-view>
  </div>
</template>

<script>

export default {
  name: 'app',
  data () {
    return {
      msg: 'Welcome to your Vue.js powered Spring Boot App'
    }
  }
}
</script>

<style lang="less">
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
.modify-container {
  .el-dialog__header {
    padding: 6px 10px 6px;
    background: #d1d3d9;
  }
  .el-dialog__headerbtn {
    top: 10px;
    right: 10px;
  }
  .el-dialog__body {
    padding: 0 0;
  }
}
</style>
