package com.Actouch.PurchaseINV.pageObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;

public class PO_WithoutDiscount {
	public static String amt;
	@FindBy(id ="poId")
	WebElement poIdEdt;
	@FindBy(id ="prdId_createpo")
	WebElement poSuppIdEdt;
	@FindBy(id="prdPo_1")
	WebElement prdPo_1Edt;
	@FindBy(id="purQty_1")
	WebElement pqtyEdt;
	@FindBy(xpath="//button[contains(.,'save')]")
	WebElement aftrqntSaveEdt;
	@FindBy(id="unitprice")
	WebElement unitpriceEdt;	
	@FindBy(id="payType")
    WebElement payTypeEdt;
	@FindBy(xpath="//a[text()='Later']")
	WebElement payLaterEdt;
	@FindBy(xpath="//label[@data-bind='html: POInventory.netAmt']")
    WebElement getTotalAmount;
	@FindBy(id ="btnSave")
	WebElement btnSaveEdt;
	@FindBy(xpath="//p[contains(text(),'Purchase Order')]")
	WebElement saleConfirmMsgedt;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement ConfirmSaveedt;
    @FindBy(xpath="//input[@aria-controls='POTable']")
    WebElement searchtxt;
   @FindBy(xpath="//table[@id='POTable']/tbody/tr/td[2]")
   WebElement actval;
   
   public void withoutDiscount(String Supp_Id,String Product_Id,String Quantity,String unit_price) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
   {
	   WebDriverCommonlib.waitForPageToLoad();
	   Actions act = new Actions(Browser.driver);
 String exp = poIdEdt.getAttribute("value");
 Thread.sleep(3000);
	    poSuppIdEdt.sendKeys(Supp_Id);
	    Thread.sleep(1000);
	    act.sendKeys(Keys.TAB).perform();
 JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
	   kl.executeScript("window.scrollBy(0,300)", "");
Thread.sleep(1000);
	   prdPo_1Edt.sendKeys(Product_Id);
	   act.sendKeys(Keys.TAB).perform();
       pqtyEdt.sendKeys(Quantity);
	   unitpriceEdt.sendKeys(unit_price);
	   act.sendKeys(Keys.ENTER).perform();
	   amt = getTotalAmount.getText();
	  btnSaveEdt.click();
	   ConfirmSaveedt.click();
	    Browser.driver.get(Constant.PurchaseMain);
	  Thread.sleep(7000);	 
	    searchtxt.sendKeys(exp);
	   String act2 = actval.getText();
	    Assert.assertEquals(act2, exp,"without Discount after saving case == fail");
  		System.out.println("without Discount after saving case == pass");
	   
   }
	

}
