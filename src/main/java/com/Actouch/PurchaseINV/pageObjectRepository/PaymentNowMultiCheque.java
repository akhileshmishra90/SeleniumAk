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
public class PaymentNowMultiCheque {
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
		@FindBy(xpath="//table[@id='taxCalc']/tbody/tr[1]/td[1]/input")
		WebElement chequeNo1;
		@FindBy(xpath="//table[@id='taxCalc']/tbody/tr[2]/td[1]/input")
		WebElement chequeNo2;
		@FindBy(xpath="//label[@data-bind='html: TotalAmount']")
	    WebElement getTotalAmount;
		@FindBy(xpath="//table[@id='taxCalc']/tbody/tr[1]/td[5]/input")
	    WebElement setTotalAmount1;
		@FindBy(xpath="//table[@id='taxCalc']/tbody/tr[2]/td[5]/input")
	    WebElement setTotalAmount2;
		@FindBy(xpath="//button[@id='btnAddDetail']")
		WebElement addNewChq;		
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
	   public void payNowMultiCheque (String Supp_Id,String prod_id,String Quantity,String unit_price,String PayMentType,String BankName,String ChequeNo1, String ChequeNo2) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException

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
	  	   Thread.sleep(1000);
	  	    act.sendKeys(Keys.TAB).perform();
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
	  			 amt =  getTotalAmount.getText();
	  		  	double a1 = 0; 
	  		  	 if(!amt.equals("")){
	  		  		 a1 = Double.valueOf(amt); 
	  		  	 }
	  		  			double amt1 = a1/2;
  				String amount1 =Double.toString(amt1);	  				
	  				chequeNo1.sendKeys(ChequeNo1);  				
	  				setTotalAmount1.clear();
	  				setTotalAmount1.sendKeys(amount1);	  				
	  				addNewChq.click();	  				
	  				chequeNo2.sendKeys(ChequeNo2);	  				
	  				setTotalAmount2.sendKeys(amount1);	  				
	  				savingCheq.click();
		btnSaveEdt.click();
	  			ConfirmSaveedt.click();	  			
	  			Browser.driver.get(Constant.PurchaseMain);
	  			Thread.sleep(7000);
	  			searchtxt.sendKeys(exp);
	  			String act2 = actval.getText();	  		   
	  		    Assert.assertEquals(act2, exp,"payment Now with multi cheque after saving case == fail");
	  	  		System.out.println("payment Now with multi cheque after saving case == pass");	  			
	     }
}
