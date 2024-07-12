
Feature: Customer

Background: Steps Common for all Scenarios

		Given User Launch Chrome Browser
    When User enter URL "https://admin-demo.nopcommerce.com/login"
    And User enter Email as "admin@yourstore.com" and Password as "admin"
    And User Click on Login
    Then User land on Dashboard

@Sanity
  Scenario: Add New Customer
    
    When User click on Customers Menu
    And Click on Customers option
    And Click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And Click on Save button
    Then User can view confirmation message "The new customer has been added successfully"
    And Close Browser


@Regression
   Scenario: Search Customer by Email
	   
	    When User click on Customers Menu
    	And Click on Customers option
    	And Enter customer Email
    	When CLick on Search button
    	Then User should found Email in the Search table
    	And Close Browser
    	
@Regression   	
   Scenario: Search Customer By Name
	    
	    When User click on Customers Menu
    	And Click on Customers option
    	And Enter customer FirstName
    	And Enter customer LastName
    	When CLick on Search button
    	Then User should found Name in the Search table
    	And Close Browser
	    
   