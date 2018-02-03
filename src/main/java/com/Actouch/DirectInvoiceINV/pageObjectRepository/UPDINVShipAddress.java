package com.Actouch.DirectInvoiceINV.pageObjectRepository;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
public class UPDINVShipAddress {
	@FindBy(xpath=".//*[@id='SHP_Table_filter']/label/input")
	WebElement SearchEdt;
			@FindBy(xpath="//input[@aria-controls='SHP_Table']")
			WebElement InvoiceEdt;
			@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle']")
			WebElement ActionEdt;
			@FindBy(linkText="Update Invoice")
			WebElement UpdateInvoice;
			@FindBy(xpath="//textarea[@placeholder='Shipping Address']")
			WebElement ShipAddEdt;
			@FindBy(id="saveMethod")
			WebElement saveEdt;
			@FindBy(xpath="html/body/div[9]/div/div[3]/button")
			WebElement AfterSaveEdt;
			@FindBy(linkText="View Invoices")
			WebElement Viewstatus;
			@FindBy(linkText="View Invoice")
			WebElement CheckInvoice;
			@FindBy(xpath="//label[@data-bind='html:soShipment.shpAddress']")
			WebElement ResultEdt;
			public void UpdateAmount(String ShipAddress) throws InterruptedException
			{
				WebDriverCommonlib.waitForPageToLoad();
				Actions act = new Actions(Browser.driver);
			String exp=	SearchEdt.getAttribute("value");
			   ActionEdt.click();
				UpdateInvoice.click();
				ShipAddEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),ShipAddress);
				 act.sendKeys(Keys.ENTER).perform();
				String Expected =  ShipAddEdt.getAttribute("value");
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
