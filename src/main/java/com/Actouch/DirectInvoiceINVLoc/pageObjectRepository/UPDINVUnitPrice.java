package com.Actouch.DirectInvoiceINVLoc.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class UPDINVUnitPrice {

	  @FindBy(xpath="//input[@aria-controls='SHP_Table']")
			WebElement InvoiceEdt;
			@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle']")
			WebElement ActionEdt;
			@FindBy(linkText="Update Invoice")
			WebElement UpdateInvoice;
			@FindBy(id="unitprice_1")
			WebElement unitpriceEdt;
			@FindBy(id="saveMethod")
			WebElement saveEdt;
			@FindBy(xpath="html/body/div[9]/div/div[3]/button")
			WebElement AfterSaveEdt;
			@FindBy(linkText="View Invoices")
			WebElement Viewstatus;
			@FindBy(linkText="View Invoice")
			WebElement CheckInvoice;
			@FindBy(xpath="//input[@data-bind='value: unitprice']")
			WebElement ResultEdt;
			public void UpdateAmount(String unitprice) throws InterruptedException
			{
				WebDriverCommonlib.waitForPageToLoad();
				Actions act = new Actions(Browser.driver);
			String exp=	InvoiceEdt.getAttribute("value");
				ActionEdt.click();
				UpdateInvoice.click();
				unitpriceEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),unitprice);
				 act.sendKeys(Keys.ENTER).perform();
				String Expected =  unitpriceEdt.getAttribute("value");
				saveEdt.click();
				AfterSaveEdt.click();
				Thread.sleep(3000);
				InvoiceEdt.sendKeys(exp);
				ActionEdt.click();
				CheckInvoice.click();
				Thread.sleep(3000);
				String Actual = ResultEdt.getAttribute("value");
				Assert.assertEquals(Actual, Expected,"Customer update wrong");
				System.out.println("Customer Upadate As Usual");
				
			}

}
