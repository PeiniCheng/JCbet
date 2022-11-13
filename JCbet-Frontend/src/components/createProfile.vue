<template>
  <body>
  <div style="height: 100%; padding-top: 150px; text-align: left">
    <div class="col"
         style="margin-left: auto; margin-right: auto; max-width: 400px; min-height: 200px; line-height: 50px;background-color: rgba(0,0,0,0.7)">
      <div class="row" style="padding-left: 30px; padding-right: 30px">
        <label style="color:whitesmoke;" for="loginForm" class="form-label">用户名</label>
        <input type="text" class="email" id="email" v-model="username">
      </div>
      <div class="row" style="padding-left: 30px; padding-right: 30px">
        <label style="color:whitesmoke;" for="loginForm" class="form-label">密码</label>
        <input type="text" class="email" id="email" placeholder="网站安全系数较低，请勿填写常用密码" v-model="password">
      </div>
      <div class="row" style="padding-left: 30px; padding-right: 30px; height: 30px">
        <p style="color: red">{{ error }}</p>
      </div>
      <div class="row" style="padding: 20px;">
        <button
            class="btn btn-outline-warning"
            type="button"
            id="proceed"
            aria-expanded="false"
            @click="profile"
        >
          确认
        </button>
      </div>
    </div>
  </div>
  </body>
</template>

<script src="./createProfile.js"></script>

<style scoped>
body {
  margin: 0;
  height: 100vh;
  background-image: url('../assets/dust2.png');
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}

button {
  max-width: 100px;
  margin-left: auto;
}

input[type=text] {
  background: rgba(0, 0, 0, 0);
  border: 2px solid #ccc;
  color: whitesmoke;
}
</style>