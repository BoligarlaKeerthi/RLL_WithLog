package steps;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import listeners.Loggerhelper;
import pages.HomePage;
import pages.LoggedInPage;
import pages.LoginPage;
import pages.base.Base;

public class TestEditProfile {
	
	HomePage homePage;
	LoginPage loginPage;
	LoggedInPage loggedInPage;
	
	String email;
	
	static Logger log = Loggerhelper.getLogger(TestEditProfile.class);
	
	public void LoadProperties() throws IOException {
        FileReader reader = new FileReader(".\\src\\test\\resources\\application.properties");
        Properties props = new Properties();
        props.load(reader);
        email = props.getProperty("email");
    }

	@Given("I open the browser and enter the application URL")
	public void i_open_the_browser_and_enter_the_application_url() throws IOException {
		homePage = new HomePage(Base.getDriver());
        loginPage = new LoginPage(Base.getDriver());
        loggedInPage = new LoggedInPage(Base.getDriver());
        LoadProperties();
        log.info("User opened Application in browser");
	}

	@Then("I click on the login link and enter the email and submit OTP")
	public void i_click_on_the_login_link_and_enter_the_email_and_submit_otp() throws InterruptedException {
		homePage.clickOnLogin();
        loginPage.email.sendKeys(email);
        Thread.sleep(2000);
        loginPage.continueBtn.click();
        Thread.sleep(30000);
        loginPage.verifyOtpBtn.click();
        log.info("user entered to loggedin page");
	}

	@Then("I go to the My Account then My Profile Section")
	public void i_go_to_the_my_account_then_my_profile_section() throws InterruptedException {
		loggedInPage.goToProfile();
		log.info("user selected my account in that my profile");
	}

	@Given("I edit the profile data {string},{string},{string},{string},{string},{string},{string}")
	public void i_edit_the_profile_address(String name, String day, String month, String year, String gender, String height, String weight) throws InterruptedException {
		loggedInPage.editButton.click();
		Thread.sleep(2000);
		loggedInPage.name.clear();
		loggedInPage.name.sendKeys(name);
	    loggedInPage.selectDOB(day,month,year);
	    if(gender.equalsIgnoreCase("Male")){
	    	loggedInPage.boyCheck.click();
	    	}
	    else{
	    	loggedInPage.girlCheck.click();
	    	}
	    loggedInPage.height.clear();
	    loggedInPage.height.sendKeys(height);
	    loggedInPage.weight.clear();
	    loggedInPage.weight.sendKeys(weight);
	    loggedInPage.submitDetailsBtn.click();
	    Thread.sleep(10000);
	    log.info("user edited details of the child");
	}
}
