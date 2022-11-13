import axios from "axios";
import {store} from "@/state";

export default {
    name: "createProfile",
    data() {
        return {
            username: "",
            password: "",
            error: "",
            isLoading: false,
        };
    },
    methods: {
        profile() {
            let self = this;
            let username = this.username;
            let password = this.password;
            let email = store.state.email;
            this.error = "";
            if (username === "") {
                this.error = "请填写用户名";
            } else if (password === "") {
                this.erorr = "请填写密码"
            } else {
                this.isLoading = true;
                axios.patch("/user/".concat(email).concat("/username"), {}, {
                    params: {
                        newName: username
                    }
                })
                    .then(response => {
                            if (response.data.email === email) {
                                axios.patch("/user/".concat(email).concat("/password"), {}, {
                                    params: {
                                        newPassword: password
                                    }
                                }).then(response => {
                                        if (response.data.email === email) {
                                            self.$router.push({path: '/home'})
                                            store.commit('login', {email, username})
                                        }
                                    }
                                ).catch(
                                    e => {
                                        console.log(e);
                                        self.error = "未知错误";
                                        self.isLoading = false;
                                    }
                                )
                            }
                        }
                    )
                    .catch(e => {
                        console.log(e);
                        self.error = "未知错误";
                        self.isLoading = false;
                    });
            }
        }
    }
}