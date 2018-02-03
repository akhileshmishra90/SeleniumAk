package com.Actouch.PurchaseINV.pageObjectRepository;
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
import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
public class ProductMultipleTax {	
	public static String amt;
	@FindBy(id ="poId")
	WebElement poIdEdt;
	@FindBy(id ="prdId_createpo")
	WebElement poSuppIdEdt;
	@FindBy(id="prdPo_1")
	WebElement prdPo_1Edt;
	@FindBy(xpath="//span[text()='Product Details']")
	WebElement prdDetailsEdt;
	@FindBy(xpath="//table[@id='batchId']/tbody/tr/td[9]/input")
	WebElement pqtyEdt;
@FindBy(xpath="//button[contains(text(),'save')]")
	WebElement aftrqntOkEdt;
	@FindBy(id="unitprice")
	WebElement unitpriceEdt;
	@FindBy(xpath="//table[@id='PODetailsTable']/tbody/tr/td[9]/div/div/span[text()='Tax Details']")
	WebElement Taxmodel;
	@FindBy(xpath="//button[@data-bind='click: ok']")
	WebElement AcceptCheck;
	@FindBy(id="payTypePO")
    WebElement payTypeEdt;
	@FindBy(xpath="//a[text()='Later']")
	WebElement payLaterEdt;
	@FindBy(xpath="//label[@data-bind='html: POInventory.netAmt']")
    WebElement getTotalAmount;
	@FindBy(id ="btnSave")
	WebElement btnSaveEdt;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement ConfirmSaveEdt;
    @FindBy(xpath="//input[@aria-controls='POTable']")
    WebElement searchtxt;
   @FindBy(xpath="//table[@id='POTable']/tbody/tr/td[2]")
   WebElement actval;
   public void ProdMultiTax(String Supp_Id,String Product_Id,String Quantity,String unit_price,String taxCode1,String taxCode2 ,String PayMentType ) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
   { 
	   String exp = poIdEdt.getAttribute("value");
	   Thread.sleep(3000);
	   poSuppIdEdt.sendKeys(Supp_Id);
	   Thread.sleep(1000);
   Actions act = new Actions(Browser.driver);
	   act.sendKeys(Keys.TAB).perform();
  JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
	   kl.executeScript("window.scrollBy(0,300)", "");
   prdPo_1Edt.sendKeys(Product_Id);
   Thread.sleep(1000);
	   act.sendKeys(Keys.TAB).perform();
	        	prdDetailsEdt.click();
	     pqtyEdt.sendKeys(Quantity);
	   aftrqntOkEdt.click();
	   Thread.sleep(1000);
	   unitpriceEdt.sendKeys(unit_price);
	   Taxmodel.click();
	   for(int i=1;i<12;i++)
		  {
		String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
			  if(count1.equals(taxCode1)){
				Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
				Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
			  
			  	break;
			  	
			  }
		  }
	   Taxmodel.click();
	for(int j=1;j<12;j++)
	 {
			  String count2=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+j+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
			  if(count2.equals(taxCode2)){
				  System.out.println(count2);
				Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+j+"]/td/input[@id ='chkTaxId']")).click();
				Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
			  
			  	break;
			  }
			  
	 }
	 	payTypeEdt.clear();
	 	payTypeEdt.sendKeys(PayMentType);
act.sendKeys(Keys.ARROW_DOWN).perform();
act.sendKeys(Keys.ENTER).perform();
	 	 amt = getTotalAmount.getText();
	   btnSaveEdt.click();
	   ConfirmSaveEdt.click();
	   Browser.driver.get(Constant.PurchaseMain);
	   Thread.sleep(7000);
	  searchtxt.sendKeys(exp);
	    String act2 = actval.getText();
	     Assert.assertEquals(act2, exp,"product multiple tax after saving case == fail");
  		System.out.println("product multiple tax saving case == pass");
	   
   }
	
	
   }
   