package com.Actouch.SalesINVLoc.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
public class UPINVCustID {
   @FindBy(xpath="//input[@aria-controls='SOTable']")
	WebElement SearchEdt;
	@FindBy(xpath="//input[@aria-controls='SHP_Table']")
	WebElement InvoiceEdt;
	@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle']")
	WebElement ActionEdt;
	@FindBy(linkText="Update Invoice")
	WebElement UpdateInvoice;
	@FindBy(id="custName")
	WebElement CustNameEdt;
	@FindBy(id="updShpInv_custId") 
	WebElement CustIDEdt;
	@FindBy(id="btnSave")
	WebElement saveEdt;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement AfterSaveEdt;
	@FindBy(linkText="View Invoices")
	WebElement Viewstatus;
	@FindBy(linkText="View Invoice")
	WebElement CheckInvoice;
	@FindBy(xpath="//label[@data-bind='html:soShipment.custName']")
	WebElement ResultEdt;
	public void UpdateAmount(String CustID) throws InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
		Actions act = new Actions(Browser.driver);
	String exp=	SearchEdt.getAttribute("value");
	Browser.driver.get(Constant.newShpMainINV);
		InvoiceEdt.sendKeys(exp);
		ActionEdt.click();
		UpdateInvoice.click();
		CustIDEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),CustID);
		Thread.sleep(1000);
		 act.sendKeys(Keys.ARROW_DOWN).perform();
		 act.sendKeys(Keys.ENTER).perform();
		String Expected =  CustNameEdt.getAttribute("value");
		saveEdt.click();
		AfterSaveEdt.click();
		Thread.sleep(3000);
		Viewstatus.click();
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
