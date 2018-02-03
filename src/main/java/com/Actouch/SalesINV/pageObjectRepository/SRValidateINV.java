package com.Actouch.SalesINV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class SRValidateINV {

	@FindBy(xpath="//input[@aria-controls='SOTable']")
	WebElement searchtxt;
	@FindBy(id="custIdForRso")
	WebElement CustIdShpedt;
	@FindBy(xpath="//div[@id='RSOTable_filter']/label/input")
	WebElement SearchforSo;
	@FindBy(xpath="//table[@id='RSOTable']/tbody/tr/td[3]/span")
	WebElement INV;	
	@FindBy(xpath="//table[@id='RSOTable']/tbody/tr/td[8]/div/button")
	WebElement ActionsforSR;
	@FindBy(xpath ="//a[contains(text(),'Shipment Returns/Reject')]")
	WebElement SRReturnpg;
	@FindBy(id="invoiceId")
	WebElement veryfyinv;
    @FindBy(xpath="//table[@id='SOTable']/tbody/tr/td[5]")
    WebElement CustId;
    @FindBy(xpath="//table[@id='SOTable']/tbody/tr[1]/td[6]")
    WebElement CustName;
      public void InvoiceValidate() throws InterruptedException
      {
	    	WebDriverCommonlib.waitForPageToLoad();	  
	    	String exp=searchtxt.getAttribute("value"); 
	    	String Cust= CustId.getText();
	    	 Browser.driver.get(Constant.RSOMain);	    	
	    	CustIdShpedt.sendKeys(Cust);	    	
	    	Actions act = new Actions(Browser.driver);
	    	act.sendKeys(Keys.TAB).perform();	    		    	
	    	SearchforSo.sendKeys(exp);		   		
		   	String expected =INV.getText();	    	
	    	ActionsforSR.click();	    	
	    	SRReturnpg.click();	    	
	    	String Actual = veryfyinv.getAttribute("value");
	    	Assert.assertEquals(Actual, expected,"INV veryfied =failed");
	    	System.out.println("inv veryfied =pass" );	
      }
}
