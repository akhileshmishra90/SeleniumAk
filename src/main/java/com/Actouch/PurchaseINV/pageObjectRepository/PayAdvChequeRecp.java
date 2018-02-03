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

public class PayAdvChequeRecp {
	// Receive Advanced by check including tax and shipment now
	public static String amt;
	@FindBy(id ="poId")
	WebElement poIdEdt;
	@FindBy(id ="prdId_createpo")
	WebElement poSuppIdEdt;
	@FindBy(id ="receiveMaterial-select")
	WebElement RecvNow;
	@FindBy(xpath="//a[contains(text(),' Yes')]")
	WebElement RecvStatus;
	@FindBy(id="prdPo_1")
	WebElement prdPo_1Edt;
	@FindBy(xpath="//span[text()='Product Details']")
	WebElement prdDetailsEdt;
	@FindBy(xpath="//table[@id='batchId']/tbody/tr/td[9]/input")
	WebElement qntEdt;
	@FindBy(xpath="//button[contains(.,'save')]")
	WebElement aftrqntSaveEdt;
	@FindBy(id="unitprice")
	WebElement unitpriceEdt;
	@FindBy(xpath="//table[@id='PODetailsTable']/tbody/tr/td[9]/div/div/span[text()='Tax Details']")
	WebElement Taxmodel;
	@FindBy(id="chkAdv1")
	WebElement SelectAdv;
	@FindBy(id="advAmt")
	WebElement EnterAmount;
	@FindBy(id="payMode1-select")
	WebElement paytype;
	@FindBy(xpath="//a[contains(text(),'SBI')]")
	WebElement genecheque;
	@FindBy(xpath="//input[@data-bind='value: ChequeNo,hasfocus:true']")
	WebElement chequeNo;
	@FindBy(xpath="//button[@data-bind='click: ok']")
	WebElement savingcheq;
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
	public void RcvAdvChequeRecp(String Customer_Id,String Product_Id,String Quantity,String unit_price,String taxCode,String Adv_money,String ChequeNo) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
     WebDriverCommonlib.waitForPageToLoad();
	    Actions act = new Actions(Browser.driver);
		String exp = poIdEdt.getAttribute("value");
 Thread.sleep(3000);
	   poSuppIdEdt.sendKeys(Customer_Id);
	   Thread.sleep(1000);
	   act.sendKeys(Keys.TAB).perform();
	   RecvNow.clear();
	   RecvNow.sendKeys("Yes");
	   RecvStatus.click();
	    JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
	   kl.executeScript("window.scrollBy(0,300)", "");
	   prdPo_1Edt.sendKeys(Product_Id);
	   Thread.sleep(1000);
	  act.sendKeys(Keys.TAB).perform();
	   prdDetailsEdt.click();	  
	   qntEdt.sendKeys(Quantity);
	   aftrqntSaveEdt.click();
	   Thread.sleep(1000);
	 unitpriceEdt.sendKeys(unit_price);
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
 SelectAdv.click();
	 EnterAmount.sendKeys(Adv_money);
	 paytype.clear();
	 paytype.sendKeys("SBI");
	 genecheque.click();
	 chequeNo.sendKeys(ChequeNo);
	 savingcheq.click();
	   btnSaveEdt.click();
	   ConfirmSaveedt.click();
	   Browser.driver.get(Constant.PurchaseMain);
	  Thread.sleep(7000);
   searchtxt.sendKeys(exp);
	   String act2 = actval.getText();
	    Assert.assertEquals(act2, exp,"Receive Advanced Cheque with Shipment after saving case == fail");
			System.out.println("Receive Advanced Cheque with Shipment after saving case == pass");
	   }

}
	
	
	


