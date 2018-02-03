package com.Actouch.OtherIncom.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class OI_LineDiscount {
	public static String amt;
	@FindBy(id ="oi_voucherId")
	WebElement VoucherId;
	@FindBy(id = "oi_custId")
	WebElement CustEdt;
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
	@FindBy(xpath="//table[@id='PODetailsTable']/tbody/tr/td[5]/input")
	WebElement DisCount;
	@FindBy(id="custIDAR")
	WebElement DashCustEdt;
	@FindBy(xpath=".//*[@id='APTable_filter']/label/input")
	WebElement SearchAR;
	@FindBy(xpath="//table[@id='APTable']/tbody/tr/td[2]/a")
	WebElement Result;
	public void ReceiveIncomeline(String CustId,String Description,String Category,String Amount,String Dis ) throws InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
		Actions act = new Actions(Browser.driver);
		String Excepted= VoucherId.getAttribute("value");
		Thread.sleep(3000);
		CustEdt.sendKeys(CustId);
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).perform();
		String Exp = CustEdt.getAttribute("value");
		DescEdt.sendKeys(Description);
		CategoryEdt.sendKeys(Category);
		AmountEdt.sendKeys(Amount);
	act.sendKeys(Keys.TAB).perform();
	DisCount.sendKeys(Dis);
	act.sendKeys(Keys.ENTER).perform();
	amt=TotalEdt.getText();
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
