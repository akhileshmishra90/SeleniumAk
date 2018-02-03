package com.Actouch.SalesSRV.pageObjectRepository;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class SRVBlankSO {
	
	@FindBy(id="btnSaveSO")
	WebElement SaveEdt;
	@FindBy(xpath="//p[contains(text(),'Customer Id cannot be blank')]")
	WebElement ErrorMessage;
	public void BlankSO() throws InterruptedException
	{
	WebDriverCommonlib.waitForPageToLoad();

	String exp ="Customer Id cannot be blank" ;
	Thread.sleep(3000);
	SaveEdt.click();
	String Actual =ErrorMessage.getText();
	Assert.assertEquals(Actual, exp,"Blank SO saving ==fail");
	System.out.println("Blank SO Saving ==pass");
	}
}
