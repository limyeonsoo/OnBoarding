<template>
  <div class="container">
    <greeting v-if="unKnownName" class="container-greeting" @on-submit-my-name="onSubmitMyName"></greeting>
    <to-do-page v-else class="container-to-do-page" :greeting-time="timesOfTheDay" :my-name="myName"></to-do-page>
  </div>
</template>

<script>
import Greeting from './Container/Greeting.vue';
import ToDoPage from './Container/ToDoPage.vue';
import { getMyName, setMyName } from '../../common/session-storage';
import { getThisIsTheMoment } from '../../common/thisMoment';

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
    this.getTimesOfTheDay();
  },
  data() {
    return {
      myName: '',
      timesOfTheDay: '',
    };
  },
  methods: {
    async onSubmitMyName(myName) {
      setMyName(myName);
      this.myName = myName;
    },
    getTimesOfTheDay() {
      Object.assign(this, getThisIsTheMoment());
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
