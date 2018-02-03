package com.Actouch.OtherIncom.pageObjectRepository;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class OI_MultiCurrency {
	public static String amt;
	@FindBy(id ="oi_voucherId")
	WebElement VoucherId;
	@FindBy(id = "oi_custId")
	WebElement CustEdt;
	@FindBy(xpath="//div[@id='ar-formp-1']/div[3]/div/div[4]/span[2]/input")
	WebElement multiCurrency;
	@FindBy(xpath="//input[@data-bind ='value: exchRate']")
	WebElement Exchange;
	@FindBy(xpath="//button[@data-bind ='click: ok']")
	WebElement AftersavingExchange;
	@FindBy(xpath="//table[@id='PODetailsTable']/tbody/tr/td[2]/textarea")
	WebElement DescEdt;
	@FindBy(id = "oi_accDesc")
	WebElement CategoryEdt;
	@FindBy(id = "amtPay")
	WebElement AmountEdt;
	@FindBy(xpath="//h3[@data-bind='html: OIModel.totalAmt']")
    WebElement TotalEdt;
	@FindBy(id ="btnSave")
	WebElement SaveEdt;
	@FindBy(xpath="html/body/div[8]/div/div[3]/button")
	WebElement aftersaving;
	@FindBy(id="custIDAR")
	WebElement DashCustEdt;
	@FindBy(xpath=".//*[@id='APTable_filter']/label/input")
	WebElement SearchAR;
	@FindBy(xpath="//table[@id='APTable']/tbody/tr/td[2]/a")
	WebElement Result;
	public void ReceiveIncomeCur(String CustId,String Description,String Category,String Amount,String Currency,String ExchangeRt ) throws InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
		Actions act = new Actions(Browser.driver);
		String Excepted= VoucherId.getAttribute("value");
		Thread.sleep(3000);
		CustEdt.sendKeys(CustId);
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).perform();
		String Exp = CustEdt.getAttribute("value");
		multiCurrency.clear();
		multiCurrency.sendKeys(Currency);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		if(!(Currency.equals("INR")))
		{
		Exchange.sendKeys(Keys.chord(Keys.CONTROL, "a"),ExchangeRt);
				AftersavingExchange.click();
			  	}
		DescEdt.sendKeys(Description);
		CategoryEdt.sendKeys(Category);
		AmountEdt.sendKeys(Amount);
		act.sendKeys(Keys.TAB).perform();
		amt= TotalEdt.getText();
		SaveEdt.click();
		aftersaving.click();
		Browser.driver.get(Constant.ARDashBoard);
		DashCustEdt.sendKeys(Exp);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		SearchAR.sendKeys(Excepted);
		String actual = Result.getText();
		 Assert.assertEquals(actual, Excepted, "Receive other income ==fail");
		 System.out.println("Receive other income ==pass");
	}
	
}
