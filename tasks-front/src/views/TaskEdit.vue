<template>
  <div class="row">
    <h2 class="col-12">タスク</h2>
    <TaskForm v-bind:task="task" @submit="submit"></TaskForm>
  </div>
</template>

<script>
import TaskForm from '@/components/TaskForm.vue';

export default {
  name: 'TaskEdit',
  components: {
    TaskForm,
  },
  props: {
    //
  },
  data() {
    return {
      task: {},
    };
  },
  async created() {
    console.log('created TaskEdit');
    const result = await this.axios.get(`/tasks/${this.$route.params.id}`);
    console.log(result);
    this.task = result.data;
  },
  methods: {
    async get(id) {
      // return {
      //   id,
      //   title: `title${id}`,
      //   deadline: '2020-01-01',
      //   description: 'setsumei1',
      // };
      const result = this.axios.get(`/tasks/${id}`);
      const { data } = result;
      return data;
    },
    async submit(data) {
      console.log('submit TaskEdit');
      this.axios.put(`/tasks/${this.$route.params.id}`, data.task);
      this.$router.push({ name: 'TaskList' });
    },
  },
  watch: {
    // eslint-disable-next-line no-unused-vars
    async $route(to, from) {
      console.log('watch');
      const result = await this.axios.get(`/tasks/${to.params.id}`);
      this.task = result.data;
    },
  },
};
</script>

<style scoped>

</style>
