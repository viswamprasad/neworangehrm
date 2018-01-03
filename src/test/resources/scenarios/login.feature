Feature: Login Page Tests

  Background:
    Given Load TestCases for "login"

  @login
  Scenario: Login page validations
    Given I am on the "login" page
    When I view login form
    Then The required fields are displayed

  @login
  Scenario: Verify successful login
    Given I am on the "login" page
    When I fill the login form and submit for "Verify valid admin login"
    Then The page is displayed