package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.AdminUsersPage;
//import pages.LogOutPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base{
	@Test(retryAnalyzer=retry.Retry.class)//retest if fail//package name-retry,class name Retry
	public void adminUsersTest() throws IOException
	{
	
		
		//String username="AnnMary";
		//String password="admin";
	    String username=ExcelUtility.getStringData(1, 0,"loginpage");
		String password=ExcelUtility.getStringData(1, 1,"loginpage");
		
		//String dropdown="Partner";
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUserName(username);
	loginpage.enterPassword(password);
	loginpage.clickSigninButton();
	//*******************************
	 //faker utility ->it randomly generate data.instance 
	FakerUtility fakerutility=new FakerUtility();
	 
	 String username_AdminUserTest= fakerutility.creatARandomFirstName();
	 String password_AdminUserTest= fakerutility.creatARandomLastName();
	 //String username_AdminUserTest=ExcelUtilities.getStringData(1, 0, "adminuserspage");
	 //String password_AdminUserTest=ExcelUtilities.getStringData(1, 1, "adminuserspage");
	 String userType=ExcelUtility.getStringData(2,2,"adminuser");
	AdminUsersPage adminusespage=new AdminUsersPage(driver);
	adminusespage.adminUsers();
	adminusespage.newUserAdminUser();
	adminusespage.adminUsersInfoUname(username_AdminUserTest);//pass username faker utility
	adminusespage.adminUsersInfoPwd(password_AdminUserTest);
	//adminusespage.adminUsersTypeSelect();
	//adminusespage.adminUsersTypeSelect(dropdown);
	// String userType=ExcelUtility.getStringData(1,0,"adminuser");//String admin page in excel
	 adminusespage.adminUsersTypeSelect(userType);
	adminusespage.saveAdminUsersInfo();
//	boolean wrongalertvar=adminusespage.userAlreadyExistAlertdisplayed();
//	Assert.assertTrue(wrongalertvar);
	//LogOutPage logoutpage=new LogOutPage(driver);
	//logoutpage.clickOnAdminAvatar();
	//logoutpage.clickOnLogoutButton();
	//logoutpage.isSignInButtonDisplayed();
    boolean successalertvar=adminusespage.successfullAlertdisplayed();
    Assert.assertTrue(successalertvar);
	
	}

}
