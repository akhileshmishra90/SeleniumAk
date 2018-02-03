
	package com.Actouch.SalesQuotation.pageObjectRepository;


	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.testng.Assert;

	import com.Actouch.SalesQuotation.generic_Lib.Browser;

	public class SqTCLenth {
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
		@FindBy(xpath="//div[contains(@data-bind,'click: SQInventory.showTermsConditionModal')]")
		WebElement TCBoxEdt;         
		@FindBy(xpath="//textarea[@placeholder='Terms and Conditions']")
		WebElement TermCond;
		
		  public void tcLentgh(String Customer_Id,String Product_Id,String Quantity,String unit_price,String Term_Condition) throws InterruptedException
		  { 
			  int kh = 4950;
			  
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
			 
			   act.sendKeys(Keys.ENTER).perform();
			   Thread.sleep(1000);
		 
			   unitpriceEdt.sendKeys(unit_price);
			 
			   TCBoxEdt.click();
			   Thread.sleep(600);
			 
			   TermCond.sendKeys(Term_Condition);
			   String fh =  TermCond.getAttribute("value");
				
			   int n = fh.length();
			   System.out.println(n);
			   Assert.assertTrue(kh>=n, "T&C length is less than equal to Max Len. == fail");
				
					
				System.out.println("T&C length is less than or equal to Max Len. == pass");
		   }

	}


