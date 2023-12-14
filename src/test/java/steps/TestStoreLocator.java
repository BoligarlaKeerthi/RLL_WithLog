package steps;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import listeners.Loggerhelper;
import pages.HomePage;
import pages.LoggedInPage;
import pages.LoginPage;
import pages.StoreLocatorPage;
import pages.base.Base;

public class TestStoreLocator {
	

	HomePage homePage;
	LoginPage loginPage;
	LoggedInPage loggedInPage;
	StoreLocatorPage storeLocatorPage;
	
	String email;
	String storeType;
	String state;
	String city;
	
	static Logger log = Loggerhelper.getLogger(TestStoreLocator.class);
	
	public void LoadProperties() throws IOException {
        FileReader reader = new FileReader(".\\src\\test\\resources\\application.properties");
        Properties props = new Properties();
        props.load(reader);
        email = props.getProperty("email");
    }
	
	
	@Given("I open the browser and enter URL of the Page")
	public void i_open_the_browser_and_enter_url_of_the_page() throws IOException {
		homePage = new HomePage(Base.getDriver());
        loginPage = new LoginPage(Base.getDriver());
        loggedInPage = new LoggedInPage(Base.getDriver());
        storeLocatorPage = new StoreLocatorPage(Base.getDriver());
        LoadProperties();
        log.info("User opened Application in browser");
	}

	@Then("I Click on login link and enter the Email")
	public void i_click_on_login_link_and_enter_the_email() throws InterruptedException {
		homePage.clickOnLogin();
        loginPage.email.sendKeys(email);
        Thread.sleep(2000);
        loginPage.continueBtn.click();
        Thread.sleep(30000);
        loginPage.verifyOtpBtn.click();
        log.info("User entered into Loggedin page");
	}

	@Then("I click on Stores Section and click on Find Stores from DropDown Menu")
	public void i_click_on_stores_section_and_click_on_find_stores_from_drop_down_menu() throws InterruptedException {
		loggedInPage.goToStoresPage();
	    Thread.sleep(1000);
	    log.info("User clicked on Store sction and Selected store from menu");
	}

	@Then("I Search For the Store Locator with {string}, {string} and {string}")
	public void i_search_for_the_store_locator_with_and(String storeType, String state, String city) throws InterruptedException {
	    this.storeType = storeType;
	    this.state = state;
	    this.city = city ;
		storeLocatorPage.selectStoreType(storeType);
	    Thread.sleep(1000);
	    storeLocatorPage.selectState(state);
	    Thread.sleep(1000);
	    storeLocatorPage.selectCity(city);
	    Thread.sleep(1000);
	    storeLocatorPage.submitBtn.click();
	    log.info("User Selected the required location of store");
	}

	@Then("I click on Search Icon")
	public void i_click_on_search_icon() throws InterruptedException {
		storeLocatorPage.submitBtn.click();
		Thread.sleep(5000);
		log.info("User Clicked on search button");
	}
	
	@Then("I verify the search result")
	public void i_verify_the_search_result() throws  IOException, InterruptedException {
	    Assert.assertEquals(storeLocatorPage.verifyLocation.getText(), city);
	    storeLocatorPage.goBack();
	    log.info("User verified the result of searched location");
	    }
}
