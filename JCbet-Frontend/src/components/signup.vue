<template>
  <div style = "height: 100vh;">
<div class="col" style = "margin-top: 200px; margin-left: auto; margin-right: auto; max-width: 400px; min-height: 200px; background-color: #6c7075; line-height: 50px;">
  <div class = "row" style = "padding: 20px;">
    <label style="color:whitesmoke;" for="loginForm" class="form-label">邮箱地址</label>
    <input type="text" class="email" id="email" placeholder="name@example.com">
  </div>
  <div class = "row" style = "padding: 20px;">
      <button
          class="btn btn-outline-warning"
          type="button"
          id="proceed"
          aria-expanded="false"
      >
        继续
      </button>
    </div>
</div>
  </div>
</template>

<script>
export default {
  name: "signup"
}
</script>

<style scoped>
input[type=text]{
  background-color: #6c7075;
  border: 2px solid #ccc;
  color: whitesmoke;
}

button{
  max-width: 100px;
  margin-left: auto;
}
</style>