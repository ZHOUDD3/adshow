<template>
	<div>
		<div class="title">节目管理</div>
          <div class="menu-box">
            <el-form :model="releaseForm" :rules="rules" ref="releaseForm">
              <div class="label">节目名称</div>
              <el-form-item label="" prop="name">
                <el-input v-model="releaseForm.name" size="mini"></el-input>
              </el-form-item>
              <div class="label">节目时长</div>
              <div class="item-box">
                <div class="time">
                  <el-form-item label="" prop="time">
                    <el-input v-model="releaseForm.time" size="mini"></el-input>
                  </el-form-item>
                  <span>秒</span>
                </div>
                <div class="rate">
                  <span>分辨率</span>
                  <el-select size="mini" v-model="releaseForm.rate">
                    <el-option v-for="(item, index) in rateArr" :key="index" :label="item" :value="item">

                    </el-option>
                  </el-select>
                </div>
              </div>
              <div class="label">备注</div>
              <el-form-item>
                <el-input
                  type="textarea"
                  :rows="2"
                  placeholder="请输入内容"
                  v-model="releaseForm.remark">
                </el-input>
              </el-form-item>
              <div class="label">节目周期</div>
              <el-form-item prop="dateRegion">
                <el-date-picker
                  v-model="releaseForm.dateRegion"
                  type="daterange"
                  range-separator="至"
                  start-placeholder="开始日期"
                  end-placeholder="结束日期">
                </el-date-picker>
              </el-form-item>
              <div class="label">投放设备</div>
              <el-form-item prop="device">
                <el-checkbox-group v-model="releaseForm.device">
                  <el-checkbox label="设备A"></el-checkbox>
                  <el-checkbox label="设备B"></el-checkbox>
                  <el-checkbox label="设备C"></el-checkbox>
                </el-checkbox-group>
              </el-form-item>
            </el-form>
          </div>
          <div class="btn-box">
            <el-button type="warning" @click="closePreview">返回</el-button>
            <el-button type="primary" @click="releaseProgram">发布</el-button>
          </div>
	</div>
</template>

<script>
	export default {
		data () {
			let checkDevice = (rule, value, callback) => {
	      if (value.length === 0) {
	        callback(new Error('请选择投放设备'))
	      } else {
	        callback()
	      }
	    }
	    return {
	    	releaseForm: {
	        name: '',
	        time: 30,
	        remark: '',
	        dateRegion: '',
	        device: [],
	        rate: '1920x1080'
	      },
	      rules: {
	        name: [
	          {required: true, message: '不能为空'}
	        ],
	        time: [
	          {required: true, message: '不能为空'}
	        ],
	        dateRegion: [
	          {required: true, message: '不能为空'}
	        ],
	        device: [
	          {validator: checkDevice}
	        ]
	      }
	    }
		},
		methods: {
			closePreview() {
	      this.$emit('closePreview')
	    },
	    releaseProgram () {
	      this.$refs.releaseForm.validate(valid => {
	        if (valid) {
	           let panelWidth = this.$refs.preview.clientWidth
	            let panelHeight = this.$refs.preview.clientHeight

	            // 传百分数到后端
	            let videoArr = JSON.parse(JSON.stringify(this.videoArr))
	            let imageArr = JSON.parse(JSON.stringify(this.imageArr))
	            let txtArr = JSON.parse(JSON.stringify(this.txtArr))
	            let marqueeArr = JSON.parse(JSON.stringify(this.marqueeArr))
	            let slideArr = JSON.parse(JSON.stringify(this.slideArr))

	            videoArr.forEach(item => {
	              item.positionX = parseInt(item.positionX / panelWidth * 10000) / 10000
	              item.positionY = parseInt(item.positionY / panelHeight * 10000) / 10000
	              item.width = parseInt(item.width / panelWidth * 10000) / 10000
	              item.height = parseInt(item.height / panelHeight * 10000) / 10000
	            })
	            imageArr.forEach(item => {
	              item.positionX = parseInt(item.positionX / panelWidth * 10000) / 10000
	              item.positionY = parseInt(item.positionY / panelHeight * 10000) / 10000
	              item.width = parseInt(item.width / panelWidth * 10000) / 10000
	              item.height = parseInt(item.height / panelHeight * 10000) / 10000
	            })
	            txtArr.forEach(item => {
	              item.positionX = parseInt(item.positionX / panelWidth * 10000) / 10000
	              item.positionY = parseInt(item.positionY / panelHeight * 10000) / 10000
	              item.width = parseInt(item.width / panelWidth * 10000) / 10000
	              item.height = parseInt(item.height / panelHeight * 10000) / 10000
	              item.type = 0
	            })
	            marqueeArr.forEach(item => {
	              item.type = 1
	              item.positionX = parseInt(item.positionX / panelWidth * 10000) / 10000
	              item.positionY = parseInt(item.positionY / panelHeight * 10000) / 10000
	              item.width = parseInt(item.width / panelWidth * 10000) / 10000
	              item.height = parseInt(item.height / panelHeight * 10000) / 10000
	            })
	            slideArr.forEach(item => {
	              item.positionX = parseInt(item.positionX / panelWidth * 10000) / 10000
	              item.positionY = parseInt(item.positionY / panelHeight * 10000) / 10000
	              item.width = parseInt(item.width / panelWidth * 10000) / 10000
	              item.height = parseInt(item.height / panelHeight * 10000) / 10000
	              let nameArr = []
	              let idArr = []
	              item.images.forEach(item => {
	                nameArr.push(item.name)
	                idArr.push(item.id)
	              })
	              item.materialId = idArr.join(',')
	              item.materialName = nameArr.join(',')
	            })
	            let playIds = []
	            this.releaseForm.device.forEach(item => {
	              playIds.push({
	                'id': item,
	                'name': item
	              })
	            })
	          // 发布节目
	          createProject({
	            "dateShow": this.dateArr.length > 0 ? 1 : 0,
	            "materials": videoArr.concat(imageArr).concat(slideArr).concat(this.musicArr),
	            "subtitles": txtArr.concat(marqueeArr),
	            "musicIds": "",
	            "name": this.releaseForm.name,
	            "playIds": playIds,
	            "previewImage": "",
	            "programDescription": this.releaseForm.remark,
	            "programDuration": this.releaseForm.time,
	            "programId": "",
	            "resolution": this.releaseForm.rate,
	            "templateImage": 123,
	            "textIds": "",
	            "type": 0,
	            "videoIds": "",
	            "weather": ""
	          }).then(res => {
	            if (res.data.success) {
	              this.$message({
	                type: 'success',
	                message: '节目发布成功'
	              })
	            } else {
	              this.$message({
	                type: 'error',
	                message: res.data.message
	              })
	            }
	          })
	        }
	      })
	    },
		}
	}
</script>

<style>
.release-menu {
  width: 320rem/@base;
  height: 100%;
  background: #fff;
  display: flex;
  flex-direction: column;
  .title {
    display: flex;
    height: 40rem/@base;
    align-items: center;
    background: #e0e0e0;
    font-size: 16rem/@base;
    font-weight: bold;
  }
  .menu-box {
    flex: 1;
    padding: 30rem/@base;
    .label {
      padding: 6rem/@base 0;
    }
    .item-box {
      display: flex;
      margin-bottom: 18px;
      .time {
        display: flex;
        align-items: center;
        span {
          margin-right: 30px;
          padding-left: 10px;
        }
      }
      .rate {
        display: flex;
        align-items: center;
        span {
          display: inline-block;
          width: 80px;
        }
      }
    }
  }
  .btn-box {
    height: 40rem/@base;
    padding: 10rem/@base 30rem/@base;
    display: flex;
  }
}
</style>