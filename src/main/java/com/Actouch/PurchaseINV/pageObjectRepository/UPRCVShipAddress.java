package com.Actouch.PurchaseINV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;

public class UPRCVShipAddress {

	 @FindBy(xpath="//input[@aria-controls='POTable']")
	    WebElement SearchPO;
		@FindBy(xpath="//input[@aria-controls='POR_Table']")
		WebElement SearchPOR;
		@FindBy(xpath="//button[text()='Actions']")
		WebElement ActionsEdt;
		@FindBy(linkText="Update PO Receipt")
		WebElement UpdateRCV;
		@FindBy(xpath="//textarea[@placeholder='Shipping Address']")
		WebElement ShipAddressEDT;
		@FindBy(id="btnSave")
		WebElement SaveEDT;
		@FindBy(xpath="html/body/div[9]/div/div[3]/button")
		WebElement OKEdt;
		@FindBy(linkText="View PO Receipt")
		WebElement ViewRCV;
		@FindBy(xpath="//label[@data-bind ='html: PORInventory.shipAddress']")
		WebElement Result;
		public void ReFerence(String ShipAddress) throws InterruptedException
		{
			WebDriverCommonlib.waitForPageToLoad();
			String Exp = SearchPO.getAttribute("value");
			Browser.driver.get(Constant.PorMain);
			Thread.sleep(3000);
			SearchPOR.sendKeys(Exp);
			ActionsEdt.click();
			UpdateRCV.click();
			ShipAddressEDT.sendKeys(Keys.chord(Keys.CONTROL,"a"),ShipAddress);
			String Expected=ShipAddressEDT.getAttribute("value");
			SaveEDT.click();
			OKEdt.click();
			Thread.sleep(3000);
			SearchPOR.sendKeys(Exp);
			ActionsEdt.click();
			ViewRCV.click();
			Thread.sleep(3000);
			String Actual = Result.getText();
			Assert.assertEquals(Actual, Expected,"given Reference is not correct");
			System.out.println("given Reference is correct");
			
			
		}

}
