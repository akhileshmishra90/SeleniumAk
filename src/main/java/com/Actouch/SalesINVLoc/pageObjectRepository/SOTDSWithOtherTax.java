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

import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class SOTDSWithOtherTax {
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
@FindBy(xpath = "//p[contains(text(), 'Select Multiple Tax Type with TDS')]")
WebElement TDSMsg;
   
   public void TDSProdMultTax(String Customer_Id,String Product_Id,String Quantity,String unit_price,String taxCode1,String taxCode2 ,String PayMentType ) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
   {
	   WebDriverCommonlib.waitForPageToLoad();
	   WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
	   Actions act= new Actions(Browser.driver);
	 String exp = "You Can't Select Multiple Tax Type with TDS";
	 Thread.sleep(3000);
	 wait.until(ExpectedConditions.visibilityOf(SoCustIdEdt));
	 SoCustIdEdt.  sendKeys(Customer_Id);
 	Thread.sleep(1000);
 	act.sendKeys(Keys.TAB).perform();
JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
	   kl.executeScript("window.scrollBy(0,300)", "");
	 prdSo_1Edt.sendKeys(Product_Id);
	   Thread.sleep(2000);
	   Actions act1 = new Actions(Browser.driver);
     	act1.sendKeys(Keys.TAB).perform();
	   prDetailsEdt.click();
roleSelProdEdt.click();
qntEdt.sendKeys(Quantity);
	   aftrqntOkEdt.click();
	 unitprice_1edt.sendKeys(unit_price);
 Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr/td[9]/div/div/span[text()='Tax Details']")).click();
	   for(int i=1;i<10;i++)
		  {
		String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
			  if(count1.equals(taxCode1)){
				Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
				Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
			  
			  	break;
			  	
			  }
		  }
	 Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr/td[9]/div/div/span[text()='Tax Details']")).click();

	 for(int j=1;j<10;j++)
	 {
			  String count2=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+j+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
			  if(count2.equals(taxCode2)){
				Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+j+"]/td/input[@id ='chkTaxId']")).click();
				Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
				
			  
			  	break;
			  }
	 }
String Actual = TDSMsg.getText();
		  Assert.assertEquals(Actual, exp,"TDS can't along with another tax == fail");
  		System.out.println("TDS can't along with another tax == pass");
	   
   }
	}
