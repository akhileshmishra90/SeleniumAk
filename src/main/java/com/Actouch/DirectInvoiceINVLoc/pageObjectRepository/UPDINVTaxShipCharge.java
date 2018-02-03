package com.Actouch.DirectInvoiceINVLoc.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
public class UPDINVTaxShipCharge {
 @FindBy(xpath="//input[@aria-controls='SOTable']")
		WebElement SearchEdt;
		@FindBy(xpath="//input[@aria-controls='SHP_Table']")
		WebElement InvoiceEdt;
		@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle']")
		WebElement ActionEdt;
		@FindBy(linkText="Update Invoice")
		WebElement UpdateInvoice;
		@FindBy(id="shpCharge")
		WebElement ShpChargeEdt;
		@FindBy(id="shpTax-select")
		WebElement ShpTaxEdt;
		@FindBy(id="SOShipTax-select")
		WebElement TaxEdt;
		@FindBy(id="saveMethod")
		WebElement saveEdt;
		@FindBy(xpath="html/body/div[9]/div/div[3]/button")
		WebElement AfterSaveEdt;
		@FindBy(linkText="View Invoices")
		WebElement Viewstatus;
		@FindBy(linkText="View Invoice")
		WebElement CheckInvoice;
		@FindBy(xpath="//span[@data-bind='text: soShipment.shipTax']")
		WebElement ResultEdt;
		public void UpdateAmount(String ShpCharge,String SelectTax,String Tax) throws InterruptedException
		{
			WebDriverCommonlib.waitForPageToLoad();
			Actions act = new Actions(Browser.driver);
		String exp=	InvoiceEdt.getAttribute("value");
		   ActionEdt.click();
			UpdateInvoice.click();
			ShpTaxEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),SelectTax);
			act.sendKeys(Keys.ARROW_DOWN).perform();
			act.sendKeys(Keys.ENTER).perform();
			ShpChargeEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),ShpCharge);
			 act.sendKeys(Keys.ENTER).perform();
			 TaxEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Tax);
			 act.sendKeys(Keys.ARROW_DOWN).perform();
				act.sendKeys(Keys.ENTER).perform();
			String Expected =  TaxEdt.getAttribute("value");
			saveEdt.click();
			AfterSaveEdt.click();
			Thread.sleep(3000);
			InvoiceEdt.sendKeys(exp);
			ActionEdt.click();
			CheckInvoice.click();
			Thread.sleep(3000);
			String Actual = ResultEdt.getText();
			Assert.assertEquals(Actual, Expected,"Customer update wrong");
			System.out.println("Customer Upadate As Usual");
			
		}

}
