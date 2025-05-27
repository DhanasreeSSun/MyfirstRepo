package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constants;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;



public class Base {
	public WebDriver driver;
	public ScreenshotUtility scrshot;
	public FileInputStream fs;
	public Properties pr;
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")//chrome come below based on this
	public void initializeBrowser(String browser) throws Exception//value goes here
	{
		try
		{
			pr=new Properties();//for maintain and flexible
			fs=new FileInputStream(Constants.CONFIGFILE);
			pr.load(fs);
		}
		catch(Exception e)
		{
			System.out.println("Invalid");
		}
		//driver=new ChromeDriver();
		if(browser.equalsIgnoreCase("chrome"))//ignore case
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			throw new Exception("invalid");
		}
		driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));//from wait utility
		driver.manage().window().maximize();
	}
	@AfterMethod(alwaysRun=true)
	public void quitAndClose(ITestResult iTestResult) throws IOException
	{
		if (iTestResult.getStatus() == ITestResult.FAILURE) {//fetch console and take result
			scrshot = new ScreenshotUtility();
			scrshot.getScreenShot(driver, iTestResult.getName());//method instance so create object for particular class
		}
		//driver.quit();//after run screenshot is taken
		//pass name of failed 
	}

}
//normally url in baseclass,there is lot in base calss so 
//for maintain src.main.resources configure a file is created
//to change any url chanfgr there
