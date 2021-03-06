package com.Actouch.OtherIncom.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;
import com.Actouch.Sales.generic_Lib.Browser;


import org.testng.Assert;

public class OE_DisINR {
	public static String amt;
	@FindBy(id="eap_voucherId")
	WebElement VoucherEdt;
	@FindBy(id ="eap_suppId")
	WebElement SuppEdt;
	@FindBy(xpath="//table[@id='PODetailsTable']/tbody/tr/td[2]/textarea")
	WebElement DescEdt;
	@FindBy(id="eap_accdisc")
	WebElement CategoryEdt;
	@FindBy(id = "amtPay")
	WebElement AmountEdt;
	@FindBy(id="overAllDisc")
	WebElement OEDiscount;
	@FindBy(xpath="//span[@data-bind = 'text: EAPModel.overallDiscUnit']")
	WebElement ModeButton;
	@FindBy(xpath="//span[@data-bind='text: EAPModel.discType2']")
	WebElement INREdt;
	@FindBy(xpath="//h3[@data-bind='html: EAPModel.netAmt']")
	WebElement TotalEdt;
	@FindBy(id= "btnSave")
    WebElement SaveEdt;
	@FindBy(xpath="html/body/div[8]/div/div[3]/button")
	WebElement AfterSaving;
	@FindBy(id="apSuppList")
	WebElement DashSuppEdt;
@FindBy (xpath="//input[@aria-controls='APTable']")
WebElement SearchAP;
@FindBy(xpath=".//*[@id='APTable']/tbody/tr/td[2]/a")
WebElement Result;	
	public void PayExpensesDisI(String Suppl,String Desc,String Category,String Amount,String Discount) throws InterruptedException
	{ 
		WebDriverCommonlib.waitForPageToLoad();
		Actions act =new Actions(Browser.driver);
	String Expected =	VoucherEdt.getAttribute("value");
		SuppEdt.sendKeys(Suppl);
		act.sendKeys(Keys.TAB).perform();
		String Exp = SuppEdt.getAttribute("value");
		DescEdt.sendKeys(Desc);
	CategoryEdt.sendKeys(Category);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		AmountEdt.sendKeys(Amount);
		act.sendKeys(Keys.TAB).perform();
		ModeButton.click();
INREdt.click();
		OEDiscount.sendKeys(Discount);
		act.sendKeys(Keys.ENTER).perform();
		SaveEdt.click();
		AfterSaving.click();
		Browser.driver.get(Constant.ApDash);
	DashSuppEdt.sendKeys(Exp);
		act.sendKeys(Keys.TAB).perform();
			SearchAP.sendKeys(Expected);
		String Actual = Result.getText();
		Assert.assertEquals(Expected, Actual,"Other Expenses = fail");
		System.out.println("Other expenses = pass");
	}


}
