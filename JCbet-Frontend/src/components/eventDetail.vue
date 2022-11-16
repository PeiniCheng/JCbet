<template>
<body>
<div style="height: 100%; padding-top: 50px; text-align: left">
  <div class="col"
       style="margin-left: auto; margin-right: auto; padding-top: 20px; padding-bottom: 20px; max-width: 800px; min-height: 200px; line-height: 50px;background-color: rgba(0,0,0,0.7)">
    <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px;">
      <h2 v-show="isOpen" style="text-align: center; color: whitesmoke">进行中</h2>
      <h2 v-show="!isOpen" style="text-align: center; color: whitesmoke">已结束</h2>
    </div>
    <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px;">
         <img id="event_image" src="../assets/default.png" width="500" height="300">
    </div>
    <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px;">
      <h1 style="text-align: center; color: whitesmoke">{{title}}</h1>
    </div>
    <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px;">
      <p style="text-align: center; color: whitesmoke">{{description}}</p>
    </div>
    <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px;">
      <label style="color:whitesmoke;" for="loginForm" class="col-2 col-form-label">下注截止日期</label>
      <div class="col-10">
        <p style="text-align: right; color: whitesmoke">{{end_time}}</p>
      </div>
    </div>
    <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px;">
      <label style="color:whitesmoke;" class="col-2">参赛队伍</label>
      <div class="col-5">
        <img id="teamA_image" src="../assets/default.png" width="100" height="100" style="margin-left: auto;
  margin-right: auto;display: block">
        <h4 style="text-align: center; color: whitesmoke">{{teamA}}</h4>
        <h3 style="text-align: center; color: whitesmoke">{{ratioA}}</h3>
      </div>
      <div class="col-5">
        <img id="teamB_image" src="../assets/default.png" width="100" height="100" style="margin-left: auto;
  margin-right: auto;display: block">
        <h4 style="text-align: center; color: whitesmoke">{{teamB}}</h4>
        <h3 style="text-align: center; color: whitesmoke">{{ratioB}}</h3>
      </div>
    </div>
    <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px">
      <p class = "col-10" style="color: red">{{ error }}</p>
      <div class="col-2">
        <button
            class="btn btn-outline-warning"
            type="button"
            id="proceed"
            aria-expanded="false"
        >
          <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true" v-show="isLoading"></span>
          下注（建造中）
        </button>
      </div>
    </div>
  </div>
</div>
</body>
</template>

<script src="./eventDetail.js">
</script>

<style scoped>
body {
  margin: 0;
  height: 100%;
  background-image: url('../assets/dust2.png');
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}
</style>