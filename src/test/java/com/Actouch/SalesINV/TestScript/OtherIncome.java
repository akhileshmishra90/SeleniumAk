package com.Actouch.SalesINV.TestScript;
import java.math.BigDecimal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Actouch.OtherIncom.pageObjectRepository.OI_CashOnHand;
import com.Actouch.OtherIncom.pageObjectRepository.OI_Cheque;
import com.Actouch.OtherIncom.pageObjectRepository.OI_DisINR;
import com.Actouch.OtherIncom.pageObjectRepository.OI_DisPER;
import com.Actouch.OtherIncom.pageObjectRepository.OI_LineDiscount;
import com.Actouch.OtherIncom.pageObjectRepository.OI_Memo;
import com.Actouch.OtherIncom.pageObjectRepository.OI_MultiCurrency;
import com.Actouch.OtherIncom.pageObjectRepository.OI_ReceiveIncome;
import com.Actouch.OtherIncom.pageObjectRepository.OI_Reference;
import com.Actouch.OtherIncom.pageObjectRepository.OI_RoundOff;
import com.Actouch.OtherIncom.pageObjectRepository.OI_TDSDeduct;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.SO_Excellib;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
import com.Actouch.SalesINVLoc.pageObjectRepository.Login;
public class OtherIncome {
	static WebDriver driver;
	SO_Excellib SO_Excellib = new SO_Excellib("D:\\Selenium\\Other Income .xlsx");

@Test(priority = 1)
	public void salesIN_Login_TC_1() throws Exception
	{
	driver = Browser.getbrowser();
	String usrid = SO_Excellib.getExcelDat("Other Income", 00, 03);
		 String pss = SO_Excellib.getExcelDat("Other Income", 00, 04);
			Browser.driver.get(Constant.Url);
		Login loginpage = PageFactory.initElements(driver, Login.class);
		loginpage.login(usrid, pss);
	Thread.sleep(3000);
		;
	}
	@Test(priority=2)
	public void OI_Receive_Income_TC_1() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String CustId = SO_Excellib.getExcelDat("Other Income", 2, 3);
		String Desc = SO_Excellib.getExcelDat("Other Income", 2, 4);
		String Category = SO_Excellib.getExcelDat("Other Income", 2, 5);
		String Amount = SO_Excellib.getExcelDat("Other Income", 2, 6);
		String total = SO_Excellib.getExcelDat("Other Income", 2, 15);
		 BigDecimal expected = new BigDecimal(total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
	driver.get(Constant.OtherIncome);
		driver.navigate().refresh();
		OI_ReceiveIncome RecvIncm =PageFactory.initElements(driver, OI_ReceiveIncome.class);
		RecvIncm.ReceiveIncome(CustId, Desc, Category, Amount);
		BigDecimal Actual = new BigDecimal(OI_ReceiveIncome.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}

@Test(priority=3)
public void OI_Income_reference_TC_2() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String CustId = SO_Excellib.getExcelDat("Other Income", 3, 3);
	String Desc = SO_Excellib.getExcelDat("Other Income", 3, 4);
	String Category = SO_Excellib.getExcelDat("Other Income", 3, 5);
	String Amount = SO_Excellib.getExcelDat("Other Income", 3, 6);
	String Ref = SO_Excellib.getExcelDat("Other Income", 3, 7);
	String total = SO_Excellib.getExcelDat("Other Income", 3, 15);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
	driver.get(Constant.OtherIncome);	
	driver.navigate().refresh();	
	OI_Reference RecvIncm =PageFactory.initElements(driver, OI_Reference.class);
	RecvIncm.ReceiveIncomeRef(CustId, Desc, Category, Amount,Ref);
	BigDecimal Actual = new BigDecimal(OI_Reference.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
	
}
@Test(priority=4)
public void OI_Income_MultiCurrency_TC_3() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String CustId = SO_Excellib.getExcelDat("Other Income", 4, 3);
	String Desc = SO_Excellib.getExcelDat("Other Income", 4, 4);
	String Category = SO_Excellib.getExcelDat("Other Income", 4, 5);
	String Amount = SO_Excellib.getExcelDat("Other Income", 4, 6);
	String Currency = SO_Excellib.getExcelDat("Other Income", 4, 8);
	String Conversion = SO_Excellib.getExcelDat("Other Income", 4, 9);
	String total = SO_Excellib.getExcelDat("Other Income", 4, 15);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
	driver.get(Constant.OtherIncome);	
	driver.navigate().refresh();	
	OI_MultiCurrency RecvIncm =PageFactory.initElements(driver, OI_MultiCurrency.class);
	RecvIncm.ReceiveIncomeCur(CustId, Desc, Category, Amount,Currency,Conversion);
	BigDecimal Actual = new BigDecimal(OI_MultiCurrency.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=5)
public void OI_Deduct_TDS_TC_4() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String CustId = SO_Excellib.getExcelDat("Other Income", 5, 3);
	String Desc = SO_Excellib.getExcelDat("Other Income", 5, 4);
	String Category = SO_Excellib.getExcelDat("Other Income", 5, 5);
	String Amount = SO_Excellib.getExcelDat("Other Income", 5, 6);
	String Tax = SO_Excellib.getExcelDat("Other Income", 5, 10);
	String total = SO_Excellib.getExcelDat("Other Income", 5, 15);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
	driver.get(Constant.OtherIncome);
	driver.navigate().refresh();	
	OI_TDSDeduct RecvIncm =PageFactory.initElements(driver, OI_TDSDeduct.class);
	RecvIncm.ReceiveIncomeTDS(CustId, Desc, Category, Amount,Tax);
	BigDecimal Actual = new BigDecimal(OI_TDSDeduct.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=6)
public void OI_Line_Discount_TC_5() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String CustId = SO_Excellib.getExcelDat("Other Income", 6, 3);
	String Desc = SO_Excellib.getExcelDat("Other Income", 6, 4);
	String Category = SO_Excellib.getExcelDat("Other Income", 6, 5);
	String Amount = SO_Excellib.getExcelDat("Other Income", 6, 6);
	String Dis = SO_Excellib.getExcelDat("Other Income", 6, 11);
	String total = SO_Excellib.getExcelDat("Other Income", 6, 15);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
	driver.get(Constant.OtherIncome);	
	driver.navigate().refresh();	
	OI_LineDiscount LineDis =PageFactory.initElements(driver, OI_LineDiscount.class);
	LineDis.ReceiveIncomeline(CustId, Desc, Category, Amount,Dis);
	BigDecimal Actual = new BigDecimal(OI_LineDiscount.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=7)
public void OI_Income_Memo_TC_6() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String CustId = SO_Excellib.getExcelDat("Other Income", 7, 3);
	String Desc = SO_Excellib.getExcelDat("Other Income", 7, 4);
	String Category = SO_Excellib.getExcelDat("Other Income", 7, 5);
	String Amount = SO_Excellib.getExcelDat("Other Income", 7, 6);
	String Memo = SO_Excellib.getExcelDat("Other Income", 7, 12);
	String total = SO_Excellib.getExcelDat("Other Income", 7, 15);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
	driver.get(Constant.OtherIncome);	
	driver.navigate().refresh();
	OI_Memo memo =PageFactory.initElements(driver, OI_Memo.class);
	memo.ReceiveIncomeMemo(CustId, Desc, Category, Amount, Memo);
	BigDecimal Actual = new BigDecimal(OI_Memo.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=8)
public void OI_Income_Cheque_TC_7() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String CustId = SO_Excellib.getExcelDat("Other Income", 8, 3);
	String Desc = SO_Excellib.getExcelDat("Other Income", 8, 4);
	String Category = SO_Excellib.getExcelDat("Other Income", 8, 5);
	String Amount = SO_Excellib.getExcelDat("Other Income", 8, 6);
	String total = SO_Excellib.getExcelDat("Other Income", 8, 15);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
	driver.get(Constant.OtherIncome);	
	driver.navigate().refresh();	
	OI_Cheque cheque =PageFactory.initElements(driver, OI_Cheque.class);
	cheque.ReceiveIncomeCheque(CustId, Desc, Category, Amount, "HDFC", "ChequeNo", "RecvdbankName");
	BigDecimal Actual = new BigDecimal(OI_Cheque.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=9)
public void OI_Income_CashOnHand_TC_8() throws Exception
{ 
	WebDriverCommonlib.waitForPageToLoad();
	String CustId = SO_Excellib.getExcelDat("Other Income", 9, 3);
	String Desc = SO_Excellib.getExcelDat("Other Income", 9, 4);
	String Category = SO_Excellib.getExcelDat("Other Income", 9, 5);
	String Amount = SO_Excellib.getExcelDat("Other Income", 9, 6);
	String total = SO_Excellib.getExcelDat("Other Income", 9, 15);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
	driver.get(Constant.OtherIncome);	
	driver.navigate().refresh();	
	OI_CashOnHand Cash =PageFactory.initElements(driver, OI_CashOnHand.class);
	Cash.ReceiveIncomeCash(CustId, Desc, Category, Amount, "0C1010");
	BigDecimal Actual = new BigDecimal(OI_CashOnHand.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=10)
public void OI_Discount_percentage_TC_9() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String CustId = SO_Excellib.getExcelDat("Other Income", 10, 3);
	String Desc = SO_Excellib.getExcelDat("Other Income", 10, 4);
	String Category = SO_Excellib.getExcelDat("Other Income", 10, 5);
	String Amount = SO_Excellib.getExcelDat("Other Income", 10, 6);
	String Dis = SO_Excellib.getExcelDat("Other Income", 10, 11);
	String total = SO_Excellib.getExcelDat("Other Income", 10, 15);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
driver.get(Constant.OtherIncome);
driver.navigate().refresh();
OI_DisPER CashDis =PageFactory.initElements(driver, OI_DisPER.class);
CashDis.ReceiveIncomeDisP(CustId, Desc, Category, Amount, "0C1010",Dis);
BigDecimal Actual = new BigDecimal(OI_DisPER.amt);	
Assert.assertEquals(Actual,expected,"total amount not correct");
 System.out.println("total Amount verified");
}
@Test(priority=11)
public void OI_Discount_INR_TC_10() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String CustId = SO_Excellib.getExcelDat("Other Income", 11, 3);
	String Desc = SO_Excellib.getExcelDat("Other Income", 11, 4);
	String Category = SO_Excellib.getExcelDat("Other Income", 11, 5);
	String Amount = SO_Excellib.getExcelDat("Other Income", 11, 6);
	String Dis = SO_Excellib.getExcelDat("Other Income", 11, 11);
	String total = SO_Excellib.getExcelDat("Other Income", 11, 15);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
	driver.get(Constant.OtherIncome);	
	driver.navigate().refresh();	
	OI_DisINR CashDis =PageFactory.initElements(driver, OI_DisINR.class);
	CashDis.ReceiveIncomeDisINR(CustId, Desc, Category, Amount, "0C1010",Dis);
	BigDecimal Actual = new BigDecimal(OI_DisINR.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=12)
public void OI_RoundOff_TC_11() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String CustId = SO_Excellib.getExcelDat("Other Income", 12, 3);
	String Desc = SO_Excellib.getExcelDat("Other Income", 12, 4);
	String Category = SO_Excellib.getExcelDat("Other Income", 12, 5);
	String Amount = SO_Excellib.getExcelDat("Other Income", 12, 6);
	String Roundoff = SO_Excellib.getExcelDat("Other Income", 12, 13);
	String total = SO_Excellib.getExcelDat("Other Income", 12, 15);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
	driver.get(Constant.OtherIncome);	
	driver.navigate().refresh();	
	OI_RoundOff RecvIncm =PageFactory.initElements(driver, OI_RoundOff.class);
	RecvIncm.ReceiveIncomeRound(CustId, Desc, Category, Amount,Roundoff);
	BigDecimal Actual = new BigDecimal(OI_RoundOff.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}

}
