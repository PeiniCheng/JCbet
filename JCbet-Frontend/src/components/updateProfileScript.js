/* eslint-disable */
import {store} from "@/state";
import axios from 'axios';
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.min.js";
import { Popover } from 'bootstrap/dist/js/bootstrap.esm.min.js'
export default {
    name: "updateProfile",
    data() {
        return {
            user: "",
            email: store.state.email,
            error: "",
            isLoading: false
        };
    },
    mounted() {
        Array.from(document.querySelectorAll('button[data-bs-toggle="popover"]'))
            .forEach(popoverNode => new Popover(popoverNode))
    },
    created: function () {
        this.isLoading = true;
        axios.get("/user/".concat(store.state.email))
            .then(response => {
                this.user = response.data;
                let imgsrc = 'https://i.ibb.co/hVG7Kks/infp.jpg'
                document.querySelector('#profilePic').setAttribute('src', imgsrc);
            })
            .catch(e => {
                let errorMsg = e.response.data.message;
                console.log(errorMsg);
            })
            .finally(() => {
                this.isLoading = false;
            });
    },
    methods: {
        updateUsername: function (username) {
            if(username === ""){
                this.error = "请填写用户名";
            }else {
                this.isLoading = true;
                axios.patch(
                    "/user/".concat(store.state.email).concat("/username"),
                    {},
                    {
                        params: {
                            newName: username
                        },
                    }
                )
                    .then()
                    .catch(e => {
                        let errorMsg = e.response.data.message;
                        console.log(errorMsg);
                    })
                    .finally(() => {
                        store.commit('update', username)
                        window.location.reload();
                        this.isLoading = false;
                    });
            }
        },
        updatePassword: function (password) {
            if (password === "") {
                this.error = "请填写密码";
            } else {
                this.isLoading = true;
                axios.patch(
                    "/user/".concat(store.state.email).concat("/password"),
                    {},
                    {
                        params: {
                            newPassword: password
                        },
                    }
                )
                    .then()
                    .catch(e => {
                        let errorMsg = e.response.data.message;
                        console.log(errorMsg);
                    })
                    .finally(() => {
                        window.location.reload();
                        this.isLoading = false;
                    });
            }
            },
        updateProfilePic: function (profilePic) {
            if (profilePic === "") {
                this.error = "请填写链接";
            } else {
                this.isLoading = true;
                axios.patch(
                    "/user/".concat(store.state.email).concat("/profilePic"),
                    {},
                    {
                        params: {
                            newProfilePic: profilePic
                        },
                    }
                )
                    .then()
                    .catch(e => {
                        let errorMsg = e.response.data.message;
                        console.log(errorMsg);
                    })
                    .finally(() => {
                        window.location.reload();
                        this.isLoading = false;
                    });
            }
        },
    },

}