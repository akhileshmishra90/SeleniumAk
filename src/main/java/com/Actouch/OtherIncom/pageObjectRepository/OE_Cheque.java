package com.Actouch.OtherIncom.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;
import org.testng.Assert;

public class OE_Cheque {
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
@FindBy(id="apPayMode-select")
	WebElement paytype;
@FindBy(xpath="//input[@data-bind='value: ChequeNo,hasfocus:true']")
	   WebElement chequeNo;
@FindBy(xpath="//h3[@data-bind ='html: EAPModel.netAmt']")
    WebElement gettingTotalAmount;
	@FindBy(xpath="//input[@data-bind='value: Amount']")
    WebElement puttingTotalAmount;
    @FindBy(xpath="//button[@data-bind='click: ok']")
	WebElement savingcheq;
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
	public void PayExpensesCheq(String Suppl,String Desc,String Category,String Amount,String BankName,String ChequeNo) throws InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
		Actions act =new Actions(Browser.driver);
	String Expected =	VoucherEdt.getAttribute("value");
		SuppEdt.sendKeys(Suppl);
		act.sendKeys(Keys.TAB).perform();
		String Exp = SuppEdt.getAttribute("value");
		System.out.println(Exp);
		DescEdt.sendKeys(Desc);
			CategoryEdt.sendKeys(Category);
			act.sendKeys(Keys.ARROW_DOWN).perform();
			act.sendKeys(Keys.ENTER).perform();
		AmountEdt.sendKeys(Amount);
		act.sendKeys(Keys.TAB).perform();
		amt = gettingTotalAmount.getText();
		paytype.clear();
		paytype.sendKeys(BankName);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
	chequeNo.sendKeys(ChequeNo);
		puttingTotalAmount.clear();
			puttingTotalAmount.sendKeys(amt);
			savingcheq.click();
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
