package com.Actouch.DirectInvoiceINVLoc.pageObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class DITermCondition {

	public static String amt;
	   @FindBy(id="SoIsoId")	
	   WebElement SOidEdt;
	   @FindBy(id="createDinvCustId")
	   WebElement DSOCustEdt;
	   @FindBy(id="prdSo_1")
	   WebElement PrDSO;
	   @FindBy(xpath="//div[@data-bind='if:chkLoc']/span[@class='label label-warning']")
	   WebElement peDetailsEdt;
	   @FindBy(xpath=".//*[@id='taxCalc']/tbody/tr[1]/td[1]/input")
	   WebElement roleSelProdEdt;
	  @FindBy(xpath=".//*[@id='taxCalc']/tbody/tr[1]/td[13]/input")
	   WebElement Qnty;
	   @FindBy(xpath="//button[@data-bind='click: ok']")
	   WebElement SaveProdModel;
	   @FindBy(id="unitprice_1")
	   WebElement UnitPrice;
	   @FindBy(xpath="//div[@data-bind='click: DIInventory.showTermsConditionModal']")
	   WebElement enTermEdt;
	   @FindBy(xpath="//textarea[@placeholder='Terms and Conditions']")
	   WebElement TermEdt;
	   @FindBy(xpath="//button[@data-bind='click: ok']")
	   WebElement SaveTCEdt;
	   @FindBy(xpath="//label[@data-bind='html: DIInventory.totalAmt']")
	   WebElement TotalEdt;
	   @FindBy(id="btnSave")
	   WebElement SaveEdt;
	   @FindBy(xpath="html/body/div[9]/div/div[3]/button")
	   WebElement AfterSaveEdt;
	   @FindBy(xpath="//input[@aria-controls='SHP_Table']")
	  WebElement Searchext;
	   @FindBy(xpath="//table[@id='SHP_Table']/tbody/tr[1]/td[4]")
	   WebElement ResultEdt;
	   public void payltr(String Customer_Id,String Product_Id,String Quantity,String unit_price,String Term ) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	   {
		   WebDriverCommonlib.waitForPageToLoad();
		   int kh = 1583;
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
		   enTermEdt.click();
		   TermEdt.sendKeys(Term);
		   String Tm= TermEdt.getAttribute("value");
		   int TMl= Tm.length();
		   Assert.assertTrue(kh >= TMl, "TC length is more than 1583");
		   SaveTCEdt.click();
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
