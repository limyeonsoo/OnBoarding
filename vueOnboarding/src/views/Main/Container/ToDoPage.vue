<template>
  <div class="todolist">
    <div class="todolist-notification">Good {{ greetingTime }}, {{ myName }}</div>
    <div class="todolist-status">
      <div class="todolist-status__letter">You've got</div>
      <div class="todolist-status__count">{{ currentTodo }} / {{ totalTodo }}</div>
    </div>
    <input-field-outline class="todolist-input"></input-field-outline>
  </div>
</template>

<script>
import InputFieldOutline from '../../../components/input/InputFieldOutline.vue';

export default {
  name: 'ToDoPage',
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
};
</script>

<style lang="scss" scoped>

.todolist {
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

  &-input {
    width: 1160px;
    height: 48px;
  }
}

.todolist-notification {

}
</style>