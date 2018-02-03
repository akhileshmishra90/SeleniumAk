package com.Actouch.DirectInvoiceINVLoc.pageObjectRepository;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
public class UPDINVTax {
	
		@FindBy(xpath="//input[@aria-controls='SHP_Table']")
		WebElement InvoiceEdt;
		@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle']")
		WebElement ActionEdt;
		@FindBy(linkText="Update Invoice")
		WebElement UpdateInvoice;
		@FindBy(id="lineItemChanges")
		WebElement Changelineitem;
		@FindBy(xpath="//input[@data-bind='checked: chkSelectAll']")
		WebElement Selectprod;
		@FindBy(xpath="//span[@data-bind='click: showPOTaxModel']")
		WebElement TaxDetail;
		@FindBy(xpath="//input[@data-bind='value:lineTaxAmount ']")
		WebElement getTaxEdt;
		@FindBy(id="saveMethod")
		WebElement saveEdt;
		@FindBy(xpath="html/body/div[9]/div/div[3]/button")
		WebElement AfterSaveEdt;
		@FindBy(linkText="View Invoices")
		WebElement Viewstatus;
		@FindBy(linkText="View Invoice")
		WebElement CheckInvoice;
		@FindBy(xpath="//label[@data-bind='text: lineTaxAmount']")
		WebElement ResultEdt;
		public void UpdateAmount(String Newtaxcode) throws InterruptedException
		{
			WebDriverCommonlib.waitForPageToLoad();
			Actions act = new Actions(Browser.driver);
		String exp=	InvoiceEdt.getAttribute("value");
			ActionEdt.click();
			UpdateInvoice.click();
			Thread.sleep(4000);
			 TaxDetail.click();
			 List<WebElement> els = Browser.driver.findElements(By.id("chkTaxId"));
			for(WebElement elw :els)
			  {
			if(elw.isSelected())
				elw.click();
			  }
			Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
			 TaxDetail.click();
				
			 for(int i=1;i<10;i++)
			  {
			String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
				  if(count1.equals(Newtaxcode)){
					Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
					Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
				  
				  	break;
				  	
				  }
			  }
			 String Expected = getTaxEdt.getAttribute("value");
			 act.sendKeys(Keys.ENTER).perform();
			saveEdt.click();
			AfterSaveEdt.click();
			Thread.sleep(3000);
			InvoiceEdt.sendKeys(exp);
			ActionEdt.click();
			CheckInvoice.click();
			Thread.sleep(3000);
			String Actual = ResultEdt.getText();
			System.out.println(Actual);
			Assert.assertEquals(Actual, Expected,"Customer update wrong");
			System.out.println("Customer Upadate As Usual");
			
		}

}
