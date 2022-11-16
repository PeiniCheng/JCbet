import axios from "axios";

export default {
    name: "eventDetail",
    data(){
        return{
            event_id: "",
            title: "",
            description: "",
            end_time: "",
            teamA: "",
            teamB: "",
            ratioA: "",
            ratioB: "",
            error: "",
            isOpen: "",
            isLoading: false,
        };
    },
    created: function(){
        let self = this;
        this.event_id = self.$route.params.id;
        axios.get("/event/".concat(this.event_id))
            .then(response => {
                this.title = response.data.title;
                let imgsrc = response.data.image;
                document.querySelector('#event_image').setAttribute('src', imgsrc);
                this.description = response.data.description;
                this.end_time = new Date(response.data.endTime);
                this.teamA = response.data.teamA.team.name;
                this.teamB = response.data.teamB.team.name;
                let imgsrcA = response.data.teamA.team.image;
                document.querySelector('#teamA_image').setAttribute('src', imgsrcA);
                let imgsrcB = response.data.teamB.team.image;
                document.querySelector('#teamB_image').setAttribute('src', imgsrcB);
                let aRatio = response.data.ratio;
                if(aRatio == -1){
                    this.ratioA = "数据暂不可用";
                    this.ratioB = "数据暂不可用";
                }else{
                    this.ratioA = aRatio;
                    this.ratioB = 1/aRatio;
                }
                let status = response.data.status;
                if(status === "OPEN"){
                    this.isOpen = true;
                }else{
                    this.isOpen = false;
                }
            })
            .catch(e => {
                let errorMsg = e.response.data.message;
                console.log(errorMsg);
                this.error = errorMsg;
            })
    }
}