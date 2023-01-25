<template>
  <div class="todo-list">
    <div class="todo-list__function-area">
      <div class="todo-list__function-area__sorting">
        <select name="sorting">
          <option value=1>Oldest</option>
          <option value=2>Latest</option>
        </select>
      </div>
      <div class="todo-list__function-area__clear">
        ClearAll
      </div>
    </div>
    <div class="todo-list__tasks">
      <input-field-in-arrow v-for="task in tasks" :key="task.id"
                            :id="task.id"
                            class="todo-list__tasks-each"
                            @on-click-check-button="onClickCheckButton"
      >
      </input-field-in-arrow>
    </div>
  </div>
</template>

<script>
import InputFieldInArrow from "../../../../components/input/InputFieldInArrow.vue";

export default {
  name: "ListGreyBoard",
  components: {InputFieldInArrow},
  props: {
    tasks: {
      type: Array,
      required: true
    }
  },
  methods: {
    onClickCheckButton(value) {
      this.$emit('on-click-check-button', value);
    }
  }
}
</script>

<style lang="scss" scoped>
.todo-list {
  background-color: rgba(242, 242, 242, 1);
  padding: 24px 60px;

  &__function-area {
    display: flex;
    justify-content: space-between;
    height: 40px;
    margin-bottom: 24px;

    &__sorting > select {
      width: 120px;
      height: 100%;
      padding: 11px 12px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
      border: none;
      border-radius: 4px;
      appearance: none;
      size: 16px;
      background: url('./src/assets/arrow_down.png') no-repeat 91% 50%/13px;

      &:focus {
        background: url('./src/assets/arrow_up.png') no-repeat 91% 50%/13px;
        outline: none;
        border-radius: 4px;
      }

      & option {

        &:checked {
          background-color: rgba(42, 130, 250, 0.1);
          color: #2A82F0;
        }
      }
    }

    &__clear {
      padding: 11px 0;
      line-height: 18px;
      font-family: Roboto, sans-serif;
    }
  }

  &__tasks {
    &-each {
      height: 68px;
    }
  }
}
</style>