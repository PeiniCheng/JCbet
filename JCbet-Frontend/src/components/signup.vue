<template>
  <body>
  <div style="height: 100%; padding-top: 150px">
    <div class="col"
         style="margin-left: auto; margin-right: auto; max-width: 400px; min-height: 200px; line-height: 50px;background-color: rgba(0,0,0,0.7)">
      <div class="row" style="padding: 20px;">
        <label style="color:whitesmoke;" for="loginForm" class="form-label">邮箱地址</label>
        <input type="text" class="email" id="email" placeholder="name@example.com" v-model="email">
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
            @click="login()"
        >
          <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true" v-show="isLoading"></span>
          继续
        </button>
      </div>
    </div>
  </div>
  </body>
</template>

<script src="./signup.js">
</script>

<style scoped>
input[type=text] {
  background: rgba(0, 0, 0, 0);
  border: 2px solid #ccc;
  color: whitesmoke;
}

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
</style>