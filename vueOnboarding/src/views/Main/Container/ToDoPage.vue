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
        @on-patch-content="onPatchContent"
        @on-click-remove-button="onClickRemoveButton"
    >
    </list-grey-board>
  </div>
</template>

<script>
import SummaryWhiteBoard from './ToDo/SummaryWhiteBoard.vue';
import ListGreyBoard from './ToDo/ListGreyBoard.vue';
import {getTasks, postTask, patchStatus, patchContent, deleteTask} from '../../../common/tasks.js';

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
    },
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
      await patchStatus(value.id, value.status);
      await this.getTasks();
    },
    async onPatchContent(value) {
      await patchContent(value.id, value.content);
      await this.getTasks();
    },
    async onClickRemoveButton(id) {
      await deleteTask(id);
      await this.getTasks();
    }
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