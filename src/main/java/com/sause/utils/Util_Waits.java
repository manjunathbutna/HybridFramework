package com.sause.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util_Waits {
	
	public static WebElement waitForElementToBeVisible(WebDriver driver, WebElement webelement, int seconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement element =  wait.until(ExpectedConditions.visibilityOf(webelement));
		return element;
		
	}
	
	public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement webelement, int seconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webelement));
		
		return element;
	}
	public static boolean waitForElementToBeInVisible(WebDriver driver, WebElement webelement, int seconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		Boolean element = wait.until(ExpectedConditions.invisibilityOf(webelement));
		
		return true;
		
	}

}
