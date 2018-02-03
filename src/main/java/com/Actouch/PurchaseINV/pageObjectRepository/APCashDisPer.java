package com.Actouch.PurchaseINV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;

public class APCashDisPer {
	public static String amt;
	@FindBy(xpath="//input[@aria-controls='POTable']")
	WebElement searchtxt;
	@FindBy(xpath=".//*[@id='POTable']/tbody/tr[1]/td[5]")
	WebElement SuppId;
	@FindBy(id="suppId_AP")
	WebElement SuppEdt;
	@FindBy(id="poList-select")
	WebElement POidEdt;
	@FindBy(xpath="//input[@placeholder='Voucher Number']")
	WebElement VoucherEdt;
	@FindBy(xpath="//table[@id='APDetailsTable']/tbody/tr/td[1]/input")
	WebElement Selectprod;
	@FindBy(xpath=".//*[@id='APDetailsTable']/tbody/tr/td[11]/input")
	WebElement PayAll;
	@FindBy(id="overAllDiscAP")
	WebElement DiscEdt;
	@FindBy(xpath="//label[@data-bind ='html: AccountPayable.totalAmt']")
	WebElement TotalEdt;
@FindBy(id="btnSaveAp")
	WebElement saveEdt;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement AfterSave;
	@FindBy(id="apSuppList")
	WebElement DashSuppEdt;
	@FindBy(xpath="//input[@aria-controls='APTable']")
	WebElement SearchAp;
	@FindBy(xpath="//table[@id='APTable']/tbody/tr/td[2]/a")
	WebElement Result;
	public void FullpaymentDisc(String Disc) throws InterruptedException
	{
	 WebDriverCommonlib.waitForPageToLoad();
String exp=searchtxt.getAttribute("value"); 
String Supp= SuppId.getText();
		      Browser.driver.get(Constant.AccountsPayment);
		 SuppEdt.sendKeys(Supp);
		Actions act = new Actions(Browser.driver);
		      act.sendKeys(Keys.ARROW_DOWN).perform();
		      act.sendKeys(Keys.ENTER).perform();
		POidEdt.sendKeys(exp);
		      act.sendKeys(Keys.ARROW_DOWN).perform();
		      act.sendKeys(Keys.ENTER).perform();
		String Excepted = VoucherEdt.getAttribute("value");
		Thread.sleep(1000);
		Selectprod.click();
		      PayAll.click();
		DiscEdt.sendKeys(Disc);
		act.sendKeys(Keys.ENTER).perform();
		amt = TotalEdt.getText();
		      saveEdt.click();
		     AfterSave.click();
	Browser.driver.get(Constant.ApDash);
		      DashSuppEdt.sendKeys(Supp);
		      act.sendKeys(Keys.ARROW_DOWN).perform();
		      act.sendKeys(Keys.ENTER).perform();
		      Thread.sleep(4000);
		SearchAp.sendKeys(Excepted );
		      Thread.sleep(300);
	 	String actual = Result.getText();
	  	 Assert.assertEquals(actual, Excepted, "full Receivable ==fail");
	  	 System.out.println("full Receivable ==pass");
		
		
	}

	

}
