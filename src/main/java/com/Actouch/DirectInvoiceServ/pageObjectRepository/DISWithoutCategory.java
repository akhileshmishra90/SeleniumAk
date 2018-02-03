package com.Actouch.DirectInvoiceServ.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class DISWithoutCategory {

	@FindBy(xpath="//label[@data-bind='html: NewSHPMain.OrderTypeSelected'] ")
	WebElement changeType;
	@FindBy(linkText="Service")
	WebElement Service;
	@FindBy(id="custid_createSOS")
	  WebElement CustEdt;
	  @FindBy(xpath="//textarea[@data-bind='value: prdDesc']")
	  WebElement DescEdt;
	  @FindBy(id="unitprice")
	  WebElement UnitpriceEdt;
		@FindBy(id="btnSaveSO")
		WebElement 	SaveEdt;
		@FindBy(xpath="//p[@data-bind ='html: errorDesc']")
		WebElement Errormsg;
	public void BlankCategory(String Cust,String Desc,String Unitprice ) throws InterruptedException
	   {
		   WebDriverCommonlib.waitForPageToLoad();
			Actions act = new Actions(Browser.driver);
			changeType.click();
			Thread.sleep(4000);
			Service.click();
			Thread.sleep(3000);
			String exp ="Please Select Service Category at Line Number:1";
			Thread.sleep(3000);
			CustEdt.sendKeys(Cust);
			Thread.sleep(1000);
			act.sendKeys(Keys.TAB).perform();
						DescEdt.sendKeys(Desc);
                  UnitpriceEdt.sendKeys(Unitprice);
			SaveEdt.click();
			 String act2 = Errormsg.getText();
			    Assert.assertEquals(act2, exp,"check Error message case == fail");
		 		System.out.println("check Error message case == pass");
	   }
}
