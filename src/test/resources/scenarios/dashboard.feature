Feature: Dashboard Page Tests

  Background:
#    Given Load TestCases for "login"
#    Given I am on the "login" page
#    Given I fill the login form and submit for "Verify valid admin login"
    Given Load TestCases for "dashboard"
    Given I am already logged in

  @dashboard
  Scenario: Validate dashboard page
    Given I am on the "dashboard" page
    When I view welcome message
    Then "Admin" text is displayed

