<template>
<body>
<button class="btn btn-light" type="button" disabled v-show="isLoading">
  <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true" v-show="isLoading"></span>
  服务器响应较慢，请耐心等待
</button>
<div style="height: 100%; padding-top: 50px; text-align: left">
  <div class="col"
       style="margin-left: auto; margin-right: auto; padding-top: 20px; padding-bottom: 20px; max-width: 800px; min-height: 200px; line-height: 50px;background-color: rgba(0,0,0,0.7)">
    <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px;">
      <h2 v-show="isOpen" style="text-align: center; color: whitesmoke; background-color: darkseagreen">进行中</h2>
      <h2 v-show="!isOpen" style="text-align: center; color: whitesmoke; background-color: #ff2b3e">已结束</h2>
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
    <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px;">
      <h6 style="text-align: right; color: indianred">数据有较大误差，最终解释权归管理员所有</h6>
    </div>
    <hr style="color:#cccccc; border-width: 3px;">
    <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px;" v-show="!participated && isOpen">
      <h1 style="text-align: center; color: whitesmoke">还等什么？立刻下注</h1>
    </div>
    <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px;" v-show="!participated && isOpen">
      <div class="form-check">
        <input class="form-check-input" type="radio" name="choice" id="flexRadioDefault1" checked v-bind:value="teamA_id">
        <label class="form-check-label" for="flexRadioDefault1" style="color:whitesmoke;">
          {{ teamA }}
        </label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="radio" name="choice" id="flexRadioDefault2" v-bind:value="teamB_id">
        <label class="form-check-label" for="flexRadioDefault2" style="color:whitesmoke;">
          {{ teamB }}
        </label>
      </div>
    </div>
    <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px;" v-show="!participated && isOpen">
      <label for="customRange2" class="form-label" style="color:whitesmoke;">下注金额：{{token}} J币</label>
      <input type="range" class="form-range" min="1" v-bind:max="user.token" id="customRange2" v-model="token">
    </div>
    <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px" v-show="!participated && isOpen">
      <p class = "col-8" style="color: red">{{ error }}</p>
      <div class="col-4">
        <button
            class="btn btn-outline-warning"
            type="button"
            id="proceed"
            aria-expanded="false"
            @click="createBet()"
        >
          <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true" v-show="isLoading"></span>
          下注（建造中）
        </button>
      </div>
    </div>
    <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px;" v-show="participated">
      <h1 style="text-align: center; color: whitesmoke">您的赌注：</h1>
    </div>
    <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px;" v-show="participated">
      <label style="color:whitesmoke;" class="col-2">您的战队：</label>
      <div class="col-10">
        <img id="bet_image" src="../assets/default.png" width="100" height="100" style="margin-left: auto;
  margin-right: auto;display: block">
        <h4 style="text-align: center; color: whitesmoke">{{bet}}</h4>
      </div>
    </div>
    <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px;" v-show="participated">
      <label style="color:whitesmoke;" class="col-2">赌注金额：</label>
      <h4 style="text-align: center; color: whitesmoke" class="col-8">{{bet_amount}} J币</h4>
      <div class="col-2">
      <button
          class="btn btn-outline-warning"
          type="button"
          id="proceed"
          aria-expanded="false"
          v-show="isOpen"
      >
        <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true" v-show="isLoading"></span>
        修改金额
      </button>
      </div>
    </div>
    <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px" v-show="participated && isOpen">
      <p class = "col-10" style="color: red">{{ error }}</p>
      <div class="col-2">
        <button
            class="btn btn-outline-danger"
            type="button"
            id="proceed"
            aria-expanded="false"
            @click="deleteBet()"
        >
          <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true" v-show="isLoading"></span>
          取消赌注
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