package com.Actouch.DirectInvoiceINV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class UPDINVProduct {
         @FindBy(xpath="//input[@aria-controls='SHP_Table']")
			WebElement InvoiceEdt;
			@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle']")
			WebElement ActionEdt;
			@FindBy(linkText="Update Invoice")
			WebElement UpdateInvoice;
			@FindBy(id="prdSoDUI_1")
			WebElement ProdIDEdt;
			@FindBy(xpath="//span[contains(text(),'Product')]")
			WebElement ProductModel;
			@FindBy(xpath="//input[@data-bind='checked: chkSelectAll ']")
			WebElement CheckProd;
			@FindBy(xpath="//input[@data-bind='value: soldQty,enable: chkRjct']")
			WebElement EnterQtyEdt;
			@FindBy(xpath="//button[@data-bind='click: ok']")
			WebElement OKmodel;
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
			@FindBy(xpath="//label[@data-bind='text: prdId']")
			WebElement ResultEdt;
			public void UpdateAmount(String ProdID,String EnterQty,String unitprice) throws InterruptedException
			{
				WebDriverCommonlib.waitForPageToLoad();
				Actions act = new Actions(Browser.driver);
			String exp=	InvoiceEdt.getAttribute("value");
				ActionEdt.click();
				UpdateInvoice.click();
				ProdIDEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),ProdID);
				 act.sendKeys(Keys.ARROW_DOWN).perform();
				 act.sendKeys(Keys.ENTER).perform();
				String Expected =  ProdIDEdt.getAttribute("value");
				ProductModel.click();
				CheckProd.click();
				EnterQtyEdt.sendKeys(EnterQty);
				OKmodel.click();
				unitpriceEdt.sendKeys(unitprice);
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
