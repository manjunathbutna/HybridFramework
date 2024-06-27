package com.sause.pages;

import java.util.List;

//import org.testng.Assert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sause.base.TestBase;

public class InventoryPage extends TestBase{
	
	
	@FindBy(xpath="//div[text()='Sauce Labs Backpack']/../../following-sibling::div/button")
	WebElement SauceLabsBackpack;
	
	@FindBy(xpath="//div[text()='Sauce Labs Bike Light']/../../following-sibling::div/button")
	WebElement SauceLabsBikeLight;
	
	@FindBy(xpath="//div[@id='shopping_cart_container']/a/span")
	WebElement cartItemCount;
	
	@FindBy(className="product_sort_container")
	List<WebElement> sortContainer;
	
	public InventoryPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void displayAllOptions() {
		for(WebElement e : sortContainer) {
			System.out.println(e.getText());
		}
	}
	
	
	public void addItemToCart() {
		SauceLabsBackpack.click();
//		if(cartItemCount.getText().equals(1)) {
//			
//		}
		//Assert.assertEquals(cartItemCount.getText(), "1");
		
	}
	

}
