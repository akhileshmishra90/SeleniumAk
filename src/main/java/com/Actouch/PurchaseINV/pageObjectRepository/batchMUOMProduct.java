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
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;

public class batchMUOMProduct {
	public static String amt;
	@FindBy(id ="poId")
	WebElement poIdEdt;
	@FindBy(id ="prdId_createpo")
	WebElement poSuppIdEdt;
	@FindBy(id="prdPo_1")
	WebElement prdPo_1Edt;
	@FindBy(xpath="//span[text()='Product Details']")
	WebElement prdDetailsEdt;
	@FindBy(id="batchNo")
	WebElement batchNoEdt;
	@FindBy(xpath="//table[@id='batchId']/tbody/tr/td[5]/span[2]/input")
	WebElement secUom;	
	@FindBy(xpath="//table[@id='batchId']/tbody/tr/td[6]/input")
	WebElement sqtyEdt;	
	@FindBy(xpath="//table[@id='batchId']/tbody/tr/td[9]/input")
	WebElement pqtyEdt;
	@FindBy(xpath="//label[@data-bind='html: POInventory.netAmt']")
    WebElement getTotalAmount;
	@FindBy(xpath="//button[contains(.,'save')]")
	WebElement aftrqntSaveEdt;	
	@FindBy(id="unitprice")
	WebElement unitpriceEdt;
	 @FindBy(xpath="//table[@id='PODetailsTable']/tbody/tr/td[9]/div/div/span[text()='Tax Details']")
	 WebElement Taxmodel;
	@FindBy(id ="btnSave")
	WebElement btnSaveEdt;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement ConfirmOkEdt;
    @FindBy(xpath="//input[@aria-controls='POTable']")
    WebElement searchPOidTxt;
    @FindBy(xpath="//table[@id='POTable']/tbody/tr/td[2]")
    WebElement actval;
	
	@FindBy(xpath="//p[contains(text(),'Purchase Order')]")
	WebElement saleConfirmMsgedt;
	
   public void muomBatchprod(String Supp_Id,String Product_Id,String batchNo,String secUOM,String secQty,String primQty,String unitPrice,String taxCode) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
   {
	   
    WebDriverCommonlib.waitForPageToLoad();
    Actions act = new Actions(Browser.driver);
	   String exp = poIdEdt.getAttribute("value");
	   Thread.sleep(3000);
	   poSuppIdEdt.sendKeys(Supp_Id);
	   Thread.sleep(1000);
 act.sendKeys(Keys.TAB).perform();
JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
	   kl.executeScript("window.scrollBy(0,300)", "");
	   prdPo_1Edt.sendKeys(Product_Id);
	   Thread.sleep(1000);
	     act.sendKeys(Keys.TAB).perform();
 prdDetailsEdt.click();
	   batchNoEdt.sendKeys(batchNo);
	   secUom.sendKeys(secUOM);
	   act.sendKeys(Keys.ARROW_DOWN).perform();
	   act.sendKeys(Keys.ENTER).perform();
 sqtyEdt.sendKeys(secQty);
pqtyEdt.sendKeys(primQty);
 aftrqntSaveEdt.click();
	   Thread.sleep(1000);
	   unitpriceEdt.sendKeys(unitPrice);	 
	   Taxmodel.click();
 for(int i=1;i<10;i++)
		  {
		String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
			  if(count1.equals(taxCode)){
				Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
				Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();			  
			  	break;			  	
			  }
		  }
	   act.sendKeys(Keys.ENTER).perform();
	   amt = getTotalAmount.getText();
	  	btnSaveEdt.click();
	  	ConfirmOkEdt.click();
  Browser.driver.get(Constant.PurchaseMain);
	   Thread.sleep(7000);
	   searchPOidTxt.sendKeys(exp);
	   String act2 = actval.getText();
	   
	    Assert.assertEquals(act2, exp,"MUOM product after saving PO == FAIL");
  		System.out.println("MUOM product after saving PO == PASS");
	   

   }
}
