package com.Actouch.PurchaseSRV.pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;

public class PORSRVPartialTax {

	public static String amt;
	 @FindBy(xpath="//input[@aria-controls='POTable']")
		    WebElement searchtxt;
	@FindBy(xpath="//table[@id='POTable']/tbody/tr/td[5]")
		 WebElement SuppNMforPOR;
		 @FindBy(id="suppIdFor_Por")
		 WebElement SuppDshEdt;
		 @FindBy(xpath="//input[@aria-controls='POTable']")
		 WebElement searchForPO;
		 @FindBy(xpath=".//*[@id='POTable']/tbody/tr/td[2]/a")
		 WebElement choosePOid;
		 @FindBy(id="porId" )
		 WebElement PORid;
		 @FindBy(xpath="//table[@id='PORDetailsTable']/tbody/tr/td[1]/input")
		 WebElement Selectprod;
		 @FindBy(id="recdQty_1")
		 WebElement Receiveall;
		 @FindBy(xpath="//span[@data-bind= 'click: porTaxMore']")
		 WebElement taxModel;
		 @FindBy(xpath="//label[@data-bind='html: PORInventory.totalAmt']")
		 WebElement TotalAmt;
		 @FindBy(id="btnSave")
		 WebElement SaveEdt;
		 @FindBy(xpath="html/body/div[9]/div/div[3]/button")
		 WebElement AfterSave;
		 @FindBy(xpath="//div[@id='crpobtn']/a")
		 WebElement viewReceipt;
		 @FindBy(xpath="//input[@aria-controls='POR_Table']")
		 WebElement SearchPOR;
		 @FindBy(xpath="//table[@id='POR_Table']/tbody/tr/td[3]")
		 WebElement Result;
		 public void Partialreceipt(String Qnty,String taxCode) throws InterruptedException
		 {
			 WebDriverCommonlib.waitForPageToLoad();
				Actions act=new Actions(Browser.driver);
				String exp = searchtxt.getAttribute("value");
				String Supp = SuppNMforPOR.getText();
				Browser.driver.get(Constant.newPorMain);
				SuppDshEdt.sendKeys(Supp);
				act.sendKeys(Keys.ARROW_DOWN).perform();
				act.sendKeys(Keys.ENTER).perform();
				Thread.sleep(2000);
				searchForPO.sendKeys(exp);
				choosePOid.click();
				 	String Expected=PORid.getAttribute("value");
				Thread.sleep(2000);
				Selectprod.click();
				Receiveall.sendKeys(Qnty);
				taxModel.click();
				 for(int i=1;i<10;i++)
							  {
							String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
								  if(count1.equals(taxCode)){
									Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
									Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
								  
								  	break;
								  	
								  }
							  }
				act.sendKeys(Keys.ENTER).perform();
				amt = TotalAmt.getText();
				SaveEdt.click();
				AfterSave.click();
				Thread.sleep(4000);
				viewReceipt.click();
				Thread.sleep(4000);
				SearchPOR.sendKeys(Expected);
				String actual = Result.getText() ;
			Assert.assertEquals(actual, Expected, "full shipment ==fail");
			 System.out.println("full shipment ==pass");
			 }

}
