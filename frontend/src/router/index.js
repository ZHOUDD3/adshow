import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Service from '@/components/Service'
import Bootstrap from '@/components/Bootstrap'
import User from '@/components/User'
import Login from '@/views/Login.vue'
import Edit from '@/views/Edit.vue'
import Home from '@/views/Home.vue'
import Make from '@/views/Edit/Index.vue'
import InsertVideo from '@/views/Video/Index'
import Play from '@/views/Video/Play'
const ProgramManage = () => import('@/views/programManage/Index')
const SystemLog = () => import('@/views/systemLog/Index')
const SystemManage = () => import('@/views/systemSetting/Index')
const TerminalManage = () => import('@/views/terminalManage/Index')
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: 'login'
    },
    {
      path: '*',
      redirect: 'login'
    },
    {
      path: '/home',
      name: 'Home',
      component: Home,
      children: [
        {
          path: 'make',
          name: '节目制作', 
          component: Make
        },
        {
          path: 'programManage',
          name: '节目管理',
          component: ProgramManage
        },
        {
          path: 'terminalManage',
          name: '终端管理',
          component: TerminalManage
        },
        {
          path: 'systemManage',
          name: '系统设置',
          component: SystemManage
        },  
        {
          path: 'systemLog',
          name: '系统日志',
          component: SystemLog
        },
        {
          path: '/',
          redirect: 'make'
        }
      ]
    },
    {
      path: '/edit',
      name: 'Edit',
      component: Edit
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/insertVideo',
      name: 'InsertVideo',
      component: InsertVideo
    },
    {
      path: '/play',
      name: 'Play',
      component: Play
    }
  ]
})
