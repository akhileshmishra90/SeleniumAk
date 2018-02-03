package com.Actouch.SalesINVLoc.pageObjectRepository;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import com.Actouch.Pages.SODashBoard;
import com.Actouch.Pages.SalesOrderCreation;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
public class SOWithCreditTerm {
	//So with credit term
	public static String amt;
   public void SoWithCrdTerm(String Customer_Id,String Credit_Term ,String Product_Id,String Quantity,String unit_price,String taxCode ) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
   {
	     WebDriverCommonlib.waitForPageToLoad();
	     SalesOrderCreation SOC = new SalesOrderCreation(Browser.driver);
		 SODashBoard SOD = new SODashBoard(Browser.driver);
	     Actions act = new Actions(Browser.driver);
	   String exp = SOC.SOidEdt();
	   System.out.println(exp);
	   Thread.sleep(5000);
	   SOC.SoCustIdEdt(Customer_Id);
	   Thread.sleep(1000);
	      	act.sendKeys(Keys.TAB).perform();
	  SOC.CreditTermEdt(Credit_Term);
	   act.sendKeys(Keys.ARROW_DOWN).perform();
	   act.sendKeys(Keys.ENTER).perform();
	    SOC.ShipNow("Yes");
	act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		 JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
		   kl.executeScript("window.scrollBy(0,300)", "");
		   SOC.prdSo_1Edt(Product_Id);
	 Thread.sleep(1000);
     	act.sendKeys(Keys.TAB).perform();
     	SOC.prDetailsEdt();
     	SOC.roleSelProdEdt();
     	SOC.qntEdt(Quantity);
     	SOC.aftrqntOkEdt();
     	SOC.unitprice_1edt(unit_price);
 Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr/td[9]/div/div/span[text()='Tax Details']")).click();
	  	 for(int i=1;i<10;i++)
		  {
		String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
			  if(count1.equals(taxCode)){
				Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
				Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
			  
			  	break;
			  	
			  }
		  }
	  
	amt = SOC.gettingTotalAmount();
	Thread.sleep(2000);
	SOC.btnSaveEdt();
	SOC.ConfirmSaveedt();
     Browser.driver.get(Constant.SalesMain);
	  Thread.sleep(7000);
	  SOD.Setsearchtxt(exp);
	   String act3 = SOD.actval();
	    Assert.assertEquals(act3, exp,"Sale order with credit term  after saving case == fail");
  		System.out.println("Sales order with credit term  after saving case == pass");
	   
   }
}
	 
	
   


