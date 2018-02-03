package com.Actouch.Purchase.generic_Lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonlib {
	public static void waitForPageToLoad(){
			Browser.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		public void waitForElementPresent(WebElement wb){
			WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
			wait.until(ExpectedConditions.visibilityOf(wb));	
		}
}
