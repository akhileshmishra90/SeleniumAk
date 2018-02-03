package com.Actouch.SalesQuotation.pageObjectRepository;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.SalesQuotation.generic_Lib.Browser;


//After saving error message verification
public class SqBlankDETlevel  {
	
	@FindBy(id ="cust_Id")
	WebElement custIdEdt;
	@FindBy(id="btnSave")
	WebElement saveBtn;
	 
  	public void BlankDETSaving(String CustId) throws InterruptedException
  {
  	
  	String et = "Please Select Product at Line Number:1";
  	custIdEdt.sendKeys(CustId);
  	Thread.sleep(1000);
  	Actions act = new Actions(Browser.driver);
  	Thread.sleep(100);
   	act.sendKeys(Keys.TAB).perform();
   	Thread.sleep(400);
  	JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
  	kl.executeScript("window.scrollBy(0,700)", "");
  	Thread.sleep(1000);
  	saveBtn.click();
  	Thread.sleep(2000);
  	String at= Browser.driver.findElement(By.xpath("//p[contains(text(),'Please Select Product')]")).getText();
  	 Assert.assertEquals(at, et,"Error massage blankDET == fail");
		System.out.println("Error massage blankDET == pass");
  	}
}

