package com.Actouch.SalesINV.pageObjectRepository;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
public class SOPaymentNowMultiCheque {
	public static String amt;
	@FindBy(id ="SoIsoId")
	WebElement SOidEdt;
	@FindBy(id ="createSoCustId")
	WebElement SoEdt;
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
	@FindBy(id="payType")
    WebElement payTypeEdt;
	@FindBy(xpath="//a[contains(text(),'Now')]")
	WebElement paynowEdt;
	@FindBy(id="SoIpayMode-select")
	WebElement paytype;
	@FindBy(xpath="//label[@data-bind ='html: SOInventory.totalAmt']")
	WebElement gettingTotalAmount;
	@FindBy(xpath="//button[@id='btnAddDetail']")
	WebElement addNewChq;
	@FindBy(xpath="//input[@data-bind='value: ChequeNo,hasfocus:true']")
	   WebElement chequeNo1;
	@FindBy(xpath="//input[@data-bind='value: recvdbankName,enable: hasColumn']")
	WebElement recvdbankName;
	@FindBy(xpath="//table[@id='taxCalc']/tbody/tr[2]/td[1]/input")
	WebElement chequeNo2;
	@FindBy(xpath="//table[@id='taxCalc']/tbody/tr[2]/td[2]/input")
	WebElement recvdbankName1;
	@FindBy(xpath="//table[@id='taxCalc']/tbody/tr[1]/td[5]/input")
    WebElement puttingTotalAmount;
	@FindBy(xpath="//table[@id='taxCalc']/tbody/tr[2]/td[5]/input")
	WebElement puttingTotalAmount1;
    @FindBy(xpath="//button[@data-bind='click: ok']")
	WebElement savingcheq;
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
   public void payNowMultCheque (String Customer_Id,String prod_id,String Quantity,String unit_price,String PayMentType,String BankName,String ChequeNo, String RecvdbankName,String ChequeNo2,String Recvbank2 ) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
    	 WebDriverCommonlib.waitForPageToLoad();
    	 Actions act= new Actions(Browser.driver);
    	 String exp = SOidEdt.getAttribute("value");
    	 System.out.println(exp);
    	 Thread.sleep(5000);
    	  SoEdt.sendKeys(Customer_Id);
    Thread.sleep(1000);
    	 act.sendKeys(Keys.TAB).perform();
    	JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
	  	kl.executeScript("window.scrollBy(0,300)", "");
	 	prdSo_1Edt.sendKeys(prod_id);
	 	Thread.sleep(2000);
	 	act.sendKeys(Keys.TAB).perform();
		      	prDetailsEdt.click();
  			roleSelProdEdt.click();
  		qntEdt.sendKeys(Quantity);
  			aftrqntOkEdt.click();
  			unitprice_1edt.sendKeys(unit_price);
  		payTypeEdt.clear();
 payTypeEdt.sendKeys(PayMentType);
  	paynowEdt.click();
  	 amt =  gettingTotalAmount.getText();
  			paytype.clear();
  			paytype.sendKeys(BankName);
  			act.sendKeys(Keys.ARROW_DOWN).perform();
  	  		act.sendKeys(Keys.ENTER).perform();
  			
 double a1 = 0; 
 		  	 if(!amt.equals("")){
 		  		 a1 = Double.valueOf(amt); 
 		  	 }
 		  			double amt1 = a1/2;
 		  			String amount1 =Double.toString(amt1);
 		chequeNo1.sendKeys(ChequeNo);
 		recvdbankName.sendKeys(RecvdbankName);
 	  	puttingTotalAmount.clear();
 	  		puttingTotalAmount.sendKeys(amount1);
 	  	addNewChq.click();
 			chequeNo2.sendKeys(ChequeNo2);
 				recvdbankName1.sendKeys(Recvbank2);
 			puttingTotalAmount1.clear();
 		puttingTotalAmount1.sendKeys(amount1);
 		savingcheq.click();
  		btnSaveEdt.click();
  		   ConfirmSaveedt.click();
  		 Browser.driver.get(Constant.SalesMain);
  		  Thread.sleep(7000);
  		   // saleConfirmMsgedt.getText();
  		  searchtxt.sendKeys(exp);
  		   String act2 = actval.getText();
  		    Assert.assertEquals(act2, exp,"payment Now with single cheque after saving case == fail");
  	  		System.out.println("payment Now with single cheque after saving case == pass");
  	 }
	
}


	


