import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('../views/TaskList.vue'),
  },
  {
    path: '/tasks/list',
    name: 'TaskList',
    component: () => import('../views/TaskList.vue'),
  },
  {
    path: '/tasks/new',
    name: 'TaskNew',
    component: () => import('../views/TaskNew.vue'),
  },
  {
    path: '/tasks/edit/:id',
    name: 'TaskEdit',
    component: () => import('../views/TaskEdit.vue'),
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
