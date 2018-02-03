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
import com.Actouch.SalesQuotation.generic_Lib.SalesQuotationExcellib;

public class SqMultiproduct {
	 
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
	
	@FindBy(xpath="//label[@class='addNewRow']")
	WebElement AddRow;
	
	
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
	
public void multiproduct(String custID, String taxCode) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException 
	{

			String exp1 = SqidEdt.getAttribute("value");
		    String exp2 = SqridEdt.getAttribute("value");
		    
		    String exp = exp1 +"-"+ exp2;
		    System.out.println(exp);
		    Thread.sleep(3000);
		    custIdEdt.sendKeys(custID);
		    Thread.sleep(3000);
    
		  	Actions act = new Actions(Browser.driver);
  	      	act.sendKeys(Keys.TAB).perform();
		  
		  	JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
		  	kl.executeScript("window.scrollBy(0,300)", "");
		  	
		  			Thread.sleep(1000);
		  			
		  			int i;
		  			int j=0;
		  			int l=22;
		  			for (i=0;i<3;i++)
		  			{

	  	        		String prdID = SalesQuotationExcellib.getExcelDat("SQ", l, 12);

	  	        		Browser.driver.findElement(By.id("prdSQ_"+j)).sendKeys(prdID);
	  	        		Thread.sleep(2000);
	  	      	
			  	      	act.sendKeys(Keys.TAB).perform();
			  	      
			  	      	Thread.sleep(3000);
	  	      				
			  	      	String unitP = SalesQuotationExcellib.getExcelDat("SQ", l, 17);
			  	      	Thread.sleep(1000);
			  	      	Browser.driver.findElement(By.id("unitprice")).sendKeys(unitP);
			  	      	Thread.sleep(1000);
			  	      	AddRow.click();
			  	      	Thread.sleep(2000);
			  	      	l++;
			  			j++;
			  			
		  			}
		  			
		  			String qty = SalesQuotationExcellib.getExcelDat("SQ", 22, 15);
		  			Browser.driver.findElement(By.xpath("//input[@data-bind='value: sellQty,enable:editQty']")).sendKeys(qty);;

		  	      
/*
		  			int j = 1;
		  			int l=22;
		  	        int count = 1;
		  	        do {
		  	        	
		  	        	while (j < 5)
		  	      	{
	
		  	        		String qty = SalesQuotationExcellib.getExcelDat("SQ", l, 15);
		  	      	
		  	        		String prdID = SalesQuotationExcellib.getExcelDat("SQ", l, 12);
	
		  	        		Browser.driver.findElement(By.id("prdSQ_"+j)).sendKeys(prdID);
		  	        		Thread.sleep(2000);
		  	      	
				  	      	act.sendKeys(Keys.TAB).perform();
				  	      	String unitP = SalesQuotationExcellib.getExcelDat("SQ", l, 17);
				  	      	Thread.sleep(1000);
				  	      	Browser.driver.findElement(By.id("unitprice")).sendKeys(unitP);
				  	      	Thread.sleep(1000);
		  
		  	      		
		  	      		
		  	      		if(j == 1)
		  	      		{
		  	      			Browser.driver.findElement(By.xpath("//table[@id='SQDetailsTable']/tbody/tr["+j+"]/td[5]/div/div[2]/input")).click();
				  			Thread.sleep(1000);
	  	        		  			
				  			
				  			qntEdt.sendKeys(qty);
				  			
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
	  						  
	  	        		  
	  						
		  	      		j++;
		  	      		break;
		  	      		}
		  	      		else if (j == 2)
		  	      			
		  	      		{
		  	        	
	try
	{

		  	        					Browser.driver.findElement(By.xpath("//table[@id='SQDetailsTable']/tbody/tr["+j+"]/td[5]/div/div[2]/input")).click();
		  	        		  			Thread.sleep(100);
		  	        		  			qntEdt.sendKeys(qty);
		  	        		  }
	catch(Exception e)
	{
				Browser.driver.findElement(By.xpath(".//*[@id='SQDetailsTable']/tbody/tr[2]/td[5]/div/div[1]/input")).sendKeys(qty);
	}
	
	
		  	      			
		  	      		  j++;
		  	      			break;
		  	      		
		  	      }
		  	    
		  	  else if(j == 3)
		      		{
		      		
	      		  			Browser.driver.findElement(By.xpath("//table[@id='SQDetailsTable']/tbody/tr["+j+"]/td[5]/div/div[2]/input")).click();
	      		  			Thread.sleep(1000);
	      		  		
	      		  			qntEdt.sendKeys(qty);
	      		 
		      		j++;
		      		break;
		      		}
		  	 else if(j == 4)
	   		{
	   		
		  		 kl.executeScript("window.scrollBy(0,300)", "");
		  		 Thread.sleep(4000);
		  		 Browser.driver.findElement(By.xpath("//table[@id='SQDetailsTable']/tbody/tr["+j+"]/td[5]/div/div[2]/input")).click();
		  		 Thread.sleep(1000);
			  			
		  		 qntEdt.sendKeys(qty);
			
	   		j++;
	   		break;
	   		
	   		}
		  	      	}
		  	    
                             l++;
		  	        	
		  	            count++;
		  	          if(count < 5){
		  	        	AddRow.click();
		  	        	  Thread.sleep(2000);
		  	          }
		  	         
		  	        } while (count < 5);

		  	       */
		  	        Thread.sleep(5000);
					amt = gettingTotalAmount.getText();
					Thread.sleep(2000);
		  	  		btnSaveEdt.click();
		  	  		clickOk.click();
		  	  		Thread.sleep(1000);
		  	  		Browser.driver.get(Constant.SqMain);
		  	  		Thread.sleep(7000);
		  	  		// saleConfirmMsgedt.getText();
		  	  		searchId.sendKeys(exp);
		  	  		String act2 = actval.getText();
		  		    Assert.assertEquals(act2, exp,"multi product after saving case == fail");
		  	  		System.out.println("multi product after saving case == pass");

}

}
