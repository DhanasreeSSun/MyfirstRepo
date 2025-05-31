package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base {
	@Test(retryAnalyzer=retry.Retry.class)
	public void verifyContactDetailsUpdateSuccessfullyinContactUsPage() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSigninButton();
	    String phone=ExcelUtility.getLongData(1, 0, "contactus");
		String email=ExcelUtility.getStringData(1, 1, "contactus");
		String address=ExcelUtility.getStringData(1, 2, "contactus");
		String deliverytime=ExcelUtility.getIntegerData(1, 3, "contactus");
		String deliverychargelimit=ExcelUtility.getIntegerData(1, 4, "contactus");
		ManageContactPage managecontactpage=new ManageContactPage(driver);
		managecontactpage.clickOnManageContactButtonInHomePage();
		managecontactpage.clickOnActionButtonInlist_contact();
		managecontactpage.enterPhoneNumberinPhoneTextField(phone);
		managecontactpage.enterEmailinEmailTextField(email);
		managecontactpage.enterAddressInAddressTextField(address);
		managecontactpage.enterDeliveryTimeinDeliveryTimeTextField(deliverytime);
		managecontactpage.enterDeliveryChargeLimitinDeliveryChargeTextField(deliverychargelimit);
		managecontactpage.clickOnUpdateButton();
		boolean successfulupdatevar=managecontactpage.isGreenAlertDisplayedForSuccessfulUpdate();
		Assert.assertTrue(successfulupdatevar);
		
		
		
	}
	@Test
	public void verifyUpdateButtoninContactUsPageDisplayedSuccessfully() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSigninButton();
		ManageContactPage managecontactpage=new ManageContactPage(driver);
		managecontactpage.clickOnManageContactButtonInHomePage();
		managecontactpage.clickOnActionButtonInlist_contact();
		boolean updatebtnvisiblityvar=managecontactpage.isUpdateButtonVisibleInContactUsPage();
		Assert.assertTrue(updatebtnvisiblityvar);
	}

}
