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
              :x="item.positionX"
              :y="item.positionY"
              :z="item.materialOder"
              :parent="true"
              :draggable="false"
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
              :x="item.positionX"
              :y="item.positionY"
              :z="item.materialOder"
              :draggable="false"
              :parent="true">
                <img :src="item.src" alt="" width="100%" height="100%">
            </Deformation>
            <!--视频区域-->
            <Deformation
              v-for="(item, index) in videoArr"
              :key="`video${index}`"
              :w="item.width"
              :h="item.height"
              :x="item.positionX"
              :y="item.positionY"
              :z="item.materialOder"
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
              :x="item.positionX"
              :y="item.positionY"
              :z="item.materialOder"
              :draggable="false">
              <marquee-text
                :content="item.content"
                :color="item.color">
              </marquee-text>
            </Deformation>
            <!--轮播图-->
             <Deformation
              v-for="(item, index) in slideArr"
              :key="`slide${index}`"
              :w="item.width"
              :h="item.height"
              :x="item.positionX"
              :y="item.positionY"
              :z="item.materialOder"
              :draggable="false">
              <swiper  :options="item.swiperOption">
                <swiper-slide v-for="(image, index) in item.images">
                  <div class="swipe-item">
                    <img :src="GLOBAL.DOMAIN + 'PICTURE/' + image.id + '/' + image.name" alt="">
                  </div>
                </swiper-slide>
                <div class="swiper-pagination swiper-pagination-bullets" slot="pagination"></div>
              </swiper>
             </Deformation>
            <audio ref="audio" :src="musicSrc" autoplay="true" loop="true"></audio>
            <div class="close" @click="closePreview"></div>
        </div>
        <!-- <div class="release-menu">
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
        </div> -->
    </div>
</template>
<script>
import Deformation from '@/components/deformation'
import VideoPlay from '../Video/Play'
import MarqueeText from '../Edit/marqueeDialog'
import { videoPlayer } from 'vue-video-player'
import {
    createProject,
    previewProgram
} from '@/service'
import 'swiper/dist/css/swiper.css'
import { swiper, swiperSlide } from 'vue-awesome-swiper'
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
      slideArr: [],
      musicArr: [],
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
      },
      rateArr: ['1920x1080'],
      swiperOption: {
        autoplay: {
          delay: 2500,
          disableOnInteraction: false
        },
        pagination: {
          el: '.swiper-pagination',
          clickable: true,
          renderBullet(index, className) {
            return `<span class="${className} swiper-pagination-bullet-custom">${index + 1}</span>`
          }
        },
        cubeEffect: {
          shadow: true,
          slideShadows: true,
          shadowOffset: 20,
          shadowScale: 0.94
        }
      },
      musicSrc: ''
    }
  },
  components: {
    swiper,
    swiperSlide,
    Deformation,
    MarqueeText,
    'video-player': videoPlayer
  },
  props: {
    componentArr: {
      type: Array
    },
    panelWidth: {
      type: Number
    },
    panelHeight: {
      type: Number
    },
    programId: {
      type: String,
      default: ''
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
            "programId": this.programId,
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
    getProgramById (id) {
      previewProgram({
        programId: id
      }).then(res => {
        if (res.data.success) {
          // 整理節目素材
          let previewWidth = this.$refs.preview.clientWidth
          let previewHeight = this.$refs.preview.clientHeight
          let materials = res.data.data.materials
          materials.forEach(item => {
            item.positionX = item.positionX * previewWidth
            item.width = item.width * previewWidth
            item.positionY = item.positionY * previewHeight
            item.height = item.height * previewHeight
          })
         /* this.dateArr = this.meterialArr.filter(item => {
            return item.type === 'date'
          })*/
          this.imageArr = materials.filter(item => {
            return item.type === 'PICTURE'
          })
          // 拼接图片路径
          this.imageArr.forEach(item => {
            item.src = process.env.BASE_API + 'PICTURE/' + item.materialId + '/' + item.materialName
          })
          this.videoArr = materials.filter(item => {
            return item.type === 'VIDEO'
          })
          this.musicArr = materials.filter(item => {
            return item.type === 'MUSIC'
          })
          if (this.musicArr && this.musicArr.length > 0) {
            this.musicSrc = process.env.BASE_API + 'MUSIC/' + this.musicArr[0].materialId + '/' + this.musicArr[0].materialName
          }
          // 拼接视频路径
          if (this.videoArr.length > 0) {
            this.releaseForm.time = this.videoArr[0].materialInterval
            this.playerOptions.width = this.videoArr[0].width
            this.playerOptions.height = this.videoArr[0].height
            this.playerOptions.muted = this.videoArr[0].mute
            this.videoArr.forEach(item => {
              if (item.timeLength > this.releaseForm.time) {
                this.releaseForm.time = item.materialInterval
              }
              this.playerOptions.sources.push({
                src: process.env.BASE_API + 'VIDEO/' + item.materialId + '/' + item.materialName,
                type: 'video/' + item.materialName.split('.')[1]
              })
            })
          }
          this.slideArr = materials.filter(item => {
            return item.type === 'LOOPIMGS'
          })
          this.slideArr.forEach(item => {
            let nameArr = item.materialName.split(',')
            let idArr = item.materialId.split(',')
            let images = []
            nameArr.forEach((image, index) => {
              images.push({
                id: idArr[index],
                name: nameArr[index]
              })
            })
            item.images = images
            item.swiperOption = this.swiperOption
          })
          let subtitles = res.data.data.subtitles
          subtitles.forEach(item => {
            item.positionX = item.positionX * previewWidth
            item.width = item.width * previewWidth
            item.positionY = item.positionY * previewHeight
            item.height = item.height * previewHeight
          })
          this.marqueeArr = subtitles.filter(item => {
            return item.type == 1
          })
          this.txtArr = subtitles.filter(item => {
            return item.type == 0
          })
        } else {
          this.$message({
            type: 'error',
            message: res.data.message
          })
        }
      })
    }
  },
  mounted() {
    this.getProgramById(this.programId)
    let _this = this
   /* this.$nextTick(() => {
      // 重新计算素材位置和大小
      let previewWidth = this.$refs.preview.clientWidth
      let previewHeight = this.$refs.preview.clientHeight
      let widthRate = previewWidth / this.panelWidth
      let heightRate = previewHeight / this.panelHeight
      this.meterialArr = JSON.parse(JSON.stringify(this.componentArr))
      this.meterialArr.forEach(item => {
        item.positionX = item.positionX * widthRate
        item.width = item.width * widthRate
        item.positionY = item.positionY * heightRate
        item.height = item.height * heightRate
      })
      this.txtArr = this.meterialArr.filter(item => {
        return item.type === 'text'
      })
      this.dateArr = this.meterialArr.filter(item => {
        return item.type === 'date'
      })
      this.imageArr = this.meterialArr.filter(item => {
        return item.type === 'PICTURE'
      })
      this.videoArr = this.meterialArr.filter(item => {
        return item.type === 'VIDEO'
      })
      this.marqueeArr = this.meterialArr.filter(item => {
        return item.type === 'marquee'
      })
      this.slideArr = this.meterialArr.filter(item => {
        return item.type === 'LOOPIMGS'
      })
      this.slideArr.forEach(item => {
        item.swiperOption =  {
          loop: true,
          autoplay: {
            delay: item.loop_time * 1000,
            disableOnInteraction: false
          },
          pagination: {
            el: '.swiper-pagination',
            clickable: false,
            renderBullet(index, className) {
              return `<span class="${className} swiper-pagination-bullet-custom">${index + 1}</span>`
            }
          }
        }
      })
      if (this.videoArr.length > 0) {
        this.playerOptions.width = this.videoArr[0].width
        this.playerOptions.height = this.videoArr[0].height
        this.playerOptions.muted = this.videoArr[0].mute
        this.videoArr.forEach(item => {
          _this.playerOptions.sources.push({
            src: process.env.BASE_API + 'VIDEO/' + item.materialId + '/' + item.materialName,
            type: 'video/' + item.materialName.split('.')[1]
          })
        })
      }
    })*/
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
  .close {
    position: absolute;
    top: 0;
    right: 0;
    width: 32px;
    height: 32px;
    background: url('../../assets/image/close_black.png');
    z-index: 10000;
  }
}
</style>
