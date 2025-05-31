package testscript;

//import java.io.FileInputStream;
//import java.io.IOException;
import java.time.Duration;
//import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;

//import constant.Constants;
//import utilities.ScreenshotUtility;
import utilities.WaitUtility;



public class Base {
	public WebDriver driver;
	
	@BeforeMethod
	
	public void initializeBrowser()//value goes here
	{
	
		driver=new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));//from wait utility
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void quitAndClose()
	{
		//driver.quit();
	}

}
