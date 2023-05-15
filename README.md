# Cucumber-Tests-in-Spring-Boot-with-CI-CD
[![Cucumber Test](https://github.com/Malena49/Cucumber-Tests-in-Spring-Boot-with-CI-CD/actions/workflows/maven.yml/badge.svg)](https://github.com/Malena49/Cucumber-Tests-in-Spring-Boot-with-CI-CD/actions/workflows/maven.yml)

This repository contains a sample Spring Boot application that uses Cucumber and JUnit Platform for testing, along with a GitHub Actions workflow for continuous integration and delivery (CI/CD). The tests can be run in two different environments and multiple browsers in parallel.

## Requirements

To run the tests in this repository, you will need the following:

- Java 17 or later
- Maven 3.8.0 or later
- Chrome and Edge browsers installed on your system (no need for driver as Webdriver Manager is used)

## Running the Tests

To run the tests locally, you can use the following command:
``mvn clean verify``

To build project without running test, you can use the following command:
``mvn clean verify -DskipTests``

This will run the Cucumber tests using JUnit Platform on Chrome and dev environment and generate a report in the `target/failsafe-reports` directory.

To run the tests in parallel on Edge and qa environment, you can use the following command:
``mvn clean verify -P qa,edge,local``

To run the tests remotely, you can use the following command:
``mvn clean verify -P dev,chrome,remote``
This will run the tests on Chrome and dev environment in parallel using Selenium Grid.

### Using WebDriver Factory

This repository also uses WebDriver Factory to manage the WebDriver instances. The factory creates a new WebDriver instance for each scenario and closes it after the scenario has completed. This allows for better control and management of the WebDriver instances.


## GitHub Actions Workflow

This repository contains a workflow file that automates the execution of Cucumber tests using GitHub Actions. The workflow is triggered whenever a push event occurs on the `main` branch. It utilizes a matrix strategy to run tests on different browsers and in the `dev` environment.

The workflow file `cucumber-test.yml` defines a single job named "Test" that runs on the latest version of Ubuntu. It sets up a Selenium service using Docker images for the specified browser, exposing port 4444.

### Job Configuration

The job configuration includes the following steps:

1. **Checkout code**: This step checks out the repository code using the `actions/checkout` action.

2. **Set up JDK**: This step sets up the Java Development Kit (JDK) using the `actions/setup-java` action. It specifies the JDK version as 17 and uses the 'temurin' distribution.

3. **Run Cucumber tests**: This step executes the Cucumber tests using the Maven command `mvn clean verify`. It utilizes the values from the matrix strategy (`matrix.environment` and `matrix.browser`) as command-line parameters. The tests are run in a remote configuration.

4. **Upload a Build Artifact**: This step uploads a build artifact named "Cucumber report" using the `actions/upload-artifact` action. The artifact consists of the Cucumber test report generated in the `./target/failsafe-reports/cucumber` directory.


## Conclusion

This repository demonstrates how to use Cucumber and JUnit Platform for testing in a Spring Boot application, along with GitHub Actions for continuous integration and delivery. With the ability to run the tests in two different environments and multiple browsers in parallel, you can ensure that your application works as expected in a variety of scenarios.
