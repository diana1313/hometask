Feature: GitHub Repository Search
  In order to regression testing of GitHub Search Flow
  As a User
  I want to have an ability to search for repository by its name

  Background:
    Given I open GitHub Login page
    And I login with credentials and click on button 'Sign In' on GitHub Login Page:
      | email    | test-user2020-at |
      | password | TesT2020TesT     |

  @first
  Scenario Outline: User search for repository in GitHub
    When I enter repository "<searched_name>" into search input and press Enter on GitHub Main Page
    Then I check "<number_of>" result contains "<searched_name>" of repository I searched for on GitHub Main Page
    Examples:
      | searched_name | number_of |
      | bonigarcia    | 1         |
