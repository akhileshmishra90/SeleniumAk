package com.Actouch.SalesINVLoc.pageObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import com.Actouch.Pages.SODashBoard;
import com.Actouch.Pages.SalesOrderCreation;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
public class SOPaymentNowSingleCheque {
	public static String amt; 
	//payment now with cheque & tax
	  public void payNowCheque (String Customer_Id,String prod_id,String Quantity,String unit_price,String PayMentType,String BankName,String ChequeNo, String RecvdbankName ) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException

     {
		  SalesOrderCreation SOC = new SalesOrderCreation(Browser.driver);
			 SODashBoard SOD = new SODashBoard(Browser.driver);
		  WebDriverCommonlib.waitForPageToLoad();
    	 Actions act= new Actions(Browser.driver);
    	 String exp = SOC.SOidEdt();
    	 Thread.sleep(5000);
    	 SOC.SoCustIdEdt(Customer_Id);
    	 Thread.sleep(1000);
    		act.sendKeys(Keys.TAB).perform();
    	JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
	  	kl.executeScript("window.scrollBy(0,300)", "");
	  	SOC.prdSo_1Edt(prod_id);
	 Thread.sleep(2000);
			act.sendKeys(Keys.TAB).perform();
			SOC.prDetailsEdt();
			SOC.roleSelProdEdt();
			SOC.qntEdt(Quantity);
			SOC.aftrqntOkEdt();
			SOC.unitprice_1edt(unit_price);
			SOC.payTypeEdt(PayMentType);
  			act.sendKeys(Keys.ARROW_DOWN).perform();
  			act.sendKeys(Keys.ENTER).perform();
  			amt = SOC.gettingTotalAmount();
  			SOC.PaymodeEdt(BankName);
  		act.sendKeys(Keys.ARROW_DOWN).perform();
  		act.sendKeys(Keys.ENTER).perform();
  			SOC.chequeNo(ChequeNo);
  			SOC.recvdbankName(RecvdbankName);
  			SOC.puttingTotalAmount(amt);
  			SOC.savingcheq();
  			Thread.sleep(3000);
  			SOC.btnSaveEdt();
  		SOC.ConfirmSaveedt();
  		  Browser.driver.get(Constant.SalesMain);
  		  Thread.sleep(7000);
  		  SOD.Setsearchtxt(exp);
  		   String act2 = SOD.actval();
  		    Assert.assertEquals(act2, exp,"payment Now with single cheque after saving case == fail");
  	  		System.out.println("payment Now with single cheque after saving case == pass");
   }
     
	
}

