package com.Actouch.SalesINV.TestScript;
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
import com.Actouch.SalesINVLoc.pageObjectRepository.SOReceiveAdvPettyShp;
import com.Actouch.SalesINVLoc.pageObjectRepository.SRFull;
public class Receivable {
static WebDriver driver;
SO_Excellib SO_Excellib = new SO_Excellib("D:\\Selenium\\SaleOrderLOC.xlsx");
@Test(priority = 1)
		public void salesIN_Login_TC_1() throws Exception
		{
			//login
			driver = Browser.getbrowser();
		String usrid = SO_Excellib.getExcelDat("SO", 03, 03);
			 String pss = SO_Excellib.getExcelDat("SO", 03, 04);
				Browser.driver.get(Constant.Url);
			Login loginpage = PageFactory.initElements(driver, Login.class);
			loginpage.login(usrid, pss);
		Thread.sleep(3000);
			
			}
		
		@Test(priority=2)
		public void AR_Full_Recevable_Cash_TC_1() throws Exception
		{
			WebDriverCommonlib.waitForPageToLoad();
			 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
			 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
			 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
			 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
			 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
			 String total =SO_Excellib.getExcelDat("receivable", 02, 12);
			 BigDecimal expected = new BigDecimal(total);
			 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
			 driver.get(Constant.SalesOrder_new);
				driver.navigate().refresh();
				SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
			payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
			ARFullCashReceivable Arfull =PageFactory.initElements(driver, ARFullCashReceivable.class);
			Arfull.fullReceivable();
			BigDecimal Actual = new BigDecimal(ARFullCashReceivable.amt);	
			Assert.assertEquals(Actual,expected,"total amount not correct");
			 System.out.println("total Amount verified");
		}

		@Test(priority=3)
		public void AR_Partial_Recevable_Cash_TC_2() throws Exception
		{
			WebDriverCommonlib.waitForPageToLoad();
			 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
			 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
			 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
			 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
			 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
			 String partialAmt = SO_Excellib.getExcelDat("receivable", 03, 06);
			 String total =SO_Excellib.getExcelDat("receivable", 03, 12);
			 BigDecimal expected = new BigDecimal(total);
			 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
			 driver.get(Constant.SalesOrder_new);
				driver.navigate().refresh();
				SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
			payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
			ARPartialCashReceivable ARPartial = PageFactory.initElements(driver, ARPartialCashReceivable.class);
		ARPartial.PartialReceivable(partialAmt);
		BigDecimal Actual = new BigDecimal(ARPartialCashReceivable.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
		}
@Test(priority=4)
public void AR_Full_Recevable_Cheque_TC_3() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
		String cheqNo=SO_Excellib.getExcelDat("Additional", 11, 06);
		String bank =SO_Excellib.getExcelDat("Additional", 11, 07);
		 String total =SO_Excellib.getExcelDat("receivable", 04, 12);
		 BigDecimal expected = new BigDecimal(total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
	 driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
	ARFullChequeReceivable ARCHR =PageFactory.initElements(driver, ARFullChequeReceivable.class);
	ARCHR.fullChequeReceivable("HDFC", cheqNo, bank);
	BigDecimal Actual = new BigDecimal(ARFullChequeReceivable.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority = 5)
public void AR_Partial_Recevable_Cheque_TC_4() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String cheqNo=SO_Excellib.getExcelDat("Additional", 11, 06);
		String bank =SO_Excellib.getExcelDat("Additional", 11, 07);
		String partialAmt = SO_Excellib.getExcelDat("receivable", 05, 06);
		 String total =SO_Excellib.getExcelDat("receivable", 05, 12);
		 BigDecimal expected = new BigDecimal(total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
		 driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
ARPartialChequeReceivable ARPCHR = PageFactory.initElements(driver, ARPartialChequeReceivable.class);
	ARPCHR.ChequePartialReceivable(partialAmt, "HDFC", cheqNo, bank);
	BigDecimal Actual = new BigDecimal(ARPartialChequeReceivable.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}

@Test(priority = 6)
public void AR_Adjust_Payment_Advanced_TC_5() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 13, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 13, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 13, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 13, 16);
	 String Adv = SO_Excellib.getExcelDat("SO", 13, 22);
	 String taxCode = SO_Excellib.getExcelDat("SO", 13, 19);
	 String total =SO_Excellib.getExcelDat("receivable", 06, 12);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
	 driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();
		SOReceiveAdvPettyShp RcvAdvPttyshp = PageFactory.initElements(driver, SOReceiveAdvPettyShp.class);
		RcvAdvPttyshp.RcvAdvPttyshp(custID, prodID, Qnty,unitp,taxCode,Adv); 
	ARAdjustAdvanced ARAD = PageFactory.initElements(driver,ARAdjustAdvanced.class);
	ARAD.AdjustAdvanced();
	BigDecimal Actual = new BigDecimal(ARAdjustAdvanced.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
	 
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
	 String total =SO_Excellib.getExcelDat("receivable", 07, 12);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
	driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();
	SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
	Thread.sleep(1000);
	SRFull SRF =PageFactory.initElements(driver, SRFull.class);
	SRF.fullReturn(); 
	driver.get(Constant.SalesOrder_new);
	driver.navigate().refresh();
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
	ARAdjustSalesReturn ARSR = PageFactory.initElements(driver,ARAdjustSalesReturn.class);
ARSR.AdjustSalesReturn();
BigDecimal Actual = new BigDecimal(ARAdjustSalesReturn.amt);	
Assert.assertEquals(Actual,expected,"total amount not correct");
 System.out.println("total Amount verified");
	
}
@Test(priority=8)
public void AR_Disc_percentage_TC_7() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String Dis = SO_Excellib.getExcelDat("receivable", 8, 07);
	 String total =SO_Excellib.getExcelDat("receivable", 8, 12);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
	 driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
	ARCashDisPer ARCDP =PageFactory.initElements(driver, ARCashDisPer.class);
	ARCDP.Percentage_Dis(Dis);
	BigDecimal Actual = new BigDecimal(ARCashDisPer.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
	
}
@Test(priority=9)
public void AR_Disc_INR_TC_8() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String Dis = SO_Excellib.getExcelDat("receivable", 9, 07);
	 String total =SO_Excellib.getExcelDat("receivable", 9, 12);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
	 driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
ARCashDisINR ARCDI =PageFactory.initElements(driver, ARCashDisINR.class);
	ARCDI.INR_Dis(Dis);
	BigDecimal Actual = new BigDecimal(ARCashDisINR.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=10)
public void AR_Roundoff_TC_9() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String RoundOff = SO_Excellib.getExcelDat("receivable", 10, 10);
	 String total =SO_Excellib.getExcelDat("receivable", 10, 12);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
	 driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
	ARCashRoundOff ARCDR =PageFactory.initElements(driver, ARCashRoundOff.class);
	ARCDR.Round_OFF(RoundOff);
	BigDecimal Actual = new BigDecimal(ARCashRoundOff.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
	@Test(priority=11)
public void AR_VoucherAdjustment_TC_10() throws Exception
{
		WebDriverCommonlib.waitForPageToLoad();
String custID = SO_Excellib.getExcelDat("SO", 05, 8);
String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
String VoucherID = SO_Excellib.getExcelDat("receivable", 11, 8);
String VoucherAmt = SO_Excellib.getExcelDat("receivable", 11, 9);
String total =SO_Excellib.getExcelDat("receivable", 11, 12);
BigDecimal expected = new BigDecimal(total);
expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
driver.get(Constant.SalesOrder_new);
	driver.navigate().refresh();
	SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
		ARVoucherAdjustment ARCDV =PageFactory.initElements(driver, ARVoucherAdjustment.class);
ARCDV.fullReceivableVoucher(VoucherID,VoucherAmt);
BigDecimal Actual = new BigDecimal(ARVoucherAdjustment.amt);	
Assert.assertEquals(Actual,expected,"total amount not correct");
 System.out.println("total Amount verified");
		
	}
	
}
