<template>
  <div>
    <el-dialog title="文字编辑" :visible.sync="textDialogVisible" width="60%" :before-close="handleClose">
      <div class="text-container">
        <el-tabs type="border-card">
          <el-tab-pane label="内容">
            <el-input type="textarea" :rows="10" placeholder="请输入内容" v-model="textarea">
            </el-input>

          </el-tab-pane>
          <el-tab-pane label="样式">样式</el-tab-pane>
          <div class="text-submit-btn">
             <el-button type="primary">确认</el-button>
          </div>
        </el-tabs>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      textDialogVisible: true,
      textarea: ''
    }
  },
  methods: {
    handleClose() {
      this.$emit('closeTextDialog')
    },
    handleSure() {
      this.$emit('closeTextDialog')
    }
  }
}
</script>

<style lang="less" scoped>
.text-submit-btn {
  display: flex;
  justify-content: center;
  margin-top: 12px;
}
</style>

