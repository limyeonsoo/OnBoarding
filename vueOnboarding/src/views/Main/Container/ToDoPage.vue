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
    <list-grey-board
      :tasks="tasks"
    >
    </list-grey-board>
  </div>
</template>

<script>
import SummaryWhiteBoard from './ToDo/SummaryWhiteBoard.vue';
import ListGreyBoard from './ToDo/ListGreyBoard.vue';
import { getTasks } from '../../../common/tasks.js';

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
  created() {
    this.getTasks();
  },
  methods: {
    onSubmitTask(value) {
      console.log(value);
    },
    getTasks() {
      this.tasks = getTasks();
    }
  }
};
</script>

<style lang="scss" scoped>

</style>