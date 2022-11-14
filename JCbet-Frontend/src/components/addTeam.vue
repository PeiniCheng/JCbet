<template>
  <body>
  <div style="height: 100%; padding-top: 150px; text-align: left">
    <div class="col"
         style="margin-left: auto; margin-right: auto; padding-top: 20px; padding-bottom: 20px; max-width: 800px; min-height: 200px; line-height: 50px;background-color: rgba(0,0,0,0.7)">
      <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px;">
        <div class="col-2">
          <label style="color:whitesmoke;" for="loginForm" class="col-form-label">图标</label>
        </div>
        <div class="col-10">
          <input type="text" v-model="image">
        </div>
      </div>
      <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px;">
        <label style="color:whitesmoke;" for="loginForm" class="col-2 col-form-label">名称</label>
        <div class="col-10">
          <input type="text" v-model="name">
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
              @click="addTeam()"
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

<script src="./addTeam.js">
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
</style>