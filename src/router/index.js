import {createRouter, createWebHistory} from "vue-router";
import SearchPage from "../components/SearchPage.vue"; 
import ProfilePage from "../components/ProfilePage.vue";
import AboutPage from "../components/AboutPage.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: SearchPage,
  },
  {
    path: "/profile",
    name: "Profile",
    component: ProfilePage,
  },
  {
    path: "/about",
    name: "About",
    component: AboutPage,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
