package com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	
	WebElement LoginBtn;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	
	WebElement img;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	
	WebElement SignUp;
	
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatelogintitle() {
		
		return driver.getTitle();
		}
	public boolean validateimage() {
		return img.isDisplayed();
	}
	
	public HomePage login(String uname,String pwd) throws InterruptedException {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		Thread.sleep(3000);
		LoginBtn.click();
		
		return new HomePage();
	}

}
