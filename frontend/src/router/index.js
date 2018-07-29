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
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: 'home'
    },
    {
      path: '/callservice',
      name: 'Service',
      component: Service
    },
    {
      path: '/bootstrap',
      name: 'Bootstrap',
      component: Bootstrap
    },
    {
      path: '/user',
      name: 'User',
      component: User
    },
    {
      path: '/home',
      name: 'Home',
      component: Home,
      children: [
        {
          path: 'make',
          name: 'Make', 
          component: Make
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
