package com.Actouch.DirectInvoiceINV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class UPDINVTermCond {
			@FindBy(xpath="//input[@aria-controls='SHP_Table']")
			WebElement InvoiceEdt;
			@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle']")
			WebElement ActionEdt;
			@FindBy(linkText="Update Invoice")
			WebElement UpdateInvoice;
			@FindBy(xpath="//div[@data-bind='click: updateDIInventory.showTermsConditionModal']")
			WebElement TermModel;
			@FindBy(xpath="//textarea[@placeholder='Terms and Conditions']")
			WebElement TermEdt;
			@FindBy(xpath="//button[@data-bind='click: ok']")
		    WebElement AfterTerm;
			@FindBy(id="saveMethod")
			WebElement saveEdt;
			@FindBy(xpath="html/body/div[9]/div/div[3]/button")
			WebElement AfterSaveEdt;
			@FindBy(linkText="View Invoices")
			WebElement Viewstatus;
			@FindBy(linkText="View Invoice")
			WebElement CheckInvoice;
			@FindBy(xpath="//div[@data-bind='click: soShipment.showTermsConditionModal']")
			WebElement openModel;
			@FindBy(xpath="//textarea[@placeholder='Terms and Conditions']")
			WebElement ResultEdt;
			public void UpdateAmount(String RoundOff) throws InterruptedException
			{
				WebDriverCommonlib.waitForPageToLoad();
				Actions act = new Actions(Browser.driver);
			String exp=	InvoiceEdt.getAttribute("value");
				ActionEdt.click();
				UpdateInvoice.click();
				TermModel.click();
				TermEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),RoundOff);
				 act.sendKeys(Keys.ENTER).perform();
				String Expected =  TermEdt.getAttribute("value");
				AfterTerm.click();
				saveEdt.click();
				AfterSaveEdt.click();
				Thread.sleep(3000);
				InvoiceEdt.sendKeys(exp);
				ActionEdt.click();
				CheckInvoice.click();
				Thread.sleep(3000);
				openModel.click();
				String Actual = ResultEdt.getAttribute("value");
				Assert.assertEquals(Actual, Expected,"Customer update wrong");
				System.out.println("Customer Upadate As Usual");
				
			}

}
