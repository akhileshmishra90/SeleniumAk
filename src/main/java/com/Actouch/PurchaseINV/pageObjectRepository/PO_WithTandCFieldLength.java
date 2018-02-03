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
public class PO_WithTandCFieldLength {
	public static String amt;
	@FindBy(id ="poId")
	WebElement poIdEdt;
	@FindBy(id ="prdId_createpo")
	WebElement poSuppIdEdt;
	@FindBy(id="prdPo_1")
	WebElement prdPo_1Edt;
	@FindBy(id="purQty_1")
	WebElement pqtyEdt;
	@FindBy(xpath="//button[contains(.,'save')]")
	WebElement aftrqntSaveEdt;
	@FindBy(id="unitprice")
	WebElement unitpriceEdt;
	@FindBy(id="payTypePO")
    WebElement payTypeEdt;
	@FindBy(xpath="//a[text()='Later']")
	WebElement payLaterEdt;
	@FindBy(xpath="//div[@data-bind='click: POInventory.showTermsConditionModal']")
	WebElement clickTCbtn;
	@FindBy(xpath="//textarea[@placeholder='Terms and Conditions']")
	WebElement tcEdt;
	@FindBy(xpath="	//button[@data-bind='click: ok']")
	WebElement clickOk;
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
   public void PoWithTC (String Supp_Id,String Product_Id,String Quantity,String unit_price,String taxCode,String PayMentType,String tc) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
   {  	  
	    
	   WebDriverCommonlib.waitForPageToLoad();
	   int actTClength= 4950;	
	   String exp = poIdEdt.getAttribute("value");
	   System.out.println(exp);
	   Thread.sleep(3000);
	   poSuppIdEdt.sendKeys(Supp_Id);
	   Thread.sleep(3100);	   
	   Actions act = new Actions(Browser.driver);
	   act.sendKeys(Keys.TAB).perform();   
	   JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
	   kl.executeScript("window.scrollBy(0,300)", "");
	   prdPo_1Edt.sendKeys(Product_Id);
	   Thread.sleep(1000);
	    Actions act1 = new Actions(Browser.driver);
	   act1.sendKeys(Keys.TAB).perform();	   
	   pqtyEdt.sendKeys(Quantity);
	    unitpriceEdt.sendKeys(unit_price);
	   Browser.driver.findElement(By.xpath("//table[@id='PODetailsTable']/tbody/tr/td[9]/div/div/span[text()='Tax Details']")).click();
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
	 payTypeEdt.clear();
	   payTypeEdt.sendKeys(PayMentType);
	   payLaterEdt.click();
	   clickTCbtn.click();
	   Thread.sleep(2000);
	   tcEdt.sendKeys(tc);	   	   
	   String TC = tcEdt.getAttribute("value");
	   int i= TC.length();	  
	   clickOk.click();
	   amt = getTotalAmount.getText();
	   btnSaveEdt.click();
	   ConfirmSaveEdt.click();
	   Browser.driver.get(Constant.PurchaseMain);
	   Thread.sleep(7000);
	   searchtxt.sendKeys(exp);
	 //  String act2 = actval.getText();	    
	   Assert.assertTrue(i <= actTClength,"TC field value should be less than 4950 characters == fail");
  		System.out.println("PO with TC field after saving case == pass");	
   }
}
	