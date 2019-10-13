@CreateEmployeesTests

Feature: Users management screen validations

  Scenario Outline: New user can be created trough 'Administrative User' screen
    Given The user is logged on "https://vacations-management.herokuapp.com/users/sign_in" site
    When  The user enters to 'New Employee' page
    And   The user creates a new employee with <firstName>, <lastName>, <email>, <Id>, <leaderName>, <startYear>, <startMonth>, <startDay>
    Then  The new employee should be created on 'Listing Employees' Page
    But   The user clicks on 'Delete' link of the created employee
    Then  The created employee should be deleted
    Scenarios:
      | firstName | lastName | email          | Id       | leaderName       | startYear | startMonth | startDay |
      | James     | Smith    | jsmith@gap.com | 12345678 | Alejandra Arango | 2014      | 01         | 21       |