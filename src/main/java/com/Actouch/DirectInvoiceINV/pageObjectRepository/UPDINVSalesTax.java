package com.Actouch.DirectInvoiceINV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class UPDINVSalesTax {

	 @FindBy(xpath="//input[@aria-controls='SHP_Table']")
		WebElement InvoiceEdt;
		@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle']")
		WebElement ActionEdt;
		@FindBy(linkText="Update Invoice")
		WebElement UpdateInvoice;
		@FindBy(id="CST-select")
		WebElement CSTTax;
		@FindBy(id="SOCFormTaxList-select")
		WebElement SalesTax;
		@FindBy(id="saveMethod")
		WebElement saveEdt;
		@FindBy(xpath="html/body/div[9]/div/div[3]/button")
		WebElement AfterSaveEdt;
		@FindBy(linkText="View Invoices")
		WebElement Viewstatus;
		@FindBy(linkText="View Invoice")
		WebElement CheckInvoice;
		@FindBy(xpath="//span[@data-bind='text: soShipment.cFormTax']")
		WebElement ResultEdt;
		public void UpdateAmount(String SaleTax) throws InterruptedException
		{
			WebDriverCommonlib.waitForPageToLoad();
			Actions act = new Actions(Browser.driver);
		String exp=	InvoiceEdt.getAttribute("value");
			ActionEdt.click();
			UpdateInvoice.click();
			CSTTax.clear();
			CSTTax.sendKeys("Yes");
			act.sendKeys(Keys.ARROW_DOWN).perform();
			 act.sendKeys(Keys.ENTER).perform();
			SalesTax.sendKeys(Keys.chord(Keys.CONTROL,"a"),SaleTax);
			 act.sendKeys(Keys.ARROW_DOWN).perform();
			 act.sendKeys(Keys.ENTER).perform();
			String Expected =  SalesTax.getAttribute("value");
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

