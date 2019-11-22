# Volvo test

## Downloading dependencies
For this poject we must have these tools installed:
- Java 1.8
- Eclipse
- Maven
- Other useful information:
The project uses **MongoDB Atlas**, so it's not neccessary to download MongoDB, the application point to the cluster's URL.
The project only have the backend, so one way of testing it is by using **Postman** or another similar software that tests services.

First download/clone this project into your computer and import it into your Eclipse workspace.
To download the dependencies you can right click in the project's name, go to "Run As" and click on "Maven build...".
When the run configuration page opens, add "clean install" to Goals and click "Run".
After that right click on the project again, go to "Maven" and click "Update Maven Project". Select the checkbox "Force Update...".
Make sure your project is selected and then click "OK", this will update the project's JARs.

## Running the application
The application uses Spring Boot, so you only need to create a new Java Application run configuration and execute it.
Choose the project (volvo), and set the main class as "com.volvo.VolvoApplication". Then click "Run" and it will start to run.
The project will be deployed in the server and will be available at http://localhost:8080.

## Endpoints
- GET - http://localhost:8080/vehicles - lists all vehicles
- GET - http://localhost:8080/vehicles/{chassisId} - return the vehicle with the expected id, if exists
- POST - http://localhost:8080/vehicles - add a new vehicle, if already exists another with same chassisId returns error
- PUT - http://localhost:8080/vehicles/{chassisId} - update a vehicle
- DELETE - http://localhost:8080/vehicles/{chassisId} - delete a vehicle

## Unit tests
The project doesn't have unit tests implemented yet. There are actually 2 in one class, but they are failing.
To run them, we must create a new JUnit run configuration using JUnit 4 and select to run all tests.
