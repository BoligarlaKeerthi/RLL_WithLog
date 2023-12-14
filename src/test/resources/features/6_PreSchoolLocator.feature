Feature: To test PreSchool Search Functionality

  Scenario Outline: Test search PreSchool after login
   Given I open browser and enter the URL	
	 Then I click on login link and enter the email then click continue
	 Then I give the OTP and click submit
	 And I hover on Stores and PreSchool then Select Find PreSchool
	 Then I click on PreSchool Locator location as <location>
	 Then I validate the PreSchool location is <location>

    Examples: 
      |    location   |
      |   "Prayagraj" |
