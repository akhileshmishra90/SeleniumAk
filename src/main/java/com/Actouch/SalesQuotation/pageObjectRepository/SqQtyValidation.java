package com.Actouch.SalesQuotation.pageObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.Actouch.SalesQuotation.generic_Lib.Browser;
public class SqQtyValidation {
	public static String amt ; 
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
	@FindBy(xpath="//h3[@data-bind='html: SQInventory.totalAmt']")
    WebElement gettingTotalAmount;
	@FindBy(id ="btnSave")
	WebElement btnSaveEdt;
	@FindBy(xpath ="//p[contains(.,'Please Enter Quantity at Line Number:1')]")
	WebElement actMsg;
   public void qtyValid (String Customer_Id,String Product_Id,String Quantity) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
   {
	   	String aMsg = "Product Quantity can not be zero";
	   
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
	   kl.executeScript("window.scrollBy(0,300)", "");
	   prdSq_1Edt.sendKeys(Product_Id);
	   Thread.sleep(1000);
	  
     	act.sendKeys(Keys.TAB).perform();
	   
     	Thread.sleep(1000);
	   
     	qntEdt.sendKeys(Quantity);
	   	Thread.sleep(500);
	   
		System.out.println(aMsg);
	   
   }
}
