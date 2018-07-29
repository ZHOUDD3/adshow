<template>
    <div class="page-container">
        <div class="edit-container">
            <div class="menu">
                <div class="menu-item" v-for="(item, index) in menuList" @click="addItem(index)" :key=index>
                    <img :src="item.icon" alt="">
                    <span>{{item.title}}</span>
                </div>
            </div>
            <div class="main">
                <div class="title">

                </div>
                <div class="content">
                    <!--文本框区域-->
                    <Deformation v-for="(item, index) in txtArr" :key="index" :w="item.width" :h="item.height" :x="item.left" :y="item.top" :parent="true" :draggable="item.status === 'unlock'" v-show="item.visible" @resizestop="onResizstop(arguments, item)" @dragstop="onDragstop($event, item)" @dragDblclick="editText(item)">
                        <p>{{item.content}}</p>
                    </Deformation>
                    <!--日历区域-->
                    <Deformation v-for="(item, index) in dateArr" :key="`date${index}`" :w="item.width" :h="item.height" :x="item.left" :y="item.top" :draggable="item.status === 'unlock'" v-show="item.visible" :parent="true" @dragDblclick="editDate(item)">
                        <p>{{item.content}}</p>
                    </Deformation>
                </div>
            </div>
        </div>
        <div class="overlay" v-if="showDialogFlag">
            <insert-video v-if="showInsertVideo" @closeInsertVideo="closeDialog">
            </insert-video>
            <!--上传素材Dialog-->
            <meterial-list
              @closeMeterialListDialog="showDialogFlag=false"
              :title="meterialTitle">
                
              </meterial-list>
        </div>
        <text-dialog v-if="textDialogVisible" @closeTextDialog="textDialogVisible = false"></text-dialog>
    </div>
</template>

<script>
import InsertVideo from '../Video/Index.vue'
import TextDialog from '../Edit/textDialog.vue'
import MeterialList from './MeterialList'
import Deformation from 'deformation'
import SpaceTime from 'spacetime'
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
      textDialogVisible: false,
      txtArr: [],
      dateArr: [],
      componentArr: [],
      // 上传素材
      meterialTitle: ''
    }
  },
  components: {
    'insert-video': InsertVideo,
    'text-dialog': TextDialog,
    'meterial-list': MeterialList,
    Deformation
  },
  methods: {
    closeDialog(type) {
      this.showDialogFlag = false
      switch (type) {
        case 'video':
          this.showInsertVideo = false
          break
      }
    },
    addItem(index) {
      switch (index) {
        case 0: // insert video
          this.showDialogFlag = true
          this.showInsertVideo = true
          break
        case 1: // insert image
          this.showDialogFlag = true
          break
        case 2: // insert music

          break
        case 3: // isert text
          this.addText()
          break
        case 4: // insert Date
          this.addDate()
          break
        case 5: // insert marqueen

          break
      }
    },
    addText() {
      this.componentArr.push({
        type: '文本',
        content: '请输入文本',
        status: 'unlock',
        visible: true,
        left: 0,
        top: 0,
        width: 200,
        height: 60
      })
      this.txtArr = this.componentArr.filter(item => {
        return item.type === '文本'
      })
    },
    addDate() {
      let date = SpaceTime().format('yyyy/MM/dd hh:mm:ss')
      this.componentArr.push({
        type: '日期',
        content: date,
        status: 'unlock',
        visible: true,
        left: 100,
        top: 100,
        width: 200,
        height: 60
      })
      this.dateArr = this.componentArr.filter(item => {
        return item.type === '日期'
      })
    },
    editText (index) {
      this.textDialogVisible = true
    },
    editDate (item) {

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
    }
  },
  mounted () {
      console.log('make page ', this.GLOBAL.DOMAIN)
  }
}
</script>
<style lang="less" scoped>
.page-container {
  height: 100%;
  position: relative;
  .edit-container {
    height: 100%;
    display: flex;
    .menu {
      width: 140px;
      display: flex;
      flex-direction: column;
      align-items: center;
      background: #232e2a;
      .menu-item {
        width: 120px;
        height: 120px;
        display: flex;
        flex-direction: column;
        justify-content: space-around;
        align-items: center;
        position: relative;
        text-align: center;
        cursor: pointer;
        border-bottom: 2px solid #535a62;
        img {
          width: 60px;
          height: 60px;
        }
        span {
          display: inline-block;
          width: 100%;
          text-align: center;
          left: 0;
          margin-bottom: 10px;
          color: #fff;
        }
      }
    }
    .main {
      flex: 1;
      .title,
      .content {
        width: 70%;
        margin: 20px auto;
        border: 2px solid #2c3e50;
        position: relative;
      }
      .title {
        height: 40px;
      }
      .content {
        height: calc(~'100% - 140px');
      }
    }
  }
  .overlay {
    position: fixed;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    background: rgba(0, 0, 0, 0.4);
  }
  .vdr {
      border: 1px solid #45DBF7;
    }
}
</style>

