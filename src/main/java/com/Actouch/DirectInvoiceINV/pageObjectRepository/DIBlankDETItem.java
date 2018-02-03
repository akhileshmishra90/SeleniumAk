package com.Actouch.DirectInvoiceINV.pageObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
public class DIBlankDETItem {
	   @FindBy(id="SoIsoId")	
	   WebElement SOidEdt;
	   @FindBy(id="createDinvCustId")
	   WebElement DSOCustEdt; 
	   @FindBy(id="btnSave")
	   WebElement SaveEdt;
	    @FindBy(xpath="//p[contains(text(),'Please Select Product')]")
	WebElement Errormessage;
	 public void payltr(String Customer_Id) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	   {
		   WebDriverCommonlib.waitForPageToLoad();
		   Actions act = new Actions(Browser.driver);
		    String exp = "At Line Number: 1. Please Select Product";
		    Thread.sleep(3000);
		    DSOCustEdt.sendKeys(Customer_Id);
		 Thread.sleep(1000);
		  act.sendKeys(Keys.TAB).perform();
		   JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
		   kl.executeScript("window.scrollBy(0,300)", "");
		     SaveEdt.click();
		   String act2 = Errormessage.getText();
		    Assert.assertEquals(act2, exp,"BlankDETitem Error Message== fail");
	  		System.out.println("BlankDETitem Error Message == pass");
		    }

}
