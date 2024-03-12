import Vue from 'vue'
import Vuex from 'vuex'
import {getMyShoppingCarNum} from '@/api/home'
Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    // 登录弹框显示隐藏  1 开启登录弹框   2 开启注册弹框   3 关闭弹框
    loginPop:3,
    // 登录状态  false 未登录   true  已登录
    loginState:false,
    // 购物车数量
    myShoppingCarNum:0

  },
  mutations: {
    // 修改登录弹框状态
    setLoginPop(state,options){
      state.loginPop = options
    },
    // 修改当前登录状态
    setLoginState(state,options){
      state.loginState = options
    },
    // 修改购物车数量
    setMyShoppingCarNum(state,options){
      state.myShoppingCarNum = options
    }
  },
  actions: {
    //  查询我的购物车数量
    setMyShoppingCarNumDes(context){
      getMyShoppingCarNum().then(res => {
        context.commit('setMyShoppingCarNum',res.data)
      }).catch(error => {
        console.log(error);
      })
    }
  },
  modules: {
  }
})
