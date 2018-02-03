package com.Actouch.PurchaseSRV.TestScript;

import java.io.IOException;
import java.math.BigDecimal;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.POExcelLib;
import com.Actouch.Purchase.generic_Lib.POSRVExcellLib;
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
import com.Actouch.PurchaseINV.pageObjectRepository.POPaymentLaterRecvnow;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVAdvancedPetty;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVPayLtrShpNow;


public class ServicePayable {

static WebDriver driver = com.Actouch.Purchase.generic_Lib.Browser.getbrowser();
	
	
	
	//-------------------Test scenario for Login into application-----------------------------
	@Test(priority=1)
	public void purchaseIN_Login_TC1() throws Exception
	{
		driver.get(Constant.Url);
		
		//login
		String usrId = POSRVExcellLib.getExcellData("POSRV",03, 04);
		 String psw = POSRVExcellLib.getExcellData("POSRV",03, 05);
		Login loginpage = PageFactory.initElements(driver, Login.class);
		loginpage.login(usrId, psw);
		Thread.sleep(5000);		
	}
	//-------------------Test scenario for create PO with payment Later-------------------------- 
	@Test(priority=2)
	public void APSer_Full_Payment_Cash_TC_1()throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String Supp = POSRVExcellLib.getExcellData("POSRV",05, 9);
		String Des = POSRVExcellLib.getExcellData("POSRV",05, 12);
		String Category = POSRVExcellLib.getExcellData("POSRV",05, 13);
		String Amount = POSRVExcellLib.getExcellData("POSRV",05, 14);
		String Total = POSRVExcellLib.getExcellData("SRVPayable",2, 12);
		BigDecimal expected = new BigDecimal(Total);
		expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.POService_new);
		driver.navigate().refresh();
		POSRVPayLtrShpNow payLtr = PageFactory.initElements(driver, POSRVPayLtrShpNow.class);
		payLtr.payltrshp(Supp, Des, Category, Amount,"Yes");
		APFullCashPayment APfull = PageFactory.initElements(driver, APFullCashPayment.class);
		APfull.Fullpayment();
		BigDecimal Actual = new BigDecimal(APFullCashPayment.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		System.out.println("total Amount verified");
			

	}
	@Test(priority=3)
	public void APSer_Partial_Payment_Cash_TC_2() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String Supp = POSRVExcellLib.getExcellData("POSRV",05, 9);
		String Des = POSRVExcellLib.getExcellData("POSRV",05, 12);
		String Category = POSRVExcellLib.getExcellData("POSRV",05, 13);
		String Amount = POSRVExcellLib.getExcellData("POSRV",05, 14);
		String Total = POSRVExcellLib.getExcellData("SRVPayable",03, 12);
		String partialAmt = POSRVExcellLib.getExcellData("SRVPayable",03, 06);
		BigDecimal expected = new BigDecimal(Total);
		expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.POService_new);
		driver.navigate().refresh();
		POSRVPayLtrShpNow payLtr = PageFactory.initElements(driver, POSRVPayLtrShpNow.class);
		payLtr.payltrshp(Supp, Des, Category, Amount,"Yes");
			APPartialCashPayment APPartial = PageFactory.initElements(driver, APPartialCashPayment.class);
			APPartial.PartialPayment(partialAmt);
			BigDecimal Actual = new BigDecimal(APPartialCashPayment.amt);	
			Assert.assertEquals(Actual,expected,"total amount not correct");
			System.out.println("total Amount verified");
	}
	@Test(priority=4)
	public void APSer_Full_Payment_Cheque_TC_3() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String Supp = POSRVExcellLib.getExcellData("POSRV",05, 9);
		String Des = POSRVExcellLib.getExcellData("POSRV",05, 12);
		String Category = POSRVExcellLib.getExcellData("POSRV",05, 13);
		String Amount = POSRVExcellLib.getExcellData("POSRV",05, 14);
		String Total = POSRVExcellLib.getExcellData("SRVPayable",04, 12);
		String Bank = POSRVExcellLib.getExcellData("Additional", 7, 5);
		String CheqNo = POSRVExcellLib.getExcellData("Additional",7, 06);
		BigDecimal expected = new BigDecimal(Total);
		expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.POService_new);
		driver.navigate().refresh();
		POSRVPayLtrShpNow payLtr = PageFactory.initElements(driver, POSRVPayLtrShpNow.class);
		payLtr.payltrshp(Supp, Des, Category, Amount,"Yes");
			APFullChequePayment FullCheque = PageFactory.initElements(driver, APFullChequePayment.class);
			FullCheque.FullCheque(Bank, CheqNo);
			BigDecimal Actual = new BigDecimal(APFullChequePayment.amt);	
			Assert.assertEquals(Actual,expected,"total amount not correct");
			System.out.println("total Amount verified");
	}

@Test(priority=5)
public void APSer_Partial_Payment_Cheque_TC_4() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",05, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",05, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",05, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",05, 14);
	String Total = POSRVExcellLib.getExcellData("SRVPayable",05, 12);
	String Bank = POSRVExcellLib.getExcellData("Additional", 7, 5);
	String CheqNo = POSRVExcellLib.getExcellData("Additional",7, 06);
	String partialAmt = POSRVExcellLib.getExcellData("SRVPayable",05, 06);
	BigDecimal expected = new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVPayLtrShpNow payLtr = PageFactory.initElements(driver, POSRVPayLtrShpNow.class);
	payLtr.payltrshp(Supp, Des, Category, Amount,"Yes");
		APPartialChequePayment PartialCheque = PageFactory.initElements(driver, APPartialChequePayment.class);
		PartialCheque.partialCheque(Bank, CheqNo,partialAmt);
		BigDecimal Actual = new BigDecimal(APPartialChequePayment.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		System.out.println("total Amount verified");
}
@Test(priority=6)
public void APSer_Adjust_Payment_Advanced_TC_5() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",10, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",10, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",10, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",10, 14);
	String Total = POSRVExcellLib.getExcellData("SRVPayable",6, 12);
	String Adv = POSRVExcellLib.getExcellData("POSRV",10, 19);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVAdvancedPetty paycsh = PageFactory.initElements(driver, POSRVAdvancedPetty.class);
	paycsh.AdvPetty(Supp,Des,Category, Amount, Adv, "0C1000");
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
}
@Test(priority=8)
public void APSer_Disc_percentage_TC_7() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",05, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",05, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",05, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",05, 14);
	String Total = POSRVExcellLib.getExcellData("SRVPayable",8, 12);
	String Dis = POSRVExcellLib.getExcellData("SRVPayable",8, 07);
	BigDecimal expected = new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVPayLtrShpNow payLtr = PageFactory.initElements(driver, POSRVPayLtrShpNow.class);
	payLtr.payltrshp(Supp, Des, Category, Amount,"Yes");
		APCashDisPer APfull = PageFactory.initElements(driver, APCashDisPer.class);
		APfull.FullpaymentDisc(Dis);
		BigDecimal Actual = new BigDecimal(APCashDisPer.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		System.out.println("total Amount verified");
		
}
@Test(priority=9)
public void APSer_Disc_INR_TC_8() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",05, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",05, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",05, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",05, 14);
	String Total = POSRVExcellLib.getExcellData("SRVPayable",9, 12);
	String Dis = POSRVExcellLib.getExcellData("SRVPayable",8, 07);
	BigDecimal expected = new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVPayLtrShpNow payLtr = PageFactory.initElements(driver, POSRVPayLtrShpNow.class);
	payLtr.payltrshp(Supp, Des, Category, Amount,"Yes");
	APCashDiscINR APfull = PageFactory.initElements(driver, APCashDiscINR.class);
	APfull.FullpaymentDiscINR(Dis);
	BigDecimal Actual = new BigDecimal(APCashDiscINR.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	System.out.println("total Amount verified");
}
@Test(priority=10)
public void APSer_Roundoff_TC_9() throws Exception

{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",05, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",05, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",05, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",05, 14);
	String Total = POSRVExcellLib.getExcellData("SRVPayable",10, 12);
	String RoundOff = POSRVExcellLib.getExcellData("SRVPayable", 10, 10);
			BigDecimal expected = new BigDecimal(Total);
			expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVPayLtrShpNow payLtr = PageFactory.initElements(driver, POSRVPayLtrShpNow.class);
	payLtr.payltrshp(Supp, Des, Category, Amount,"Yes");	
		APCashRoundOff APfull = PageFactory.initElements(driver, APCashRoundOff.class);
		APfull.CashRoundoff(RoundOff);
		BigDecimal Actual = new BigDecimal(APCashRoundOff.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		System.out.println("total Amount verified");
		
}
@Test(priority=11)
public void APSer_VoucherAdjustment_TC_10()throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",05, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",05, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",05, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",05, 14);
	String Total = POSRVExcellLib.getExcellData("SRVPayable",11, 12);
	String VoucherID = POSRVExcellLib.getExcellData("SRVPayable", 11, 8);
	String VoucherAmt = POSRVExcellLib.getExcellData("SRVPayable", 11, 9);
			BigDecimal expected = new BigDecimal(Total);
			expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVPayLtrShpNow payLtr = PageFactory.initElements(driver, POSRVPayLtrShpNow.class);
	payLtr.payltrshp(Supp, Des, Category, Amount,"Yes");	
		APVoucherAdjustment APfull = PageFactory.initElements(driver, APVoucherAdjustment.class);
		APfull.Voucher(VoucherID,VoucherAmt);
		BigDecimal Actual = new BigDecimal(APVoucherAdjustment.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		System.out.println("total Amount verified");
		
}
}
