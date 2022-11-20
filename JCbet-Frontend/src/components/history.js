import axios from "axios";
import {store} from "../state";
export default {
    name: "history",
    data(){
        return{
            bet: "",
        };
    },
    mounted: function () {
        let self = this;
        this.isLoading = true;
        axios.get("/user/".concat(store.state.email))
            .then(response => {
                this.betList = response.data.betList;
            })
            .catch(e => {
                let errorMsg = e.response.data.message;
                console.log(errorMsg);
                this.error = errorMsg;
            })
            .finally(() => {
                this.isLoading = false;
                let group = document.getElementById("eventList");
                this.betList.forEach(function (bet) {
                    let image = bet.;
                    let title = event.title;
                    let t1 = event.teamA.team.name;
                    let t2 = event.teamB.team.name;
                    let id = event.id;
                    let section = document.createElement("div");
                    section.setAttribute('padding', '10px');
                    let item = document.createElement("img");
                    item.setAttribute('src', image);
                    item.setAttribute('width', '400px');
                    item.setAttribute('height', '250px');
                    item.onclick = function () {
                        self.$router.push({path: '/event/' + id})
                    };
                    let titleSection = document.createElement("p");
                    titleSection.innerHTML = title + "   " + t1 + " 对战 " + t2;
                    titleSection.setAttribute('style', 'color: white')
                    section.appendChild(item);
                    section.appendChild(titleSection);
                    group.appendChild(section);
                })
            });
    },
}