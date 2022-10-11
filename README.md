### The Assignment
- Create an application that implements the rules of Fizz Buzz game
    - A user gives 1-N numbers and for each the API returns the correct String response   based on the rules of the FizzBuzz game: http://en.wikipedia.org/wiki/Fizz_buzz
    - No need to consider multiplayer-scenario
- The application has to be written in a language runnable on JVM
- The game must be playable through an HTTP API
- Make the code repository available to us. E.g. from GitHub or BitBucket
- Even though the assignment is rather simple, produce production-level code


### How to run the application
- Clone the repository
- Run the following command from the root directory of the project
    - `mvn clean install`
    - `mvn spring-boot:run`
- The application will be running on port 8080
- API Documentation can be accessed at http://localhost:8080/swagger-ui/index.html#/


### How to play the game
- The game can be played by making a GET request to the following endpoint
    - `http://localhost:8080/games/v1/fizzbuzz?start=1&size=1`
- The start query param denotes the starting number of the game and size denotes the number of results to be returned; which is "size + start". This is done to make the API more flexible and to allow the user to play the game with any number of results(pagination).
- e.g. `http://localhost:8080/games/v1/fizzbuzz?start=1&size=0` will return the following response
    - `{ items: ["1"] }`
- AND `http://localhost:8080/games/v1/fizzbuzz?start=1&size=2` will return the following response
    - `{ items: ["1", "2", "Fizz"] }`
- The response will be an json object with items array in the following format
    - `{ items: ["1","2"] }`
- One can also access the swaggar documentation at http://localhost:8080/swagger-ui/index.html#/ to play the game.


### Limitations
- The value of start param can not be smaller than 1.
- The value of size param can not be smaller than 0.
- The combined value of size + start can not be greater than 1000, which can be modified in the `application.properties` file; also to consider other JVM limitations.
- As of now there is monitoring for the application, but it can be added by using the actuator module or other monitoring tools.


### Pre-requisites to run the application
- Java 8 / 17
- Maven 3+
- Spring Boot 2.7
- Mac OS / Linux with configured Java and Maven.
- Additional maven dependencies:
    - Spring Doc
    - Lombok


### How to run the unit & integration tests
- Clone the repository
- Run the following command from the root directory of the project
    - `mvn clean install`
- the unit tests will be executed and the results will be displayed in the console.
- The integration tests can be run using `FizzBuzz.postman_collection.json` file in the root directory of the project. The collection can be imported in Postman and the tests can be run from there.


### How to debug the application
- Application logs can be found in `fizzbuzz-application.log` file in the root directory of the project.
- For any invalid api access, a static error page(`src/main/resources/static/error.html`) is displayed.
- For updating any configuration, the `application.properties` file can be updated.
- Global exception handler is implemented and can be further enhanced for other exceptions.
