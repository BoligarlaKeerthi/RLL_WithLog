package pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PreSchoolPage {

	public static WebDriver driver;
	
	@FindBy(xpath = "//a[@id='school-finder-btn']")
	public WebElement preSchoolLocatorBtn;
	
	@FindBy(xpath = "//*[@id='city']")
	public static WebElement selectLocation;
	
	@FindBy(xpath = "//input[@name='findersubmit']")
	public WebElement findSchoolBtn;
	
	@FindBy(xpath = "(//div[@class='area-wrapper'])[1]/h4/span[2]")
	public WebElement location;
	
	public PreSchoolPage(WebDriver driver) {
	    super();
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	public void selectLocation(String location) {
		Select select  = new Select(selectLocation);
		select.selectByVisibleText(location);
	}
	
	public void goBack() throws InterruptedException {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.close();
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
	}
}
