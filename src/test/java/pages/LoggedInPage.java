package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.gherkin.model.And;

import java.util.ArrayList;

public class LoggedInPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//span[@class='anch myacc_2']")
	public WebElement myAccount;
	
	@FindBy(xpath = "(//a[text()='My Profile'])[1]")
	public WebElement myProfile;
	
	@FindBy(xpath = "//*[@id='profile1']/div/div[3]/div[1]/div/span")
	public WebElement profileEmail;
	
	@FindBy(xpath = "//a[@href='https://www.firstcry.com/footwear/6/170?scat=170@~416@@@@@@@@@1@0@20@@@@@@@@@@&ref2=menu_dd_footwear_casual-shoes_H' and @title='Casual Shoes' and @class='M13_75']")
	public WebElement casualShoes;


	@FindBy(xpath = "(//span[@class='size-option pos-rel2stat R14_42'])[1]")
	public static WebElement SelectSize;

	@FindBy(xpath = "(//span[@class='M16_white'])[4]")
	public WebElement addToCartBtn;
	
	@FindBy(xpath = "(//li[@class='M14_42 categry'])[3]/child::a")
	public static WebElement footwear;
	
	@FindBy(xpath = "//*[@id='mbc']")
	public WebElement goToCart;
	
	@FindBy(xpath = "//*[@id=\"productlist\"]/div/div[2]/div[2]/div[4]/span[2]")
	public static WebElement cartItemCount;
	
	@FindBy(xpath="//div[@id='shortlist']")
	public static WebElement ShortListBTN;
	
	@FindBy(xpath="(//a[@class='R12_61'])[9]")
	public static WebElement ShortListIcon;
	
	@FindBy(xpath = "(//span[@class='anch'])[2]")
	public static WebElement storesAndPreSchool;
	
	@FindBy(xpath = "(//div[@class='list_img wifi'])[1]")
	public WebElement product;
	
	@FindBy(xpath = "//a[@href='https://www.firstcryintellitots.com/preschool-locator/?ref2=topstrip\' and @class='R12_61']")
	public static WebElement preSchoolElement;
	
	@FindBy(xpath = "//a[@class='R12_61' and contains(@href, 'store-locator')]/span[@class='anch']")
	public static WebElement storesElement;
	
	@FindBy(xpath = "//input[@id='search_box']")
	public WebElement searchBox;
	
	@FindBy(xpath = "//span[@class='search-button']")
	public WebElement searchBtn;
	
	@FindBy(xpath = "(//div[@title='Edit'])[3]")
	public WebElement editButton;
	
	@FindBy(xpath = "//input[@id='childName_1']")
	public WebElement name;
	
	@FindBy(xpath = "(//div[@class='sprite-ac sp_cal'])[4]")
	public WebElement dob;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/span[1]")
	public WebElement month;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/span[2]")
	public WebElement year;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[1]")
	public WebElement goLeft;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]")
	public WebElement goRight;
	
	@FindBy(xpath = "//div[@id='UchildGenderGirl']")
	public WebElement girlCheck;
	
	@FindBy(xpath = "//div[@id='UchildGenderBoy']")
	public WebElement boyCheck;
	
	@FindBy(xpath = "//*[@id='editWeight']")
	public WebElement weight;
	
	@FindBy(xpath = "//*[@id='editHeight']")
	public WebElement height;
	
	@FindBy(xpath = "//*[@id='btn_1']")
	public WebElement submitDetailsBtn;
	
	@FindBy(xpath = "//div[@id='placeorder_btn']")
	public WebElement placeOrderBtn;
	
	@FindBy(xpath = "//*[@id='codrow']")
	public WebElement selectCOD;
	
//	@FindBy(xpath = "(//*[@id=\"BtnCodPayNow\"]/span/span[2])[2]")
//	public WebElement orderWithCOD;
	
	@FindBy(xpath = "(//*[@id=\"BtnCodPayNow\"]/span/span[2])[2]")
	public WebElement orderValue;
	
	
	public LoggedInPage(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	public void goToProfile() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(myAccount);
		Thread.sleep(2000);
		action.moveToElement(myProfile);
		action.click().build().perform();
	}
	
	public void goToFootwear() {
		Actions action =  new Actions(driver);
		action.moveToElement(footwear).build().perform();
	}
	
	public void goToProductPage() throws InterruptedException {
		 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(tabs.get(1));
		 Thread.sleep(2000);
	}
	
	
	public void goBack() throws InterruptedException {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.close();
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
	}
	
	public void goToPreSchoolPage() throws InterruptedException {
		Actions action =  new Actions(driver);
		action.moveToElement(storesAndPreSchool).build().perform();
		preSchoolElement.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);
	}
	
	public void goToStoresPage() throws InterruptedException {
		Actions action =  new Actions(driver);
		action.moveToElement(storesAndPreSchool).build().perform();
		storesElement.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);
	}
	
	public void selectDOB(String dayString ,String monthString, String yearString) throws InterruptedException {
		dob.click();
		
		//select year                                   
		while(Integer.valueOf(year.getText())>Integer.valueOf(yearString)){
			goLeft.click();
		}                    
		while(Integer.valueOf(year.getText())<Integer.valueOf(yearString)){
			goRight.click();
		}
		
		//select month                                   Dec           May
		int clicks = calculateMonthDifferenceLinear(month.getText(), monthString);
		if(clicks>0) {
			for(int i=0;i<clicks;i++) {
				goRight.click();
			}
		}
		else {
			for(int i=0;i<Integer.valueOf(clicks*-1);i++) {
				goLeft.click();
			}
		}
		Thread.sleep(5000);
		//select date
		 WebElement dayElement = driver.findElement(By.xpath("//div[text()='" + dayString + "']"));
		 dayElement.click();
		 Thread.sleep(5000);
	}

	
	
	private static int calculateMonthDifferenceLinear(String currentMonth, String targetMonth) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int currentIndex = getIndex(months, currentMonth); //12
        int targetIndex = getIndex(months, targetMonth);  //5
        int difference = targetIndex - currentIndex; //5-12 =-7
        return difference;
    }

    private static int getIndex(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(value)) {
                return i;
            }
        }
        return -1; 
    }

	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getProfileEmail() {
		return profileEmail.getText();
	}
}
