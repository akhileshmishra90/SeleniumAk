package com.Actouch.SalesQuotation.pageObjectRepository;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;


public class SQWithCreditTerm {
	//So with credit term
	public static String amt;
	@FindBy(id ="SoIsoId")
	WebElement SOidEdt;
	@FindBy(id ="createSoCustId")
	WebElement SoCustIdEdt;
	@FindBy(id ="SoIshipMaterials-select")
	WebElement ShipNow;
	@FindBy(id="SoIcrdtTerm-select")
	WebElement CreditTerm;
	
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
	@FindBy(xpath="//label[@data-bind='html: SOInventory.totalAmt']")
    WebElement gettingTotalAmount;

  @FindBy(id ="btnSave")
	WebElement btnSaveEdt;
	@FindBy(xpath="//p[contains(text(),'Sales Order')]")
	WebElement saleConfirmMsgedt;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement ConfirmSaveedt;
    @FindBy(xpath="//input[@aria-controls='SOTable']")
    WebElement searchtxt;
   @FindBy(xpath="//table[@id='SOTable']/tbody/tr/td[2]")
   WebElement actval;
   public void SoWithCrdTerm(String Customer_Id,String Credit_Term ,String Product_Id,String Quantity,String unit_price,String taxCode ) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
   {
	     
	   String exp = SOidEdt.getAttribute("value");
	   System.out.println(exp);
	   Thread.sleep(3000);
	   SoCustIdEdt.sendKeys(Customer_Id);
	   Thread.sleep(3000);
	   Actions act = new Actions(Browser.driver);
	      	act.sendKeys(Keys.TAB).perform();
	   Thread.sleep(1000);
	  CreditTerm.clear();
	  CreditTerm.sendKeys(Credit_Term);
	  Thread.sleep(3000);
	   Actions act2 = new Actions(Browser.driver);
	      	act2.sendKeys(Keys.ARROW_DOWN).perform();
	   Thread.sleep(1000);
	   act2.sendKeys(Keys.ENTER).perform();
	   
	   ShipNow.clear();
	   ShipNow.sendKeys("Yes");
	Thread.sleep(200);
	act.sendKeys(Keys.ARROW_DOWN).perform();
	Thread.sleep(200);
	act.sendKeys(Keys.ENTER).perform();
	Thread.sleep(100);
	   
	   JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
	   kl.executeScript("window.scrollBy(0,300)", "");
	 Thread.sleep(1000);
	   prdSo_1Edt.sendKeys(Product_Id);
	   Thread.sleep(1000);
	   
     	act.sendKeys(Keys.TAB).perform();
	   
     	Thread.sleep(3000);
	   prDetailsEdt.click();
	   Thread.sleep(3000);
	   roleSelProdEdt.click();
	   Thread.sleep(1000);
	   qntEdt.sendKeys(Quantity);
	   aftrqntOkEdt.click();
	 unitprice_1edt.sendKeys(unit_price);

	 Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr/td[9]/div/div/span[text()='Tax Details']")).click();
	  		Thread.sleep(2000);
	   for(int i=1;i<10;i++)
		  {
		String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
			  if(count1.equals(taxCode)){
				Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
				Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
			  
			  	break;
			  	
			  }
		  }
	  
	   Thread.sleep(1000);
		amt = gettingTotalAmount.getText();
		Thread.sleep(2000);
    
	 
 btnSaveEdt.click();
	   ConfirmSaveedt.click();
	   Thread.sleep(1000);
	   Browser.driver.get(Constant.SalesMain);
	  Thread.sleep(7000);
	   // saleConfirmMsgedt.getText();
	    searchtxt.sendKeys(exp);
	   String act3 = actval.getText();
	    Assert.assertEquals(act3, exp,"Sale order with credit term  after saving case == fail");
  		System.out.println("Sales order with credit term  after saving case == pass");
	   
   }
}
	 
	
   


