package com.Actouch.SalesINVLoc.pageObjectRepository;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class SRValidateCustomer {
	@FindBy(xpath="//input[@aria-controls='SOTable']")
	WebElement searchtxt;
	@FindBy(id="custIdForRso")
	WebElement CustIdShpedt;
	@FindBy(xpath="//div[@id='RSOTable_filter']/label/input")
	WebElement SearchforSo;
	@FindBy(xpath="//table[@id='RSOTable']/tbody/tr/td[8]/div/button")
	WebElement ActionsforSR;
	@FindBy(xpath ="//a[contains(text(),'Shipment Returns/Reject')]")
	WebElement SRReturnpg;
    @FindBy(xpath="//table[@id='SOTable']/tbody/tr/td[5]")
    WebElement CustId;
    @FindBy(xpath="//table[@id='SOTable']/tbody/tr[1]/td[6]")
    WebElement CustName;
    @FindBy(id="custName")
    WebElement VeryfyCust;
   

      public void CustomerValidate() throws InterruptedException
      {
	    	WebDriverCommonlib.waitForPageToLoad();
	    	String exp=searchtxt.getAttribute("value"); 
	    	String Cust= CustId.getText();
	    	String Custname =CustName.getText();    	
	    	 Browser.driver.get(Constant.RSOMain);
	    	 WebDriverCommonlib.waitForElementPresent(CustIdShpedt);
	    	CustIdShpedt.sendKeys(Cust);	    	
	    	Actions act = new Actions(Browser.driver);
	    	act.sendKeys(Keys.TAB).perform();
	    	Thread.sleep(2000);
	    	String veryCust = VeryfyCust.getAttribute("value");
	    	Assert.assertEquals(veryCust, Custname,"Customer Name of searchbar veryfied==fail");
	    	System.out.println("Customer Name of searchbar veryfied == pass");	    	
	    	SearchforSo.sendKeys(exp);	   	
	    	ActionsforSR.click();	    	
	    	SRReturnpg.click();	    	
	    	String veryCust1 = VeryfyCust.getAttribute("value");
	    	Assert.assertEquals(veryCust1, Custname,"Customer Name verified==fail");
	    	System.out.println("Customer Name veryfied == pass");
	
      }
}
