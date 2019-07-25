# MobySoft Tech Test
#### Developer, Andy McCall, andy.mccall@gmail.com

The repository hosts a solution for the MobySoft Tech Test as of the 25th July 2019.

The solution has been built using Java 8 and the Spring Framework. With more time I would have looked at adding an Angular front end to display the results, but this seems out of scope for the tech test.

The project has been built using SOLID principles using well known design patterns.

## Project Status

[![Build Status](https://travis-ci.org/andymccall/mobysoft-recruitment.svg?branch=master)](https://travis-ci.org/andymccall/mobysoft-recruitment) [![Coverage Status](https://coveralls.io/repos/github/andymccall/mobysoft-recruitment/badge.svg?branch=master)](https://coveralls.io/github/andymccall/mobysoft-recruitment?branch=master)

## Build and Environment

The application has been created using the IntelliJ IDE.  To run via the IDE, checkout the project from GitHub and or unzip the provided archive.

To test and package the project using maven on the command line run the following:

    mvn package

## Running

On Linux ensure the resources folder and the Recruitment-1.0-SNAPSHOT.jar file are in the same directory.  Ensure you are logged in with a user that has permissions to access the file system and ru the following:

    root@linux-server:/opt/mobysoft-recruitment# java -Djava.net.preferIPv4Stack=true -jar Recruitment-1.0-SNAPSHOT.jar

You should then be able to browse to the application on http://localhost:8080 if you have launched in on your local workstation.  If you have launched it on a server you will need to ensure the port between your workstation and the server is not being blocked by the firewall and the you are not configured to use a proxy.

## REST Endpoints

GET /api/v1/transactions
    - Read a list of all transactions

GET /api/v1/transactions/fortnightly
    - Read a list of all fortnightly transactions

GET /api/v1/transactions/fourweekly
    - Read a list of all four weekly transactions

GET /api/v1/transactions/monthly
    - Read a list of all monthly transactions

GET /api/v1/transactions/weekly
    - Read a list of all weekly transactions

## Documentation

Documentation is provided via Swagger.  Once the project is running the documentation can be found at:

http://localhost:8080/swagger-ui.html

Again, if running on a remote server replace the localhost with the server name or IP address.

## Testing

To run the projects unit tests using maven on the command line run the following:

    mvn test

Testing has been performed using JUnit and Mockito.  Code coverage reports have been produced using Jacoco and are presented by Coveralls.io.

If working with a Business Analyst on the project it would have been beneficial to use Cucumber for BDD.  For the purpose of this test I have not included this.

## CI / CD Pipeline

The project is hosted on a public GitHub.com repository.  Upon commit a private Travis-CI.com build initiates, builds and tests the project.  An after-success option in the .travis.yml triggers Codecov.io to produce code coverage reports.

The next logical step for this CI/CD pipeline is upon a successful build publish straight into AWS Elastic BeanStalk, however I feel this is out of the scope of the tech test and would take longer then the time I have allowed to completed the test.

I would also look at automatic load testing using LoadImpact.com.