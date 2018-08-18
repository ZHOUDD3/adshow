<template>
    <!--预览界面-->
    <div class="preview-wrap" @click="closePreview">
        <div class="preview-dialog">
            <!--文本框区域-->
            <Deformation v-for="(item, index) in txtArr" :key="index" :w="item.width" :h="item.height" :x="item.left" :y="item.top" :z="10" :parent="true" :draggable="false" v-show="item.visible" @resizestop="onResizstop(arguments, item)" @dragstop="onDragstop($event, item)" @dragDblclick="editText(item, index)">
                <p :readonly="true" :style="{
									fontSize: item.fontSize + 'px',
									color: item.color
								}">
                    {{item.content}}
                </p>
            </Deformation>
            <!--日历区域-->
            <Deformation v-for="(item, index) in dateArr" :key="`date${index}`" :w="item.width" :h="item.height" :x="item.left" :y="item.top" :z="1" :draggable="false" v-show="item.visible" :parent="true" @dragDblclick="editDate(item)">
                <p>{{item.content}}</p>
            </Deformation>
            <!--图片区域-->
            <Deformation v-for="(item, index) in imageArr" :key="`image${index}`" :w="item.width" :h="item.height" :x="item.left" :y="item.top" :draggable="false" v-show="item.visible" :parent="true">
                <img :src="item.src" alt="" width="100%" height="100%">
            </Deformation>
            <!--视频区域-->
            <video-player
              class="video-player-box"
              ref="videoPlayer"
              v-if="videoArr.length > 0"
              :options="playerOptions">
            </video-player>
            <!--滚动文字-->
            <Deformation 
              v-for="(item, index) in marqueeArr" 
              :key="`marquee${index}`"
              :w="item.width" 
              :h="item.height" 
              :x="item.left" 
              :y="item.top" 
              :z="100" 
              :draggable="false">
              <marquee-text :content="item.content">
              </marquee-text>
            </Deformation>
        </div>
        <audio ref="audio"></audio>
    </div>
</template>
<script>
import Deformation from '@/components/deformation'
import VideoPlay from '../Video/Play'
import MarqueeText from './marqueeDialog'
import { videoPlayer } from 'vue-video-player'
export default {
  data() {
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
      }
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
    }
  },
  mounted() {
    this.txtArr = this.componentArr.filter(item => {
      return item.type === 'text'
    })
    this.dateArr = this.componentArr.filter(item => {
      return item.type === 'date'
    })
    this.imageArr = this.componentArr.filter(item => {
      return item.type === 'picture'
    })
    this.videoArr = this.componentArr.filter(item => {
      return item.type === 'video'
    })
    this.marqueeArr = this.componentArr.filter(item => {
      return item.type === 'marquee'
    })
    /*this.playerOptions.width = this.videoArr[0].width
    this.playerOptions.height = this.videoArr[0].height*/
    this.videoArr.forEach(item => {
      this.playerOptions.sources.push({
        src: process.env.BASE_API + 'VIDEO/' + item.id + '/' + item.name,
        type: 'video/' + item.name.split('.')[1]
      })
    })
  }
}
</script>
<style lang="less" scoped>
.preview-wrap {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: rgba(0, 0, 0, 0.6);
  z-index: 1000;
  .preview-dialog {
    position: absolute;
    top: 5vh;
    left: 5vh;
    right: 5vh;
    bottom: 5vh;
    background: #fff;
    border-radius: 10px;
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
}
</style>
