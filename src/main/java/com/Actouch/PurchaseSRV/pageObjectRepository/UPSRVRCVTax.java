package com.Actouch.PurchaseSRV.pageObjectRepository;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;

public class UPSRVRCVTax {

	@FindBy(xpath="//input[@aria-controls='POTable']")
	WebElement getPOID;
	@FindBy(xpath="//input[@aria-controls='POR_Table']")
	WebElement SearchPOR;
	@FindBy(xpath="//button[text()='Actions']")
	WebElement Action;
	@FindBy(linkText ="Update PO Receipt")
	WebElement ClickUpdate;
	@FindBy(xpath="//input[@data-bind='checked: chkSelectAll']")
	WebElement SelectProd;
	@FindBy(xpath="//span[@data-bind='click: showPOTaxModel']")
	WebElement TaxModelEdt;
	@FindBy(xpath="//input[@data-bind='value:lineTaxAmount ']")
	WebElement TaxAmtEdt;
	@FindBy(id="btnSave")
	WebElement Save;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement okEdt;
	@FindBy(linkText="View PO Receipt")
	WebElement ClickView;
	@FindBy(xpath="//label[@data-bind='text: lineTaxAmount']")
	WebElement Result;
	public void Supplier(String Newtaxcode) throws InterruptedException
	{
	    WebDriverCommonlib.waitForPageToLoad();
		String Exp=getPOID.getAttribute("value");
		Browser.driver.get(Constant.PorMain);
		Thread.sleep(3000);
		SearchPOR.sendKeys(Exp);
		Action.click();
		ClickUpdate.click();
		Thread.sleep(4000);
		SelectProd.click();
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
	    Save.click();
	    okEdt.click();
	    Thread.sleep(3000);
	    SearchPOR.sendKeys(Exp);
	    Action.click();
		ClickView.click();
		Thread.sleep(3000);
		String Actual=Result.getText();
		Assert.assertEquals(Actual, Expected,"supplier name is update not correct");
		System.out.println("Supplier name is correct");
			}
}
