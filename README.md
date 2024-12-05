# Final Project
## Team Members:
* Michael DeFulvio - mfd223@lehigh.edu
* Evan McDonnell - esm227@lehigh.edu
* Siqi Zhang - siz227@lehigh.edu
* Rico Chen - yic625@lehigh.edu

## Application Description
The application we created is called WeatherWise. It allows users to specify a city and receive detailed information about the weather in that location. Users can sign in and opt to be paid/premium users. Paid users get access to a 5-day forecast, while unpaid or unauthenticated users will only receive information for the current day.

## REST API
OpenWeatherMap API provides all the weather information for the application.

## Framework Not Discussed in Class
We used the Vue framework due to its component base architecture.

## Database
We used H2 which is an embedded database that does not need to be installed or started separately. Spring Boot directly embeds H2 as a library file into the application, which is very convenient. 

## How to Run Application:

* Make sure that view is installed by checking with 'vue --version'
* If it is not installed, install it with 'npm install -g @vue/cli'
* Get API key for the .env file in order to be able to fetch data from API
* Start the application from the vue directory with 'npm run serve'
* The backend for handling user authentication is stored in a separate branch called 'Rico' (he handled this)
* To start the backend, use 'mvn spring-boot:run' from the 'spring-backend' directory


# Previously Provided Guidelines:

## Due Last day of Class
## First report due Monday Oct 28, 2024

### Build a web app in a team of 4-5

### Requirements:
* Must have user accounts and different user roles (like user/Admin, free/paid, etc)
* Must use a database (you choose)
* Must have interactive UI (of any kind)
* Must use a library or framework not discussed/used in class
* Must use an outside REST API in some way (Outside as in external, like the Reddit API, etc)

* Feel free to build off other projects and frameworks. For example [https://github.com/sahat/hackathon-starter] is a great starter project that you can build on top of. 

### Instructions
Build your team and write a document describing your application to me by Monday Oct 28, 2024. Email this document to me and the TA for this course (Xinhui Chen xic721@lehigh.edu)  I will approve your web application idea. In your paper, include:
* the name of your application
* Name and roles of all your team members
* its functionality (how does it meet each of the requirements listed above - list each requirement along with your will fulfill it)
* user story/use case (what happens when a user visits your application, what can they do, etc)
* technical design (what is your tech stack)


### Final deliverable due end of the semester:
* Codebase in Github Repo
* README describing your project, with all the information outlined above (team members, application name, description, etc). You will also include detailed instructions of how to install and run your application, and what API keys, databases, etc are needed to run your application.
* Final Presentation and Demo
  * You will prepare a 5 minute presentation and demo of your application in class during the last week of classes
