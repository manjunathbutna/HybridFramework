package com.sause.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sause.base.TestBase;
import com.sause.pages.InventoryPage;
import com.sause.pages.LoginPage;

public class InventoryPageTest extends TestBase{
	
	LoginPage login ;
	InventoryPage Ip;
	
	public InventoryPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		Intialization();
		login = new LoginPage();
		Ip = login.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void displayAllOptionsTest() {
		Ip.displayAllOptions();
		//Ip.addItemToCart();
	}
	
	@Test
	public void cartItemCount() {
		Ip.addItemToCart();
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
