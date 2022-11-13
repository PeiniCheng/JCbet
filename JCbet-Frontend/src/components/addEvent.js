import axios from "axios";
import {store} from "@/state";

export default {
    name: "addEvent",
    data() {
        return {
            name: "",
            description: "",
            error: "",
            isLoading: false,
        };
    },
    created: function () {
        this.isLoading = true;
        axios.get("/team/")
            .then(response => {
                this.user = response.data;
            })
            .catch(e => {
                let errorMsg = e.response.data.message;
                console.log(errorMsg);
            })
            .finally(() => {
                this.isLoading = false;
            });
    },
}