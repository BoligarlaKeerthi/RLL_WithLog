Feature: To test store locator functionality

  Scenario Outline: Test StoreLocator after login
    Given I open the browser and enter URL of the Page
    Then I Click on login link and enter the Email
    Then I click on Stores Section and click on Find Stores from DropDown Menu
    Then I Search For the Store Locator with "<StoreType>", "<State>" and "<City>"
    Then I click on Search Icon

    Examples:
      | StoreType | State | City |
      |FirstCry|Uttar Pradesh|Prayagraj Civil Lines|

