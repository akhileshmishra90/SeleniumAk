package com.Actouch.SalesINV.pageObjectRepository;

    

import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.testng.Assert;

	import com.Actouch.Sales.generic_Lib.Browser;
	import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

	public class SR_vehicle {
		public static String amt;
		@FindBy(xpath="//input[@aria-controls='SOTable']")
		WebElement searchtxt;
		@FindBy(xpath="//table[@id='SOTable']/tbody/tr/td[5]")
		   WebElement CustId;
		@FindBy(id="custIdForRso")
		WebElement CustIdShpedt;
		@FindBy(xpath="//div[@id='RSOTable_filter']/label/input")
		WebElement SearchforSo;
		@FindBy(xpath="//table[@id='RSOTable']/tbody/tr/td[3]/span")
		WebElement INV;
		@FindBy(xpath="//table[@id='RSOTable']/tbody/tr/td[8]/div/button")
		WebElement ActionsforSR;
		@FindBy(xpath ="//a[contains(text(),'Shipment Returns/Reject')]")
		WebElement SRReturnpg;
		@FindBy(id="rsoId")
		WebElement RsoId;
		@FindBy(xpath="//div[@data-bind='click: RSOInventory.showVehicleModel']")
		WebElement VehicleModel;
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
		@FindBy(xpath = "//table[@id='PODetailsTable']/tbody/tr/td[1]/input")
		WebElement selectProd;
		@FindBy(xpath="//table[@id='PODetailsTable']/tbody/tr/td[9]/label")
		WebElement RemainQty;
		@FindBy(xpath="//span[contains(text(),'Product')]")
		WebElement productDetails;
		@FindBy(xpath="//table[@id='taxCalc']/tbody/tr/td[1]/input")
		WebElement locProd;
		@FindBy(xpath="//table[@id='taxCalc']/tbody/tr/td[12]/input")
		WebElement issueQnty;
		@FindBy(xpath="html/body/div[9]/form/div/div[3]/button[1]")
		WebElement afterSavingQnty;
		@FindBy(xpath="//label[@data-bind='html: RSOInventory.totalAmt']")
		WebElement TotalEdt;
		@FindBy(id="btnSave")
		WebElement afterRSO;
		@FindBy(xpath="html/body/div[9]/div/div[3]/button")
		   WebElement aftSavingRso;
		@FindBy(xpath="//div[@id='crsobtn']/a")
		   WebElement viewRSo;
		@FindBy(xpath="//div[@id='RSO_Table_filter']/label/input")
		WebElement RsoSearch;
		@FindBy(xpath="//table[@id='RSO_Table']/tbody/tr/td[2]")
		WebElement Result;
		public void VehicleDetail(String TransPortName,String VehicleNo,String GCnumber,String Packing_No,String NumberOfPackage,String Package_Weight  ) throws InterruptedException
		 {
		   WebDriverCommonlib.waitForPageToLoad();
		   	String exp=searchtxt.getAttribute("value"); 
		   	String Cust= CustId.getText();
		   	Browser.driver.get(Constant.RSOMain);		   	
		   	CustIdShpedt.sendKeys(Cust);	   	
		   	Actions act = new Actions(Browser.driver);
		   	act.sendKeys(Keys.TAB).perform();		   	
		   	SearchforSo.sendKeys(exp);			   			   	
		   	ActionsforSR.click();		   	
		   	SRReturnpg.click();		   	
		   	String Excepted=RsoId.getAttribute("value");
		   	Thread.sleep(2000);
	 	selectProd.click();
	 	String Qty=RemainQty.getText();
		   	productDetails.click();		   	
		   	locProd.click();		   	
		   issueQnty.sendKeys(Qty);			
		   	afterSavingQnty.click();		   	
		   	VehicleModel.click();			
			transPorterName.sendKeys(TransPortName);			
			vehicleNo.sendKeys(VehicleNo);			
			gcNo.sendKeys(GCnumber);			
			packingNo.sendKeys(Packing_No);			
			noOfPackage.sendKeys(NumberOfPackage);			
			packingWeight.sendKeys(Package_Weight);			
			saveVehicleDetails.click();
			amt=TotalEdt.getText();
		   	afterRSO.click();		   	
		   	aftSavingRso.click();
			Thread.sleep(4000);
		   	viewRSo.click();
			Thread.sleep(4000);
		   	RsoSearch.sendKeys(Excepted);	   	
		   	String actual = Result.getText();
		   	 Assert.assertEquals(actual, Excepted, "sales return vehicle detail ==fail");
		   	 System.out.println("sales return vehicle detail ==pass");

		 }

	}



