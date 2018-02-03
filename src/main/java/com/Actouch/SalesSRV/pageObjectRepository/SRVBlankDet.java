package com.Actouch.SalesSRV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class SRVBlankDet {

	@FindBy(id="custid_createSOS")
	WebElement CustEdt;
	@FindBy(id="btnSaveSO")
	WebElement SaveEdt;
	@FindBy(xpath="//p[contains(text(),'Please Select Service Category at Line Number:1')]")
	WebElement ErrorMessage;
	public void BlankDET(String Cust) throws InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
		Actions act = new Actions(Browser.driver);
		String exp="Please Select Service Category at Line Number:1";
		Thread.sleep(3000);
		CustEdt.sendKeys(Cust);
		Thread.sleep(1000);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		SaveEdt.click();
		String Actual =ErrorMessage.getText();
		Assert.assertEquals(Actual, exp,"Blank DET saving ==fail");
		System.out.println("Blank DET Saving ==pass");
	}

	
}
