package com.Actouch.SalesQuotation.pageObjectRepository;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.SalesQuotation.generic_Lib.Browser;

public class ShipmentLength {
	
	@FindBy(id ="sqId")
	WebElement SqidEdt;
	@FindBy(id ="SqrId")
	WebElement SqridEdt;
	
	@FindBy(id ="cust_Id")
	WebElement custIdEdt;
	@FindBy(id ="sq_shipAddress")
	WebElement shippingAddress;
	
	public void ShipLength(String Cust_id) throws InterruptedException
	{
	
		int kh = 200;
		String exp1 = SqidEdt.getAttribute("value");
	    String exp2 = SqridEdt.getAttribute("value");
	    
	    String exp = exp1 +"-"+ exp2;
	 
	    System.out.println(exp);
	    Thread.sleep(3000);
	    custIdEdt.sendKeys(Cust_id);
	    
	    Actions act = new Actions(Browser.driver);
	    act.sendKeys(Keys.TAB).perform();
	    
	    Thread.sleep(3000);
		
		String fh = shippingAddress.getAttribute("value");
		int n = fh.length();
		System.out.println(n);
		
		 Assert.assertTrue(kh>=n, "shipment lenth is less than equal to 200 == fail");
			
		System.out.println("shipment lenth is less than or equal to 200 == pass");

	}
}