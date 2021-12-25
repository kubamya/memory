import { createApp } from "vue";
import ElementPlus from "element-plus";
import "element-plus/dist/index.css";
import "./assets/restElement.css";
import App from "./App.vue";
import router from "./router/index.js";
import store from "./store/index.js";
import Emitter from "tiny-emitter";
import VueParticles from "vue-particles";
import animated from "animate.css";

const emitter = new Emitter();
const app = createApp(App).use(store);

app.use(router).use(ElementPlus).use(animated).use(VueParticles).mount("#app");

app.config.globalProperties.emitter = emitter;
