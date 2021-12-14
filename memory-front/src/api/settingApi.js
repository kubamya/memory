import { Post, Get, Put, Del } from "./request";

// 删除标签
export const deleteLabel = (params) =>
  Del({
    url: `/settings/label/api/v1/label/${params.id}`,
  });

// 修改标签
export const updateLabel = (data) =>
  Put({
    url: `/settings/label/api/v1/label`,
    data,
  });

// 获取标签详情
export const getLabelById = (params) =>
  Get({
    url: `/settings/label/api/v1/label/${params.id}`,
  });

// 获取标签列表
export const getLabels = (params) =>
  Get({
    url: `/settings/label/api/v1/labels/current/${params.current}/total/${params.pageSize}`,
  });

// 添加标签
export const addLabel = (data) =>
  Post({
    url: `/settings/label/api/v1/label`,
    data,
  });
