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
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;
public class PO_WithoutDETline {

	@FindBy(id ="poId")
	WebElement poIdEdt;
	@FindBy(id ="prdId_createpo")
	WebElement poSuppIdEdt;
	@FindBy(id ="btnSave")
	WebElement btnSaveEdt;
	@FindBy(xpath="//p[contains(.,'Please Select Product at Line Number:1')]")
	WebElement detErr;
	
   public void PoDETerr(String Supp_Id) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
   { 
	   WebDriverCommonlib.waitForPageToLoad();
	   Actions act = new Actions(Browser.driver);
	   Thread.sleep(3000);
	   poSuppIdEdt.sendKeys(Supp_Id);
	   Thread.sleep(1000);	   
		   act.sendKeys(Keys.TAB).perform();
	   JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
	   kl.executeScript("window.scrollBy(0,300)", "");
	   btnSaveEdt.click();
	   String actMsg = "Please Select Product at Line Number:1";	   
	   String exp = detErr.getText();
  Assert.assertEquals(actMsg, exp,"enter product at line level before saving case == fail");
  		System.out.println("PO with product line item after saving case == pass");
  }
}
	