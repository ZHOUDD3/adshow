<template>
    <div class="page-container">
        <div class="edit-container" :style="style">
            <div class="menu">
                <div class="menu-box">
                  <div class="menu-item" v-for="(item, index) in menuList" @click="addItem(index)" :key=index>
                      <img :src="item.icon" alt="">
                      <span>{{item.title}}</span>
                  </div>
                </div>
                <div class="menu-btn">
                  <span class="exit" @click="previewProgram">预览与发布</span>
                  <span @click="saveProgram">保存</span>
                  <span @click="exit">退出</span>
                </div>
            </div>
            <div class="main">
                <div class="title">
                  <div class="menu-tool">
                    <span class="delete" @click="deleteItem"></span>
                    <span class="full" @click="fullItem"></span>
                    <span class="reimport" @click="reimportItem"></span>
                    <span class="toplayer" @click="topItem"></span>
                    <span class="uplayer" @click="upItem"></span>
                    <span class="botlayer" @click="lowerItem"></span>
                  </div>
                  <div class="text-tool">
                    <div v-if="showTextTool" class="text-tool-item font-family">
                      <el-select v-model="fontFamily">
                        <el-option v-for="(item, index) in fontFamilyArr" :key="index" :value="item" :label="item">
                
                        </el-option>
                      </el-select>
                    </div>
                    <div v-if="showTextTool" class="text-tool-item font-color">
                      <el-color-picker v-model="fontColor" @change="setFontColor(color)"></el-color-picker>
                    </div>
                    <div v-if="showTextTool" class="text-tool-item text-align">
                      <span @click="setTextAligh('left')"></span>
                      <span @click="setTextAligh('center')"></span>
                      <span @click="setTextAligh('right')"></span>
                    </div>
                    <div v-if="showTextTool" class="text-tool-item font-size">
                      <el-select v-model="fontSize" @change="changeFontSize">
                        <el-option v-for="(item, index) in fontSizeArr" :key="item" :label="item" :value="item">
                        </el-option>
                      </el-select>
                    </div>
                  </div>
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
                      :z="item.zIndex" 
                      :parent="true" 
                      :draggable="item.status === 'unlock'" 
                      v-show="item.visible" 
                      @resizestop="onResizstop(arguments, item)"
                      @activated="itemActived($event, item)"
                      @deactivated="itemDeactived"
                      @dragstop="onDragstop($event, item)" 
                      @dragDblclick="editText(item, index, 'text')">
                      <p :readonly="true" :style="{
                          fontSize: item.fontSize + 'px',
                          color: item.color,
                          textAlign: item.align || 'center',
                          fontFamily: item.fontFamily || 'Microsoft YaHei'
                        }">
                          {{item.content}}
                        </p>
                    </Deformation>
                    <!-- 滚动文字框区域 -->
                    <Deformation 
                      v-for="(item, index) in marqueeArr" 
                      :key="`marquee${index}`" 
                      :w="item.width" 
                      :h="item.height" 
                      :x="item.left" 
                      :y="item.top"
                      :z="item.zIndex" 
                      :parent="true" 
                      :draggable="item.status === 'unlock'" 
                      v-show="item.visible" 
                      @activated="itemActived($event, item)"
                      @deactivated="itemDeactived"
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
                    <!-- 日历区域 -->
                    <Deformation 
                      v-for="(item, index) in dateArr" 
                      :key="`date${index}`" 
                      :w="item.width" 
                      :h="item.height" 
                      :x="item.left" 
                      :y="item.top"
                      :z="item.zIndex" 
                      :draggable="item.status === 'unlock'" 
                      v-show="item.visible" 
                      :parent="true"
                      @activated="itemActived($event, item)"
                      @deactivated="itemDeactived"
                      @resizestop="onResizstop(arguments, item)" 
                      @dragstop="onDragstop($event, item)" 
                      @dragDblclick="editDate(item)">
                      <p>{{item.content}}</p>
                    </Deformation>
                    <!-- 图片区域 -->
                    <Deformation
                      v-for="(item, index) in imageArr"
                      :key="`image${index}`" 
                      :w="item.width" 
                      :h="item.height" 
                      :x="item.left" 
                      :y="item.top"
                      :z="item.zIndex" 
                      :draggable="item.status === 'unlock'" 
                      v-show="item.visible"
                      @activated="itemActived($event, item)"
                      @deactivated="itemDeactived"
                      @resizestop="onResizstop(arguments, item)" 
                      @dragstop="onDragstop($event, item)" 
                      :parent="true">
                      <img :src="item.src" alt="" width="100%" height="100%">
                    </Deformation>
                    <!-- 视频区域 -->
                    <Deformation
                      v-for="(item, index) in videoArr"
                      :key="`video${index}`"
                      :w="item.width" 
                      :h="item.height" 
                      :x="item.left" 
                      :y="item.top"
                      :parent="true"
                      @activated="itemActived($event, item)"
                      @deactivated="itemDeactived"
                      @resizestop="onResizstop(arguments, item)" 
                      @dragstop="onDragstop($event, item)">
                      <img :src="item.thumb" alt="" width="100%" height="100%">
                      <i class="video-icon"></i>
                    </Deformation>
                  </div>
                </div>
            </div>
        </div>
        <transition name="el-fade-in">
          <div class="overlay" v-if="showDialogFlag">
              <insert-video 
                v-if="showInsertVideo"
                @insertVideo="insertVideo"
                @reimportVideo="reimportVideo"
                :type="editVideoType"
                @closeInsertVideo="closeDialog('video')">
              </insert-video>
              <!--上传素材Dialog-->
              <meterial-list
                v-if="showMeterialDialog"
                @closeMeterialListDialog="closeDialog('picture')"
                @addImage="addImage"
                :type="editImageType"
                @reimportImage="reimportImage"
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
        </transition>
        <text-dialog 
          v-if="textDialogVisible"
          :content="currentText"
          :type="textType"
          :textStyle="currentTextStyle"
          @closeTextDialog="justifyText">
        </text-dialog>
        <transition name="el-zoom-in-center">
          <preview-dialog 
            v-if="dialogVisible"
            ref="preview"
            :panelWidth="panelWidth"
            :panelHeight="panelHeight"
            :componentArr="componentArr"
            @closePreview="closePreview">
          </preview-dialog>
        </transition>
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
      fontFamilyArr: [
        'Microsoft YAHEI'
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
      panelHeight: 1080,
      activeItem: null,
      fontFamily: '',
      showTextTool: false,
      fontColor: '',
      fontSizeArr: [12, 14, 16, 18, 20, 24, 30, 36, 48],
      fontSize: 16,
      editVideoType: 'add',
      showBlur: false
    }
  },
  computed: {
    style () {
      return this.showBlur ? {filter: 'blur(6px)'} : ''
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
      this.showBlur = false
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
          zIndex: this.componentArr.length + 1,
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
      this.showBlur = false
    },
    reimportVideo (data) {
      this.activeItem.id = data.id
      this.activeItem.name = data.name
      this.activeItem.createUser = data.createUser
      this.activeItem.createTime = data.createTime
      this.activeItem.materialInterval = data.materialInterval
      this.showDialogFlag = false
      this.showInsertVideo = false
    },
    insertImage (data) {
      this.imageArr = data
      this.showDialogFlag = false
      this.showInsertVideo = false
    },
    addItem(index) {
      switch (index) {
        case 0: // insert video
          this.editVideoType = 'add'
          this.showBlur = true
          this.showDialogFlag = true
          this.showInsertVideo = true
          break
        case 1: // insert image
          this.editImageType = 'add'
          this.showDialogFlag = true
          this.showMeterialDialog = true
          this.showBlur = true
          break
        case 2: // insert music
          this.showDialogFlag = true
          this.showMusicDialog = true
          this.showBlur = true
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
        left: 100,
        top: 100,
        width: 800,
        height: 64,
        fontSize: 56,
        color: '#000',
        align: 'center',
        zIndex: this.componentArr.length + 1
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
        height: 60,
        zIndex: this.componentArr.length + 1
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
        color: '#000',
        zIndex: this.componentArr.length + 1
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
          left: 50,
          top: 50,
          width: 400,
          height: 300,
          zIndex: this.componentArr.length + 1
        })
      })
      this.imageArr = this.componentArr.filter(item => {
        return item.type === 'picture'
      })
    },
    reimportImage (data) {
      this.activeItem.src = process.env.BASE_API + 'PICTURE/' + data.id + '/' + data.name
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
    itemActived (event, item) {
      this.activeItem = item
      if (item.type === 'text') {
        this.showTextTool = true
      } else {
        this.showTextTool = false
      }
    },
    itemDeactived () {
      
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
        if (res.data.success) {
          this.$message({
            type: 'success',
            message: '节目保存成功'
          })
        }
      })
    },
    exit () {
      // 退出编辑节目
    },
    previewProgram () {
      // 预览节目
      this.showBlur = true
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

    },
    deleteItem () {
      if (this.activeItem) {
        let index = this.componentArr.indexOf(this.activeItem)
        this.componentArr.splice(index, 1)
        switch (this.activeItem.type) {
          case 'text':
            this.txtArr = this.componentArr.filter(item => {
              return item.type === 'text'
            })
            break
          case 'video':
            this.videoArr = this.componentArr.filter(item => {
              return item.type === 'text'
            })
            break
          case 'picture':
            this.imageArr = this.componentArr.filter(item => {
              return item.type === 'picture'
            })
            break
          case 'marquee':
            this.marqueeArr = this.componentArr.filter(item => {
              return item.type === 'marquee'
            })
            break
          case 'date':
            this.dateArr = this.componentArr.filter(item => {
              return item.type === 'date'
            })
            break
        }
        this.activeItem = null
      }
    },
    fullItem () {
      if (this.activeItem) {
        let panelWidth = this.$refs.programPanel.clientWidth
        let panelHeight = this.$refs.programPanel.clientHeight
        this.activeItem.left = 0
        this.activeItem.top = 0
        this.activeItem.width = panelWidth
        this.activeItem.height = panelHeight
      }
    },
    upItem () {
     if (this.activeItem) {
       let index = this.activeItem.zIndex
        this.componentArr.forEach(item => {
          if (item.zIndex - 1 === index) {
            item.zIndex -= 1
          }
        })
        this.activeItem.zIndex = index + 1
     }
    },
    lowerItem () {
      if (this.activeItem) {
        let index = this.activeItem.zIndex
        this.componentArr.forEach(item => {
          if (item.zIndex + 1 === index) {
            item.zIndex += 1
          }
        })
        this.activeItem.zIndex = index - 1
      }
    },
    topItem () {
      if (this.activeItem) {
        let index = this.activeItem.zIndex
        this.componentArr.forEach(item => {
          if (item.zIndex > index) {
            item.zIndex -= 1
          }
        })
        this.activeItem.zIndex = this.componentArr.length
      }
    },
    reimportItem () { // 重新导入素材
      switch(this.activeItem.type) {
        case 'video':
          this.editVideoType = 'reimport'
          this.showDialogFlag = true
          this.showInsertVideo = true
          this.showBlur = true
          break
        case 'picture':
          this.editImageType = 'reimport'
          this.showDialogFlag = true
          this.showMeterialDialog = true
          this.showBlur = true
          break
      }
    },
    setTextAligh (align) {
      this.activeItem.align = align
    },
    setFontColor (color) {
      this.activeItem.color = color
    },
    closePreview () {
      this.dialogVisible = false
      this.showBlur = false
    },
    changeFontSize (value) {
      if (this.activeItem && this.activeItem.type === 'text') {
        this.activeItem.fontSize = value
      }
    }
  },
  watch: {
    fontColor (newVal) {
      this.activeItem.color = newVal
    }
  },
  mounted () {
  },
  beforeDestroy () {
    if (this.componentArr.length > 0) {
      this.$alert('您是否要保存当前节目', {
        confirmButtonText: '保存',
        callback: action => {
          this.saveProgram()
        }
      })
    }
  }
}
</script>
<style lang="less" scoped>
@base: 192;
.page-container {
  position: relative;
  height: 100%;
  overflow: hidden;
  .edit-container {
    height: 100%;
    display: flex;
    font-size: 24rem/base;
    .menu {
      width: 154rem/@base;
      height: 100%;
      display: flex;
      flex-direction: column;
      justify-content: space-between;
      align-items: center;
      background: #232e2a;
      .menu-box {
        flex: 1;
        /* padding-top: 60rem/@base;
        padding-bottom: 60rem/@base;*/
        display: flex;
        flex-direction: column;
        justify-content: space-around;
        font-size: 14rem/@base; 
        .menu-item {
          width: 84rem/@base;
          display: flex;
          flex-direction: column;
          justify-content: space-around;
          align-items: center;
          position: relative;
          text-align: center;
          cursor: pointer;
          border-bottom: 2px solid #535a62;
          img {
            width: 35px;
            height: 35px;
          }
          span {
            display: inline-block;
            width: 100%;
            text-align: center;
            left: 0;
            font-size: 16rem/@base;
            margin-top: 20rem/@base;
            margin-bottom: 15rem/@base;
            color: #fff;
          }
          &:hover {
            span {
              color: #fe4a76;
            }
          }
        }
      }
      .menu-btn {
        /* span {
          display: block;
          text-align: center;
          height: 30rem/@base;
        }
        height: 140rem/@base; */
        color: #fff;
        display: flex;
        flex-direction: column;
        align-items: center;
        span {
          display: block;
          height: 30rem/@base;
          line-height: 30rem/@base;
          cursor: pointer;
          font-size: 16rem/@base;
          &:hover {
            color: #409eff;
          }
          &.exit {
            width: 100rem/@base;
            height: 30rem/@base;
            line-height: 30rem/@base;
            margin-top: 10rem/@base;
            background: #05608c;
            text-align: center;
            border-radius: 4px;
            margin-bottom: 10px;
            font-size: 16rem/@base;
            &:hover {
              background: #087db5;
              color: #fff;
            }
          }
        } 
      }
    }
    .main {
      height: 100%;
      flex: 1;
      position: relative;
      display: flex;
      flex-direction: column;
      .title,
      .content {
        width: 1080rem/@base;
        margin: 20rem/@base auto;
        border: 2px solid #2c3e50;
      }
      .title {
        height: 65rem/@base;
        display: flex;
        border: none;
        border-radius: 6px;
        box-shadow: 0 0 4px rgba(0, 0, 0, 0.5);
        .menu-tool {
          flex: 1;
          display: flex;
          justify-content: space-around;
          align-items: center;
          span {
            display: inline-block;
            width: 24rem/@base;
            height: 24rem/@base;
            cursor: pointer;
          }
          .delete {
            background: url('../../assets/image/delete.png');
            background-size: cover;
          }
          .full {
            background: url('../../assets/image/full.png');
            background-size: cover;
          }
          .toplayer {
            background: url('../../assets/image/toplayer.png');
            background-size: cover;
          }
          .uplayer {
            background: url('../../assets/image/uplayer.png');
            background-size: cover;
          }
          .botlayer {
            background: url('../../assets/image/botlayer.png');
            background-size: cover;
          }
          .reimport {
            background: url('../../assets/image/reimport.png') no-repeat center center;
            background-size: contain;
          }
        }
        .text-tool {
          flex: 1;
          display: flex;
          align-items: center;
          .text-tool-item {
            height: 36rem/@base;
            border-right: 1px solid #dedede;
            i {
              display: inline-block;
              width: 28rem/@base;
              height: 28rem/@base;
              cursor: pointer;
            }
          }
          .font-family {
            display: flex;
            align-items: center;
          }
          .font-size {
            width: 80rem/@base;
            display: flex;
            justify-content: center;
            align-items: center;
            i {
              display: inline-block;
              width: 28rem/@base;
              height: 28rem/@base;
              background: url('../../assets/image/font_size.png');
            }
          }
          .text-align {
            width: 160rem/@base;
            height: 28rem/@base;
            display: flex;
            justify-content: space-around;
            span {
              display: inline-block;
              width: 24rem/@base;
              height: 24rem/@base;
              cursor: pointer;
              &:nth-child(1) {
                background: url('../../assets/image/text_left.png');
                background-size: cover;
              }
              &:nth-child(2) {
                background: url('../../assets/image/text_center.png');
                background-size: cover;
              }
              &:nth-child(3) {
                background: url('../../assets/image/text_right.png');
                background-size: cover;
              }
            }
          }
          .font-color {
            display: flex;
            align-items: center;
            justify-content: center;
            width: 40rem/@base;
            i {
              width: 28rem/@base;
              height: 29rem/@base;
              background: url('../../assets/image/font_color.png');
              background-size: cover;
            }
          }
        }
      }
      .content {
        // height: 720rem/@base;
        flex: 1;
        background: #bbb;
        overflow: hidden;
        .program-panel {
          position: relative;
          width: 100%;
          height: 100%;
          background: #fff;
          overflow: hidden;
        }
        p {
          margin: 0;
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
          width: 24rem/@base;
          height: 24rem/@base;
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
  .video-icon {
    width: 48rem/@base;
    height: 48rem/@base;
    display: inline-block;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background: url('../../assets/image/video.png');
  }
}
</style>

