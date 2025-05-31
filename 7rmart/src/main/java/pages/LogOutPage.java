package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
	public WebDriver driver;
	public LogOutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class='nav-link' and @data-toggle='dropdown']")WebElement Adminavatar;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']")WebElement Logout;
	@FindBy(xpath="//button[@type='submit']")WebElement SignInButton;


public void clickOnAdminAvatar()
{
	Adminavatar.click();
}
public void clickOnLogoutButton()
{
	Logout.click();
}
public boolean isSignInButtonDisplayed()
{
	return SignInButton.isDisplayed();
	}
}
