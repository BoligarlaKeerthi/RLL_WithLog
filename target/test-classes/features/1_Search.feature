Feature:To test Search Functionality 

  Scenario Outline: Test valid product search after login
    Given I open the browser and enter the URL 	
		Then I click on the login link and enter the email
  	When I enter a valid product name as <productName> in the search bar
    And I click on the search button
    
    Examples: 
      | productName|
      | "Footwear" |
      |   "Shoes"  |