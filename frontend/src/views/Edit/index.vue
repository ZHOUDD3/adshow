<template>
    <div class="page-container">
        <div class="edit-container">
            <div class="menu">
                <div class="menu-box">
                  <div class="menu-item" v-for="(item, index) in menuList" @click="addItem(index)" :key=index>
                      <img :src="item.icon" alt="">
                      <span>{{item.title}}</span>
                  </div>
                </div>
                <div class="menu-btn">
                  <span @click="previewProgram">预览与发布</span>
                  <span @click="saveProgram">保存</span>
                  <span class="exit" @click="exit">退出</span>
                </div>
            </div>
            <div class="main">
                <div class="title">
                </div>
                <div class="content">
                  <div class="program-panel" ref="programPanel">
                    <!--文本框区域-->
                    <Deformation 
                      v-for="(item, index) in txtArr" 
                      :key="`text${index}`" 
                      :w="item.width" 
                      :h="item.height" 
                      :x="item.left" 
                      :y="item.top"
                      :z="10" 
                      :parent="true" 
                      :draggable="item.status === 'unlock'" 
                      v-show="item.visible" 
                      @resizestop="onResizstop(arguments, item)" 
                      @dragstop="onDragstop($event, item)" 
                      @dragDblclick="editText(item, index, 'text')">
                      <p :readonly="true" :style="{
                          fontSize: item.fontSize + 'px',
                          color: item.color
                        }">
                          {{item.content}}
                        </p>
                    </Deformation>
                    <!--滚动文字框区域-->
                    <Deformation 
                      v-for="(item, index) in marqueeArr" 
                      :key="`marquee${index}`" 
                      :w="item.width" 
                      :h="item.height" 
                      :x="item.left" 
                      :y="item.top"
                      :z="10" 
                      :parent="true" 
                      :draggable="item.status === 'unlock'" 
                      v-show="item.visible" 
                      @resizestop="onResizstop(arguments, item)" 
                      @dragstop="onDragstop($event, item)" 
                      @dragDblclick="editText(item, index, 'marquee')">
                      <p :readonly="true" :style="{
                          fontSize: item.fontSize + 'px',
                          color: item.color
                        }">
                          {{item.content}}
                        </p>
                    </Deformation>
                    <!--日历区域-->
                    <Deformation 
                      v-for="(item, index) in dateArr" 
                      :key="`date${index}`" 
                      :w="item.width" 
                      :h="item.height" 
                      :x="item.left" 
                      :y="item.top"
                      :z="10" 
                      :draggable="item.status === 'unlock'" 
                      v-show="item.visible" 
                      :parent="true"
                      @resizestop="onResizstop(arguments, item)" 
                      @dragstop="onDragstop($event, item)" 
                      @dragDblclick="editDate(item)">
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
                      :z="1" 
                      :draggable="item.status === 'unlock'" 
                      v-show="item.visible"
                      @resizestop="onResizstop(arguments, item)" 
                      @dragstop="onDragstop($event, item)" 
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
                      :parent="true"
                      @resizestop="onResizstop(arguments, item)" 
                      @dragstop="onDragstop($event, item)">
                      <img :src="item.thumb" alt="" width="100%" height="100%">
                      <i class="video-icon"></i>
                    </Deformation>
                  </div>
                </div>
            </div>
        </div>
        <div class="overlay" v-if="showDialogFlag">
            <insert-video 
              v-if="showInsertVideo"
              @insertVideo="insertVideo"
              @closeInsertVideo="closeDialog('video')">
            </insert-video>
            <!--上传素材Dialog-->
            <meterial-list
              v-if="showMeterialDialog"
              @closeMeterialListDialog="closeDialog('picture')"
              @addImage="addImage"
              title="插入图片">
            </meterial-list>
            <!--上传音乐Dialog-->
            <music-list
              v-if="showMusicDialog"
              @closeMusicListDialog="closeDialog('music')"
              @addMusic="addMusic"
              title="背景音乐">
            </music-list>
        </div>
        <text-dialog 
          v-if="textDialogVisible"
          :content="currentText"
          :type="textType"
          :textStyle="currentTextStyle"
          @closeTextDialog="justifyText">
        </text-dialog>
        <preview-dialog 
          v-if="dialogVisible"
          ref="preview"
          :panelWidth="panelWidth"
          :panelHeight="panelHeight"
          :componentArr="componentArr"
          @closePreview="dialogVisible=false">
        </preview-dialog>
</div>
</template>

<script>
import InsertVideo from '../Video/Index.vue'
import TextDialog from '../Edit/textDialog.vue'
import MeterialList from './MeterialList'
import MusicList from './MusicList'
import Deformation from '@/components/deformation'
import SpaceTime from 'spacetime'
import Preview from  './preview'
import {
    createProject
} from '@/service'
export default {
  data() {
    return {
      menuList: [
        {
          icon: require('../../assets/image/vid.png'),
          title: '视频插入',
          route: '/insertVideo'
        },
        {
          icon: require('../../assets/image/img_icon.png'),
          title: '插入图片'
        },
        {
          icon: require('../../assets/image/music.png'),
          title: '背景音乐'
        },
        {
          icon: require('../../assets/image/text.png'),
          title: '插入文字'
        },
        {
          icon: require('../../assets/image/calendar.png'),
          title: '日期插入'
        },
        {
          icon: require('../../assets/image/mar_text.png'),
          title: '滚动文字'
        }
      ],
      showDialogFlag: false,
      showInsertVideo: false,
      showMeterialDialog: false,
      showMusicDialog: false,
      textDialogVisible: false,
      txtArr: [],
      dateArr: [],
      videoArr: [],
      imageArr: [],
      marqueeArr: [],
      componentArr: [],
      // 上传素材
      meterialTitle: '',
      currentModifyIndex: '',
      currentText: '',
      currentTextStyle: null,
      zoomRate: 100,
      dialogVisible: false,
      panelWidth: 1920,
      panelHeight: 1080
    }
  },
  components: {
    'insert-video': InsertVideo,
    'text-dialog': TextDialog,
    'meterial-list': MeterialList,
    'music-list': MusicList,
    'preview-dialog': Preview,
    Deformation
  },
  methods: {
    closeDialog(type) {
      this.showDialogFlag = false
      switch (type) {
        case 'video':
          this.showInsertVideo = false
          break
        case 'picture':
          this.showMeterialDialog = false
          break
        case 'music':
          this.showMusicDialog = false
          break
        default:

          break
      }
    },
    insertVideo (data) {
         // 保存节目
      data.forEach(item => {
        this.componentArr.push({
          type: 'video',
          status: 'unlock',
          visible: true,
          left: 0,
          top: 0,
          width: 400,
          height: 300,
          id: item.id,
          name: item.name,
          createTime: item.createTime,
          createUser: item.createUser,
          materialInterval: item.timeLength
        })
      })
      this.videoArr = this.componentArr.filter(item => {
        return item.type === 'video'
      })
      this.showDialogFlag = false
      this.showInsertVideo = false
      console.log('video arr', this.videoArr)
    },
    insertImage (data) {
      this.imageArr = data
      this.showDialogFlag = false
      this.showInsertVideo = false
    },
    addItem(index) {
      switch (index) {
        case 0: // insert video
          this.showDialogFlag = true
          this.showInsertVideo = true
          break
        case 1: // insert image
          this.showDialogFlag = true
          this.showMeterialDialog = true
          break
        case 2: // insert music
        this.showDialogFlag = true
          this.showMusicDialog = true
          break
        case 3: // isert text
          this.addText()
          break
        case 4: // insert Date
          this.addDate()
          break
        case 5: // insert marqueen
          this.addMarquee()
          break
      }
    },
    addText() {
      this.componentArr.push({
        type: 'text',
        content: '请输入文本',
        status: 'unlock',
        visible: true,
        left: 0,
        top: 0,
        width: 200,
        height: 60,
        fontSize: 16,
        color: '#000'
      })
      this.txtArr = this.componentArr.filter(item => {
        return item.type === 'text'
      })
    },
    justifyText (text) {
      if (this.textType === 'text') {
        this.txtArr[this.currentModifyIndex].content = text.content
        this.txtArr[this.currentModifyIndex].fontSize = text.fontSize
        this.txtArr[this.currentModifyIndex].color = text.color
      } else {
        this.marqueeArr[this.currentModifyIndex].content = text.content
        this.marqueeArr[this.currentModifyIndex].fontSize = text.fontSize
        this.marqueeArr[this.currentModifyIndex].color = text.color
      }
      this.textDialogVisible = false
    },
    addDate() {
      let date = SpaceTime().format('yyyy/MM/dd hh:mm:ss')
      this.componentArr.push({
        type: 'date',
        content: date,
        status: 'unlock',
        visible: true,
        left: 100,
        top: 100,
        width: 200,
        height: 60
      })
      this.dateArr = this.componentArr.filter(item => {
        return item.type === 'date'
      })
    },
    addMarquee () {
      this.componentArr.push({
        type: 'marquee',
        content: '这里是滚动文字这里是滚动文字滚动文字',
        status: 'unlock',
        visible: true,
        left: 100,
        top: 100,
        width: 200,
        height: 60,
        fontSize: 16,
        color: '#000'
      })
      this.marqueeArr = this.componentArr.filter(item => {
        return item.type === 'marquee'
      })
    },
    editText (item, index, type) {
      this.textType = type
      this.currentModifyIndex = index
      this.currentText =item.content
      this.currentTextStyle = {
        fontSize: item.fontSize,
        color: item.color
      }
      this.textDialogVisible = true
    },
    editDate (item) {

    },
    addImage (arr) {
      arr.forEach(item => {
        this.componentArr.push({
          type: 'picture',
          src: process.env.BASE_API + 'PICTURE/' + item.id + '/' + item.name,
          visible: true,
          status: 'unlock',
          left: 150,
          top: 150,
          width: 400,
          height: 400
        })
      })
      this.imageArr = this.componentArr.filter(item => {
        return item.type === 'picture'
      })
    },
    addMusic () {

    },
    onResizstop () {
      const [x, y, w, h] = arguments[0]
      let item = arguments[1]
      item.left = x
      item.top = y
      item.width = w
      item.height = h
    },
    onDragstop (event, item) {
      item.left = event[0]
      item.top = event[1]
    },
    saveProgram () {
      let panelWidth = this.$refs.programPanel.clientWidth
      let panelHeight = this.$refs.programPanel.clientHeight

      // 传百分数到后端
      let videoArr = JSON.parse(JSON.stringify(this.videoArr))
      let imageArr = JSON.parse(JSON.stringify(this.imageArr))
      let txtArr = JSON.parse(JSON.stringify(this.txtArr))

      videoArr.forEach(item => {
        item.left = item.left / panelWidth
        item.top = item.top / panelHeight
        item.width = item.width / panelWidth
        item.height = item.height / panelHeight
      })
      imageArr.forEach(item => {
        item.left = item.left / panelWidth
        item.top = item.top / panelHeight
        item.width = item.width / panelWidth
        item.height = item.height / panelHeight
      })
      txtArr.forEach(item => {
        item.left = item.left / panelWidth
        item.top = item.top / panelHeight
        item.width = item.width / panelWidth
        item.height = item.height / panelHeight
      })
      createProject({
        "dateShow": this.dateArr.length > 0 ? 1 : 0,
        "materials": videoArr.concat(imageArr).concat(txtArr),
        "musicIds": "可以先不传",
        "name": "节目名称",
        "playIds": [
          "设备1","设备2"
        ],
        "previewImage": "不填",
        "programDescription": "节目描述",
        "programDuration": 3000,
        "programId": "11234",
        "resolution": "1080*720",
        "templateImage": 123,
        "textIds": "1123",
        "type": 0,
        "videoIds": "101",
        "weather": "1024"
      }).then(res => {
        
      })
    },
    exit () {
      // 退出编辑节目
    },
    previewProgram () {
      // 预览节目
      this.panelWidth = this.$refs.programPanel.clientWidth
      this.panelHeight = this.$refs.programPanel.clientHeight
      this.dialogVisible = true
    },
    zoomIn () {
      if (this.zoomRate > 50) {
        this.zoomRate -= 10
      }
      this.panelWidth = 1920 * this.zoomRate / 100
      this.panelHeight = 1080 * this.zoomRate / 100
    },
    zoomOut () {
       if (this.zoomRate < 200) {
        this.zoomRate += 10
      }
      this.panelWidth = 1920 * this.zoomRate / 100
      this.panelHeight = 1080 * this.zoomRate / 100
    },
    handleClose () {

    }
  },
  mounted () {
  }
}
</script>
<style lang="less" scoped>
.page-container {
  position: relative;
  height: 100%;
  .edit-container {
    height: 100%;
    display: flex;
    .menu {
      width: 140px;
      display: flex;
      flex-direction: column;
      justify-content: space-between;
      align-items: center;
      background: #232e2a;
      .menu-box {
        flex: 1;
        display: flex;
        flex-direction: column;
        justify-content: space-around;
        .menu-item {
          width: 120px;
          display: flex;
          flex-direction: column;
          justify-content: space-around;
          align-items: center;
          position: relative;
          text-align: center;
          cursor: pointer;
          border-bottom: 2px solid #535a62;
          img {
            width: 56px;
            height: 56px;
          }
          span {
            display: inline-block;
            width: 100%;
            text-align: center;
            left: 0;
            margin-bottom: 6px;
            color: #fff;
          }
        }
      }
      .menu-btn {
        height: 110px;
        color: #fff;
        display: flex;
        flex-direction: column;
        align-items: center;
        span {
          display: inline-block;
          height: 30px;
          line-height: 30px;
          cursor: pointer;
          &:hover {
            color: #409eff;
          }
          &.exit {
            width: 100px;
            margin-top: 10px;
            background: #05608c;
            text-align: center;
            border-radius: 4px;
            margin-bottom: 10px;
            &:hover {
              background: #087db5;
              color: #fff;
            }
          }
        }
      }
    }
    .main {
      flex: 1;
      position: relative;
      .title,
      .content {
        width: 1200px;
        margin: 20px auto;
        border: 2px solid #2c3e50;
      }
      .title {
        height: 40px;
        border: none;
        box-shadow: 0 0 4px rgba(0, 0, 0, 0.5)
      }
      .content {
        height: calc(~'100% - 140px');
        background: #bbb;
        overflow: hidden;
        .program-panel {
          position: relative;
          width: 100%;
          height: 100%;
          background: #fff;
          overflow: hidden;
        }
      }
      .zoom-box {
        position: absolute;
        display: flex;
        background: #e4e7ed;
        align-items: center;
        border-radius: 4px;
        bottom: 0;
        right: 0;
        .zoom-in,
        .zoom-out {
          display: inline-block;
          width: 24px;
          height: 24px;
          cursor: pointer;
        }
        .zoom-in {
          background: url('../../assets/image/zoom_in.png');
        }
        span {
          color: #000;
        }
        .zoom-out {
          background: url('../../assets/image/zoom_out.png');
        }
      }
    }
  }
  .overlay {
    position: fixed;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    z-index: 10;
    background: rgba(0, 0, 0, 0.4);
  }
  .vdr {
      border: 1px solid #45DBF7;
    }

  .video-icon {
    width: 48px;
    height: 48px;
    display: inline-block;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background: url('../../assets/image/video.png');
  }
}
</style>

