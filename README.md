# CucumberTestAutomationExamples

## Description

testExample project contains a simple Cucumber for Selenium and API Test Automation (RestAssured) sample framework with test examples .

 Note - all features were tested on Windows 32/64 bit and Chrome browser

**Selenium Test Automation Framework includes:**
- 'PropertiesManager' - test data imported from test.data.properties file
- 'CustomLogger' - Custom Logger to stdout and file including 'WebEventListener' event custom logs based on log4j (configuration file - log4j.properties, logging to logging.log file in main project directory)
- 'SharedTestData' - container for test data that can be used during test execution
- 'ScreenShotOnFailure' - taking screeshot on failure for Junit tests and saving it to .png file in screenShots/ directory.
For Cucumber tests run from CucumberTestRunners report with screenshot will be generated in target/Cucumber directory
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

**To support Cucumber you'll need to install Cucumber for Java plugin**

File -> Settings -> Plugins -> enter 'Cucumber for Java' in the search field and click 'Install'.

Create a new file - Right click -> New -> File -> <fileName.feature>
Now you should be able to see .feature files with the cucumber mark.

Run cmd and navigate to your maven project directory (or open terminal in IntelliJ and navigate to directory). Make sure to clean and compile project by typing in:

```bash
mvn clean install -DskipTests
```

## Usage

***1. PROJECT STRUCTURE***

- All core framework classes can be found under ./src/main/java/com/assignment/core
- All POM classes can be found under ./src/main/java/com/assignment/selenium
- All API POJO classes can be found under ./src/main/java/com/assignment/api

*Junit Test classes:*
- All API Test classes can be found under ./src/test/java/com/assignment/junitTests/api
- All Selenium Test classes can be found under ./src/test/java/com/assignment/junitTests/selenium

*Cucumber Test Classes:*
- All Stef Definitions classes can be found under ./src/test/java/com/assignment/cucumberTests/stepDefinitions
- All Feature files can be found under ./src/test/resources/features
- All TestRunners classes can be found under ./src/test/java/com/assignment/cucumberTests

***2. TEST DATA***

*Junit Test data:*
Test data can be found in ./src/test/resources/test.data.properties file.

*CucumberTest data:*
Test data can be found in feature files in ./src/test/resources/features.

If test needs some additional data SharedTestData can be used.

***3. SHARED TEST DATA***

'SharedTestData' is a container for test data that can be dynamically used during test execution.

To add data to 'SharedTestData' simply use addData(String key, String value) method.
To get data from 'SharedTestData' simply use getData(String key) method.

***4. CUSTOM LOGGER***

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

***5. RUNNING TESTS***

**JUnit tests**

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

**Cucumber tests**

*FROM IntelliJ:*

- to run chosen type of scenarios API/Selenium:

Use CucumberTestRunner classes located in ./src/test/java/com/assignment/cucumberTests directory.

CucumberTestRunnerApi.java will trigger scenarios with @API tag
CucumberTestRunnerSelenium.java will trigger scenarios with @Selenium tag

- to run scenario/scenarios with chosen tag:

Use TestRunner class and modify 'tags = "@yourTag"'

- to run chosen feature file:


    Click on the feature file you want to run
    In the Run menu Select Run…
    In the contextual menu, select the feature, then “Edit…”
    You should now see the ‘Edit Configuration Settings’ window. Set the main class to ‘cucumber.api.cli.Main’
    Change the Glue field to the root package of your project (or of your step definitions)
    Click Apply

If you have a hard time to follow the instructions go to the [Running tests from feature files guide](https://johnfergusonsmart.com/running-cucumber-serenity-feature-files-directly-intellij/) (look at the GIF)

**You won't need to go through this steps once you set this up.**
Then you'll be able just to Right click on test class you want to run and click "Run 'testClassName.class'".

- to run chosen scenario from feature file:

(Needs set up from above)
Right click on scenario you want to run and click "Run 'testMethodName()'".

*FROM cmd - maven:*

- to run all tests

```bash
mvn test
```
NOTE: When running all tests, DEBUG logs are not displayed
- to run chosen type of scenarios:

```bash
mvn test -Dtest=testRunnerClassName
```

- to run scenario/scenarios with chosen tag or modify other cucumber options:

```bash
mvn test –DCucumber.options="Your Options"
```
e.g. running scenario with chosen tag:
```bash
mvn test –DCucumber.options="--tags @yourTag"
```

If you need help on these Cucumber options, then enter the following command in the command prompt and look at the output:
```bash
mvn test -Dcucumber.options="--help"
```
Report with screenshot (for failed scenario) will be generated in target/Cucumber directory.

## Authors and acknowledgment
Created by Michal Wierzbicki 12.2018

Updated by Michal Wierzbicki 03.2019

Updated by Michal Wierzbicki 08.2019

## Project status
Project will be continued in future.
