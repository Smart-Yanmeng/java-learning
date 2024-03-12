<template>
    <div>
        <div class="box1" style="marginTop:10px">哈哈哈哈哈</div>
    </div>
</template>

<script>
export default {
    data(){
        return {

        }
    },
    created(){

    },
    mounted(){
        var box = document.querySelector('.box1')
        console.log(box.getBoundingClientRect());
    }
}
</script>