<template>
  <div id="app">
    <top-bar
        :title="title"
        :month="month"
        :day="day"
        :weekday="weekday"
    ></top-bar>
  </div>
</template>

<script>
import TopBar from "./components/TopBar.vue";

export default {
  components: {
    TopBar
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
</style>
