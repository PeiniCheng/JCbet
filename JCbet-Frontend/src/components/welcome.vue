<template>
  <body>
  <div class="row" style="width:100%">
    <button class="btn btn-light" type="button" disabled>
      服务器响应较慢，请耐心等待
    </button>
        <div class="col">
          <img src="../assets/whph.png">
        </div>
      <form
          class="col"
          style="
          left: 0px;
          text-align: left;
          max-width: 400px;
          line-height: 50px;
          background-color: rgba(0,0,0,0.7)">
        <div class="row" style="padding-left: 30px; padding-right: 30px; padding-top: 100px">
          <label style="color:whitesmoke;" for="exampleFormControlInput1" class="form-label">邮箱地址</label>
          <input type="text" class="form-control1" placeholder="name@example.com" v-model="email" required>
        </div>
        <div class="row" style="padding-left: 30px; padding-right: 30px;">
          <label style="color:whitesmoke;" for="exampleFormControlInput1" class="form-label">密码</label>
          <input type="text" class="form-control2" v-model="password" required>
        </div>
        <div class="row" style="padding-left: 30px; padding-right: 30px; height: 30px">
          <p style="color: red">{{ error }}</p>
        </div>
        <div class="row" style="padding: 30px">
          <div class="col">
            <button
                class="btn btn-outline-light"
                type="button"
                id="login"
                aria-expanded="false"
                @click="login()"
            >
              <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true" v-show="isLoading"></span>
              登陆
            </button>
          </div>
          <div class="col-8">
            <router-link to="/sign">
              <button
                  class="btn btn-outline-light"
                  type="button"
                  id="login"
                  aria-expanded="false"
              >
                还没有账号？点击注册
              </button>
            </router-link>
          </div>
        </div>
      </form>
    </div>
  </body>
</template>

<script src="./welcomeScript.js"></script>

<style scoped>
body {
  margin: 0;
  height: 100vh;
  background-image: url('../assets/dust2.png');
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}

input[type=text] {
  background: rgba(0, 0, 0, 0);
  border: 2px solid #ccc;
  color: whitesmoke;
}

row {
  margin-right: 0;
}
</style>