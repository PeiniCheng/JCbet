import axios from 'axios'
export default {
    name: 'Welcome',
    data() {
        return {
            email: "",
            password: "",
            error: "",
            isLoading: false,
        };
    },
        methods: {
            login(){
                let self = this;
                let email = this.email;
                let password = this.password;
                this.error = "";
                if(email === "") {
                    this.error = "请填写邮箱";
                }else {
                    this.isLoading = true;
                    axios.get("/user/".concat(email), {})
                        .then(response => {
                            if (password === response.data.password) {
                                //LOGIN_STATE.commit("login", { userType, username });
                                self.isLoading = false;
                                self.$router.push({path: '/home'});
                            } else {
                                self.error = "密码错误，如忘记密码请联系管理员";
                                self.isLoading = false;
                            }
                        }).catch(e => {
                        console.log(e);
                        self.error = "邮箱不存在";
                        self.isLoading = false;
                    });
                }
            },
        },
    };