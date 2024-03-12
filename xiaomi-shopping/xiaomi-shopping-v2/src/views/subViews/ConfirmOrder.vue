<template>
  <div class="confirmorder-mod">
    <!-- 头部 -->
    <threeNav :icon="require('../../assets/myorder_icon.png')" :title="'我的订单'" :dis="''"></threeNav>
    <!-- 生成订单内容模块 -->
    <div class="cm-content">
      <div class="cm-content-main">
        <div class="cmcm-c">
          <h1>收货地址</h1>
          <!-- 地址列表生成 -->
          <div class="address">
            <div class="address-item" v-for="(item,index) in addressLsit" :class="{'active':index==activeIndex}"
              :key="item.addressId" >
              <div class="item-box" @click="selectAddrss(item,index)">
                <h2 class="item-name">{{item.name}}</h2>
                <h3 class="item-phone">{{item.phone}}</h3>
                <h3 class="item-town">{{item.area}}</h3>
                <h3 class="item-street">{{item.addressDtl}}</h3>
              </div>
             
              <img class="delete-address" src="../../assets/deleteAddress.png" alt="" @click="deleteAddress(item)">
            </div>
            <div class="address-item" @click="addAddress">
              <img class="add-img" src="../../assets/ConfirmOrderAddress.png" alt="">
            </div>
          </div>
          <h1>商品及优惠券</h1>
          <div class="good-detail">
            <div class="arguments" v-for="item in goodList" :key="item.productId">
              <img :src="item.productPicture" alt="">
              <div class="arguments-name">{{item.productName}}</div>
              <div class="arguments-price">{{item.productSellingPrice}}元</div>
            </div>
            <div class="distribution">
              <div class="distribution-title">配送方式</div>
              <div class="distribution-type">{{distributionList[0]}}</div>
            </div>
            <div class="invoice">
              <div class="invoice-title">发票</div>
              <div class="invoice-type">
                <span class="detail">电子发票</span>
                <span class="detail">个人</span>
                <span class="detail">商品明细</span>
              </div>
            </div>

          </div>

          <div class="good-price-num">
            <div class="item">
              <div class="item-title">
                商品件数:
              </div>
              <div class="item-num">
                {{goodPriceAndNum.num}}件
              </div>
            </div>
            <div class="item">
              <div class="item-title">
                商品总价:
              </div>
              <div class="item-price">
                {{goodPriceAndNum.price}}元
              </div>
            </div>
            <div class="item">
              <div class="item-title">
                活动优惠:
              </div>
              <div class="item-price">
                -0元
              </div>
            </div>
            <div class="item">
              <div class="item-title">
                优惠券抵扣:
              </div>
              <div class="item-price">
                -0元
              </div>
            </div>
            <div class="item">
              <div class="item-title">
                运费:
              </div>
              <div class="item-price">
                0元
              </div>
            </div>
            <div class="item">
              <div class="item-title">
                应付总额:
              </div>
              <div class="item-price">
                {{goodPriceAndNum.totalPrice}}元
              </div>
            </div>
          </div>

          <div class="break-submit">
            <div class="break" @click="breakShoppingCar()">返回购物车</div>
            <div class="submit" @click="setGenerateOrder()">结算</div>
          </div>
        </div>
      </div>
    </div>

    <el-dialog title="添加收货地址" v-model="dialogFormVisible"  :visible.sync="dialogFormVisible" @close="deleteLabel()">
      <el-form :model="form" :inline="true"  ref="ruleForm" :rules="rules">
        <div class="name-phone">
          <el-form-item prop="name">
            <el-input class="name" v-model="form.name" placeholder="名字"></el-input>
          </el-form-item>
          <el-form-item prop="phone">
            <el-input class="phone" v-model="form.phone" placeholder="手机号"></el-input>
          </el-form-item>

        </div>
        <div class="address">
          <el-form-item prop="areaArr" label-width="620px">
            <el-cascader ref="myCascader" v-model="form.areaArr" @change="getAddressValue" :props="props"></el-cascader>
          </el-form-item>

        </div>
        <div class="address">
          <el-form-item prop="addressDtl" label-width="620px">
            <el-input v-model="form.addressDtl" placeholder="详细地址，路名或街道名称，门牌号"></el-input>
          </el-form-item>

        </div>
        <div class="address">
          <el-form-item prop="addressTags" label-width="620px">
            <el-input v-model="form.addressTags" placeholder="地址标签"></el-input>
          </el-form-item>

        </div>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <div class="btn notarize" @click="submit()">确 定</div>
        <div class="btn cancel" @click="deleteLabel()">取 消</div>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { getArea, createAddress, getAddressByUser, generateOrder,deleteAddress } from "@/api/home"
import ThreeNav from "@/components/ThreeNav.vue";
export default {
  name: "ConfirmOrder",
  components: {
    ThreeNav,
  },
  data() {
    let checkPhone = (rule, value, callback) => {
      let reg = /^1[345789]\d{9}$/
      if (!reg.test(value)) {
        callback(new Error('请输入11位手机号'))
      } else {
        callback()
      }
    }
    return {
      // 选中的item
      activeIndex: -1,
      // 地址列表
      addressLsit: [{
        addressId: 3,
        name: "",
        phone: "",
        area: "",
        addressDtl: "",
      }],
      //商品列表
      goodList: [],
      // 配送方式
      distributionList: ["包邮"],

      goodPriceAndNum:{
        num:0,
        price:0,
        totalPrice:0
      },
      // 地址添加表单
      form: {
        name: "",
        phone: "",
        area: 0,
        areaArr: [],
        addressDtl: "",
        addressTags: "",
      },
      // 弹窗显示
      dialogFormVisible: false,
      // 订单生成
      orderFrom:{
        addressId:-1,
        shoppingCartIds:[]
      },
      rules: {
        name: [
          { required: true, message: '请输入名字', trigger: 'blur' },
          { min: 2, max: 5, message: '长度在 2 到 5 个字符', trigger: 'blur' }
        ],
        phone: { type: 'number', validator: checkPhone, message: '请输入正确的手机号', trigger: 'blur' },
        areaArr: [
          { required: true, message: '请选择所在区域', trigger: 'change' }
        ],
        addressDtl: [
          { required: true, message: '请填写详细地址', trigger: 'blur' }
        ],
        addressTags: [
          { required: true, message: '请填地址标签', trigger: 'blur' }
        ]
      },
      props: {
        lazy: true,
        // emitPath:false ,
        lazyLoad(node, resolve) {
          let address = ""
          const { level } = node;
          if (level == 0) {
            getArea(1).then((res) => {
              console.log(res.data);
              if (res.code == 200) {
                var data = res.data;
                var nodes = data.map(item => {
                  return {
                    value: item.id,
                    label: item.name,
                    leaf: false
                  };
                });
                resolve(nodes);
              }
            })
          } else if (level == 1) {
            let flag = false
            // 直辖市排除
            if (node.label == "北京市" || node.label == "天津市" || node.label == "上海市" || node.label == "重庆市" || node.label == "新疆建设兵团") {
              flag = true
            }
            getArea(node.value).then((res) => {
              if (res.code == 200) {
                var data = res.data;
                var nodes = data.map(item => {
                  return {
                    value: item.id,
                    label: item.name,
                    leaf: flag
                  };

                });
                resolve(nodes);
              }
            })
          } else if (level == 2) {
            var flag = true
            getArea(node.value).then((res) => {
              if (res.code == 200) {
                var data = res.data;
                var nodes = data.map(item => {
                  if (item.name == "市辖区") {
                    console.log(item.name)
                    flag = false
                  } else {
                    flag = true
                  }
                  return {
                    value: item.id,
                    label: item.name,
                    leaf: flag
                  };
                });
                resolve(nodes);
              }
            })
          } else if (level == 3) {
            getArea(node.value).then((res) => {
              if (res.code == 200) {
                var data = res.data;
                var nodes = data.map(item => {
                  return {
                    value: item.id,
                    label: item.name,
                    leaf: true
                  };
                });
                resolve(nodes);
              }
            })
          }
        }
      },
    };
  },
  methods: {
    // 选择地址
    selectAddrss(item, index) {
      this.activeIndex = index
      console.log(item)

      this.orderFrom.addressId=item.addressId
    },
    // 打开地址表单
    addAddress() {
      this.dialogFormVisible = true
    },
    getAddressUser(){
      getAddressByUser().then(res=>{
        console.log(res);
        this.addressLsit = res.data
      })
    },
    
    // 删除地址
    deleteAddress(item){
      console.log(item);
      this.$confirm('您是否要删除该地址', '确认信息', {
          distinguishCancelAndClose: true,
          confirmButtonText: '确认',
          cancelButtonText: '放弃'
        })
          .then(() => {
            deleteAddress(item.addressId).then(res=>{
              console.log(res);
              if(res.code==200){
                  this.$message({
                      message: res.msg,
                      type: 'success'
                });
                this.getAddressUser()
              }else{
                this.$message.error("删除失败");
              }
              
            }).catch(err=>{
              this.$message.error("删除失败");
            })
          })
          .catch(action => {
            this.$message({
              type: 'info',
              message: action === 'cancel'
                ? '取消删除'
                : '停留'
            })
          });
    },
    // 返回购物车
    breakShoppingCar() {
      this.$router.push("/home/myShoppingCar")
    },
    // 提交地址
    submit() {
      this.$refs['ruleForm'].validate((valid) => {
          if (valid) {
            createAddress(this.form).then(res => {
              console.log(res);
              if (res.code == 200) {
                this.$message({
                  message: res.msg,
                  type: 'success'
                });
               
                this.getAddressUser()
                this.dialogFormVisible = false
              } else {
                this.$message.error(res.msg);
              }
            }).catch(err => {
              this.$message.error('添加失败');
            })
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      

    },
    deleteLabel() {
      this.$nextTick(() => {
        this.$refs.ruleForm.resetFields()
      })
      this.form={
        name: "",
        phone: "",
        area: 0,
        areaArr: [],
        addressDtl: "",
        addressTags: "",
      },
      this.dialogFormVisible = false
    },
    // 获取地址
    getAddressValue(value) {
      console.log(value, this.$refs.myCascader.getCheckedNodes()[0].pathLabels);
      this.form.area = this.$refs.myCascader.getCheckedNodes()[0].pathLabels.join(' '); //label
      console.log(this.form);
    },
    handleChangeRegion() {

    },
    // 生成订单
    setGenerateOrder(){
     
      this.$confirm('您是否要进行结算', '确认信息', {
          distinguishCancelAndClose: true,
          confirmButtonText: '确认',
          cancelButtonText: '放弃'
        })
          .then(() => {
            if(this.orderFrom.addressId==-1){
              this.$message.error('请选择地址');
            }
             generateOrder(this.orderFrom).then(res =>{
              console.log(res);
              if(res.code==200){
                this.$notify.success({
                  message:'购买成功'
                })
                localStorage.removeItem("goodList");
                this.$router.replace("/home/myorder")
              }else{
                this.$notify.error({
                  message:'生成订单失败'
                })
              }
                // this.getShoppingCartData()
              }).catch(error =>{
                this.$notify.error({
                  message:'生成订单失败'
                })
              })
          })
          .catch(action => {
            this.$message({
              type: 'info',
              message: action === 'cancel'
                ? '取消结算'
                : '停留在当前页面'
            })
          });
    }
  },
  created() {
    this.getAddressUser()
   
    let goodList = localStorage.getItem("goodList")
    this.goodList = JSON.parse(goodList)

    console.log(goodList);
    this.goodList.map(item=>{
      this.goodPriceAndNum.num+= item.num
      this.goodPriceAndNum.price +=item.productSellingPrice
      this.orderFrom.shoppingCartIds.push(item.shoppingCartId)
    })
    this.goodPriceAndNum.totalPrice = this.goodPriceAndNum.price
  }
};
</script>

<style lang="scss" scoped>
/deep/ .el-dialog {
  width: 660px;

  .name-phone {
    display: flex;
    justify-content: space-between;

    .name,
    .phone {
      width: 304px;
    }

  }

  // .address {
  //   margin-top: 18px;
  // }

  .dialog-footer {
    display: flex;
    justify-content: center;

    .btn {
      width: 160px;
      height: 42px;
      color: #fff;
      font-family: 'PingFang SC';
      font-style: normal;
      font-weight: 500;
      font-size: 14px;
      line-height: 42px;
      text-align: center;
    }

    .notarize {
      background-color: #FF6700;
    }

    .cancel {
      margin-left: 20px;
      background-color: #B0B0B0;
    }
  }
}
/deep/ .el-form-item__content,.el-form-item{
  display: block;
}
/deep/ .el-input__inner:focus {
  border-color: #FF6700;
  outline: 0;
}

/deep/ .el-cascader {
  display: block;
}


.confirmorder-mod {
  box-sizing: border-box;
  width: 100%;
  // height: 400px;
  //   background-color: red;
}

// 头部
.confirmorder-mod-head {}

// 内容
.cm-content {
  width: 100%;
  background-color: #F5F5F5;
  margin: auto;
  padding-top: 20px;
  padding-bottom: 24px;

}

.cm-content-main {
  width: 100%;

  .cmcm-c {
    max-width: 1000px;
    min-width: 800px;
    // height: 200px;
    margin: auto;
    padding: 82px 80px;
    padding-top: 56px;
    background-color: #ffffff;

    h1 {
      margin: 0;
      font-weight: 400;
      font-size: 18px;
      line-height: 100%;
      color: #333333;
      display: inline-block;
    }

    .address {
      width: 906px;
      margin: auto;
      margin-top: 21px;
      margin-bottom: 6px;
      display: flex;
      flex-wrap: wrap;

      .address-item {
        height: 194px;
        width: 270px;
        border: 1px solid #B0B0B0;
        box-sizing: border-box;
        padding: 20px 24px;
        margin-right: 32px;
        font-family: 'PingFang SC';
        font-style: normal;
        font-weight: 400;
        color: #606266;
        margin-bottom: 30px;
        position: relative;
        
        .item-box{
          cursor: pointer;
        }
        .delete-address{
          position: absolute;
          right: 10px;
          top: 10px;
          width: 20px;
          height: 20px;
          cursor: pointer;
        }
        .item-name {
          font-size: 18px;
          font-size: 14px;
          color: #333333;
        }

        .item-phone {
          margin-top: 16px;
          font-size: 14px;

        }

        .item-town {
          margin-top: 12px;
          font-size: 14px;
          line-height: 155%;
          margin: 0;
        }

        .item-street {
          font-size: 14px;
          line-height: 155%;
          margin: 0;
        }

        .add-img {
          height: 194px;
          width: 270px;
        }
      }

      .active {
        border: 1px solid #FF6700;
      }

      .address-item:last-child {
        padding: 0;
        border: none;
      }

    }

    .good-detail {
      margin-top: 11px;
      margin-bottom: 54px;

      .arguments {
        height: 60px;
        border-top: 1px solid #DCDFE6;
        border-bottom: 1px solid #DCDFE6;
        display: flex;
        justify-content: space-between;
        align-items: center;

        &-price {
          width: 80px;
          text-align: right;
          margin-right: 3px;
          font-family: 'PingFang SC';
          font-style: normal;
          font-weight: 500;
          font-size: 16px;

          color: #FF6700;
        }

        &-name {
          flex: 1;
          margin-left: 6px;
          font-family: 'PingFang SC';
          font-style: normal;
          font-weight: 500;
          font-size: 16px;

          color: #333333;
        }

        img {
          width: 36px;
          height: 36px;
        }
      }

      .distribution {
        height: 90px;
        font-family: 'PingFang SC';
        font-style: normal;
        font-weight: 400;
        display: flex;
        align-items: center;

        &-title {
          font-size: 18px;
          color: #333333;
        }

        &-type {
          font-size: 14px;
          color: #FF6700;
          margin-left: 75px;
        }
      }

      .invoice {
        display: flex;
        align-items: center;
        height: 86px;
        border-top: 1px solid #DCDFE6;
        border-bottom: 1px solid #DCDFE6;
        font-family: 'PingFang SC';
        font-style: normal;
        font-weight: 400;

        &-title {
          font-size: 18px;
          color: #333333;
          margin-right: 114px;
        }

        &-type {
          font-size: 14px;
          color: #FF6700;

          .detail {
            margin-right: 20px;
          }
        }
      }


    }

    .good-price-num {

      display: flex;
      flex-direction: column;
      align-items: flex-end;

      .item {
        width: 210px;
        height: 20px;
        display: inline-flex;
        align-items: flex-end;
        text-align: right;
        font-family: 'PingFang SC';
        font-style: normal;
        margin-bottom: 10px;

        .item-title {
          color: #606266;
          font-size: 16px;
          font-weight: 400;
          width: 90px;
        }

        .item-price {
          font-weight: 500;
          font-size: 16px;
          color: #FF6700;
          width: 120px;
        }

        .item-num {
          color: #FF6700;
          font-weight: 500;
          font-size: 20px;
          width: 120px;
        }
      }

      .item:last-child {
        height: 30px;
        margin-top: 18px;
        margin-bottom: 0;

        .item-price {
          font-weight: 500;
          font-size: 30px;
          color: #FF6700;
          width: 120px;
        }
      }
    }

    .break-submit {
      display: flex;
      justify-content: flex-end;
      margin-top: 46px;
      text-align: center;
      line-height: 38px;
      font-family: 'PingFang SC';
      font-style: normal;
      font-weight: 400;
      font-size: 14px;

      .break {
        width: 160px;
        height: 38px;
        color: #B0B0B0;
        box-sizing: border-box;
        border: 1px solid #B0B0B0;
        margin-right: 24px;
        cursor: pointer;
      }

      .submit {
        width: 160px;
        height: 38px;
        background: #FF6700;
        cursor: pointer;
        color: #FFFFFF;
      }
    }
  }
}
</style>