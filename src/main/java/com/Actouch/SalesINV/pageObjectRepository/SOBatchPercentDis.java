package com.Actouch.SalesINV.pageObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class SOBatchPercentDis {

	public static String amt;
	@FindBy(id ="SoIsoId")
	WebElement SOidEdt;
	@FindBy(id ="createSoCustId")
	WebElement SoCustIdEdt;
	@FindBy(id="prdSo_1")
	WebElement prdSo_1Edt;
	@FindBy(xpath="//span[text()='Product Details']")
	WebElement prDetailsEdt;
	@FindBy(xpath="//span[@data-bind='text: discTypeLine']")
	WebElement discTypeLine;
	@FindBy(xpath="//span[@data-bind='text: $root.SOInventory.discType2']")
	WebElement DiscType2;
	@FindBy(xpath="//input[@data-bind=' value: lineDisc']")
	WebElement lineDisEdt;
	@FindBy(name="roleFor")
	WebElement roleSelProdEdt;
	@FindBy(xpath="//table[@id='taxCalc']/tbody/tr[2]/td[12]/input")
	WebElement qntEdt;
	@FindBy(xpath="//button[contains(text(),'Ok')]")
	WebElement aftrqntOkEdt;
	@FindBy(id="unitprice_1")
	WebElement unitprice_1edt;
	@FindBy(xpath="//label[@data-bind='html: SOInventory.totalAmt']")
    WebElement gettingTotalAmount;
	@FindBy(id ="btnSave")
	WebElement btnSaveEdt;
	@FindBy(xpath="//p[contains(text(),'Sales Order')]")
	WebElement saleConfirmMsgedt;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement ConfirmSaveedt;
    @FindBy(xpath="//input[@aria-controls='SOTable']")
    WebElement searchtxt;
   @FindBy(xpath="//table[@id='SOTable']/tbody/tr/td[2]")
   WebElement actval;
   public void ProdTaxDis(String CustId,String ProdId,String Batch,String Quantity,String unitPrice,String Discount) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
   {
	   WebDriverCommonlib.waitForPageToLoad();
	   Actions act = new Actions(Browser.driver);
	   String exp = SOidEdt.getAttribute("value");
	    Thread.sleep(5000);
	    SoCustIdEdt.sendKeys(CustId);
	   Thread.sleep(1000);
	   	act.sendKeys(Keys.TAB).perform();
	  JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
	   kl.executeScript("window.scrollBy(0,300)", "");
	 prdSo_1Edt.sendKeys(ProdId);
	   Thread.sleep(2000);
     	act.sendKeys(Keys.TAB).perform();
	    prDetailsEdt.click();
	    for (int i= 2;i<=10;i++)
		   {
			      String batch =  Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[3]/input")).getAttribute("value");
		 if(batch.equals(Batch))
		 {
			 Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[1]/input")).click();
			  Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[12]/input")).sendKeys(Quantity);
		 break;
		 }
		 i++;
		 }
	  
	   aftrqntOkEdt.click();
	 unitprice_1edt.sendKeys(unitPrice);
	 lineDisEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Discount);
	  amt = gettingTotalAmount.getText();
	 btnSaveEdt.click();
	   ConfirmSaveedt.click();
	    Browser.driver.get(Constant.SalesMain);
	  Thread.sleep(7000);
	 
	    searchtxt.sendKeys(exp);
	   String act2 = actval.getText();
	    Assert.assertEquals(act2, exp,"product tax discount  after saving case == fail");
  		System.out.println("product tax discount after saving case == pass");
	   
   }
}
