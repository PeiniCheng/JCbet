import {createApp} from 'vue'
import App from './App.vue'
import {createRouter, createWebHistory} from 'vue-router'
import Welcome from "@/components/welcome.vue";
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap"

const routes = [
    {
        path: "/",
        component: Welcome,
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});
createApp(App).use(router).mount('#app')
