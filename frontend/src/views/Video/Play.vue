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
            type: 'video/mp4',
            src:
              'https://cdn.theguardian.tv/webM/2015/07/20/150716YesMen_synd_768k_vp8.webm'
          }
        ],
        poster: '/static/images/author.jpg'
      }
    }
  },
  props: {
    videoId: {
      type: String
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
    videoId: function (n, o) {
      this.playerOptions.sources.src = process.env.BASE_API + 'ad/video/view/' + n
    }
  },
  mounted () {
    this.playerOptions.sources.src = process.env.BASE_API + 'ad/video/view/' + this.videoId
    console.log('xxx', this.playerOptions.sources.src)
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
