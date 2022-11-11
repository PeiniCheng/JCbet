/* eslint-disable */
<template>
  <body>
  <div class = "row" style = "height: 100%;">
    <div class = "col">
      <img src="../assets/whph.png">
    </div>
      <div
          class = "col"
          style="
          left: 0px;
          text-align: left;
          max-width: 400px;
          line-height: 50px;
          background-color: rgba(0,0,0,0.7)">
        <div class = "row" style = "padding-left: 30px; padding-right: 30px; padding-top: 100px">
        <label style="color:whitesmoke;" for="exampleFormControlInput1" class="form-label">邮箱地址</label>
        <input type="text" class="form-control1" id="FormControlInput1" placeholder="name@example.com">
        </div>
        <div class = "row" style = "padding-left: 30px; padding-right: 30px;">
        <label style="color:whitesmoke;" for="exampleFormControlInput1" class="form-label">密码</label>
        <input type="text" class="form-control2" id="FormControlInput2">
        </div>
        <div class = "row" style = "padding: 30px">
          <div class = "col">
        <button
            class="btn btn-outline-light"
            type="button"
            id="login"
            aria-expanded="false"
        >
          登陆
        </button>
          </div>
          <div class = "col-8">
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
      </div>
  </div>
  </body>
</template>

<script>
export default {
  name: 'Welcome',
}
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

input[type=text]{
  background: rgba(0,0,0,0);
  border: 2px solid #ccc;
  color: whitesmoke;
}
</style>