package pages;

import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.Toolkit;
//import java.awt.datatransfer.StringSelection;
//import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;
//import utilities.WaitUtility;

public class ManageCategoryPage {
	public WebDriver driver;
	FileUploadUtility fileuploadutility = new FileUploadUtility();
	PageUtility pageutility = new PageUtility();
	

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")
	WebElement ManageCategoryBtn;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement NewButtoninListCategories;
	@FindBy(xpath = "//input[@id='category']")
	WebElement CategoryinAddCategory;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement SelectGroupsselectable;
	@FindBy(xpath = "//li[@id='134-selection']")
	WebElement selection;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFile;
	@FindBy(xpath = "//input[@value='yes' and @name='top_menu']")
	WebElement RadioShowOnTopMenuYes;
	@FindBy(xpath = "//input[@value='no' and @name='top_menu']")
	WebElement RadioShowOnTopMenuNo;
	@FindBy(xpath = "//input[@value='yes' and @name='show_home']")
	WebElement RadioShowOnLeftMenuYes;
	@FindBy(xpath = "//input[@value='no' and @name='show_home']")
	WebElement RadioShowOnLetMenuNo;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement SuccessfullySaveGreenAlertForSave;
	// @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/category/delete?del=2306&page_ad=1']")WebElement
	// DeleteButton_Action;
	// @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/category/delete?del=2302&page_ad=1']")WebElement
	// DeleteButton;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	public List<WebElement> DeleteButton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement DeletesuccessGreenAlert;

	public void clickOnManageCategoryButton() {
		ManageCategoryBtn.click();
	}

	public void clickOnNewButtoninlist_category() {
		NewButtoninListCategories.click();
	}

	public void enterCategoryinCategoryaddPage(String category) {
		CategoryinAddCategory.sendKeys(category);

	}

	public void clickOnSelectablefromSelectGroups() {
		SelectGroupsselectable.click();
	}

	public void clickOnSelectedGroups() {
		selection.click();
		
	}
	public void clickOnChooseFileandChooseFile() throws AWTException {
		
		fileuploadutility.fileUploadUsingSendKeys(chooseFile, Constants.FANCYITEMSSTATIONARY);
		
		// chooseFile.sendKeys("C:\\Users\\user\\Desktop\\photos\\CategoriesFoeProject\\Fooditems.jpg");
		// Actions actions=new Actions(driver);
		// actions.click(chooseFile);
		// chooseFile.click();
    	//	FileUploadUtility fileuploadutility = new FileUploadUtility();
		// fileuploadutility.fileUploadUsingSendKeys(chooseFile,Constants.STATIONARY);//classname.methodnae
		
		
		
	}
	public void chooseanOptionFromTheRadioButtonForShowOnTopMenu(String value) {
		
		WaitUtility wait=new WaitUtility();
		wait.explicitwaitForElementToBeVisible(driver, RadioShowOnTopMenuYes);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		//js.executeScript("arguments[0].click();", RadioShowOnTopMenuYes);
		// js.executeScript("arguments[0].click();", RadioShowOnTopMenuNo);

		if("yes".equalsIgnoreCase(value))
		{
			js.executeScript("arguments[0].click();", RadioShowOnTopMenuYes);
		}
		else
		{
			js.executeScript("arguments[0].click();", RadioShowOnTopMenuNo);
		}
		        // pageutility.javaScriptClick(RadioShowOnTopMenuYes);
				// pageutility.javaScriptClick(RadioShowOnTopMenuNo);

				// RadioShowOnTopMenuYes.click();

				// RadioShowOnTopMenuNo.click();
		

	}

	public void chooseanOptionFromTheRadioButtonForShowOnLeftMenu(String value) {

		// ShowOnLeftMenuYes.click();

		// RadioShowOnLetMenuNo.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		//js.executeScript("arguments[0].click();", RadioShowOnLetMenuNo);
		// js.executeScript("arguments[0].click();", RadioShowOnLeftMenuYes);
		
		
	 if("no".equalsIgnoreCase(value))
			{
			 js.executeScript("arguments[0].click();", RadioShowOnLetMenuNo);
		}
			else
			{
				
				 js.executeScript("arguments[0].click();", RadioShowOnLeftMenuYes);
			}

		

	}

	public void clickOnSaveButton() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", saveButton);
//		  saveButton.click();PageUtility pageutility=new PageUtility();
//		  pageutility.javaScriptClick(saveButton);
		
		
		
	}

	public boolean isSuccessfullGreenAlertDisplayedForSave() {
		return SuccessfullySaveGreenAlertForSave.isDisplayed();
	}

	public void ClickDeleteButton(int index) {
		DeleteButton.get(index).click();
	}

	public void confirmAlert() {
		// JavascriptExecutor js=(JavascriptExecutor)driver;
		// js.executeScript("arguments[0].click();",DeleteButton_Action );
		// DeleteButton.click();
		driver.switchTo().alert().accept();
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	public boolean isSuccessfullGreenAlertForDeleteisDisplayed() {
		
		return DeletesuccessGreenAlert.isDisplayed();
	}
}
