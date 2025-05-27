package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.LoginPage;
import pages.AdminUsersPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base{
	@Test(retryAnalyzer=retry.Retry.class)//retest if fail//package name-retry,class name Retry
	public void adminUsersTest() throws IOException
	{
	// add if needed //FakerUtility fakerutility=new FakerUtility();//object of faker utility final so classname.variablename
		
		//String username="AnnMary";
		//String password="admin";
	    String username=ExcelUtility.getStringData(1, 0,"loginpage");
		String password=ExcelUtility.getStringData(1, 1,"loginpage");
		// add if needed //String username=fakerutility.creatARandomFirstName();
		//add if needed//String password=fakerutility.creatARandomLastName();//faker utility randomly generate data
		//String dropdown="Partner";
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUserName(username);
	loginpage.enterPassword(password);
	loginpage.clickTheSignInButton();
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
	//adminusespage.adminUsersInfoPwd(password);
	//adminusespage.adminUsersTypeSelect();
	//adminusespage.adminUsersTypeSelect(dropdown);
	// String userType=ExcelUtility.getStringData(1,0,"adminuser");//String admin page in excel
	 adminusespage.adminUsersTypeSelect(userType);
	adminusespage.saveAdminUsersInfo();
//	boolean wrongalertvar=adminusespage.userAlreadyExistAlertdisplayed();
//	Assert.assertTrue(wrongalertvar);
    boolean successalertvar=adminusespage.successfullAlertdisplayed();
    Assert.assertTrue(successalertvar);
	
	}

}
