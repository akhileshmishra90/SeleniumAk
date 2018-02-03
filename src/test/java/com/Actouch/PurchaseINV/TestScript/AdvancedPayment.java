package com.Actouch.PurchaseINV.TestScript;
import java.math.BigDecimal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Actouch.OtherIncom.pageObjectRepository.AP_AdvancedPayment;
import com.Actouch.OtherIncom.pageObjectRepository.AP_CashOnhand;
import com.Actouch.OtherIncom.pageObjectRepository.AP_Cheque;
import com.Actouch.OtherIncom.pageObjectRepository.AP_DisINR;
import com.Actouch.OtherIncom.pageObjectRepository.AP_DisPER;
import com.Actouch.OtherIncom.pageObjectRepository.AP_Memo;
import com.Actouch.OtherIncom.pageObjectRepository.AP_Reference;
import com.Actouch.OtherIncom.pageObjectRepository.AP_RoundOff;
import com.Actouch.OtherIncom.pageObjectRepository.AP_TDSDeduct;
import com.Actouch.OtherIncom.pageObjectRepository.AP_lineDiscount;
import com.Actouch.OtherIncom.pageObjectRepository.AP_multiCurrency;
import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.POExcelLib;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;
import com.Actouch.PurchaseINV.pageObjectRepository.Login;
import com.Actouch.Sales.generic_Lib.SO_Excellib;
import com.Actouch.Sales.generic_Lib.SO_Excellib;


class AdvancedPayment {
	static WebDriver driver;
	SO_Excellib SO_Excellib = new SO_Excellib("D:\\Selenium\\SaleOrderWSWL.xlsx");
	@Test(priority = 1 )
	public void salesIN_Login_TC_1() throws Exception
	{
		//login
		
		driver = Browser.getbrowser();
String usrId = POExcelLib.getExcelData("PO", 03, 03);
		 String psw = POExcelLib.getExcelData("PO", 03, 04);
		 driver.get(Constant.Url);
		Login loginpage = PageFactory.initElements(driver, Login.class);
		loginpage.login(usrId, psw);
		Thread.sleep(5000);		
	}
	@Test(priority=2)
	public void AP_Pay_Advanced_TC_1() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String SuppId = SO_Excellib.getExcelDat("Advanced payment", 2, 3);
		String Desc = SO_Excellib.getExcelDat("Advanced payment", 2, 4);
		String Amount = SO_Excellib.getExcelDat("Advanced payment", 2, 5);
		String Total = SO_Excellib.getExcelDat("Advanced payment", 2, 14);
		BigDecimal Expected = new BigDecimal(Total);
		Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.OtherExpenses);
		driver.navigate().refresh();
		AP_AdvancedPayment AvdPayment = PageFactory.initElements(driver, AP_AdvancedPayment.class);
		AvdPayment.PayAdvanced(SuppId, Desc,Amount);
		BigDecimal Actual = new BigDecimal(AP_AdvancedPayment.amt);
		Assert.assertEquals(Actual, Expected,"Total Amount not correct");
		System.out.println("Total Amount verified");
	}
@Test(priority=3)
public void AP_Advanced_reference_TC_2() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
String SuppId = SO_Excellib.getExcelDat("Advanced payment", 3, 3);
String Desc = SO_Excellib.getExcelDat("Advanced payment", 3, 4);
String Amount = SO_Excellib.getExcelDat("Advanced payment", 3, 5);
String Ref = SO_Excellib.getExcelDat("Advanced payment", 3, 6);
String Total = SO_Excellib.getExcelDat("Advanced payment", 3, 14);
BigDecimal Expected = new BigDecimal(Total);
Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.OtherExpenses);
	driver.navigate().refresh();
	AP_Reference AvdRef = PageFactory.initElements(driver, AP_Reference.class);
	AvdRef.PayAdvancedRef(SuppId, Desc,Amount, Ref);
	BigDecimal Actual = new BigDecimal(AP_Reference.amt);
	Assert.assertEquals(Actual, Expected,"Total Amount not correct");
	System.out.println("Total Amount verified");
}
@Test(priority=4)
public void AP_Advanced_MultiCurrency_TC_3() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String SuppId = SO_Excellib.getExcelDat("Advanced payment", 4, 3);
	String Desc = SO_Excellib.getExcelDat("Advanced payment", 4, 4);
	String Amount = SO_Excellib.getExcelDat("Advanced payment", 4, 5);
	String Currency = SO_Excellib.getExcelDat("Advanced payment", 4, 7);
	String Conversion = SO_Excellib.getExcelDat("Advanced payment", 4, 8);
	String Total = SO_Excellib.getExcelDat("Advanced payment", 4, 14);
	BigDecimal Expected = new BigDecimal(Total);
	Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.OtherExpenses);
	driver.navigate().refresh();
	AP_multiCurrency AvdCurrency = PageFactory.initElements(driver, AP_multiCurrency.class);
	AvdCurrency.PayAdvancedMulti(SuppId, Desc,Amount, Currency,Conversion);
	BigDecimal Actual = new BigDecimal(AP_multiCurrency.amt);
	Assert.assertEquals(Actual, Expected,"Total Amount not correct");
	System.out.println("Total Amount verified");
}
@Test(priority = 5)
public void AP_Deduct_TDS_TC_4() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String SuppId = SO_Excellib.getExcelDat("Advanced payment", 5, 3);
	String Desc = SO_Excellib.getExcelDat("Advanced payment", 5, 4);
	String Amount = SO_Excellib.getExcelDat("Advanced payment", 5, 5);
	String Tax = SO_Excellib.getExcelDat("Advanced payment", 5, 9);
	String Total = SO_Excellib.getExcelDat("Advanced payment", 5, 14);
	BigDecimal Expected = new BigDecimal(Total);
	Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.OtherExpenses);
	driver.navigate().refresh();
	AP_TDSDeduct AvdTax =PageFactory.initElements(driver, AP_TDSDeduct.class);
	AvdTax.PayAdvancedTDS(SuppId, Desc,Amount,Tax);
	BigDecimal Actual = new BigDecimal(AP_TDSDeduct.amt);
	Assert.assertEquals(Actual, Expected,"Total Amount not correct");
	System.out.println("Total Amount verified");
}
@Test(priority=6)
public void AP_Line_Discount_TC_5() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String SuppId = SO_Excellib.getExcelDat("Advanced payment", 6, 3);
	String Desc = SO_Excellib.getExcelDat("Advanced payment", 6, 4);
	String Amount = SO_Excellib.getExcelDat("Advanced payment", 6, 5);
	String Dis = SO_Excellib.getExcelDat("Advanced payment", 6, 10);
	String Total = SO_Excellib.getExcelDat("Advanced payment", 6, 14);
	BigDecimal Expected = new BigDecimal(Total);
	Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.OtherExpenses);
	driver.navigate().refresh();
	AP_lineDiscount Avdline =PageFactory.initElements(driver, AP_lineDiscount.class);
	Avdline.PayAdvancedline(SuppId, Desc,Amount, Dis);
	BigDecimal Actual = new BigDecimal(AP_lineDiscount.amt);
	Assert.assertEquals(Actual, Expected,"Total Amount not correct");
	System.out.println("Total Amount verified");
	
}
@Test(priority = 7)
public void AP_Advanced_Memo_TC_6() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String SuppId = SO_Excellib.getExcelDat("Advanced payment", 7, 3);
	String Desc = SO_Excellib.getExcelDat("Advanced payment", 7, 4);
	String Amount = SO_Excellib.getExcelDat("Advanced payment", 7, 5);
	String memo = SO_Excellib.getExcelDat("Advanced payment", 7, 11);
	String Total = SO_Excellib.getExcelDat("Advanced payment", 7, 14);
	BigDecimal Expected = new BigDecimal(Total);
	Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.OtherExpenses);
	driver.navigate().refresh();
	AP_Memo AvdMemo = PageFactory.initElements(driver, AP_Memo.class);
	AvdMemo.PayAdvancedmMemo(SuppId, Desc,Amount, memo);
	BigDecimal Actual = new BigDecimal(AP_Memo.amt);
	Assert.assertEquals(Actual, Expected,"Total Amount not correct");
	System.out.println("Total Amount verified");
}
@Test(priority = 8)
public void AP_Advanced_Cheque_TC_7() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String SuppId = SO_Excellib.getExcelDat("Advanced payment", 8, 3);
	String Desc = SO_Excellib.getExcelDat("Advanced payment", 8, 4);
	String Amount = SO_Excellib.getExcelDat("Advanced payment", 8, 5);
	String Total = SO_Excellib.getExcelDat("Advanced payment", 8, 14);
	BigDecimal Expected = new BigDecimal(Total);
	Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
driver.get(Constant.OtherExpenses);
	driver.navigate().refresh();
	AP_Cheque AvdCheque =PageFactory.initElements(driver, AP_Cheque.class);
	AvdCheque.PayAdvancedCheque(SuppId, Desc,Amount, "HDFC", "ChequeNo");
	BigDecimal Actual = new BigDecimal(AP_Cheque.amt);
	Assert.assertEquals(Actual, Expected,"Total Amount not correct");
	System.out.println("Total Amount verified");
}
@Test(priority=9)
public void AP_Advanced_CashOnHand_TC_8() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String SuppId = SO_Excellib.getExcelDat("Advanced payment", 9, 3);
	String Desc = SO_Excellib.getExcelDat("Advanced payment", 9, 4);
	String Amount = SO_Excellib.getExcelDat("Advanced payment", 9, 5);
	String Total = SO_Excellib.getExcelDat("Advanced payment", 9, 14);
	BigDecimal Expected = new BigDecimal(Total);
	Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.OtherExpenses);
	driver.navigate().refresh();
		AP_CashOnhand AvdCash=PageFactory.initElements(driver, AP_CashOnhand.class);
	AvdCash.PayAdvancedCash(SuppId, Desc,Amount, "0C1010");
	BigDecimal Actual = new BigDecimal(AP_CashOnhand.amt);
	Assert.assertEquals(Actual, Expected,"Total Amount not correct");
	System.out.println("Total Amount verified");
}
@Test(priority=10)
public void AP_Discount_percentage_TC_9() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String SuppId = SO_Excellib.getExcelDat("Advanced payment", 10, 3);
	String Desc = SO_Excellib.getExcelDat("Advanced payment", 10, 4);
	String Amount = SO_Excellib.getExcelDat("Advanced payment", 10, 5);
	String Dis = SO_Excellib.getExcelDat("Advanced payment", 10, 10);
	String Total = SO_Excellib.getExcelDat("Advanced payment", 10, 14);
	BigDecimal Expected = new BigDecimal(Total);
	Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.OtherExpenses);
	driver.navigate().refresh();
		AP_DisPER AvdDsp =PageFactory.initElements(driver,AP_DisPER.class );
	AvdDsp.PayAdvancedDsp(SuppId, Desc,Amount, Dis);
	BigDecimal Actual = new BigDecimal(AP_DisPER.amt);
	Assert.assertEquals(Actual, Expected,"Total Amount not correct");
	System.out.println("Total Amount verified");
	
}

@Test(priority=11)
public void AP_Discount_INR_TC_10() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String SuppId = SO_Excellib.getExcelDat("Advanced payment", 11, 3);
	String Desc = SO_Excellib.getExcelDat("Advanced payment", 11, 4);
	String Amount = SO_Excellib.getExcelDat("Advanced payment",11, 5);
	String Dis = SO_Excellib.getExcelDat("Advanced payment",11, 10);
	String Total = SO_Excellib.getExcelDat("Advanced payment", 11, 14);
	BigDecimal Expected = new BigDecimal(Total);
	Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.OtherExpenses);
	driver.navigate().refresh();
	AP_DisINR AvdDsI =PageFactory.initElements(driver, AP_DisINR.class);
	AvdDsI.PayAdvancedDisI(SuppId, Desc,Amount, Dis);
	BigDecimal Actual = new BigDecimal(AP_DisINR.amt);
	Assert.assertEquals(Actual, Expected,"Total Amount not correct");
	System.out.println("Total Amount verified");
}
@Test(priority=12)
public void AP_RoundOff_TC_11() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String SuppId = SO_Excellib.getExcelDat("Advanced payment", 12, 3);
	String Desc = SO_Excellib.getExcelDat("Advanced payment", 12, 4);
	String Amount = SO_Excellib.getExcelDat("Advanced payment", 12, 5);
	String RoundOff = SO_Excellib.getExcelDat("Advanced payment", 12, 12);
	String Total = SO_Excellib.getExcelDat("Advanced payment", 12, 14);
	BigDecimal Expected = new BigDecimal(Total);
	Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.OtherExpenses);
	driver.navigate().refresh();
	AP_RoundOff AvdRound = PageFactory.initElements(driver, AP_RoundOff.class);
	AvdRound.PayAdvancedRound(SuppId, Desc,Amount, RoundOff);
	BigDecimal Actual = new BigDecimal(AP_RoundOff.amt);
	Assert.assertEquals(Actual, Expected,"Total Amount not correct");
	System.out.println("Total Amount verified");
}

}
