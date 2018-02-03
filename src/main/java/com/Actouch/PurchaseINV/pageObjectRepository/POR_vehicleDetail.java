package com.Actouch.PurchaseINV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;

public class POR_vehicleDetail {
	public static String amt;
	 @FindBy(xpath="//input[@aria-controls='POTable']")
	    WebElement searchtxt;
	 @FindBy(xpath="//table[@id='POTable']/tbody/tr/td[5]")
	 WebElement SuppNMforPOR;
	 @FindBy(id="suppIdFor_Por")
	 WebElement SuppDshEdt;
	 @FindBy(xpath="//input[@aria-controls='POTable']")
	 WebElement searchForPO;
	 @FindBy(xpath=".//*[@id='POTable']/tbody/tr/td[2]/a")
	 WebElement choosePOid;
	 @FindBy(id="porId" )
	 WebElement PORid;
	 @FindBy(xpath="//table[@id='PORDetailsTable']/tbody/tr/td[1]/input")
	 WebElement Selectprod;
	 @FindBy(xpath="//table[@id='PORDetailsTable']/tbody/tr/td[6]/label")
	 WebElement RemainQnty;
	 @FindBy(xpath="//span[text()='Product Details']")
	 WebElement productDetail;
	 @FindBy(xpath ="//table[@id ='batchId' ]/tbody/tr/td[9]/input")
	 WebElement RecQnty;
	 @FindBy(xpath="//button[@data-bind = 'click: ok']")
	 WebElement AfterReceive;
	  @FindBy(xpath ="//input[@data-bind='value: transName']")
	 WebElement transPorterName;
	 @FindBy(xpath="//input[@data-bind='value: vehicleNo']")
	 WebElement vehicleNo;
	 @FindBy(xpath="//input[@data-bind='value: gclrNo']")
	 WebElement gcNo;
	 @FindBy(xpath="//input[@data-bind='value: packingNo']")
	 WebElement packingNo;
	 @FindBy(xpath="//input[@data-bind='value: packageNo']")
	 WebElement noOfPackage;
	 @FindBy(xpath="//input[@data-bind='value: packingWgt']")
	 WebElement packingWeight;
	 @FindBy(xpath="//button[@data-bind='click: ok']")
	 WebElement saveVehicleDetails;
@FindBy(xpath= "//div[@data-bind = 'click: PORInventory.showVehicleModel']")
	 WebElement velicleEdt;
  @FindBy(xpath="//label[@data-bind='html: PORInventory.totalAmt']")
   WebElement Totaledt;
    @FindBy(id="btnSave")
	 WebElement SaveEdt;
	 @FindBy(xpath="html/body/div[9]/div/div[3]/button")
	 WebElement AfterSave;
	 @FindBy(xpath="//div[@id='crpobtn']/a")
	 WebElement viewReceipt;
	 @FindBy(xpath="//input[@aria-controls='POR_Table']")
	 WebElement SearchPOR;
	 @FindBy(xpath="//table[@id='POR_Table']/tbody/tr/td[3]")
	 WebElement Result;
	 public void ReceiptVehicle(String TransPortName,String VehicleNo,String GCnumber,String Packing_No,String NumberOfPackage,String Package_Weight) throws InterruptedException
	 {
 WebDriverCommonlib.waitForPageToLoad();
		 String exp = searchtxt.getAttribute("value");
		 		 String Supp = SuppNMforPOR.getText();
		 Browser.driver.get(Constant.newPorMain);
		 SuppDshEdt.sendKeys(Supp);
		 Actions act = new Actions(Browser.driver);
		 act.sendKeys(Keys.ARROW_DOWN).perform();
		 act.sendKeys(Keys.ENTER).perform();
		 Thread.sleep(2000);
		 searchForPO.sendKeys(exp);
		 choosePOid.click();
		 String Expected = PORid.getAttribute("value");
		 Thread.sleep(2000);
		 Selectprod.click();
		 String RemQty =RemainQnty.getText();
		 productDetail.click();
		 RecQnty.sendKeys(RemQty);
		 AfterReceive.click();
		 velicleEdt.click();
			transPorterName.sendKeys(TransPortName);	
			vehicleNo.sendKeys(VehicleNo);
			gcNo.sendKeys(GCnumber);
			packingNo.sendKeys(Packing_No);
			noOfPackage.sendKeys(NumberOfPackage);
			packingWeight.sendKeys(Package_Weight);
				saveVehicleDetails.click();
				act.sendKeys(Keys.ENTER).perform();
				amt = Totaledt.getText();
	 SaveEdt.click();
			 AfterSave.click();
			 Thread.sleep(4000);
		 	 viewReceipt.click();
		 	 Thread.sleep(4000);
	 SearchPOR.sendKeys(Expected);
			 String Actual = Result.getText();
		  Assert.assertEquals(Actual, Expected,"Full Purchase Receipt == fail");
		 System.out.println("Full purchase Receipt == pass");
		 }
	 
}
