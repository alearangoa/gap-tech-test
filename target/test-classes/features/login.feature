@LoginTests

Feature: Login into Vacation Management system

  Scenario: User can login into Vacation Management system
    Given The user is on "https://vacations-management.herokuapp.com/users/sign_in" site
    When  The user login in with right credentials
    Then  The user should see the logo of the site
    And   The user should see the successful message on the banner
    And   The user should see his name on the banner
