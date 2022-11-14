<template>
  <body>
  <div style="height: 100%; padding-top: 150px; text-align: left">
    <div class="col"
         style="margin-left: auto; margin-right: auto; padding-top: 20px; padding-bottom: 20px; max-width: 800px; min-height: 200px; line-height: 50px;background-color: rgba(0,0,0,0.7)">
      <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px;">
        <div class="col-2">
        <label style="color:whitesmoke;" for="loginForm" class="col-form-label">头像</label>
        <button
            class="btn btn-outline-warning btn-sm"
            type="button"
            id="proceed"
            aria-expanded="false"
            style="margin-left: 5px"
            data-bs-container="body"
            data-bs-toggle="popover"
            data-bs-placement="top"
            data-bs-content="将图片上传至https://imgbb.com/或者其他图像储存服务器，然后将链接复制在框内。例如：https://i.ibb.co/hVG7Kks/infp.jpg"
        >
          ？
        </button>
          </div>
        <div class="col-2">
          <img id = "profilePic" src="../assets/default.png" width="100" height="100">
        </div>
        <div class="col-6">
          <input type="text" class="email" id="email" v-model="user.profilePic">
        </div>
        <div class="col-2">
          <button
              class="btn btn-outline-warning"
              type="button"
              id="proceed"
              aria-expanded="false"
              @click="updateProfilePic(user.profilePic)"
          >
            <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true" v-show="isLoading"></span>
            上传
          </button>
        </div>
      </div>
      <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px;">
        <label style="color:whitesmoke;" for="loginForm" class="col-2 col-form-label">邮箱</label>
        <div class="col-8">
          <p style="color: whitesmoke">{{ user.email }}</p>
        </div>
      </div>
      <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px;">
        <label style="color:whitesmoke;" for="loginForm" class="col-2 col-form-label">用户名</label>
        <div class="col-8">
          <input type="text" class="email" id="email" v-model="user.username">
        </div>
        <div class="col-2">
          <button
              class="btn btn-outline-warning"
              type="button"
              id="proceed"
              aria-expanded="false"
              @click="updateUsername(user.username)"
          >
            <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true" v-show="isLoading"></span>
            确认修改
          </button>
        </div>
      </div>
      <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 20px;">
        <label style="color:whitesmoke;" for="loginForm" class="col-2 col-form-label">密码</label>
        <div class="col-8">
          <input type="text" class="email" id="email" placeholder="网站安全系数较低，请勿填写常用密码"
                 v-model="user.password">
        </div>
        <div class="col-2">
          <button
              class="btn btn-outline-warning"
              type="button"
              id="proceed"
              aria-expanded="false"
              @click="updatePassword(user.password)"
          >
            <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true" v-show="isLoading"></span>
            确认修改
          </button>
        </div>
      </div>
      <div class="row" style="padding-left: 30px; padding-right: 30px; height: 30px">
        <p style="color: red">{{ error }}</p>
      </div>
    </div>
  </div>
  </body>
</template>

<script src="./updateProfileScript.js">
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
  width: 100%;
}
</style>