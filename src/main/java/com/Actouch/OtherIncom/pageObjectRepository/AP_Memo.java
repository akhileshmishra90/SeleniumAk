package com.Actouch.OtherIncom.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;
public class AP_Memo {
	public static String amt;
	@FindBy(id="eap_voucherId")
	WebElement VoucherEdt;
	@FindBy(id ="advPayment")
	WebElement AdvancedEdt;
	@FindBy(id ="eap_suppId")
	WebElement SuppEdt;
	@FindBy(xpath="//table[@id='PODetailsTable']/tbody/tr/td[2]/textarea")
	WebElement DescEdt;	
	@FindBy(id = "amtPay")
	WebElement AmountEdt;
	@FindBy(id="memo")
	WebElement MemoEdt;
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
	public void PayAdvancedmMemo(String Suppl,String Desc,String Amount,String Memo) throws InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
		int kh = 495; 
		Actions act =new Actions(Browser.driver);
	String Expected =	VoucherEdt.getAttribute("value");
		AdvancedEdt.click();
		SuppEdt.sendKeys(Suppl);
			act.sendKeys(Keys.TAB).perform();
			String Exp = SuppEdt.getAttribute("value");
		DescEdt.sendKeys(Desc);
		AmountEdt.sendKeys(Amount);
		act.sendKeys(Keys.TAB).perform();
			MemoEdt.sendKeys(Memo);
		 String fh =  MemoEdt.getAttribute("value");
			int n = fh.length();
			 Assert.assertTrue(kh>=n,"Memo lenth is less than equal to 495 == fail");
			System.out.println("Memo lenth is less than or equal to 495 == pass");
			act.sendKeys(Keys.ENTER).perform();
			amt=TotalEdt.getText();
			SaveEdt.click();
		AfterSaving.click();
		Browser.driver.get(Constant.ApDash);
			DashSuppEdt.sendKeys(Exp);
		act.sendKeys(Keys.TAB).perform();
		Thread.sleep(200);
		SearchAP.sendKeys(Expected);
		Thread.sleep(200);
		String Actual = Result.getText();
		Assert.assertEquals(Expected, Actual,"Other Expenses = fail");
		System.out.println("Other expenses = pass");
		
	}

}
