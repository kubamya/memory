import { createRouter, createWebHistory } from "vue-router";

const routes = [
  {
    path: "/",
    component: () => import("@/view/home/home.vue"),
  },
  {
    path: "/mySpace",
    component: () => import("@/view/userSpace/mySpace.vue"),
  },
  {
    path: "/login",
    component: () => import("@/view/login.vue"),
  },
  {
    path: "/edit",
    component: () => import("@/view/content/edit.vue"),
  },
  {
    path: "/aboutMe",
    component: () => import("@/view/aboutMe/aboutMe.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
