package com.Actouch.SalesQuotation.pageObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
public class SqcustIDvalidation {
	
	@FindBy(id ="sqId")
	WebElement SqidEdt;
	@FindBy(id ="SqrId")
	WebElement SqridEdt;
	
	@FindBy(id ="cust_Id")
	WebElement custIdEdt;
	
	
	@FindBy(id ="btnSave")
	WebElement btnSaveEdt;
	
	@FindBy(xpath ="//p[contains(.,'Customer Id cannot be blank')]")
	WebElement custValidateMsg;
	
   public void custIDvalid(String Customer_Id) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
   {
	   
	   String actMsg = "Customer Id cannot be blank";
	   
	   String exp1 = SqidEdt.getAttribute("value");
	    String exp2 = SqridEdt.getAttribute("value");
	    
	    String exp = exp1 +"-"+ exp2;
	    System.out.println(exp);
	    Thread.sleep(3000);
	    custIdEdt.sendKeys(Customer_Id);
	    Thread.sleep(3000);
	
	    btnSaveEdt.click();
		Thread.sleep(2000);
		
		String msg = custValidateMsg.getAttribute("value");
		
		
		Assert.assertEquals(msg, actMsg,"SQ saved after executing case == pass");
		System.out.println("SQ not saved after executing case == fail");
	   
   }
}
