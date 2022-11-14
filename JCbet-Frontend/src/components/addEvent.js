import axios from "axios";

export default {
    name: "addEvent",
    data() {
        return {
            teams: [],
            title: "",
            description: "",
            image: "",
            error: "",
            isLoading: false,
        };
    },
    created: function () {
        this.isLoading = true;
        axios.get("/team/")
            .then(response => {
                this.teams = response.data;
                this.teams.forEach(function(team){
                    let x = document.getElementById("teamA");
                    let option = document.createElement("option");
                    option.text = team.name;
                    x.add(option);
                })
                this.teams.forEach(function(team){
                    let y = document.getElementById("teamB");
                    let option = document.createElement("option");
                    option.text = team.name;
                    y.add(option);
                })
            })
            .catch(e => {
                let errorMsg = e.response.data.message;
                console.log(errorMsg);
                this.error = errorMsg;
            })
            .finally(() => {
                this.isLoading = false;
            });
    },
    methods: {
        addEvent() {
            let self = this;
            let title = this.title;
            let description = this.description;
            let a = document.getElementById("teamA");
            let teamA = a.options[a.selectedIndex].text;
            let b = document.getElementById("teamB");
            let teamB = b.options[b.selectedIndex].text;
            let time = document.getElementById("endTime").valueAsNumber;
            this.error = "";
            if (title === "") {
                this.error = "请填写标题";
            } else if (description === "") {
                this.erorr = "请填写内容"
            } else {
                this.isLoading = true;
                axios.post("/event/".concat(title), {}, {
                    params: {
                        description: this.description,
                        image: this.image,
                        endTime: time,
                        teamAName: teamA,
                        teamBName: teamB,
                    }
                })
                    .then(response => {
                            if (response.data.title === title) {
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