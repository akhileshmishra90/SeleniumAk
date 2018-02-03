package com.Actouch.DirectInvoiceServ.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class DISBlankDET {
	@FindBy(xpath="//label[@data-bind='html: NewSHPMain.OrderTypeSelected'] ")
	WebElement changeType;
	@FindBy(linkText="Service")
	WebElement Service;
	  @FindBy(id="SoIsoId")	
	   WebElement SOidEdt;
	   @FindBy(id="createDinvCustId")
	   WebElement DSOCustEdt; 
	   @FindBy(id="btnSave")
	   WebElement SaveEdt;
	    @FindBy(xpath="//p[contains(text(),'Please Select Product')]")
	WebElement Errormessage;
	public void BlankDET(String Cust) throws InterruptedException
	{
	WebDriverCommonlib.waitForPageToLoad();
	Actions act = new Actions(Browser.driver);
	changeType.click();
	Thread.sleep(4000);
	Service.click();
	String exp="Please Select Service Category at Line Number:1";
	Thread.sleep(3000);
	DSOCustEdt.sendKeys(Cust);
	Thread.sleep(1000);
	act.sendKeys(Keys.ARROW_DOWN).perform();
	act.sendKeys(Keys.ENTER).perform();
	SaveEdt.click();
	String Actual =Errormessage.getText();
	Assert.assertEquals(Actual, exp,"Blank DET saving ==fail");
	System.out.println("Blank DET Saving ==pass");
	}
}
