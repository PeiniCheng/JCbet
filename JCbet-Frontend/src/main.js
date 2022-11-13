import App from './App.vue'
import {createApp} from 'vue'
import {createRouter, createWebHistory} from 'vue-router'
import Welcome from "@/components/welcome.vue";
import Signup from "@/components/signup.vue";
import CreateProfile from "@/components/createProfile.vue";
import Home from "@/components/home.vue"
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap"
import axios from 'axios'
import {store} from "./state";
import UpdateProfile from "@/components/updateProfile";
import AddEvent from "@/components/addEvent.vue";

const routes = [
    {
        path: "/",
        component: Welcome,
    },
    {
        path: "/sign",
        component: Signup,
    },
    {
        path: "/createProfile",
        component: CreateProfile,
    },
    {
        path: "/home",
        component: Home,
    },
    {
        path: "/updateProfile",
        component: UpdateProfile
    },
    {
        path: "/addEvent",
        component: AddEvent
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
})
axios.defaults.baseURL = 'https://jcbet-backend-1.herokuapp.com';
const app = createApp(App)
app.use(router, axios, store)
app.mount('#app')
