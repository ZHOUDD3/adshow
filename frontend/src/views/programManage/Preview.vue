<template>
    <!--预览界面-->
    <div class="preview-wrap">
        <div ref="preview" class="preview-dialog">
            <!--文本框区域-->
            <Deformation 
              v-for="(item, index) in txtArr" 
              :key="index" 
              :w="item.width" 
              :h="item.height" 
              :x="item.left" 
              :y="item.top" 
              :z="item.zIndex" 
              :parent="true" 
              :draggable="false" 
              v-show="item.visible" 
              @resizestop="onResizstop(arguments, item)" 
              @dragstop="onDragstop($event, item)" 
              @dragDblclick="editText(item, index)">
                <p :readonly="true" :style="{
									fontSize: item.fontSize + 'px',
									color: item.color,
                  textAlign: item.align
								}">
                    {{item.content}}
                </p>
            </Deformation>
            <!--日历区域-->
            <Deformation v-for="(item, index) in dateArr" :key="`date${index}`" :w="item.width" :h="item.height" :x="item.left" :y="item.top" :z="1" :draggable="false" v-show="item.visible" :parent="true" @dragDblclick="editDate(item)">
                <p>{{item.content}}</p>
            </Deformation>
            <!--图片区域-->
            <Deformation 
              v-for="(item, index) in imageArr" 
              :key="`image${index}`" 
              :w="item.width" 
              :h="item.height" 
              :x="item.left" 
              :y="item.top"
              :z="item.zIndex" 
              :draggable="false" 
              v-show="item.visible" 
              :parent="true">
                <img :src="item.src" alt="" width="100%" height="100%">
            </Deformation>
            <!--视频区域-->
            <Deformation
              v-for="(item, index) in videoArr"
              :key="`video${index}`"
              :w="item.width"
              :h="item.height"
              :x="item.left"
              :y="item.top"
              :z="item.zIndex"
              :draggable="false">
              <video-player
                class="video-player-box"
                ref="videoPlayer"
                v-if="videoArr.length > 0"
                :options="playerOptions">
              </video-player>
            </Deformation>
            <!--滚动文字-->
            <Deformation 
              v-for="(item, index) in marqueeArr" 
              :key="`marquee${index}`"
              :w="item.width" 
              :h="item.height" 
              :x="item.left" 
              :y="item.top" 
              :z="item.zIndex" 
              :draggable="false">
              <marquee-text 
                :content="item.content"
                :color="item.color">
              </marquee-text>
            </Deformation>
            <audio ref="audio"></audio>
        </div>
        <div class="release-menu">
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
    </div>
</template>
<script>
import Deformation from '@/components/deformation'
import VideoPlay from '../Video/Play'
import MarqueeText from '../Edit/marqueeDialog'
import { videoPlayer } from 'vue-video-player'
import {
    createProject
} from '@/service'
export default {
  data() {
    let checkDevice = (rule, value, callback) => {
      if (value.length === 0) {
        callback(new Error('请选择投放设备'))
      } else {
        callback()
      }
    }
    return {
      txtArr: [],
      dateArr: [],
      imageArr: [],
      videoArr: [],
      marqueeArr: [],
      videoId: '',
      videoName: '',
      playerOptions: {
       autoplay: true,
       width: 1280,
       height: 720,
       sources: [
      ]
      },
      releaseForm: {
        name: '',
        time: '',
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
      },
      rateArr: ['1920x1080']
    }
  },
  components: {
    Deformation,
    MarqueeText,
    'video-player': videoPlayer
  },
  props: {
    componentArr: {
      type: Array
    }
  },
  methods: {
    closePreview() {
      this.$emit('closePreview')
    },
    releaseProgram () {
      this.$refs.releaseForm.validate(valid => {
        if (valid) {
          // 发布节目
          createProject({
            "dateShow": this.dateArr.length > 0 ? 1 : 0,
            "materials": this.componentArr,
            "musicIds": "可以先不传",
            "name": this.releaseForm.name,
            "playIds": this.releaseForm.device,
            "previewImage": "不填",
            "programDescription": this.releaseForm.remark,
            "programDuration": this.releaseForm.time,
            "programId": "",
            "resolution": this.releaseForm.rate,
            "templateImage": 123,
            "textIds": "1123",
            "type": 0,
            "videoIds": "101",
            "weather": "1024"
          }).then(res => {
            if (res.data.success) {
              this.$message({
                type: 'success',
                message: '节目发布成功'
              })
            }
          })
        }
      })
    }
  },
  mounted() {
    let _this = this
    this.$nextTick(() => {
      // 重新计算素材位置和大小
      let previewWidth = this.$refs.preview.clientWidth
      let previewHeight = this.$refs.preview.clientHeight
      this.meterialArr = JSON.parse(JSON.stringify(this.componentArr))
      this.meterialArr.forEach(item => {
        item.left = item.left * previewWidth
        item.width = item.width * previewWidth
        item.top = item.top * previewHeight
        item.height = item.height * previewHeight
      })
      this.txtArr = this.meterialArr.filter(item => {
        return item.type === 'text'
      })
      this.dateArr = this.meterialArr.filter(item => {
        return item.type === 'date'
      })
      this.imageArr = this.meterialArr.filter(item => {
        return item.type === 'picture'
      })
      this.videoArr = this.meterialArr.filter(item => {
        return item.type === 'video'
      })
      this.marqueeArr = this.meterialArr.filter(item => {
        return item.type === 'marquee'
      })
      this.playerOptions.width = this.videoArr[0].width
      this.playerOptions.height = this.videoArr[0].height
      this.videoArr.forEach(item => {
        _this.playerOptions.sources.push({
          src: process.env.BASE_API + 'VIDEO/' + item.id + '/' + item.name,
          type: 'video/' + item.name.split('.')[1]
        })
      })

    })
  }
}
</script>
<style lang="less" scoped>
@base: 192;
.preview-wrap {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  padding: 3%;
  display: flex;
  align-items: center;
  background: rgba(0, 0, 0, 0.6);
  z-index: 1000;
  .preview-dialog {
    flex: 1;
    position: relative;
    height: 100%;
    background: #fff;
    border: 2px solid #000;
    border-radius: 4px;
    .video-player-box {
      position: absolute;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
    }
    .video-js {
      background: transparent;
      .vjs-control-bar {
        display: none;
      }
    }
  }
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
}
</style>
