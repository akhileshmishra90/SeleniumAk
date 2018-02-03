package com.Actouch.DirectReceiptINV.pageObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Actouch.Purchase.generic_Lib.Browser;

public class UPDRTaxCode {

	 public static String amt;
	    @FindBy(xpath="//input[@aria-controls='POR_Table']")
		WebElement SerchPor;
	    @FindBy(xpath="//button[text()='Actions']")
	    WebElement Action;
	    @FindBy(linkText="Update PO Receipt")
	    WebElement UpdateReceipt;
	    @FindBy(xpath="//span[@data-bind='click: showPOTaxModel']")
	    WebElement TaxDetail;
	    @FindBy(xpath="//input[@data-bind='value:lineTaxAmount ']") 
	    WebElement UPTaxValueEdt;
	    @FindBy(xpath="//label[@data-bind='html: DPInventoryUpd.netAmt']")
	    WebElement Total;
	    @FindBy(id="btnSave")
	    WebElement Save;
	    @FindBy(xpath="html/body/div[9]/div/div[3]/button")
	    WebElement OkEdt;
	    @FindBy(linkText="View PO Receipt")
	    WebElement ViewReceipt;
	    @FindBy(xpath="//label[@data-bind='text : lineTaxAmount']")
	    WebElement Result;
	    public void SuppID (String UPTaxCode) throws InterruptedException
	    {
	 	   WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
	 	   Actions act= new Actions(Browser.driver);
	 	   String PORID =SerchPor.getAttribute("value");
	 	   wait.until(ExpectedConditions.visibilityOf(Action));
	 	   act.moveToElement(Action).click().perform();
	 	   wait.until(ExpectedConditions.visibilityOf(UpdateReceipt));
	 	   act.moveToElement(UpdateReceipt).click().perform();
	 	   wait.until(ExpectedConditions.visibilityOf(TaxDetail));
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
			  if(count1.equals(UPTaxCode)){
				Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
				Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
			  
			  	break;
			  	
			  }
		  }
		String  Expected =UPTaxValueEdt.getAttribute("value") ;
	 	 act.sendKeys(Keys.ENTER).perform();
	 	  amt=Total.getText();
	 	   Save.click();
	 	   OkEdt.click();
	 	   wait.until(ExpectedConditions.visibilityOf(SerchPor));
	 	   SerchPor.sendKeys(Keys.chord(Keys.CONTROL,"a"),PORID);
	 	   wait.until(ExpectedConditions.visibilityOf(Action));
	 	   act.moveToElement(Action).click().perform();
	 	   wait.until(ExpectedConditions.visibilityOf(ViewReceipt));
	 	   act.moveToElement(ViewReceipt).click().perform();
	 	   wait.until(ExpectedConditions.visibilityOf(Result));
	 	   String Actual = Result.getText();
	 	   Assert.assertEquals(Actual, Expected,"Supp Name not updated as Usual");
	 	   System.out.println("Supp Name  updated as Usual");
	    }

}
