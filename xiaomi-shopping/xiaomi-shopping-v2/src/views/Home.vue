<template>
  <div>
    <!-- 头部状态管理 -->
    <div class="home-head-state">
      <div class="home-head-state-content">
        <div
          v-for="(item, index) in headInfo"
          :key="index"
          class="home-head-state-content-item"
        >
          <!-- 登录｜注册 -->
          <div v-if="index === 0">
            <!-- 已登录 -->
            <el-popover placement="top" width="160" v-model="exitLoginPop">
              <p>确定要退出登录吗？</p>
              <div style="text-align: right; margin: 0">
                <el-button size="mini" type="text" @click="exitCancel"
                  >取消</el-button
                >
                <el-button type="primary" size="mini" @click="exitSubmit"
                  >确定</el-button
                >
              </div>
              <span
                slot="reference"
                class="hhst"
                v-show="$store.state.loginState"
                >欢迎 admin</span
              >
            </el-popover>

            <!-- 未登录 -->
            <div
              class="home-head-state-content-item-notlogin"
              v-show="!$store.state.loginState"
            >
              <span class="hhst" @click="loginEvent">登录</span>
              <span class="hhst-icon">｜</span>
              <span class="hhst" @click="registerEvent">注册</span>
            </div>
          </div>
          <!-- 我的订单、我的收藏 -->
          <div v-else-if="index > 0 && index <= 2" @click="goMyOther(index)">
            <span class="hhst">{{ item }}</span>
          </div>
          <!-- 购物车 -->
          <div
            v-else
            class="home-head-state-content-item-shopping-car"
            @click="goShoppingCarEvent"
          >
            <img src="../assets/home/shopping_cart.png" alt="" />
            <span class="hhst">{{
              item + "（" + $store.state.myShoppingCarNum + "）"
            }}</span>
          </div>
        </div>
      </div>
    </div>
    <!-- 二级tab栏 -->
    <div class="home-head-second">
      <div class="home-head-second-content">
        <!-- logo -->
        <div class="hhsc-left">
          <img src="../assets/home/shopping_logo.png" alt="" />
        </div>
        <!-- tab -->
        <div class="hhsc-center">
          <div
            v-for="(item, index) in secondInfo"
            :key="index"
            class="hhsc-center-item"
            :style="{
              color: secondColor(item),
            }"
            @mousemove="secondMouseMove(item)"
            @mouseleave="secondMouseLeave()"
            @click="selectSecondTab(item)"
          >
            {{ item.name }}
            <div
              class="hhsc-center-item-underline"
              v-show="showTabUnderLine(item)"
            ></div>
          </div>
        </div>
        <!-- 搜索框 -->
        <!-- <div class="hhsc-right">
          <div class="hhsc-right-searchbox"></div>
        </div> -->
      </div>
    </div>
    <!-- 二级页面 -->
    <div class="second-view">
      <router-view></router-view>
    </div>
    <!-- 底部 -->
    <div class="foot-mod">
      <div class="foot-mod-main">
        <div class="foot-mod-main-content">
          <div class="foot-mod-main-content-top">
            <div
              class="foot-mod-main-content-top-item"
              v-for="(item, index) in footInfo"
              :key="index"
            >
              <img src="../assets/foot/safety_shield.png" alt="" />
              <span>{{ item }}</span>
            </div>
          </div>
          <div class="foot-mod-main-content-bottom">
            <img src="../assets/foot/black_cat.png" alt="" />
            <span>首页｜全部商品｜关于我们</span>
            <span>商城版权所有 © 2012-2021 </span>
          </div>
        </div>
      </div>
    </div>
    <!-- 登录弹框 -->
    <login
      :show="$store.state.loginPop != 3"
      @on-result-change="onResultChange"
      :title="loginFormType"
    ></login>
  </div>
</template>

<script>
import Login from "../components/Login.vue";
import { removeCookie } from "../common/cookie";
export default {
  components: {
    Login,
  },
  watch: {
    "$store.state.loginState"(val) {
      if (val) {
        // 已登录
        this.$store.dispatch("setMyShoppingCarNumDes");
      } else {
        // 未登录
        this.$store.commit("setMyShoppingCarNum", 0);
      }
    },
  },
  data() {
    return {
      /** 顶部tab栏信息 */
      headInfo: ["登录｜注册", "我的订单", "我的收藏", "购物车"],
      /** 二级tab栏信息 */
      secondInfo: [
        { name: "首页", routName: "Index" },
        { name: "全部商品", routName: "AllShopping" },
        { name: "关于我们", routName: "AboutUs" },
      ],
      /** 底部数据 */
      footInfo: ["7天无理由退换货", "满99元全场免邮", "100%品质保证"],

      index: 0,
      /** 二级tab栏鼠标移入移出 */
      secondTabMouseName: null,

      /** 控制登录弹框的显示隐藏 */
      loginFormType: 1, //弹出框类型

      /** 退出登录 */
      exitLoginPop: false,
    };
  },
  computed: {
    // 二级tab栏颜色
    secondColor() {
      return (item) => {
        let currentRouteName = this.$route.name;
        if (currentRouteName == item.routName) {
          return "#409EFF";
        } else {
          if (this.secondTabMouseName == item.routName) {
            return "#000000";
          }
          return "#909399";
        }
      };
    },
    // 二级tab栏下划线
    showTabUnderLine() {
      return (item) => {
        let currentRouteName = this.$route.name;
        if (currentRouteName == item.routName) {
          return true;
        } else {
          return false;
        }
      };
    },
  },
  created() {
    // 查询当前购物车数量
    if (this.$store.state.loginState) {
      this.$store.dispatch("setMyShoppingCarNumDes");
    }
    console.log(process.env.TARGET,'哈哈哈哈');
  },
  methods: {
    /** 登录 */
    loginEvent() {
      this.loginFormType = 1;
      this.$store.commit("setLoginPop", 1);
    },
    /** 注册 */
    registerEvent() {
      this.loginFormType = 2;
      this.$store.commit("setLoginPop", 2);
    },
    /** 登录弹框取消事件 */
    onResultChange() {
      this.$store.commit("setLoginPop", 3);
    },
    /** 前往我的订单、我的收藏 */
    goMyOther(index) {
      if (index == 1) {
        // 前往我的订单
        this.goSubPage("MyOrder", "/home/myorder");
      } else {
        // 前往我的收藏
        this.goSubPage("MyCollection", "/home/myCollection");
      }
    },
    /** 前往购物车 */
    goShoppingCarEvent() {
      this.goSubPage("MyShoppingCar", "/home/myShoppingCar");
    },
    /** 路由导航 */
    goSubPage(routeName, routePath) {
      if (this.$route.name != routeName) {
        this.$router.push({
          path: routePath,
        });
      }
    },
    /** 二级tab栏点击事件 */
    selectSecondTab(item) {
      console.log(item);
      let currentRouteName = this.$route.name;
      if (item.routName !== currentRouteName) {
        if (item.name === "全部商品") {
          this.$router.push({
            path: "/home/allShopping",
            query: {
              id: "0",
            },
          });
        } else {
          this.$router.push({
            name: item.routName,
          });
        }
      }
    },

    /** 二级tab栏鼠标移入 */
    secondMouseMove(item) {
      this.secondTabMouseName = item.routName;
    },
    /** 二级tab栏鼠标移出 */
    secondMouseLeave() {
      this.secondTabMouseName = null;
    },
    exitCancel() {
      this.exitLoginPop = false;
    },
    exitSubmit() {
      this.exitLoginPop = false;
      removeCookie("token");
      this.$store.commit("setLoginState", false);
      this.$notify.success({
        message: "退出登录成功",
      });
    },
  },
};
</script>

<style lang="scss" scoped>
// 顶部tab栏
.home-head-state {
  box-sizing: border-box;
  width: 100%;
  height: 42px;
  background-color: #3d3d3d;
  .home-head-state-content {
    box-sizing: border-box;
    max-width: 1200px;
    height: 100%;
    margin: 0;
    padding: 0;
    // background-color: red;
    margin: auto;
    display: flex;
    justify-content: flex-end;
    .home-head-state-content-item {
      box-sizing: border-box;
      height: 100%;
      padding-left: 18px;
      padding-right: 18px;
      line-height: 42px;
      display: flex;
      align-items: center;
      justify-content: center;
      .home-head-state-content-item-shopping-car {
        display: flex;
        align-items: center;
        img {
          margin-right: 8px;
        }
      }
    }
  }
}
// 二级tab栏
.home-head-second {
  box-sizing: border-box;
  width: 100%;
  height: 80px;
  .home-head-second-content {
    box-sizing: border-box;
    height: 100%;
    margin: auto;
    max-width: 1200px;
    min-width: 800px;
    // background-color: yellow;
    border-bottom: 1px solid #e6e6e6;
    display: flex;
    align-items: flex-end;
    // logo
    .hhsc-left {
      width: 186px;
      height: 60px;
      img {
        width: 100%;
        height: 100%;
      }
    }
    // tab
    .hhsc-center {
      box-sizing: border-box;
      margin-left: 102px;
      flex-grow: 1;
      //   background-color: red;
      height: 100%;
      display: flex;
      align-items: flex-end;
      .hhsc-center-item {
        box-sizing: border-box;
        height: 38px;
        // background-color: yellow;
        padding-left: 20px;
        padding-right: 20px;
        text-align: center;
        font-weight: 400;
        font-size: 14px;
        color: #909399;
        position: relative;
        min-width: 68px;
        cursor: pointer;
        .hhsc-center-item-underline {
          width: 68px;
          height: 2px;
          background-color: #409eff;
          position: absolute;
          bottom: 0;
          left: calc((100% - 68px) / 2);
        }
      }
    }
    // 搜索框
    .hhsc-right {
      box-sizing: border-box;
      width: 300px;
      height: 100%;
      //   background-color: green;
      display: flex;
      align-items: flex-end;
      padding-bottom: 10px;
      .hhsc-right-searchbox {
        box-sizing: border-box;
        width: 100%;
        height: 40px;
        // background-color: red;
        border: 1px solid #dcdfe6;
        border-radius: 4px;
      }
    }
  }
}
// 二级页面
.second-view {
  box-sizing: border-box;
  width: 100%;
  min-height: 100px;
  margin: auto;
}
// 底部
.foot-mod {
  box-sizing: border-box;
  width: 100%;
  height: 336px;
  background-color: #2f2f2f;
  .foot-mod-main {
    box-sizing: border-box;
    max-width: 1200px;
    min-width: 1000px;
    height: 100%;
    margin: auto;
    .foot-mod-main-content {
      box-sizing: border-box;
      height: 100%;
      margin: auto;
      .foot-mod-main-content-top {
        box-sizing: border-box;
        width: 100%;
        display: flex;
        justify-content: space-between;
        .foot-mod-main-content-top-item {
          width: 100%;
          display: flex;
          justify-content: center;
          align-items: center;
          padding-top: 54px;
          img {
            width: 42px;
            height: 42px;
            margin-right: 10px;
          }
          span {
            font-weight: 500;
            font-size: 20px;
            color: #ffffff;
          }
        }
      }
      .foot-mod-main-content-bottom {
        box-sizing: border-box;
        width: 100%;
        margin-top: 74px;
        display: flex;
        flex-flow: column;
        align-items: center;
        img {
          width: 48px;
          height: 60px;
        }
        span {
          font-weight: 400;
          font-size: 16px;
          line-height: 100%;
          text-align: center;
          color: #888888;
          margin-top: 26px;
        }
      }
    }
  }
}

// 头部状态栏默认样式
.hhst {
  font-weight: 400;
  font-size: 14px;
  line-height: 100%;
  color: #b0b0b0;
  &:hover {
    color: #ffffff;
    cursor: pointer;
  }
}

.hhst-icon {
  font-weight: 400;
  font-size: 14px;
  line-height: 100%;
  color: #b0b0b0;
}

// 遮盖层
.mask-view {
  width: 100%;
  height: 100vh;
  background-color: #000000;
  opacity: 0.5;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 100;
}

.login-pop {
  width: 100%;
  height: 100vh;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 120;
}
</style>