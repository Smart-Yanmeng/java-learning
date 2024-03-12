<template>
  <div class="mycollection-mod">
    <!-- 头部 -->
    <threeNav
      :icon="require('../../assets/mycollection.png')"
      :title="'我的收藏'"
      :dis="'温馨提示：商品是否购买成功，以最终下单为准哦，请尽快结算'"
    ></threeNav>
    <div class="mycollection-mod-content">
      <div class="mycollection-mod-content-main">
        <div class="mycollection-mod-content-main-just">
          <!-- 有数据 -->
          <div class="mycollection-mod-content-render" v-if="state == 2">
            <ul :style="{ gridTemplateRows: `repeat(${gridLine},300px)` }">
              <li v-for="(item, index) in dataList" :key="index" @click="goShoppingInfo(item)">
                <el-image
                  :src="item.productPicture"
                  lazy
                  style="width: 160px; height: 160px"
                ></el-image>
                <span class="allshopping-mod-content-main-item-name"
                  >{{ item.productName }}
                </span>
                <span class="allshopping-mod-content-main-item-dis">{{
                  item.productTitle
                }}</span>
                <div class="allshopping-mod-content-main-item-price">
                  <span class="amcmip-onwprice">{{ item.productPrice }}元</span>
                  <span class="amcmip-newprice"
                    >{{ item.productSellingPrice }}元</span
                  >
                </div>
              </li>
            </ul>
          </div>
          <!-- 无数据 -->
          <div class="mycollection-mod-content-notdata" v-else-if="state == 1">
            <!-- <img src="../../assets/mycollection_notdata.png" alt="" />
            <div class="mycollection-mod-content-notdata-right">
              <div class="mmcnr-text">您的收藏还是空的！</div>
              <div class="mmcnr-go">快去购物吧！</div>
            </div> -->
            <default-page
              :title="'您的收藏还是空的！'"
              :dis="'快去购物吧！'"
              :icon="require('../../assets/mycollection_notdata.png')"
            ></default-page>
          </div>
          <!-- 加载失败 -->
          <div class="mycollection-mod-content-error" v-else-if="state == 3">
            加载失败～
          </div>
          <!-- 加载中 -->
          <div class="myshoppingcar-mod-content-loading" v-else>加载中...</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ThreeNav from "@/components/ThreeNav.vue";
import DefaultPage from "@/components/DefaultPage";
import { getCollect } from "@/api/home";
export default {
  name: "MyCollection",
  components: {
    ThreeNav,
    DefaultPage,
  },
  watch: {
    "$store.state.loginState"(val) {
      if (val) {
        // 已登录
        this.getCollectData();
      } else {
        // 未登录
        this.state = 1;
      }
    },
  },
  data() {
    return {
      /** 当前页面展示状态  0：加载中  1：无数据   2：有数据  3：加载失败 */
      state: 0,
      /** 数据动态行数 */
      gridLine: 0,
      /** 页面信息 */
      dataList: [],
    };
  },
  created() {
    this.getCollectData();
  },
  methods: {
    // 获取我的收藏数据
    getCollectData() {
      getCollect()
        .then((res) => {
          if (res.data.length == 0) {
            this.state = 1
          } else {
            this.state = 2
            this.dataList = res.data;
            this.gridLine = Math.ceil(this.dataList.length / 5);
          }
        })
        .catch((error) => {
          this.state = 3;
          console.log(error);
          this.$notify.error({
            message: "数据获取失败",
          });
        });
    },
    /** 前往商品详情 */
    goShoppingInfo(item){
      this.$router.push({
        path:'/home/shoppingInfo',
        query:{
          id:item.productId
        }
      })
    }
  },
};
</script>

<style lang="scss" scoped>
.mycollection-mod {
  box-sizing: border-box;
  width: 100%;
  background-color: #f5f5f5;
  // 展示内容
  .mycollection-mod-content {
    box-sizing: border-box;
    width: 100%;
    padding-bottom: 24px;
    background-color: #ffffff;
    .mycollection-mod-content-main {
      width: 100%;
      box-sizing: border-box;
      background: #f5f5f5;
      .mycollection-mod-content-main-just {
        width: 1200px;
        box-sizing: border-box;
        margin: auto;
        background-color: #f5f5f5;
      }
    }
  }
  // 无数据
  .mycollection-mod-content-notdata {
    width: 100%;
    box-sizing: border-box;
  }

  // 有数据
  .mycollection-mod-content-render {
    box-sizing: border-box;
    width: 100%;
    padding-top: 14px;
    padding-bottom: 24px;
    //   padding-bottom: 24px;
    ul {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
      display: grid;
      list-style-type: none;
      grid-template-columns: 232px 232px 232px 232px 232px;
      // grid-template-rows: 300px 300px;
      align-content: space-between;
      justify-content: space-between;
      row-gap: 10px;
      li {
        width: 232px;
        height: 300px;
        box-sizing: border-box;
        padding-top: 14px;
        // margin-bottom: 10px;
        background-color: #ffffff;
        cursor: pointer;
        transition: 0.5s;
        display: flex;
        flex-flow: column;
        align-items: center;
        .allshopping-mod-content-main-item-name {
          font-weight: 400;
          font-size: 14px;
          line-height: 100%;
          text-align: center;
          letter-spacing: 0.2px;
          color: #333333;
          margin-top: 24px;
        }
        .allshopping-mod-content-main-item-dis {
          font-weight: 500;
          font-size: 12px;
          line-height: 100%;
          text-align: center;
          letter-spacing: 0.1px;
          color: #b0b0b0;
          margin-top: 14px;
        }
        .allshopping-mod-content-main-item-price {
          width: 100%;
          display: flex;
          justify-content: center;
          align-items: center;
          margin-top: 12px;
          .amcmip-onwprice {
            font-weight: 500;
            font-size: 16px;
            line-height: 100%;
            text-align: center;
            letter-spacing: 0.1px;
            color: #ff6700;
            margin-right: 8px;
          }
          .amcmip-newprice {
            font-weight: 500;
            font-size: 16px;
            line-height: 100%;
            text-align: center;
            color: #b0b0b0;
            text-decoration: line-through;
          }
        }
        &:hover {
          box-shadow: 0px 10px 22px rgba(132, 132, 132, 0.25);
          transform: translateY(-2px);
        }
      }
    }
  }
  // 加载失败
  .mycollection-mod-content-error {
    width: 100%;
    height: 598px;
    box-sizing: border-box;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 30px;
    font-weight: 600;
  }
  // 加载中
  .myshoppingcar-mod-content-loading {
    width: 100%;
    height: 500px;
    box-sizing: border-box;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 30px;
    color: #b0b0b0;
    font-weight: 600;
  }
}
</style>