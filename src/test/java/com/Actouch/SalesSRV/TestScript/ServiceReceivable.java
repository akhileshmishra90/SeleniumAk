package com.Actouch.SalesSRV.TestScript;
import java.math.BigDecimal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.SO_Excellib;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
import com.Actouch.SalesINVLoc.pageObjectRepository.ARAdjustAdvanced;
import com.Actouch.SalesINVLoc.pageObjectRepository.ARAdjustSalesReturn;
import com.Actouch.SalesINVLoc.pageObjectRepository.ARCashDisINR;
import com.Actouch.SalesINVLoc.pageObjectRepository.ARCashDisPer;
import com.Actouch.SalesINVLoc.pageObjectRepository.ARCashRoundOff;
import com.Actouch.SalesINVLoc.pageObjectRepository.ARFullCashReceivable;
import com.Actouch.SalesINVLoc.pageObjectRepository.ARFullChequeReceivable;
import com.Actouch.SalesINVLoc.pageObjectRepository.ARPartialCashReceivable;
import com.Actouch.SalesINVLoc.pageObjectRepository.ARPartialChequeReceivable;
import com.Actouch.SalesINVLoc.pageObjectRepository.ARVoucherAdjustment;
import com.Actouch.SalesINVLoc.pageObjectRepository.Login;
import com.Actouch.SalesINVLoc.pageObjectRepository.SOPaymentLaterShipnow;
import com.Actouch.SalesINVLoc.pageObjectRepository.SRFull;
import com.Actouch.SalesSRV.pageObjectRepository.SRVAdvPettyDlv;
import com.Actouch.SalesSRV.pageObjectRepository.SRVPaymentlaterDlv;

public class ServiceReceivable {
	static WebDriver driver;
	SO_Excellib SO_Excellib = new SO_Excellib("D:\\Selenium\\SO Service .xlsx");
	@Test(priority = 1)
	public void salesIN_Login_TC_1() throws Exception
	{
		//login
		driver = Browser.getbrowser();
		String usrid = SO_Excellib.getExcelDat("SOSRV", 03, 04);
		 String pss = SO_Excellib.getExcelDat("SOSRV", 03, 05);
			Browser.driver.get(Constant.Url);
		Login loginpage = PageFactory.initElements(driver, Login.class);
		loginpage.login(usrid, pss);
	
		Thread.sleep(3000);
		
		}
	
	@Test(priority=2)
	public void AR_Full_Recevable_Cash_TC_1() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String Cust = SO_Excellib.getExcelDat("SOSRV",05, 9);
		String Desc =SO_Excellib.getExcelDat("SOSRV",05, 12);
		String Category = SO_Excellib.getExcelDat("SOSRV",05, 13);
		String Price = SO_Excellib.getExcelDat("SOSRV",05, 14);
		String Total = SO_Excellib.getExcelDat("receivable",02, 12);
		BigDecimal expected =new BigDecimal(Total);
		expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesService);
		driver.navigate().refresh();
				SRVPaymentlaterDlv payltrDl=PageFactory.initElements(driver, SRVPaymentlaterDlv.class);
		payltrDl.payLtrDlv(Cust,Desc, Category, Price,"Yes");
		ARFullCashReceivable Arfull =PageFactory.initElements(driver, ARFullCashReceivable.class);
		Arfull.fullReceivable();
		BigDecimal Actual = new BigDecimal(ARFullCashReceivable.amt);
		Assert.assertEquals(Actual, expected,"Total Amount is not correct");
	System.out.println("Total Amount is verified ");
	}
	 
	@Test(priority=3)
	public void AR_Partial_Recevable_Cash_TC_2() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String Cust = SO_Excellib.getExcelDat("SOSRV",05, 9);
		String Desc =SO_Excellib.getExcelDat("SOSRV",05, 12);
		String Category = SO_Excellib.getExcelDat("SOSRV",05, 13);
		String Price = SO_Excellib.getExcelDat("SOSRV",05, 14);
		String Total = SO_Excellib.getExcelDat("receivable",03, 12);
		String partialAmt = SO_Excellib.getExcelDat("receivable", 03, 06);
		BigDecimal expected =new BigDecimal(Total);
		expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesService);
		driver.navigate().refresh();
				SRVPaymentlaterDlv payltrDl=PageFactory.initElements(driver, SRVPaymentlaterDlv.class);
		payltrDl.payLtrDlv(Cust,Desc, Category, Price,"Yes");
		ARPartialCashReceivable ARPartial = PageFactory.initElements(driver, ARPartialCashReceivable.class);
	ARPartial.PartialReceivable(partialAmt);
	BigDecimal Actual = new BigDecimal(ARPartialCashReceivable.amt);
	Assert.assertEquals(Actual, expected,"Total Amount is not correct");
System.out.println("Total Amount is verified ");
	}
@Test(priority=4)
public void AR_Full_Recevable_Cheque_TC_3()throws Exception
{
WebDriverCommonlib.waitForPageToLoad();
String Cust = SO_Excellib.getExcelDat("SOSRV",05, 9);
String Desc =SO_Excellib.getExcelDat("SOSRV",05, 12);
String Category = SO_Excellib.getExcelDat("SOSRV",05, 13);
String Price = SO_Excellib.getExcelDat("SOSRV",05, 14);
String Total = SO_Excellib.getExcelDat("receivable",04, 12);
	String cheqNo=SO_Excellib.getExcelDat("Additional", 11, 06);
	String bank =SO_Excellib.getExcelDat("Additional", 11, 07);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
			SRVPaymentlaterDlv payltrDl=PageFactory.initElements(driver, SRVPaymentlaterDlv.class);
	payltrDl.payLtrDlv(Cust,Desc, Category, Price,"Yes");
ARFullChequeReceivable ARCHR =PageFactory.initElements(driver, ARFullChequeReceivable.class);
ARCHR.fullChequeReceivable("HDFC", cheqNo, bank);
BigDecimal Actual = new BigDecimal(ARFullChequeReceivable.amt);
Assert.assertEquals(Actual, expected,"Total Amount is not correct");
System.out.println("Total Amount is verified ");
}
@Test(priority = 5)
public void AR_Partial_Recevable_Cheque_TC_4() throws Exception
{
WebDriverCommonlib.waitForPageToLoad();
String Cust = SO_Excellib.getExcelDat("SOSRV",05, 9);
String Desc =SO_Excellib.getExcelDat("SOSRV",05, 12);
String Category = SO_Excellib.getExcelDat("SOSRV",05, 13);
String Price = SO_Excellib.getExcelDat("SOSRV",05, 14);
String Total = SO_Excellib.getExcelDat("receivable",05, 12);
 String cheqNo=SO_Excellib.getExcelDat("Additional", 11, 06);
	String bank =SO_Excellib.getExcelDat("Additional", 11, 07);
	String partialAmt = SO_Excellib.getExcelDat("receivable", 05, 06);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
			SRVPaymentlaterDlv payltrDl=PageFactory.initElements(driver, SRVPaymentlaterDlv.class);
	payltrDl.payLtrDlv(Cust,Desc, Category, Price,"Yes");
ARPartialChequeReceivable ARPCHR = PageFactory.initElements(driver, ARPartialChequeReceivable.class);
ARPCHR.ChequePartialReceivable(partialAmt, "HDFC", cheqNo, bank);
BigDecimal Actual = new BigDecimal(ARPartialChequeReceivable.amt);
Assert.assertEquals(Actual, expected,"Total Amount is not correct");
System.out.println("Total Amount is verified ");
}

@Test(priority = 6)
public void AR_Adjust_Payment_Advanced_TC_5() throws Exception
{
WebDriverCommonlib.waitForPageToLoad();
String Cust = SO_Excellib.getExcelDat("SOSRV",11, 9);
String Desc =SO_Excellib.getExcelDat("SOSRV",11, 12);
String Category = SO_Excellib.getExcelDat("SOSRV",11, 13);
String Price = SO_Excellib.getExcelDat("SOSRV",11, 14);
String Adv = SO_Excellib.getExcelDat("SOSRV",11, 19);
String Total = SO_Excellib.getExcelDat("receivable",06, 12);
BigDecimal expected = new BigDecimal(Total);
		expected=expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesService);
		driver.navigate().refresh();
		SRVAdvPettyDlv RcvAdvDlv = PageFactory.initElements(driver, SRVAdvPettyDlv.class);
		RcvAdvDlv.ReceiveAdvCash(Cust,Desc, Category, Price, Adv,"0C1000", "Yes");

ARAdjustAdvanced ARAD = PageFactory.initElements(driver,ARAdjustAdvanced.class);
ARAD.AdjustAdvanced();
BigDecimal Actual = new BigDecimal(ARAdjustAdvanced.amt);
Assert.assertEquals(Actual, expected,"Total Amount is not correct");
System.out.println("Total Amount is verified ");
}

@Test(priority = 7)
public void AR_Adjust_Payment_SaleReturn_TC_6() throws Exception
{
WebDriverCommonlib.waitForPageToLoad();
 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
driver.get(Constant.SalesOrder_new);
	driver.navigate().refresh();
	SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
SRFull SRF =PageFactory.initElements(driver, SRFull.class);
SRF.fullReturn(); 
driver.get(Constant.SalesOrder_new);
driver.navigate().refresh();
payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
ARAdjustSalesReturn ARSR = PageFactory.initElements(driver,ARAdjustSalesReturn.class);
ARSR.AdjustSalesReturn();

} 
@Test(priority=8)
public void AR_Disc_percentage_TC_7() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",05, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",05, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",05, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",05, 14);
	String Total = SO_Excellib.getExcelDat("receivable",8, 12);
	String Dis = SO_Excellib.getExcelDat("receivable", 8, 07);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
			SRVPaymentlaterDlv payltrDl=PageFactory.initElements(driver, SRVPaymentlaterDlv.class);
	payltrDl.payLtrDlv(Cust,Desc, Category, Price,"Yes");
ARCashDisPer ARCDP =PageFactory.initElements(driver, ARCashDisPer.class);
ARCDP.Percentage_Dis(Dis);
BigDecimal Actual = new BigDecimal(ARCashDisPer.amt);
Assert.assertEquals(Actual, expected,"Total Amount is not correct");
System.out.println("Total Amount is verified ");

}
@Test(priority=9)
public void AR_Disc_INR_TC_8() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",05, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",05, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",05, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",05, 14);
	String Total = SO_Excellib.getExcelDat("receivable",9, 12);
	String Dis = SO_Excellib.getExcelDat("receivable", 9, 07);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
			SRVPaymentlaterDlv payltrDl=PageFactory.initElements(driver, SRVPaymentlaterDlv.class);
	payltrDl.payLtrDlv(Cust,Desc, Category, Price,"Yes");
ARCashDisINR ARCDI =PageFactory.initElements(driver, ARCashDisINR.class);
ARCDI.INR_Dis(Dis);
BigDecimal Actual = new BigDecimal(ARCashDisINR.amt);
Assert.assertEquals(Actual, expected,"Total Amount is not correct");
System.out.println("Total Amount is verified ");
}
@Test(priority=10)
public void AR_Roundoff_TC_9() throws Exception
{
WebDriverCommonlib.waitForPageToLoad();
String Cust = SO_Excellib.getExcelDat("SOSRV",05, 9);
String Desc =SO_Excellib.getExcelDat("SOSRV",05, 12);
String Category = SO_Excellib.getExcelDat("SOSRV",05, 13);
String Price = SO_Excellib.getExcelDat("SOSRV",05, 14);
String Total = SO_Excellib.getExcelDat("receivable",10, 12);
 String RoundOff = SO_Excellib.getExcelDat("receivable", 10, 10);
 BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
			SRVPaymentlaterDlv payltrDl=PageFactory.initElements(driver, SRVPaymentlaterDlv.class);
	payltrDl.payLtrDlv(Cust,Desc, Category, Price,"Yes");
ARCashRoundOff ARCDR =PageFactory.initElements(driver, ARCashRoundOff.class);
ARCDR.Round_OFF(RoundOff);
BigDecimal Actual = new BigDecimal(ARCashRoundOff.amt);
Assert.assertEquals(Actual, expected,"Total Amount is not correct");
System.out.println("Total Amount is verified ");
}
@Test(priority=11)
public void AR_VoucherAdjustment_TC_10() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",05, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",05, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",05, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",11, 12);
	String Total = SO_Excellib.getExcelDat("receivable",11, 25);
String VoucherID = SO_Excellib.getExcelDat("receivable", 11, 8);
String VoucherAmt = SO_Excellib.getExcelDat("receivable", 11, 9);
BigDecimal expected =new BigDecimal(Total);
expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
driver.get(Constant.SalesService);
driver.navigate().refresh();
		SRVPaymentlaterDlv payltrDl=PageFactory.initElements(driver, SRVPaymentlaterDlv.class);
payltrDl.payLtrDlv(Cust,Desc, Category, Price,"Yes");
ARVoucherAdjustment ARCDV =PageFactory.initElements(driver, ARVoucherAdjustment.class);
ARCDV.fullReceivableVoucher(VoucherID,VoucherAmt);
BigDecimal Actual = new BigDecimal(ARVoucherAdjustment.amt);
Assert.assertEquals(Actual, expected,"Total Amount is not correct");
System.out.println("Total Amount is verified ");
	
}

}
