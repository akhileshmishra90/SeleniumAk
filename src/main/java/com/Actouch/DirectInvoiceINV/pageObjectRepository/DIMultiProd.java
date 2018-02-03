package com.Actouch.DirectInvoiceINV.pageObjectRepository;

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
import com.Actouch.Sales.generic_Lib.DI_Excellib;

import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class DIMultiProd {

	public static String amt;
	   @FindBy(id="SoIsoId")	
	   WebElement SOidEdt;
	   @FindBy(id="createDinvCustId")
	   WebElement DSOCustEdt;
	   @FindBy(id="prdSo_1")
	   WebElement PrDSO;
	   @FindBy(xpath="//div[@data-bind='if:chkLoc']/span[@class='label label-warning']")
	   WebElement peDetailsEdt;
	   @FindBy(name="roleFor")
		WebElement roleSelProdEdt;
		@FindBy(xpath="//table[@id='taxCalc']/tbody/tr[2]/td[12]/input")
		WebElement qntEdt;
		@FindBy(xpath="//button[contains(text(),'Ok')]")
		WebElement aftrqntOkEdt;
		@FindBy(xpath ="//div[@class='addbtn']")//xpath="//div[@id='creso-table']/div[1]/div/div[2]/label[contains(text(),'Add Row')]")
		WebElement AddRow;
	   @FindBy(xpath="//label[@data-bind='html: DIInventory.totalAmt']")
	   WebElement TotalEdt;
	   @FindBy(id="btnSave")
	   WebElement SaveEdt;
	   @FindBy(xpath="html/body/div[9]/div/div[3]/button")
	   WebElement AfterSaveEdt;
	   @FindBy(xpath="//input[@aria-controls='SHP_Table']")
	  WebElement Searchext;
	   @FindBy(xpath="//table[@id='SHP_Table']/tbody/tr[1]/td[3]")
	   WebElement ResultEdt;
	   public void payltr(String Customer_Id,String Product_Id,String Quantity,String unit_price,String taxCode,String SecUOM) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	   {
		   WebDriverCommonlib.waitForPageToLoad();
		   Actions act = new Actions(Browser.driver);
		    String exp = SOidEdt.getAttribute("value");
		    Thread.sleep(3000);
		    DSOCustEdt.sendKeys(Customer_Id);
		 Thread.sleep(1000);
		  act.sendKeys(Keys.TAB).perform();
		   JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
		   kl.executeScript("window.scrollBy(0,300)", "");
			int j = 1;
  			int l=18;
  	        int count = 1;
  	        do {
  	        	
  	        	while (j < 5)
  	   	{
String qty = DI_Excellib.getExcelDat("DII", l, 13);
  	      			  	      String prdID = DI_Excellib.getExcelDat("DII", l, 10);
	  	   		Browser.driver.findElement(By.id("prdSo_"+j)).sendKeys(prdID);
  	      			  	      	Thread.sleep(1000);
  	      	act.sendKeys(Keys.TAB).perform();
  	      String unitP = DI_Excellib.getExcelDat("DII", l, 16);
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
      		{
  		  WebElement Ch=Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[5]/div/div[2]/span"));
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
		  act.sendKeys(Keys.ENTER).perform();
		   amt = TotalEdt.getText();
		   SaveEdt.click();
		   AfterSaveEdt.click();
		  Browser.driver.get(Constant.newShpMain);
		  Thread.sleep(7000);
		  Searchext.sendKeys(exp);
		   String act2 = ResultEdt.getText();
		    Assert.assertEquals(act2, exp,"payment later after saving case == fail");
	  		System.out.println("payment later after saving case == pass");
		    }

}
