package com.Actouch.PurchaseINV.TestScript;

import java.math.BigDecimal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.POExcelLib;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;
import com.Actouch.PurchaseINV.pageObjectRepository.APAdjustAdvanced;
import com.Actouch.PurchaseINV.pageObjectRepository.APAdjustPurchaseReturn;
import com.Actouch.PurchaseINV.pageObjectRepository.APCashDisPer;
import com.Actouch.PurchaseINV.pageObjectRepository.APCashDiscINR;
import com.Actouch.PurchaseINV.pageObjectRepository.APCashRoundOff;
import com.Actouch.PurchaseINV.pageObjectRepository.APFullCashPayment;
import com.Actouch.PurchaseINV.pageObjectRepository.APFullChequePayment;
import com.Actouch.PurchaseINV.pageObjectRepository.APPartialCashPayment;
import com.Actouch.PurchaseINV.pageObjectRepository.APPartialChequePayment;
import com.Actouch.PurchaseINV.pageObjectRepository.APVoucherAdjustment;
import com.Actouch.PurchaseINV.pageObjectRepository.Login;
import com.Actouch.PurchaseINV.pageObjectRepository.PRR_FullReturn;
import com.Actouch.PurchaseINV.pageObjectRepository.POPayAdvPettyRecp;
import com.Actouch.PurchaseINV.pageObjectRepository.POPaymentLaterRecvnow;

public class Payable {
static WebDriver driver = com.Actouch.Purchase.generic_Lib.Browser.getbrowser();
	
	
	
	//-------------------Test scenario for Login into application-----------------------------
	@Test(priority=1)
	public void purchaseIN_Login_TC1() throws Exception
	{
		driver.get(Constant.Url);
		
		//login
		 String usrId = POExcelLib.getExcelData("PO", 03, 03);
		 String psw = POExcelLib.getExcelData("PO", 03, 04);
		
		Login loginpage = PageFactory.initElements(driver, Login.class);
		loginpage.login(usrId, psw);
		Thread.sleep(5000);		
	}
	//-------------------Test scenario for create PO with payment Later-------------------------- 
	@Test(priority=2)
	public void purchaseIN_payltr_recvNow_TC3() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		 String suppID = POExcelLib.getExcelData("PO", 5, 8);
		 String prodID = POExcelLib.getExcelData("PO", 5, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
		 String unitp = POExcelLib.getExcelData("PO", 5, 21);
		 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
		 String payType = POExcelLib.getExcelData("PO", 5, 28);
driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
			POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
			payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
			APFullCashPayment APfull = PageFactory.initElements(driver, APFullCashPayment.class);
			APfull.Fullpayment();

	}
	@Test(priority=3)
	public void AP_Partial_Payment_Cash_TC_2() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		 String suppID = POExcelLib.getExcelData("PO", 5, 8);
		 String prodID = POExcelLib.getExcelData("PO", 5, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
		 String unitp = POExcelLib.getExcelData("PO", 5, 21);
		 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
		 String payType = POExcelLib.getExcelData("PO", 5, 28);
		 String partialAmt = POExcelLib.getExcelData("Payable", 03, 06);
		 String Total = POExcelLib.getExcelData("Payable", 03, 12);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
			driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
			POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
			payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
			APPartialCashPayment APPartial = PageFactory.initElements(driver, APPartialCashPayment.class);
			APPartial.PartialPayment(partialAmt);
			BigDecimal Actual = new BigDecimal(APPartialCashPayment.amt);	
			Assert.assertEquals(Actual,expected,"total amount not correct");
			 System.out.println("total Amount verified");
	}
	@Test(priority=4)
	public void AP_Full_Payment_Cheque_TC_3() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		 String suppID = POExcelLib.getExcelData("PO", 5, 8);
		 String prodID = POExcelLib.getExcelData("PO", 5, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
		 String unitp = POExcelLib.getExcelData("PO", 5, 21);
		 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
		 String payType = POExcelLib.getExcelData("PO", 5, 28);
		 String Bank = POExcelLib.getExcelData("Add_details", 6, 5);
		 String Chequeno = POExcelLib.getExcelData("Add_details", 6, 6);
		 String Total = POExcelLib.getExcelData("Payable", 04, 12);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
			driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
			POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
			payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
			APFullChequePayment FullCheque = PageFactory.initElements(driver, APFullChequePayment.class);
			FullCheque.FullCheque(Bank, Chequeno);
			BigDecimal Actual = new BigDecimal(APFullChequePayment.amt);	
			Assert.assertEquals(Actual,expected,"total amount not correct");
			 System.out.println("total Amount verified");
	}

@Test(priority=5)
public void AP_Partial_Payment_Cheque_TC_4() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String suppID = POExcelLib.getExcelData("PO", 5, 8);
	 String prodID = POExcelLib.getExcelData("PO", 5, 14);
	 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
	 String unitp = POExcelLib.getExcelData("PO", 5, 21);
	 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
	 String payType = POExcelLib.getExcelData("PO", 5, 28);
	 String partialAmt = POExcelLib.getExcelData("PO", 5,06);
	 String Bank = POExcelLib.getExcelData("Add_details", 6, 5);
	 String Chequeno = POExcelLib.getExcelData("Add_details", 6, 6);
	 String Total = POExcelLib.getExcelData("Payable", 05, 12);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
	driver.navigate().refresh();
		POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
		payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
		APPartialChequePayment PartialCheque = PageFactory.initElements(driver, APPartialChequePayment.class);
		PartialCheque.partialCheque(Bank, Chequeno,partialAmt);
		BigDecimal Actual = new BigDecimal(APPartialChequePayment.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
}
@Test(priority=6)
public void AP_Adjust_Payment_Advanced_TC_5() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String suppID = POExcelLib.getExcelData("PO", 13, 8);
	 String prodID = POExcelLib.getExcelData("PO", 13, 14);
	 String Qnty = POExcelLib.getExcelData("PO", 13, 17);
	 String unitp = POExcelLib.getExcelData("PO", 13, 21);
	 String Adv = POExcelLib.getExcelData("PO", 13, 29);
	 String taxCode = POExcelLib.getExcelData("PO", 13, 24);
	 String Total = POExcelLib.getExcelData("Payable", 06, 12);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.PurchaseOrder_new);
driver.navigate().refresh();
POPayAdvPettyRecp PayAdvPttyRecp = PageFactory.initElements(driver, POPayAdvPettyRecp.class);
	PayAdvPttyRecp.PayAdvPttyRecp(suppID, prodID, Qnty, unitp, taxCode, Adv);
	APAdjustAdvanced APAjAvd = PageFactory.initElements(driver, APAdjustAdvanced.class);
	APAjAvd.AdjustAdv();
	BigDecimal Actual = new BigDecimal(APAdjustAdvanced.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}

@Test(priority=7)
public void AP_Adjust_Payment_SaleReturn_TC_6() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String suppID = POExcelLib.getExcelData("PO", 5, 8);
	 String prodID = POExcelLib.getExcelData("PO", 5, 14);
	 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
	 String unitp = POExcelLib.getExcelData("PO", 5, 21);
	 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
	 String payType = POExcelLib.getExcelData("PO", 5, 28);
	 String Reason = POExcelLib.getExcelData("PRR", 8, 9);
	 String Total = POExcelLib.getExcelData("Payable", 7, 12);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
	driver.navigate().refresh();
		POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
		payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
		PRR_FullReturn PRRFR=PageFactory.initElements(driver, PRR_FullReturn.class);
		PRRFR.FullReturn(Reason);
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
		APAdjustPurchaseReturn APADPRR = PageFactory.initElements(driver, APAdjustPurchaseReturn.class);
		APADPRR.AdjustPRR();
		BigDecimal Actual = new BigDecimal(APAdjustPurchaseReturn.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
}
@Test(priority=8)
public void AP_Disc_percentage_TC_7() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String suppID = POExcelLib.getExcelData("PO", 5, 8);
	 String prodID = POExcelLib.getExcelData("PO", 5, 14);
	 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
	 String unitp = POExcelLib.getExcelData("PO", 5, 21);
	 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
	 String payType = POExcelLib.getExcelData("PO", 5, 28);
	 String Dis = POExcelLib.getExcelData("Payable", 8, 07);
	 String Total = POExcelLib.getExcelData("Payable", 8, 12);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 driver.get(Constant.PurchaseOrder_new);
	driver.navigate().refresh();
		POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
		payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
		APCashDisPer APfull = PageFactory.initElements(driver, APCashDisPer.class);
		APfull.FullpaymentDisc(Dis);
		BigDecimal Actual = new BigDecimal(APCashDisPer.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
		
}
@Test(priority=9)
public void AP_Disc_INR_TC_8() throws Exception
{

WebDriverCommonlib.waitForPageToLoad();
String suppID = POExcelLib.getExcelData("PO", 5, 8);
String prodID = POExcelLib.getExcelData("PO", 5, 14);
String Qnty = POExcelLib.getExcelData("PO", 5, 17);
String unitp = POExcelLib.getExcelData("PO", 5, 21);
String taxCode = POExcelLib.getExcelData("PO", 5, 24);
String payType = POExcelLib.getExcelData("PO", 5, 28);
String Dis = POExcelLib.getExcelData("Payable", 9, 07);
String Total = POExcelLib.getExcelData("Payable", 9, 12);
BigDecimal expected = new BigDecimal(Total);
expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
driver.get(Constant.PurchaseOrder_new);
driver.navigate().refresh();
	POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
	payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
	APCashDiscINR APfull = PageFactory.initElements(driver, APCashDiscINR.class);
	APfull.FullpaymentDiscINR(Dis);
	BigDecimal Actual = new BigDecimal(APCashDiscINR.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=10)
public void AP_Roundoff_TC_9() throws Exception

{
	WebDriverCommonlib.waitForPageToLoad();
	String suppID = POExcelLib.getExcelData("PO", 5, 8);
	String prodID = POExcelLib.getExcelData("PO", 5, 14);
	String Qnty = POExcelLib.getExcelData("PO", 5, 17);
	String unitp = POExcelLib.getExcelData("PO", 5, 21);
	String taxCode = POExcelLib.getExcelData("PO", 5, 24);
	String payType = POExcelLib.getExcelData("PO", 5, 28);
	String RoundOff = POExcelLib.getExcelData("Payable", 10, 10);
	 String Total = POExcelLib.getExcelData("Payable", 10, 12);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
		payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
		APCashRoundOff APfull = PageFactory.initElements(driver, APCashRoundOff.class);
		APfull.CashRoundoff(RoundOff);
		BigDecimal Actual = new BigDecimal(APCashRoundOff.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
		
}
@Test(priority=11)
public void AP_VoucherAdjustment_TC_10() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String suppID = POExcelLib.getExcelData("PO", 5, 8);
	String prodID = POExcelLib.getExcelData("PO", 5, 14);
	String Qnty = POExcelLib.getExcelData("PO", 5, 17);
	String unitp = POExcelLib.getExcelData("PO", 5, 21);
	String taxCode = POExcelLib.getExcelData("PO", 5, 24);
	String payType = POExcelLib.getExcelData("PO", 5, 28);
	String VoucherID = POExcelLib.getExcelData("Payable", 11, 8);
	String VoucherAmt = POExcelLib.getExcelData("Payable", 11, 9);
	 String Total = POExcelLib.getExcelData("Payable", 11, 12);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
driver.get(Constant.PurchaseOrder_new);
driver.navigate().refresh();
		POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
		payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
		APVoucherAdjustment APfull = PageFactory.initElements(driver, APVoucherAdjustment.class);
		APfull.Voucher(VoucherID,VoucherAmt);
		BigDecimal Actual = new BigDecimal(APVoucherAdjustment.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
		
}

}
