package com.Actouch.SalesQuotation.pageObjectRepository;

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


public class SqReceiveAdvPettyShp {
	//receiving Advanced with petty cash
	public static String amt; 
	@FindBy(id ="SoIsoId")
	WebElement SOidEdt;
	@FindBy(id ="createSoCustId")
	WebElement SoCustIdEdt;
	@FindBy(id ="SoIshipMaterials-select")
	WebElement ShipNow;
	
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
	@FindBy(id="chkAdv1")
	WebElement SelectAdv;
	@FindBy(id="advAmt")
	WebElement EnterAmount;
	@FindBy(id="SoIpayMode-select")
	WebElement paytype;
	
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
	public void RcvAdvPttyshp(String Customer_Id,String Product_Id,String Quantity,String unit_price,String taxCode,String Adv_money  ) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
	   
	 
		
	   
		
	   
	   String exp = SOidEdt.getAttribute("value");
	
	   System.out.println(exp);
	   Thread.sleep(3000);
	   SoCustIdEdt.sendKeys(Customer_Id);
	   Thread.sleep(3000);
	   Actions act = new Actions(Browser.driver);
	      	act.sendKeys(Keys.TAB).perform();
	   Thread.sleep(1000);
	   ShipNow.clear();
	   ShipNow.sendKeys("Yes");
	   Thread.sleep(200);
		 act.sendKeys(Keys.ARROW_DOWN).perform();
		 Thread.sleep(200);
		 act.sendKeys(Keys.ENTER).perform();
		 Thread.sleep(200);
	   
	   JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
	   kl.executeScript("window.scrollBy(0,300)", "");
	 prdSo_1Edt.sendKeys(Product_Id);
	   Thread.sleep(1000);
	   
	 	act.sendKeys(Keys.TAB).perform();
	   
	 	Thread.sleep(1000);
	   prDetailsEdt.click();
	   Thread.sleep(3000);
	   roleSelProdEdt.click();
	   Thread.sleep(1000);
	   qntEdt.sendKeys(Quantity);
	   aftrqntOkEdt.click();
	 unitprice_1edt.sendKeys(unit_price);
	 Thread.sleep(200);
	   
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
	   
	 SelectAdv.click();
	 EnterAmount.sendKeys(Adv_money);
	 paytype.clear();
	 paytype.sendKeys("petty");
	 Thread.sleep(200);
	 act.sendKeys(Keys.ARROW_DOWN).perform();
	 Thread.sleep(200);
	 act.sendKeys(Keys.ENTER).perform();
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
	   String act2 = actval.getText();
	    Assert.assertEquals(act2, exp,"Receive Advanced pettty cash shipment after saving case == fail");
			System.out.println("Receive Advanced petty cash shipment after saving case == pass");
	   


	}

}
