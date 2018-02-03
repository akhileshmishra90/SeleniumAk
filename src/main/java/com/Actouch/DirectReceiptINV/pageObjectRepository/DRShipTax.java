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

public class DRShipTax {

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
		@FindBy(id="shpTax-select")
		WebElement ShpTaxSelect;
		@FindBy(id="shpCharge")
		WebElement ShpChargeEdt;
		@FindBy(id="POShipTax-select")
		WebElement PoshipTaxEdt;
	   @FindBy(xpath="//label[@data-bind='html: DPInventory.netAmt']")
		WebElement TotalAmt;
		@FindBy(id="btnSave")
		WebElement Save;
		@FindBy(xpath="html/body/div[9]/div/div[3]/button")
		WebElement okEdt;
		@FindBy(xpath="//input[@aria-controls='POR_Table']")
		WebElement SerchPOR;
		@FindBy(xpath=".//*[@id='POR_Table']/tbody/tr/td[3]")
		WebElement Result;
		public void CrdTerm(String Supp,String ProdID,String Qnty,String UnitP,String TaxCode,String ShpCharge,String ShpTaxselect) throws InterruptedException
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
			  ShpTaxSelect.sendKeys(Keys.chord(Keys.CONTROL,"a"),"Yes");
			  act.sendKeys(Keys.ARROW_DOWN).perform();
			  act.sendKeys(Keys.ENTER).perform();
			  ShpChargeEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),ShpCharge);
			  PoshipTaxEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),ShpTaxselect);
			  act.sendKeys(Keys.ARROW_DOWN).perform();
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
