/* eslint-disable */
<template>
  <title>JCbet</title>
  <div class="row">
    <div class="col">
      <div
          style="
          margin-left: 200px;
          margin-top: 100px;
          text-align: left;
          max-width: 400px;
          line-height: 50px;">
        <div class = "row" style = "padding: 10px">
        <label style="color:whitesmoke;" for="exampleFormControlInput1" class="form-label">邮箱地址</label>
        <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
        </div>
        <div class = "row" style = "padding: 10px">
        <label style="color:whitesmoke;" for="exampleFormControlInput1" class="form-label">密码</label>
        <input type="password" class="form-control" id="exampleFormControlInput1">
        </div>
        <div class = "row" style = "padding: 10px">
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
    <div class="col">
      <img src="../assets/whph.png">
    </div>
  </div>
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

input{
  background-color: #17181a;
  color: whitesmoke;
}
</style>