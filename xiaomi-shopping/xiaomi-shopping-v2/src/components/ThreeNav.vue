<template>
  <div class="threeNav-component">
    <div class="threeNav-component-main">
      <div class="threeNav-component-main-content">
        <img :src="icon" alt="" />
        <div class="tcmc-wrapper">
          <span class="tcmcw-t">{{ title }}</span>
          <span class="tcmcw-d">{{ dis }}</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    icon: {
      type: String,
    },
    title: {
      type: String,
    },
    dis: {
      type: String,
    },
  },
  data() {
    return {};
  },
};
</script>

<style lang="scss" scoped>
.threeNav-component {
  box-sizing: border-box;
  width: 100%;
  padding-top: 20px;
  background-color: #ffffff;
}
.threeNav-component-main {
  width: 100%;
  height: 66px;
  border-bottom: 2px solid #ff6700;
}
.threeNav-component-main-content {
  box-sizing: border-box;
  max-width: 1200px;
  min-width: 600px;
  height: 100%;
  margin: auto;
  display: flex;
  align-items: center;
  img {
    width: 28px;
    height: 28px;
    margin-right: 16px;
  }
}
.tcmc-wrapper {
  box-sizing: border-box;
  display: flex;
  align-items: flex-end;
  .tcmcw-t {
    font-weight: 400;
    font-size: 28px;
    line-height: 100%;
    color: #333333;
    margin-right: 24px;
  }
  .tcmcw-d {
    font-weight: 400;
    font-size: 12px;
    line-height: 100%;
    color: #606266;
  }
}
</style>