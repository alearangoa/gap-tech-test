# Growth Acceleration Partners - Technical Exercise

![](gap-tech-test-results.gif)

## Table of Contents

- [1. Challenge](#1-challenge)
  - [1.1. User Stories](#11-user-stories)
- [2. Stack](#2-stack)
- [3. Getting Started](#3-getting-started)
  - [3.1. Requirements](#31-requirements)
  - [3.2. Setup environment](#32-setup-environment)
- [4. Folder Structure](#4-folder-structure)
- [5. Author](#author)

## 1. QA Automation Test

### 1.1. User Stories

Feature: Login into Vacation Management system

**_Scenario:_** User can login into Vacation Management system

**Given** The user is on "https://vacations-management.herokuapp.com/users/sign_in" site

**When** The user login in with right credentials

**Then** The user should see the logo of the site

**And** The user should see the successful message on the banner

**And** The user should see his name on the banner


Feature: Users management screen validations


**_Scenario:_** New user can be created trough 'Administrative User' screen

**Given** The user is logged on "https://vacations-management.herokuapp.com/users/sign_in" site

**When** The user enters to 'New Employee' page

**And** The user creates a new employee with 'firstName', 'lastName', 'email', 'Id', 'leaderName', 'startYear', 'startMonth', 'startDay'

**Then** The new employee should be created on 'Listing Employees' Page

**But** The user clicks on 'Delete' link of the created employee

**Then** The created employee should be deleted

    Scenarios:
      | firstName | lastName | email          | Id       | leaderName       | startYear | startMonth | startDay |
      | James     | Smith    | jsmith@gap.com | 12345678 | Alejandra Arango | 2014      | 01         | 21       |


## 2. Stack

The project was build under above technologies

- Selenium v3.9.1
- Cucumber v1.2.5
- Java v11.0.4
- OS Windows 
- Chrome Driver v77.0.3865.40

## 3. Getting Started

### 3.1. Requirements

- [Maven](https://docs.wso2.com/display/IS323/Installing+Apache+Maven+on+Windows)
- Standard Edition Development Kit (JDK™)

### 3.2. Setup environment

1. Check that the system meet the requirements.
2. Clone repository from ´https://github.com/alearangoa/gap-tech-test.git´
3. Run ´mvn -Dtest=CucumberRunner test´


```bash
$ git clone https://github.com/alearangoa/gap-tech-test.git
$ cd gap-tech-exercise
$ mvn -Dtest=CucumberRunner test
```

## 4. Folder Structure

```
gap-tech.test
 ┣ data_pool
 |   └── Data.java
 ┣ pages
  |   └── CreateNewEmployeePage.java
  |   └── HomePage.java
  |   └── LoginPage.java
      └── VacationManagementPage.java
 ┣ steps_definition
  |   └── CreateEmployeesSteps.java
  |   └── LoginPageSteps.java
 ┣ support
  |   └── AutomationWebDriver.java
 ┣ cucumberRunner.java
 ┣ resources
  |   └── features
  |         └── CreateEmployee.feature
  |         └── Login.feature
  |   └── ChromeDriver.exe
 ┣ README.md
```
An overview of what each of these does:

| FILE / DIRECTORY |      Description                                  |
|------------------|-------------------------------------------------|
| data_pool        | Aim of data needed on the project execution       | 
| locators         | Contains a java file with used test locators  | 
| pages            | Pages of vacations-management site based on POM             | 
| steps_definition | Java method with an expression that links it to one or more Gherkin steps. | 
| support          | Automation Web Driver configuration and methods | 
| resources        | Chrome Driver and features based on BDD| 


## Author

[Alejandra Arango Arcila]