<template>
  <div class="row">
    <h2 class="col-12">タスク</h2>
    <TaskEditForm v-bind:task="task" @submit="submit"></TaskEditForm>
  </div>
</template>

<script>
import TaskEditForm from '@/components/TaskForm.vue';

export default {
  name: 'TaskNew',
  components: {
    TaskEditForm,
  },
  props: {
  },
  data() {
    return {
      task: {},
    };
  },
  async created() {
    this.task = await this.blank();
  },
  methods: {
    async blank() {
      return {
        id: '',
        title: '',
        deadline: '',
        description: '',
      };
    },
    async submit(data) {
      console.log('submit TaskNew');
      await this.axios.post('/tasks', data.task);
      this.$router.push({ name: 'TaskList' });
    },
  },
};
</script>

<style scoped>

</style>
