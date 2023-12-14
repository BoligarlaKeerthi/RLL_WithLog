package pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class StoreLocatorPage {

	public static WebDriver driver;
	
	@FindBy(xpath = "//select[@id='storetype']")
	public WebElement selectStoreType;
	
	@FindBy(xpath = "//select[@name='state']")
	public WebElement selectState;
	
	@FindBy(xpath = "//select[@name='city']")
	public WebElement selectCity;
	
	@FindBy(xpath = "//input[@onClick='searchstore(); callstoreslider()']")
	public WebElement submitBtn;
	
	@FindBy(xpath = "//label[@id='citynme']")
	public WebElement verifyLocation;
	
	public StoreLocatorPage(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	public void selectState(String state) {
		Select select  = new Select(selectState);
		select.selectByVisibleText(state);
	}
	
	public void selectStoreType(String storeType) {
		Select select  = new Select(selectStoreType);
		select.selectByVisibleText(storeType);
	}
	public void selectCity(String city) {
		Select select  = new Select(selectCity);
		select.selectByVisibleText(city);
	}
	
	public void goBack() throws InterruptedException {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.close();
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
	}
}
