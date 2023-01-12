<template>
  <div class="wrapper">
    <div class="wrapper-left">
      <div class="wrapper-left-menu">
        <img src="./icons/ic_topbar_menu.svg" alt="menu">
      </div>
      <div class="wrapper-left-title">
        {{ title }}
      </div>
    </div>
    <div class="wrapper-right">
      {{ today }}
    </div>
  </div>
</template>

<script>
export default {
  props: {
    title: {
      type: String,
      required: true
    },
    month: {
      type: Number,
      require: true
    },
    day: {
      type: Number,
      required: true
    },
    weekday: {
      type: String,
      required: true
    }
  },
  computed: {
    today() {
      return `${this.month}/${this.day} ${this.weekday}`
    }
  }
}
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
  background-color: #6C77A7;
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
  color: #FFFFFF;
  white-space: nowrap;
}

.wrapper-right {
  width: 65px;
  height: 19px;
  line-height: 19px;
  font-size: 16px;
  font-weight: 700;
  color: #FFFFFF;
  white-space: nowrap;
}
</style>
