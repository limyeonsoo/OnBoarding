<template>
  <div class="container">
    <greeting v-if="unKnownName" class="container-greeting" @on-submit-name="onSubmitName"></greeting>
    <to-do-page v-else class="container-to-do-page"></to-do-page>
  </div>
</template>

<script>
import Greeting from './Container/Greeting.vue';
import ToDoPage from './Container/ToDoPage.vue';
import {  mapGetters } from 'vuex';
import { mapMutations } from 'vuex';

export default {
  name: 'MainPage',
  components: {
    ToDoPage,
    Greeting,
  },
  computed: {
    ...mapGetters(['name']),
    unKnownName() {
      return this.name === '';
    },
  },
  methods: {
    ...mapMutations(['setName']),
    onSubmitName(value) {
      this.setName(value);
    },
  },
};
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