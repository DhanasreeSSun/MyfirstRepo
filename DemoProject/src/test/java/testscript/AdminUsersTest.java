package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.LoginPage;
import pages.AdminUsersPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base{
	@Test
	public void adminUsersTest()
	{
		FakerUtility fakerutility=new FakerUtility();
		
		//String username="AnnMary";
		//String password="admin";
//		String username=ExcelUtility.getStringData(1, 0,"loginpage");
//		String password=ExcelUtility.getStringData(1, 1,"loginpage");
		String username=fakerutility.creatARandomFirstName();
		String password=fakerutility.creatARandomLastName();//faker utility randomly generate data
		String dropdown="Partner";
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUserName(username);
	loginpage.enterPassword(password);
	loginpage.clickTheSignInButton();
	AdminUsersPage adminusespage=new AdminUsersPage(driver);
	adminusespage.adminUsers();
	adminusespage.newUserAdminUser();
	adminusespage.adminUsersInfoUname(username);//pass username faker utility
	adminusespage.adminUsersInfoPwd(password);
	//adminusespage.adminUsersInfoPwd(password);
	//adminusespage.adminUsersTypeSelect();
	adminusespage.adminUsersTypeSelect(dropdown);
	adminusespage.saveAdminUsersInfo();
	boolean wrongalertvar=adminusespage.userAlreadyExistAlertdisplayed();
	Assert.assertTrue(wrongalertvar);
    boolean successalertvar=adminusespage.successfullAlertdisplayed();
    Assert.assertTrue(successalertvar);
	
	}

}
