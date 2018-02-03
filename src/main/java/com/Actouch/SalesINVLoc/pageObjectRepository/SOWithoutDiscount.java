package com.Actouch.SalesINVLoc.pageObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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

public class SOWithoutDiscount {
	//without Discount
	public static String amt;
	@FindBy(id ="SoIsoId")
	WebElement SOidEdt;
	@FindBy(id ="createSoCustId")
	WebElement SoCustIdEdt;
	@FindBy(id="prdSo_1")
	WebElement prdSo_1Edt;
	@FindBy(xpath="//span[text()='Product Details']")
	WebElement prDetailsEdt;
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
   public void withoutDiscount(String Customer_Id,String Product_Id,String Quantity,String unit_price) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
   {
	WebDriverCommonlib.waitForPageToLoad();
	WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
	 Actions act = new Actions(Browser.driver);
	 String exp = SOidEdt.getAttribute("value");
	 wait.until(ExpectedConditions.visibilityOf(SoCustIdEdt));
	 Thread.sleep(3000);  
	 SoCustIdEdt.sendKeys(Customer_Id);
	   Thread.sleep(1000);
	  act.sendKeys(Keys.TAB).perform();
	    JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
	   kl.executeScript("window.scrollBy(0,300)", "");
	 prdSo_1Edt.sendKeys(Product_Id);
	   Thread.sleep(1000);
	   act.sendKeys(Keys.TAB).perform();
	    prDetailsEdt.click();
	    roleSelProdEdt.click();
	    qntEdt.sendKeys(Quantity);
	   aftrqntOkEdt.click();
	 unitprice_1edt.sendKeys(unit_price);
	  act.sendKeys(Keys.ENTER).perform();
	 amt = gettingTotalAmount.getText();
		 btnSaveEdt.click();
	   ConfirmSaveedt.click();
	    Browser.driver.get(Constant.SalesMain);
	  Thread.sleep(7000);
	   searchtxt.sendKeys(exp);
	   String act2 = actval.getText();
	    Assert.assertEquals(act2, exp,"without Discount after saving case == fail");
  		System.out.println("without Discount after saving case == pass");
	 
   }
	}
