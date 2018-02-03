package com.Actouch.SalesINV.pageObjectRepository;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class SOMemoLentgh {
	@FindBy(id ="SoIsoId")
	WebElement SOidEdt;
	@FindBy(id ="createSoCustId")
	WebElement SoCustIdEdt;
	@FindBy(id="prdSo_1")
	WebElement prdSo_1Edt;
	@FindBy(xpath="//span[text()='Product Details']")
	WebElement prDetailsEdt;
	@FindBy(name="roleFor")
	WebElement roleSelProdEdt;
	@FindBy(xpath="//table[@id='taxCalc']/tbody/tr[2]/td[12]/input")
	WebElement qntEdt;
	@FindBy(xpath="//button[contains(text(),'Ok')]")
	WebElement aftrqntOkEdt;
	@FindBy(id="unitprice_1")
	WebElement unitprice_1edt;
	@FindBy(id="memo")
	WebElement memoedt;
	  public void memoLentgh(String Customer_Id,String Product_Id,String Quantity,String unit_price,String Memo) throws InterruptedException
	  { 
		  WebDriverCommonlib.waitForPageToLoad();
		  Actions act = new Actions(Browser.driver);
		  int kh = 495;
		    Thread.sleep(5000);
		 SoCustIdEdt.sendKeys(Customer_Id);
		  Thread.sleep(1000);
		  	act.sendKeys(Keys.TAB).perform();
		 JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
		   kl.executeScript("window.scrollBy(0,300)", "");
		 prdSo_1Edt.sendKeys(Product_Id);
		act.sendKeys(Keys.TAB).perform();
		  prDetailsEdt.click();
		 roleSelProdEdt.click();
		 qntEdt.sendKeys(Quantity);
		   aftrqntOkEdt.click();
		 unitprice_1edt.sendKeys(unit_price);
		 memoedt.sendKeys(Memo);
		 String fh =  memoedt.getAttribute("value");
			int n = fh.length();
			System.out.println(n);
			 Assert.assertTrue(kh>=n, "Memo lenth is less than equal to 495 == fail");
		System.out.println("Memo lenth is less than or equal to 495 == pass");
	   }

}
