<template>
  <div class="myorder-mod">
    <threeNav
      :icon="require('../../assets/myorder_icon.png')"
      :title="'我的订单'"
      :dis="''"
    ></threeNav>

    <!-- 展示内容 -->
    <div class="myorder-mod-main">
        <div class="content">
            <!-- 收获地址 -->
            <div>
              <h4>收货地址</h4>
              <div>
                <div class="address-card address-info-card">
                  
                </div>
                <div class="address-card address-add-card">
                  <span class="el-icon-circle-plus-outline" style="font-size:34px;"></span>
                </div>
              </div>
            </div>
            <!-- 商品及优惠券 -->
            <!-- 商品价格及结算按钮 -->
        </div>
    </div>
  </div>
</template>


<script>
import ThreeNav from "@/components/ThreeNav.vue";
import DefaultPage from "@/components/DefaultPage";
import { getArea,createAddress,getAddressByUser } from "@/api/home";
export default {
  name: "MyOrderAddress",
  components: {
    ThreeNav,
    DefaultPage,
  },
  computed: {

  },
  watch: {
    "$store.state.loginState"(val) {
      if (val) {
        // 已登录
       
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
      // 选择的地址数据
      addressForm:{
        addressDtl: null,
        addressTags: null,
        area: null,
        name: null,
        phone: null
      }
    };
  },
  created() {

  },
  methods: {
    getAddressByUser(){
      getAddressByUser().then(res => {
        console.log(res);
      })
    },
    createAddress(){
      createAddress().then(res => {

      })
    }
  },
};
</script>


<style lang="scss" scoped>
.myorder-mod-main {
  box-sizing: border-box;
  width: 100%;
  background-color: #f5f5f5;
  padding-bottom: 24px;
  .content{
    width: 1200px;
    background-color: #ffffff;
    margin: auto;
    box-sizing: border-box;
    padding: 56px 80px;
    .address-card{
      width: 270px;
      height: 194px;
      border: 1px solid #B0B0B0;
      box-sizing: border-box;
      padding: 20px 24px;
      &:hover{
        border: 1px solid #FF6700;
      }
      cursor: pointer;
    }
    .address-info-card{
      display: flex;
      flex-direction: column;
    }
    .address-add-card{
      padding: 79px 24px;
      text-align: center;
    }
  }
}
</style>