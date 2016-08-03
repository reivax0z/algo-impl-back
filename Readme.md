## Algo Implementations Project

This is a back-end project for classic Algorithm implementations.

### Stack

* Java 8
* SpringBoot
* Swagger
* Gradle
* Groovy + Spock for unit testing
* Protractor + Mocha for integration testing

### Pre-requisites

You need to have Java and Gradle already installed.

### Run the app

Just run the following:

```sh
$ gradle bootRun
```

The app will then be running on:

_http://localhost:8080/algo-impl_


Access Swagger UI for API endpoints here:

_http://localhost:8080/algo-impl/swagger-ui.html_


### Run the unit tests

Just run the following:

```sh
$ gradle test
```

### Run the integration tests

Pre-requesite:

* `$ cd api-tests`
* `$ npm install`
* `$ ./node_modules/protractor/bin/webdriver-manager update`

Make sure your server is running locally (See _'Run the app'_ section)

Then you just need to run the following (inside the _api-tests_ folder):

```sh
$ npm test
```