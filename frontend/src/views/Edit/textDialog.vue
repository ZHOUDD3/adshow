<template>
  <div>
    <el-dialog title="文字编辑" :visible.sync="textDialogVisible" width="60%" :before-close="handleClose">
      <div class="text-container">
        <el-tabs type="border-card">
          <el-tab-pane label="内容">
            <el-input type="textarea" :rows="10" placeholder="请输入内容" v-model="textarea">
            </el-input>

          </el-tab-pane>
          <el-tab-pane label="样式">
            <div>
              <el-form ref="styleForm" label-width="80px" :model="form">
                <el-form-item label="字体大小">
                  <el-select v-model="form.fontSize">
                    <el-option v-for="(item, index) in fontSizeArr" :label="item" :key="item" :value="item">
                      
                    </el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="字体颜色">
                  <el-color-picker v-model="form.color"></el-color-picker>
                </el-form-item>
              </el-form>
            </div>
          </el-tab-pane>
          <div class="text-submit-btn">
             <el-button type="primary" @click="handleSure">确认</el-button>
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
      textarea: '',
      form: {
        fontSize: '16',
        color: '#000'
      },
      fontSizeArr: [12, 14, 16, 18, 20, 24, 30, 36, 48]
    }
  },
  props: {
    content: {
      type: String,
      default: ''
    },
    textStyle: {
      type: Object
    },
    textType: {
      type: String,
      default: 'text'
    }
  },
  methods: {
    handleClose() {
       let textInfo = {

      }
      this.$emit('closeTextDialog', textInfo)
    },
    handleSure() {
      let textInfo = {
        content: this.textarea,
        fontSize: this.form.fontSize,
        color: this.form.color
      }
      this.$emit('closeTextDialog', textInfo)
    }
  },
  mounted () {
    if (this.content) {
      this.textarea = this.content
    }

    if (this.textStyle) {
      this.form.fontSize = this.textStyle.fontSize
      this.form.color = this.textStyle.color
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

