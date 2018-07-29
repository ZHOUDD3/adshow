<template>
    <div class="video-container">
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
  components: {
    'video-player': videoPlayer
  }
}
</script>
<style lang="less" scoped>
.video-container {
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  background: rgba(0, 0, 0, 0.8);
  .video-player-box {
  }
}
</style>
