<template>
  <body>
  <div style="height: 100%; padding-top: 150px; text-align: left">
    <div class="col"
         style="margin-left: auto; margin-right: auto; padding-top: 20px; padding-bottom: 20px; max-width: 800px; min-height: 200px; line-height: 50px;background-color: rgba(0,0,0,0.7)">
      <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px;">
        <div class="col-2">
          <label style="color:whitesmoke;" for="loginForm" class="col-form-label">头图</label>
        </div>
        <div class="col-10">
          <input type="text" v-model="image">
        </div>
      </div>
      <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px;">
        <label style="color:whitesmoke;" for="loginForm" class="col-2 col-form-label">标题</label>
        <div class="col-10">
          <input type="text" v-model="title">
        </div>
      </div>
      <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px;">
        <label style="color:whitesmoke;" for="loginForm" class="col-2 col-form-label">内容</label>
        <div class="col-10">
          <textarea class="form-control" rows="3" v-model="description"></textarea>
        </div>
      </div>
      <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px;">
        <label style="color:whitesmoke;" for="loginForm" class="col-2 col-form-label">截止日期</label>
        <div class="col-10">
          <input type="datetime-local" id="endTime">
        </div>
      </div>
      <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px;">
        <label style="color:whitesmoke;" for="loginForm" class="col-2 col-form-label">参赛队伍</label>
        <div class="col-5">
          <select class="form-select" id="teamA" aria-label="Default select example">
          </select>
        </div>
        <div class="col-5">
          <select class="form-select" id="teamB" aria-label="Default select example">
          </select>
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
              @click="addEvent()"
          >
            <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true" v-show="isLoading"></span>
            创建
          </button>
        </div>
      </div>
    </div>
  </div>
  </body>
</template>

<script src="./addEvent.js">
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
input[type=text] {
  background: rgba(0, 0, 0, 0);
  border: 2px solid #ccc;
  color: whitesmoke;
  width: 80%;
}
textarea {
  background: rgba(0, 0, 0, 0);
  border: 2px solid #ccc;
  color: whitesmoke;
  width: 100%;
}
</style>