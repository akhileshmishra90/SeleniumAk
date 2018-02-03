package com.Actouch.PurchaseSRV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;

public class UPSRVRCVDisINR {

	@FindBy(xpath="//input[@aria-controls='POTable']")
	WebElement getPOID;
	@FindBy(xpath="//input[@aria-controls='POR_Table']")
	WebElement SearchPOR;
	@FindBy(xpath="//button[text()='Actions']")
	WebElement Action;
	@FindBy(linkText ="Update PO Receipt")
	WebElement ClickUpdate;
	@FindBy(xpath="//span[@data-bind='text: PORServiceUpdate.discType']")
	WebElement DiscType;
	@FindBy(xpath="//span[@data-bind = 'text: PORServiceUpdate.discType2']")
	WebElement DiscINR;
	@FindBy(id="overAllDisc")
	WebElement AllDiscPerEdt;
	@FindBy(id="btnSave")
	WebElement Save;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement okEdt;
	@FindBy(linkText="View PO Receipt")
	WebElement ClickView;
	@FindBy(xpath="//label[@data-bind='html: PORInventory.overAllDisc']")
	WebElement Result;
	public void Supplier(String DisINR) throws InterruptedException
	{
	    WebDriverCommonlib.waitForPageToLoad();
		String Exp=getPOID.getAttribute("value");
		Browser.driver.get(Constant.PorMain);
		Thread.sleep(3000);
		SearchPOR.sendKeys(Exp);
		Action.click();
		ClickUpdate.click();
		DiscType.click();
		DiscINR.click();
		AllDiscPerEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),DisINR);
	    String Expected=AllDiscPerEdt.getAttribute("value");
	    Save.click();
	    okEdt.click();
	    Thread.sleep(3000);
	    SearchPOR.sendKeys(Exp);
	    Action.click();
		ClickView.click();
		Thread.sleep(3000);
		String Actual=Result.getText();
		Assert.assertEquals(Actual, Expected,"supplier name is update not correct");
		System.out.println("Supplier name is correct");
			}


}
