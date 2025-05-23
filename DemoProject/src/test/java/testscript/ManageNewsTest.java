package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.LoginPage;
import pages.ManageNewspage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
//	@Test
//	public void manageNewsTest()
//	{

//		String username="admin";
//		String password="admin";
//		LoginPage loginpage=new LoginPage(driver);
//		loginpage.enterUserName(username);
//		loginpage.enterPassword(password);
//		loginpage.clickTheSignInButton();
//		
//	//	boolean ishomepageavailable=loginpage.isDashboardDisplayed();
// //		Assert.assertTrue(ishomepageavailable);
//		ManageNewspage managenewspage=new ManageNewspage(driver);
//		String newsenter="SALES MELA";
//		boolean managenewsdispvariable=managenewspage.isManageNewsDisplayed();
//		//Assert.assertTrue(managenewsdispvariable);
//		managenewspage.moreInfolink();
//		managenewspage.newsLink();
//		
//		managenewspage.newstext(newsenter);
//		//obj1.newstext("Rain In Kerala");
//		managenewspage.savebutton();
//		boolean ismanagenewsdispvar=managenewspage.isAlertMsgDisplayed();
//		Assert.assertTrue(ismanagenewsdispvar);
//}
	@Test
	public void manageNewsmethod() throws IOException
	{
		//String username="admin";
		//String password="admin";
		String username=ExcelUtility.getStringData(1, 0,"loginpage");
		String password=ExcelUtility.getStringData(1, 1,"loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickTheSignInButton();
//		boolean ishomepageavailable=loginpage.isDashBoardDisplayed();
//		Assert.assertTrue(ishomepageavailable);//true
		String news=ExcelUtility.getStringData(1, 0,"managenewspage");
		//String password=ExcelUtility.getStringData(1, 1,"loginpage");
		ManageNewspage managenewspage=new ManageNewspage(driver);
		managenewspage.moreInfolink();
    	managenewspage.newsLink();
		managenewspage.newstext(news);
		managenewspage.savebutton();
		//boolean ishomepageavailable=loginpage.isDashBoardDisplayed();
		//Assert.assertTrue(ishomepageavailable);//true
		//boolean managenewsdispvariable=managenewspage.isManageNewsDisplayed();
		//Assert.assertTrue(ishomepageavailable);//true
		//Assert.assertTrue(managenewsdispvariable);
		boolean ismanagenewsdispvar=managenewspage.isAlertMsgDisplayed();
		Assert.assertTrue(ismanagenewsdispvar);
	}
}
