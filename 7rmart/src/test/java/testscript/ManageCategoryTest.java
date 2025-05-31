package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

//import utilities.FileUploadUtility;
//import utilities.PageUtility;

public class ManageCategoryTest extends Base {
	@Test(retryAnalyzer=retry.Retry.class)
	public void verifyItemsEnteredInManageCategoryPageShouldBeEnteredSuccessfully() throws IOException, AWTException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSigninButton();
		String topradiobtn = ExcelUtility.getStringData(1, 2, "managecategory");
		String leftradiobtn = ExcelUtility.getStringData(2, 3, "managecategory");
		ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		managecategorypage.clickOnManageCategoryButton();
		managecategorypage.clickOnNewButtoninlist_category();
		FakerUtility fakerutility = new FakerUtility();
		String category = fakerutility.creatARandomFirstName();
		// String category=ExcelUtility.getStringData(5, 0, "managecategory");
		managecategorypage.enterCategoryinCategoryaddPage(category);
		managecategorypage.clickOnSelectablefromSelectGroups();
		// managecategorypage.clickOnSelectedGroups();

		managecategorypage.clickOnChooseFileandChooseFile();

		managecategorypage.chooseanOptionFromTheRadioButtonForShowOnTopMenu(topradiobtn);
		managecategorypage.chooseanOptionFromTheRadioButtonForShowOnLeftMenu(leftradiobtn);
		// String uploadfile=ExcelUtility.getStringData(3, 0, "fileupload");

		// managecategorypage.fileUploadUsingRobotClass();
		managecategorypage.clickOnSaveButton();
		boolean suuceesfullGreenalertvar = managecategorypage.isSuccessfullGreenAlertDisplayedForSave();
		Assert.assertTrue(suuceesfullGreenalertvar);

	}

	@Test(retryAnalyzer = retry.Retry.class)
	public void verifyitemselectedForDeletesuccessfullyDeleteFromListCategories() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSigninButton();
		int indextoDelete = 0;
		ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		managecategorypage.clickOnManageCategoryButton();
		// String itemfordelete=ExcelUtility.getStringData(4, 0, "managecategory");
		// managecategorypage.clickOnDeleteButtoninActionandDeleteandItemfromListCategories();
		managecategorypage.ClickDeleteButton(indextoDelete);// to delete based in index
		managecategorypage.confirmAlert();
		managecategorypage.isSuccessfullGreenAlertForDeleteisDisplayed();
	}

}
