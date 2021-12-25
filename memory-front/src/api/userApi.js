import { Get, Post } from "./request";

export const signIn = (params) =>
  Get({
    url: `/user/login/api/v1/login?loginId=${params.username}&password=${params.password}`,
  });
export const signUp = (data) =>
  Post({
    url: `/user/user/api/v1/user`,
    data,
  });
