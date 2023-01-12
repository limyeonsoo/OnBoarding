<template>
  <div class="container">
    <greeting v-if="unKnownName" class="container-greeting"></greeting>
    <to-do-page v-else class="container-to-do-page"></to-do-page>
  </div>
</template>

<script>
import Greeting from "./Greeting.vue";
import ToDoPage from "./ToDoPage.vue";
export default {
  name: "MainPage",
  components: {
    ToDoPage,
    Greeting
  },
  computed: {
    unKnownName() {
      return true;
    }
  }
}
</script>

<style scoped>
.container-greeting {
  padding-left: 120px;
  padding-top: 60px;
}

.container-to-do-page {
  padding-left: 60px;
  padding-top: 16px;

}
</style>