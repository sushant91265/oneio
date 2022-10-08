### The Assignment
- Create an application that implements the rules of Fizz Buzz game
    - A user gives 1-N numbers and for each the API returns the correct String response   based on the rules of the FizzBuzz game: http://en.wikipedia.org/wiki/Fizz_buzz
    - No need to consider multiplayer-scenario
- The application has to be written in a language runnable on JVM
- The game must be playable through an HTTP API
- Make the code repository available to us. E.g. from GitHub or BitBucket
- Even though the assignment is rather simple, produce production-level code


### Pre-requisites to run the application
- Java 8 / 17
- Maven 3+
- Spring Boot 2.7
- Mac OS / Linux with configured Java and Maven.


### How to run the application
- Clone the repository
- Run the following command from the root directory of the project
    - `mvn clean install`
    - `mvn spring-boot:run`
- The application will be running on port 8080
- API Documentation can be accessed at http://localhost:8080/swagger-ui/index.html#/


### How to run the tests
- Clone the repository
- Run the following command from the root directory of the project
    - `mvn clean install`
- The tests will be executed and the results will be displayed in the console


### How to play the game
- The game can be played by making a POST request to the following endpoint
    - `http://localhost:8080/games/v1/fizzbuzz?start=1&end=2`
- The response will be an array with the following format
    - `["1","2"]`


### How to debug the application
- Application logs can be found in `fizzbuzz-application.log` file in the root directory of the project.
- For any invalid api access, a static error page(`src/main/resources/static/error.html`) is displayed with the error message.
- For updating any configuration, the `application.properties` file can be updated.
- Global exception handler is implemented and can be further enhanced for other exceptions.