<template>
  <div class="todolist">
    <summary-white-board
        :greeting-time="greetingTime"
        :my-name="myName"
        :current-todo="currentTodo"
        :total-todo="totalTodo"
        @on-submit-task="onSubmitTask"
    >
    </summary-white-board>
    <list-grey-board>

    </list-grey-board>
  </div>
</template>

<script>
import SummaryWhiteBoard from './ToDo/SummaryWhiteBoard.vue';
import ListGreyBoard from './ToDo/ListGreyBoard.vue';

export default {
  name: 'ToDoPage',
  components: {SummaryWhiteBoard, ListGreyBoard},
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
      console.log(value);
    }
  }
};
</script>

<style lang="scss" scoped>

</style>