<template>
  <div id="app">
    <nav class="navbar bg-dark align-items-top" style="text-align: center; " v-show="store.state.loggedIn">
      <div class="container-fluid" style="margin-left: 100px; margin-right: 100px">
        <router-link to="/home">
          <img src="./assets/logo.png" width="60" height="30" class="d-inline-block align-text-top">
        </router-link>
        <div class="d-flex">
          <ul style="text-align: center; margin-bottom: 0; padding-left: 20px">
            <li class="nav-item">
              <a href="https://discord.gg/s4pswSK4">
                <img src="./assets/discord.png" width="30" height="30">
              </a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                {{ user.username }}
                <img src="./assets/default.png" class="avatar" width="30" height="30">
              </a>
              <ul class="dropdown-menu dropdown-menu-dark">
                <router-link to="/updateProfile">
                  <li><a class="dropdown-item">个人资料</a></li>
                </router-link>
                <li><a class="dropdown-item">历史记录</a></li>
                <li>
                  <router-link to="/">
                    <a class="dropdown-item" @click="logout()">登出</a>
                  </router-link>
                </li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <router-view></router-view>
  </div>
</template>

<script src="./App.js">
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #FFFFFF;
  margin: 0;
}

html, body {
  padding: 0;
}

.logo {
  width: 144px;
  background: url('./assets/logo.png') 50% no-repeat;
  -webkit-background-size: 100% 100%;
  background-size: 100% 100%;
}

nav {
  height: 8vh;
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
}

li {
  display: inline-block;
  padding-left: 20px;
  padding-right: 20px;
}
</style>
