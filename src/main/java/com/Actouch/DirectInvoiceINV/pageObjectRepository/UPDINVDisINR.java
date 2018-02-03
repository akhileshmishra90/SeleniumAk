package com.Actouch.DirectInvoiceINV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;

import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class UPDINVDisINR {

	 @FindBy(xpath="//input[@aria-controls='SOTable']")
		WebElement SearchEdt;
		@FindBy(xpath="//input[@aria-controls='SHP_Table']")
		WebElement InvoiceEdt;
		@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle']")
		WebElement ActionEdt;
		@FindBy(linkText="Update Invoice")
		WebElement UpdateInvoice;
		@FindBy(xpath="//span[@data-bind='text: updateDIInventory.discType']")
		WebElement DisType;
		@FindBy(xpath="//span[@data-bind='text: updateDIInventory.discType2']")
		WebElement INR;
		@FindBy(id="overAllDisc")
		WebElement AllDiscEdt;
		@FindBy(id="saveMethod")
		WebElement saveEdt;
		@FindBy(xpath="html/body/div[9]/div/div[3]/button")
		WebElement AfterSaveEdt;
		@FindBy(linkText="View Invoices")
		WebElement Viewstatus;
		@FindBy(linkText="View Invoice")
		WebElement CheckInvoice;
		@FindBy(xpath="//label[@data-bind='html: soShipment.overAllDiscAmt']")
		WebElement ResultEdt;
		public void UpdateAmount(String AllDisc) throws InterruptedException
		{
			WebDriverCommonlib.waitForPageToLoad();
			Actions act = new Actions(Browser.driver);
		String exp=	InvoiceEdt.getAttribute("value");
			ActionEdt.click();
			UpdateInvoice.click();
			DisType.click();
			INR.click();
			AllDiscEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),AllDisc);
			 act.sendKeys(Keys.ENTER).perform();
			String Expected =  AllDiscEdt.getAttribute("value");
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
