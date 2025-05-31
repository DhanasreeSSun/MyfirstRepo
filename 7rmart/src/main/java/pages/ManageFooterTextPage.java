package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {
	public WebDriver driver;

	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
}

@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")
WebElement More_Info_ManageFooterText;
@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']")
WebElement Action_listfootertext;
@FindBy(xpath = "//textarea[@id='content']")
WebElement AddresFooterText_edit;
@FindBy(xpath = "//input[@id='email']")
WebElement Email_FooterText_edit;
@FindBy(xpath = "//input[@id='phone']")
WebElement Phone_FooterText_edit;
@FindBy(xpath = "//button[@type='submit']")
WebElement UpdateButton_edit;
@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
WebElement GreenAlert_UpdateSuccess;

public void clickOn_MoreInfoButtonin_homepage()
{
	More_Info_ManageFooterText.click();
	
}
public void clickOn_ActionButtonin_list_footertext()
{
	Action_listfootertext.click();
}
public void enterAddress_in_textboxforAddressof_editpage(String address)
{
	AddresFooterText_edit.clear();
	AddresFooterText_edit.sendKeys(address);
	
}
public void enterEmail_in_textboxforEmailof_editpage(String email)
{
	Email_FooterText_edit.clear();
	Email_FooterText_edit.sendKeys(email);
}
public void enterPhoneNumberinPhoneFieldof_editpage(String phone)
{
	Phone_FooterText_edit.clear();
	Phone_FooterText_edit.sendKeys(phone);
}
public void clickOnUpdateButtonof_editpage()
{
	UpdateButton_edit.click();

}
public boolean isAlertDisplayedForFooterTextUpdatedSuccessfully()
{
	return GreenAlert_UpdateSuccess.isDisplayed();
}
public boolean isUpdateButtonDisplayedSuccessfully()
{
	return UpdateButton_edit.isDisplayed();
}
}
