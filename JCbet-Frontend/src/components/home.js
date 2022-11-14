import axios from "axios";

export default {
    name: "home",
    data() {
        return {
            events: [],
            error: "",
            isLoading: false,
        };
    },
    created: function(){

    },
    mounted: function(){
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
                    let section = document.createElement("div");
                    section.setAttribute('padding', '10px');
                    let item = document.createElement("img");
                    item.setAttribute('src', image);
                    item.setAttribute('width', '400px');
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