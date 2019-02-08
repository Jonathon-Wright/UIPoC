Feature: Login
  As a user
  I want to access Volo2
  So that I can list products to channels

  Rules:
  * The user must be informed if the login information is incorrect
  * The user must be informed if the login is successful

  Glossary:
  * User: Anyone who wishes to list a product to a channel using the Volo2 platform

  @e2e
  @integration
  @component
  Scenario Outline: Navigate and login to the application
    Given I navigate to the login page
    When I enter the login details for a '<userType>'
    Then I can see the following message: '<validationMessage>'
    Examples:
      | userType  | validationMessage |
      | validUser | Welcome to Volo   |

  @component
  Scenario Outline: Error message displayed and access denied upon entering incorrect credentials
    Given I navigate to the login page
    When I enter the login details for a '<userType>'
    Then I can see the following message: '<validationMessage>'
    Examples:
      | userType    | validationMessage            |
      | invalidUser | Invalid username or password |