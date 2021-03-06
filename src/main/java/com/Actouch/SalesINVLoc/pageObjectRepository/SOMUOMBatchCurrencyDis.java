package com.Actouch.SalesINVLoc.pageObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class SOMUOMBatchCurrencyDis {
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
	@FindBy(xpath=".//*[@id='taxCalc']/tbody/tr/td[1]/input[@data-bind ='checked: chkSelectAll ']")
	WebElement roleSelProdEdt;
	@FindBy(xpath=".//*[@id='taxCalc']/tbody/tr/td[13]/input")
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
   public void ProdTaxDis(String CustId,String ProdId,String Batch,String Quantity,String SecUOM,String unitPrice,String Discount) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
   {
	   WebDriverCommonlib.waitForPageToLoad();
	   WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
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
	    for (int i= 1;i<=10;i++)
		   {
			      String batch =  Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[3]/input")).getAttribute("value");
		 if(batch.equals(Batch))
		 {
			 Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[1]/input")).click();
			  Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[13]/input")).sendKeys(Quantity);
			  Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[14]/div/span/input")).sendKeys(SecUOM);
			  act.sendKeys(Keys.ARROW_DOWN).perform();
			  act.sendKeys(Keys.ENTER).perform();
			  break;
		 }
		 }
	  
	   aftrqntOkEdt.click();
	 unitprice_1edt.sendKeys(unitPrice);
	 wait.until(ExpectedConditions.visibilityOf(discTypeLine));
	 act.moveToElement(discTypeLine).click().perform();
	 DiscType2.click();
	 lineDisEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Discount);
	 act.sendKeys(Keys.ENTER).perform();
	  amt = gettingTotalAmount.getText();
	  Thread.sleep(2000);
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
