<template>
  <div class="input-field-outline">
    <div class="input-field-outline__container">
      <div v-if="isFocused" class="input-field-outline__container__checkbox">
        <img v-if="isDone" class="input-field-outline__container__checkbox-selected"
             src="../icons/selected.png"
             @click="onClickCheckButton" alt="selected"/>
        <img v-else class="input-field-outline__container__checkbox-not-selected"
             src="../icons/not_selected.png"
             @click="onClickCheckButton" alt="not_selected"/>
      </div>
      <input
          class="input-field-outline__container__input"
          :class="{ status }"
          :disabled="isDone"
          :placeholder="placeholder"
          v-model="value"
          ref="inputRef"
          @keydown="onKeydownEnter"
          @focus="onFocus"
          @focusout="onFocusOut"
      />
      <div class="input-field-outline__container__function">
        <div v-if="isFocused" class="input-field-outline__container__function-wrapper">
          <span class="input-field-outline__container__function-wrapper__date">{{ month }}/{{ day }}</span>
          <img class="input-field-outline__container__function-wrapper__button" src="../icons/btn_remove.png"
               alt="remove-button"
               @click="onClickRemoveButton"/>
        </div>
        <img v-else class="input-field-outline__container__function-blue" src="../icons/SendBlue.svg"
             alt="send-button"
        />
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
    content: {
      type: String,
      required: true,
    },
    status: {
      type: String,
      required: true,
    },
    month: {
      type: String,
      required: true,
    },
    day: {
      type: String,
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
    isDone() {
      return this.status === 'DONE';
    }
  },
  created() {
    this.value = this.content;
  },
  methods: {
    initValue() {
      this.value = '';
    },
    initFocus() {
      this.$refs.inputRef.blur();
    },
    onClickRemoveButton() {
      this.$emit('on-click-remove-button', this.id);
    },
    onKeydownEnter(event) {
      if (event.key !== 'Enter') return;
      this.$emit('on-keydown-enter', {
        'id': this.id,
        'content': this.value
      });
      this.initFocus();
    },
    onClickCheckButton() {
      this.$emit('on-click-check-button', {
        'status': this.isDone ? 'ACTIVE' : 'DONE',
        'id': this.id
      });
    },
    onFocus() {
      this.isFocused = false;
    },
    onFocusOut() {
      this.isFocused = true;
      this.$emit('on-focus-out', {
        'id': this.id,
        'content': this.value
      });
      this.initFocus();
    }
  }
};
</script>

<style lang="scss" scoped>

.input-field-outline {
  padding-bottom: 8px;

  &__container {
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    background-color: #ffffff;
    padding: 0 16px;

    &__checkbox {
      width: 34.5px;
      height: 28px;
      display: flex;
      align-items: center;
      padding-left: 6.5px;
      padding-right: 18px;
    }

    &__input {
      min-width: calc(100% - 50.5px - 82px);
      height: 24px;
      border: none;
      padding: 0;
      font-size: 24px;
      flex-grow: 1;

      &:focus {
        outline: none;

        &::placeholder {
          color: transparent;
        }
      }
      &:disabled {
        background-color: #fff;
        color: black;
        pointer-events: none;
        user-select: none;

      }

      & .DONE {
        text-decoration-line: line-through;
      }
    }

    &__function {
      &-wrapper {
        width: 82px;
        display: flex;
        justify-content: space-between;
        align-items: center;

        &__date {
          width: 26px;
          size: 12px;
          line-height: 28px;
          opacity: 0.6;
        }
        &__button {
          cursor: pointer;
        }
      }

      &-blue {
        display: flex;
        align-items: center;
        width: 40px;
        padding-left: 12px;
        height: 28px;
        cursor: pointer;
      }
    }
  }
}


</style>