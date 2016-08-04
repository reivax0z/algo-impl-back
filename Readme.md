## Algo Implementations Project

> This is a back-end project for classic Algorithm implementations.

### Stack

* Java 8
* SpringBoot
* Swagger
* MongoDB
* Gradle
* Groovy + Spock for unit testing
* Protractor + Mocha for integration testing

### Pre-requisites

You need to have Java, MongoDB and Gradle already installed.

##### Install MongoDB

To install MongoDB, run the following commands:

```sh
$ brew install mongodb
```

### Run the app

1) Have MongoDB running in the background:

```sh
$ mongod --config /usr/local/etc/mongod.conf
```

Note that you can access the logs by typing: `$ tail -f /usr/local/var/log/mongodb/mongo.log`

2) Then just run the following:

 ```sh
$ gradle bootRun
```

3) Access the app:

* The app will then be running on:

    _http://localhost:8080/algo-impl_

* Access Swagger UI for API endpoints here:

    _http://localhost:8080/algo-impl/swagger-ui.html_


### Run the unit tests

Just run the following:

```sh
$ gradle test
```

Note that the tests cover more than 70% of lines of code.

### Run the integration tests

1) Pre-requesite:

You need to go to the _api-tests_ folder and install the `npm` dependencies:

* Go to the integration tests folder:

    `$ cd api-tests`

* Install the npm dependencies:

    `$ npm install`

*  You might also need to run the following command to complete the installation:

    `$ ./node_modules/protractor/bin/webdriver-manager update`

2) Make sure your server is running locally (See _'Run the app'_ section)

3) Then you just need to run the following (inside the _api-tests_ folder):

```sh
$ npm test
```