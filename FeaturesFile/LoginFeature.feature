
Feature: Login

@Sanity
Scenario: Successful Login with Valid Credentials

    Given User Launch Chrome Browser
    When User enter URL "https://admin-demo.nopcommerce.com/login"
    And User enter Email as "admin@yourstore.com" and Password as "admin"
    And User Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Logout link
    Then Page Title should be "Your store. Login"
    And Close Browser
    
    
@Regression
Scenario Outline: Successful Login with Valid Credentials Data Driven

    Given User Launch Chrome Browser
    When User enter URL "https://admin-demo.nopcommerce.com/login"
    And User enter Email as "<email>" and Password as "<password>"
    And User Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Logout link
    Then Page Title should be "Your store. Login"
    And Close Browser
    
 
 Examples:
 |email|password|
 |admin@yourstore.com|admin|	
 |test@yourstore.com|admin|	 	# invalid credentials
 