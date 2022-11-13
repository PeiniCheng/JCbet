import axios from 'axios'
import {store} from "../state";

export default {
    name: 'Signup',
    data() {
        return {
            email: "",
            error: "",
            isLoading: false,
        };
    },
    methods: {
        login() {
            let self = this;
            let email = this.email;
            this.error = "";
            if (email === "") {
                this.error = "请填写邮箱";
            } else if (!email.match("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
                this.error = "邮箱格式错误";
            } else {
                this.isLoading = true;
                axios.post("/user/".concat(email), {})
                    .then(response => {
                            if (response.data.email === email)
                                self.$router.push({path: '/createProfile'})
                            store.commit('register', email)
                        }
                    )
                    .catch(e => {
                        console.log(e);
                        self.error = "邮箱已被占用";
                        self.isLoading = false;
                    });
            }
        },
    },
}