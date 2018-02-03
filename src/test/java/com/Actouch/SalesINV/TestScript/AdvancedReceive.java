package com.Actouch.SalesINV.TestScript;
import java.math.BigDecimal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Actouch.OtherIncom.pageObjectRepository.AD_CashOnHand;
import com.Actouch.OtherIncom.pageObjectRepository.AD_Cheque;
import com.Actouch.OtherIncom.pageObjectRepository.AD_DisINR;
import com.Actouch.OtherIncom.pageObjectRepository.AD_DisPER;
import com.Actouch.OtherIncom.pageObjectRepository.AD_LineDiscount;
import com.Actouch.OtherIncom.pageObjectRepository.AD_Memo;
import com.Actouch.OtherIncom.pageObjectRepository.AD_MultiCurrency;
import com.Actouch.OtherIncom.pageObjectRepository.AD_ReceiveAdvanced;
import com.Actouch.OtherIncom.pageObjectRepository.AD_Reference;
import com.Actouch.OtherIncom.pageObjectRepository.AD_RoundOff;
import com.Actouch.OtherIncom.pageObjectRepository.AD_TDSDeduct;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.SO_Excellib;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
import com.Actouch.SalesINVLoc.pageObjectRepository.Login;

public class AdvancedReceive {
	
	
	static WebDriver driver;
	SO_Excellib SO_Excellib = new SO_Excellib("D:\\Selenium\\Other Income .xlsx");
	@Test(priority = 1)
	public void salesIN_Login_TC_1() throws Exception
	{
		//login
		
		driver = Browser.getbrowser();
	
		
		 String usrid = SO_Excellib.getExcelDat("Advanced",00, 03);
		 String pss = SO_Excellib.getExcelDat("Advanced", 00, 04);
			Browser.driver.get(Constant.Url);
		Login loginpage = PageFactory.initElements(driver, Login.class);
		loginpage.login(usrid, pss);
	
		Thread.sleep(3000);
		
		}
	@Test(priority=2)
	public void AD_Receive_Advanced_TC_1() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String CustId = SO_Excellib.getExcelDat("Advanced", 2, 3);
		String Desc = SO_Excellib.getExcelDat("Advanced", 2, 4);
		String Amount = SO_Excellib.getExcelDat("Advanced", 2, 5);
		String Total = SO_Excellib.getExcelDat("Advanced", 2, 14);
		BigDecimal Expected = new BigDecimal(Total);
		Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.OtherIncome);
		driver.navigate().refresh();
		AD_ReceiveAdvanced RecvAdv =PageFactory.initElements(driver, AD_ReceiveAdvanced.class);
		RecvAdv.ReceiveAdvanced(CustId,Desc,Amount);
		BigDecimal Actual = new BigDecimal(AD_ReceiveAdvanced.amt);
		Assert.assertEquals(Actual, Expected,"Total Amount not correct");
		System.out.println("total Amount verified");
		}

	@Test(priority=3)
	public void AD_Advanced_reference_TC_2() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String CustId = SO_Excellib.getExcelDat("Advanced", 3, 3);
		String Desc = SO_Excellib.getExcelDat("Advanced", 3, 4);
		String Amount = SO_Excellib.getExcelDat("Advanced", 3, 5);
		String Ref = SO_Excellib.getExcelDat("Advanced", 3, 6);
		String Total = SO_Excellib.getExcelDat("Advanced", 3, 14);
		BigDecimal Expected = new BigDecimal(Total);
		Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.OtherIncome);
		driver.navigate().refresh();
		AD_Reference RecvAvd =PageFactory.initElements(driver, AD_Reference.class);
	RecvAvd.ReceiveAdvRef(CustId,Desc,Amount,Ref);
	BigDecimal Actual = new BigDecimal(AD_Reference.amt);
	Assert.assertEquals(Actual, Expected,"Total Amount not correct");
	System.out.println("total Amount verified");
	
	}
@Test(priority=4)
public void AD_Advanced_MultiCurrency_TC_3() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String CustId = SO_Excellib.getExcelDat("Advanced", 4, 3);
	String Desc = SO_Excellib.getExcelDat("Advanced", 4, 4);
	String Amount = SO_Excellib.getExcelDat("Advanced", 4, 5);
	String Currency = SO_Excellib.getExcelDat("Advanced", 4, 7);
	String Conversion = SO_Excellib.getExcelDat("Advanced", 4, 8);
	String Total = SO_Excellib.getExcelDat("Advanced", 4, 14);
	BigDecimal Expected = new BigDecimal(Total);
	Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.OtherIncome);
	driver.navigate().refresh();
	AD_MultiCurrency RecvADV =PageFactory.initElements(driver, AD_MultiCurrency.class);
	RecvADV.ReceiveAdvancedCur(CustId,Desc,Amount,Currency,Conversion);
	BigDecimal Actual = new BigDecimal(AD_MultiCurrency.amt);
	Assert.assertEquals(Actual, Expected,"Total Amount not correct");
	System.out.println("total Amount verified");
}
@Test(priority=5)
public void AD_Deduct_TDS_TC_4() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String CustId = SO_Excellib.getExcelDat("Advanced", 5, 3);
	String Desc = SO_Excellib.getExcelDat("Advanced", 5, 4);
	String Amount = SO_Excellib.getExcelDat("Advanced", 5, 5);
	String Tax = SO_Excellib.getExcelDat("Advanced", 5, 9);
	String Total = SO_Excellib.getExcelDat("Advanced", 5, 14);
	BigDecimal Expected = new BigDecimal(Total);
	Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.OtherIncome);
	driver.navigate().refresh();
	AD_TDSDeduct RecvADV =PageFactory.initElements(driver, AD_TDSDeduct.class);
	RecvADV.ReceiveAdvancedTDS(CustId,Desc,Amount,Tax);
	BigDecimal Actual = new BigDecimal(AD_TDSDeduct.amt);
	Assert.assertEquals(Actual, Expected,"Total Amount not correct");
	System.out.println("total Amount verified");
}
@Test(priority=6)
public void AD_Line_Discount_TC_5() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String CustId = SO_Excellib.getExcelDat("Advanced", 6, 3);
	String Desc = SO_Excellib.getExcelDat("Advanced", 6, 4);
	String Amount = SO_Excellib.getExcelDat("Advanced", 6, 5);
	String Dis = SO_Excellib.getExcelDat("Advanced", 6, 10);
	String Total = SO_Excellib.getExcelDat("Advanced", 6, 14);
	BigDecimal Expected = new BigDecimal(Total);
	Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.OtherIncome);
	driver.navigate().refresh();
	AD_LineDiscount LineDis =PageFactory.initElements(driver, AD_LineDiscount.class);
	LineDis.ReceiveAdvancedline(CustId,Desc,Amount,Dis);
	BigDecimal Actual = new BigDecimal(AD_LineDiscount.amt);
	Assert.assertEquals(Actual, Expected,"Total Amount not correct");
	System.out.println("total Amount verified");
}

@Test(priority=7)
public void AD_Advanced_Memo_TC_6() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String CustId = SO_Excellib.getExcelDat("Advanced", 7, 3);
	String Desc = SO_Excellib.getExcelDat("Advanced", 7, 4);
	String Amount = SO_Excellib.getExcelDat("Advanced", 7, 5);
	String memo = SO_Excellib.getExcelDat("Advanced", 7, 11);
	String Total = SO_Excellib.getExcelDat("Advanced", 7, 14);
	BigDecimal Expected = new BigDecimal(Total);
	Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.OtherIncome);
driver.navigate().refresh();
AD_Memo MEMO =PageFactory.initElements(driver, AD_Memo.class);
MEMO.ReceiveAdvancedMemo(CustId,Desc,Amount, memo);
BigDecimal Actual = new BigDecimal(AD_Memo.amt);
Assert.assertEquals(Actual, Expected,"Total Amount not correct");
System.out.println("total Amount verified");

}
@Test(priority=8)
public void AD_Advanced_Cheque_TC_7() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String CustId = SO_Excellib.getExcelDat("Advanced", 8, 3);
String Desc = SO_Excellib.getExcelDat("Advanced", 8, 4);
String Amount = SO_Excellib.getExcelDat("Advanced", 8, 5);
String Total = SO_Excellib.getExcelDat("Advanced", 8, 14);
BigDecimal Expected = new BigDecimal(Total);
Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
driver.get(Constant.OtherIncome);
driver.navigate().refresh();
AD_Cheque RecvIncm =PageFactory.initElements(driver, AD_Cheque.class);
RecvIncm.ReceiveAdvancedCheque(CustId,Desc,Amount, "HDFC", "ChequeNo", "RecvdbankName");
BigDecimal Actual = new BigDecimal(AD_Cheque.amt);
Assert.assertEquals(Actual, Expected,"Total Amount not correct");
System.out.println("total Amount verified");
}

@Test(priority=9)
public void AD_Advanced_CashOnHand_TC_8() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String CustId = SO_Excellib.getExcelDat("Advanced", 9, 3);
	String Desc = SO_Excellib.getExcelDat("Advanced", 9, 4);
    String Amount = SO_Excellib.getExcelDat("Advanced", 9, 5);
    String Total = SO_Excellib.getExcelDat("Advanced", 9, 14);
	BigDecimal Expected = new BigDecimal(Total);
	Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
    driver.get(Constant.OtherIncome);
	driver.navigate().refresh();
	AD_CashOnHand RecvIncm =PageFactory.initElements(driver, AD_CashOnHand.class);
	RecvIncm.ReceiveAdvancedCash(CustId,Desc,Amount,"0C1010");
	BigDecimal Actual = new BigDecimal(AD_CashOnHand.amt);
	Assert.assertEquals(Actual, Expected,"Total Amount not correct");
	System.out.println("total Amount verified");
}
@Test(priority=10)
public void AD_Discount_percentage_TC_9() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String CustId = SO_Excellib.getExcelDat("Advanced", 10, 3);
	String Desc = SO_Excellib.getExcelDat("Advanced", 10, 4);
	String Amount = SO_Excellib.getExcelDat("Advanced", 10, 5);
	String Dis = SO_Excellib.getExcelDat("Advanced", 10, 10);
	String Total = SO_Excellib.getExcelDat("Advanced", 10, 14);
	BigDecimal Expected = new BigDecimal(Total);
	Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.OtherIncome);
	driver.navigate().refresh();
	AD_DisPER RecvADV =PageFactory.initElements(driver, AD_DisPER.class);
	RecvADV.ReceiveAdvancedDisP(CustId,Desc,Amount,"0C1010", Dis);
	BigDecimal Actual = new BigDecimal(AD_DisPER.amt);
	Assert.assertEquals(Actual, Expected,"Total Amount not correct");
	System.out.println("total Amount verified");
}
@Test(priority=11)
public void AD_Discount_INR_TC_10() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String CustId = SO_Excellib.getExcelDat("Advanced", 11, 3);
	String Desc = SO_Excellib.getExcelDat("Advanced", 11, 4);
	String Amount = SO_Excellib.getExcelDat("Advanced",11, 5);
	String Dis = SO_Excellib.getExcelDat("Advanced",11, 10);
	String Total = SO_Excellib.getExcelDat("Advanced", 11, 14);
	BigDecimal Expected = new BigDecimal(Total);
	Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.OtherIncome);
	driver.navigate().refresh();
	AD_DisINR RecvIncm =PageFactory.initElements(driver, AD_DisINR.class);
	RecvIncm.ReceiveAdvancedDisINR(CustId,Desc,Amount,"0C1010",Dis);
	BigDecimal Actual = new BigDecimal(AD_DisINR.amt);
	Assert.assertEquals(Actual, Expected,"Total Amount not correct");
	System.out.println("total Amount verified");
}
@Test(priority=12)
public void AD_RoundOff_TC_11() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String CustId = SO_Excellib.getExcelDat("Advanced", 12, 3);
String Desc = SO_Excellib.getExcelDat("Advanced", 12, 4);
String Amount = SO_Excellib.getExcelDat("Advanced", 12, 5);
String RoundOff = SO_Excellib.getExcelDat("Advanced", 12, 12);
String Total = SO_Excellib.getExcelDat("Advanced", 12, 14);
BigDecimal Expected = new BigDecimal(Total);
Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.OtherIncome);
	driver.navigate().refresh();
	AD_RoundOff RecvIncm =PageFactory.initElements(driver, AD_RoundOff.class);
	RecvIncm.ReceiveAdvancedRound(CustId,Desc,Amount, RoundOff);
	BigDecimal Actual = new BigDecimal(AD_RoundOff.amt);
	Assert.assertEquals(Actual, Expected,"Total Amount not correct");
	System.out.println("total Amount verified");
}

}
