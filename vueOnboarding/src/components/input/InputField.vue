<template>
  <div class="input-field">
    <input class="input-field__input"
           :placeholder="placeholder"
    >
    <div class="input-field__icon">
      <img src="../icons/SendGray.svg" alt="menu">
    </div>
  </div>
</template>

<script>
const sendIconSize = 32;

export default {
  name: "InputField",
  props: {
    placeholder: {
      type: String,
      default: '',
    }
  },
}
</script>

<style lang="scss" scoped>
.input-field {
  display: flex;
  align-items: flex-end;
  background-color: red;
  &__input {
    width: calc(100% - var(sendIconSize))px;
    height: calc(100% - var(sendIconSize))px;
    border: none;
    border-bottom: 1px solid #CCCCCC;
    padding: 0;
    font-weight: 400;
    font-size: 16px;
  }
}
.input-field__input:focus {
  outline: none;
}
.input-field__icon {
  width: var(sendIconSize)px;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>