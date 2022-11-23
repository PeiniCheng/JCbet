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
                    let choice = bet.choice;
                    console.log(choice);
                    let token = bet.token;
                    let section = document.createElement("div");
                    section.setAttribute('padding', '10px');
                    let titleSection = document.createElement("h2");
                    titleSection.innerHTML = choice.eventTitle + ": " +choice.team.name+ " "+ token + " J币";
                    titleSection.setAttribute('style', 'color: white')
                    section.appendChild(titleSection);
                    group.appendChild(section);
                })
            });
    },
}