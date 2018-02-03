package com.Actouch.SalesSRV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class DLVPartial {
	public static String amt;
	@FindBy(xpath = "//input[@aria-controls='SOTable']")
	WebElement Searchtxt;
	@FindBy(xpath = "//table[@id='SOTable']/tbody/tr/td[5]")
	WebElement CustId;
	@FindBy(id = "custIdForShp")
	WebElement CustDlvEdt;
@FindBy(xpath="//div[@id='SOTable_filter']/label/input")
WebElement SearchorServ;
@FindBy(xpath="//table[@id='SOTable']/tbody/tr[1]/td[2]/a")
WebElement ChooseSOid;
@FindBy(xpath="//table[@id='PODetailsTable']/tbody/tr/td[6]/label")
WebElement RemainQnty;
@FindBy(id="invoiceId")
WebElement InvoiceEdt;
@FindBy(xpath="//table[@id='PODetailsTable']/tbody/tr/td[1]/input")
WebElement selectServ;
@FindBy(id="soldQty_1")
WebElement SoldQnty;
@FindBy(xpath="//label[@data-bind ='html: soShipment.totalAmt']")
WebElement TotalAmt;
@FindBy(id="btnSave")
WebElement SaveEdt;
@FindBy(xpath="html/body/div[9]/div/div[3]/button")
WebElement aftSavingShp;
@FindBy(xpath="//div[@id='crsobtn']/a")
WebElement viewInvoice;
@FindBy(xpath="//div[@id='SHP_Table_filter']/label/input")
WebElement InvSearch;
@FindBy(xpath=".//*[@id='SHP_Table']/tbody/tr/td[3]")
WebElement Result;

public void PartialServ(String Remain) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	Actions act=new Actions(Browser.driver);
	String exp = Searchtxt.getAttribute("value");
	String Cust = CustId.getText();
	Browser.driver.get(Constant.shpMain);
	Thread.sleep(1000);
	CustDlvEdt.sendKeys(Cust);
	act.sendKeys(Keys.ARROW_DOWN).perform();
	act.sendKeys(Keys.ENTER).perform();
	Thread.sleep(2000);
	SearchorServ.sendKeys(exp);
	ChooseSOid.click();
	 String Expected=InvoiceEdt.getAttribute("value");
	Thread.sleep(2000);
	selectServ.click();
	SoldQnty.sendKeys(Remain);
	act.sendKeys(Keys.ENTER).perform();
	amt = TotalAmt.getText();
	SaveEdt.click();
	aftSavingShp.click();
	Thread.sleep(4000);
	viewInvoice.click();
	Thread.sleep(4000);
	InvSearch.sendKeys(Expected);
	
String actual = Result.getText() ;

 Assert.assertEquals(actual, Expected, "full shipment ==fail");
 System.out.println("full shipment ==pass");
	 
	

}

}
