<template>
  <div class="input-field-outline">
    <div class="input-field-outline__container">
      <input
          class="input-field-outline__container__input"
          :placeholder="placeholder"
          v-model="value"
          ref="inputRef"
          @keydown="onKeydownEnter"
      />
      <div v-if="hasText" class="input-field-outline__container__remove-icon" @click="onClickRemoveButton">
        <img src="../icons/RemoveButton.svg" alt="remove"/>
      </div>
    </div>
    <div class="input-field-outline__icon" @click="onClickSendButton">
      <img v-if="!hasText" class="input-field-outline__icon-gray" src="../icons/SendGray.svg" alt="send-button"/>
      <img v-else class="input-field-outline__icon-blue" src="../icons/SendBlue.svg" alt="send-button"/>
    </div>
  </div>
</template>

<script>
export default {
  name: 'InputFieldOutline',
  props: {
    placeholder: {
      type: String,
      default: 'Enter your task',
    },
  },
  data() {
    return {
      value: '',
    };
  },
  computed: {
    hasText() {
      return this.value !== '';
    },
  },
  methods: {
    initValue() {
      this.value = '';
    },
    onClickRemoveButton() {
      this.initValue();
      this.$refs.inputRef.focus();
    },
    onClickSendButton() {
      if (!this.hasText) return;
      this.$emit('on-click-send-button', this.value);
      this.initValue();
    },
    onKeydownEnter(event) {
      if (event.key !== 'Enter') return;
      this.$emit('on-keydown-enter', this.value);
      this.initValue();
    },
  }
};
</script>

<style lang="scss" scoped>
$sendIconSize: 32px;
$sendIconSizePadding: 17px;

.input-field-outline {
  display: flex;
  align-items: center;

  &__container {
    width: calc(100% - $sendIconSize);
    height: 100%;
    position: relative;
    display: flex;
    align-items: center;
    &__input {
      width: 100%;
      height: 100%;
      border: 1px solid #cccccc;
      border-radius: 4px;
      padding: 8px 12px 8px 12px;
      font-weight: 400;
      font-size: 16px;

      &:focus {
        outline: none;
        border: 1px solid #2a82f0;

        &::placeholder {
          color: transparent;
        }
      }
    }

    &__remove-icon {
      position: absolute;
      width: 32px;
      height: 32px;
      padding: 8px;
      left: calc(100% - ($sendIconSize / 2) - $sendIconSizePadding);
      display: flex;
      justify-content: center;
      align-items: center;
      background-color: transparent;
      user-select: none;

      &:hover {
        cursor: pointer;
      }
    }
  }


  &__icon {
    width: 32px;
    height: 32px;
    display: flex;
    justify-content: center;
    align-items: center;

    & img {
      height: 17.28px;
      width: 15.84px;
    }

    &-blue:hover {
      cursor: pointer;
    }
  }


}
</style>