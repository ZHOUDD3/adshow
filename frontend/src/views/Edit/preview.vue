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
            <Deformation 
              v-for="(item, index) in videoArr" 
              :key="index"
              :w="item.width" 
              :h="item.height" 
              :x="item.left" 
              :y="item.top" 
              :z="100" 
              :draggable="false">
              <video-player
                class="video-player-box"
                ref="videoPlayer"
                :options="playerOptions">
              </video-player>
            </Deformation>
        </div>
        <audio ref="audio"></audio>
    </div>
</template>
<script>
import Deformation from '@/components/deformation'
import VideoPlay from '../Video/Play'
import { videoPlayer } from 'vue-video-player'
export default {
  data() {
    return {
      txtArr: [],
      dateArr: [],
      imageArr: [],
      videoArr: [],
      videoId: '',
      videoName: '',
      playerOptions: {
       autoplay: true,
       width: '',
       height: '',
       sources: [
      ]
      }
    }
  },
  components: {
    Deformation,
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
    this.playerOptions.width = this.videoArr[0].width
    this.playerOptions.height = this.videoArr[0].height
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
}
.preview-dialog {
  position: absolute;
  top: 5vh;
  left: 5vh;
  right: 5vh;
  bottom: 5vh;
  background: #fff;
  border-radius: 10px;
}
</style>
