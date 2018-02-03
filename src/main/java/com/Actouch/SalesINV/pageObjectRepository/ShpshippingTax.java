package com.Actouch.SalesINV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;

public class ShpshippingTax {
	public static String amt;
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
@FindBy(id="shpCharges")
WebElement givSshipcharge;
@FindBy(id ="shpTax-select")
WebElement enableShpTax;
@FindBy(id="SOShipTax-select")
WebElement shippingTax;
@FindBy(xpath="//table[@id='SOTable']/tbody/tr/td[5]")
WebElement CustId;
@FindBy(xpath="//label[@data-bind='html: soShipment.totalAmt']")
WebElement TotalEdt;
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

public void ShipTax(String shipcharge,String ShippingTax ) throws InterruptedException
{
String exp=searchtxt.getAttribute("value"); 
String Cust= CustId.getText();
Browser.driver.get(Constant.shpMain);
CustIdShpedt.sendKeys(Cust);
Actions act = new Actions(Browser.driver);
act.sendKeys(Keys.TAB).perform();
Thread.sleep(2000);
SearchforSo.sendKeys(exp);
chooseSoId.click();
String Excepted = InvoiceId.getAttribute("value");
Thread.sleep(2000);
selecProd.click();
String Qty = RemainQnty.getText();
productDetail.click();
issueQnty.sendKeys(Qty);
aftrsavingQnty.click();
givSshipcharge.sendKeys(shipcharge);
enableShpTax.clear();
enableShpTax.sendKeys("Yes");
act.sendKeys(Keys.ARROW_DOWN).perform();
act.sendKeys(Keys.ENTER).perform();
shippingTax.sendKeys(ShippingTax);
act.sendKeys(Keys.ARROW_DOWN).perform();
act.sendKeys(Keys.ENTER).perform();
amt=TotalEdt.getText();
shipsaving.click();
aftSavingShp.click();
Thread.sleep(4000);
viewInvoice.click();
Thread.sleep(4000);
InvSearch.sendKeys(Excepted);
String actual = Result.getText() ;
Assert.assertEquals(actual, Excepted, "ShpshippingTax ==fail");
System.out.println("ShpshippingTax ==pass");
}

}
