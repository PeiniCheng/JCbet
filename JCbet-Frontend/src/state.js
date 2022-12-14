import {createStore} from "vuex";
import persistedState from "vuex-persistedstate";

export const store = createStore({
    plugins: [
        persistedState({
            key: "vuex-login-state",
            storage: window.localStorage,
        }),
    ],
    state: {
        email: "",
        username: "",
        loggedIn: false,
    },
    mutations: {
        login(state, {email, username}) {
            state.email = email;
            state.username = username;
            state.loggedIn = true;
        },
        register(state, email) {
            state.email = email
        },
        update(state, username){
            state.username = username;
        },
        logout(state) {
            state.email = "";
            state.username = "";
            state.loggedIn = false;
        }
    }
})