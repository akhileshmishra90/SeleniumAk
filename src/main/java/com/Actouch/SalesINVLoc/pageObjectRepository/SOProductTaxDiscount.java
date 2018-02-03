package com.Actouch.SalesINVLoc.pageObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;

import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class SOProductTaxDiscount {
   // product with tax with Discount 
	public static String amt;
	@FindBy(id ="SoIsoId")
	WebElement SOidEdt;
	@FindBy(id ="createSoCustId")
	WebElement SoCustIdEdt;
	@FindBy(id="prdSo_1")
	WebElement prdSo_1Edt;
	@FindBy(xpath="//span[text()='Product Details']")
	WebElement prDetailsEdt;
	@FindBy(xpath="//input[@data-bind=' value: lineDisc']")
	WebElement lineDiscount;
	@FindBy(xpath=".//*[@id='taxCalc']/tbody/tr/td[1]/input[@data-bind ='checked: chkSelectAll ']")
	WebElement roleSelProdEdt;
	@FindBy(xpath=".//*[@id='taxCalc']/tbody/tr/td[13]/input")
	WebElement qntEdt;
	@FindBy(xpath="//button[contains(text(),'Ok')]")
	WebElement aftrqntOkEdt;
	@FindBy(id="unitprice_1")
	WebElement unitprice_1edt;
	@FindBy(id="payType")
    WebElement payTypeEdt;
	@FindBy(xpath="//a[text()='Later']")
	WebElement payLaterEdt;
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
   public void ProdTaxDis(String Customer_Id,String Product_Id,String Quantity,String unit_price,String Discount,String taxCode1,String taxCode2 ,String PayMentType  ) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
   {
	   WebDriverCommonlib.waitForPageToLoad();
	   Actions act = new Actions(Browser.driver);
	   String exp = SOidEdt.getAttribute("value");
	    Thread.sleep(5000);
	    SoCustIdEdt.sendKeys(Customer_Id);
	   Thread.sleep(1000);
	   	act.sendKeys(Keys.TAB).perform();
	  JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
	   kl.executeScript("window.scrollBy(0,300)", "");
	 prdSo_1Edt.sendKeys(Product_Id);
	   Thread.sleep(2000);
     	act.sendKeys(Keys.TAB).perform();
	    prDetailsEdt.click();
	    roleSelProdEdt.click();
	   
	   qntEdt.sendKeys(Quantity);
	   aftrqntOkEdt.click();
	 unitprice_1edt.sendKeys(unit_price);
	   payTypeEdt.clear();
	 String Dis = lineDiscount.getAttribute("value");
	  
	 if(Dis.equals("0"))
	  {
	    lineDiscount.clear();
		  lineDiscount.sendKeys(Discount);
  }
	   Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr/td[9]/div/div/span[text()='Tax Details']")).click();
	  		 for(int i=1;i<10;i++)
		  {
		String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
			  if(count1.equals(taxCode1)){
				Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
				Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
			  
			  	break;
			  	
			  }
		  }
	
	   payTypeEdt.sendKeys(PayMentType);
	   payLaterEdt.click();
	   amt = gettingTotalAmount.getText();
	 btnSaveEdt.click();
	   ConfirmSaveedt.click();
	    Browser.driver.get(Constant.SalesMain);
	  Thread.sleep(7000);
	 
	    searchtxt.sendKeys(exp);
	   String act2 = actval.getText();
	    Assert.assertEquals(act2, exp,"product tax discount  after saving case == fail");
  		System.out.println("product tax discount after saving case == pass");
	   
   }
	
	
   }

