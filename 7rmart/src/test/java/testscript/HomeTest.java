package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.LoginPage;
import pages.HomePage;
import utilities.ExcelUtility;

public class HomeTest extends Base{
	HomePage homepage;
	@Test(description= "verify Logout from the page successfully",retryAnalyzer=retry.Retry.class)
	public void verifyLogOutAvatarByClickOnIt() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		homepage=loginpage.clickSigninButton();
		HomePage logoutpage=new HomePage(driver);
		logoutpage.clickOnAdminAvatar();
		logoutpage.clickOnLogoutButton();
		boolean successfullogout=logoutpage.isSignInButtonDisplayed();
		Assert.assertTrue(successfullogout,Constants.LOGOUTERROR);
		
	}
	

}
