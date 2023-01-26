<template>
  <div class="todolist">
    <summary-white-board
        class="todolist__summary"
        :greeting-time="greetingTime"
        :my-name="myName"
        :done-todo="doneTodo"
        :total-todo="totalTodo"
        @on-submit-task="onSubmitTask"
    >
    </summary-white-board>
    <list-grey-board
        class="todolist__list"
        :tasks="tasks"
        @on-click-check-button="onClickCheckButton"
    >
    </list-grey-board>
  </div>
</template>

<script>
import SummaryWhiteBoard from './ToDo/SummaryWhiteBoard.vue';
import ListGreyBoard from './ToDo/ListGreyBoard.vue';
import {getTasks, postTask, patchStatus} from '../../../common/tasks.js';

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
  },
  data() {
    return {
      tasks: []
    }
  },
  computed: {
    totalTodo() {
      return this.tasks.length;
    },
    doneTodo() {
      return this.tasks.filter(it => it.status === 'DONE').length;
    }
  },
  created() {
    this.getTasks();
  },
  methods: {
    async getTasks() {
      this.tasks = await getTasks();
    },
    async onSubmitTask(value) {
      await postTask(value)
      await this.getTasks();
    },
    async onClickCheckButton(value) {
      const newStatus = value.isChecked ? 'DONE' : 'ACTIVE';
      await patchStatus(value.id, newStatus);
      await this.getTasks();
    },
  }
};
</script>

<style lang="scss" scoped>
.todolist {
  height: 100%;
  background-color: rgb(242, 242, 242);
  &__summary {
    height: 324px;
  }
}
</style>