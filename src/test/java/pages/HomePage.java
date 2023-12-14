package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.base.Base;

public class HomePage{
	
	WebDriver driver;
	Base base;
	
	@FindBy(xpath = "//span[@class='anch poplogin_main poplogin R12_61']")
	public WebElement loginElement;

	public HomePage(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}


	@Test
    public void openHome() {
        driver = Base.getDriver();
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
    }
    
    @Test
    public void clickOnLogin() {
    	loginElement.click();
    }
    
}
