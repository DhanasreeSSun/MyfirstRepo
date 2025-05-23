package testscript;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.WaitUtility;



public class Base {
	public WebDriver driver;
	@BeforeMethod
	@Parameters("browser")//chrome come below based on this
	public void initializeBrowser(String browser) throws Exception//value goes here
	{
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
	@AfterMethod
	public void quitAndClose()
	{
		//driver.quit();
	}

}
