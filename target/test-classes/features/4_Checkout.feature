Feature: To test Checkout functionality

	Scenario Outline: Test Checkout after login
    Given I open the browser and enter the app URL 	
		Then I click on the login link and enter email and submit OTP
		Then I open Cart and Proceed to Checkout
		And I select COD and then submit to check for the status order placed

    
