package com.Actouch.DirectInvoiceServ.pageObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class UPDSRVTax {

	@FindBy(xpath="//input[@aria-controls='SOTable']")
	WebElement TextEdt;
	@FindBy(xpath="//input[@aria-controls='SHP_Table']")
	WebElement SerchTextEdt;
	@FindBy(xpath="//button[text()='Actions']")
	WebElement ClickForUpdate;
	@FindBy(linkText ="Update Invoice")
	WebElement openForUpdatePage;
	@FindBy(xpath="//span[@data-bind='click: showSOTaxModel']")
	WebElement TaxModelEdt;
	@FindBy(xpath="//input[@data-bind='value:lineTaxAmount ']")
	WebElement TaxAmtEdt;
	@FindBy(id="btnSaveSO")
	WebElement UpdateEdt;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement AfterSave;
	@FindBy(linkText="View Invoice")
	WebElement clickforView;
	@FindBy(xpath="//label[@data-bind='html:soShipment.custName']")
	WebElement Result;
	public void upadateCust(String Newtaxcode) throws InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
	   String SoId=SerchTextEdt.getAttribute("value");
	    ClickForUpdate.click();
	    openForUpdatePage.click();
	    Thread.sleep(4000);
	    TaxModelEdt.click();
	    List<WebElement> els = Browser.driver.findElements(By.id("chkTaxId"));
	    for(WebElement elw :els)
	    {
	    	if(elw.isSelected())
	    	{
	    		elw.click();
	    	}
	    }
	    Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
	    TaxModelEdt.click();
			
		 for(int i=1;i<10;i++)
		  {
		String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
			  if(count1.equals(Newtaxcode)){
				Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
				Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
			  
			  	break;
			  	
			  }
		  }
	
	    String Expected = TaxAmtEdt.getAttribute("value");
	    UpdateEdt.click();
	    AfterSave.click();
	    SerchTextEdt.sendKeys(SoId);
	    ClickForUpdate.click();
	    clickforView.click();
	    Thread.sleep(3000);
	   String Actual= Result.getText();
	   Assert.assertEquals(Actual, Expected,"given customer name is invalid");
	System.out.println("given Customer name is valid");
	}
		
}
