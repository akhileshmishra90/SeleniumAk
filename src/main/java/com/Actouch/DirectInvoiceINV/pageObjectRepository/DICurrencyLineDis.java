package com.Actouch.DirectInvoiceINV.pageObjectRepository;

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

public class DICurrencyLineDis {

	public static String amt;
	   @FindBy(id="SoIsoId")	
	   WebElement SOidEdt;
	   @FindBy(id="createDinvCustId")
	   WebElement DSOCustEdt;
	   @FindBy(id="prdSo_1")
	   WebElement PrDSO;
	   @FindBy(xpath="//div[@data-bind='if:chkLoc']/span[@class='label label-warning']")
	   WebElement peDetailsEdt;
	   @FindBy(name="roleFor")
	   WebElement roleSelProdEdt;
	   @FindBy(xpath="//table[@id='taxCalc']/tbody/tr[2]/td[12]/input")
	   WebElement Qnty;
	   @FindBy(xpath="//button[@data-bind='click: ok']")
	   WebElement SaveProdModel;
	   @FindBy(id="unitprice_1")
	   WebElement UnitPrice;
	   @FindBy(xpath="//span[@data-bind='text: discTypeLine']")
	   WebElement DiscTypeLine;
	   @FindBy(xpath="//span[@data-bind='text: $root.DIInventory.discType2']")
	   WebElement DiscType2;
	   @FindBy(xpath="//input[@data-bind=' value: lineDisc']")
	   WebElement LineDisEdt;
	   @FindBy(xpath="//label[@data-bind='html: DIInventory.totalAmt']")
	   WebElement TotalEdt;
	   @FindBy(id="btnSave")
	   WebElement SaveEdt;
	   @FindBy(xpath="html/body/div[9]/div/div[3]/button")
	   WebElement AfterSaveEdt;
	   @FindBy(xpath="//input[@aria-controls='SHP_Table']")
	  WebElement Searchext;
	   @FindBy(xpath="//table[@id='SHP_Table']/tbody/tr[1]/td[3]")
	   WebElement ResultEdt;
	   public void payltr(String Customer_Id,String Product_Id,String Quantity,String unit_price,String LineDis) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	   {
		   WebDriverCommonlib.waitForPageToLoad();
		   WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
		   Actions act = new Actions(Browser.driver);
		    String exp = SOidEdt.getAttribute("value");
		    Thread.sleep(3000);
		    DSOCustEdt.sendKeys(Customer_Id);
		 Thread.sleep(1000);
		  act.sendKeys(Keys.TAB).perform();
		   JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
		   kl.executeScript("window.scrollBy(0,300)", "");
		   PrDSO.sendKeys(Product_Id);
		  Thread.sleep(2000);
	     	act.sendKeys(Keys.TAB).perform();
	     	peDetailsEdt.click();
		    roleSelProdEdt.click();
		    Qnty.sendKeys(Quantity);
		    SaveProdModel.click();
		   Thread.sleep(1000);
		   UnitPrice.sendKeys(unit_price);
		  wait.until(ExpectedConditions.visibilityOf(DiscTypeLine));
		  act.moveToElement(DiscTypeLine).click().perform();
		  wait.until(ExpectedConditions.visibilityOf(DiscType2));
		  act.moveToElement(DiscType2).click().perform();
		   LineDisEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),LineDis);
		  act.sendKeys(Keys.ENTER).perform();
		   amt = TotalEdt.getText();
		   SaveEdt.click();
		   AfterSaveEdt.click();
		  Browser.driver.get(Constant.newShpMain);
		  Thread.sleep(7000);
		  Searchext.sendKeys(exp);
		   String act2 = ResultEdt.getText();
		    Assert.assertEquals(act2, exp,"payment later after saving case == fail");
	  		System.out.println("payment later after saving case == pass");
		    }

}
