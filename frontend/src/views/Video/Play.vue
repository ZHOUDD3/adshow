<template>
    <div class="video-container">
        <i @click="closeVideo" class="close-icon"></i>
        <video-player
            class="video-player-box"
            ref="videoPlayer"
            :options="playerOptions">
        </video-player>
    </div>
</template>

<script>
import 'video.js/dist/video-js.css'
import { videoPlayer } from 'vue-video-player'
export default {
  data() {
    return {
      playerOptions: {
        // videojs options
        muted: false,
        language: 'en',
        playbackRates: [0.7, 1.0, 1.5, 2.0],
        sources: [
          {
            type: '',
            // 需要拼接  播放地址 + id + 文件名
            src: ''
          }
        ],
        poster: '/static/images/author.jpg'
      }
    }
  },
  props: {
    id: {
      type: String,
      default: ''
    },
    name: {
      type: String,
      default: ''
    }
  },
  components: {
    'video-player': videoPlayer
  },
  methods: {
    closeVideo () {
      this.$emit('closeVideo')
    }
  },
  watch: {
    
  },
  created () {
    // http://localhost:8089/VIDEO/39085873957965824/e640e3b6d3c469a3eb65990f25f0d7f4.mp4
    //设置视频类型
    this.playerOptions.sources[0].type = 'video/' +　this.name.split('.')[1]
    this.playerOptions.sources[0].src = process.env.BASE_API + 'VIDEO/' + this.id + '/' + this.name
    console.log(this.playerOptions.sources[0].type)
  }
}
</script>
<style lang="less" scoped>
.video-container {
  height: 100%;
  width: 100%;
  display: flex;
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  justify-content: center;
  align-items: center;
  background: rgba(0, 0, 0, 0.6);
  z-index: 1;
  .video-player-box {
    z-index: 100;
  }
  .close-icon {
    position: absolute;
    display: inline-block;
    width: 32px;
    height: 32px;
    top: 16px;
    right: 16px;
    background: url('../../assets/image/close_white.png');
  }
}
</style>
