<template>
  <form class="col-12 text-left" v-on:submit.prevent>
    <div class="form-group">
      <label for="title">タイトル</label>
      <input type="text" class="form-control" id="title"
             aria-describedby="title" placeholder=""
             v-model="task.title">
    </div>
    <div class="form-group">
      <label for="description">内容</label>
      <input type="text" class="form-control" id="description" placeholder=""
             v-model="task.description">
    </div>
    <div class="form-group">
      <label for="deadline">締め切り</label>
      <input type="date" class="form-control" id="deadline" placeholder=""
             v-model="task.deadline">
    </div>
    <button type="submit" class="btn btn-primary" v-on:click="submit">確定</button>
  </form>
</template>

<script>

export default {
  name: 'TaskForm',
  components: {
  },
  props: {
    task: Object,
  },
  data() {
    return {
      //
    };
  },
  async created() {
    //
    console.log(`TaskForm task: ${this.task}`);
  },
  methods: {
    submit() {
      console.log('submit');
      this.$emit('submit', { task: this.task });
    },
  },
};
</script>

<style scoped>

</style>
