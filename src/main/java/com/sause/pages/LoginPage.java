package com.sause.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sause.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement submitbtn;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public InventoryPage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		submitbtn.click();
		
		return new InventoryPage();
		
	}

}
