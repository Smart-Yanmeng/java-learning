<template>
  <div class="login-mod">
    <el-dialog
      width="306px"
      :visible.sync="showDialog"
      :title="$store.state.loginPop == 1 ? '登录' : '注册'"
      center
    >
      <el-form
        :model="$store.state.loginPop == 1 ? loginForm : registerForm"
        :rules="$store.state.loginPop == 1 ? loginRules : registerRules"
        ref="loginform"
        status-icon
      >
        <!-- 登录 -->
        <el-form-item prop="accountNumber" v-show="$store.state.loginPop == 1">
          <el-input
            type="text"
            v-model="loginForm.accountNumber"
            autocomplete="off"
            placeholder="请输入账号"
            prefix-icon="el-input__icon el-icon-user-solid"
            clearable
            :validate-event="false"
          ></el-input>
        </el-form-item>
        <el-form-item prop="password" v-show="$store.state.loginPop == 1">
          <el-input
            type="password"
            v-model="loginForm.password"
            autocomplete="off"
            placeholder="请输入密码"
            prefix-icon="el-input__icon el-icon-view"
            clearable
            :validate-event="false"
          ></el-input>
        </el-form-item>

        <!-- 注册 -->
        <el-form-item prop="accountNumber" v-show="$store.state.loginPop == 2">
          <el-input
            type="text"
            v-model="registerForm.accountNumber"
            autocomplete="off"
            placeholder="请输入账号"
            clearable
            :validate-event="false"
          ></el-input>
        </el-form-item>
        <el-form-item prop="password" v-show="$store.state.loginPop == 2">
          <el-input
            type="password"
            v-model="registerForm.password"
            autocomplete="off"
            placeholder="请输入密码"
            clearable
            :validate-event="false"
          ></el-input>
        </el-form-item>
        <el-form-item
          prop="confirmPassword"
          v-show="$store.state.loginPop == 2"
        >
          <el-input
            type="password"
            v-model="registerForm.confirmPassword"
            autocomplete="off"
            placeholder="请再次输入密码"
            clearable
            :validate-event="false"
          ></el-input>
        </el-form-item>

        <!-- 按钮 -->
        <el-form-item>
          <div
            class="form-btn"
            @click="submitForm('loginform')"
            style="cursor: pointer"
          >
            {{ $store.state.loginPop == 1 ? "登录" : "注册" }}
          </div>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import { setRegister, login } from "@/api/login.js";
import { setCookie } from "@/common/cookie.js";
export default {
  props: {
    // 是否显示
    show: {
      type: Boolean,
      default: false,
    },
    // 标题  1：登录  2:注册
    title: {
      type: Number,
      default: 1,
    },
  },
  watch: {
    show(val) {
      this.showDialog = val;
    },
    showDialog(val) {
      if (val == false) {
        this.$emit("on-result-change", val);
      }
    },
  },
  data() {
    // 输入账号校验
    var accountNumber = (rule, value, callback) => {
      if (!value) {
        return callback(new Error("请输入用户名"));
      } else if(!/^[a-zA-Z]{1}\w{4,15}$/g.test(value)) {
        return callback(new Error("字母开头，长度5-16之间，允许字母数字下划线"));
      }else{
        callback();
      }
    };
    // 输入密码校验
    var aassword = (rule, value, callback) => {
      if (!value) {
        return callback(new Error("请输入密码"));
      } else if(!/^[a-zA-Z]{1}\w{5,16}$/g.test(value)) {
        return callback(new Error("字母开头，长度5-16之间，允许字母数字下划线"));
      }else{
        callback();
      }
    };
    // 再次输入密码校验
    var aginAassword = (rule, value, callback) => {
      if (!value) {
        return callback(new Error("请再次输入密码"));
      } else if(/^[a-zA-Z]{1}\w{6,17}$/g.test(value) == false) {
        return callback(new Error("字母开头，长度5-16之间，允许字母数字下划线"));
      }else if(value != this.registerForm.password){
        return callback(new Error("两次输入的密码不一致"));
      }else{
        callback();
      }
    };
    return {
      // 是否显示
      showDialog: false,
      // 注册表单数据
      registerForm: {
        accountNumber: null,
        password: null,
        confirmPassword: null,
      },
      // 登录表单数据
      loginForm: {
        accountNumber: null,
        password: null,
      },

      // 登录表单校验
      loginRules: {
        accountNumber: [
          {
            required: true,
            validator: accountNumber,
            trigger: "blur",
          },
        ],
        password: [
          {
            required: true,
            validator: aassword,
            trigger: "blur",
          },
        ],
      },

      // 注册表单校验
      registerRules: {
        accountNumber: [
          {
            required: true,
            validator: accountNumber,
            trigger: "blur",
          },
        ],
        password: [
          {
            required: true,
            validator: aassword,
            trigger: "blur",
          },
        ],
        confirmPassword: [
          {
            required: true,
            validator: aginAassword,
            trigger: "blur",
          },
        ],
      },
    };
  },
  methods: {
    // 登录提交
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (this.$store.state.loginPop == 1) {
          // 登录表单
          if (valid) {
            this.loginEvent(
              this.loginForm.accountNumber,
              this.loginForm.password
            );
          } else {
            console.log("error submit!!登录");
            return false;
          }
        } else if (this.$store.state.loginPop == 2) {
          // 注册表单
          if (valid) {
            this.setRegisterData(
              this.registerForm.accountNumber,
              this.registerForm.confirmPassword
            );
          } else {
            console.log("error submit!!注册");
            return false;
          }
        }
      });
    },
    /**
     * 注册接口
     * @param username [String] 用户名
     * @param password [String] 密码
     */
    setRegisterData(username, password) {
      let options = {
        password: password,
        username: username,
      };
      setRegister(options)
        .then((res) => {
          if (res.code == 200) {
            this.showDialog = false; //关闭注册框
            this.$notify.success({
              message: "注册成功",
            });
          } else {
            this.$notify.error({
              message: res.code,
            });
          }
        })
        .catch((error) => {
          this.$notify.error({
            message: "注册失败",
          });
        });
    },
    /**
     * 登录接口
     * @params username [String] 用户名
     * @param password [String] 密码
     */
    loginEvent(username, password) {
      let options = {
        username,
        password,
      };
      login(options)
        .then((res) => {
          console.log(res);
          if (res.code == 200) {
            this.showDialog = false; //关闭登录框
            let token = res.data;
            setCookie("token", token, 7 * 24 * 60 * 60);
            this.$store.commit("setLoginState", true);
            this.$notify.success({
              message: "登录成功",
            });
          } else {
            this.$notify.error({
              message: res.msg,
            });
          }
        })
        .catch((error) => {
          console.log(error);
          this.$notify.error({
            message: "登录失败",
          });
        });
    },
  },
};
</script>


<style lang="scss" scoped>
.form-btn {
  width: 100%;
  height: 38px;
  border-radius: 4px;
  background: #409eff;
  text-align: center;
  color: #ffffff;
  font-weight: 400;
  font-size: 14px;
  line-height: 38px;
  color: #ffffff;
}
</style>