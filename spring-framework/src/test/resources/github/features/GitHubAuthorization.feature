Feature: GitHub Authorization
  In order to regression testing of GitHub Authorization Flow
  As a User
  I want to have an ability to  login with valid credentials

  Background:
    Given I open GitHub Login page

  Scenario: Login of user with valid credentials to GitHub
    When I login with credentials and click on button 'Sign In' on GitHub Login Page:
      | email                | password  |
      | nonexisting@test.com | 123456Pwd |
    Then I check I was successfully logged in to GitHub
