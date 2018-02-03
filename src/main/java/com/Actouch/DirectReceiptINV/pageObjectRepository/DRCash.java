package com.Actouch.DirectReceiptINV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;
 public class DRCash {
  public static String amt;
    @FindBy(id="poId")
    WebElement PORID;
	@FindBy(id="prdId_createDpor")
	WebElement SuppEdt;
	@FindBy(id="prdPo_1")
	WebElement ProdIDEdt;
	@FindBy(xpath="//div[@data-bind='if:chkLoc']/span")
	WebElement prodModEdt;
	@FindBy(xpath="//td[@data-bind='visible: !isSerialNo()']/input")
	WebElement QntyEdt;
	@FindBy(xpath="//button[@data-bind='click: ok']")
	WebElement QtySave;
	@FindBy(id="unitprice")
	WebElement UnitPEdt;
	@FindBy(xpath="//span[@data-bind='click: showPOTaxModel']")
	WebElement TaxModel;
	@FindBy(id="payTypePO")
	WebElement PayTypeEdt;
	@FindBy(id="payMode2-select")
	WebElement PaymodeEdt;
	@FindBy(xpath="//label[@data-bind='html: DPInventory.netAmt']")
	WebElement TotalAmt;
	@FindBy(id="btnSave")
	WebElement Save;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement okEdt;
	@FindBy(xpath="//input[@aria-controls='POR_Table']")
	WebElement SerchPOR;
	@FindBy(xpath=".//*[@id='POR_Table']/tbody/tr/td[3]")
	WebElement Result;
	public void PayNow(String Supp,String ProdID,String Qnty,String UnitP,String PayType,String Paymode) throws InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
		Actions act =new Actions(Browser.driver);
		String Expected= PORID.getAttribute("value");
		 Thread.sleep(4000);
		SuppEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Supp);
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).perform();
		ProdIDEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),ProdID);
		 Thread.sleep(1000);
		act.sendKeys(Keys.TAB).perform();
		prodModEdt.click();
		QntyEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Qnty);
		QtySave.click();
		UnitPEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),UnitP);
		  PayTypeEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),PayType);
		  act.sendKeys(Keys.ARROW_DOWN).perform();
		  act.sendKeys(Keys.ENTER).perform();
		  PaymodeEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Paymode);
		  act.sendKeys(Keys.ARROW_DOWN).perform();
		  act.sendKeys(Keys.ENTER).perform();
		 amt=TotalAmt.getText();
		  Save.click();
		  okEdt.click();
		 Browser.driver.get(Constant.PorMain);
		 Thread.sleep(6000);
		 SerchPOR.sendKeys(Expected);
		 String Actual = Result.getText();
		 Assert.assertEquals(Actual, Expected,"POR ID not created");
		  
	}


}
