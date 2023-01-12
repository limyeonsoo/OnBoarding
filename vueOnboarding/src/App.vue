<template>
  <div id="app">
    <top-bar
        :title="title"
        :month="month"
        :day="day"
        :weekday="weekday">
    </top-bar>
    <main-page id="mainpage"></main-page>
  </div>
</template>

<script>
import TopBar from "./components/TopBar.vue";
import MainPage from "./components/MainPage.vue";

export default {
  components: {
    TopBar,
    MainPage
  },
  data() {
    return {
      title: 'My Todo',
      month: 9,
      day: 13,
      weekday: 'Thu'
    }
  }
}
</script>

<style scoped>
#app {
  width: 100%;
}
#mainpage {
  position: relative;
  top: 48px;
}
</style>
