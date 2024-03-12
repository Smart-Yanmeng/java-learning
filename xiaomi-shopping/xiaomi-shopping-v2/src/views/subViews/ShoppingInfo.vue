<template>
  <div class="shopping-info-mod">
    <!-- 头部 -->
    <div class="shopping-info-mod-head">
      <div class="shopping-info-mod-head-content">
        <span>Redmi K30</span>
        <ul>
          <li v-for="(item, index) in 3" :key="index">
            {{ index === 0 ? "概述" : index === 1 ? "参数" : "用户评价" }}
          </li>
        </ul>
      </div>
    </div>
    <!-- 内容区 -->
    <div class="shopping-info-mod-mian">
      <div class="shopping-info-mod-mian-content">
        <!-- 轮播图 -->
        <div class="shopping-info-mod-mian-content-banner">
          <el-carousel height="532px">
            <el-carousel-item v-for="item in bannerData" :key="item.pictureId">
              <img
                :src="item.productPicture"
                alt="图片加载失败"
                style="width: 520px; height: 518px"
              />
            </el-carousel-item>
          </el-carousel>
        </div>
        <!-- 详情介绍 -->
        <div class="shopping-info-mod-mian-content-info">
          <span>{{ dataInfo.productName ? dataInfo.productName : "" }}</span>
          <div class="shopping-info-mod-mian-content-info-dis">
            {{ dataInfo.productIntro ? dataInfo.productIntro : "" }}
          </div>
          <span class="shopping-info-mod-mian-content-info-type">小米自营</span>
          <div class="shopping-info-mod-mian-content-info-price">
            <span class="simmcip-onwprice"
              >{{
                dataInfo.productSellingPrice
                  ? dataInfo.productSellingPrice
                  : ""
              }}元</span
            >
            <span class="simmcip-oldprice"
              >{{ dataInfo.productPrice ? dataInfo.productPrice : "" }}元</span
            >
          </div>
          <div class="shopping-info-mod-mian-content-info-underline"></div>
          <div class="shopping-info-mod-mian-content-info-paymentprice">
            <div class="simmcip-top">
              <span>{{ dataInfo.productName }}</span>
              <span
                >{{ dataInfo.productSellingPrice }}元
                <span>{{ dataInfo.productPrice }}元</span></span
              >
            </div>
            <div class="simmcip-total">
              总计：{{ dataInfo.productSellingPrice }}
            </div>
          </div>
          <div class="shopping-info-mod-mian-content-info-bottom">
            <div
              class="shopping-info-mod-mian-content-info-bottom-add"
              @click="addShoppingCarEvent"
            >
              加入购物车
            </div>
            <div
              class="shopping-info-mod-mian-content-info-bottom-like"
              @click="likeEvent"
            >
              {{isCollect == 1?'取消收藏':'收藏'}}
            </div>
          </div>
          <div class="shopping-info-mod-mian-content-info-other">
            <div
              v-for="(otherItem, otherIndex) in otherInfo"
              :key="otherIndex"
              class="simmcio-item"
            >
              <img src="../../assets/shoppingInfo/close.png" alt="" />
              <span>{{ otherItem }}</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import {
  getShoppingInfo,
  getCollect,
  setCollect,
  setShoppingCart,
} from "@/api/home";
export default {
  name: "ShoppingInfo",
  data() {
    return {
      // 数据源
      dataInfo: {},
      // 轮播图数据
      bannerData: null,
      otherInfo: ["小米自营", "小米发货", "7天无理由退货", "7天价格保护"],
      shoppingId: null,
      shoppingCarData: [],
      num: 0,
      // shoppingCollectData: [],
      shoppingCartId: null,
      isCollect:false
    };
  },
  created() {
    this.shoppingId = this.$route.query.id;
    this.getShoppingInfoData();
  },
  methods: {
    /** 获取当前商品详情数据 */
    async getShoppingInfoData() {
      try {
        const result = await getShoppingInfo(this.shoppingId);
        if (result.code == 200) {
          this.dataInfo = result.data;
          this.isCollect = this.dataInfo.isCollect
          this.bannerData = JSON.parse(JSON.stringify(this.dataInfo.pictures));
        } else {
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
    /** 收藏、取消收藏 */
    async setCollectData(type, shoppingId) {
      try {
        const result = await setCollect(shoppingId);
        if (result.code == 200) {
          if (type == 1) {
            this.isCollect = 1
            this.$notify.success({
              message: "收藏成功",
            });
          } else {
            this.isCollect = 0
            this.$notify.success({
              message: "取消收藏",
            });
          }
        } else {
          this.$notify.error({
            message: result.msg,
          });
        }
      } catch (error) {
        console.log(error);
        this.$notify.error({
          message: "操作失败",
        });
      }
    },
   
    /** 添加购物车商品 */
    async setShoppingCartData(productId) {
      let options = {
        productId,
      };
      try {
        const result = await setShoppingCart(options);
        if (result.code == 200) {
          this.$store.dispatch('setMyShoppingCarNumDes')
          this.$notify.success({
            message: "商品添加成功",
          });
        } else {
          this.$notify.error({
            message: result.msg,
          });
        }
      } catch (error) {
        console.log(error);
        this.$notify.error({
          message: "商品添加失败",
        });
      }
    },
    /** 加入购物车 */
    addShoppingCarEvent() {
      this.setShoppingCartData(this.shoppingId);
    },
    /** 喜欢 */
    likeEvent() {
      if(this.isCollect == 1){
        // 已收藏
        this.setCollectData(2,this.shoppingId);
      }else{
        // 未收藏
        this.setCollectData(1,this.shoppingId);
      }
    },
  },
};
</script>

<style lang="scss" scoped>
/deep/.el-carousel__indicator {
  button {
    background: #dcdfe6;
    &:hover {
      background: #b0b0b0;
    }
  }
}
/deep/.is-active {
  button {
    background: #b0b0b0;
  }
}
.shopping-info-mod {
  box-sizing: border-box;
  width: 100%;
  background-color: #ffffff;
  // 头部
  .shopping-info-mod-head {
    box-sizing: border-box;
    width: 100%;
    height: 62px;
    box-shadow: 0px 4px 10px rgba(148, 148, 148, 0.25);
    position: relative;
    z-index: 100;
    .shopping-info-mod-head-content {
      box-sizing: border-box;
      max-width: 1200px;
      min-width: 800px;
      height: 100%;
      margin: auto;
      display: flex;
      align-items: center;
      justify-content: space-between;
      div {
        font-weight: 500;
        font-size: 18px;
        line-height: 100%;
        color: #333333;
      }
      ul {
        box-sizing: border-box;
        display: flex;
        align-items: center;
        list-style-type: none;
        display: flex;
        align-items: center;
        li {
          margin-left: 20px;
          font-weight: 400;
          font-size: 14px;
          line-height: 100%;
          color: #606266;
          cursor: pointer;
          &:hover {
            color: #ff6700;
          }
        }
      }
    }
  }
  // 内容区
  .shopping-info-mod-mian {
    box-sizing: border-box;
    width: 100%;
    .shopping-info-mod-mian-content {
      box-sizing: border-box;
      width: 1200px;
      background-color: #ffffff;
      margin: auto;
      padding-top: 48px;
      display: flex;
      justify-content: space-between;
      align-items: flex-start;
      padding-bottom: 39px;
      .shopping-info-mod-mian-content-banner {
        width: 520px;
        height: 532px;
        // background-color: red;
        flex-grow: 0;
        flex-shrink: 0;
      }
      .shopping-info-mod-mian-content-info {
        box-sizing: border-box;
        flex-grow: 1;
        // height: 532px;
        // background-color: yellow;
        margin-left: 64px;
        min-height: 532px;
        span {
          font-weight: 400;
          font-size: 24px;
          line-height: 120%;
          color: #333333;
        }
        .shopping-info-mod-mian-content-info-dis {
          margin-top: 12px;
          font-weight: 400;
          font-size: 16px;
          line-height: 120%;
          color: #b0b0b0;
          margin-bottom: 12px;
        }
        .shopping-info-mod-mian-content-info-type {
          font-weight: 400;
          font-size: 16px;
          line-height: 120%;
          letter-spacing: 0.75px;
          color: #ff6700;
        }
        // 价格
        .shopping-info-mod-mian-content-info-price {
          box-sizing: border-box;
          margin-top: 26px;
          .simmcip-onwprice {
            font-weight: 500;
            font-size: 18px;
            line-height: 120%;
            letter-spacing: 0.75px;
            color: #ff6700;
          }
          .simmcip-oldprice {
            font-weight: 500;
            font-size: 14px;
            line-height: 115%;
            letter-spacing: 0.75px;
            color: #b0b0b0;
            margin-left: 6px;
            text-decoration: line-through;
          }
        }
        // 下划线
        .shopping-info-mod-mian-content-info-underline {
          width: 100%;
          height: 1px;
          background: #e0e0e0;
          margin-top: 28px;
        }
        .shopping-info-mod-mian-content-info-paymentprice {
          box-sizing: border-box;
          width: 624px;
          height: 136px;
          box-sizing: border-box;
          padding: 34px 60px;
          .simmcip-top {
            width: 100%;
            box-sizing: border-box;
            display: flex;
            justify-content: space-between;
            span {
              font-weight: 400;
              font-size: 16px;
              line-height: 100%;
              color: #606266;
              span {
                text-decoration: line-through;
                font-weight: 400;
                font-size: 16px;
                line-height: 110%;
                color: #606266;
              }
            }
          }
          .simmcip-total {
            font-weight: 400;
            font-size: 24px;
            line-height: 110%;
            color: #ff6700;
            margin-top: 30px;
          }
        }
        .shopping-info-mod-mian-content-info-bottom {
          box-sizing: border-box;
          width: 100%;
          display: flex;
          align-items: center;
          margin-top: 84px;
          justify-content: space-between;
          .shopping-info-mod-mian-content-info-bottom-add {
            box-sizing: border-box;
            width: 340px;
            height: 56px;
            background: #ff6700;
            border-radius: 4px;
            font-weight: 400;
            font-size: 16px;
            color: #ffffff;
            line-height: 56px;
            text-align: center;
            cursor: pointer;
            &:hover {
              background-color: #e75d00;
            }
          }
          .shopping-info-mod-mian-content-info-bottom-like {
            width: 260px;
            height: 56px;
            background: #c0c4cc;
            border-radius: 4px;
            font-weight: 400;
            font-size: 16px;
            line-height: 56px;
            color: #ffffff;
            text-align: center;
            cursor: pointer;
            &:hover {
              background-color: #b0b0b0;
            }
          }
        }
        .shopping-info-mod-mian-content-info-other {
          width: 100%;
          display: flex;
          align-items: center;
          margin-top: 24px;
          .simmcio-item {
            display: flex;
            align-items: center;
            margin-right: 22px;
            img {
              width: 14px;
              height: 14px;
              margin-right: 6px;
            }
            span {
              font-weight: 400;
              font-size: 16px;
              line-height: 100%;
              color: #b0b0b0;
            }
          }
        }
      }
    }
  }
}
</style>