import Vue from 'vue';
import BootstrapVue from 'bootstrap-vue';
import axios from 'axios';
import VueAxios from 'vue-axios';
import App from './App.vue';
import router from './router';

import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';


Vue.use(BootstrapVue);
Vue.use(VueAxios, axios);
Vue.config.productionTip = false;

new Vue({
  router,
  render: (h) => h(App),
}).$mount('#app');
