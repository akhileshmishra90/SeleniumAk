package com.Actouch.DirectReceiptINV.Testscript;
import java.math.BigDecimal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRCashDisINR;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRCashDisPer;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRCreditTerm;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRMemo;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRPaymentLtr;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRReference;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRRoundOff;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRShipCharge;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRShipTax;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRTaxDiscount;
import com.Actouch.DirectReceiptINV.pageObjectRepository.DRTermCond;
import com.Actouch.DirectReceiptINV.pageObjectRepository.UPDRCreditTerm;
import com.Actouch.DirectReceiptINV.pageObjectRepository.UPDRDisINR;
import com.Actouch.DirectReceiptINV.pageObjectRepository.UPDRDisPer;
import com.Actouch.DirectReceiptINV.pageObjectRepository.UPDRLineDis;
import com.Actouch.DirectReceiptINV.pageObjectRepository.UPDRMemo;
import com.Actouch.DirectReceiptINV.pageObjectRepository.UPDRProduct;
import com.Actouch.DirectReceiptINV.pageObjectRepository.UPDRQnty;
import com.Actouch.DirectReceiptINV.pageObjectRepository.UPDRSupplier;
import com.Actouch.DirectReceiptINV.pageObjectRepository.UPDRTaxCode;
import com.Actouch.DirectReceiptINV.pageObjectRepository.UPDRTermCond;
import com.Actouch.DirectReceiptINV.pageObjectRepository.UPDRUnitPrice;
import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.POExcelLib;
import com.Actouch.Purchase.generic_Lib.UPDRINVDataProvider;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;
import com.Actouch.PurchaseINV.pageObjectRepository.Login;
import com.Actouch.DirectReceiptINV.pageObjectRepository.UPDRReference;
import com.Actouch.DirectReceiptINV.pageObjectRepository.UPDRRoundOff;
import com.Actouch.DirectReceiptINV.pageObjectRepository.UPDRShipAddress;
import com.Actouch.DirectReceiptINV.pageObjectRepository.UPDRShipCharge;
import com.Actouch.DirectReceiptINV.pageObjectRepository.UPDRShipTax;
public class UpdateDirectReceipt extends UPDRINVDataProvider  {
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
   @Test(dataProvider ="UpdateSupplier2",priority=2)
	public void UPDRINV_Supplier_TC_2(String SuppID,String ProdID,String Qnty,String UnitP,String TaxCode,String UPSupp,String total) throws InterruptedException
	{
	   WebDriverCommonlib.waitForPageToLoad();
		 BigDecimal expected = new BigDecimal(total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
		  driver.get(Constant.directPorMain);	
		  driver.navigate().refresh();
			DRPaymentLtr payLtr = PageFactory.initElements(driver, DRPaymentLtr.class);
		payLtr.Payltr(SuppID, ProdID, Qnty, UnitP, TaxCode);
		UPDRSupplier Supp = PageFactory.initElements(driver, UPDRSupplier.class);
		Supp.SuppID(UPSupp);
		BigDecimal Actual = new BigDecimal(UPDRSupplier.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}
   @Test(dataProvider="UPDRReference3",priority=3)
   public void UPDRINV_Reference_TC_3(String Supp,String OrRef,String PoRefAmt,String ProdID,String Qnty,String UnitP,String TaxCode,String UPRef,String UPRefAmt,String Total) throws InterruptedException
	   {
	   	WebDriverCommonlib.waitForPageToLoad();
	   	BigDecimal expected= new BigDecimal(Total);
	   	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	   	driver.get(Constant.directPorMain);
	   	driver.navigate().refresh(); 
	   	DRReference DRef = PageFactory.initElements(driver, DRReference.class);
	   	DRef.CrdTerm(Supp, OrRef, PoRefAmt, ProdID, Qnty, UnitP, TaxCode);
	   	UPDRReference Ref = PageFactory.initElements(driver, UPDRReference.class);
	   	Ref.SuppID(UPRef, UPRefAmt);
	   	BigDecimal Actual =new BigDecimal(UPDRReference.amt);
	   	Assert.assertEquals(Actual, expected,"total amount not correct");
	       System.out.println("total amount verified");
   }
   @Test(dataProvider="UpdateShipAddress4",priority=4)
   public void UPDRINV_shipAddress_TC_4(String SuppID,String ProdID,String Qnty,String UnitP,String TaxCode,String UPship,String total) throws InterruptedException
   {
	   WebDriverCommonlib.waitForPageToLoad();
		 BigDecimal expected = new BigDecimal(total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
		  driver.get(Constant.directPorMain);	
		  driver.navigate().refresh();
			DRPaymentLtr payLtr = PageFactory.initElements(driver, DRPaymentLtr.class);
		payLtr.Payltr(SuppID, ProdID, Qnty, UnitP, TaxCode);
		UPDRShipAddress Supp = PageFactory.initElements(driver, UPDRShipAddress.class);
		Supp.SuppID(UPship);
		BigDecimal Actual = new BigDecimal(UPDRShipAddress.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
   }
 @Test(dataProvider="UpdateCreditTerm5",priority=5)
   public void UPDRINV_CreditTerm_TC_5(String Supp,String CrdTerm ,String ProdID,String Qnty,String UnitP,String TaxCode,String UPCrdt,String total) throws InterruptedException
   {
	   WebDriverCommonlib.waitForPageToLoad();
		BigDecimal expected= new BigDecimal(total);
		expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.directPorMain);
		driver.navigate().refresh(); 
		DRCreditTerm ExTax = PageFactory.initElements(driver, DRCreditTerm.class);
		ExTax.CrdTerm(Supp,CrdTerm ,ProdID, Qnty, UnitP, TaxCode);
		UPDRCreditTerm Crdt = PageFactory.initElements(driver, UPDRCreditTerm.class);
		Crdt.SuppID(UPCrdt);
		BigDecimal Actual =new BigDecimal(DRCreditTerm.amt);
		Assert.assertEquals(Actual, expected,"total amount not correct");
	    System.out.println("total amount verified");
   }
 @Test(dataProvider="UpdateProduct6",priority=6)
 public void UPDRINV_Product_TC_6(String SuppID,String ProdID,String Qnty,String UnitP,String TaxCode,String UPProdID,String UPQty,String upuniP,String UPTaxCode,String total) throws InterruptedException
 {
	 WebDriverCommonlib.waitForPageToLoad();
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
	  driver.get(Constant.directPorMain);	
	  driver.navigate().refresh();
		DRPaymentLtr payLtr = PageFactory.initElements(driver, DRPaymentLtr.class);
	payLtr.Payltr(SuppID, ProdID, Qnty, UnitP, TaxCode);
	UPDRProduct Prod= PageFactory.initElements(driver, UPDRProduct.class);
	Prod.SuppID(UPProdID, upuniP, UPQty, UPTaxCode);
	BigDecimal Actual =new BigDecimal(UPDRProduct.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
 }
 @Test(dataProvider="UpdateQnty7",priority=7)
 public void UPDRINV_Quantity_TC_7(String SuppID,String ProdID,String Qnty,String UnitP,String TaxCode,String UPQnty,String Total) throws InterruptedException
 {
 	WebDriverCommonlib.waitForPageToLoad();
 	BigDecimal expected= new BigDecimal(Total);
 	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
 	driver.get(Constant.directPorMain);
 	driver.navigate().refresh(); 
 	DRPaymentLtr payLtr = PageFactory.initElements(driver, DRPaymentLtr.class);
	payLtr.Payltr(SuppID, ProdID, Qnty, UnitP, TaxCode);
	UPDRQnty UPDRQ =PageFactory.initElements(driver, UPDRQnty.class);
	UPDRQ.SuppID(UPQnty);
 	BigDecimal Actual =new BigDecimal(UPDRQnty.amt);
 	Assert.assertEquals(Actual, expected,"total amount not correct");
     System.out.println("total amount verified");
 	
 }
@Test(dataProvider="UpdateUnitP8",priority=8)
public void UPDRINV_Unitprice_TC_8(String SuppID,String ProdID,String Qnty,String UnitP,String TaxCode,String UPUnitP,String Total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh();
	DRPaymentLtr payLtr = PageFactory.initElements(driver, DRPaymentLtr.class);
	payLtr.Payltr(SuppID, ProdID, Qnty, UnitP, TaxCode);
	UPDRUnitPrice UPDRUP =PageFactory.initElements(driver, UPDRUnitPrice.class);
	UPDRUP.SuppID(UPUnitP);
	BigDecimal Actual =new BigDecimal(UPDRUnitPrice.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
}
@Test(dataProvider="UpdatelineDis9",priority=9)
public void UPDRINV_LineDis_TC_9(String Supp,String ProdID,String Qnty,String UnitP,String lineDis,String TaxCode1,String TaxCode2,String UPLineDis,String Total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh();
	DRTaxDiscount TxDis = PageFactory.initElements(driver,DRTaxDiscount.class);
	TxDis.Payltr(Supp, ProdID, Qnty, UnitP, lineDis, TaxCode1, TaxCode2);
	UPDRLineDis UPDRUP =PageFactory.initElements(driver, UPDRLineDis.class);
	UPDRUP.SuppID(UPLineDis);
	BigDecimal Actual =new BigDecimal(UPDRLineDis.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
}

@Test(dataProvider="UpdateTaxCode10",priority=10)
public void UPDRINV_UpdateTax_TC_10(String SuppID,String ProdID,String Qnty,String UnitP,String TaxCode,String UPTaxCode,String Total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh(); 
	DRPaymentLtr payLtr = PageFactory.initElements(driver, DRPaymentLtr.class);
	payLtr.Payltr(SuppID, ProdID, Qnty, UnitP, TaxCode);
	UPDRTaxCode UPDRTX = PageFactory.initElements(driver, UPDRTaxCode.class);
	UPDRTX.SuppID(UPTaxCode);
	BigDecimal Actual =new BigDecimal(UPDRTaxCode.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
	
}
@Test(dataProvider="UpdateTermCond12",priority=12)
public void UPDRINV_TermCondition_TC_12(String Supp,String ProdID,String Qnty,String UnitP,String TaxCode,String TermCond,String UPTermCond,String Total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh(); 
	DRTermCond DTermCond=PageFactory.initElements(driver, DRTermCond.class);
	DTermCond.CrdTerm(Supp, ProdID, Qnty, UnitP, TaxCode, TermCond);
	UPDRTermCond UPDRTC =PageFactory.initElements(driver, UPDRTermCond.class);
	UPDRTC.SuppID(UPTermCond);
	BigDecimal Actual =new BigDecimal(UPDRTermCond.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
	
}
@Test(dataProvider="UpdateMemo13",priority=13)
public void UPDRINV_Memo_TC_13(String Supp,String ProdID,String Qnty,String UnitP,String TaxCode,String Memo,String UPMemo,String Total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh(); 
	DRMemo DMemo = PageFactory.initElements(driver, DRMemo.class);
	DMemo.CrdTerm(Supp, ProdID, Qnty, UnitP, TaxCode, Memo);
	UPDRMemo MemoObj =PageFactory.initElements(driver, UPDRMemo.class);
	MemoObj.SuppID(UPMemo);
	BigDecimal Actual =new BigDecimal(UPDRMemo.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
	
}
@Test(dataProvider="UpdateDisPer14",priority=14)
public void UPDRINV_DisPer_TC_14(String Supp,String ProdID,String Qnty,String UnitP,String TaxCode,String DisPer,String UPDiser,String Total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh(); 
	DRCashDisPer CshDisPer =PageFactory.initElements(driver, DRCashDisPer.class);
	CshDisPer.CrdTerm(Supp, ProdID, Qnty, UnitP, TaxCode, DisPer); 
	UPDRDisPer UPDRDP = PageFactory.initElements(driver, UPDRDisPer.class);
	UPDRDP.SuppID(UPDiser);
	BigDecimal Actual =new BigDecimal(UPDRDisPer.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
	
	
}
@Test(dataProvider="UpdateDisINR15",priority=15)
public void UPDRINV_DisINR_TC_15(String Supp,String ProdID,String Qnty,String UnitP,String TaxCode,String DisINR,String UPDisI,String Total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh(); 
	DRCashDisINR CshDisINR =PageFactory.initElements(driver, DRCashDisINR.class);
	CshDisINR.CrdTerm(Supp, ProdID, Qnty, UnitP, TaxCode, DisINR); 
	UPDRDisINR UPDRDP = PageFactory.initElements(driver, UPDRDisINR.class);
	UPDRDP.SuppID(UPDisI);
	BigDecimal Actual =new BigDecimal(UPDRDisINR.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
	
	
}
@Test(dataProvider="UpdateShipCharge16",priority=16)
public void UPDRINV_ShipCharge_TC_16(String Supp,String ProdID,String Qnty,String UnitP,String TaxCode,String ShpCharge,String UPShpCharge,String Total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh();
	DRShipCharge DRef = PageFactory.initElements(driver, DRShipCharge.class);
	DRef.CrdTerm(Supp, ProdID, Qnty, UnitP, TaxCode, ShpCharge);
	UPDRShipCharge UPDRSC=PageFactory.initElements(driver, UPDRShipCharge.class);
	UPDRSC.SuppID(UPShpCharge);
	BigDecimal Actual =new BigDecimal(UPDRShipCharge.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
	
	
}
@Test(dataProvider="UpdateShipTax17",priority=17)
public void UPDRINV_ShipTax_TC_17(String Supp,String ProdID,String Qnty,String UnitP,String TaxCode,String ShpCharge,String ShpTaxselect,String UPshpTax ,String Total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh();	
	DRShipTax DRef = PageFactory.initElements(driver, DRShipTax.class);
	DRef.CrdTerm(Supp, ProdID, Qnty, UnitP, TaxCode, ShpCharge, ShpTaxselect);
	UPDRShipTax UPDRST = PageFactory.initElements(driver, UPDRShipTax.class);
	UPDRST.SuppID(UPshpTax);
	BigDecimal Actual =new BigDecimal(UPDRShipTax.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
	
	
}
@Test(dataProvider="UpdateRoundOff18",priority=18)
public void UPDRINV_Roundoff_TC_18(String Supp,String ProdID,String Qnty,String UnitP,String TaxCode,String RoundOff,String UPRoundOff,String Total) throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected= new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.directPorMain);
	driver.navigate().refresh();	
	DRRoundOff DRef = PageFactory.initElements(driver, DRRoundOff.class);
	DRef.CrdTerm(Supp, ProdID, Qnty, UnitP, TaxCode, RoundOff);
	UPDRRoundOff UPDRRF= PageFactory.initElements(driver, UPDRRoundOff.class);
	UPDRRF.SuppID(UPRoundOff);
	BigDecimal Actual =new BigDecimal(UPDRRoundOff.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
    System.out.println("total amount verified");
}


   
   }
