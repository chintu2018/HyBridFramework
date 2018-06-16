package com.freecrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.base.TestBase;
import com.freecrm.pages.ContactPage;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import com.freecrm.utility.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactPage contactPage;

	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		init();
		loginpage=new LoginPage();
		testutil=new TestUtil();
		
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not matched");
	}
	@Test(priority=2)
	public void verifyUserNameTest(){
		testutil.SwitchToFrame();
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		testutil.SwitchToFrame();
		contactPage = homepage.clickOnContactsLink();
	}
	
	@AfterMethod
	
	public void teardown() {
		driver.quit();
	}
}
