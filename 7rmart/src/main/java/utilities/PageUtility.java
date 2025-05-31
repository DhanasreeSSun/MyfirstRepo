package utilities;

//import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class PageUtility {//to help page class method create common
	public WebDriver driver;
	public void selectByVisibleText(WebElement element,String visibleText) {
		Select select =new Select(element);
		select.selectByVisibleText(visibleText);;
		
	}
	public void dragAndDrop(WebElement drag,WebElement drop)
	{
		Actions action=new Actions(driver);
		
		action.dragAndDrop(null,null).build().perform();
	}
	public void doubleClick(WebElement element)
	{
		Actions action=new Actions(driver);
		action.doubleClick(element).build().perform();
	}
	public void contextClick(WebElement element)
	{
		Actions action=new Actions(driver);
		action.contextClick(element).build().perform();
	}
	public void moveToElement(WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(null).build().perform();
	}
	public void mouseClick(WebElement element)
	{
		Actions action=new Actions(driver);
		
		action.click(element).build().perform();
//		action.doubleClick(null).build().perform();
//		action.contextClick(null).build().perform();
//		action.moveToElement(null).build().perform();
	}
	
	public void javaScriptSendKeys(WebElement element,String data)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript(arguments[0].click();", webelement);"
		
		js.executeScript("arguments[0].value='data';", element);
	}
	public void javaScriptClick(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
		//click
		//sendkeys
		
	}
	public void scrollBy(WebDriver driver,int x,int y)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(x,y)","");
		
	}
}
//	public String multipleWindowHandling(WebElement element)
//	{
//		//String windowhandle=driver.getWindowHandle();
//		//return windowhandle;
//		Set<String> windowhandles=driver.getWindowHandles();
//		for( String temp:windowhandles)
//		{
//		
//	
//		driver.switchTo().window(temp);
//		
//		
//	}
//		return null;
//	
//		
//		
//		
//	}
//		public void frame(String WebElement)
//		{
//			driver.switchTo().frame(WebElement);
//		}
//		public void alert()
//		{
//			driver.switchTo().alert().accept();
//			driver.switchTo().alert().dismiss();
//}
//		public void checkBox(WebElement element)
//		{
//			element.click();
//		}
//		public void radioButton(WebElement element)
//		{
//			element.click();
//		}
//}
//
