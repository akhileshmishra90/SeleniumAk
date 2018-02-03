package com.Actouch.SalesQuotation.pageObjectRepository;

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

public class SqTDSWithOtherTax {
	public static String amt;
	@FindBy(id ="sqId")
	WebElement SqidEdt;
	@FindBy(id ="SqrId")
	WebElement SqridEdt;
	
	@FindBy(id ="cust_Id")
	WebElement custIdEdt;
	@FindBy(id="prdSQ_0")
	WebElement prdSq_1Edt;
	
	@FindBy(xpath="//table[@id='SQDetailsTable']/tbody/tr/td[5]/div/div[1]/input")
	WebElement qntEdt;
	
	@FindBy(id="unitprice")
	WebElement unitpriceEdt;
	
	@FindBy(xpath = "//p[contains(text(), 'Select Multiple Tax Type with TDS')]")
	WebElement TDSMsg;
	@FindBy(xpath="//button[contains(text(),'Ok')]")
	WebElement aftrqntOkEdt;
	
   public void TDSProdMultTax(String Customer_Id,String Product_Id,String Quantity,String unit_price,String taxCode1,String taxCode2) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
   {
	   
	 String exp = "You Can't Select Multiple Tax Type with TDS";
	   
	   Thread.sleep(2000);
	   SqidEdt.sendKeys(Customer_Id);
 	 Thread.sleep(3000);
 	 Actions act= new Actions(Browser.driver);
	      	act.sendKeys(Keys.TAB).perform();
 	Thread.sleep(1000);
	 
	   JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
	   kl.executeScript("window.scrollBy(0,300)", "");
	   prdSq_1Edt.sendKeys(Product_Id);
	   Thread.sleep(1000);
	   Actions act1 = new Actions(Browser.driver);
     	act1.sendKeys(Keys.TAB).perform();
	   
     	Thread.sleep(1000);
	   prdSq_1Edt.click();
	   Thread.sleep(3000);
	   
	   qntEdt.sendKeys(Quantity);
	   aftrqntOkEdt.click();
	   unitpriceEdt.sendKeys(unit_price);

	   Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr/td[9]/div/div/span[text()='Tax Details']")).click();
	  		Thread.sleep(2000);
	 
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
		Thread.sleep(2000);
	 for(int j=1;j<10;j++)
	 {
			  String count2=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+j+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
			  if(count2.equals(taxCode2)){
				Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+j+"]/td/input[@id ='chkTaxId']")).click();
				Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
				
			  
			  	break;
			  }
			  
	 }
	 Thread.sleep(5000);
		String Actual = TDSMsg.getText();
		
		Thread.sleep(5000);




	    Assert.assertEquals(Actual, exp,"TDS can't along with another tax == fail");
  		System.out.println("TDS can't along with another tax == pass");
	   
   }
	

}
