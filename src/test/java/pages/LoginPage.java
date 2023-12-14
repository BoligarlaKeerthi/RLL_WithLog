package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@name='email']")
	public WebElement email;
	
	@FindBy(xpath = "//div[@class='B14_white comm-btn btn-login-continue btn-login-cont-otp']")
	public WebElement continueBtn;
	
	@FindBy(xpath = "//div[@id='verfiedbtn']")
	public WebElement verifyOtpBtn;

	public LoginPage(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
}
