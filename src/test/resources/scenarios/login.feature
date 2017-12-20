Feature: Login Page Test

  Scenario: Verify successful login
    Given I am on the login page
    When I enter valid credentials
    Then User dashboard page displayed