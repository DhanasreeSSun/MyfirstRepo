package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static final int EXPLICIT_WAIT=10;
	public static final int IMPLICIT_WAIT=10;//common for all wait
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
		public void implicitwaitForElementToBeClickable(WebDriver driver,WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IMPLICIT_WAIT));
		    wait.until(ExpectedConditions.alertIsPresent());
		    		
		}
		public void explicitwaitForElementToBeVisible(WebDriver driver,WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		    wait.until(ExpectedConditions.visibilityOf(element));
		    		
		}
		public void explicitwaitForElementToBeClickable(WebDriver driver,WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		    //wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));//doubt bt
			wait.until(ExpectedConditions.elementToBeClickable(element));
		    		
		}
		public void explicitwaitForElementToBeSelected(WebDriver driver,WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		   // wait.until(ExpectedConditions.textToBePresentInElementLocated((By) element, "success"));//doubt
			wait.until(ExpectedConditions.elementToBeSelected(element));
		    		
		}
		
		


}
