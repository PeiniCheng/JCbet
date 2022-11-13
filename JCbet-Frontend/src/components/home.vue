<template>
  <body>
  <div class="container-fluid">
  <div class="col" style="padding: 20px;">
    <div class="row">
      <div class="col-2">
        <div class = "row-cols-auto" style = "background-color: rgba(0,0,0,0.7);">
          <div class="col-12" style="margin: auto">
          <img src="../assets/event.png" class = "row" width="100" height="100">
          <p class="row" style ="color:whitesmoke">添加比赛</p>
          </div>
        </div>
        <div class = "row-cols-auto" style = "background-color: rgba(0,0,0,0.7);">
          <div class="col-12" style="margin: auto">
          <img src="../assets/team.png" class = "row" width="100" height="100">
          <p class="row" style ="color:whitesmoke">添加队伍</p>
          </div>
        </div>
      </div>
      <div class="col-7">
        <iframe
            width="750" height="400" src="https://www.youtube.com/embed/7x48eNIIjlw" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>
        </iframe>
      </div>
      <div class="col-3" style = "background-color: rgba(0,0,0,0.7)">

      </div>
    </div>
  </div>
  </div>
  </body>
</template>

<script>
export default {
  name: "home"
}
</script>

<style scoped>
body {
  margin: 0;
  height: 100vh;
  background-image: url('../assets/dust2.png');
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}
</style>