Feature: Gmail Authorization
  In order to regression testing of Gmail Authorization Flow
  As a User
  I want to have an ability to 'log in' and 'log out'

  Background:
    Given I open Gmail Login page

  Scenario Outline: User authorization with valid credentials
    When I enter <user_email> into email field and press enter on Gmail Login Page
    And I enter <user_password> into password field and press enter on Gmail Login Page
    Then I check that I was successfully logged in with email <user_email> to Gmail Inbox
    Examples:
      | user_email                   | user_password |
      | test.user.john2018@gmail.com | TesT2018      |


