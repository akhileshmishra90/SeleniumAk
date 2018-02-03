package com.Actouch.SalesINV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class UPINVMemo {
   @FindBy(xpath="//input[@aria-controls='SOTable']")
	WebElement SearchEdt;
	@FindBy(xpath="//input[@aria-controls='SHP_Table']")
	WebElement InvoiceEdt;
	@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle']")
	WebElement ActionEdt;
	@FindBy(linkText="Update Invoice")
	WebElement UpdateInvoice;
	@FindBy(id="memo")
	WebElement MemoEdt;
	@FindBy(id="btnSave")
	WebElement saveEdt;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement AfterSaveEdt;
	@FindBy(linkText="View Invoices")
	WebElement Viewstatus;
	@FindBy(linkText="View Invoice")
	WebElement CheckInvoice;
	@FindBy(xpath="//label[@data-toggle='tooltip']")
	WebElement ResultEdt;
	public void UpdateAmount(String Memo) throws InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
		Actions act = new Actions(Browser.driver);
	String exp=	SearchEdt.getAttribute("value");
	Browser.driver.get(Constant.newShpMainINV);
		InvoiceEdt.sendKeys(exp);
		ActionEdt.click();
		UpdateInvoice.click();
		MemoEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Memo);
		 act.sendKeys(Keys.ENTER).perform();
		String Expected =  MemoEdt.getAttribute("value");
		saveEdt.click();
		AfterSaveEdt.click();
		Thread.sleep(3000);
		Viewstatus.click();
		InvoiceEdt.sendKeys(exp);
		ActionEdt.click();
		CheckInvoice.click();
		Thread.sleep(3000);
		String Actual = ResultEdt.getText();
		Assert.assertEquals(Actual, Expected,"Customer update wrong");
		System.out.println("Customer Upadate As Usual");
		
	}

}
