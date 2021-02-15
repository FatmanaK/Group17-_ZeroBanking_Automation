@activity @wip
Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given the user is logged in

  #Here is for Murat and Levent



Scenario: Verify Account Activity page title
  When the user navigates to "Account Activity" page
  Then "Account Activity" page should have the title "Zero - Account Activity"
  Then In the Account drop down default option should be Savings.
  Then Account drop down should have the following options:
  | Savings     |
  | Checking    |
  | Loan        |
  | Credit Card |
  | Brokerage   |
  Then Transactions table should have column names
  | Date        |
  | Description |
  | Deposit     |
  | Withdrawal  |


  Scenario Outline: Verify different account redirect <link>

  When the user clicks on "<link>" link on the Account Summary page
  Then the "<page>" page should be displayed
  And Account drop down should have "<selectedDropdown>" selected

    Examples:
  | link        | page             | selectedDropdown |
  | Savings     | Account Activity | Savings          |
  | Savings     | Account Activity | Savings          |
  | Checking    | Account Activity | Checking         |
  | Credit Card | Account Activity | Credit Card      |
  | Loan        | Account Activity | Loan             |
