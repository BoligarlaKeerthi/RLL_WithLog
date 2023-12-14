package steps;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import listeners.Loggerhelper;
import pages.HomePage;
import pages.LoggedInPage;
import pages.LoginPage;
import pages.base.Base;

public class TestSearch {
	
	HomePage homePage;
	LoginPage loginPage;
	LoggedInPage loggedInPage;
	
	String email;
	
	static Logger log = Loggerhelper.getLogger(TestSearch.class);
	
	public void LoadProperties() throws IOException {
        FileReader reader = new FileReader(".\\src\\test\\resources\\application.properties");
        Properties props = new Properties();
        props.load(reader);
        email = props.getProperty("email");
    }
	
	@Given("I open the browser and enter the URL")
	public void i_open_the_browser_and_enter_the_url() throws IOException {
		homePage = new HomePage(Base.getDriver());
        loginPage = new LoginPage(Base.getDriver());
        loggedInPage = new LoggedInPage(Base.getDriver());
        LoadProperties();
        log.info("User opened Application in browser");
	}

	@Then("I click on the login link and enter the email")
	public void i_click_on_the_login_link_and_enter_the_email() throws InterruptedException {
		homePage.clickOnLogin();
        loginPage.email.sendKeys(email);
        Thread.sleep(2000);
        loginPage.continueBtn.click();
        Thread.sleep(30000);
        loginPage.verifyOtpBtn.click();
        log.info("User entered into loggedin page");
	}

	@When("I enter a valid product name as {string} in the search bar")
	public void i_enter_a_valid_product_name_as_in_the_search_bar(String string) {
		loggedInPage.searchBox.clear();
	    loggedInPage.searchBox.sendKeys(string);
	    log.info("User entered the product name in search bar");
	}

	@When("I click on the search button")
	public void i_click_on_the_search_button() throws InterruptedException {
	    loggedInPage.searchBtn.click();
	    Thread.sleep(5000);
	    log.info("User clicked on Serach icon");
	    
	}	
}
