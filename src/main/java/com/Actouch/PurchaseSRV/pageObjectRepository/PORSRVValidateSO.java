package com.Actouch.PurchaseSRV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;

public class PORSRVValidateSO {

	@FindBy(xpath="//input[@aria-controls='POTable']")
    WebElement searchtxt;
 
 
 @FindBy(xpath="//table[@id='POTable']/tbody/tr/td[5]")
 WebElement SuppNMforPOR;
 @FindBy(id="suppIdFor_Por")
 WebElement SuppDshEdt;
 @FindBy(xpath="//input[@aria-controls='POTable']")
 WebElement searchForPO;
 @FindBy(xpath=".//*[@id='POTable']/tbody/tr/td[2]/a")
 WebElement choosePOid;
 @FindBy(id="porId" )
 WebElement PORid;
 @FindBy(id="poId")
 WebElement VeryfySupp;
 public void ReceiptvalidatePO() throws InterruptedException
 {
	WebDriverCommonlib.waitForPageToLoad();
	String exp = searchtxt.getAttribute("value");
	  String Supp = SuppNMforPOR.getText();
	 Browser.driver.get(Constant.newPorMain);
	 SuppDshEdt.sendKeys(Supp);
	 Actions act = new Actions(Browser.driver);
	 act.sendKeys(Keys.ARROW_DOWN).perform();
	 act.sendKeys(Keys.ENTER).perform();
	 searchForPO.sendKeys(exp);
	 choosePOid.click();
	 String verify = VeryfySupp.getAttribute("value");
 	Assert.assertEquals(verify, exp," PO verified==fail");
 	System.out.println("PO verified == pass");
}

}
