@login
Feature: User should be able to login
  @wip
  Scenario: Only authorized users should be able to login
    Given the user is on the login page
    When the user enters valid credentials
    Then Account summary page should be displayed

  @wip
  Scenario Outline: Users should not be able to login with <userNameType> username and <passWordType> password
    Given the user is on the login page
    When the user enters "<userNameType>" "<userName>" username and "<passWordType>" "<passWord>" password
    Then The error message "Login and/or password are wrong." should be displayed.
    Examples:

      | userNameType | userName      | passWordType | passWord      |
      | wrong        | wrongUsername | valid        | password      |
      | valid        | username      | wrong        | wrongPassword |
      | blank        |               | valid        | password      |
      | valid        | username      | blank        |               |