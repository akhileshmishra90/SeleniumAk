package com.Actouch.SalesINV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
public class ARAdjustAdvanced {
	public static String amt;
@FindBy(xpath="//input[@aria-controls='SOTable']")
		    WebElement searchtxt;
		@FindBy(xpath="//table[@id='SOTable']/tbody/tr/td[5]")
	    WebElement CustId;
		@FindBy(id="custId_AR")
	WebElement CustEdt;
	@FindBy(id="salesOrderList-select")
	WebElement SOidEdt;
	@FindBy(xpath="//input[@placeholder='Voucher Number']")
	WebElement Voucher;
	@FindBy(xpath=".//*[@id='ReceibaleTable']/tbody/tr/td[1]/input")
	WebElement Selectprod;
	@FindBy(xpath=".//*[@id='ReceibaleTable']/tbody/tr/td[11]/input")
	WebElement ReceiveAll;
	@FindBy(xpath="//input[@data-bind='checked: AccountReceivable.inAdvVouchers,enable: AccountReceivable.hasinAdvVouchers']")
	WebElement selectAdvanced;
	@FindBy(xpath="//table[@id='ReceibaleTable']/tbody/tr[2]/td[1]/input")
	WebElement AdjustAmount;
	@FindBy(xpath="//table[@id='ReceibaleTable']/tbody/tr[2]/td[11]/input")
	WebElement ReceiveAdvanced;
	@FindBy(xpath="//label[@data-bind='html: AccountReceivable.totalAmt']")
	WebElement TotalEdt;
	@FindBy(id="btnSave")
	WebElement saveEdt;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement AfterSaving;
	@FindBy(id="custIDAR")
	WebElement DashCustEdt;
	@FindBy(xpath=".//*[@id='APTable_filter']/label/input")
	WebElement SearchAR;
	@FindBy(xpath="//table[@id='APTable']/tbody/tr/td[2]/a")
	WebElement Result;

	public void AdjustAdvanced() throws InterruptedException
	{
	WebDriverCommonlib.waitForPageToLoad();
		String exp=searchtxt.getAttribute("value"); 
		String Cust= CustId.getText();
		Browser.driver.get(Constant.AccountsReceivable);
		  CustEdt.sendKeys(Cust);
		Actions act = new Actions(Browser.driver);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		SOidEdt.sendKeys(exp);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		String Excepted = Voucher.getAttribute("value");
		Thread.sleep(1000);
		Selectprod.click();
		ReceiveAll.click();
		selectAdvanced.click();
		AdjustAmount.click();
		ReceiveAdvanced.click();
		act.sendKeys(Keys.ENTER).perform();
		amt=TotalEdt.getText();
		saveEdt.click();
		AfterSaving.click();
		Browser.driver.get(Constant.ARDashBoard);
		DashCustEdt.sendKeys(Cust);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
			SearchAR.sendKeys(Excepted );
		String actual = Result.getText();
	  	 Assert.assertEquals(actual, Excepted, "Adjust Advanced ==fail");
	  	 System.out.println("Adjust Advanced ==pass");
		}
}


