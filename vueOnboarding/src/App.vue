<template>
  <div id="app">
    <top-bar></top-bar>
    <main-page id="mainpage"></main-page>
  </div>
</template>

<script>
import TopBar from './views/TopBar/TopBar.vue';
import MainPage from './views/Main/MainPage.vue';

export default {
  components: {
    TopBar,
    MainPage,
  },
};
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
