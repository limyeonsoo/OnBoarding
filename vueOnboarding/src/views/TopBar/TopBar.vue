<template>
  <div class="wrapper">
    <div class="wrapper-left">
      <div class="wrapper-left-menu">
        <img src="../../components/icons/ic_topbar_menu.svg" alt="menu" />
      </div>
      <div class="wrapper-left-title">
        {{ title }}
      </div>
    </div>
    <div class="wrapper-right">
      {{ dateOfToday }}
    </div>
  </div>
</template>

<script>
import { getThisIsTheMoment } from '../../common/thisMoment';

export default {
  data() {
    return {
      title: '',
      month: -1,
      day: -1,
      weekday: '',
    };
  },
  created() {
    this.getToday();
  },
  computed: {
    dateOfToday() {
      return `${this.month}/${this.day} ${this.weekday}`;
    },
  },
  methods: {
    getToday() {
      Object.assign(this, getThisIsTheMoment());
    },
  },
};
</script>

<style scoped>
.wrapper {
  position: absolute;

  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
  height: 48px;
  padding: 0 16px;
  background-color: #6c77a7;
}

.wrapper-left {
  width: 128px;
  display: flex;
  align-items: center;
}

.wrapper-left-menu {
  width: 24px;
  height: 24px;
}

.wrapper-left-title {
  padding-left: 14px;
  font-size: 24px;
  line-height: 24px;
  font-weight: 700;
  color: #ffffff;
  white-space: nowrap;
}

.wrapper-right {
  width: 75px;
  height: 19px;
  line-height: 19px;
  font-size: 16px;
  font-weight: 700;
  color: #ffffff;
  white-space: nowrap;
}
</style>
