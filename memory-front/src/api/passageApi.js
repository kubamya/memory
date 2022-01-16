import { Post } from "./request";

// 发布文章
export const publishPassage = (data) =>
  Post({
    url: `/passages/passage/api/v1/passage/publish`,
    data,
  });
