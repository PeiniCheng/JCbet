<template>
  <body>
  <button class="btn btn-light" type="button" disabled v-show="isLoading">
    <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true" v-show="isLoading"></span>
    服务器响应较慢，请耐心等待
  </button>
  <div class="container-fluid">
      <div class="sidebar">
        <div class = "sticky-top">
        <div class = "row justify-content-center" style = "background-color: #212529; padding-top: 10px">
            <div class="col-6 justify-content-center" style="margin: auto">
              <router-link to="/addEvent">
              <img src="../assets/event.png" width="100" height="100">
              </router-link>
              <p style="color:whitesmoke">添加赛事</p>
            </div>
          <div class="col-6 justify-content-center" style="margin: auto">
            <router-link to="/addTeam">
          <img src="../assets/team.png" width="100" height="100">
            </router-link>
            <p style="color:whitesmoke">添加战队</p>
          </div>
        </div>
        <div class = "row justify-content-center" style = "background-color: #212529; border: 2px solid silver">
          <p style="color:whitesmoke">赛事列表</p>
        </div>
        </div>
        <div>
          <div class="list-group" id="eventList">
          </div>
        </div>
      </div>
        <div class="col" id="ranking" style = "width: 70px; height: 92vh; background-color:  #2c2e37">
          <div class="row" style="padding-top: 10px">
            <div class="col">
                <img v-bind:src="user1.profilePic" width="50" height="50" class="rounded">
            </div>
          </div>
          <div class="row" style="padding-top: 10px">
            <div class="col">
                <img v-bind:src="user2.profilePic" width="50" height="50" class="rounded">
            </div>
          </div>
          <div class="row" style="padding-top: 10px">
            <div class="col">
                <img v-bind:src="user3.profilePic" width="50" height="50" class="rounded">
            </div>
          </div>
          <div class="row" style="padding-top: 10px">
            <div class="col">
              <img v-bind:src="user4.profilePic" width="50" height="50" class="rounded">
            </div>
          </div>
          <div class="row" style="padding-top: 10px">
            <div class="col">
              <img v-bind:src="user5.profilePic" width="50" height="50" class="rounded">
            </div>
          </div>
        </div>
        <div class="col">
          <!-- for further use -->
        </div>
      </div>
  </body>
</template>

<script src="./home.js">
</script>

<style scoped>
body {
  margin: 0;
  height: 92vh;
  background-color: #212529;
}

#ranking {
  height: 600px;
}

.sidebar {
  margin: 0;
  right: 0;
  padding: 0;
  width: 400px;
  position: fixed;
  height: 100%;
  overflow: auto;
  border-left: 2px solid #171a23;
}

::-webkit-scrollbar {
  width: 12px;
}
/* Track */
::-webkit-scrollbar-track {
  background: #212529;
}

/* Handle */
::-webkit-scrollbar-thumb {
  background: #ffbc00;
}

.container, .container-fluid, .container-lg, .container-md, .container-sm, .container-xl, .container-xxl {
  --bs-gutter-x: 0;
}
</style>