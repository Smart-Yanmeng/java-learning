<template>
  <div class="defaultpage-component">
    <div class="defaultpage-component-mian">
      <img :src="icon" alt="" />
      <div class="defaultpage-component-main-right">
        <div class="dcmr-title">{{ title }}</div>
        <div class="dcmr-dis">{{dis}}</div>
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
.defaultpage-component {
  box-sizing: border-box;
  max-width: 1200px;
  min-width: 600px;
  height: 598px;
  padding-top: 46px;
  .defaultpage-component-mian {
    display: flex;
    justify-content: center;
    img {
      width: 362px;
      height: 362px;
    }
    .defaultpage-component-main-right {
      margin-left: 80px;
      margin-top: 114px;
      .dcmr-title {
        font-weight: 600;
        font-size: 36px;
        line-height: 100%;
        color: #b0b0b0;
      }
      .dcmr-dis {
        font-weight: 500;
        font-size: 18px;
        line-height: 100%;
        color: #b0b0b0;
        margin-top: 24px;
      }
    }
  }
}
</style>