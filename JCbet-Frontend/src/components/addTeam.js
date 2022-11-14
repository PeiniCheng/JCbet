import axios from "axios";

export default {
    name: "addTeam",
    data() {
        return {
            name: "",
            image: "",
            error: "",
            isLoading: false,
        };
    },
    methods: {
        addTeam() {
            let self = this;
            let name = this.name;
            this.error = "";
            if (name === "") {
                this.error = "请填写名称";
            }else {
                this.isLoading = true;
                axios.post("/team/".concat(name), {}, {
                    params: {
                        image: this.image,
                    }
                })
                    .then(response => {
                            if (response.data.name === name) {
                                self.loading = false;
                                self.$router.push({path: '/home'})
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