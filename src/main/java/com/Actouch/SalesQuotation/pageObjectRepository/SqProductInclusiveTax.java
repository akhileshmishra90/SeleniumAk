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


public class SqProductInclusiveTax {
	//tax Inclusive
	public static String amt;
	
	@FindBy(id ="SoIsoId")
	WebElement SOidEdt;
	@FindBy(id ="createSoCustId")
	WebElement SoCustIdEdt;
	@FindBy(id="prdSo_1")
	WebElement prdSo_1Edt;
	@FindBy(xpath="//span[text()='Product Details']")
	WebElement prDetailsEdt;
	@FindBy(id="lineDisc")
	WebElement lineDiscount;
	@FindBy(name="roleFor")
	WebElement roleSelProdEdt;
	@FindBy(xpath="//table[@id='taxCalc']/tbody/tr[2]/td[12]/input")
	WebElement qntEdt;
	@FindBy(xpath="//button[contains(text(),'Ok')]")
	WebElement aftrqntOkEdt;
	@FindBy(id="unitprice_1")
	WebElement unitprice_1edt;
	@FindBy(xpath="//label[@data-bind='html: SOInventory.totalAmt']")
    WebElement gettingTotalAmount;
	@FindBy(id ="btnSave")
	WebElement btnSaveEdt;
	@FindBy(xpath="//p[contains(text(),'Sales Order')]")
	WebElement saleConfirmMsgedt;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement ConfirmSaveedt;
    @FindBy(xpath="//input[@aria-controls='SOTable']")
    WebElement searchtxt;
   @FindBy(xpath="//table[@id='SOTable']/tbody/tr/td[2]")
   WebElement actval;
   public void ProdTaxIncl(String Customer_Id,String Product_Id,String Quantity,String unit_price, String taxCode1,String Discount) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
   {
	     String exp = SOidEdt.getAttribute("value");
	    System.out.println(exp);
	    Thread.sleep(3000);
	    SoCustIdEdt.sendKeys(Customer_Id);
	   Thread.sleep(1000);
	   Actions act = new Actions(Browser.driver);
	      	act.sendKeys(Keys.TAB).perform();
	   Thread.sleep(1000);
	   JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
	   kl.executeScript("window.scrollBy(0,300)", "");
	 prdSo_1Edt.sendKeys(Product_Id);
	   Thread.sleep(1000);
	   Actions act1 = new Actions(Browser.driver);
     	act1.sendKeys(Keys.TAB).perform();
	   
     	Thread.sleep(1000);
	   prDetailsEdt.click();
	   Thread.sleep(3000);
	   roleSelProdEdt.click();
	   Thread.sleep(1000);
	   qntEdt.sendKeys(Quantity);
	   aftrqntOkEdt.click();
	 unitprice_1edt.sendKeys(unit_price);
	   
	 String Dis = lineDiscount.getAttribute("value");
	  
	 if(Dis.equals("0"))
	  {
	   Thread.sleep(1000);
		  lineDiscount.clear();
		  lineDiscount.sendKeys(Discount);
  }
	  
	   Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr/td[8]/span/input")).click();
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
	 Thread.sleep(1000);
		amt = gettingTotalAmount.getText();
		Thread.sleep(2000);
	 
	  btnSaveEdt.click();
	   ConfirmSaveedt.click();
	   Thread.sleep(1000);
	   Browser.driver.get(Constant.SalesMain);
	  Thread.sleep(7000);
	   // saleConfirmMsgedt.getText();
	    searchtxt.sendKeys(exp);
	   String act2 = actval.getText();
	    Assert.assertEquals(act2, exp,"product inclusive after saving case == fail");
  		System.out.println("product inclusive  after saving case == pass");
	   
   }
	
	
   }




