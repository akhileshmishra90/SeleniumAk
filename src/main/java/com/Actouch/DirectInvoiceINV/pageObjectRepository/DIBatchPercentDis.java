package com.Actouch.DirectInvoiceINV.pageObjectRepository;

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

public class DIBatchPercentDis {

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
	   @FindBy(xpath="//table[@id='SODetailsTable']/tbody/tr/td[9]/div/div/span[text()='Tax Details']")
	   WebElement TaxModel;
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
	   public void payltr(String Customer_Id,String Product_Id,String Batch,String Quantity,String unit_price,String LineDis,String taxCode1) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	   {
		   WebDriverCommonlib.waitForPageToLoad();
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
		    SaveProdModel.click();
		   Thread.sleep(1000);
		   UnitPrice.sendKeys(unit_price);
			   LineDisEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),LineDis);
			   TaxModel.click();
		    for(int i=1;i<15;i++)
			  {
			String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
				  if(count1.equals(taxCode1)){
					Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
					Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
				  
				  	break;
				  	
				  }
			  }
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
