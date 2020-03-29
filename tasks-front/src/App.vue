<template>
  <div id="app">
    <div class="row mt-4">
      <h1 class="col-md-12">タスク管理</h1>
    </div>
    <div id="nav">
      <router-link to="/">トップに戻る</router-link>
    </div>
    <div class="row">
      <router-view class="col-md-10 offset-1"/>
    </div>
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
