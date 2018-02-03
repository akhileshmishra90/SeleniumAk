package com.Actouch.PurchaseSRV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;

public class UPSRVRCVReference {

	@FindBy(xpath="//input[@aria-controls='POTable']")
	WebElement getPOID;
	@FindBy(xpath="//input[@aria-controls='POR_Table']")
	WebElement SearchPOR;
	@FindBy(xpath="//button[text()='Actions']")
	WebElement Action;
	@FindBy(linkText ="Update PO Receipt")
	WebElement ClickUpdate;
	@FindBy(id="porSUSuppList")
	WebElement SuppIDEdt;
	@FindBy(id="PORSoRefno")
	WebElement RefEdt;
	@FindBy(id="soRefAmt")
	WebElement RefAmtEdt;
	@FindBy(id="btnSave")
	WebElement Save;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement okEdt;
	@FindBy(linkText="View PO Receipt")
	WebElement ClickView;
	@FindBy(xpath="//label[@data-bind='html: PORInventory.suppName']")
	WebElement Result;
	public void Supplier(String Reference,String RefAmt) throws InterruptedException
	{
	    WebDriverCommonlib.waitForPageToLoad();
		String Exp=getPOID.getAttribute("value");
		Browser.driver.get(Constant.PorMain);
		Thread.sleep(3000);
		SearchPOR.sendKeys(Exp);
		Action.click();
		ClickUpdate.click();
		RefEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Reference);
         RefAmtEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),RefAmt);     	
 	    String Expected=RefEdt.getAttribute("value");
 	    System.out.println(Expected);
	    Save.click();
	    okEdt.click();
	    Thread.sleep(3000);
	    SearchPOR.sendKeys(Exp);
	    Action.click();
		ClickView.click();
		String Actual=Result.getText();
		System.out.println(Actual);
		Assert.assertEquals(Actual, Expected,"supplier name is update not correct");
		System.out.println("Supplier name is correct");
			}
}
