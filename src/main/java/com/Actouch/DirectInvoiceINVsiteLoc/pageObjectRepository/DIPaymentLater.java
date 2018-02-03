package com.Actouch.DirectInvoiceINVsiteLoc.pageObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.Actouch.Pages.DirectInvoiceCreation;
import com.Actouch.Pages.InvoiceDashbord;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class DIPaymentLater {
	public static String amt;
	public void payltr(String Site,String Customer_Id,String Product_Id,String Quantity,String unit_price) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	   {
		DirectInvoiceCreation DIC = new DirectInvoiceCreation(Browser.driver);
		InvoiceDashbord IDB = new InvoiceDashbord(Browser.driver);
		   WebDriverCommonlib.waitForPageToLoad();
		   Actions act = new Actions(Browser.driver);
		   DIC.SiteEdt(Site);
		   act.sendKeys(Keys.TAB).perform();
		    String exp = DIC.SOidEdt();
		    Thread.sleep(3000);
		   DIC.DSOCustEdt(Customer_Id);
		 Thread.sleep(1000);
		  act.sendKeys(Keys.TAB).perform();
		   JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
		   kl.executeScript("window.scrollBy(0,300)", "");
		   DIC.PrDSO(Product_Id);
		  Thread.sleep(2000);
	     	act.sendKeys(Keys.TAB).perform();
	     	DIC.peDetailsEdt();
		    DIC.roleSelProdEdt();
		    DIC.ModelQnty(Quantity);
		    DIC.SaveProdModel();
		   Thread.sleep(1000);
		   DIC.UnitPrice(unit_price);
		  act.sendKeys(Keys.ENTER).perform();
		   amt = DIC.TotalEdt();
		   DIC.SaveEdt();
		   DIC.AfterSaveEdt();
		  Browser.driver.get(Constant.newShpMain);
		  Thread.sleep(7000);
		  IDB.SiteEdt(Site);
		  act.sendKeys(Keys.TAB).perform();
		  IDB.Searchext(exp);
		   String act2 = IDB.ResultEdt();
		    Assert.assertEquals(act2, exp,"payment later after saving case == fail");
	  		System.out.println("payment later after saving case == pass");
		    }
	}


