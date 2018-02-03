package com.Actouch.PurchaseSRV.pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;

public class POSRVDiffTDS {
	public static String amt;
	@FindBy(id ="poId")
	WebElement PoIdEdt;
	@FindBy(id="poServSuppList")
	WebElement SuppEdt;
	@FindBy(xpath="//textarea[@placeholder='Enter Service Description (Max 190 characters)']")
	WebElement DescEdt;
	@FindBy(xpath="//input[@data-bind ='selectcontrolExpenseAcPOSInput:prdId']")
	WebElement CategoryEdt;
	@FindBy(id="POSunitprice")
	WebElement UnitPriceEdt;
	@FindBy(xpath="//table[@id='PODetailsTable']/tbody/tr/td[8]/div/div/span[text()='Tax Details']")
	WebElement Taxmodel;
	@FindBy(xpath="//p[@data-bind ='text: message']")
	WebElement actval;
	public void payTDSDiff(String Supp,String Desc,String Category,String Unitprice,String taxCode1 ,String taxCode2 ) throws InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
		Actions act = new Actions(Browser.driver);
		String exp = "You Can't Select Multiple Tax Type with TDS";
		Thread.sleep(3000);
		SuppEdt.sendKeys(Supp);
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).perform();
		DescEdt.sendKeys(Desc);
		CategoryEdt.sendKeys(Category);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		UnitPriceEdt.sendKeys(Unitprice);
		act.sendKeys(Keys.ENTER).perform();
		 Taxmodel.click();
		 for(int i=1;i<10;i++)
			  {
			String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
				  if(count1.equals(taxCode1)){
					Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
					Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
				  
				  	break;
				  	
				  }
			  }
		 Taxmodel.click();
		 for(int i=1;i<10;i++)
			  {
			String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
				  if(count1.equals(taxCode2)){
					Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
					Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
				  
				  	break;
				  	
				  }
			  }
		   
		  
		   String Atual= actval.getText();
		    Assert.assertEquals(Atual, exp,"payment later after saving case == fail");
	 		System.out.println("payment later after saving case == pass");
		   
		   }

}
