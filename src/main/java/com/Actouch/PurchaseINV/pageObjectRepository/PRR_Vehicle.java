package com.Actouch.PurchaseINV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;

public class PRR_Vehicle {
	public static String amt;
	@FindBy(xpath="//input[@aria-controls='POTable']")
	WebElement SearchEdt;
	@FindBy(xpath = "//table[@id='POTable']/tbody/tr/td[5]")
	WebElement SuppEdt;
	@FindBy(id ="suppIdPrr")
	WebElement SuppDashEdt;
	@FindBy(xpath="//div[@id='PORTable_filter']/label/input")
	WebElement Searchpartcular;
	@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle']")
	WebElement ActionEdt;
	@FindBy(xpath="//a[contains(text(),'POR Returns')]")
	WebElement POReturns;
	@FindBy(id="prrId")
	WebElement PRRIdEdt;
	@FindBy(xpath=".//*[@id='PORDetailsTable']/tbody/tr/td[1]/input")
	WebElement chooseId;
	@FindBy(xpath="//label[@data-bind='text: qtyRemain']")
	WebElement RemainQtyEdt;
	@FindBy(xpath="//span[@class='label label-warning']")
	WebElement prodmodelEdt;
	@FindBy(xpath="//tbody[@data-bind='foreach: porDetailList']/tr[3]/td[1]/div/input")
	WebElement selectQty;
	@FindBy(xpath="//input[@data-bind='value: soldQty,enable: chkRjct']")
	WebElement QtyEdt;
	@FindBy(xpath="//button[@data-bind='click: ok']")
	WebElement QtySubmit;
	@FindBy(xpath="//input[@data-bind='value: rejReason, enable: chkReason']")
	WebElement Rejreason;
	@FindBy(xpath="//div[@data-bind='click: PRRInventory.showVehicleModel']")
	WebElement VehicleEdt;
	@FindBy(xpath ="//input[@data-bind='value: transName']")
	 WebElement TransPorterEdt;
	 @FindBy(xpath="//input[@data-bind='value: vehicleNo']")
	 WebElement vehicleNoEdt;
	 @FindBy(xpath="//input[@data-bind='value: gclrNo']")
	 WebElement gcNoEdt;
	 @FindBy(xpath="//input[@data-bind='value: packingNo']")
	 WebElement packingNoEdt;
	 @FindBy(xpath="//input[@data-bind='value: packageNo']")
	 WebElement noOfPackageEdt;
	 @FindBy(xpath="//input[@data-bind='value: packingWgt']")
	 WebElement packingWeightEdt;
	 @FindBy(xpath="//button[@data-bind='click: ok']")
	 WebElement saveVehicleDetailsEdt;
	 @FindBy(xpath="//label[@data-bind='html: PRRInventory.totalAmt']")
		WebElement TotalEdt;
@FindBy(id ="btnSave")
	WebElement SaveEdt;
	@FindBy(xpath="//button[@class='btn btn-primary autofocus']")
	WebElement AfterSaving;
	@FindBy(xpath="//div[@id='crpobtn']/a")
	WebElement ViewReturn;
	@FindBy(xpath="//input[@aria-controls='PRR_Table']")
	WebElement PRRSearch;
	@FindBy(xpath="//table[@id='PRR_Table']/tbody/tr/td[2]")
	WebElement Result;
	public void FullReturnVehicle(String Reason,String TransPorter,String vehicleNo,String gcNo,String packingNo,String noOfPackage,String packingWeight) throws InterruptedException
	{
WebDriverCommonlib.waitForPageToLoad();
		String Exp = SearchEdt.getAttribute("value");
		String Supp= SuppEdt.getText();
		Browser.driver.get(Constant.PRRMain);
			SuppDashEdt.sendKeys(Supp);
		Actions act = new Actions(Browser.driver);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		Searchpartcular.sendKeys(Exp);
		ActionEdt.click();
		POReturns.click();
			String Expected=PRRIdEdt.getAttribute("value");
			Thread.sleep(2000);
		chooseId.click();
		String Qty = RemainQtyEdt.getText();
			prodmodelEdt.click();
		selectQty.click();
		QtyEdt.sendKeys(Qty);
		QtySubmit.click();
		Rejreason.sendKeys(Reason);
		VehicleEdt.click();
		TransPorterEdt.sendKeys(TransPorter);
		vehicleNoEdt.sendKeys(vehicleNo);
		gcNoEdt.sendKeys(gcNo);
		packingNoEdt.sendKeys(packingNo);
		noOfPackageEdt.sendKeys(noOfPackage);
		packingWeightEdt.sendKeys(packingWeight);
		saveVehicleDetailsEdt.click();
		act.sendKeys(Keys.ENTER).perform();
		amt = TotalEdt.getText(); 
		  SaveEdt.click();
		AfterSaving.click();
		Thread.sleep(4000);
		ViewReturn.click();
		Thread.sleep(4000);
		PRRSearch.sendKeys(Expected);
		String Actual = Result.getText();
		Assert.assertEquals(Actual, Expected,"full purchase return == fail");
		System.out.println("full purchase return = pass");
		}

}
