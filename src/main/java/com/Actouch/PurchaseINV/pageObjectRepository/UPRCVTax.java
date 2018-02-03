package com.Actouch.PurchaseINV.pageObjectRepository;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;

public class UPRCVTax {

	  @FindBy(xpath="//input[@aria-controls='POTable']")
	    WebElement SearchPO;
		@FindBy(xpath="//input[@aria-controls='POR_Table']")
		WebElement SearchPOR;
		@FindBy(xpath="//button[text()='Actions']")
		WebElement ActionsEdt;
		@FindBy(linkText="Update PO Receipt")
		WebElement UpdateRCV;
		@FindBy(id="lineItemChanges")
		WebElement lineItemChanges;
		@FindBy(xpath="//input[@data-bind='checked: chkSelectAll']")
		WebElement SelectProd;
		@FindBy(xpath="//span[@data-bind='click: porTaxMore']")
		WebElement TaxModel;
		@FindBy(xpath="//input[@data-bind='value: taxAmt']")
		WebElement getTaxEdt;
		@FindBy(xpath="//button[@data-bind='click: ok']")
		WebElement saveQty;
		@FindBy(id="btnSave")
		WebElement SaveEDT;
		@FindBy(xpath="html/body/div[9]/div/div[3]/button")
		WebElement OKEdt;
		@FindBy(linkText="View PO Receipt")
		WebElement ViewRCV;
		@FindBy(xpath="//label[@data-bind ='text : lineTaxAmount']")
		WebElement Result;
		public void Quantity(String Newtaxcode) throws InterruptedException
		{
			WebDriverCommonlib.waitForPageToLoad();
			Actions act= new Actions(Browser.driver);
			String Exp = SearchPO.getAttribute("value");
			Browser.driver.get(Constant.PorMain);
			Thread.sleep(3000);
			SearchPOR.sendKeys(Exp);
			ActionsEdt.click();
			UpdateRCV.click();
			Thread.sleep(3000);
			lineItemChanges.click();
			SelectProd.click();
			TaxModel.click();
			
			List<WebElement> els = Browser.driver.findElements(By.id("chkTaxId"));
			for(WebElement elw :els)
			  {
			if(elw.isSelected())
				elw.click();
			  }
			Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
			TaxModel.click();
				
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
			SaveEDT.click();
			OKEdt.click();
			Thread.sleep(3000);
			SearchPOR.sendKeys(Exp);
			ActionsEdt.click();
			ViewRCV.click();
			Thread.sleep(3000);
			String Actual = Result.getText();
			Assert.assertEquals(Actual, Expected,"given Reference is not correct");
			System.out.println("given Reference is correct");
			
			
		}
		

}
