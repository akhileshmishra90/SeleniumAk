package com.Actouch.DirectReceiptINV.Testscript;


import java.math.BigDecimal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Actouch.DirectReceiptINV.pageObjectRepository.DRMultiChq;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRPaymentLtr;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRSingleCheq;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRTDSWithTax;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRTaxDiscount;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRTermCond;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRWithoutTax;
//import com.Actouch.DirectReceiptINV.pageObjectRepository.DRAdvCash;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRCash;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRCashDisINR;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRCashDisPer;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRCreditTerm;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRExclusiveTax;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRInclusiveTax;
import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.DRINVDataProvider;
import com.Actouch.Purchase.generic_Lib.POExcelLib;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;
import com.Actouch.PurchaseINV.pageObjectRepository.Login;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRAdvChq;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRBatchableProd;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRBlankDR;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRBlankDetLevel;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRMultiTax;
import 	com.Actouch.DirectReceiptINV.pageObjectRepository.DRWithoutDis;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRRecieptMode;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRTradeDis;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRVehicleDetail;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRPurchaseTax;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRMUOM;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRMuomBatchable;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRMemo;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRReference;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRRoundOff;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRMultiCurrency;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRShipCharge;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRShipTax;
public class DirectReceptLocation  extends DRINVDataProvider {
	static WebDriver driver;
	@Test(priority = 1)
	public void DRINV_Login_TC_1() throws Exception
	{
		driver = Browser.getbrowser();
		String usrId = POExcelLib.getExcelData("PO", 03, 03);
				 String psw = POExcelLib.getExcelData("PO", 03, 04);
				 driver.get(Constant.Url);
				Login loginpage = PageFactory.initElements(driver, Login.class);
				loginpage.login(usrId, psw);
				Thread.sleep(5000);		
	}
   @Test(dataProvider ="PaymentLate",priority=2)
	public void DRINV_payltr_TC_2(String SuppID,String ProdID,String Qnty,String UnitP,String TaxCode,String total) throws InterruptedException
	{
	   WebDriverCommonlib.waitForPageToLoad();
		 BigDecimal expected = new BigDecimal(total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
		  driver.get(Constant.directPorMain);	
		  driver.navigate().refresh();
			DRPaymentLtr payLtr = PageFactory.initElements(driver, DRPaymentLtr.class);
		payLtr.Payltr(SuppID, ProdID, Qnty, UnitP, TaxCode);
		BigDecimal Actual = new BigDecimal(DRPaymentLtr.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}

	@Test(dataProvider="DRSingleCheq",priority=3)
	public void DRINV_payNowByChq_singlechq_TC_3(String Supp,String ProdID,String Qnty,String UnitP,String PayType,String Paymode,String chequeNo,String total) throws InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
		BigDecimal expected = new BigDecimal(total);
		expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.directPorMain);
		driver.navigate().refresh();
    DRSingleCheq SingleCh = PageFactory.initElements(driver, DRSingleCheq.class);
    SingleCh.Payltr(Supp, ProdID, Qnty, UnitP, PayType, Paymode, chequeNo);
    BigDecimal Actual = new BigDecimal(DRSingleCheq.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");

	}
@Test(dataProvider="DRMultiCheq",priority=4)
public void DRINV_payNowByChq_Multichq_TC_4(String Supp,String ProdID,String Qnty,String UnitP,String PayType,String Paymode,String ChequeNo1,String ChequeNo2,String total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected = new BigDecimal(total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh();
DRMultiChq SingleCh = PageFactory.initElements(driver, DRMultiChq.class);
SingleCh.Payltr(Supp, ProdID, Qnty, UnitP, PayType, Paymode, ChequeNo1, ChequeNo2);
BigDecimal Actual = new BigDecimal(DRMultiChq.amt);	
Assert.assertEquals(Actual,expected,"total amount not correct");
 System.out.println("total Amount verified");

}
@Test(dataProvider="DRCash",priority=5)
public void DRINV_payNowByCash_TC_5(String Supp,String ProdID,String Qnty,String UnitP,String PayType,String Paymode,String total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected = new BigDecimal(total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh();
	DRCash Cash = PageFactory.initElements(driver, DRCash.class);
	Cash.PayNow(Supp, ProdID, Qnty, UnitP, PayType, Paymode);
BigDecimal Actual = new BigDecimal(DRCash.amt);	
Assert.assertEquals(Actual,expected,"total amount not correct");
 System.out.println("total Amount verified");
}
//@Test(dataProvider="DRRCVAdv",priority=6)
//public void DRINV_Receive_AdvbyPtty_TC_6(String Supp,String ProdID,String Qnty,String UnitP,String TaxCode,String AdvAmt,String Paymode,String total) throws InterruptedException
//{
//	WebDriverCommonlib.waitForPageToLoad();
//	BigDecimal expected = new BigDecimal(total);
//	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
//	driver.get(Constant.directPorMain);
//	driver.navigate().refresh();
//	DRAdvCash AdvCash = PageFactory.initElements(driver, DRAdvCash.class);
//	AdvCash.Payltr(Supp, ProdID, Qnty, UnitP, TaxCode, AdvAmt, Paymode);
//BigDecimal Actual = new BigDecimal(DRAdvCash.amt);
//Assert.assertEquals(Actual,expected,"total amount not correct");
//System.out.println("total Amount verified");
//}
@Test(dataProvider = "DRAdvChq",priority = 7)
public void DRINV_Receive_Advbycheque_TC_7(String Supp,String ProdID,String Qnty,String UnitP,String TaxCode,String AdvAmt,String Paymode,String ChequeNo,String total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh();
	DRAdvChq AdvChq = PageFactory.initElements(driver, DRAdvChq.class);
	AdvChq.Payltr(Supp, ProdID, Qnty, UnitP, TaxCode, AdvAmt, Paymode, ChequeNo);
	BigDecimal Actual = new BigDecimal(DRAdvChq.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
	System.out.println("total Amount verified");
}
@Test(dataProvider = "DRMultiTax",priority=8)
public void DRINV_MultiTax_TC_8(String Supp,String ProdID,String Qnty,String UnitP,String TaxCode1,String TaxCode2,String total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected = new BigDecimal(total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh();
	DRMultiTax MultiTax = PageFactory.initElements(driver, DRMultiTax.class);
	MultiTax.Payltr(Supp, ProdID, Qnty, UnitP, TaxCode1, TaxCode2);
	BigDecimal Actual=new BigDecimal(DRMultiTax.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
	System.out.println("total amount verified");
}
    @Test(dataProvider="DRTaxDis",priority=9)
   public void DRINV_Tax_Discount_TC_9(String Supp,String ProdID,String Qnty,String UnitP,String lineDis,String TaxCode1,String TaxCode2,String total) throws InterruptedException
   {
    	WebDriverCommonlib.waitForPageToLoad();
    	BigDecimal expected= new BigDecimal(total);
    	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
    	driver.get(Constant.directPorMain);
    	driver.navigate().refresh();
    	DRTaxDiscount TxDis = PageFactory.initElements(driver,DRTaxDiscount.class);
    	TxDis.Payltr(Supp, ProdID, Qnty, UnitP, lineDis, TaxCode1, TaxCode2);
    	BigDecimal Actual=new BigDecimal(DRTaxDiscount.amt);
    	Assert.assertEquals(Actual, expected,"total amount not correct");
        System.out.println("total amount verified");
    	
   }

@Test(dataProvider="DRWithoutTAx",priority=10)
public void DRINV_withoutTax_TC_10(String Supp,String ProdID,String Qnty,String UnitP,String lineDis,String total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh();
	DRWithoutTax WTTax =PageFactory.initElements(driver, DRWithoutTax.class);
	WTTax.Payltr(Supp, ProdID, Qnty, UnitP, lineDis);
	BigDecimal Actual =new BigDecimal(DRWithoutTax.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
}
@Test(dataProvider="DRWithoutDis",priority=11)
public void DRINV_WithoutDiscount_TC_11(String Supp,String ProdID,String Qnty,String UnitP,String total) throws InterruptedException
{ 
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh();
	DRWithoutDis WTDis = PageFactory.initElements(driver, DRWithoutDis.class);
	WTDis.Payltr(Supp, ProdID, Qnty, UnitP);
	BigDecimal Actual =new BigDecimal(DRWithoutDis.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
}
   @Test(dataProvider="DRInclusiveTAx",priority=12)
   public void DRINV_InclusiveTax_TC_12(String Supp,String ProdID,String Qnty,String UnitP,String TaxCode,String total) throws InterruptedException
   {
	   WebDriverCommonlib.waitForPageToLoad();
		BigDecimal expected= new BigDecimal(total);
		expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.directPorMain);
		driver.navigate().refresh(); 
		DRInclusiveTax InTax = PageFactory.initElements(driver, DRInclusiveTax.class);
		InTax.Payltr(Supp, ProdID, Qnty, UnitP, TaxCode);
		BigDecimal Actual =new BigDecimal(DRInclusiveTax.amt);
		Assert.assertEquals(Actual, expected,"total amount not correct");
	    System.out.println("total amount verified");
		
   }
   @Test(dataProvider="DRExclusiveTAx",priority=13)
public void DRINV_ExclusiveTax_TC_13(String Supp,String ProdID,String Qnty,String UnitP,String TaxCode,String total) throws InterruptedException
{
	   WebDriverCommonlib.waitForPageToLoad();
		BigDecimal expected= new BigDecimal(total);
		expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.directPorMain);
		driver.navigate().refresh(); 
		DRExclusiveTax ExTax = PageFactory.initElements(driver, DRExclusiveTax.class);
		ExTax.Payltr(Supp, ProdID, Qnty, UnitP, TaxCode);
		BigDecimal Actual =new BigDecimal(DRExclusiveTax.amt);
		Assert.assertEquals(Actual, expected,"total amount not correct");
	    System.out.println("total amount verified");
	   
}
   @Test(dataProvider="DRCrdTerm",priority=14)
   public void DRINV_CreditTerm_TC_14(String Supp,String CrdTerm ,String ProdID,String Qnty,String UnitP,String TaxCode,String total) throws InterruptedException
   {
	   WebDriverCommonlib.waitForPageToLoad();
		BigDecimal expected= new BigDecimal(total);
		expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.directPorMain);
		driver.navigate().refresh(); 
		DRCreditTerm ExTax = PageFactory.initElements(driver, DRCreditTerm.class);
		ExTax.CrdTerm(Supp,CrdTerm ,ProdID, Qnty, UnitP, TaxCode);
		BigDecimal Actual =new BigDecimal(DRCreditTerm.amt);
		Assert.assertEquals(Actual, expected,"total amount not correct");
	    System.out.println("total amount verified");
   }

@Test(dataProvider="DRRecieptMode",priority=15)
public void DRINV_RecieptMode_TC_15(String Supp,String ProdID,String Qnty,String UnitP,String TaxCode,String Receipt,String total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh(); 
	DRRecieptMode ExTax = PageFactory.initElements(driver, DRRecieptMode.class);
	ExTax.CrdTerm(Supp,ProdID, Qnty, UnitP, TaxCode,Receipt );
	BigDecimal Actual =new BigDecimal(DRRecieptMode.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
	
}
@Test(dataProvider="DRDisPer",priority=16)
public void DRINV_CashDiscount_Percentage_TC_16(String Supp,String ProdID,String Qnty,String UnitP,String TaxCode,String DisPer,String total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh(); 
	DRCashDisPer CshDisPer =PageFactory.initElements(driver, DRCashDisPer.class);
	CshDisPer.CrdTerm(Supp, ProdID, Qnty, UnitP, TaxCode, DisPer);
	BigDecimal Actual =new BigDecimal(DRCashDisPer.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
}
@Test(dataProvider="DRDisINR",priority=17)
public void DRINV_CashDiscount_INR_TC_17(String Supp,String ProdID,String Qnty,String UnitP,String TaxCode,String DisPer,String total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh(); 
	DRCashDisINR CshDisPer =PageFactory.initElements(driver, DRCashDisINR.class);
	CshDisPer.CrdTerm(Supp, ProdID, Qnty, UnitP, TaxCode, DisPer);
	BigDecimal Actual =new BigDecimal(DRCashDisINR.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
}
@Test(dataProvider="DRTradeDis",priority=18)
public void DRINV_TradeDiscount_TC_18(String Supp,String ProdID,String Qnty,String UnitP,String TaxCode,String DisTrade,String total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh(); 
	DRTradeDis CshDisPer =PageFactory.initElements(driver, DRTradeDis.class);
	CshDisPer.CrdTerm(Supp, ProdID, Qnty, UnitP, TaxCode, DisTrade);
	BigDecimal Actual =new BigDecimal(DRTradeDis.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
}
@Test(dataProvider="DRPurchaseTax",priority=19)
public void DRINV_purchaseTax_TC_19(String Supp,String ProdID,String CSTPurchase,String Qnty,String UnitP,String TaxCode,String PurTax,String total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh(); 
	DRPurchaseTax CshDisPer =PageFactory.initElements(driver, DRPurchaseTax.class);
	CshDisPer.CrdTerm(Supp, ProdID, CSTPurchase, Qnty, UnitP, TaxCode, PurTax);
	BigDecimal Actual =new BigDecimal(DRPurchaseTax.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
}
@Test( dataProvider= "TDSTax",priority=20)
public void DRINV_TDSWith_OtherTax_TC_20(String Supp,String ProdID,String Qnty,String UnitP,String TaxCode,String TaxCode2) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	driver.get(Constant.directPorMain);
	driver.navigate().refresh();
	DRTDSWithTax TDSTx=PageFactory.initElements(driver, DRTDSWithTax.class);
	TDSTx.Payltr(Supp, ProdID, Qnty, UnitP, TaxCode, TaxCode2);
}

@Test(dataProvider="DRMUOM",priority=21)
public void DRINV_MUOM_TC_21(String Supp,String ProdID,String SecMuom,String SecQty,String PrimQnty,String UnitP,String TaxCode,String Total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh(); 
	DRMUOM MUOM  =PageFactory.initElements(driver, DRMUOM.class);
	MUOM.CrdTerm(Supp, ProdID, SecMuom, SecQty, PrimQnty, UnitP, TaxCode);
	BigDecimal Actual =new BigDecimal(DRMUOM.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
}
@Test(dataProvider="DRBatchable",priority=22)
public void DRINV_BatchableItem_TC_22(String Supp,String ProdID,String Batch,String Qnty,String UnitP,String TaxCode,String Total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh(); 
	DRBatchableProd batchable  =PageFactory.initElements(driver, DRBatchableProd.class);
	batchable.Batch(Supp, ProdID, Batch, Qnty, UnitP, TaxCode);
	BigDecimal Actual =new BigDecimal(DRBatchableProd.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
}
@Test(dataProvider="DRMuomBatchable",priority=23)
public void DRINV_MUOM_Batchableitem_TC_23(String Supp,String ProdID,String Batch,String SecMuom,String SecQty,String PrimQnty,String UnitP,String TaxCode,String Total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh(); 
	DRMuomBatchable batchable  =PageFactory.initElements(driver, DRMuomBatchable.class);
	batchable.BatchMuom(Supp, ProdID, Batch, SecMuom, SecQty, PrimQnty, UnitP, TaxCode);
	BigDecimal Actual =new BigDecimal(DRMuomBatchable.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
}
@Test(priority=24)
public void DRINV_BlankPO_TC_24() throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	driver.get(Constant.directPorMain);
	driver.navigate().refresh();
	DRBlankDR Blank =PageFactory.initElements(driver, DRBlankDR.class);
	Blank.BatchMuom();
}
@Test(dataProvider="BlankDet",priority=25)
public void DRINV_BlankDETlevel_TC_25(String supp) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	driver.get(Constant.directPorMain);
	driver.navigate().refresh();
	DRBlankDetLevel Blank =PageFactory.initElements(driver, DRBlankDetLevel.class);
	Blank.BatchMuom(supp);
}
@Test(dataProvider="DRMemo",priority=26)
public void DRINV_Memo_Length_TC_26(String Supp,String ProdID,String Qnty,String UnitP,String TaxCode,String Memo,String Total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh(); 
	DRMemo DMemo = PageFactory.initElements(driver, DRMemo.class);
	DMemo.CrdTerm(Supp, ProdID, Qnty, UnitP, TaxCode, Memo);
	BigDecimal Actual =new BigDecimal(DRMemo.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
	
}
@Test(dataProvider="DRTc",priority=27)
public void DRINV_TC_Length_TC_27(String Supp,String ProdID,String Qnty,String UnitP,String TaxCode,String TC,String Total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh(); 
	DRTermCond DMemo = PageFactory.initElements(driver, DRTermCond.class);
	DMemo.CrdTerm(Supp, ProdID, Qnty, UnitP, TaxCode, TC);
	BigDecimal Actual =new BigDecimal(DRTermCond.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
}
@Test(dataProvider ="DRReference",priority=28)
public void DRINV_Reference_TC_28(String Supp,String OrRef,String PoRefAmt,String ProdID,String Qnty,String UnitP,String TaxCode,String Total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh(); 
	DRReference DRef = PageFactory.initElements(driver, DRReference.class);
	DRef.CrdTerm(Supp, OrRef, PoRefAmt, ProdID, Qnty, UnitP, TaxCode);
	BigDecimal Actual =new BigDecimal(DRReference.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
}
@Test(dataProvider ="DRMultiCurrency",priority=29)
public void DRINV_MultiCurrency_TC_29(String Supp,String Currency,String ExRate,String ProdID,String Qnty,String UnitP,String TaxCode,String Total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh(); 
	DRMultiCurrency DRef = PageFactory.initElements(driver, DRMultiCurrency.class);
	DRef.CrdTerm(Supp, Currency, ExRate, ProdID, Qnty, UnitP, TaxCode);
	BigDecimal Actual =new BigDecimal(DRMultiCurrency.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");

}
@Test(dataProvider ="DRShipCharge",priority=30)
public void DRINV_ShipCharge_TC_30(String Supp,String ProdID,String Qnty,String UnitP,String TaxCode,String ShpCharge,String Total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh(); 
	DRShipCharge DRef = PageFactory.initElements(driver, DRShipCharge.class);
	DRef.CrdTerm(Supp, ProdID, Qnty, UnitP, TaxCode, ShpCharge);
	BigDecimal Actual =new BigDecimal(DRShipCharge.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");

}
@Test(dataProvider ="DRShipTax",priority=31)
public void DRINV_ShipTax_TC_31(String Supp,String ProdID,String Qnty,String UnitP,String TaxCode,String ShpCharge,String ShpTaxselect, String Total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh(); 
	DRShipTax DRef = PageFactory.initElements(driver, DRShipTax.class);
	DRef.CrdTerm(Supp, ProdID, Qnty, UnitP, TaxCode, ShpCharge, ShpTaxselect);
	BigDecimal Actual =new BigDecimal(DRShipTax.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
}
@Test(dataProvider ="DRVehicleDetail",priority=32)
public void DRINV_VehicleDetail_TC_32(String Supp,String ProdID,String Qnty,String UnitP,String TaxCode,String transName,String vehicleNo,String gclrNo,String packingNo,String packageNo,String packingWgt,String Total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh(); 
	DRVehicleDetail DRef = PageFactory.initElements(driver, DRVehicleDetail.class);
	DRef.CrdTerm(Supp, ProdID, Qnty, UnitP, TaxCode, transName, vehicleNo, gclrNo, packingNo, packageNo, packingWgt);
	BigDecimal Actual =new BigDecimal(DRVehicleDetail.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
}
@Test(dataProvider ="DRRoundoff",priority=33)
public void DRINV_Roundoff_TC_33(String Supp,String ProdID,String Qnty,String UnitP,String TaxCode,String RoundOff,String Total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh(); 
	DRRoundOff DRef = PageFactory.initElements(driver, DRRoundOff.class);
	DRef.CrdTerm(Supp, ProdID, Qnty, UnitP, TaxCode, RoundOff);
	BigDecimal Actual =new BigDecimal(DRRoundOff.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
}
}
