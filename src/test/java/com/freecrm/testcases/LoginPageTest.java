package com.freecrm.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.base.TestBase;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	
    public LoginPageTest() {
		
		super();
	}
	
	
	@BeforeMethod
	
	public void setup() {
		init();
		loginpage=new LoginPage();
	}
	@Test
	public void validatetitle() {
		String title=loginpage.validatelogintitle();
		
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
	}
	
	@Test
	
	public void image() {
		
		boolean imagetest=loginpage.validateimage();
		
		Assert.assertTrue(imagetest);
	}
	@Test
	
	public void LoginTest() throws InterruptedException {
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
