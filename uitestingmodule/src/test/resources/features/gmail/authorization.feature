 Feature: Gmail Authorization
  In order to regression testing of Gmail Authorization Flow
  As a User
  I want to have an ability to 'log in' and 'log out'

  Background:
    Given I open Gmail Login page

  Scenario Outline: User authorization with valid credentials
    When I enter <user_email> into 'email' field and press enter on Gmail Login Page
    And I enter <user_password> into 'password' field and press enter on Gmail Login Page
    Then I check that I was successfully logged in with email <user_email> to Gmail Inbox
    Examples:
      | user_email                   | user_password |
      | test.user.john2020@gmail.com | TesT2020      |

  Scenario Outline: User authorization with invalid email
    When I enter <user_email> into 'email' field and press enter on Gmail Login Page
    Then I check that error message with text appeared on Gmail Login Page:
    """
    Enter a valid email or phone number
    """
    Examples:
      | user_email                 |
      | test.user.john2020@cfgfgfd |

  Scenario Outline: User authorization with invalid password
    When I enter <user_email> into 'email' field and press enter on Gmail Login Page
    And I enter <user_password> into 'password' field and press enter on Gmail Login Page
    Then I check that error message with text appeared on Gmail Login Page:
    """
    Wrong password. Try again or click Forgot password to reset it.
    """
    Examples:
      | user_email                   | user_password |
      | test.user.john2020@gmail.com | XXXXXXXX      |

  Scenario Outline: User is able to logout
    When I enter <user_email> into 'email' field and press enter on Gmail Login Page
    And I enter <user_password> into 'password' field and press enter on Gmail Login Page
    Then I check that I was successfully logged in with email <user_email> to Gmail Inbox
    When I make logout from my account on Gmail Inbox Page
    Then I check that I was logged out and got back to Gmail Login Page
    Examples:
      | user_email                   | user_password |
      | test.user.john2020@gmail.com | TesT2020      |