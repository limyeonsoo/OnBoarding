<template>
  <div class="todo-summary">
    <div class="todo-summary-notification">Good {{ greetingTime }}, {{ myName }}</div>
    <div class="todo-summary-status">
      <div class="todo-summary-status__letter">You've got</div>
      <div class="todo-summary-status__count">{{ currentTodo }} / {{ totalTodo }}</div>
    </div>
    <div class="todo-summary-tasks">
      <div class="todo-summary-tasks__letter">task Today!</div>
      <input-field-outline class="todo-summary-tasks__input"
                           @on-click-send-button="onSubmitTask"
                           @on-keydown-enter="onSubmitTask">

      </input-field-outline>
    </div>
  </div>
</template>

<script>
import InputFieldOutline from '../../../../components/input/InputFieldOutline.vue';

export default {
  name: "SummaryWhiteBoard",
  components: {InputFieldOutline},
  props: {
    greetingTime: {
      type: String,
      required: true,
    },
    myName: {
      type: String,
      required: true,
    },
    currentTodo: {
      type: Number,
      default: 0,
    },
    totalTodo: {
      type: Number,
      default: 0,
    },
  },
  methods: {
    onSubmitTask(value) {
      this.$emit('on-submit-task',value);
    }
  }
}
</script>

<style lang="scss" scoped>
.todo-summary {
  background-color: rgba(255, 255, 255, 1);
  padding-left: 60px;
  padding-top: 16px;
  padding-bottom: 40px;

  &-notification {
    font-size: 28px;
    font-weight: 400;
    color: #2c3e50;
    margin-bottom: 16px;
  }

  &-status {
    display: flex;
    flex-direction: column;

    &__letter {
      font-size: 28px;
      font-weight: 400;
      color: #2c3e50;
    }

    &__count {
      font-size: 48px;
      font-weight: 700;
      color: #2c3e50;
    }
  }

  &-tasks {
    &__letter {
      font-size: 24px;
      font-weight: 400;
      color: #2c3e50;
      margin-bottom: 16px;
    }

    &__input {
      width: 1160px;
      height: 48px;
    }
  }

}
</style>