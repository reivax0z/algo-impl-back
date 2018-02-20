## Algo Implementations Project

> This is a back-end project for classic Algorithm implementations.

### Stack

* Java 8
* SpringBoot
* Swagger
* DynamoDB
* Gradle
* Groovy + Spock for unit testing
* Protractor + Mocha for integration testing

### Pre-requisites

You need to have Java, DynamoDB and Gradle already installed.

#### Install DynamoDB locally

[Official AWS Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.html)

#### Run DynamoDB locally

```sh
java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb
```

#### Create table

```sh
aws dynamodb create-table \
    --table-name algo-impl-back-Report \
    --attribute-definitions AttributeName=ID,AttributeType=S \
    --key-schema AttributeName=Id,KeyType=HASH \
    --provisioned-throughput ReadCapacityUnits=1,WriteCapacityUnits=1 \
    --endpoint-url http://localhost:8000
```

### Run the app

 ```sh
$ SPRING_PROFILES_ACTIVE=local gradle bootRun
```

* The app will then be accessible at:

    [_http://localhost:8080/api_](http://localhost:8080/api)

* Access Swagger UI for API endpoints here:

    [_http://localhost:8080/api/swagger-ui.html_](http://localhost:8080/api/swagger-ui.html)


### Run the unit tests

Just run the following:

```sh
$ gradle test
```

Note that the tests cover almost 80% of lines of code overall.

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
