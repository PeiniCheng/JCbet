<template>
  <body>
  <button class="btn btn-light" type="button" disabled v-show="isLoading">
    <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true" v-show="isLoading"></span>
    服务器响应较慢，请耐心等待
  </button>
  <div class="container-fluid">
      <div class="sidebar">
        <div class = "row justify-content-center" style = "background-color: rgba(0,0,0,0.7); ">
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
        <div>
          <div class="list-group" id="eventList">
            <div class="list-group-item" style="height: 100%;">
              赛事列表
            </div>
          </div>
        </div>
      </div>
      <div class="row" style="width: 1000px;">
        <div class="col" id="ranking">
          <h3 style="color:whitesmoke; padding-top: 10px">J币排行榜</h3>
            <div class="row" style="padding-top: 10px">
              <h4 style="color:whitesmoke; padding-top: 10px">{{user1.token}} J币: {{user1.username}}</h4>
              <img v-bind:src="user1.profilePic" width="200" height="200">
            </div>
            <div class="row">
              <div class="col">
                <h6 style="color:whitesmoke; padding-top: 10px">{{user2.token}} J币: {{user2.username}}</h6>
                <img v-bind:src="user2.profilePic" width="90" height="90">
              </div>
              <div class="col">
                <h6 style="color:whitesmoke; padding-top: 10px">{{user3.token}} J币: {{user3.username}}</h6>
                <img v-bind:src="user3.profilePic" width="80" height="80">
              </div>
            </div>
        </div>
        <div class="col">
          <iframe
              width="750" height="400"  src="https://www.youtube.com/embed/7x48eNIIjlw" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>
          </iframe>
        </div>
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
  background-image: url('../assets/dust2.png');
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}

#ranking {
  height: 600px;
  background-image: url('../assets/flag.png');
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}

.sidebar {
  margin: 0;
  right: 0;
  padding: 0;
  width: 400px;
  background-color: rgba(0,0,0,0.7);
  position: fixed;
  height: 100%;
  overflow: auto;
}
</style>