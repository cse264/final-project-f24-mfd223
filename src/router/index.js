import {createRouter, createWebHistory} from "vue-router";
import SearchPage from "../components/SearchPage.vue"; 
import ProfilePage from "../components/ProfilePage.vue";
import AboutPage from "../components/AboutPage.vue";
import WeatherInfoPage from "../components/WeatherInfoPage.vue";
import SignInPage from "../components/SignInPage";
import SignUpPage from "../components/SignUpPage";

const routes = [
  {
    path: "/", // Route for the home page (search page)
    name: "Home",
    component: SearchPage,
  },
  {
    path: "/profile", // Route for the profile page
    name: "Profile",
    component: ProfilePage,
  },
  {
    path: "/about", // Route for the about page
    name: "About",
    component: AboutPage,
  },
  {
    path: '/weather/:city', // Route for the weather info page (takes the specified city as a parameter)
    name: 'weather-detail',
    component: WeatherInfoPage
  },
  {
    path: '/signin', // Sign-in page route
    name: 'SignInPage',
    component: SignInPage
  },
  {
    path: '/signup', // Sign-up page route
    name: 'SignUpPage',
    component: SignUpPage
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
