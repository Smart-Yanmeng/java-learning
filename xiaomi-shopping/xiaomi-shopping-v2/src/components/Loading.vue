<template>
  <div class="loading-mod">
    <ul>
      <li
        v-for="(item, index) in 5"
        :key="index"
        :style="{
          width: index == currentIndex ? '40px' : '30px',
          height: index == currentIndex ? '40px' : '30px',
          borderRadius:index == currentIndex?'20px':'15px'
        }"
      ></li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      currentIndex: 0,
      timer:null
    };
  },
  created() {
    this.timer = setInterval(() => {
        if(this.currentIndex == 5){
            this.currentIndex = 0
        }
        this.currentIndex++
        console.log(11);
    },200)
  },
  beforeDestroy(){
    clearInterval(this.timer)
  }
};
</script>

<style lang="scss" scoped>
.loading-mod {
  box-sizing: border-box;
  width: 100%;
  height: 100%;
  // background-color: #ffffff;
  ul {
    list-style-type: none;
    display: flex;
    justify-content: center;
    // margin-top: 200px;
    box-sizing: border-box;
    padding-top: 50px;
    align-items: center;
    height: 100%;
    li {
      box-sizing: border-box;
      width: 40px;
      height: 40px;
      border-radius: 50px;
      background-color: #ff6700;
      margin-right: 15px;
      transition: 0.3s;
    }
  }
}
</style>