package com.Actouch.DirectReceiptINV.pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;

public class DRVehicleDetail {
	 public static String amt;
	    @FindBy(id="poId")
	    WebElement PORID;
		@FindBy(id="prdId_createDpor")
		WebElement SuppEdt;
    	@FindBy(id="prdPo_1")
		WebElement ProdIDEdt;
		@FindBy(xpath="//div[@data-bind='if:chkLoc']/span")
		WebElement prodModEdt;
		@FindBy(xpath="//td[@data-bind='visible: !isSerialNo()']/input")
		WebElement QntyEdt;
		@FindBy(xpath="//button[@data-bind='click: ok']")
		WebElement QtySave;
		@FindBy(id="unitprice")
		WebElement UnitPEdt;
		@FindBy(xpath="//span[@data-bind='click: showPOTaxModel']")
		WebElement TaxModel;
	   @FindBy(xpath="//label[@data-bind='html: DPInventory.netAmt']")
		WebElement TotalAmt;
		@FindBy(xpath="//div [@data-bind='click: DPInventory.showVehicleModel']")
		WebElement vehiclemodel;
		@FindBy(xpath="//input [@data-bind='value: transName']")
		WebElement transNameEdt;
		@FindBy(xpath="//input [@data-bind='value: vehicleNo']")
		WebElement vehicleNoEdt;
		@FindBy(xpath="//input [@data-bind='value: gclrNo']")
		WebElement gclrNoEdt;
		@FindBy(xpath="//input [@data-bind='value: packingNo']")
		WebElement packingNoEdt;
		@FindBy(xpath="//input [@data-bind='value: packageNo']")
		WebElement packageNoEdt;
		@FindBy(xpath="//input [@data-bind='value: packingWgt']")
		WebElement packingWgtEdt;
		@FindBy(xpath="//button [@data-bind='click: ok']")
		WebElement okEdtV;
	     @FindBy(id="btnSave")
		WebElement Save;
		@FindBy(xpath="html/body/div[9]/div/div[3]/button")
		WebElement okEdt;
		@FindBy(xpath="//input[@aria-controls='POR_Table']")
		WebElement SerchPOR;
		@FindBy(xpath=".//*[@id='POR_Table']/tbody/tr/td[3]")
		WebElement Result;
		public void CrdTerm(String Supp,String ProdID,String Qnty,String UnitP,String TaxCode,String transName,String vehicleNo, String gclrNo,String packingNo,String packageNo,String packingWgt) throws InterruptedException
		{
			WebDriverWait wait =new WebDriverWait(Browser.driver, 20);
			Actions act =new Actions(Browser.driver);
			String Expected= PORID.getAttribute("value");
			wait.until(ExpectedConditions.visibilityOf(SuppEdt));
			SuppEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Supp);
			Thread.sleep(1000);
			act.sendKeys(Keys.TAB).perform();
		    	ProdIDEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),ProdID);
			 Thread.sleep(1000);
			act.sendKeys(Keys.TAB).perform();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(prodModEdt));
			prodModEdt.click();
			QntyEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Qnty);
			QtySave.click();
			UnitPEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),UnitP);
			wait.until(ExpectedConditions.visibilityOf(TaxModel));
			act.moveToElement(TaxModel).click().perform();
			  for(int i=1;i<10;i++)
			  {
			String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
				  if(count1.equals(TaxCode)){
					Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
					Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
				  break;
				  	
				  }
			  }
			  wait.until(ExpectedConditions.visibilityOf(vehiclemodel));
			  vehiclemodel.click();
			    transNameEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),transName);
			  vehicleNoEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),vehicleNo);
			  gclrNoEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),gclrNo);
			  packingNoEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),packingNo);
			  packageNoEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),packageNo);
			  packingWgtEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),packingWgt);
			 okEdtV.click();
			  act.sendKeys(Keys.ENTER).perform();
			amt=TotalAmt.getText();
			  Save.click();
			  okEdt.click();
			 Browser.driver.get(Constant.PorMain);
			 wait.until(ExpectedConditions.visibilityOf(SerchPOR));
			 SerchPOR.sendKeys(Expected);
			 String Actual = Result.getText();
			 Assert.assertEquals(Actual, Expected,"POR ID not created");
			  
		}


}
