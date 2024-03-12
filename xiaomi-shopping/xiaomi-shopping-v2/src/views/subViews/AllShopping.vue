<template>
  <div class="allshopping-mod">
    <div class="allshopping-mod-head">
      <div class="allshopping-mod-head-mian">
        <div class="allshopping-mod-head-mian-nav">
          <span
            class="allshopping-mod-head-mian-nav-back"
            @click="backHomeEvent"
            >首页</span
          >
          <img src="../../assets/right.png" alt="" />
          <span>全部商品</span>
          <img src="../../assets/right.png" alt="" />
          <span>分类</span>
        </div>
        <!-- tab栏 -->
        <div class="allshopping-mod-head-mian-tab">
          <div class="allshopping-mod-head-mian-tab-title">分类</div>
          <ul>
            <li
              :style="{
                borderWidth: index === tabInfo.length - 1 ? '0' : '1px',
                borderBottomWidth: item.categoryId == selectTabId ? '0' : '1px',
                color: tabTitleColor(item),
              }"
              v-for="(item, index) in tabInfo"
              :key="index"
              @click="selectTab(item)"
              @mousemove="tabMousemove(item)"
              @mouseleave="tabMouseleave(item)"
            >
              {{ item.categoryName }}
            </li>
          </ul>
          <!-- 补齐下划线 -->
          <div class="allshopping-mod-head-mian-tab-otherline"></div>
        </div>
      </div>
    </div>
    <!-- 列表 -->
    <div class="allshopping-mod-content">
      <div class="allshopping-mod-content-main">
        <!-- 列表 -->
        <ul :style="{ gridTemplateRows: `repeat(${tabLine},300px)` }">
          <li v-for="item in dataList" :key="item.productId.productId" @click="goShoppingInfoEvent(item)">
            <el-image
              :src="item.productPicture"
              lazy
              style="width: 160px; height: 160px"
            ></el-image>
            <div class="allshopping-mod-content-main-item-name"
              >{{ item.productName }}
            </div>
            <div class="allshopping-mod-content-main-item-dis">{{
              item.productTitle
            }}</div>
            <div class="allshopping-mod-content-main-item-price">
              <span class="amcmip-onwprice">{{ item.productPrice }}</span>
              <span class="amcmip-newprice">{{
                item.productSellingPrice
              }}</span>
            </div>
          </li>
        </ul>
        <!-- 分页 -->
        <div class="allshopping-mod-content-main-paging" v-show="total>20">
          <el-pagination
            background
            layout="prev, pager, next"
            :total="total"
            :page-size="this.options.pageSize"
            :current-page="this.options.pageNum"
            @current-change="currentChange"
          >
          </el-pagination>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { getHomeClassification, getShoppingList } from "@/api/home";
export default {
  name: "AllShopping",
  computed: {
    tabTitleColor() {
      return (item) => {
        if (item.categoryId == this.selectTabId) {
          return "#409eff";
        } else {
          if (item.categoryId == this.tabMouseMoveId) {
            return "#409eff";
          } else {
            return "#333333";
          }
        }
      };
    },
  },
  data() {
    return {
      // tab栏信息
      tabInfo: [],
      /** tab栏点击-id */
      selectTabId: 0,
      /** tab栏-鼠标移动-选中id */
      tabMouseMoveId: null,
      /** 页面信息 */
      dataList: [],
      /** 列表需要多少行 */
      tabLine: 4,
      /** 分类查询商品列表参数表单 */
      options: {
        pageNum: 1,
        pageSize: 20,
      },
      /** 分页总条数 */
      total: 0,
    };
  },
  async created() {
    // 获取所有商品类型数组
    await this.getHomeClassificationData();
    let object = { categoryName: "全部", categoryId: 0 };
    this.tabInfo.unshift(object);
    // 当前类型的商品id
    let routeId = this.$route.query.categoryId;
    if (routeId) {
      this.selectTabId = this.$route.query.categoryId;
    }
    this.resetOptions(this.selectTabId);
    await this.getShoppingListData();
  },
  methods: {
    /** 获取所有的商品的分类 */
    async getHomeClassificationData() {
      try {
        const result = await getHomeClassification();
        if (result.code == 200) {
          this.tabInfo = result.data;
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
    /** 获取商品展示列表数据 */
    async getShoppingListData() {
      try {
        const result = await getShoppingList(this.options);
        if (result.code == 200) {
          this.dataList = result.rows;
          // 列表需要多少行
          this.tabLine = Math.ceil(this.dataList.length / 5);
          // 当前页面总条数
          this.total = result.total;
        } else {
          this.$notify.error({
            message: result.msg,
          });
        }
      } catch (error) {
        console.log(this.error);
        this.$notify.error({
          message: "数据获取失败",
        });
      }
    },
    backHomeEvent() {
      this.$router.push({
        path: "/home/index",
      });
    },
    resetOptions(id) {
      if (id == 0) {
        this.options = {
          pageNum: 1,
          pageSize: 20,
        };
      } else {
        this.options = {
          pageNum: 1,
          pageSize: 20,
          categoryId: id,
        };
      }
    },
    /** tab栏-鼠标点击事件 */
    selectTab(item) {
      if (this.selectTabId != item.categoryId) {
        this.selectTabId = item.categoryId;
        this.$router.replace({
          path: "/home/allShopping",
          query: {
            categoryId: this.selectTabId,
          },
        });
        this.resetOptions(this.selectTabId);
        this.getShoppingListData();
      }
    },
    /** tab栏-鼠标移入事件 */
    tabMousemove(item) {
      let id = item.categoryId;
      this.tabMouseMoveId = id;
      // console.log(this.tabMouseMoveId);
    },
    /** tab栏-鼠标移出事件 */
    tabMouseleave(item) {
      this.tabMouseMoveId = null;
    },
    currentChange(pageNum) {
      this.options.pageNum = pageNum
      this.getShoppingListData();
    },
    /** 跳转商品详情页 */
    goShoppingInfoEvent(item){
      let shoppingId = item.productId
      this.$router.push({
        path:'/home/shoppingInfo',
        query:{
          id:shoppingId
        }
      })
    }
  },
};
</script>

<style lang="scss" scoped>
/deep/ .el-breadcrumb__inner {
  font-size: 16px;
}
.separator-class {
  width: 16px;
  height: 16px;
}
.allshopping-mod-head {
  box-sizing: border-box;
  width: 100%;
  height: 109px;
  background-color: #ffffff;
  .allshopping-mod-head-mian {
    box-sizing: border-box;
    width: 1200px;
    height: 100%;
    // background-color: red;
    margin: auto;
    display: flex;
    flex-flow: column;
    .allshopping-mod-head-mian-nav {
      box-sizing: border-box;
      padding-top: 24px;
      padding-bottom: 27px;
      flex-grow: 0;
      flex-shrink: 0;
      display: flex;
      align-items: center;
      span {
        margin-right: 6px;
        font-size: 16px;
        line-height: 100%;
        color: #333333;
      }
      img {
        margin-right: 6px;
      }
      .allshopping-mod-head-mian-nav-back {
        font-weight: 600;
        font-size: 16px;
        line-height: 100%;
        color: #333333;
        cursor: pointer;
        &:hover {
          color: #409eff;
        }
      }
    }
    .allshopping-mod-head-mian-tab {
      box-sizing: border-box;
      flex-grow: 1;
      // background-color: red;
      display: flex;
      align-items: flex-end;
      .allshopping-mod-head-mian-tab-title {
        width: 50px;
        height: 100%;
        box-sizing: border-box;
        font-weight: 600;
        font-size: 16px;
        color: #333333;
        display: flex;
        align-items: center;
        justify-content: left;
        border-bottom: 1px solid #dcdfe6;
      }
      ul {
        height: 42px;
        // background-color: yellow;
        display: flex;
        align-items: center;
        border-radius: 4px 4px 0px 0px;
        border-top: 1px solid #dcdfe6;
        border-left: 1px solid #dcdfe6;
        border-right: 1px solid #dcdfe6;
        list-style-type: none;
        margin: 0;
        padding: 0;
        li {
          box-sizing: border-box;
          height: 100%;
          padding-left: 20px;
          padding-right: 20px;
          border-right: 1px solid #dcdfe6;
          display: flex;
          align-items: center;
          border-bottom-color: #dcdfe6;
          border-bottom-style: solid;
          font-weight: 400;
          font-size: 14px;
          color: #333333;
          cursor: pointer;
          // &:hover {
          //   color: #409eff;
          // }
        }
      }
      .allshopping-mod-head-mian-tab-otherline {
        flex-grow: 1;
        height: 1px;
        background-color: #dcdfe6;
      }
    }
  }
}
.allshopping-mod-content {
  box-sizing: border-box;
  width: 100%;
  // height: 200px;
  background-color: #f5f5f5;
  padding-top: 14px;
  padding-bottom: 24px;
  .allshopping-mod-content-main {
    box-sizing: border-box;
    width: 1200px;
    margin: auto;
    // 列表
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
          width: 232px;
          box-sizing: border-box;
          font-weight: 400;
          font-size: 14px;
          line-height: 100%;
          text-align: center;
          letter-spacing: 0.2px;
          color: #333333;
          margin-top: 24px;
          padding-left: 16px;
          padding-right: 16px;
          white-space: nowrap;
          text-overflow: ellipsis;
          overflow: hidden;
        }
        .allshopping-mod-content-main-item-dis {
          width: 232px;
          box-sizing: border-box;
          font-weight: 500;
          font-size: 12px;
          line-height: 100%;
          text-align: center;
          letter-spacing: 0.1px;
          color: #b0b0b0;
          margin-top: 14px;
          white-space: nowrap;
          text-overflow: ellipsis;
          overflow: hidden;
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
    // 分页
    .allshopping-mod-content-main-paging {
      box-sizing: border-box;
      padding-top: 20px;
      // height: 28px;
      padding-bottom: 18px;
      // background-color: blue;
      display: flex;
      justify-content: center;
      align-items: center;
    }
  }
}
</style>