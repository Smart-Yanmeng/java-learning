import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/views/Home.vue'
import store from '../store'
import {getCookie} from '../common/cookie'
Vue.use(VueRouter)

const routes = [{
    path: '/',
    redirect: '/home'
  },{
    path: '/home',
    component: Home,
    children: [{
      path: '',
      redirect: 'index'
    }, {
      path: 'index',
      name: 'Index',
      meta:{
        title:'小米商城'
      },
      component: () => import('@/views/subViews/Index.vue')
    }, {
      path: 'allShopping',
      name: 'AllShopping',
      meta:{
        title:'所有商品'
      },
      component: () => import('../views/subViews/AllShopping.vue')
    }, {
      path: 'aboutUs',
      name: 'AboutUs',
      meta:{
        title:'关于我们'
      },
      component: () => import('../views/subViews/AboutUs.vue')
    },{
      path:'shoppingInfo',
      name:'ShoppingInfo',
      meta:{
        title:'商品详情'
      },
      component:() => import('../views/subViews/ShoppingInfo.vue')
    },{
      path:'myCollection',
      name:'MyCollection',
      meta:{
        title:'我的收藏'
      },
      component:() => import('../views/subViews/MyCollection.vue')
    },{
      path:'myOrder',
      name:'MyOrder',
      meta:{
        title:'我的订单'
      },
      component:() => import('../views/subViews/MyOrder.vue')
    },{
      path:'myShoppingCar',
      name:'MyShoppingCar',
      meta:{
        title:'购物车'
      },
      component:() => import('../views/subViews/MyShoppingCar.vue')
    },{
      path:'confirmOrder',
      name:'ConfirmOrder',
      meta:{
        title:'确认订单'
      },
      component:() => import('../views/subViews/ConfirmOrder.vue')
    },{
      path:'test',
      name:'Test',
      meta:{
        title:'测试'
      },
      component:() => import('../views/subViews/test.vue')
    },{
      path:'test1',
      name:'Test1',
      meta:{
        title:'测试'
      },
      component:() => import('../views/subViews/test1.vue')
    },{
      path:'myOrderAddress',
      name:'MyOrderAddress',
      meta:{
        title:'订单详情'
      },
      component:() => import('../views/subViews/MyOrderAddress.vue')
      
    }]
  }
]

const router = new VueRouter({
  routes
})

// 全局导航守卫
router.beforeEach((to,from,next) => {
  let token = getCookie('token')
  if(token){
    store.commit('setLoginState',true)
  }else{
    store.commit('setLoginState',false)
  }
  next()
})
export default router