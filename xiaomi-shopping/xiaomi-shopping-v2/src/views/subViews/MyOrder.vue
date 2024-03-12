<template>
  <div class="myorder-mod">
    <threeNav
      :icon="require('../../assets/myorder_icon.png')"
      :title="'我的订单'"
      :dis="''"
    ></threeNav>

    <!-- 展示内容 -->
    <div class="myorder-mod-main">
      <div class="myorder-mod-main-content">
        <div class="myorder-mod-main-content-center">
          <!-- 有数据 -->
          <ul
            class="myorder-mod-main-content-center-render"
            v-show="state == 2"
          >
            <li
              v-for="(item, index) in orderDataList"
              :key="item.orderId"
              :style="{
                marginBottom: index == orderDataList.length - 1 ? '0' : '40px',
              }"
            >
              <div class="mmmccr-top">
                <span class="mmmccr-top-ordernumer"
                  >订单编号:{{ item.orderNum }}</span
                >
                <span class="mmmccr-top-ordertime"
                  >订单时间:{{ item.orderTime }}</span
                >
              </div>
              <div class="mmmccr-info">
                <div
                  class="mmmccr-info-item"
                  v-for="(infoItem, infoIndex) in item.products"
                  :key="infoIndex"
                  :style="infoStyle(infoIndex)"
                >
                  <!-- 封面 -->
                  <div class="mmmccr-info-item-cover text-style">
                    <img
                      v-if="infoIndex != 0"
                      :src="infoItem.productPicture"
                      alt=""
                      @click="goShoppingInfoEvent(infoItem)"
                    />
                  </div>
                  <!-- 商品名称 -->
                  <div class="mmmccr-info-item-name">
                    <span
                      @mousemove="mousemove(infoItem, infoIndex)"
                      @mouseleave="mouseleave"
                      @click="goNameShoppingInfoEvent(infoItem, infoIndex)"
                      :style="{
                        color: shoppingColor(infoItem, infoIndex),
                        cursor: shoppingCursor(infoItem, infoIndex),
                      }"
                    >
                      {{ infoIndex == 0 ? "商品名称" : infoItem.productName }}
                    </span>
                  </div>
                  <!-- 单价 -->
                  <div class="mmmccr-info-item-price text-style">
                    {{
                      infoIndex == 0
                        ? "单价"
                        : infoItem.productSellingPrice + "元"
                    }}
                  </div>
                  <!-- 数量 -->
                  <div class="mmmccr-info-item-number text-style">
                    {{ infoIndex == 0 ? "数量" : infoItem.num }}
                  </div>
                  <!-- 小计 -->
                  <div
                    class="mmmccr-info-item-j"
                    :style="{ color: infoIndex == 0 ? '#333333' : '#FF6700' }"
                  >
                    {{
                      infoIndex == 0
                        ? "小计"
                        : infoItem.num * infoItem.productSellingPrice + "元"
                    }}
                  </div>
                </div>
              </div>
              <div class="mmmccr-o">
                <div class="mmmccr-o-totalnumber">
                  共<span> {{ item.shoppingNum }} </span>件商品
                </div>
                <div class="mmmccr-o-total">
                  <span>合计：</span>{{ item.shoppingMoney }}元
                </div>
              </div>
            </li>
          </ul>
          <!-- 无数据 -->
          <div
            class="myorder-mod-main-content-center-notdata"
            v-show="state == 1"
          >
            <default-page
              :title="'您的购物车还是空的！'"
              :dis="'快去购物吧！'"
              :icon="require('../../assets/myorder_notdata.png')"
            ></default-page>
          </div>
          <!-- 加载失败 -->
          <div
            class="myorder-mod-main-content-center-error"
            v-show="state == 3"
          >
            加载失败～
          </div>
        </div>
      </div>
    </div>
  </div>
</template>


<script>
import ThreeNav from "@/components/ThreeNav.vue";
import DefaultPage from "@/components/DefaultPage";
import { getOrder } from "@/api/home";
export default {
  name: "MyOrder",
  components: {
    ThreeNav,
    DefaultPage,
  },
  computed: {
    infoStyle() {
      return (index) => {
        return {
          height: index == 0 ? "85px" : "119px",
          borderBottomColor: index == 0 ? "#DCDFE6" : "#FF6700",
        };
      };
    },
    shoppingColor() {
      return (item, infoIndex) => {
        if (this.currentTypeIndex == 0) {
          return "#333333";
        } else {
          if (item.orderDtlId == this.currentShoppingId) {
            if (infoIndex == 0) {
              return "#333333";
            }
            return "#FF6700";
          } else {
            return "#333333";
          }
        }
      };
    },
    shoppingCursor() {
      return (item, infoIndex) => {
        if (this.currentTypeIndex == 0) {
          return "auto";
        } else {
          if (item.orderDtlId == this.currentShoppingId) {
            if (infoIndex == 0) {
              return "auto";
            }
            return "pointer";
          } else {
            return "auto";
          }
        }
      };
    },
  },
  watch: {
    "$store.state.loginState"(val) {
      if (val) {
        // 已登录
        this.getOrderData();
      } else {
        // 未登录
        this.state = 1;
      }
    },
  },
  data() {
    return {
      /** state：0-加载中  1-无数据  2-有数据  3-加载失败 */
      state: 2,
      /** 订单数据 */
      orderDataList: [],
      /** 鼠标移入-商品名称-商品id */
      currentShoppingId: null,
      currentTypeIndex: null,
    };
  },
  created() {
    this.getOrderData();
  },
  methods: {
    /** 获取我的订单列表 */
    getOrderData() {
      getOrder()
        .then((res) => {
          // 无数据
          if (res.data.length == 0) {
            this.state = 1
          } else {
            // 有数据
            this.orderDataList = JSON.parse(JSON.stringify(res.data));
            this.orderDataList.forEach((item) => {
              // 商品数量
              var shoppingNum = 0;
              // 合计金额
              var shoppingMoney = 0;
              item.products.forEach((shoppingItem) => {
                shoppingNum++;
                shoppingMoney =
                  shoppingMoney +
                  shoppingItem.num * shoppingItem.productSellingPrice;
              });
              item.shoppingNum = shoppingNum;
              item.shoppingMoney = shoppingMoney;
              let options = {
                num: 0,
                orderDtlId: null,
                productId: null,
                productName: null,
                productPicture: null,
                productSellingPrice: null,
              };
              // 此处的操作可能某些小可爱看不懂，因为数据源遍历的时候，我将列表的头部也算作一个数据，所有这里插入一个空数据对象
              item.products.unshift(options);
            });
            this.state = 2
          }
        })
        .catch((error) => {
          this.state = 3;
          this.$notify.error({
            message: "数据获取失败",
          });
        });
    },
    /** 前往商品详情 */
    goShoppingInfoEvent(item) {
      let shoppingId = item.productId;
      this.$router.push({
        path: "/home/shoppingInfo",
        query: {
          id: shoppingId,
        },
      });
    },
    goNameShoppingInfoEvent(item, index) {
      let shoppingId = item.productId;
      if (index >= 1) {
        this.$router.push({
          path: "/home/shoppingInfo",
          query: {
            id: shoppingId,
          },
        });
      }
    },
    /** 鼠标移入-商品名称 */
    mousemove(item, infoIndex) {
      this.currentShoppingId = item.orderDtlId;
      this.currentTypeIndex = infoIndex;
    },
    /** 鼠标移出 */
    mouseleave() {
      this.currentShoppingId = null;
      this.currentTypeIndex = null;
    },
  },
};
</script>


<style lang="scss" scoped>
.myorder-mod-main {
  box-sizing: border-box;
  width: 100%;
  background-color: #ffffff;
  padding-bottom: 24px;
}
.myorder-mod-main-content {
  box-sizing: border-box;
  width: 100%;
  background-color: #f5f5f5;
}
.myorder-mod-main-content-center {
  box-sizing: border-box;
  width: 1200px;
  margin: auto;
}
// 加载失败
.myorder-mod-main-content-center-error {
  width: 100%;
  height: 598px;
  box-sizing: border-box;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 30px;
  font-weight: 600;
}
// 无数据
.myorder-mod-main-content-center-notdata {
  box-sizing: border-box;
}
// 有数据
ul {
  width: 100%;
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  list-style-type: none;
  padding-top: 24px;
  padding-bottom: 36px;
  li {
    width: 100%;
    // height: 314px;
    // background-color: yellowgreen;
    box-sizing: border-box;
    background-color: #ffffff;
    .mmmccr-top {
      box-sizing: border-box;
      width: 100%;
      height: 61px;
      border-bottom: 1px solid #ff6700;
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding-left: 28px;
      padding-right: 8px;
      .mmmccr-top-ordernumer {
        font-weight: 400;
        font-size: 16px;
        line-height: 100%;
        color: #ff6700;
      }
      .mmmccr-top-ordertime {
        font-weight: 400;
        font-size: 16px;
        line-height: 100%;
        color: #333333;
      }
    }
    .mmmccr-info {
      width: 100%;
      box-sizing: border-box;
      .mmmccr-info-item {
        box-sizing: border-box;
        width: 100%;
        border-bottom-width: 1px;
        border-bottom-style: solid;
        padding-left: 78px;
        padding-right: 92px;
        display: flex;
        align-items: center;
        // 封面
        .mmmccr-info-item-cover {
          width: 90px;
          height: 100%;
          margin-right: 32px;
          flex-grow: 0;
          flex-shrink: 0;
          img {
            width: 90px;
            height: 90px;
            cursor: pointer;
          }
        }
        // 商品名称
        .mmmccr-info-item-name {
          box-sizing: border-box;
          flex-grow: 1;
          height: 100%;
          font-weight: 400;
          font-size: 16px;
          color: #333333;
          display: flex;
          align-items: center;
          justify-content: left;
          cursor: pointer;
        }
        // 单价
        .mmmccr-info-item-price {
          box-sizing: border-box;
          width: 178px;
          height: 100%;
          margin-right: 18px;
          flex-grow: 0;
          flex-shrink: 0;
        }
        // 数量
        .mmmccr-info-item-number {
          box-sizing: border-box;
          width: 190px;
          height: 100%;
          flex-grow: 0;
          flex-shrink: 0;
        }
        // 小计
        .mmmccr-info-item-j {
          box-sizing: border-box;
          width: 238px;
          height: 100%;
          flex-grow: 0;
          flex-shrink: 0;
          font-weight: 500;
          font-size: 16px;
          color: #ff6700;
          display: flex;
          justify-content: right;
          align-items: center;
        }
      }
    }
    .mmmccr-o {
      box-sizing: border-box;
      width: 100%;
      height: 49px;
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding-left: 20px;
      padding-right: 10px;
      .mmmccr-o-totalnumber {
        font-weight: 400;
        font-size: 16px;
        line-height: 110%;
        color: #606266;
        span {
          color: #ff6700;
        }
      }
      .mmmccr-o-total {
        font-weight: 500;
        font-size: 30px;
        line-height: 100%;
        color: #ff6700;
        span {
          font-size: 14px;
          font-weight: 400;
        }
      }
    }
  }
}

.text-style {
  display: flex;
  justify-content: center;
  align-items: center;
  font-weight: 500;
  font-size: 16px;
  color: #333333;
}
</style>