package com.Actouch.PurchaseINV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;

public class UPRCVVehicleDetail {

	@FindBy(xpath="//input[@aria-controls='POTable']")
    WebElement SearchPO;
	@FindBy(xpath="//input[@aria-controls='POR_Table']")
	WebElement SearchPOR;
	@FindBy(xpath="//button[text()='Actions']")
	WebElement ActionsEdt;
	@FindBy(linkText="Update PO Receipt")
	WebElement UpdateRCV;
	@FindBy(xpath="//div[@data-bind='click: PORUpdInventory.showVehicleModel']")
	WebElement VehicleEDT;
	@FindBy(xpath="//input[@data-bind='value: transName']")
	WebElement TransNameEdt;
	@FindBy(xpath="//input[@data-bind='value: vehicleNo']")
	WebElement VehicleNoEdt;
	@FindBy(xpath="//input[@data-bind='value: gclrNo']")
	WebElement GclrNoEdt;
	@FindBy(xpath="//input[@data-bind='value: packingNo']")
	WebElement PackingNoEdt;
	@FindBy(xpath="//input[@data-bind='value: packageNo']")
	WebElement PackageNoEdt;
	@FindBy(xpath="//input[@data-bind='value: packingWgt']")
	WebElement packingWgtEdt;
	@FindBy(xpath="//button[@data-bind='click: ok']")
    WebElement Savevehicle;
	@FindBy(id="btnSave")
	WebElement SaveEDT;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement OKEdt;
	@FindBy(linkText="View PO Receipt")
	WebElement ViewRCV;
	@FindBy(xpath="//label[@data-bind ='html: PORInventory.vehicleNo']")
	WebElement Result;
	public void ReFerence(String TransName,String VehicleNo, String GclrNo, String PackingNo, String PackageNo, String packingWgt) throws InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
		String Exp = SearchPO.getAttribute("value");
		Browser.driver.get(Constant.PorMain);
		Thread.sleep(3000);
		SearchPOR.sendKeys(Exp);
		ActionsEdt.click();
		UpdateRCV.click();
		VehicleEDT.click();
		TransNameEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),TransName);
		VehicleNoEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),VehicleNo);
		GclrNoEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),GclrNo);
		PackingNoEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),PackingNo);
		PackageNoEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),PackageNo);
		packingWgtEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),packingWgt);
		String Expected=VehicleNoEdt.getAttribute("value");
		Savevehicle.click();
		Thread.sleep(1000);
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
