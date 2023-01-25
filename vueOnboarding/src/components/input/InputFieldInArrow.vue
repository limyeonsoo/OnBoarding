<template>
  <div class="input-field-outline">
    <div class="input-field-outline__container">
      <div v-if="isFocused" class="input-field-outline__container__checkbox">
        <img v-if="isChecked" class="input-field-outline__container__checkbox-selected"
             src="../icons/selected.png"
             @click="onClickCheckButton" alt="selected"/>
        <img v-else class="input-field-outline__container__checkbox-not-selected"
             src="../icons/not_selected.png"
             @click="onClickCheckButton" alt="not_selected"/>
      </div>
      <input
          class="input-field-outline__container__input"
          :placeholder="placeholder"
          v-model="value"
          ref="inputRef"
          @keydown="onKeydownEnter"
          @focus="onFocus"
          @focusout="onFocusOut"
      />
      <div class="input-field-outline__container__function">
        <img v-if="!hasText" class="input-field-outline__container__function-red" src="../icons/btn_remove.png"
             alt="remove-button"
             @click="onClickRemoveButton"/>
        <img v-else class="input-field-outline__container__function-blue" src="../icons/SendBlue.svg"
             alt="send-button"
             @click="onClickSendButton"/>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: 'InputFieldOutline',
  props: {
    id: {
      type: Number,
      required: true,
    },
    placeholder: {
      type: String,
      default: '',
    },
    isChecked: {
      type: Boolean,
      default: false,
    }
  },
  data() {
    return {
      value: '',
      isFocused: true,
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
    onClickCheckButton() {
      this.$emit('on-click-check-button', {
        isChecked: !this.isChecked,
        id: this.id
      });
    },
    onFocus() {
      this.isFocused = false;
    },
    onFocusOut() {
      this.isFocused = true;
    }
  }
};
</script>

<style lang="scss" scoped>

.input-field-outline__container {
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  padding-bottom: 8px;
  background-color: #ffffff;
  padding-left: 16px;

  &__checkbox {
    width: 34.5px;
    height: 28px;
    display: flex;
    align-items: center;
    padding-left: 6.5px;
    padding-right: 18px;
  }

  &__input {
    //width: 100%;
    height: 24px;
    border: none;
    //border-radius: 4px;
    padding: 0 16px 0 0;
    //font-weight: 400;
    font-size: 24px;
    //
    &:focus {
      outline: none;

      &::placeholder {
        color: transparent;
      }
    }
  }

  &__function {
    width: 28px;
    height: 28px;
  }

  //& img {
  //  height: 17.28px;
  //  width: 15.84px;
  //}
  //
  //&-blue:hover {
  //  cursor: pointer;
  //}

}


</style>