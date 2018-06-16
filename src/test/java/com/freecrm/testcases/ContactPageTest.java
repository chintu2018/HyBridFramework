package com.freecrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.freecrm.base.TestBase;
import com.freecrm.pages.ContactPage;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import com.freecrm.utility.TestUtil;

public class ContactPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactPage contactPage;
	
	String sheetName = "contacts";

	public ContactPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		init();
		loginpage=new LoginPage();
		testutil=new TestUtil();
		
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.SwitchToFrame();
		contactPage=homepage.clickOnContactsLink();
		
	}
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactPage.verifyContactsLabel(), "contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest(){
		contactPage.selectContactsByName("Damini Gedia");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest(){
		contactPage.selectContactsByName("Damini Gedia");
		contactPage.selectContactsByName("Priya Acharya");

	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company){
		homepage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactPage.createNewContact(title, firstName, lastName, company);
		
	}
	
	@AfterMethod
	
	public void teardown() {
		driver.quit();
	}
}
