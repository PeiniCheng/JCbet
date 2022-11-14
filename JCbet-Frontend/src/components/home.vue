<template>
  <body>
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
      <div style="width: 1000px">
        <iframe
            width="750" height="400" src="https://www.youtube.com/embed/7x48eNIIjlw" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>
        </iframe>
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