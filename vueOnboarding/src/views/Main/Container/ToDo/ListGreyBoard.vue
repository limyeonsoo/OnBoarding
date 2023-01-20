<template>
  <div class="todo-list">
    <div class="todo-list__sorting"></div>
    <div class="todo-list__tasks">
      <input-field-outline v-for="task in tasks" :key="task.id">
      </input-field-outline>
    </div>
  </div>
</template>

<script>
import InputFieldOutline from "../../../../components/input/InputFieldOutline.vue";

export default {
  name: "ListGreyBoard",
  components: {InputFieldOutline},
  props: {
    tasks: {
      type: Array,
      required: true
    }
  }
}
</script>

<style lang="scss" scoped>
.todo-list {
  background-color: rgba(242, 242, 242, 1);
}
</style>