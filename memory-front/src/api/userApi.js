import { Get } from "./request";

export const login = (params) =>
  Get({
    url: `/user/login/api/v1/login?loginId=${params.username}&password=${params.password}`,
  });
