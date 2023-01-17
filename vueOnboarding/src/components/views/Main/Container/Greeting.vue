<template>
  <div class="greeting">
    <div class="greeting-notification">Welcome Newbie!!<br />MyTodo makes it easy to stay organized and</div>
    <div class="greeting-question">
      <div class="greeting-question__title">What is your name?</div>
      <InputField
        class="greeting-question__input"
        placeholder="Input our name"
        @on-click-send-button="onClickSendButton"
      />
    </div>
  </div>
</template>

<script>
import InputField from '../../../input/InputField.vue';

export default {
  name: 'Greeting',
  components: { InputField },
  methods: {
    onClickSendButton() {
      console.log('click');
    },
  },
};
</script>

<style lang="scss" scoped>
.greeting-notification {
  font-size: 28px;
  font-weight: 400;
  color: #2c3e50;
  margin-bottom: 24px;
}

.greeting-question {
  &__title {
    font-size: 48px;
    font-weight: 700;
    color: #2c3e50;
    margin-bottom: 16px;
  }

  &__input {
    width: 680px;
    height: 32px;
  }
}
</style>