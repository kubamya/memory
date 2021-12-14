import { createApp } from "vue";
import ElementPlus from "element-plus";
import "element-plus/dist/index.css";
import "./assets/restElement.css";
import App from "./App.vue";
import router from "./router/index.js";
import store from "./store/index.js";
import Emitter from "tiny-emitter";

const emitter = new Emitter();
const app = createApp(App).use(store);

app.use(router).use(ElementPlus).mount("#app");
app.config.globalProperties.emitter = emitter;
