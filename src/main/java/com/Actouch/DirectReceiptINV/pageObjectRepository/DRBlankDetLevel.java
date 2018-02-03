package com.Actouch.DirectReceiptINV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;

public class DRBlankDetLevel {
	@FindBy(id="prdId_createDpor")
	WebElement SuppEdt;
	 @FindBy(id="btnSave")
		WebElement Save;
		@FindBy(xpath="//p[contains(text(),'Please Select Product at Line Number')]")
		WebElement Result;
		public void BatchMuom(String Supp) throws InterruptedException
		{
			WebDriverWait wait =new WebDriverWait(Browser.driver, 20);
			String	Expected = "Please Select Product at Line Number:1";
			WebDriverCommonlib.waitForPageToLoad();
			Actions act =new Actions(Browser.driver);
			 Thread.sleep(4000);
			SuppEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Supp);
			Thread.sleep(1000);
			act.sendKeys(Keys.TAB).perform();
			 wait.until(ExpectedConditions.visibilityOf(Save));
			  Save.click();
			 String Actual = Result.getText();
			 Assert.assertEquals(Actual, Expected,"Error message expected");

}
}
