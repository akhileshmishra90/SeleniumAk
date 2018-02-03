package com.Actouch.PurchaseINV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;

public class UPRCVTermCond {

	@FindBy(xpath="//input[@aria-controls='POTable']")
    WebElement SearchPO;
	@FindBy(xpath="//input[@aria-controls='POR_Table']")
	WebElement SearchPOR;
	@FindBy(xpath="//button[text()='Actions']")
	WebElement ActionsEdt;
	@FindBy(linkText="Update PO Receipt")
	WebElement UpdateRCV;
   @FindBy(xpath="//div[@data-bind ='click: PORUpdInventory.showTermsConditionModal']")
   WebElement OpenTermCond;
	@FindBy(xpath="//textarea[@data-bind='value: termsCondnSQ']")
	WebElement TermCondEDT;
	@FindBy(xpath="//button[@data-bind='click: ok']")
	WebElement SaveTermCondi;
	@FindBy(id="btnSave")
	WebElement SaveEDT;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement OKEdt;
	@FindBy(linkText="View PO Receipt")
	WebElement ViewRCV;
	@FindBy(xpath="//div[@data-bind='click: PORInventory.showTermsConditionModal']")
	WebElement ConditionModal;
	@FindBy(xpath="//textarea[@data-bind='value: termsCondnSQ']")
	WebElement Result;
	@FindBy(xpath="//button[@data-bind='click: cancel']")
	WebElement OK;
	public void ReFerence(String ShipCharge) throws InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
		String Exp = SearchPO.getAttribute("value");
		Browser.driver.get(Constant.PorMain);
		Thread.sleep(3000);
		SearchPOR.sendKeys(Exp);
		ActionsEdt.click();
		UpdateRCV.click();
		OpenTermCond.click();
		TermCondEDT.sendKeys(Keys.chord(Keys.CONTROL,"a"),ShipCharge);
		String Expected=TermCondEDT.getAttribute("value");
		SaveTermCondi.click();
		SaveEDT.click();
		OKEdt.click();
		Thread.sleep(3000);
		SearchPOR.sendKeys(Exp);
		ActionsEdt.click();
		ViewRCV.click();
		Thread.sleep(3000);
		ConditionModal.click();
		String Actual = Result.getText();
		OK.click();
		Assert.assertEquals(Actual, Expected,"given Reference is not correct");
		System.out.println("given Reference is correct");
		
		}


}
