<template>
  <div class="todolist">
    <div class="todolist-notification">Good afternoon, {{ myName }}</div>
    <div class="todolist-status"></div>
  </div>
</template>

<script>
export default {
  name: 'ToDoPage',
  props: {
    myName: {
      type: String,
      required: true,
    },
  },
};
</script>

<style scoped></style>