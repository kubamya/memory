import axios from "axios";
import store from "../store/index.js";

axios.interceptors.request.use(function (config) {
  const token = store.state.userInfo.token;
  if (token) {
    config.headers.token = token;
  }
  return config;
});

axios.interceptors.response.use((response) => {
  if (response.data.code) {
    switch (response.data.code) {
      case 401:
        store.commit("setUser", {
          corpId: "",
          corpName: "",
          deptId: "",
          deptName: "",
          id: "",
          loginId: "",
          name: "",
          token: null,
        });
        window.location.href = "#/login";
        break;
    }
  }
  return response;
});

function request(options) {
  return new Promise((resolve, reject) => {
    axios
      .request({
        ...options,
      })
      .then((res) => {
        resolve(res.data || res);
      })
      .catch((e) => {
        reject(e);
      });
  });
}

export const Get = (opt) => request({ ...opt, method: "GET" });
export const Post = (opt) => request({ ...opt, method: "POST" });
export const Put = (opt) => request({ ...opt, method: "PUT" });
export const Del = (opt) => request({ ...opt, method: "delete" });
