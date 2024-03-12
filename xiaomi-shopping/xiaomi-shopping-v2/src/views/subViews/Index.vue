<template>
  <div>
    <div class="index-mod">
      <!-- 轮播图 -->
      <div class="index-mod-banner-wrapper">
        <div class="index-mod-banner-wrapper-content">
          <el-carousel height="456px">
            <el-carousel-item
              v-for="item in bannerDataList"
              :key="item.carouselId"
            >
              <img style="width: 100%; height: 456px" :src="item.url" alt="" />
            </el-carousel-item>
          </el-carousel>
        </div>
      </div>
      <!-- 商品 -->
      <div class="index-mod-other-wrapper">
        <div
          class="index-mod-other-wrapper-content-mian"
          v-for="(item, index) in shoppingData"
          :key="index"
        >
          <div class="index-mod-other-wrapper-content-title">
            <span>{{ item.categoryName ? item.categoryName : "" }}</span>
          </div>
          <div class="index-mod-other-wrapper-content-list">
            <!-- 活动区 -->
            <div class="index-mod-other-wrapper-content-list-left">
              <!-- 两张图片 -->
              <div
                class="index-mod-other-wrapper-content-list-left-two"
                v-if="item.categoryPicture1 && item.categoryPicture2"
              >
                <div
                  v-for="(activiItem, activiIndex) in 2"
                  :key="activiIndex"
                  class="index-mod-other-wrapper-content-list-left-item"
                >
                  <img
                    :src="
                      activiIndex == 0
                        ? item.categoryPicture1
                        : item.categoryPicture2
                    "
                    alt=""
                  />
                </div>
              </div>
              <!-- 一张图片的情况 -->
              <img :src="item.categoryPicture1" alt="" v-else />
            </div>
            <!-- 列表区 -->
            <div class="index-mod-other-wrapper-content-list-right">
              <ul>
                <li
                  v-for="shoppingItem in item.products"
                  :key="shoppingItem.productId"
                  class="hover"
                >
                  <div
                    class="imowclr-notover"
                    @click="shoppingInfoEvent(shoppingItem)"
                  >
                    <!-- 封面 -->
                    <div class="imowclr-cover">
                      <img :src="shoppingItem.productPicture" alt="" />
                    </div>
                    <!-- 商品名称 -->
                    <div class="imowclr-shopping-name">
                      {{ shoppingItem.productTitle }}
                    </div>
                    <!-- 介绍 -->
                    <div class="imowclr-dis">
                      {{ shoppingItem.productIntro }}
                    </div>
                    <!-- 价格 -->
                    <div class="imowclr-price">
                      <div class="imowclr-price-now">
                        {{ shoppingItem.productPrice }}
                      </div>
                      <div class="imowclr-old-price">
                        {{ shoppingItem.productSellingPrice }}
                      </div>
                    </div>
                  </div>
                </li>
                <div
                  class="imowclr-more hover"
                  v-show="item.products && item.products.length >= 7"
                  @click="seeMoreClickEvent(item)"
                >
                  浏览更多 >>
                </div>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { getHomeBanner, getHomeHot } from "@/api/home.js";
export default {
  name: "Index",
  data() {
    return {
      /** 轮播图数据 */
      bannerDataList: [],
      shoppingData: [
        {
          id: "1222",
          activi: [
            {
              img: require("../../assets/home/shopping_long.png"),
              id: "1",
            },
          ],
          list: [
            { id: "11", img: require("../../assets/home/cover.png") },
            { id: "11", img: require("../../assets/home/cover.png") },
            { id: "11", img: require("../../assets/home/cover.png") },
            { id: "11", img: require("../../assets/home/cover.png") },
            { id: "11", img: require("../../assets/home/cover.png") },
            { id: "11", img: require("../../assets/home/cover.png") },
            { id: "11", img: require("../../assets/home/cover.png") },
          ],
        },
        {
          id: "1333",
          activi: [
            {
              img: require("../../assets/home/shopping_long.png"),
              id: "1",
            },
            { img: require("../../assets/home/shopping_long.png"), id: "2" },
          ],
          list: [
            { id: "11", img: require("../../assets/home/cover.png") },
            { id: "11", img: require("../../assets/home/cover.png") },
            { id: "11", img: require("../../assets/home/cover.png") },
            { id: "11", img: require("../../assets/home/cover.png") },
            { id: "11", img: require("../../assets/home/cover.png") },
            { id: "11", img: require("../../assets/home/cover.png") },
          ],
        },
      ],
      typeData: [
        { id: "1", name: "哈哈哈" },
        { id: "2", name: "哈哈" },
        { id: "3", name: "最好的" },
      ],
      typeMousemoveIndex: 0,
    };
  },
  created() {
    this.getHomeBannerData();
    this.getHomeHotData();
  },
  methods: {
    /** 获取首页轮播图数据 */
    getHomeBannerData() {
      getHomeBanner()
        .then((res) => {
          if (res.code == 200) {
            this.bannerDataList = res.data;
          } else {
            this.$notify.error({
              message: res.msg,
            });
          }
        })
        .catch((error) => {
          this.$notify.error({
            message: "轮播图数据获取失败",
          });
        });
    },
    /** 获取首页热门商品接口 */
    getHomeHotData() {
      getHomeHot()
        .then((res) => {
          this.shoppingData = res.rows;
          console.log(this.shoppingData);
        })
        .catch((error) => {
          console.log(error);
          this.$notify.error({
            message: "数据获取失败",
          });
        });
    },
    /** 商品栏-加载更多 */
    seeMoreClickEvent(item) {
      let categoryId = item.categoryId;
      this.$router.push({
        path: "/home/allShopping",
        query: {
          categoryId: categoryId,
        },
      });
    },

    /** 商品点击 */
    shoppingInfoEvent(item) {
      console.log(item);
      let shoppingId = item.productId;
      this.$router.push({
        path: "/home/shoppingInfo",
        query: {
          id: shoppingId,
        },
      });
    },
    /** 商品区域tab栏鼠标悬浮 */
    typeMousemove(item) {},
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
.index-mod {
  box-sizing: border-box;
  width: 100%;
  padding-top: 24px;
  padding-bottom: 24px;
  .index-mod-banner-wrapper {
    box-sizing: border-box;
    width: 100%;
    margin: auto;
    padding-bottom: 32px;
    .index-mod-banner-wrapper-content {
      max-width: 1200px;
      min-width: 1000px;
      margin: auto;
    }
    // background-color: yellow;
  }
  .index-mod-other-wrapper {
    box-sizing: border-box;
    width: 100%;
    background-color: #f5f5f5;
    padding-bottom: 32px;
    .index-mod-other-wrapper-content-mian {
      box-sizing: border-box;
      width: 1200px;
      margin: auto;
      // padding-top: 16px;
      .index-mod-other-wrapper-content-title {
        box-sizing: border-box;
        width: 100%;
        height: 70px;
        display: flex;
        align-items: center;
        span {
          font-weight: 400;
          font-size: 22px;
          line-height: 100%;
          text-align: center;
          color: #333333;
        }
      }
      .index-mod-other-wrapper-content-list {
        box-sizing: border-box;
        width: 1200px;
        // background-color: red;
        // margin-top: 24px;
        display: flex;
        justify-content: space-between;
        .index-mod-other-wrapper-content-list-left {
          width: 232px;
          height: 614px;
          // background-color: yellow;
          flex-grow: 0;
          flex-shrink: 0;
          img {
            width: 100%;
            height: 100%;
          }
          .index-mod-other-wrapper-content-list-left-two {
            box-sizing: border-box;
            display: flex;
            flex-flow: column;
            justify-content: space-between;
            height: 100%;
            .index-mod-other-wrapper-content-list-left-item {
              width: 100%;
              height: 300px;
              transition: 0.5s;
              &:hover {
                box-shadow: 0px 10px 22px rgba(132, 132, 132, 0.25);
                transform: translateY(-2px);
              }
            }
          }
        }
        .index-mod-other-wrapper-content-list-right {
          flex-grow: 1;
          padding-left: 10px;
          // background-color: green;
          ul {
            height: 614px;
            margin: 0;
            padding: 0;
            list-style-type: none;
            display: grid;
            grid-template-columns: 232px 232px 232px 232px;
            grid-template-rows: 300px 300px;
            align-content: space-between;
            justify-content: space-between;
            li {
              width: 232px;
              height: 300px;
              display: flex;
              background-color: #ffffff;
              .imowclr-notover {
                box-sizing: border-box;
                width: 100%;
                height: 100%;
                display: flex;
                flex-flow: column;
                align-items: center;
                padding-top: 14px;
              }
            }
            // 加载更多
            .imowclr-more {
              width: 100%;
              height: 100%;
              display: flex;
              justify-content: center;
              align-items: center;
              font-weight: 400;
              font-size: 18px;
              text-align: center;
              color: #000000;
              background-color: #ffffff;
            }
          }
        }
      }
    }
  }
}

// 商品悬浮动画
.hover {
  cursor: pointer;
  transition: 0.5s;
  &:hover {
    box-shadow: 0px 10px 22px rgba(132, 132, 132, 0.25);
    transform: translateY(-2px);
  }
}

// 商品详情
// 封面
.imowclr-cover {
  width: 160px;
  height: 160px;
  img {
    width: 100%;
    height: 100%;
  }
}
// 商品名称
.imowclr-shopping-name {
  width: 100%;
  font-weight: 400;
  font-size: 14px;
  line-height: 100%;
  text-align: center;
  color: #333333;
  letter-spacing: 0.2px;
  margin-top: 24px;
}
// 介绍
.imowclr-dis {
  box-sizing: border-box;
  width: 100%;
  font-weight: 500;
  font-size: 12px;
  line-height: 100%;
  text-align: center;
  letter-spacing: 0.1px;
  color: #b0b0b0;
  margin-top: 14px;
  padding-left: 16px;
  padding-right: 16px;
  text-overflow: ellipsis;
  overflow: hidden;
  white-space: nowrap;
}
// 价格
.imowclr-price {
  box-sizing: border-box;
  margin-top: 12px;
  display: flex;
  justify-content: center;
  width: 100%;
  // 折后价
  .imowclr-price-now {
    font-weight: 500;
    font-size: 16px;
    text-align: center;
    letter-spacing: 0.1px;
    color: #ff6700;
  }
  // 原价
  .imowclr-old-price {
    font-weight: 500;
    font-size: 16px;
    text-align: center;
    color: #b0b0b0;
    margin-left: 8px;
  }
}
</style>