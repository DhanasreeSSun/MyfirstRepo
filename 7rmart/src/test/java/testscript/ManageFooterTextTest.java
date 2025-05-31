package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base {
	@Test
	public void verifyManageFooterTextPage() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSigninButton();
		String address=ExcelUtility.getStringData(1, 0,"managefootertext");
		String email=ExcelUtility.getStringData(1, 1, "managefootertext");
		String phone=ExcelUtility.getLongData(1, 2, "managefootertext");

		
		ManageFooterTextPage managefootertextpage=new ManageFooterTextPage(driver);
		managefootertextpage.clickOn_MoreInfoButtonin_homepage();
		managefootertextpage.clickOn_ActionButtonin_list_footertext();
		managefootertextpage.enterAddress_in_textboxforAddressof_editpage(address);
		managefootertextpage.enterEmail_in_textboxforEmailof_editpage(email);
		managefootertextpage.enterPhoneNumberinPhoneFieldof_editpage(phone);
		managefootertextpage.clickOnUpdateButtonof_editpage();
		boolean greenalertvar=managefootertextpage.isAlertDisplayedForFooterTextUpdatedSuccessfully();
		Assert.assertTrue(greenalertvar);
		
		
	}
	@Test
	public void verifyUpdateButtonDisplayedSuccessfully() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSigninButton();	
		ManageFooterTextPage managefootertextpage=new ManageFooterTextPage(driver);
		managefootertextpage.clickOn_MoreInfoButtonin_homepage();
		managefootertextpage.clickOn_ActionButtonin_list_footertext();
		boolean updatebtnvisiblevar=managefootertextpage.isUpdateButtonDisplayedSuccessfully();
		Assert.assertTrue(updatebtnvisiblevar);
	}

}
