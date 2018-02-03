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

import com.Actouch.SalesQuotation.generic_Lib.Browser;
import com.Actouch.SalesQuotation.generic_Lib.Constant;


public class SqLineDisc {
	
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
	@FindBy(xpath="//button/span[@data-bind='text: discTypeLine']")
	WebElement lineDiscEdt;
	@FindBy(xpath="//a[@data-bind='click: discTypeA']")
	WebElement discType;
	
	@FindBy(id ="lineDisc")
	WebElement lineDiscount;
	
	@FindBy(xpath="//h3[@data-bind='html: SQInventory.totalAmt']")
    WebElement gettingTotalAmount;
	@FindBy(id ="btnSave")
	WebElement btnSaveEdt;
	
	@FindBy(xpath="//p[contains(text(),'Sales Quotation')]")
	WebElement sqConfirmMsgedt;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement clickOk;
    @FindBy(xpath="//input[@aria-controls='SQTable']")
    WebElement searchId;
   @FindBy(xpath="//table[@id='SQTable']/tbody/tr/td[2]")
   WebElement actval;
   
   public void sqLineDisc (String Customer_Id,String Product_Id,String Quantity,String unit_price,String disc,String taxCode) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
   {
	   
	    String exp1 = SqidEdt.getAttribute("value");
	    String exp2 = SqridEdt.getAttribute("value");
	    
	    String exp = exp1 +"-"+ exp2;
	 System.out.println(exp);
	 
	 Thread.sleep(3000);
	 custIdEdt.sendKeys(Customer_Id);
	   Thread.sleep(3000);
	   Actions act = new Actions(Browser.driver);
	   act.sendKeys(Keys.TAB).perform();
	   Thread.sleep(1000);
	   JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
	   kl.executeScript("window.scrollBy(0,400)", "");
	   
	   prdSq_1Edt.sendKeys(Product_Id);
	   Thread.sleep(1000);
	  
     	act.sendKeys(Keys.TAB).perform();
	  
	   Thread.sleep(1000);
	   qntEdt.sendKeys(Quantity);
	   Thread.sleep(100);
	   unitpriceEdt.clear();
	 unitpriceEdt.sendKeys(unit_price);
	 Thread.sleep(100);
	 
	 lineDiscEdt.click();
	 Thread.sleep(100);
	 discType.click();
	 Thread.sleep(100);
	 
	 
	 lineDiscount.sendKeys(disc);
	 
	   Browser.driver.findElement(By.xpath("//table[@id='SQDetailsTable']/tbody/tr/td[9]/div/div/span[text()='Tax Details']")).click();
	  		Thread.sleep(2000);
	  		
	  		for(int i=1;i<10;i++)
			  {
			String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
				  if(count1.equals(taxCode)){
					Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
					Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
				  
				  	break;
				  	
				  }
			  }
	 
	
	 Thread.sleep(4000);
		amt = gettingTotalAmount.getText();
		Thread.sleep(2000);
		btnSaveEdt.click();
		Thread.sleep(1000);
		
		clickOk.click();
	   Thread.sleep(1000);
	   Browser.driver.get(Constant.SqMain);
	  Thread.sleep(7000);
	  
	  searchId.sendKeys(exp);
	   String act2 = actval.getText();
	    Assert.assertEquals(act2, exp,"SQ with product Line Disc. not saved after executing case == fail");
  		System.out.println("SQ with product Line Disc. saved after executing case == pass");
	   

   }
}
