Feature: Login Page Test

  Scenario: Verify successful login
    Given I am on the login page
    When I fill the login form and submit
    Then The page is displayed