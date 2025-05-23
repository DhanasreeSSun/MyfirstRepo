package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends Base {
	@Test
	public void LoginTest()
	{
		driver.navigate().to("https://groceryapp.uniqassosiates.com/admin");
		
		String username="admin";
		String password="admin";
		WebElement uid=driver.findElement(By.xpath("//input[@name='username']"));
		uid.sendKeys(username);
		WebElement pwd=driver.findElement(By.xpath("//input[@name='password']"));
		pwd.sendKeys(password);
		WebElement signin=driver.findElement(By.xpath("//button[@type='submit']"));
		signin.click();
		WebElement dashboard=driver.findElement(By.xpath("//p[text()='Dashboard']"));
		boolean ishomepadeavailabele=dashboard.isDisplayed();
		//assign value to a boolean variable
		//if dashboard displayed true,else return false
		//true is going to ishomepage avaialable
		Assert.assertTrue(ishomepadeavailabele);//variable pass to assert to method
		
		
	}

}
