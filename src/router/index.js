import {createRouter, createWebHistory} from "vue-router";
import SearchPage from "../components/SearchPage.vue"; 
import ProfilePage from "../components/ProfilePage.vue";
import AboutPage from "../components/AboutPage.vue";
import WeatherInfoPage from "../components/WeatherInfoPage.vue";
import SignInPage from "../components/SignInPage";
import SignUpPage from "../components/SignUpPage";

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
  {
    path: '/weather/:city',
    name: 'weather-detail',
    component: WeatherInfoPage
  },
  {
    path: '/signin',
    name: 'SignInPage',
    component: SignInPage
  },
  {
    path: '/signup',
    name: 'SignUpPage',
    component: SignUpPage
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
