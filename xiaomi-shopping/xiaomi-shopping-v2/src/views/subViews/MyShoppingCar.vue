<template>
  <div class="myshoppingcar-mod">
    <!-- 头部 -->
    <threeNav
      :icon="require('../../assets/myshopping-car.png')"
      :title="'我的购物车'"
      :dis="'温馨提示：商品是否购买成功，以最终下单为准哦，请尽快结算'"
    ></threeNav>
    <!-- 内容 -->
    <div
      class="myshoppingcar-mod-content"
      :style="{ minHeight: state == 0 ? '400px' : '0' }"
    >
      <div class="myshoppingcar-mod-content-main">
        <div class="myshoppingcar-mod-content-main-just">
          <!-- 无数据 -->
          <div class="myshoppingcar-mod-content-notdata" v-if="state == 1">
            <default-page
              :title="'您的购物车还是空的！'"
              :dis="'快去购物吧！'"
              :icon="require('../../assets/myshopping_car_notdata.png')"
            ></default-page>
          </div>
          <!-- 有数据 -->
          <div class="myshoppingcar-mod-content-render" v-else-if="state == 2">
            <div class="myshoppingcar-mod-content-render-mian">
              <!-- 头部 -->
              <div class="myshoppingcar-mod-content-render-mian-head">
                <!-- 全选 -->
                <div class="mmcrmh-all">
                  <div
                    @click="allSelectEvent"
                    :style="{
                      backgroundColor:
                        selectShoppingCarNum == myShoppingCarNum &&
                        selectShoppingCarNum != 0 &&
                        myShoppingCarNum != 0
                          ? '#FF6700'
                          : '#ffffff',
                      borderWidth:
                        selectShoppingCarNum == myShoppingCarNum &&
                        selectShoppingCarNum != 0 &&
                        myShoppingCarNum != 0
                          ? '0'
                          : '1px',
                    }"
                  >
                    <img
                      src="../../assets/select.png"
                      alt=""
                      v-show="
                        selectShoppingCarNum == myShoppingCarNum &&
                        selectShoppingCarNum != 0 &&
                        myShoppingCarNum != 0
                      "
                    />
                  </div>
                  <span>全选</span>
                </div>
                <!-- 封面 -->
                <div class="mmcrmh-cover"></div>
                <!-- 商品名称 -->
                <div class="mmcrmh-name">商品名称</div>
                <!-- 单价 -->
                <div class="mmcrmh-price">单价</div>
                <!-- 数量 -->
                <div class="mmcrmh-number">数量</div>
                <!-- 小计 -->
                <div class="mmcrmh-subtotal">小计</div>
                <!-- 操作 -->
                <div class="mmcrmh-operation">操作</div>
              </div>
              <!-- 列表 -->
              <div class="myshoppingcar-mod-content-render-mian-list">
                <ul>
                  <li v-for="(item, index) in shoppingCarDataList" :key="index">
                    <!-- 单选 -->
                    <div class="mmcrml-select">
                      <div
                        @click="shoppingSelect(item)"
                        :style="selectStyle(item)"
                      >
                        <img
                          src="../../assets/select.png"
                          alt=""
                          v-show="isShowSelectImg(item)"
                        />
                      </div>
                    </div>
                    <!-- 封面 -->
                    <div class="mmcrml-cover" @click="goShoppingInfo(item)">
                      <img :src="item.productPicture" alt="" />
                    </div>
                    <!-- 商品名称 -->
                    <div class="mmcrml-name" @click="goShoppingInfo(item)">{{ item.productName }}</div>
                    <!-- 单价 -->
                    <div class="mmcrml-price">
                      {{ item.productSellingPrice }}元
                    </div>
                    <!-- 数量 -->
                    <div class="mmcrml-number">
                      <el-input-number
                        v-model="item.num"
                        @change="(val) => handleChange(val, item)"
                        :min="1"
                        :max="10"
                        label="描述文字"
                        style="height: 32px"
                      ></el-input-number>
                    </div>
                    <!-- 小计 -->
                    <div class="mmcrml-subtotal">
                      {{ item.productSellingPrice * item.num }}元
                    </div>
                    <!-- 操作 -->
                    <div class="mmcrml-operation">
                      <img
                        src="../../assets/shopping_car_close.png"
                        alt=""
                        @click="deletShoppingEvent(item)"
                      />
                      <!-- 是否删除 -->
                      <div
                        class="mmcrml-operation-pop"
                        :style="{
                          width: deleteStyleWidth(item),
                          boxShadow: deleteStyleBoxShaow(item),
                          padding: deleteStylePadding(item),
                        }"
                      >
                        <div class="mmcrml-operation-pop-title">
                          确定要删除吗？
                        </div>
                        <div class="mmcrml-operation-pop-bottom">
                          <div
                            @click.stop="subDeleteEvent(item)"
                            :style="{ width: commitStyle(item) }"
                          >
                            确定
                          </div>
                        </div>
                      </div>
                    </div>
                  </li>
                </ul>
              </div>
            </div>
            <div class="myshoppingcar-mod-content-render-bottom">
              <div class="mmcrb-statistics">
                <div class="mmcrbs-nav" @click="goShoppingEvent">继续购物</div>
                <span></span>
                <div class="mmcrbs-menu">
                  共<span> {{ myShoppingCarNum }} </span>件商品，已选择<span>
                    {{ selectShoppingCarNum }} </span
                  >件
                </div>
              </div>
              <div class="mmcrb-settlement">
                <div class="mmcrb-settlement-total">
                  <span class="mmcrbst-h">合计：</span>
                  <span class="mmcrbst-number">{{ totalPrice }}元</span>
                </div>
                <div
                  class="mmcrb-settlement-gosettlement"
                  :style="{
                    backgroundColor:
                      selectShoppingCarNum == 0 ? '#E0E0E0' : '#FF6700',
                    color: selectShoppingCarNum == 0 ? '#909399' : '#ffffff',
                  }"
                  @click="goSettle"
                >
                  去结算
                </div>
              </div>
            </div>
          </div>
          <!-- 加载失败 -->
          <div class="myshoppingcar-mod-content-error" v-else-if="state == 3">
            加载失败～
          </div>
          <!-- 加载中 -->
          <div class="myshoppingcar-mod-content-loading" v-else>
            加载中...
          </div>
          <!-- 遮盖层 -->
          <div class="mask" v-show="deleteState" @click="maskEvent"></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ThreeNav from "@/components/ThreeNav.vue";
import DefaultPage from "@/components/DefaultPage";
// import Loading from '@/components/Loading'
import {generateOrder} from '@/api/home'
import {
  getShoppingCart,
  deleteShoppingCartNum,
  setShoppingCartNum,
} from "@/api/home";
export default {
  name: "MyShoppingCar",
  components: {
    ThreeNav,
    DefaultPage,
    // Loading
  },
  computed: {
    /** 单选按钮样式 */
    selectStyle() {
      return (item) => {
        return {
          backgroundColor:
            this.selectIdList.indexOf(item.shoppingCartId) != -1
              ? "#FF6700"
              : "#ffffff",
          borderWidth:
            this.selectIdList.indexOf(item.shoppingCartId) != -1 ? "0" : "1px",
        };
      };
    },
    /** 单选按钮打勾图片样式 */
    isShowSelectImg() {
      return (item) => {
        if (this.selectIdList.indexOf(item.shoppingCartId) == -1) {
          return false;
        } else {
          return true;
        }
      };
    },
    /** 删除提示样式 */
    deleteStyleWidth() {
      return (item) => {
        if (this.deleteState) {
          if (item.productId == this.deleteId) {
            return "176px";
          } else {
            return "0";
          }
        } else {
          return "0";
        }
      };
    },
    deleteStyleBoxShaow() {
      return (item) => {
        if (this.deleteState) {
          if (item.productId == this.deleteId) {
            return "0 2px 12px 0 rgb(0 0 0 / 10%)";
          } else {
            return "0 0 0 0";
          }
        } else {
          return "0 0 0 0";
        }
      };
    },
    commitStyle() {
      return (item) => {
        if (this.deleteState) {
          if (item.productId == this.deleteId) {
            return "56px";
          } else {
            return "0";
          }
        } else {
          return "0";
        }
      };
    },
    deleteStylePadding() {
      return (item) => {
        if (this.deleteState) {
          if (item.productId == this.deleteId) {
            return "12px 12px";
          } else {
            return "12px 0";
          }
        } else {
          return "12px 0";
        }
      };
    },
  },
  watch: {
    "$store.state.loginState"(val) {
      if (val) {
        // 已登录
        this.getShoppingCartData();
      } else {
        // 未登录
        this.state = 1;
      }
    },
  },
  data() {
    return {
      /** 当前视图状态  0：加载中  1：无数据  2：有数据  3：加载失败 */
      state: 0,
      /** 购物车列表数据 */
      shoppingCarDataList: [],
      /** 选中的商品的id集合 */
      selectIdList: [],
      /** 选中的商品集合 */
      selectShoppingList: [],
      /** 删除按钮状态 */
      deleteState: false,
      /** 当前删除商品id */
      deleteId: null,
      /** 当前我的购物车商品数量 */
      myShoppingCarNum: 0,
      /** 当前选中的商品数量 */
      selectShoppingCarNum: 0,
      /** 合计 */
      totalPrice: 0,
    };
  },
  created() {
    this.getShoppingCartData();
  },
  methods: {
    /** 查询当前购物车 */
    async getShoppingCartData() {
      try {
        const result = await getShoppingCart();
        if (result.code == 200) {
          let data = JSON.parse(JSON.stringify(result.data));
          this.$store.dispatch("setMyShoppingCarNumDes");
          if (data.length == 0) {
            this.state = 1;
          } else {
            this.state = 2;
            this.shoppingCarDataList = result.data;
            this.myShoppingCarNum = result.data.length;
          }
        } else {
          this.state = 3;
          this.$notify.error({
            message: result.msg,
          });
        }
      } catch (error) {
        this.$notify.error({
          message: "数据获取失败",
        });
      }
    },
    /** 修改商品数量 */
    async setShoppingCartNum(shoppingCartId, num) {
      try {
        let options = {
          shoppingCartId,
          num,
        };
        const result = await setShoppingCartNum(options);
        if (result.code == 200) {
        } else {
          this.$notify.error({
            message: "修改失败",
          });
          await this.getShoppingCartData();
        }
      } catch (error) {
        this.$notify.error({
          message: "修改失败",
        });
      }
    },
    /** 删除商品 */
    async deleteShoppingCartNumData(shoppingCartId) {
      try {
        const result = await deleteShoppingCartNum(shoppingCartId);
        if (result.code == 200) {
          this.$notify.success({
            message: "删除成功",
          });
          await this.getShoppingCartData();
        } else {
          this.$notify.error({
            message: result.msg,
          });
        }
      } catch (error) {
        this.$notify.error({
          message: "删除失败",
        });
      }
    },
    /** 生成订单 */
    setGenerateOrder(){
      let options = this.selectIdList
      // .toString()
      // console.log(options);
      // generateOrder(options).then(res =>{
      //   this.$notify.success({
      //     message:'购买成功'
      //   })
      //   this.getShoppingCartData()
      // }).catch(error =>{
      //   this.$notify.error({
      //     message:'生成订单失败'
      //   })
      // })
      console.log(this.selectShoppingList);
      localStorage.setItem("goodList",JSON.stringify(this.selectShoppingList))
      this.$router.push({name:"ConfirmOrder",params:{goodList:JSON.stringify(this.selectShoppingList)}})
    },
    /** 全选事件 */
    allSelectEvent() {
      if (this.selectIdList.length == this.shoppingCarDataList.length) {
        this.selectIdList = [];
        this.selectShoppingList = [];
        this.selectShoppingCarNum = 0;
      } else {
        this.shoppingCarDataList.forEach((item) => {
          if (this.selectIdList.indexOf(item.shoppingCartId) == -1) {
            this.selectIdList.push(item.shoppingCartId);
            this.selectShoppingList.push(item);
          }
        });
        this.selectShoppingCarNum = this.selectIdList.length;
      }
      this.totalPriceEvent(); //合计
    },
    /** 单选 */
    shoppingSelect(item) {
      console.log(item);
      let shoppingCartId = item.shoppingCartId;
      let index = this.selectIdList.indexOf(shoppingCartId);
      if (index == -1) {
        this.selectIdList.push(shoppingCartId);
        this.selectShoppingList.push(item);
      } else {
        this.selectIdList.splice(index, 1);
        this.selectShoppingList.splice(index, 1);
      }
      this.selectShoppingCarNum = this.selectIdList.length;
      this.totalPriceEvent(); //合计
    },
    /** 删除商品事件 */
    deletShoppingEvent(item) {
      if (this.deleteId == item.productId) {
        if (this.deleteState) {
          // 处于打开状态
          this.deleteState = false;
          this.deleteId = null;
        } else {
          // 处于关闭状态
          this.deleteState = true;
          this.deleteId = item.productId;
        }
      } else {
        this.deleteState = true;
        this.deleteId = item.productId;
      }
    },
    /** 删除商品提交 */
    async subDeleteEvent(item) {
      console.log(item);
      let shoppingCartId = item.shoppingCartId;
      await this.deleteShoppingCartNumData(shoppingCartId);
      this.deleteState = false;
      this.deleteId = null;
    },
    /** 计算商品总价格 */
    totalPriceEvent() {
      this.totalPrice = this.selectShoppingList.reduce(
        (sum, item) => sum + item.num * item.productSellingPrice,
        0
      );
      console.log(this.totalPrice, "zheshi1heji");
    },
    /** 商品计数器 */
    async handleChange(val, item) {
      console.log(val, item);
      let shoppingCartId = item.shoppingCartId;
      let num = val;
      // 计算商品价格
      this.totalPriceEvent()
      await this.setShoppingCartNum(shoppingCartId, num);
    },
    /** 继续购物 */
    goShoppingEvent() {
      this.$router.push({
        path: "/home/allShopping",
      });
    },
    maskEvent() {
      this.deleteState = false;
    },
    /** 前往商品详情 */
    goShoppingInfo(item){
      this.$router.push({
        path:'/home/shoppingInfo',
        query:{
          id:item.productId
        }
      })
    },
    /** 去结算 */
    goSettle(){
      this.setGenerateOrder()
    }
  },
};
</script>

<style lang="scss" scoped>
.myshoppingcar-mod {
  box-sizing: border-box;
  width: 100%;
  background: #f5f5f5;
}
// 内容区
.myshoppingcar-mod-content {
  box-sizing: border-box;
  width: 100%;
  background-color: #ffffff;
  padding-bottom: 24px;
  .myshoppingcar-mod-content-main {
    box-sizing: border-box;
    width: 100%;
    background: #f5f5f5;
    .myshoppingcar-mod-content-main-just {
      box-sizing: border-box;
      width: 1200px;
      margin: auto;
    }
  }
}
// 无数据
.myshoppingcar-mod-content-notdata {
  width: 100%;
  box-sizing: border-box;
}
// 有数据
.myshoppingcar-mod-content-render {
  box-sizing: border-box;
  width: 100%;
  padding-bottom: 24px;
  padding-top: 47px;
  .myshoppingcar-mod-content-render-mian {
    box-sizing: border-box;
    width: 100%;
    // 头部
    .myshoppingcar-mod-content-render-mian-head {
      width: 100%;
      height: 82px;
      box-sizing: border-box;
      padding-left: 24px;
      padding-right: 26px;
      display: flex;
      align-items: center;
      border-bottom: 1px solid #c0c4cc;
      background-color: #ffffff;
      // 全选
      .mmcrmh-all {
        width: 52px;
        height: 100%;
        // background-color: red;
        margin-right: 32px;
        flex-grow: 0;
        flex-shrink: 0;
        display: flex;
        justify-content: space-between;
        align-items: center;
        cursor: pointer;
        div {
          box-sizing: border-box;
          width: 14px;
          height: 14px;
          border: 1px solid #c0c4cc;
          border-radius: 2px;
          display: flex;
          justify-content: center;
          align-items: center;
          img {
            width: 10px;
            height: 10px;
          }
          &:hover {
            border-color: #ff6700;
          }
        }
        span {
          font-weight: 400;
          font-size: 14px;
          line-height: 100%;
          color: #606266;
        }
      }
      // 封面
      .mmcrmh-cover {
        width: 80px;
        height: 100%;
        // background-color: red;
        flex-grow: 0;
        flex-shrink: 0;
        margin-right: 24px;
      }
      // 商品名称
      .mmcrmh-name {
        box-sizing: border-box;
        flex-grow: 1;
        // background-color: blue;
        height: 100%;
        display: flex;
        align-items: center;
        font-weight: 500;
        font-size: 16px;
        line-height: 100%;
        color: #606266;
      }
      // 单价
      .mmcrmh-price {
        width: 158px;
        height: 100%;
        // background-color: orangered;
        font-weight: 500;
        font-size: 16px;
        line-height: 100%;
        color: #606266;
        display: flex;
        align-items: center;
        justify-content: center;
      }
      // 数量
      .mmcrmh-number {
        width: 130px;
        height: 100%;
        // background-color: yellow;
        margin-left: 18px;
        flex-grow: 0;
        flex-shrink: 0;
        font-weight: 500;
        font-size: 16px;
        line-height: 100%;
        color: #606266;
        display: flex;
        align-items: center;
        justify-content: center;
      }
      // 小计
      .mmcrmh-subtotal {
        box-sizing: border-box;
        width: 132px;
        height: 100%;
        padding-left: 20px;
        flex-grow: 0;
        flex-shrink: 0;
        // background-color: yellowgreen;
        font-weight: 500;
        font-size: 16px;
        line-height: 100%;
        color: #606266;
        display: flex;
        justify-content: right;
        align-items: center;
      }
      // 操作
      .mmcrmh-operation {
        width: 32px;
        height: 100%;
        // background-color: red;
        flex-grow: 0;
        flex-shrink: 0;
        margin-left: 104px;
        font-weight: 500;
        font-size: 16px;
        line-height: 100%;
        color: #606266;
        display: flex;
        align-items: center;
        justify-content: center;
      }
    }
    // 列表
    .myshoppingcar-mod-content-render-mian-list {
      box-sizing: border-box;
      width: 100%;
      background-color: #ffffff;
      ul {
        width: 100%;
        box-sizing: border-box;
        margin: 0;
        padding: 0;
        list-style-type: none;
        li {
          box-sizing: border-box;
          width: 100%;
          height: 116px;
          padding-left: 24px;
          padding-right: 26px;
          display: flex;
          align-items: center;
          // 单选
          .mmcrml-select {
            width: 52px;
            height: 100%;
            width: 52px;
            height: 100%;
            // background-color: red;
            margin-right: 32px;
            flex-grow: 0;
            flex-shrink: 0;
            display: flex;
            justify-content: space-between;
            align-items: center;
            cursor: pointer;
            div {
              box-sizing: border-box;
              width: 14px;
              height: 14px;
              border: 1px solid #c0c4cc;
              border-radius: 2px;
              display: flex;
              justify-content: center;
              align-items: center;
              img {
                width: 10px;
                height: 10px;
              }
              &:hover {
                border-color: #ff6700;
              }
            }
          }
          // 封面
          .mmcrml-cover {
            width: 80px;
            height: 100%;
            // background-color: red;
            flex-grow: 0;
            flex-shrink: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            margin-right: 24px;
            cursor: pointer;
            img {
              width: 80px;
              height: 80px;
            }
          }
          // 商品名称
          .mmcrml-name {
            box-sizing: border-box;
            flex-grow: 1;
            // background-color: blue;
            height: 100%;
            display: flex;
            align-items: center;
            font-weight: 500;
            font-size: 16px;
            line-height: 100%;
            color: #606266;
            cursor: pointer;
            &:hover{
              color: #FF6700;
            }
          }
          // 单价
          .mmcrml-price {
            width: 158px;
            height: 100%;
            // background-color: orangered;
            font-weight: 500;
            font-size: 16px;
            line-height: 100%;
            color: #606266;
            display: flex;
            align-items: center;
            justify-content: center;
          }
          // 数量
          .mmcrml-number {
            width: 130px;
            height: 100%;
            // background-color: yellow;
            margin-left: 18px;
            flex-grow: 0;
            flex-shrink: 0;
            font-weight: 500;
            font-size: 16px;
            line-height: 100%;
            color: #606266;
            display: flex;
            align-items: center;
            justify-content: center;
          }
          // 小计
          .mmcrml-subtotal {
            box-sizing: border-box;
            width: 132px;
            height: 100%;
            padding-left: 20px;
            flex-grow: 0;
            flex-shrink: 0;
            // background-color: yellowgreen;
            font-weight: 500;
            font-size: 16px;
            line-height: 100%;
            color: #ff6700;
            display: flex;
            justify-content: right;
            align-items: center;
          }
          // 操作
          .mmcrml-operation {
            width: 32px;
            height: 100%;
            // background-color: red;
            flex-grow: 0;
            flex-shrink: 0;
            margin-left: 104px;
            font-weight: 500;
            font-size: 16px;
            line-height: 100%;
            color: #606266;
            display: flex;
            align-items: center;
            justify-content: center;
            position: relative;
            cursor: pointer;
            img {
              width: 16px;
              height: 16px;
              position: relative;
              z-index: 120;
            }
            .mmcrml-operation-pop {
              box-sizing: border-box;
              width: 176px;
              height: 83px;
              background-color: #ffffff;
              position: absolute;
              top: calc(33 / 2);
              right: 32px;
              transition: 0.3s;
              box-shadow: 1px 3px 8px 5px rgba(132, 132, 132, 0.25);
              overflow: hidden;
              padding: 12px;
              border-radius: 4px;
              display: flex;
              flex-flow: column;
              justify-content: space-between;
              // position: relative;
              z-index: 120;
              .mmcrml-operation-pop-title {
                font-size: 14px;
                color: #606266;
                overflow: hidden;
                white-space: nowrap;
              }
              .mmcrml-operation-pop-bottom {
                display: flex;
                justify-content: right;
                div {
                  width: 56px;
                  height: 28px;
                  border-radius: 4px;
                  background-color: #409eff;
                  font-weight: 500;
                  font-size: 14px;
                  text-align: center;
                  line-height: 28px;
                  color: #ffffff;
                  overflow: hidden;
                  transition: 0.3s;
                  &:hover {
                    opacity: 0.8;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  .myshoppingcar-mod-content-render-bottom {
    box-sizing: border-box;
    width: 100%;
    margin-top: 24px;
    height: 48px;
    background-color: #ffffff;
    display: flex;
    justify-content: space-between;
    align-items: center;
    .mmcrb-statistics {
      height: 100%;
      display: flex;
      align-items: center;
      .mmcrbs-nav {
        font-weight: 400;
        font-size: 16px;
        line-height: 100%;
        color: #606266;
        padding-left: 30px;
        padding-right: 22px;
        cursor: pointer;
        &:hover {
          color: #ff6700;
        }
      }
      span {
        width: 2px;
        height: 20px;
        background-color: #b0b0b0;
        margin-right: 25px;
      }
      .mmcrbs-menu {
        font-weight: 400;
        font-size: 16px;
        line-height: 100%;
        color: #606266;
        span {
          color: #ff6700;
          margin: 0;
          background-color: #ffffff;
        }
      }
    }
    .mmcrb-settlement {
      height: 100%;
      display: flex;
      align-items: center;
      .mmcrb-settlement-total {
        box-sizing: border-box;
        display: flex;
        align-items: flex-end;
        margin-right: 44px;
        .mmcrbst-h {
          font-weight: 400;
          font-size: 14px;
          line-height: 100%;
          color: #ff6700;
        }
        .mmcrbst-number {
          font-weight: 400;
          font-size: 30px;
          line-height: 100%;
          color: #ff6700;
        }
      }
      .mmcrb-settlement-gosettlement {
        width: 200px;
        height: 48px;
        background: #e0e0e0;
        font-weight: 500;
        font-size: 20px;
        line-height: 100%;
        color: #909399;
        text-align: center;
        line-height: 48px;
        cursor: pointer;
      }
    }
  }
}
// 加载失败
.myshoppingcar-mod-content-error {
  width: 100%;
  height: 500px;
  box-sizing: border-box;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 30px;
  font-weight: 600;
  color: #B0B0B0;
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
  color: #B0B0B0;
  font-weight: 600;
}

.mask {
  box-sizing: border-box;
  width: 100%;
  height: 100vh;
  opacity: 0.5;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 100;
}
</style>