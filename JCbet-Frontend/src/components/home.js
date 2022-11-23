import axios from "axios";
export default {
    name: "home",
    data() {
        return {
            events: [],
            user1: "",
            user2: "",
            user3: "",
            error: "",
            isLoading: false,
        };
    },
    created: function(){
        this.isLoading = true;
        axios.get("/user/ranking")
            .then(response => {
                let users = response.data;
                this.user1 = users[0];
                this.user1.token = Math.round( this.user1.token * 100 + Number.EPSILON ) / 100
                this.user2 = users[1];
                this.user2.token = Math.round( this.user2.token * 100 + Number.EPSILON ) / 100
                this.user3 = users[2];
                this.user3.token = Math.round( this.user3.token * 100 + Number.EPSILON ) / 100
            })
            .catch(e => {
                let errorMsg = e.response.data.message;
                console.log(errorMsg);
                this.error = errorMsg;
            })
    },
    mounted: function(){
        let self = this;
        this.isLoading = true;
        axios.get("/event/")
            .then(response => {
                this.events = response.data;
            })
            .catch(e => {
                let errorMsg = e.response.data.message;
                console.log(errorMsg);
                this.error = errorMsg;
            })
            .finally(() => {
                this.isLoading = false;
                let group = document.getElementById("eventList");
                this.events.forEach(function(event){
                    let image = event.image;
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
                    item.onclick = function(){self.$router.push({path: '/event/' + id})};
                    let titleSection = document.createElement("p");
                    titleSection.innerHTML = title +"   "+ t1 +" 对战 "+ t2;
                    titleSection.setAttribute('style', 'color: white')
                    section.appendChild(item);
                    section.appendChild(titleSection);
                    group.appendChild(section);
                })
            });
    },
    methods: {
    }

}