package com.Actouch.OtherIncom.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class OI_Memo {
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
	@FindBy(id = "oi_memo")
	WebElement Memo;
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
	public void ReceiveIncomeMemo(String CustId,String Description,String Category,String Amount,String memo ) throws InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
		int kh = 495;
		Actions act = new Actions(Browser.driver);
		String Excepted= VoucherId.getAttribute("value");
		Thread.sleep(2000);
		CustEdt.sendKeys(CustId);
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).perform();
		String Exp = CustEdt.getAttribute("value");
		DescEdt.sendKeys(Description);
		CategoryEdt.sendKeys(Category);
		AmountEdt.sendKeys(Amount);
		act.sendKeys(Keys.TAB).perform();
		 Memo.sendKeys(memo);
		 String fh =  Memo.getAttribute("value");
			int n = fh.length();
			 Assert.assertTrue(kh>=n, "Memo lenth is less than equal to 495 == fail");
				System.out.println("Memo lenth is less than or equal to 495 == pass");
				act.sendKeys(Keys.ENTER).perform();
				amt = TotalEdt.getText();
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
