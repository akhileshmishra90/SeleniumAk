package com.Actouch.SalesSRV.pageObjectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
public class DLVFullTax {
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
@FindBy(id="invoiceId")
WebElement InvoiceEdt;
@FindBy(xpath="//table[@id='PODetailsTable']/tbody/tr/td[1]/input")
WebElement selectServ;
@FindBy(id="recAll_1")
WebElement Receiveall;
@FindBy(xpath="//table[@id='PODetailsTable']/tbody/tr/td[11]/span[contains(text(),'Tax Details')]")
WebElement taxModel;
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

public void FullServ(String Newtaxcode) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	Actions act=new Actions(Browser.driver);
	String exp = Searchtxt.getAttribute("value");
	Thread.sleep(1000);
	String Cust = CustId.getText();
	Browser.driver.get(Constant.shpMain);
	CustDlvEdt.sendKeys(Cust);
	act.sendKeys(Keys.ARROW_DOWN).perform();
	act.sendKeys(Keys.ENTER).perform();
	Thread.sleep(2000);
	SearchorServ.sendKeys(exp);
	ChooseSOid.click();
	
	String Expected=InvoiceEdt.getAttribute("value");
	Thread.sleep(2000);
	selectServ.click();
	Receiveall.click();
	taxModel.click();
    for(int i=1;i<10;i++)
	  {
	String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
		  if(count1.equals(Newtaxcode)){
			Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
			Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
		  
		  	break;
		  	
		  }
	  }
    act.sendKeys(Keys.ENTER).perform();
    amt=TotalAmt.getText();
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
