import {store} from "./state";
import axios from "axios";

export default {
    data() {
        return {
            user: "",
            store: store
        }
    },
    created: function () {
        this.isLoading = true;
        axios.get("/user/".concat(store.state.email))
            .then(response => {
                this.user = response.data;
                let imgsrc = this.user.profilePic;
                document.querySelector('.avatar').setAttribute('src', imgsrc);
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
        logout() {
            store.commit('logout');
        }
    }
}