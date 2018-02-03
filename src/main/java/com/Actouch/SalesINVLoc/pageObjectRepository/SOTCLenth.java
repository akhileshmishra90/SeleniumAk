
	package com.Actouch.SalesINVLoc.pageObjectRepository;


	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.testng.Assert;

	import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

	public class SOTCLenth {
		@FindBy(id ="SoIsoId")
		WebElement SOidEdt;
		@FindBy(id ="createSoCustId")
		WebElement SoCustIdEdt;
		@FindBy(id="prdSo_1")
		WebElement prdSo_1Edt;
		@FindBy(xpath="//span[text()='Product Details']")
		WebElement prDetailsEdt;
		@FindBy(xpath=".//*[@id='taxCalc']/tbody/tr/td[1]/input[@data-bind ='checked: chkSelectAll ']")
		WebElement roleSelProdEdt;
		@FindBy(xpath=".//*[@id='taxCalc']/tbody/tr/td[13]/input")
		WebElement qntEdt;
		@FindBy(xpath="//button[contains(text(),'Ok')]")
		WebElement aftrqntOkEdt;
		@FindBy(id="unitprice_1")
		WebElement unitprice_1edt;
		@FindBy(xpath="//div[contains(text(),'Click here to Enter')]")
		WebElement TCBoxEdt;
		@FindBy(xpath="//textarea[@placeholder='Terms and Conditions']")
		WebElement TermCond;
		  public void tcLentgh(String Customer_Id,String Product_Id,String Quantity,String unit_price,String Term_Condition) throws InterruptedException
		  { 
			  WebDriverCommonlib.waitForPageToLoad();
			  int kh = 4950;
			    String exp = SOidEdt.getAttribute("value");
			 System.out.println(exp);
			 Thread.sleep(5000);
			 SoCustIdEdt.sendKeys(Customer_Id);
			  Thread.sleep(1000);
			   Actions act = new Actions(Browser.driver);
				act.sendKeys(Keys.TAB).perform();
			 JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
			   kl.executeScript("window.scrollBy(0,300)", "");
			 prdSo_1Edt.sendKeys(Product_Id);
			   Thread.sleep(1000);
			   act.sendKeys(Keys.TAB).perform();
			    prDetailsEdt.click();
		 roleSelProdEdt.click();
 qntEdt.sendKeys(Quantity);
			   aftrqntOkEdt.click();
			 unitprice_1edt.sendKeys(unit_price);
			 TCBoxEdt.click();
			 TermCond.sendKeys(Term_Condition);
			 String fh =  TermCond.getAttribute("value");
				int n = fh.length();
				System.out.println(n);
				 Assert.assertTrue(kh>=n, "Memo lenth is less than equal to 5000 == fail");
				System.out.println("Memo lenth is less than or equal to 5000 == pass");
		   }

	}


