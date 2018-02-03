package com.Actouch.PurchaseSRV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;

public class POSRVBlankDet {
	@FindBy(id="poServSuppList")
	WebElement SuppEdt;
	@FindBy(id="btnSave")
	WebElement SaveEdt;
		@FindBy(xpath="//p[contains(text(),'Please Select Service Category at Line Number:1')]")
	WebElement actval;
	public void BlankPo(String Supp) throws InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
		Actions act = new Actions(Browser.driver);
		String exp ="Please Select Service Category at Line Number:1" ;
		Thread.sleep(3000);
		SuppEdt.sendKeys(Supp);
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).perform();
SaveEdt.click();
	String act2 = actval.getText();
		    Assert.assertEquals(act2, exp,"payment later after saving case == fail");
	 		System.out.println("payment later after saving case == pass");
		   }

}
