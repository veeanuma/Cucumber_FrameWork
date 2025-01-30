@logout @regression
Feature: User Logout Functionality
  As a user, I want to log out of the application so that my session is securely terminated.

  Background:
    Given User is on the login page
    Given User is logged in with valid credentials
      | username | Admin    |
      | password | admin123 |

  @smoke
  Scenario: Successful Logout from Dashboard
    When User clicks on the logout button
    Then User should be redirected to the login page

  @smoke
  Scenario: click on admin from Dashboard
    When User clicks on the Admin button
    Then User should be redirected to the viewSystemUsers page
