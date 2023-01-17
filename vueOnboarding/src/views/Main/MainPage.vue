<template>
  <div class="container">
    <greeting v-if="unKnownName" class="container-greeting" @on-submit-my-name="onSubmitMyName"></greeting>
    <to-do-page v-else class="container-to-do-page" :my-name="myName"></to-do-page>
  </div>
</template>

<script>
import Greeting from './Container/Greeting.vue';
import ToDoPage from './Container/ToDoPage.vue';
import { getMyName, setMyName } from '../../common/session-storage';

export default {
  name: 'MainPage',
  components: {
    ToDoPage,
    Greeting,
  },
  computed: {
    unKnownName() {
      return this.myName === null;
    },
  },
  created() {
    this.myName = getMyName();
  },
  data() {
    return {
      myName: '',
    };
  },
  methods: {
    onSubmitMyName(myName) {
      setMyName(myName);
      this.myName = myName;
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