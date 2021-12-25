import { Post, Get, Put, Del } from "./request";

// 获取所有链接
export const getAllLinks = () =>
  Get({
    url: `/settings/link/api/v1/link/all`,
  });

// 链接置无效
export const unableLink = (data) =>
  Put({
    url: `/settings/link/api/v1/link`,
    data,
  });

// 根据id获取链接
export const getLinkById = (params) =>
  Get({
    url: `/settings/link/api/v1/link/${params.id}`,
  });

// 获取链接列表
export const getLinks = (params) =>
  Get({
    url: `/settings/link/api/v1/links/current/${params.current}/total/${params.pageSize}`,
  });

// 新增/更新链接
export const saveLink = (data) =>
  Post({
    url: `/settings/link/api/v1/link`,
    data,
  });

// 获取所有标签
export const getAllLabels = () =>
  Get({
    url: `/settings/label/api/v1/label/all`,
  });

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
