package com.sause.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sause.base.TestBase;
import com.sause.pages.InventoryPage;
import com.sause.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage login ;
	InventoryPage Ip;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		Intialization();
		login = new LoginPage();
	}
	
	@Test
	public void loginMethod() {
		Ip = login.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
