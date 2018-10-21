// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import moment from 'moment'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import './utils/computedREM.js'
import 'element-ui/lib/theme-chalk/index.css'
import 'normalize.css'
import './style/index.less'
import CONFIG from  './CONFIG.vue'
import store from './store'
import SpaceTime from 'spacetime'

Vue.config.productionTip = false
Vue.use(ElementUI, {size: 'small'})
Vue.prototype.GLOBAL = CONFIG
Vue.prototype.$spacetime = SpaceTime

// 使用form-data请求接口
import axios from "axios"  //引入

//设置axios为form-data
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
axios.defaults.headers.get['Content-Type'] = 'application/x-www-form-urlencoded';
//请求发送时,携带Cookie
axios.defaults.withCredentials=true;
axios.defaults.transformRequest = [function (data) {
    let ret = ''
    for (let it in data) {
      ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
    }
    return ret
}]


//然后再修改原型链
Vue.prototype.$axios = axios
Vue.filter('dateFormatter', function(date, pattern = 'YYYY-MM-DD HH:mm:ss') {
  return moment(date).format(pattern)

});
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: { App }
})
