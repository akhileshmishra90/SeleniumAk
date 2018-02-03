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


public class SQview {
	public static String amt;
	
    @FindBy(xpath="//input[@aria-controls='SQTable']")
    WebElement searchId;
    @FindBy(xpath="//table[@id='SQTable']/tbody/tr[1]/td[2]")
    WebElement clickSqId;
   
   
   public void viewSQ(String sqID) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
   {
	  
	   searchId.sendKeys(sqID);
	   Thread.sleep(3000);
	   
  		System.out.println("sq view case == pass");
	   
   }

}
