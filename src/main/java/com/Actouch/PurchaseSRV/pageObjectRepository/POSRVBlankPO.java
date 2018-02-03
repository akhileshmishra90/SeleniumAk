package com.Actouch.PurchaseSRV.pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;

public class POSRVBlankPO {
	
	@FindBy(id="btnSave")
	WebElement SaveEdt;
		@FindBy(xpath="//p[contains(text(),'Supplier ID Cannot be Blank')]")
	WebElement actval;
	public void BlankPo() throws InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
		String exp ="Supplier ID Cannot be Blank" ;
		Thread.sleep(3000);
		SaveEdt.click();
	String act2 = actval.getText();
		    Assert.assertEquals(act2, exp,"payment later after saving case == fail");
	 		System.out.println("payment later after saving case == pass");
		   }

}
