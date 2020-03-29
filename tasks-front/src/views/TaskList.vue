<template>
  <div class="row">
    <h2 class="col-12">タスク一覧</h2>
    <!-- 追加カード -->
    <router-link to="/tasks/new"  class="col-4 card mb-2">
      <div class="card-body d-flex justify-content-center flex-column">
        <h3>＋</h3>
      </div>
    </router-link>
    <!-- 一覧 -->
    <div class="col-4 card mb-2" v-for="task in taskList" v-bind:key="task.id">
      <router-link v-bind:to="{name: 'TaskEdit', params: {id: task.id}}">
      <div class="card-body">
        <h5 class="card-title">{{ task.title }}</h5>
        <p class="card-text">{{ task.description }}</p>
      </div>
      </router-link>
    </div>
  </div>
</template>

<script>

export default {
  name: 'TaskList',
  components: {
  },
  props: {
  },
  data() {
    return {
      count: 0,
      taskList: [],
    };
  },
  async created() {
    // this.taskList = [
    //   {
    //     id: '1',
    //     title: 'title1',
    //     deadline: '2020/01/01',
    //     description: 'setsumei1',
    //   },
    //   {
    //     id: '2',
    //     title: 'title2',
    //     deadline: '2020/01/01',
    //     description: 'setsumei2',
    //   },
    //   {
    //     id: '3',
    //     title: 'title3',
    //     deadline: '2020/01/01',
    //     description: 'setsumei2',
    //   },
    //   {
    //     id: '4',
    //     title: 'title4',
    //     deadline: '2020/01/01',
    //     description: 'setsumei2',
    //   },
    // ];
    const result = await this.axios.get('/tasks');
    this.taskList = result.data;
    this.count = this.taskList.length;
  },
};
</script>

<style scoped>

</style>
