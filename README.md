# Group17-_ZeroBanking_Automation
First Team Collabration of Group 17

Description
In this assignment you will create an automated testing framework for testing Zero online banking application. The framework will use Cucumber BDD and Selenium.

Project set up

1. Create a maven project.Use group-id com.zerobank and artifact-idzerobank- automation. Add all the required dependencies for Cucumber and Selenium to the pom file. Also add required plugins for HTML reporting with cucumber.

2. Undersrc/test/javacreatefollowingpackages: 
  a. com.zerobank.pages
  b. com.zerobank.runners
  c. com.zerobank.stepdefnitions d. com.zerobank.utilities

3. Under src/test create following directory resources. Mark the new resources directory as a test resource folder.

4. Under the src/test/resources create new folder features.

5. Under the project folder add  fileconfiguration.properties.

6. Under utilities package create ConfigurationReader which reads from the
properties file.

7. Under utilities package create Driverutility which can create a new web
driver object based on value from configuration.properties.

8. Under utilities package create BrowserUtils based on the example shown in
the class. You can more methods to this utility as you see fit.

9. Under runner package create CukesRunner based on the example shown in the class. In this class you can use any CucumberOptions as you see fit.

NOTE: This picture shows what packages you should have up completion of steps 1 to 4.

   
   Write feature files
Write feature files based on the following requirements. Create one feature file per requirement. Each feature file can have multiple requirements.

Login
Only authorized users should be able to login to the application. When user logs in with valid credentials, Account summary page should be displayed.
Users with wrong username or wrong password should not be able to login. Users with blank username or password should also not be able to login. When user tries to login with invalid information, error message Login and/or password are wrong. should be displayed.

Account summary
Account summary page should have the title Zero – Account summary. Account summary page should have to following account types: Cash Accounts, Investment Accounts, Credit Accounts, Loan Accounts. Credit Accounts table must have columns Account, Credit Card and Balance.

Account Activity
Account Activity page should have the title Zero – Account activity.
In the Account drop down default option should be Savings. Account drop down should have the following options: Savings, Checking, Loan, Credit Card, Brokerage. Transactions table should have column names Date, Description, Deposit, Withdrawal.

Pay Bills
Account Activity page should have the title Zero – Pay Bills. When user completes a successful Pay operation, The payment was successfully submitted. should be displayed. When user tries to make a payment without entering the amount or date, Please fill out this field message! should be displayed.
Amount field should not accept alphabetical or special characters. Date field should not accept alphabetical characters.
NOTE: . For the date input field you can just use sendKeys. No need to click on the date navigator.


   Automate following scenarios
NOTE: You can modify the feature files based on your needs


  AccountActivityNavigation.feature
Feature: Navigating to specific accounts in Accounts Activity 

Scenario: Savings account redirect
Given the user is logged in
When the user clicks on Savings link on the Account Summary page 
Then the Account Activity page should be displayed
And Account drop down should have Savings selected

Scenario: Brokerage account redirect Given the user is logged in
When the user clicks on Brokerage link on the Account Summary page 
Then the Account Activity page should be displayed
And Account drop down should have Brokerage selected

Scenario: Checking account redirect Given the user is logged in
When the user clicks on Checking link on the Account Summary page 
Then the Account Activity page should be displayed
And Account drop down should have Checking selected

Scenario: Credit Card account redirect Given the user is logged in
When the user clicks on Credit card link on the Account Summary page 
Then the Account Activity page should be displayed
And Account drop down should have Credit Card selected

Scenario: Loan account redirect Given the user is logged in
When the user clicks on Loan link on the Account Summary page 
Then the Account Activity page should be displayed
And Account drop down should have Loan selected

 
   FindTransactions.feature
Feature: Find Transactions in Account Activity 

Scenario: Search date range
Given the user accesses the Find Transactions tab
When the user enters date range from “2012-09-01” to “2012-09-06”
And clicks search
Then results table should only show transactions dates between “2012-09-01” to “2012-09-06”
And the results should be sorted by most recent date
When the user enters date range from “2012-09-02” to “2012-09-06”
And clicks search
Then results table should only show transactions dates between “2012-09-02” to “2012-09-06”
And the results table should only not contain transactions dated “2012-09-01”

Scenario: Search description
Given the user accesses the Find Transactions tab
When the user enters description “ONLINE”
And clicks search
Then results table should only show descriptions containing “ONLINE” When the user enters description “OFFICE”
And clicks search
Then results table should only show descriptions containing “OFFICE” But results table should not show descriptions containing “OFFICE”

Scenario: Search description case insensitive
Given the user accesses the Find Transactions tab
When the user enters description “ONLINE”
And clicks search
Then results table should only show descriptions containing “ONLINE” When the user enters description “online”
And clicks search
Then results table should only show descriptions containing “ONLINE”

Scenario: Type
Given the user accesses the Find Transactions tab
And clicks search
Then results table should show at least one result under Deposit 
Then results table should show at least one result under Withdrawal 
When user selects type “Deposit”
Then results table should show at least one result under Deposit
But results table should show no result under Withdrawal
When user selects type “Withdrawal”
Then results table should show at least one result under Withdrawal 
But results table should show no result under Deposit

  Add New Payee.feature
Feature: Add new payee under pay bills 

Scenario: Add a new payee
Given Add New Payee tab
And creates new payee using following information
|Payee Name |Payee Address |Account
| The Law Offices of Hyde, Price & Scharks| | 100 Same st, Anytown, USA, 10001 | | Checking |
| XYZ account | successfully created. should be displayed

PurchaseForeignCurrency.feature
Feature: Purchase Foreign Currency 

Scenario: Available currencies
Given the user accesses the Purchase foreign currency cash tab Then following currencies should be available
|Australia (dollar) |
|Payee details|
Then message The new payee The Law Offices of Hyde, Price & Scharks was successfully created. should be displayed

  PurchaseForeignCurrency.feature
Feature: Purchase Foreign Currency

Scenario: Available currencies
Given the user accesses the Purchase foreign currency cash tab 
Then following currencies should be available
|Canada (dollar) | 
|Switzerland (franc) | 
|China (yuan) | 
|Denmark (krone) | 
|Eurozone (euro) | 
|Great Britain (pound)| 
|Japan (yen) |
|Mexico (peso) | 
|Norway (krone) | 
|New Zealand (dollar) | 
|Singapore (dollar) |

Scenario: Error message for not selecting currency
Given the user accesses the Purchase foreign currency cash tab
When user tries to calculate cost without selecting a currency
Then error message should be displayed Scenario: Error message for not entering value
Given the user accesses the Purchase foreign currency cash tab 
When user tries to calculate cost without entering a value 
Then error message should be displayed
