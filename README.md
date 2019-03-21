# CucumberTestAutomationExamples project

## Description

testExample project contains a simple Cucumber for Selenium and API Test Automation (RestAssured) sample framework with test examples .

 Note - all features were tested on Windows 32/64 bit and Chrome browser

**Cucumber for Selenium and API Test Automation Framework includes:**
- 'PropertiesManager' - initial test data imported from test.data.properties file
- 'CustomLogger' - Custom Logger to stdout and file including 'WebEventListener' event custom logs based on log4j (configuration file - log4j.properties, logging to logging.log file in main project directory)
- 'SharedTestData' - container for test data that can be dynamically added and used during test execution
- 'ScreenShotOnFailure' - taking screeshot on failure and saving it to .png file in screenShots/ directory
- Ability to choose browser from test.data.properties file ('WebDriverInitializer' class) (package includes webdrivers for chrome and mozilla firefox)
- Supporting POM model

Set up with Cucumber + JUnit and Maven + Selenium WebDriver and Rest Assured, tests written in Java.

## Installation

Download the repository. 

Make sure you have Java and Maven installed on your machine. To check go to cmd and type:

```bash
java -version
mvn -version
```
You should be able to see information about version of your Java and Maven installed. Remember to set up JAVA_HOME and PATH environment variables. If you are not familiar with configuration go to:

[Java installation guide](https://docs.oracle.com/cd/E19509-01/820-3208/inst_cli_jdk_javahome_t/)

[Maven installation guide for Windows](https://www.mkyong.com/maven/how-to-install-maven-in-windows/)

**IntelliJ IDEA instruction:**

To open Maven project:

File -> New -> Project from existing sources -> go do repository folder, click on pom.xml file, click OK -> follow the instructions

Wait for IDE to import all necessary project files.

You may need to select project SDK under File -> Project Structure -> Project Settings -> Project -> Project SDK (1.8)

Run cmd and navigate to your maven project directory (or open terminal in IntelliJ and navigate to directory). Make sure to clean and compile project by typing in:

```bash
mvn clean install -DskipTests
```

## Usage

***1. PROJECT STRUCTURE***

- All core framework classes can be found under ./src/main/java/com/assignment/core
- All POM Pages classes can be found under ./src/main/java/com/assignment/selenium
- All API POJO classes can be found under ./src/main/java/com/assignment/api

*Test classes:*
- All API Test classes can be found under ./src/test/java/com/assignment/api
- All Selenium Test classes can be found under ./src/test/java/com/assignment/selenium

***2. TEST DATA***

All test data can be found in ./src/test/resources/test.data.properties file.

***3. CUSTOM LOGGER***

Custom logger is set to DEBUG mode as default, configuration can be found in ./src/main/resources/log4j.properties. 

DEBUG mode contains all INFO loggs (steps and step related informations) and DEBUG logs specified in 'WebEventListener' class (e.g. beforeNavigateTo, afterNavigateTo, beforeFindBy, afterFindBy etc.). To turn off DEBUG mode and see only INFO logs please change line in log4j.properties from:
```bash
log4j.rootLogger=DEBUG, file, stdout
```
to
```bash
log4j.rootLogger=INFO, file, stdout
```

If you don't want to get logs extracted to file, remove 'file' from line above.

More information about logger levels avaliable in log4j documentation.

***4. RUNNING TESTS***

*FROM IntelliJ:*

- to run chosen test class:

Right click on test class you want to run and click "Run 'testClassName.class'"

- to run chosen test method from test class:

Right click on test methof you want to run and click "Run 'testMethodName()'" or click 'Run Test' button next to method name.

*FROM cmd - maven:*

- to run all tests

```bash
mvn test
```
NOTE: When running all tests, DEBUG logs are not displayed
- to run chosen test class:

```bash
mvn test -Dtest=testClassName
```

- to run chosen test method from test class:

```bash
mvn test -Dtest=testClassName#testMethodName
```
In case of test failure, screenshot can be found in project main folder

## Authors and acknowledgment
Created by Michal Wierzbicki 12.2018

## Project status
Project will be continued in future.
Next to be implemented:

- support for Suite.class running
- support for Cucumber 
