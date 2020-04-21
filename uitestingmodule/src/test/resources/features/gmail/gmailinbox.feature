Feature: Gmail Inbox Functionality
  In order to regression testing of Gmail Inbox Functionality
  As a User
  I want to have an ability to write and delete letters,save it as a draft, etc.

  Background:
    Given I open Gmail Login page

  @debug
  Scenario Outline: User authorization with valid credentials
    When I enter "test.user.john2020@gmail.com" into 'email' field and press enter on Gmail Login Page
    And I enter "TesT2020" into 'password' field and press enter on Gmail Login Page
    Then I check that I was successfully logged in with email "test.user.john2020@gmail.com" to Gmail Inbox
    When I invoke 'Write Letter dialog' on Gmail Inbox Page
    When I fill input fields of 'Write Letter dialog' with set of following data and SEND email:
      | input_name | value                        |
      | cc         | test.user.john2018@gmail.com |
      | subject    | <subject>                    |
      | body       | Test email body , John Smith |
    When I open a tab "Sent" from side menu on Gmail Inbox page
    Then I the letter with <subject> is present in Sent
    When I delete the message with <subject> from Sent
    Then I check there is no messages in Sent
    Examples:
      | subject            |
      | Test email subject |