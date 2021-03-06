package com.Actouch.OtherIncom.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;
public class AP_multiCurrency {
	public static String amt;
	@FindBy(id="eap_voucherId")
	WebElement VoucherEdt;
	@FindBy(id ="advPayment")
	WebElement AdvancedEdt;
	@FindBy(id ="eap_suppId")
	WebElement SuppEdt;
	@FindBy(xpath="//div[@id='ap-formp-1']/div[3]/div/div[4]/span[2]/input")
	WebElement CurrencyEdt;
	@FindBy(xpath="//input[@data-bind='value: exchRate']")
	WebElement ExchangeEdt;
	@FindBy(xpath="//button[@data-bind='click: ok']")
	WebElement AfterSavingExng;
@FindBy(xpath="//table[@id='PODetailsTable']/tbody/tr/td[2]/textarea")
	WebElement DescEdt;
@FindBy(id = "amtPay")
	WebElement AmountEdt;
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
	public void PayAdvancedMulti(String Suppl,String Desc,String Amount,String Currency ,String Exchange ) throws InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
		Actions act =new Actions(Browser.driver);
	String Expected = VoucherEdt.getAttribute("value");
		AdvancedEdt.click();
		SuppEdt.sendKeys(Suppl);
	act.sendKeys(Keys.TAB).perform();
		String Exp = SuppEdt.getAttribute("value");
		CurrencyEdt.clear();
		CurrencyEdt.sendKeys(Currency);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
	if(!(Currency.equals("INR")))
		{
			ExchangeEdt.sendKeys(Keys.chord(Keys.CONTROL, "a"),Exchange);
				AfterSavingExng.click();
			  	
			  	}
		DescEdt.sendKeys(Desc);
		AmountEdt.sendKeys(Amount);
		act.sendKeys(Keys.TAB).perform();
		amt=TotalEdt.getText();
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
