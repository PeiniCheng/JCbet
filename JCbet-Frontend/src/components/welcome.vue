/* eslint-disable */
<template>
  <body>
  <div style = "height: 650px;">
      <div
          class = "col"
          style="
          top: 150px;
          left: 1100px;
          text-align: left;
          max-width: 350px;
          max-width: 350px;
          line-height: 50px;">
        <div class = "row" style = "padding: 10px;">
        <label style="color:whitesmoke;" for="exampleFormControlInput1" class="form-label">邮箱地址</label>
        <input type="text" class="form-control1" id="FormControlInput1" placeholder="name@example.com">
        </div>
        <div class = "row" style = "padding: 10px">
        <label style="color:whitesmoke;" for="exampleFormControlInput1" class="form-label">密码</label>
        <input type="text" class="form-control2" id="FormControlInput2">
        </div>
        <div class = "row" style = "margin-top: 20px">
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
            <button
                class="btn btn-outline-light"
                type="button"
                id="login"
                aria-expanded="false"
            >
              还没有账号？点击注册
            </button>
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
.login {
  width: 200px;
}

div{
  position: relative;
}
body {
  margin: 0;
  height: 100%;
  background-image: url('../assets/background.png');
  background-position: center;
  background-repeat: no-repeat;
}

input[type=text]{
  background-color: #6c7075;
  border: 2px solid #ccc;
  color: whitesmoke;
}
</style>