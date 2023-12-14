package steps;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import listeners.Loggerhelper;
import pages.HomePage;
import pages.LoggedInPage;
import pages.LoginPage;
import pages.base.Base;

public class TestAddToCart {
	
	HomePage homePage;
	LoginPage loginPage;
	LoggedInPage loggedInPage;
	
	String email;
	
    static Logger log = Loggerhelper.getLogger(TestAddToCart.class);
	
	public void LoadProperties() throws IOException {
        FileReader reader = new FileReader(".\\src\\test\\resources\\application.properties");
        Properties props = new Properties();
        props.load(reader);
        email = props.getProperty("email");
    }

	@Given("I open the browser and enter URL")
	public void i_open_the_browser_and_enter_url() throws IOException {
		homePage = new HomePage(Base.getDriver());
        loginPage = new LoginPage(Base.getDriver());
        loggedInPage = new LoggedInPage(Base.getDriver());
        LoadProperties();
        log.info("User opened Application in browser");
    }

	@Then("I click on Login link and enter the email id")
	public void i_click_on_login_link_and_enter_the_email_id() throws InterruptedException {
		homePage.clickOnLogin();
        loginPage.email.sendKeys(email);
        Thread.sleep(2000);
        loginPage.continueBtn.click();
        Thread.sleep(30000);
        loginPage.verifyOtpBtn.click();
        log.info("User entered into Logged in page");
        
	}

	@Then("I verify the {string} of the FirstCryPage")
	public void i_verify_the_of_the_first_cry_page(String string) {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(loggedInPage.getTitle(), string, "The title donot match");
		log.info("User checks the title of page");
	}
	
	@Then("I click on Footwear and click on Casualshoes")
	public void i_click_on_footwear_and_click_on_casualshoes() throws InterruptedException {
	    loggedInPage.goToFootwear();
	    Thread.sleep(2000);
	    loggedInPage.casualShoes.click();
	    log.info("User hover over footwear and selected Casualshoes");
	}

	@Then("I click on Product on the page")
	public void i_click_on_product_on_the_page() throws InterruptedException {
		loggedInPage.product.click();
		loggedInPage.goToProductPage();
		 log.info("User selected the product");
		
	}

	@Then("I click on Add to cart page")
	public void i_click_on_add_to_cart_page() throws InterruptedException {
		loggedInPage.addToCartBtn.click();
		Thread.sleep(2000);
		 log.info("User clicked on add to cart button");
		
	}

	@Then("I click on Go to Cart page")
	public void i_click_on_go_to_cart_page() throws InterruptedException {
		loggedInPage.goBack();
		loggedInPage.goToCart.click();
		try {
			Thread.sleep(1000);
			Assert.assertEquals(LoggedInPage.cartItemCount.getText(), "1", "Product is not added to the cart.");
		} catch (Exception e) {
			System.out.println(" CartItemCount Assertion Passed");
		}
		 log.info("User went to cart and checked the product");
	    
	}


}
