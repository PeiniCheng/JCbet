import axios from "axios";
import { ref } from "vue";
import {store} from "@/state";
export default {
    name: "eventDetail",
    data(){
        return{
            event_id: "",
            title: "",
            description: "",
            end_time: "",
            teamA: "",
            teamA_id: "",
            teamB: "",
            teamB_id: "",
            ratioA: "",
            ratioB: "",
            user: "",
            bet: "",
            bet_amount: "",
            bet_id: "",
            participated: false,
            error: "",
            isOpen: "",
            isLoading: false,
        };
    },
    setup() {
        const token = ref(1);
        return { token };
    },
    created: function(){
        let self = this;
        this.event_id = self.$route.params.id;
        axios.get("/user/".concat(store.state.email))
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
        axios.get("/event/".concat(this.event_id))
            .then(response => {
                this.title = response.data.title;
                let imgsrc = response.data.image;
                document.querySelector('#event_image').setAttribute('src', imgsrc);
                this.description = response.data.description;
                this.end_time = new Date(response.data.endTime);
                this.teamA = response.data.teamA.team.name;
                this.teamA_id = response.data.teamA.id;
                this.teamB = response.data.teamB.team.name;
                this.teamB_id = response.data.teamB.id;
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
        axios.get("/event/".concat(this.event_id).concat("/getBet"),{
            params: {
                email: store.state.email
            }})
            .then(response => {
                if(response.data.user === store.state.email){
                    this.bet_id = response.data.id;
                    this.bet = response.data.choice.team.name;
                    this.bet_amount = response.data.token;
                    this.participated = true;
                    let imgsrc = response.data.choice.team.image;
                    document.querySelector('#bet_image').setAttribute('src', imgsrc);
                }
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
        createBet(){
            this.isLoading = true;
            axios.post("/bet/", {}, {
                params: {
                    email: store.state.email,
                    teamId: document.querySelector('input[name="choice"]:checked').value,
                    amount: this.token
                }
            }).then(
                response => {
                    if(response.data.user === store.state.email){
                        window.location.reload();
                        this.isLoading = false;
                    }
                }
                )
                .catch(e => {
                    let errorMsg = e.response.data.message;
                    console.log(errorMsg);
                    this.isLoading = false;
                })
        },
        deleteBet(){
            this.isLoading = true;
            axios.delete("/bet/".concat(this.bet_id), {}).then(
                function(){
                    window.location.reload();
                    this.isLoading = false;
                }
            )
                .catch(e => {
                    let errorMsg = e.response.data.message;
                    console.log(errorMsg);
                    this.isLoading = false;
                })
        }
    },
}