# Cucumber-Tests-in-Spring-Boot-with-CI-CD


This repository contains a sample Spring Boot application that uses Cucumber and JUnit Platform for testing, along with a GitHub Actions workflow for continuous integration and delivery (CI/CD). The tests can be run in two different environments and multiple browsers in parallel.

## Requirements

To run the tests in this repository, you will need the following:

- Java 17 or later
- Maven 3.8.0 or later
- Chrome and Edge browsers installed on your system (no need for driver as Webdriver Manager is used)

## Running the Tests

To run the tests locally, you can use the following command:
``mvn clean verify``

This will run the Cucumber tests using JUnit Platform on Chrome and dev environment and generate a report in the `target/failsafe-reports` directory.

To run the tests in parallel on Edge and qa environment, you can use the following command:
``mvn clean verify -P qa,edge,local``

To run the tests remotely, you can use the following command:
``mvn clean verify -P dev,chrome,remote``
This will run the tests on Chrome and dev environment in parallel using Selenium Grid.

### Using WebDriver Factory

This repository also uses WebDriver Factory to manage the WebDriver instances. The factory creates a new WebDriver instance for each scenario and closes it after the scenario has completed. This allows for better control and management of the WebDriver instances.


## GitHub Actions Workflow

The repository includes a GitHub Actions workflow that runs the tests on push and pull request events. The workflow is defined in the `.github/workflows/ci.yml` file and uses the `actions/checkout` action to check out the repository, and the `actions/setup-java` action to set up the Java environment.

The workflow then runs the tests using the `maven-verify` action, which is a community action that runs the `mvn verify` command. The action is configured to run the tests on both Chrome and Firefox in parallel using Selenium Grid.

## Environment Variables

The following environment variables are used in the GitHub Actions workflow:

- `CI_SERVER`: The name of the CI server (set to `GitHub Actions` by default).
- `SELENIUM_HUB_URL`: The URL of the Selenium Grid hub (set to `http://localhost:4444/wd/hub` by default).
- `TEST_ENV`: The environment to run the tests in (set to `dev` by default).
- `BROWSER`: The browser to run the tests on (set to `chrome` by default).

These environment variables can be customized to fit your specific needs.

## Conclusion

This repository demonstrates how to use Cucumber and JUnit Platform for testing in a Spring Boot application, along with GitHub Actions for continuous integration and delivery. With the ability to run the tests in two different environments and multiple browsers in parallel, you can ensure that your application works as expected in a variety of scenarios.
