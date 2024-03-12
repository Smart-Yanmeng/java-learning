<template>
  <div>
    <h1>测试</h1>
    <div @click="click1">点击</div>

    <div v-for="item in list" :key="item.id">
        <div v-for="itempro in item.pro" :key="itempro.id">
            <span>{{itempro.name}}</span>
        </div>
    </div>
  </div>
</template>


<script>
export default {
  data() {
    return {
      list: [
        { id: "1", pro: [{ name: "" ,id:'4'},{ name: "",id:'5' }] },
        { id: "2", pro: [{ name: "",id:'6' }] },
        { id: "3", pro: [{ name: "",id:'7' }] },
      ],
    };
  },
  methods: {
    click1() {
      sessionStorage.removeItem("key1");
      sessionStorage.setItem("key1", {
        name: "dasd",
        name1: "asdasd",
      });
      console.log(sessionStorage.getItem("key1").name);
    },
  },
};
</script>

