package com.Actouch.SalesINV.pageObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class ShpMultiProduct {
	 @FindBy(xpath="//input[@aria-controls='SOTable']")
	    WebElement searchtxt;
	@FindBy(id="invoiceId")
	WebElement InvoiceId;
	@FindBy(id="custIdForShp")
	WebElement CustIdShpedt;
	@FindBy(xpath="//div[@id='SOTable_filter']/label/input")
	WebElement SearchforSo;
	@FindBy(xpath="//table[@id='SOTable']/tbody/tr/td[2]/a")
	WebElement chooseSoId;
	@FindBy(xpath="//table[@id='PODetailsTable']/tbody/tr/td[1]/input")
	WebElement selecProd;
 @FindBy(xpath="//table[@id='PODetailsTable']/tbody/tr/td[7]/label")
	WebElement RemainQnty;
 @FindBy(xpath="//span[contains(text(),'Product')]")
 WebElement productDetail;
 @FindBy(xpath="//table[@id='taxCalc']/tbody/tr/td[12]/input")
 WebElement issueQnty;
 @FindBy(xpath="//button[contains(text(),'Ok')]")
 WebElement aftrsavingQnty;
 @FindBy(xpath="//input[@class='form-control createPO-suppId ui-autocomplete-input']")
 WebElement uomEdt;
 @FindBy(xpath="//table[@id='SOTable']/tbody/tr/td[5]")
 WebElement CustId;
 @FindBy(id="btnSave")
 WebElement shipsaving;
 @FindBy(xpath="html/body/div[9]/div/div[3]/button")
 WebElement aftSavingShp;
 @FindBy(xpath="//div[@id='crsobtn']/a")
 WebElement viewInvoice;
 @FindBy(xpath="//div[@id='SHP_Table_filter']/label/input")
 WebElement InvSearch;
 @FindBy(xpath=".//*[@id='SHP_Table']/tbody/tr/td[3]")
 WebElement Result;
 @FindBy(xpath="//table[@id='PODetailsTable']/tbody/tr/td[12]/span[contains(text(),'Tax Details')]")
 WebElement taxModel;

 public void fullShipment() throws InterruptedException
 {
 	WebDriverCommonlib.waitForPageToLoad();
 	Thread.sleep(4000);
 	searchtxt.sendKeys("");
 	String exp=searchtxt.getAttribute("value"); 
 	String Cust= CustId.getText();
 	 Browser.driver.get(Constant.shpMain);
 CustIdShpedt.sendKeys(Cust);
 	Actions act = new Actions(Browser.driver);
 	act.sendKeys(Keys.TAB).perform();
 	Thread.sleep(2000);
    SearchforSo.sendKeys(exp);
 	chooseSoId.click();
 	//String Excepted = InvoiceId.getAttribute("value");
 	Thread.sleep(2000);
 	List<WebElement> els = Browser.driver.findElements( By.xpath("//input[@data-bind ='checked: chkSelectAll']"));
 	for ( WebElement el : els ) {
 	    if ( !el.isSelected() ) {
 	    	Thread.sleep(1000);
 	    	el.click();
 	     // Thread.sleep(2000);
 	     String Qty = RemainQnty.getText();
 	     System.out.println(Qty);
 	     taxModel.click();
 	     
 	    Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
 		}
 	}
 	
 	
 	 /*List<WebElement> els = Browser.driver.findElements( By.id("taxId"));
 	int i = els.size();
 	System.out.println(i);
 	for ( WebElement el : els ) {
 	    String TA =el.getText();

 	 System.out.println(TA);    }
 	
	String Qty = RemainQnty.getText();
 	productDetail.click();
 	issueQnty.sendKeys(Qty);
 	aftrsavingQnty.click();
 	shipsaving.click();
 	aftSavingShp.click();
 	Thread.sleep(4000);
 	viewInvoice.click();
 	Thread.sleep(4000);
	InvSearch.sendKeys(Excepted);
String actual = Result.getText() ;
Assert.assertEquals(actual, Excepted, "full shipment ==fail");
	 System.out.println("full shipment ==pass");
 	*/
 	
  }
}



