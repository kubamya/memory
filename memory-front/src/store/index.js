import { createStore } from "vuex";

export default createStore({
  state: {
    userInfo: {
      id: "",
      loginId: "",
      name: "",
      token: null,
    },
  },
  mutations: {
    setUser(state, playload) {
      state.userInfo = playload;
    },
  },
});
