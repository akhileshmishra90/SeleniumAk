package com.Actouch.SalesQuotation.pageObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.Actouch.SalesQuotation.generic_Lib.Browser;
public class SqIDvalidation {
	
	
	@FindBy(id ="sqId")
	WebElement SqidEdt;
	
	@FindBy(xpath ="//p[contains(.,'Quotation Number already exists')]")
	WebElement msgEdt;
	
	
   public void sqIdValid(String sqId) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
   {
	   String actMsg = "Quotation Number already exists";
	   
	   Actions act = new Actions(Browser.driver);
     	
	   act.doubleClick(SqidEdt).perform();
	   Thread.sleep(1000);
	   SqidEdt.sendKeys(sqId); 
	   Thread.sleep(1000);
	   act.sendKeys(Keys.TAB).perform();
	   Thread.sleep(1000);
	   	String msg = msgEdt.getAttribute("value");
	   	System.out.println(msg);
	   	Thread.sleep(1000);
	   	
	   	/*String exp1 = SqidEdt.getAttribute("value");
	    String exp2 = SqridEdt.getAttribute("value");
	    
	    String exp = exp1 +"-"+ exp2;
	    System.out.println(exp);*/
	 
	    Assert.assertEquals(msg, actMsg,"SQ saved after executing case == pass");
		System.out.println("SQ  not saved after executing case == fail");
	   
   }
}
