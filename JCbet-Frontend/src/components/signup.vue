<template>
  <body>
  <div style = "height: 100%; padding-top: 150px">
<div class="col" style = "margin-left: auto; margin-right: auto; max-width: 400px; min-height: 200px; line-height: 50px;background-color: rgba(0,0,0,0.7)">
  <div class = "row" style = "padding: 20px;">
    <label style="color:whitesmoke;" for="loginForm" class="form-label">邮箱地址</label>
    <input type="text" class="email" id="email" placeholder="name@example.com">
  </div>
  <div class = "row" style = "padding: 20px;">
    <router-link to="/createProfile">
      <button
          class="btn btn-outline-warning"
          type="button"
          id="proceed"
          aria-expanded="false"
      >
        继续
      </button>
    </router-link>
    </div>
</div>
  </div>
  </body>
</template>

<script>
export default {
  name: "signup"
}
</script>

<style scoped>
input[type=text]{
  background: rgba(0,0,0,0);
  border: 2px solid #ccc;
  color: whitesmoke;
}

body {
  margin: 0;
  height: 92vh;
  background-image: url('../assets/dust2.png');
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}

button{
  max-width: 100px;
  margin-left: auto;
}
</style>