// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import './utils/computedREM.js'
import 'element-ui/lib/theme-chalk/index.css'
import 'normalize.css'
import './style/index.less'
import CONFIG from  './CONFIG.vue'
import store from './store'

Vue.config.productionTip = false
Vue.use(ElementUI, {size: 'small'})
Vue.prototype.GLOBAL = CONFIG

// 使用form-data请求接口
import axios from "axios"  //引入

//设置axios为form-data
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
axios.defaults.headers.get['Content-Type'] = 'application/x-www-form-urlencoded';
axios.defaults.transformRequest = [function (data) {
    let ret = ''
    for (let it in data) {
      ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
    }
    return ret
}]


//然后再修改原型链
Vue.prototype.$axios = axios

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: { App }
})
