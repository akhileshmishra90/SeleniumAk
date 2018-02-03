package com.Actouch.DirectReceiptINV.pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;
 public class DRTDSWithTax {
 public static String amt;
    @FindBy(id="poId")
    WebElement PORID;
	@FindBy(id="prdId_createDpor")
	WebElement SuppEdt;
	@FindBy(id="prdPo_1")
	WebElement ProdIDEdt;
	@FindBy(xpath="//div[@data-bind='if:chkLoc']/span")
	WebElement prodModEdt;
	@FindBy(xpath="//td[@data-bind='visible: !isSerialNo()']/input")
	WebElement QntyEdt;
	@FindBy(xpath="//button[@data-bind='click: ok']")
	WebElement QtySave;
	@FindBy(id="unitprice")
	WebElement UnitPEdt;
	@FindBy(xpath="//span[@data-bind='click: showPOTaxModel']")
	WebElement TaxModel;
	@FindBy(xpath="//p[contains(text(),' Select Multiple Tax Type with TDS')]")
	WebElement Result;
	public void Payltr(String Supp,String ProdID,String Qnty,String UnitP,String TaxCode,String TaxCode2 ) throws InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
		Actions act =new Actions(Browser.driver);
		String Expected= "You Can't Select Multiple Tax Type with TDS";
		 Thread.sleep(4000);
		SuppEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Supp);
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).perform();
		ProdIDEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),ProdID);
		 Thread.sleep(1000);
		act.sendKeys(Keys.TAB).perform();
		prodModEdt.click();
		QntyEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Qnty);
		QtySave.click();
		UnitPEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),UnitP);
		TaxModel.click();
		  for(int i=1;i<10;i++)
		  {
		String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
			  if(count1.equals(TaxCode)){
				Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
				Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
			  break;
			  	
			  }
		  }
	
			  TaxModel.click();
			  for(int i=1;i<10;i++)
			  {
				  String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
			  
					  if(count1.equals(TaxCode2)){
						Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
						Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
					  break;
					  	
					  }
			  }
				  
    String Actual = Result.getText();
		 Assert.assertEquals(Actual, Expected,"POR ID not created");
		  
	}
	
	

}
