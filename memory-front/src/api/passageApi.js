import { Post, Get } from "./request";

// 获取主题列表
export const getThemeList = () =>
  Get({
    url: `/passages/passage/api/v1/themeList`,
  });

// 发布文章
export const publishPassage = (data) =>
  Post({
    url: `/passages/passage/api/v1/passage/publish`,
    data,
  });
