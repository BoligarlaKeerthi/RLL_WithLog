Feature: To test Login Functionality

  Scenario Outline: Login with email
    Given I open the application
    And Click on Login 
    When I give the email
    And Click continue
    And Give the OTP and click Submit
    Then I go to the My Account then My Profile
    And verify the email

    
