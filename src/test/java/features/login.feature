Feature: User Login
  Scenario: Valid Login
    Given User is on the login page
    When User enters username "Admin" and password "admin123"
    Then User should be redirected to the dashboard