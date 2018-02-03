package com.Actouch.SalesINV.pageObjectRepository;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

//After saving error message verification
public class SOBlankDETlevel  {
	
	@FindBy(id ="createSoCustId")
	WebElement SoCustIdEdt;
	@FindBy(id="btnSave")
	WebElement salsSavingbtn;
	 
  	public void BlankDETSaving(String CustId) throws InterruptedException
  	{
  WebDriverCommonlib.waitForPageToLoad();
  		Actions act = new Actions(Browser.driver);
  	String et = "At Line Number: 1. Please Select Product";
  	Thread.sleep(5000);
  	SoCustIdEdt.sendKeys(CustId);
  Thread.sleep(1000);
 	act.sendKeys(Keys.TAB).perform();
 JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
  	kl.executeScript("window.scrollBy(0,700)", "");
  	salsSavingbtn.click();
String at= Browser.driver.findElement(By.xpath("//p[contains(text(),'Please Select Product')]")).getText();
  	 Assert.assertEquals(at, et,"Error massage blankDET == fail");
		System.out.println("Error massage blankDET == pass");
  	}
}

