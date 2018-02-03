package com.Actouch.SalesQuotation.pageObjectRepository;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import com.Actouch.SalesQuotation.generic_Lib.Browser;

import com.Actouch.SalesQuotation.generic_Lib.WebDriverCommonlib;
//After saving error message verification

public class SqBlankPageSaving extends WebDriverCommonlib {
	
	@FindBy(id="btnSave")
	WebElement saveBtn;
	 @FindBy(xpath = "//p[contains(text(),'Customer Id cannot be blank')]")
	 WebElement ActualResult;
	 
  	public void Blank_PageSaving() throws InterruptedException
  	{
  		

	  	String et = "Customer Id cannot be blank";
	  	
	  	JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
		   kl.executeScript("window.scrollBy(0,400)", "");
	  	Thread.sleep(1000);
	  	saveBtn.click();
	  	Thread.sleep(3000);
	  	
	  	String at= ActualResult.getText();
	  	 boolean status= et.contains(at);
		 System.out.println(status);
		SoftAssert as= new SoftAssert();
//		as.assertTrue(status);
		System.out.println("1st test case finish");
		as.assertAll();
  	}

}