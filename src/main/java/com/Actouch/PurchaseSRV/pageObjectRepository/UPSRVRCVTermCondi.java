package com.Actouch.PurchaseSRV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;

public class UPSRVRCVTermCondi {

	@FindBy(xpath="//input[@aria-controls='POTable']")
	WebElement getPOID;
	@FindBy(xpath="//input[@aria-controls='POR_Table']")
	WebElement SearchPOR;
	@FindBy(xpath="//button[text()='Actions']")
	WebElement Action;
	@FindBy(linkText ="Update PO Receipt")
	WebElement ClickUpdate;
	@FindBy(xpath="//div[@data-bind='click: PORServiceUpdate.showTermsConditionModal']")
	WebElement TermCond;
	@FindBy(xpath="//textarea[@data-bind='value: termsCondnSQ']")
	WebElement TermCondiEdt;
	@FindBy(id="btnSave")
	WebElement Save;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement okEdt;
	@FindBy(linkText="View PO Receipt")
	WebElement ClickView;
	@FindBy(xpath="//label[@data-bind='html: PORInventory.suppName']")
	WebElement Result;
	public void Supplier(String TermCond) throws InterruptedException
	{
	    WebDriverCommonlib.waitForPageToLoad();
		Actions act = new Actions(Browser.driver);
		String Exp=getPOID.getAttribute("value");
		Browser.driver.get(Constant.PorMain);
		Thread.sleep(3000);
		SearchPOR.sendKeys(Exp);
		Action.click();
		ClickUpdate.click();
		Thread.sleep(3000);
		TermCondiEdt.click();
		TermCondiEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),TermCond);
	    act.sendKeys(Keys.ARROW_DOWN).perform();
	    act.sendKeys(Keys.ENTER).perform();
	    String Expected=TermCondiEdt.getAttribute("value");
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
