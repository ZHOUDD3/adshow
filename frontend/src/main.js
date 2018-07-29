// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import 'normalize.css'
import './style/index.less'
import CONFIG from  './CONFIG.vue'

Vue.config.productionTip = false
Vue.use(ElementUI, {size: 'small'})
Vue.prototype.GLOBAL = CONFIG

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})
