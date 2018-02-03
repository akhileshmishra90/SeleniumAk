package com.Actouch.SalesINVLoc.pageObjectRepository;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.testng.asserts.SoftAssert;

import com.Actouch.Sales.generic_Lib.Browser;

import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
//After saving error message verification
public class SOBlankPageSaving extends WebDriverCommonlib {
	
	@FindBy(id="btnSave")
	WebElement salsSavingbtn;
	 @FindBy(xpath = "//p[contains(text(),'Customer Id cannot be blank')]")
	 WebElement ActualResult;
  	public void Blank_PageSaving() throws InterruptedException
  	{
  		WebDriverCommonlib.waitForPageToLoad();
String et = "Customer Id cannot be blank";
  	JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
  	kl.executeScript("window.scrollBy(0,700)", "");
  	Thread.sleep(2000);
  	salsSavingbtn.click();
  		String at= ActualResult.getText();
  	 boolean status= et.contains(at);
	 System.out.println(status);
	SoftAssert as= new SoftAssert();
	//as.assertTrue(status);
	System.out.println("1st test case finish");
	as.assertAll();
 //   Assert.assertEquals(at, et,"Custmer id cannot blank case pass == fail");
	//	System.out.println("Custmer id cannot blank case pass == pass");
  }

}