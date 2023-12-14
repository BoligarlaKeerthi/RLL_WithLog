Feature: To test Shortlist functionality

	Scenario Outline: Test shortlist product after login

		Given I open the browser and enter URL of Firstcry	
		Then I click on login link and enter the email
		Then I click on Footwear and click on Casualshoes product	
		Then I click on Products on the page
		Then I click on ShortList Icon
		Then I Go to ShortList Page
 