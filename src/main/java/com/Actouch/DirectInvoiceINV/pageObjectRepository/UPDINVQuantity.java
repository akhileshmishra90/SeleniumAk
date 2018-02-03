package com.Actouch.DirectInvoiceINV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
public class UPDINVQuantity {
	@FindBy(xpath=".//*[@id='SHP_Table_filter']/label/input")
	WebElement SearchEdt;
		@FindBy(xpath="//input[@aria-controls='SHP_Table']")
		WebElement InvoiceEdt;
		@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle']")
		WebElement ActionEdt;
		@FindBy(linkText="Update Invoice")
		WebElement UpdateInvoice;
		@FindBy(xpath="//div[@data-bind='if:chkLoc() || $root.updateDIInventory.fromDc()']/span[@class='label label-success']")
		WebElement prodDetail;
		@FindBy(xpath="//input[@data-bind='value: soldQty,enable: chkRjct']")
		WebElement QuantityEdt;
		@FindBy(xpath="//button[@data-bind='click: ok']")
		WebElement OkEdt;
		@FindBy(xpath="//input[@data-bind='value: sellQty,enable:editQty']")
		WebElement getQty;
		@FindBy(id="saveMethod")
		WebElement saveEdt;
		@FindBy(xpath="html/body/div[9]/div/div[3]/button")
		WebElement AfterSaveEdt;
		@FindBy(linkText="View Invoices")
		WebElement Viewstatus;
		@FindBy(linkText="View Invoice")
		WebElement CheckInvoice;
		@FindBy(xpath="//label[@data-bind='text: soldQty']")
		WebElement ResultEdt;
		public void UpdateAmount(String Quantity) throws InterruptedException
		{
			WebDriverCommonlib.waitForPageToLoad();
			Actions act = new Actions(Browser.driver);
		String exp=	SearchEdt.getAttribute("value");
			ActionEdt.click();
			UpdateInvoice.click();
			Thread.sleep(4000);
			prodDetail.click();
			QuantityEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Quantity);
			 act.sendKeys(Keys.ENTER).perform();
			 OkEdt.click();
			String Expected =  getQty.getAttribute("value");
			saveEdt.click();
			AfterSaveEdt.click();
			Thread.sleep(3000);
			InvoiceEdt.sendKeys(exp);
			ActionEdt.click();
			CheckInvoice.click();
			Thread.sleep(3000);
			String Actual = ResultEdt.getText();
			System.out.println(Actual);
			Assert.assertEquals(Actual, Expected,"Customer update wrong");
			System.out.println("Customer Upadate As Usual");
			
		}

}
