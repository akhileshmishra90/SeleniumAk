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
public class PO_WithCreditTerm {
	public static String amt;
	@FindBy(id ="poId")
	WebElement poIdEdt;
	@FindBy(id ="prdId_createpo")
	WebElement poSuppIdEdt;
	@FindBy(id ="po_crdtId-select")
	WebElement suppCrdEdt;
	@FindBy(id="prdPo_1")
	WebElement prdPo_1Edt;
	@FindBy(id="purQty_1")
	WebElement pqtyEdt;
@FindBy(xpath="//button[contains(.,'save')]")
	WebElement aftrqntOkEdt;
	@FindBy(id="unitprice")
	WebElement unitpriceEdt;
	@FindBy(xpath="//label[@data-bind='html: POInventory.netAmt']")
    WebElement getTotalAmount;
 @FindBy(id ="btnSave")
	WebElement btnSaveEdt;
	@FindBy(xpath="//p[contains(text(),'Purchase Order')]")
	WebElement saleConfirmMsgedt;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement ConfirmSaveedt;
    @FindBy(xpath="//input[@aria-controls='POTable']")
    WebElement searchtxt;
   @FindBy(xpath="//table[@id='POTable']/tbody/tr/td[2]")
   WebElement actval;
   public void PoWithCrdTerm(String Supp_Id,String Credit_Term ,String Product_Id,String Quantity,String unit_price,String taxCode ) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
   {
	   WebDriverCommonlib.waitForPageToLoad();
	   Actions act = new Actions(Browser.driver);
	   String exp = poIdEdt.getAttribute("value");
	   System.out.println(exp);
		  Thread.sleep(3000); 
	   poSuppIdEdt.sendKeys(Supp_Id);
	  Thread.sleep(1000); 
	  act.sendKeys(Keys.TAB).perform();
	   suppCrdEdt.clear();
	   suppCrdEdt.sendKeys(Credit_Term);
	   act.sendKeys(Keys.ARROW_DOWN).perform();
	   act.sendKeys(Keys.ENTER).perform();
	   JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
	   kl.executeScript("window.scrollBy(0,300)", "");
  prdPo_1Edt.sendKeys(Product_Id);
		Thread.sleep(1000); 
 	act.sendKeys(Keys.TAB).perform();
	    pqtyEdt.sendKeys(Quantity);
	 unitpriceEdt.sendKeys(unit_price);
 Browser.driver.findElement(By.xpath("//table[@id='PODetailsTable']/tbody/tr/td[9]/div/div/span[text()='Tax Details']")).click();
	  		
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
	   ConfirmSaveedt.click();
   Browser.driver.get(Constant.PurchaseMain);
	  Thread.sleep(7000);
        searchtxt.sendKeys(exp);
	   String act3 = actval.getText();
	    Assert.assertEquals(act3, exp,"Sale order with credit term  after saving case == fail");
  		System.out.println("Sales order with credit term  after saving case == pass");
	   
   }
}
	 
	
   


