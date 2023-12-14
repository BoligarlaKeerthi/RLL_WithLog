package pages.base;

import java.io.File;

//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Properties;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//
//public class Base{
//	
//	String baseURL;
//	public static WebDriver driver;
//	
//	
//	public void LoadProperties() throws IOException {
//        FileReader reader = new FileReader(".\\src\\test\\resources\\application.properties");
//        Properties props = new Properties();
//        props.load(reader);
//        baseURL = props.getProperty("baseURL");
//    }
//
//    @Before
//    public void OpenBrowser() throws IOException {
//    	LoadProperties(); 
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get(baseURL);
//    }
//
//    @After
//    public void CloseBrowser() {
//        driver.close();
//    }
//
//    public static WebDriver getDriver() {
//        return driver;
//    }
//}

import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Base{
	
	String baseURL;
	public static WebDriver driver;
	
	
	public void LoadProperties() throws IOException {
        FileReader reader = new FileReader(".\\src\\test\\resources\\application.properties");
        Properties props = new Properties();
        props.load(reader);
        baseURL = props.getProperty("baseURL");
    }

    @Before
    public void OpenBrowser() throws IOException {
    	LoadProperties(); 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
    }
    
    @After(order = 0)
    public void CloseBrowser() {
        driver.close();
    }
    
    @After(order = 1)
    public void takeScreenshotOnFail(Scenario s) {
    	if(s.isFailed())  {
		TakesScreenshot ts=(TakesScreenshot)driver;
        byte[] src =ts.getScreenshotAs(OutputType.BYTES);
       s.attach(src, "image/png","screenshot");
       
       File srcFile = ts.getScreenshotAs(OutputType.FILE);
		  try {
		   FileUtils.copyFile(srcFile, new File("./ScreenShots/"+s.getName()+"-Failed.jpg"));
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		 }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}