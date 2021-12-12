import { createStore } from "vuex";

export default createStore({
  state: {
    userInfo: {
      corpId: "",
      corpName: "",
      deptId: "",
      deptName: "",
      id: "",
      loginId: "",
      name: "",
      token: null,
    },
  },
});
