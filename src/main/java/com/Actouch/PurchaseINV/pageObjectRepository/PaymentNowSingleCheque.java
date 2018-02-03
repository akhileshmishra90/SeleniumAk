package com.Actouch.PurchaseINV.pageObjectRepository;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;
public class PaymentNowSingleCheque {
	//payment now with cheque & tax
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
	@FindBy(xpath="//button[contains(.,'save')]")
	WebElement aftrqntSaveEdt;
	@FindBy(id="unitprice")
	WebElement unitpriceEdt;	
	@FindBy(id="payTypePO")
    WebElement payTypeEdt;
		@FindBy(id="payMode2-select")
	WebElement payMode;	
	@FindBy(xpath="//input[@data-bind='value: ChequeNo,hasfocus:true']")
	WebElement chequeNo;
	@FindBy(xpath="//label[@data-bind='html: POInventory.netAmt']")
    WebElement getTotalAmount;
	@FindBy(xpath="//input[@data-bind='value: Amount']")
    WebElement setTotalAmount;
    @FindBy(xpath="//button[@data-bind='click: ok']")
	WebElement savingCheq;
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
   public void payNowCheque (String Supp_Id,String prod_id,String Quantity,String unit_price,String PayMentType ,String BankName,String ChequeNo) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException

     {
   WebDriverCommonlib.waitForPageToLoad();
    			 String exp = poIdEdt.getAttribute("value");
  	   Thread.sleep(3000);
  	   poSuppIdEdt.sendKeys(Supp_Id);
  	   Thread.sleep(1000);
  	   Actions act = new Actions(Browser.driver);
  	   act.sendKeys(Keys.TAB).perform();
  	    JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
  	   kl.executeScript("window.scrollBy(0,300)", "");
  	   prdPo_1Edt.sendKeys(prod_id);
  	   Thread.sleep(2000);
  	   Actions act1 = new Actions(Browser.driver);
  	   act1.sendKeys(Keys.TAB).perform();
  	  prdDetailsEdt.click();
  	   pqtyEdt.sendKeys(Quantity);
  	   aftrqntSaveEdt.click();
  	   Thread.sleep(1000);
  	   unitpriceEdt.sendKeys(unit_price);
	payTypeEdt.clear();
			payTypeEdt.sendKeys(PayMentType); 			
			act.sendKeys(Keys.ARROW_DOWN).perform();
  			act.sendKeys(Keys.ENTER).perform();
  			payMode.clear();
  			payMode.sendKeys(BankName);  			
  			act.sendKeys(Keys.ARROW_DOWN).perform();
  			act.sendKeys(Keys.ENTER).perform();
  			chequeNo.sendKeys(ChequeNo);
  		//	 setTotalAmount.sendKeys(amt);
  		savingCheq.click();
  		act.sendKeys(Keys.ENTER).perform();
  			amt =  getTotalAmount.getText();
  		  	btnSaveEdt.click();
  		   ConfirmSaveedt.click();
     Browser.driver.get(Constant.PurchaseMain);
  		  Thread.sleep(7000); 		   
  		  searchtxt.sendKeys(exp);
  		   String act2 = actval.getText(); 		   
  		    Assert.assertEquals(act2, exp,"payment Now with single cheque after saving case == fail");
  	  		System.out.println("payment Now with single cheque after saving case == pass");
  			}
	
}

