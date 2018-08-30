<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>

export default {
  name: 'app',
  data () {
    return {
      msg: ''
    }
  }
}
</script>

<style lang="less">
html, body {
  height: 100%;
}
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  height: 100%;
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
