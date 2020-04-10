Feature: GitHub Repository Search
  In order to regression testing of GitHub Search Flow
  As a User
  I want to have an ability to search for repository by its name

  Background:
    Given I open GitHub Login page
    When I login with credentials and click on button 'Sign In' on GitHub Login Page:
      | email                | password  |
      | nonexisting@test.com | 123456Pwd |
    Then I check I was successfully logged in to GitHub

  Scenario: User search for repository in GitHub
    When I enter
