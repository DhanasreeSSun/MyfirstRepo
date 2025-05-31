package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;


public class LoginTest extends Base {
	@Test(groups= {"regression"},description="LoginTest",retryAnalyzer=retry.Retry.class)//for regression testing,after
	public void verifyLoginPageWithCorrectUserNameandCorrectPassword() throws IOException
	{
		//String username="admin";
		//String password="admin";
		String username=ExcelUtility.getStringData(1, 0,"loginpage");
		String password=ExcelUtility.getStringData(1, 1,"loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSigninButton();
		boolean ishomepageavailable=loginpage.isDashboardDisplayed();
		Assert.assertTrue(ishomepageavailable);//true
	}
	@Test
	public void verifyLoginPageWithCorrectUserNameandIncorrectPassword() throws IOException
	{
		String username=ExcelUtility.getStringData(2, 0, "loginpage");
		String password=ExcelUtility.getStringData(2, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSigninButton();
		boolean ishomepagenotavailable=loginpage.isAlertisDisplayed();
		Assert.assertTrue(ishomepagenotavailable);
	}
	@Test
	public void verifyLoginPageWithIncorrectUserNameandCorrectPassword() throws IOException
	{
		String username=ExcelUtility.getStringData(3, 0, "loginpage");
		String password=ExcelUtility.getStringData(3, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSigninButton();
		boolean ishomepagenotavailable=loginpage.isAlertisDisplayed();
		Assert.assertTrue(ishomepagenotavailable);
		
	}
	@Test
	public void verifyLoginPageWithIncorrectUserNameandIncorrectPassword() throws IOException
	{
		String username=ExcelUtility.getStringData(4, 0, "loginpage");
		String password=ExcelUtility.getStringData(4, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSigninButton();
		boolean ishomepagenotavailable=loginpage.isAlertisDisplayed();
		Assert.assertTrue(ishomepagenotavailable);
	}

}
