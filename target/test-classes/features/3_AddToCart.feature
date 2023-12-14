Feature: To test Add to Cart functionality

	Scenario Outline: Test adding product after login

		Given I open the browser and enter URL
		Then I click on Login link and enter the email id
		Then I verify the <title> of the FirstCryPage
		Then I click on Footwear and click on Casualshoes	
		Then I click on Product on the page
		Then I click on Add to cart page
		Then I click on Go to Cart page


			Examples: 
      	|                                         title                                            | 
      	|"Baby Products Online India: Newborn Baby Products & Kids Online Shopping at FirstCry.com"|  
      	