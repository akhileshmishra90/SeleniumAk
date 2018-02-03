package com.Actouch.SalesINV.pageObjectRepository;

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
import com.Actouch.Sales.generic_Lib.SO_Excellib;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
public class SOMutiproduct {
	//multi product 
	public static String amt;
	@FindBy(id ="SoIsoId")
	WebElement SOidEdt;
	@FindBy(id ="createSoCustId")
	WebElement SoEdt;
	@FindBy(id="prdSo_1")
	WebElement prdSo_1Edt;
	@FindBy(xpath="//span[text()='Product Details']")
	WebElement prDetailsEdt;
	@FindBy(xpath="//input[@data-bind='checked: chkSelectAll ']")
	WebElement roleSelProdEdt;
	@FindBy(xpath="//table[@id='taxCalc']/tbody/tr[2]/td[12]/input")
	WebElement qntEdt;
	@FindBy(xpath="//button[contains(text(),'Ok')]")
	WebElement aftrqntOkEdt;
	@FindBy(xpath="//div[@id='creso-table']/div[1]/div/div[2]/label[contains(text(),'Add Row')]")
	WebElement AddRow;
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
public void multiproduct(String custID,String taxCode,String SecUOM ) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException 
	{
	SO_Excellib SO_Excellib = new SO_Excellib("E:\\ServerCode\\SaleOrder.xlsx");
WebDriverCommonlib.waitForPageToLoad();
Actions act = new Actions(Browser.driver);
		String exp =SOidEdt.getAttribute("value");
		 Thread.sleep(5000);
		SoEdt.sendKeys(custID);
		  	  Thread.sleep(1000);
  	      	act.sendKeys(Keys.TAB).perform();
		 	  	JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
		  	kl.executeScript("window.scrollBy(0,300)", "");
		  	int j = 1;
		  			int l=24;
		  	        int count = 1;
		  	        do {
		  	        	
		  	        	while (j < 5)
		  	   	{
String qty = SO_Excellib.getExcelDat("SO", l, 13);
		  	      			  	      String prdID = SO_Excellib.getExcelDat("SO", l, 10);
			  	   		Browser.driver.findElement(By.id("prdSo_"+j)).sendKeys(prdID);
		  	      			  	      	Thread.sleep(1000);
		  	      	act.sendKeys(Keys.TAB).perform();
		  	      String unitP = SO_Excellib.getExcelDat("SO", l, 16);
		  	      	Browser.driver.findElement(By.id("unitprice_"+j)).sendKeys(unitP);		  	      	
		 	if(j == 1)
		  	      		{
		  	             Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[5]/div/div[2]/span")).click();
				  			roleSelProdEdt.click();
				  			qntEdt.sendKeys(qty);
				  			aftrqntOkEdt.click();
	  	        		  		Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr/td[9]/div/div/span[text()='Tax Details']")).click();
	  	        		  			  	        				for(int i=1;i<10;i++)
	  	        		  {
	  	        		String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
	  						  if(count1.equals(taxCode)){
	  							Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
							  		Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();							  
							  	break;							  	
	  						  }
	  	        		  }
	  						  j++;
		  	      		break;
		  	      		}
		  	      		else if (j == 2)		  	      			
		  	      		{
try
	{
	Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[5]/div/div[2]/span")).click();
		  	        		  			roleSelProdEdt.click();
		  	        		  qntEdt.sendKeys(qty);
					  			aftrqntOkEdt.click();
		  	        		  }
	catch(Exception e)
	{
		Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr[2]/td[5]/div/div[1]/input")).sendKeys(qty);
	}	
	  j++;
		  	      			break;
		  	      		  	      }
		  	     else if(j == 3)
		      		{	      		  WebElement Ch=Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[5]/div/div[2]/span"));

	      		  boolean check = Ch.isDisplayed();
	      		  System.out.println(check);
	      		  boolean check1 = Ch.isEnabled();
	      		  System.out.println(check1);
	      		  Ch.click();
	      		  roleSelProdEdt.click();
	      		  	qntEdt.sendKeys(qty);
	      		  		Browser.driver.findElement(By.xpath("//input[@class='form-control createPO-suppId ui-autocomplete-input']")).sendKeys(SecUOM);
	      		  			act.sendKeys(Keys.ARROW_DOWN).perform();
	      		  				act.sendKeys(Keys.ENTER).perform();
	      		  aftrqntOkEdt.click();
	      		  			j++;
		      		break;
		      		}
		  	 else if(j == 4)
	   		{
	   		
	   		kl.executeScript("window.scrollBy(0,300)", "");
	   		Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[5]/div/div[2]/span")).click();
			  				roleSelProdEdt.click();
			  			qntEdt.sendKeys(qty);
			  			
			  	aftrqntOkEdt.click();
	j++;
	   		break;
	   		
	   		}
		  	 }
		  	     l++;
		  	        	      count++;
		  	          if(count < 5){
		  	        	AddRow.click();
		  	        	  
		  	          }
		  	 } while (count < 5);
		  	    amt = gettingTotalAmount.getText();
				btnSaveEdt.click();
		  		   ConfirmSaveedt.click();
		  		   Browser.driver.get(Constant.SalesMain);
		  		  Thread.sleep(7000);
		  		   // saleConfirmMsgedt.getText();
		  		  searchtxt.sendKeys(exp);
		  		   String act2 = actval.getText();
		  		    Assert.assertEquals(act2, exp,"multi product after saving case == fail");
		  	  		System.out.println("multi product after saving case == pass");
	}
}
