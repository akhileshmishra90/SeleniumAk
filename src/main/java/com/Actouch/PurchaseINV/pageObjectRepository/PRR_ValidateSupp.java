package com.Actouch.PurchaseINV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;

public class PRR_ValidateSupp {
	@FindBy(xpath="//input[@aria-controls='POTable']")
	WebElement SearchEdt;
	@FindBy(xpath = "//table[@id='POTable']/tbody/tr/td[6]")
	WebElement SuppEdt;
	@FindBy(id ="suppIdPrr")
	WebElement SuppDashEdt;
	@FindBy(id ="suppName")
	WebElement VeryfySupp;
	@FindBy(xpath="//div[@id='PORTable_filter']/label/input")
	WebElement Searchpartcular;
	@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle']")
	WebElement ActionEdt;
	@FindBy(xpath="//a[contains(text(),'POR Returns')]")
	WebElement POReturns;
	@FindBy(xpath="//input[@placeholder='Supplier Name']")
	WebElement SuppMain;
	
	public void validateSupp() throws InterruptedException
	{
	WebDriverCommonlib.waitForPageToLoad();
	String exp = SearchEdt.getAttribute("value");
	 String Supp = SuppEdt.getText();
	 Browser.driver.get(Constant.PRRMain);
		 SuppDashEdt.sendKeys(Supp);
 Actions act = new Actions(Browser.driver);
	 act.sendKeys(Keys.ARROW_DOWN).perform();
 act.sendKeys(Keys.ENTER).perform();
 String veryCust = VeryfySupp.getAttribute("value");
 	Assert.assertEquals(veryCust, Supp,"Supplier Name veryfied==fail");
 	System.out.println("Customer Name veryfied == pass");
Searchpartcular.sendKeys(exp);
 ActionEdt.click();
 POReturns.click();
String verySupp1 = SuppMain.getAttribute("value");
Assert.assertEquals(verySupp1, Supp,"Supplier Name veryfied==fail");
 	System.out.println("Supplier Name veryfied == pass");
}
}
