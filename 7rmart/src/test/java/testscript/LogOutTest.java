package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogOutPage;
import utilities.ExcelUtility;

public class LogOutTest extends Base{
	@Test//(description= "LogOutTest",retryAnalyzer=retry.Retry.class)
	public void verifyLogOutAvatarByClickOnIt() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSigninButton();
		LogOutPage logoutpage=new LogOutPage(driver);
		logoutpage.clickOnAdminAvatar();
		logoutpage.clickOnLogoutButton();
		boolean successfullogout=logoutpage.isSignInButtonDisplayed();
		Assert.assertTrue(successfullogout);
		
	}
	

}
