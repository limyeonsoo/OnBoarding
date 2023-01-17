<template>
  <div class="input-field">
    <input
      class="input-field__input"
      :placeholder="placeholder"
      v-model="value"
      ref="inputRef"
      @keydown="onKeydownEnter"
    />
    <div v-if="hasText" class="input-field__remove-icon" @click="onClickRemoveButton">
      <img src="../icons/RemoveButton.svg" alt="remove" />
    </div>
    <div class="input-field__icon" @click="onClickSendButton">
      <img v-if="!hasText" class="input-field__icon-gray" src="../icons/SendGray.svg" alt="send-button" />
      <img v-else class="input-field__icon-blue" src="../icons/SendBlue.svg" alt="send-button" />
    </div>
  </div>
</template>

<script>
export default {
  name: 'InputField',
  props: {
    placeholder: {
      type: String,
      default: '',
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
  async created() {
    await this.$nextTick(() => {
      this.onFocusInput();
    });
  },
  methods: {
    initValue() {
      this.value = '';
    },
    onClickRemoveButton() {
      this.initValue();
      this.$refs.inputRef.focus();
    },
    onFocusInput() {
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
  },
};
</script>

<style lang="scss" scoped>
$sendIconSize: 32px;

.input-field {
  display: flex;
  align-items: flex-end;

  &__input {
    width: calc(100% - 32px);
    height: 100%;
    border: none;
    border-bottom: 1px solid #cccccc;
    padding: 0;
    font-weight: 400;
    font-size: 16px;

    &:focus {
      outline: none;
      border-bottom: 1px solid #2a82f0;

      &::placeholder {
        color: transparent;
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
      height: 15.84px;
      width: 17.28px;
    }

    &-blue:hover {
      cursor: pointer;
    }
  }

  &__remove-icon {
    position: absolute;
    left: 616px;
    width: 32px;
    height: 32px;
    padding: 8px;
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
</style>