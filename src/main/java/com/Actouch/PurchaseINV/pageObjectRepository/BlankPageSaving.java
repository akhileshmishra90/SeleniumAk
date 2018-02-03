package com.Actouch.PurchaseINV.pageObjectRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;
public class BlankPageSaving extends WebDriverCommonlib {
	
	@FindBy(id="btnSave")
	WebElement purSaveBtn;
	@FindBy(xpath = "//p[contains(text(),'Supplier ID Cannot be Blank')]")
	 WebElement ActualResult;
	 
  	public void Blank_PageSaving() throws InterruptedException
  	{
  	WebDriverCommonlib.waitForPageToLoad();	
	  	String et = "Supplier ID Cannot be Blank";
	  	JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
	  	kl.executeScript("window.scrollBy(0,700)", "");	  	
	  	purSaveBtn.click();
	  	String at= ActualResult.getText();
	    Assert.assertEquals(at, et,"Supplier Id cannot be blank after saving case == fail");
		System.out.println("Supplier Id cannot be blank after saving case == pass");
  	}

}