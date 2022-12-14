import {store} from "./state";
import axios from "axios";

export default {
    data() {
        return {
            user: "",
            store: store,
            valid: false,
        }
    },
    created: function () {
        this.isLoading = true;
        axios.get("/user/".concat(store.state.email))
            .then(response => {
                this.user = response.data;
                let imgsrc = this.user.profilePic;
                document.querySelector('.avatar').setAttribute('src', imgsrc);
                console.log(this.user);
            })
            .catch(e => {
                let errorMsg = e.response.data.message;
                console.log(errorMsg);
            })
            .finally(() => {
                this.isLoading = false;
            });
        axios.get("/user/".concat(store.state.email).concat("/daily"))
            .then(response => {
                this.valid = response.data;
            })
            .catch(e => {
                let errorMsg = e.response.data.message;
                console.log(errorMsg);
            });
    },
    mounted() {
    },
    methods: {
        logout() {
            store.commit('logout');
        },
        claim(){
            axios.patch(
                "/user/".concat(store.state.email).concat("/claim"),
                {},
                {
                }
            ).then(() =>{window.location.reload();}
            )
        }
    }
}