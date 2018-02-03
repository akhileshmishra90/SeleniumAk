package com.Actouch.PurchaseSRV.pageObjectRepository;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;
public class POSRVWithoutCategory {

	public static String amt;
	@FindBy(id ="poId")
	WebElement PoIdEdt;
	@FindBy(id="poServSuppList")
	WebElement SuppEdt;
	@FindBy(xpath="//textarea[@placeholder='Enter Service Description (Max 190 characters)']")
	WebElement DescEdt;
	@FindBy(xpath="//input[@data-bind ='selectcontrolExpenseAcPOSInput:prdId']")
	WebElement CategoryEdt;
	@FindBy(id="POSunitprice")
	WebElement UnitPriceEdt;
	@FindBy(xpath="//label[@data-bind='html: POService.netAmt']")
	WebElement TotalEdt;
	@FindBy(id="btnSave")
	WebElement SaveEdt;
	@FindBy(xpath="//p[contains(text(),'Please Select Service Category')]")
	WebElement Errormsg;
	public void BlankCategory(String Supp,String Desc,String Unitprice) throws InterruptedException
	{
		 WebDriverCommonlib.waitForPageToLoad();
			Actions act = new Actions(Browser.driver);
			String exp ="Please Select Service Category at Line Number:1";
			Thread.sleep(3000);
			SuppEdt.sendKeys(Supp);
			Thread.sleep(1000);
			act.sendKeys(Keys.TAB).perform();
					DescEdt.sendKeys(Desc);
UnitPriceEdt.sendKeys(Unitprice);
			amt=TotalEdt.getText();
			SaveEdt.click();
			   String act2 = Errormsg.getText();
			    Assert.assertEquals(act2, exp,"check Error message case == fail");
		 		System.out.println("check Error message case == pass");
	}
}
