package com.Actouch.PurchaseINV.TestScript;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Actouch.OtherIncom.pageObjectRepository.OE_CashOnHand;
import com.Actouch.OtherIncom.pageObjectRepository.OE_Cheque;
import com.Actouch.OtherIncom.pageObjectRepository.OE_DisINR;
import com.Actouch.OtherIncom.pageObjectRepository.OE_DisPER;
import com.Actouch.OtherIncom.pageObjectRepository.OE_LineDiscount;
import com.Actouch.OtherIncom.pageObjectRepository.OE_Memo;
import com.Actouch.OtherIncom.pageObjectRepository.OE_MultiCurrency;
import com.Actouch.OtherIncom.pageObjectRepository.OE_PayExpenses;
import com.Actouch.OtherIncom.pageObjectRepository.OE_Reference;
import com.Actouch.OtherIncom.pageObjectRepository.OE_RoundOff;
import com.Actouch.OtherIncom.pageObjectRepository.OE_TDSDeduct;
import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.POExcelLib;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;
import com.Actouch.PurchaseINV.pageObjectRepository.Login;
public class OtherExpenses {
static WebDriver driver;
com.Actouch.Sales.generic_Lib.SO_Excellib SO_Excellib = new com.Actouch.Sales.generic_Lib.SO_Excellib("D:\\Selenium\\SaleOrderWSWL.xlsx");
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
	
	@Test(priority =2)
	public void OE_Pay_Expenses_TC_1() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String SuppID = SO_Excellib.getExcelDat("Other Expenses",2,3);
		String Desc = SO_Excellib.getExcelDat("Other Expenses", 2, 4);
		String Category = SO_Excellib.getExcelDat("Other Expenses", 2, 5);
		String Amount = SO_Excellib.getExcelDat("Other Expenses", 2, 6);
		String Total = SO_Excellib.getExcelDat("Other Expenses", 2, 15);
		BigDecimal Expected = new BigDecimal(Total);
		Expected=Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.OtherExpenses);
		driver.navigate().refresh();
		OE_PayExpenses PaYExpenses =PageFactory.initElements(driver, OE_PayExpenses.class);
		PaYExpenses.PayExpenses(SuppID, Desc, Category, Amount);
		BigDecimal Actual = new BigDecimal(OE_PayExpenses.amt);	
		Assert.assertEquals(Actual,Expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}
@Test(priority=3)
public void OE_Expenses_reference_TC_2()throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String SuppID = SO_Excellib.getExcelDat("Other Expenses", 3, 3);
	String Desc = SO_Excellib.getExcelDat("Other Expenses", 3, 4);
	String Category = SO_Excellib.getExcelDat("Other Expenses", 3, 5);
	String Amount = SO_Excellib.getExcelDat("Other Expenses", 3, 6);
	String Ref = SO_Excellib.getExcelDat("Other Expenses", 3, 7);
	String Total = SO_Excellib.getExcelDat("Other Expenses", 3, 15);
	BigDecimal Expected = new BigDecimal(Total);
	Expected=Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.OtherExpenses);
	driver.navigate().refresh();
	OE_Reference ExpRef = PageFactory.initElements(driver, OE_Reference.class);
	ExpRef.PayExpensesRef(SuppID, Desc, Category, Amount, Ref);
	BigDecimal Actual = new BigDecimal(OE_Reference.amt);	
	Assert.assertEquals(Actual,Expected,"total amount not correct");
	 System.out.println("total Amount verified");
	
}
@Test(priority = 4)
public void OE_Expenses_MultiCurrency_TC_3() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String SuppID = SO_Excellib.getExcelDat("Other Expenses", 4, 3);
	String Desc = SO_Excellib.getExcelDat("Other Expenses", 4, 4);
	String Category = SO_Excellib.getExcelDat("Other Expenses", 4, 5);
	String Amount = SO_Excellib.getExcelDat("Other Expenses", 4, 6);
	String Currency = SO_Excellib.getExcelDat("Other Expenses", 4, 8);
	String Conversion = SO_Excellib.getExcelDat("Other Expenses", 4, 9);
	String Total = SO_Excellib.getExcelDat("Other Expenses", 4, 15);
	BigDecimal Expected = new BigDecimal(Total);
	Expected=Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.OtherExpenses);
	driver.navigate().refresh();
	OE_MultiCurrency ExpMulCurr= PageFactory.initElements(driver, OE_MultiCurrency.class);
	ExpMulCurr.PayExpensesCurrency(SuppID, Desc, Category, Amount, Currency, Conversion);
	BigDecimal Actual = new BigDecimal(OE_MultiCurrency.amt);	
	Assert.assertEquals(Actual,Expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=5)
public void OE_Deduct_TDS_TC_4() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String SuppID = SO_Excellib.getExcelDat("Other Expenses", 5, 3);
	String Desc = SO_Excellib.getExcelDat("Other Expenses", 5, 4);
	String Category = SO_Excellib.getExcelDat("Other Expenses", 5, 5);
	String Amount = SO_Excellib.getExcelDat("Other Expenses", 5, 6);
	String Tax = SO_Excellib.getExcelDat("Other Expenses", 5, 10);
	String Total = SO_Excellib.getExcelDat("Other Expenses", 5, 15);
	BigDecimal Expected = new BigDecimal(Total);
	Expected=Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.OtherExpenses);
	driver.navigate().refresh();
	OE_TDSDeduct ExpTDS = PageFactory.initElements(driver, OE_TDSDeduct.class);
	ExpTDS.PayExpensesTDS(SuppID, Desc, Category, Amount, Tax);
	BigDecimal Actual = new BigDecimal(OE_TDSDeduct.amt);	
	Assert.assertEquals(Actual,Expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=6)
public void OE_Line_Discount_TC_5() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String SuppID = SO_Excellib.getExcelDat("Other Expenses", 6, 3);
	String Desc = SO_Excellib.getExcelDat("Other Expenses", 6, 4);
	String Category = SO_Excellib.getExcelDat("Other Expenses", 6, 5);
	String Amount = SO_Excellib.getExcelDat("Other Expenses", 6, 6);
	String Dis = SO_Excellib.getExcelDat("Other Expenses", 6, 11);
	String Total = SO_Excellib.getExcelDat("Other Expenses", 6, 15);
	BigDecimal Expected = new BigDecimal(Total);
	Expected=Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.OtherExpenses);
	driver.navigate().refresh();
	OE_LineDiscount ExpLDsp=PageFactory.initElements(driver, OE_LineDiscount.class);
	ExpLDsp.PayExpensesLDsp(SuppID, Desc, Category, Amount, Dis);
	BigDecimal Actual = new BigDecimal(OE_LineDiscount.amt);	
	Assert.assertEquals(Actual,Expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=7)
public void OE_Expenses_Memo_TC_6() throws Exception
{ 
	WebDriverCommonlib.waitForPageToLoad();
	String SuppID = SO_Excellib.getExcelDat("Other Expenses", 7, 3);
	String Desc = SO_Excellib.getExcelDat("Other Expenses", 7, 4);
	String Category = SO_Excellib.getExcelDat("Other Expenses", 7, 5);
	String Amount = SO_Excellib.getExcelDat("Other Expenses", 7, 6);
	String Memo = SO_Excellib.getExcelDat("Other Expenses", 7, 12);
	String Total = SO_Excellib.getExcelDat("Other Expenses", 7, 15);
	BigDecimal Expected = new BigDecimal(Total);
	Expected=Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.OtherExpenses);
	driver.navigate().refresh();
	OE_Memo ExpMemo =PageFactory.initElements(driver, OE_Memo.class);
	ExpMemo.PayExpensesMemo(SuppID, Desc, Category, Amount, Memo);
	BigDecimal Actual = new BigDecimal(OE_Memo.amt);	
	Assert.assertEquals(Actual,Expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
 @Test(priority=8)
 public void OE_Expenses_Cheque_TC_7() throws Exception
 {
	 WebDriverCommonlib.waitForPageToLoad();
	 String SuppID = SO_Excellib.getExcelDat("Other Expenses", 8, 3);
		String Desc = SO_Excellib.getExcelDat("Other Expenses", 8, 4);
		String Category = SO_Excellib.getExcelDat("Other Expenses", 8, 5);
		String Amount = SO_Excellib.getExcelDat("Other Expenses", 8, 6);
		String Total = SO_Excellib.getExcelDat("Other Expenses", 8, 15);
		BigDecimal Expected = new BigDecimal(Total);
		Expected=Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 driver.get(Constant.OtherExpenses);
		driver.navigate().refresh();
		OE_Cheque ExpCheq =PageFactory.initElements(driver, OE_Cheque.class); 
		ExpCheq.PayExpensesCheq(SuppID, Desc, Category, Amount, "HDFC", "ChequeNo");
		BigDecimal Actual = new BigDecimal(OE_Cheque.amt);	
		Assert.assertEquals(Actual,Expected,"total amount not correct");
		 System.out.println("total Amount verified");
 }
@Test(priority=9)
public void OE_Expenses_CashOnHand_TC_8() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String SuppID = SO_Excellib.getExcelDat("Other Expenses", 9, 3);
	String Desc = SO_Excellib.getExcelDat("Other Expenses", 9, 4);
	String Category = SO_Excellib.getExcelDat("Other Expenses", 9, 5);
	String Amount = SO_Excellib.getExcelDat("Other Expenses", 9, 6);
	String Total = SO_Excellib.getExcelDat("Other Expenses", 9, 15);
	BigDecimal Expected = new BigDecimal(Total);
	Expected=Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.OtherExpenses);
	driver.navigate().refresh();
	OE_CashOnHand ExpCash = PageFactory.initElements(driver, OE_CashOnHand.class);
	ExpCash.PayExpensesCash(SuppID, Desc, Category, Amount, "0C1010");
	BigDecimal Actual = new BigDecimal(OE_CashOnHand.amt);	
	Assert.assertEquals(Actual,Expected,"total amount not correct");
	 System.out.println("total Amount verified");
	
}
@Test(priority=10)
public void OE_Discount_percentage_TC_9() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String SuppID = SO_Excellib.getExcelDat("Other Expenses", 10, 3);
	String Desc = SO_Excellib.getExcelDat("Other Expenses", 10, 4);
	String Category = SO_Excellib.getExcelDat("Other Expenses", 10, 5);
	String Amount = SO_Excellib.getExcelDat("Other Expenses", 10, 6);
	String Dis = SO_Excellib.getExcelDat("Other Expenses", 10, 11);
	String Total = SO_Excellib.getExcelDat("Other Expenses", 10, 15);
	BigDecimal Expected = new BigDecimal(Total);
	Expected=Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.OtherExpenses);
	driver.navigate().refresh();
	OE_DisPER ExpDisP = PageFactory.initElements(driver, OE_DisPER.class);
	ExpDisP.PayExpensesDisp(SuppID, Desc, Category, Amount, Dis);
	BigDecimal Actual = new BigDecimal(OE_DisPER.amt);	
	Assert.assertEquals(Actual,Expected,"total amount not correct");
	 System.out.println("total Amount verified");
	

	
}
@Test(priority=11)
public void OE_Discount_INR_TC_10() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String SuppID = SO_Excellib.getExcelDat("Other Expenses", 11, 3);
	String Desc = SO_Excellib.getExcelDat("Other Expenses", 11, 4);
	String Category = SO_Excellib.getExcelDat("Other Expenses", 11, 5);
	String Amount = SO_Excellib.getExcelDat("Other Expenses", 11, 6);
	String Dis = SO_Excellib.getExcelDat("Other Expenses", 11, 11);
	String Total = SO_Excellib.getExcelDat("Other Expenses",11, 15);
	BigDecimal Expected = new BigDecimal(Total);
	Expected=Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.OtherExpenses);
	driver.navigate().refresh();
	OE_DisINR ExpDisN = PageFactory.initElements(driver, OE_DisINR.class);
	ExpDisN.PayExpensesDisI(SuppID, Desc, Category, Amount, Dis);
	BigDecimal Actual = new BigDecimal(OE_DisINR.amt);	
	Assert.assertEquals(Actual,Expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=12)
public void OE_RoundOff_TC_11() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String SuppID = SO_Excellib.getExcelDat("Other Expenses", 12, 3);
	String Desc = SO_Excellib.getExcelDat("Other Expenses", 12, 4);
	String Category = SO_Excellib.getExcelDat("Other Expenses", 12, 5);
	String Amount = SO_Excellib.getExcelDat("Other Expenses", 12, 6);
	String Roundoff = SO_Excellib.getExcelDat("Other Expenses", 12, 13);
	String Total = SO_Excellib.getExcelDat("Other Expenses", 12, 15);
	BigDecimal Expected = new BigDecimal(Total);
	Expected=Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.OtherExpenses);
	driver.navigate().refresh();
	OE_RoundOff ExpR = PageFactory.initElements(driver,OE_RoundOff.class);
	ExpR.PayExpensesRound(SuppID, Desc, Category, Amount, Roundoff);
	BigDecimal Actual = new BigDecimal(OE_RoundOff.amt);	
	Assert.assertEquals(Actual,Expected,"total amount not correct");
	 System.out.println("total Amount verified");
	
}

}
