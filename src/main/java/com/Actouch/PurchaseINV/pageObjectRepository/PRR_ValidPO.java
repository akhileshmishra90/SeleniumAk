package com.Actouch.PurchaseINV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;

public class PRR_ValidPO {
	@FindBy(xpath="//input[@aria-controls='POTable']")
	WebElement SearchEdt;
	@FindBy(xpath = "//table[@id='POTable']/tbody/tr/td[5]")
	WebElement SuppEdt;
	@FindBy(id ="suppIdPrr")
	WebElement SuppDashEdt;
@FindBy(xpath="//div[@id='PORTable_filter']/label/input")
	WebElement Searchpartcular;
	@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle']")
	WebElement ActionEdt;
	@FindBy(xpath="//a[contains(text(),'POR Returns')]")
	WebElement POReturns;
	@FindBy(xpath="//input[@placeholder='Supplier Name']")
	WebElement SuppMain;
	@FindBy(id="prrId")
	WebElement PRRIdEdt;
	@FindBy(id ="porId")
	WebElement POIdEdt;
	@FindBy(xpath=".//*[@id='PORTable']/tbody/tr[1]/td[3]")
	WebElement PoridEDT;
	
	public void ReceiptvalidatePO() throws InterruptedException
	{
		 WebDriverCommonlib.waitForPageToLoad();
		 String exp = SearchEdt.getAttribute("value");
	 String Supp = SuppEdt.getText();
 Browser.driver.get(Constant.PRRMain);
 SuppDashEdt.sendKeys(Supp);
 Actions act = new Actions(Browser.driver);
		 act.sendKeys(Keys.ARROW_DOWN).perform();
 act.sendKeys(Keys.ENTER).perform();
 Searchpartcular.sendKeys(exp);
String Porid= PoridEDT.getText();
ActionEdt.click();
POReturns.click();
	 String verify = POIdEdt.getAttribute("value");
		 	Assert.assertEquals(verify, Porid," PO verified==fail");
		 	System.out.println("PO verified == pass");
	}

}
