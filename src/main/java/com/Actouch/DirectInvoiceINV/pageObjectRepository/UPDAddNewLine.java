package com.Actouch.DirectInvoiceINV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class UPDAddNewLine {

	 @FindBy(xpath="//input[@aria-controls='SHP_Table']")
		WebElement InvoiceEdt;
		@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle']")
		WebElement ActionEdt;
		@FindBy(linkText="Update Invoice")
		WebElement UpdateInvoice;
		@FindBy(xpath=".//*[@id='creso']/div")
		WebElement AddlineEdt;
		@FindBy(id="prdSoDUI_2")
		WebElement prodID2Edt;
		@FindBy(xpath="//table[@id='SODetailsTable']/tbody/tr[2]/td[5]/div/div/div[3]/span[contains(text(),'Product')]")
		WebElement Prodmodel2Edt;
		@FindBy(xpath="//input[@data-bind='checked: chkSelectAll ']")
		WebElement checkProdEdt;
		@FindBy(xpath="//input[@data-bind='value: soldQty,enable: chkRjct']")
		WebElement EnterQty;
		@FindBy(xpath="//button[@data-bind='click: ok']") 
		WebElement OKEdt;
		@FindBy(id="unitprice_2")
		WebElement UnitpriceEdt;
		@FindBy(id="saveMethod")
		WebElement saveEdt;
		@FindBy(xpath="html/body/div[9]/div/div[3]/button")
		WebElement AfterSaveEdt;
		@FindBy(linkText="View Invoices")
		WebElement Viewstatus;
		@FindBy(linkText="View Invoice")
		WebElement CheckInvoice;
		@FindBy(xpath=".//*[@id='PODetailsTable']/tbody/tr[2]/td[2]/label")
		WebElement ResultEdt;
		public void UpdateAmount(String ProdID2,String Qnty,String Unitprice) throws InterruptedException
		{
			WebDriverCommonlib.waitForPageToLoad();
			Actions act = new Actions(Browser.driver);
		String exp=	InvoiceEdt.getAttribute("value");
			ActionEdt.click();
			UpdateInvoice.click();
			Thread.sleep(10000);
			AddlineEdt.click();
			Thread.sleep(3000);
			prodID2Edt.sendKeys(Keys.chord(Keys.CONTROL,"a"),ProdID2);
			act.sendKeys(Keys.ARROW_DOWN).perform();
			 act.sendKeys(Keys.ENTER).perform();
			 Prodmodel2Edt.click();
			 checkProdEdt.click();
			 EnterQty.sendKeys(Qnty);
			 OKEdt.click();
			 UnitpriceEdt.sendKeys(Unitprice);
			String Expected =  prodID2Edt.getAttribute("value");
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



