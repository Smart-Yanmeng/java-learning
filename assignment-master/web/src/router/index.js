import { createRouter, createWebHistory } from 'vue-router'
import HomeIndexView from '@/views/home/HomeIndexView'
import InfoIndexView from '@/views/info/InfoIndexView'
import RequireIndexView from '@/views/require/RequireIndexView'
import ChatIndexView from '@/views/chat/ChatIndexView'
import AdminInfoIndexView from '@/views/admin/info/AdminInfoIndexView'
import NotFound from '@/views/error/NotFound'

const routes = [
  {
    path: '/',
    name: 'home',
    redirect: '/home/',
  },
  {
    path: '/home/',
    name: 'home_index',
    component: HomeIndexView,
  },
  {
    path: '/info/',
    name: 'info_index',
    component: InfoIndexView,
  },
  {
    path: '/require/',
    name: 'require_index',
    component: RequireIndexView,
  },
  {
    path: '/chat/',
    name: 'chat_index',
    component: ChatIndexView,
  },
  {
    path: '/admin/info/',
    name: 'admin_info_index',
    component: AdminInfoIndexView,
  },
  {
    path: '/404/',
    name: '404',
    component: NotFound,
  },
  {
    path: '/:catchAll(.*)',
    redirect: '/404/',
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
