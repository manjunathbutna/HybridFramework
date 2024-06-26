package com.sause.pages;

import org.openqa.selenium.support.PageFactory;

import com.sause.base.TestBase;

public class InventoryPage extends TestBase{
	
	public InventoryPage() {
		PageFactory.initElements(driver, this);
	}
	

}
