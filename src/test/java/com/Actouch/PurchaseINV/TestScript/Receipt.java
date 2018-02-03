package com.Actouch.PurchaseINV.TestScript;
import java.math.BigDecimal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.POExcelLib;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;
import com.Actouch.PurchaseINV.pageObjectRepository.Login;
import com.Actouch.PurchaseINV.pageObjectRepository.POR_DisINR;
import com.Actouch.PurchaseINV.pageObjectRepository.POR_DisPer;
import com.Actouch.PurchaseINV.pageObjectRepository.POR_DlryChallan;
import com.Actouch.PurchaseINV.pageObjectRepository.POR_FullReceipt;
import com.Actouch.PurchaseINV.pageObjectRepository.POR_FullTax;
import com.Actouch.PurchaseINV.pageObjectRepository.POR_PartialReceipt;
import com.Actouch.PurchaseINV.pageObjectRepository.POR_PartialTax;
import com.Actouch.PurchaseINV.pageObjectRepository.POR_RejectedQty;
import com.Actouch.PurchaseINV.pageObjectRepository.POR_RoundOff;
import com.Actouch.PurchaseINV.pageObjectRepository.POR_ShippingTax;
import com.Actouch.PurchaseINV.pageObjectRepository.POR_ValidateSupp;
import com.Actouch.PurchaseINV.pageObjectRepository.POR_shippingCharge;
import com.Actouch.PurchaseINV.pageObjectRepository.POR_validatePO;
import com.Actouch.PurchaseINV.pageObjectRepository.POR_vehicleDetail;
import com.Actouch.PurchaseINV.pageObjectRepository.POPaymentLater;
public class Receipt {
	WebDriver driver;
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
public void POR_Vldt_Supplier_TC_2() throws Exception
{
	//Required Data for test case.
		WebDriverCommonlib.waitForPageToLoad();
		String suppID = POExcelLib.getExcelData("PO", 4, 8);
		String prdID = POExcelLib.getExcelData("PO", 4, 14);
		String qty = POExcelLib.getExcelData("PO", 4, 17);
		String unitP = POExcelLib.getExcelData("PO", 4, 21);
		String taxCode = POExcelLib.getExcelData("PO", 4, 24);
		String payType = POExcelLib.getExcelData("PO", 4, 28);
			driver.get(com.Actouch.Purchase.generic_Lib.Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		POPaymentLater payLtr = PageFactory.initElements(driver, POPaymentLater.class);
		payLtr.payltr(suppID, prdID, qty, unitP, taxCode, payType);
			POR_ValidateSupp validsupp = PageFactory.initElements(driver, POR_ValidateSupp.class);
		validsupp.ReceiptvalidateSupp();
		
}
	@Test(priority=3)
	public void POR_Vldt_PO_TC_3() throws Exception
	{
	//Required Data for test case.
		WebDriverCommonlib.waitForPageToLoad();
		String suppID = POExcelLib.getExcelData("PO", 4, 8);
		String prdID = POExcelLib.getExcelData("PO", 4, 14);
		String qty = POExcelLib.getExcelData("PO", 4, 17);
		String unitP = POExcelLib.getExcelData("PO", 4, 21);
		String taxCode = POExcelLib.getExcelData("PO", 4, 24);
		String payType = POExcelLib.getExcelData("PO", 4, 28);
		driver.get(com.Actouch.Purchase.generic_Lib.Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		POPaymentLater payLtr = PageFactory.initElements(driver, POPaymentLater.class);
		payLtr.payltr(suppID, prdID, qty, unitP, taxCode, payType);
		POR_validatePO validPo =PageFactory.initElements(driver, POR_validatePO.class);
		validPo.ReceiptvalidatePO();
		
	}

@Test(priority=4)
	public void POR_partial_TC_4() throws Exception
	{
	//Required Data for test case.
	WebDriverCommonlib.waitForPageToLoad();
		String suppID = POExcelLib.getExcelData("PO", 4, 8);
		String prdID = POExcelLib.getExcelData("PO", 4, 14);
		String qty = POExcelLib.getExcelData("PO", 4, 17);
		String unitP = POExcelLib.getExcelData("PO", 4, 21);
		String taxCode = POExcelLib.getExcelData("PO", 4, 24);
		String payType = POExcelLib.getExcelData("PO", 4, 28);
		String partial = POExcelLib.getExcelData("Receipt", 07, 06);
		String Total = POExcelLib.getExcelData("Receipt", 7, 16);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(com.Actouch.Purchase.generic_Lib.Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		POPaymentLater payLtr = PageFactory.initElements(driver, POPaymentLater.class);
		payLtr.payltr(suppID, prdID, qty, unitP, taxCode, payType);
		POR_PartialReceipt partialReceipt = PageFactory.initElements(driver, POR_PartialReceipt.class);
			partialReceipt.Partialreceipt(partial);
			BigDecimal Actual = new BigDecimal(POR_PartialReceipt.amt);	
			Assert.assertEquals(Actual,expected,"total amount not correct");
			 System.out.println("total Amount verified");
			
	}

@Test(priority=5)
	public void POR_Full_TC_5() throws Exception
	{ 
		//Required Data for test case.
	WebDriverCommonlib.waitForPageToLoad();
		String suppID = POExcelLib.getExcelData("PO", 4, 8);
		String prdID = POExcelLib.getExcelData("PO", 4, 14);
		String qty = POExcelLib.getExcelData("PO", 4, 17);
		String unitP = POExcelLib.getExcelData("PO", 4, 21);
		String taxCode = POExcelLib.getExcelData("PO", 4, 24);
		String payType = POExcelLib.getExcelData("PO", 4, 28);
		String Total = POExcelLib.getExcelData("Receipt", 8, 16);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(com.Actouch.Purchase.generic_Lib.Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		POPaymentLater payLtr = PageFactory.initElements(driver, POPaymentLater.class);
		payLtr.payltr(suppID, prdID, qty, unitP, taxCode, payType);
	POR_FullReceipt FullReceipt =PageFactory.initElements(driver, POR_FullReceipt.class);
	FullReceipt.Fullreceipt();
	BigDecimal Actual = new BigDecimal(POR_FullReceipt.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
	}
@Test(priority=6)
public void POR_partial_Tax_TC_6() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String suppID = POExcelLib.getExcelData("PO", 4, 8);
	String prdID = POExcelLib.getExcelData("PO", 4, 14);
	String qty = POExcelLib.getExcelData("PO", 4, 17);
	String unitP = POExcelLib.getExcelData("PO", 4, 21);
	String taxCode = POExcelLib.getExcelData("PO", 4, 24);
	String payType = POExcelLib.getExcelData("PO", 4, 28);
	 String partial = POExcelLib.getExcelData("Receipt", 9, 06);
	 String newTaxCode = POExcelLib.getExcelData("Receipt", 9, 8);
	 String Total = POExcelLib.getExcelData("Receipt", 9, 16);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 driver.get(com.Actouch.Purchase.generic_Lib.Constant.PurchaseOrder_new);
	 driver.navigate().refresh();
	POPaymentLater payLtr = PageFactory.initElements(driver, POPaymentLater.class);
	payLtr.payltr(suppID, prdID, qty, unitP, taxCode, payType);
	POR_PartialTax PORPT = PageFactory.initElements(driver, POR_PartialTax.class);
			PORPT.PartialreceiptTax(partial,taxCode,newTaxCode);
			BigDecimal Actual = new BigDecimal(POR_PartialTax.amt);	
			Assert.assertEquals(Actual,expected,"total amount not correct");
			 System.out.println("total Amount verified");
}


@Test(priority=7)
public void POR_Full_Tax_TC_7() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
String suppID = POExcelLib.getExcelData("PO", 4, 8);
	String prdID = POExcelLib.getExcelData("PO", 4, 14);
	String qty = POExcelLib.getExcelData("PO", 4, 17);
	String unitP = POExcelLib.getExcelData("PO", 4, 21);
	String taxCode = POExcelLib.getExcelData("PO", 4, 24);
	String payType = POExcelLib.getExcelData("PO", 4, 28);
	String newTaxCode = POExcelLib.getExcelData("Receipt", 10, 8);
	String Total = POExcelLib.getExcelData("Receipt", 10, 16);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(com.Actouch.Purchase.generic_Lib.Constant.PurchaseOrder_new);
	driver.navigate().refresh();
	POPaymentLater payLtr = PageFactory.initElements(driver, POPaymentLater.class);
	payLtr.payltr(suppID, prdID, qty, unitP, taxCode, payType);
	POR_FullTax PORFT = PageFactory.initElements(driver, POR_FullTax.class);
			PORFT.ReceiptTax(taxCode,newTaxCode);
			BigDecimal Actual = new BigDecimal(POR_FullTax.amt);	
			Assert.assertEquals(Actual,expected,"total amount not correct");
			 System.out.println("total Amount verified");
}

@Test(priority=8)
public void POR_DiliveryChallan_TC_8() throws Exception
{
	//Required Data for test case.
	WebDriverCommonlib.waitForPageToLoad();
	String suppID = POExcelLib.getExcelData("PO", 4, 8);
	String prdID = POExcelLib.getExcelData("PO", 4, 14);
	String qty = POExcelLib.getExcelData("PO", 4, 17);
	String unitP = POExcelLib.getExcelData("PO", 4, 21);
	String taxCode = POExcelLib.getExcelData("PO", 4, 24);
	String payType = POExcelLib.getExcelData("PO", 4, 28);
	 String DC = POExcelLib.getExcelData("Receipt", 11, 9);
	 String Total = POExcelLib.getExcelData("Receipt",11,16);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 driver.get(com.Actouch.Purchase.generic_Lib.Constant.PurchaseOrder_new);
	 driver.navigate().refresh();
	POPaymentLater payLtr = PageFactory.initElements(driver, POPaymentLater.class);
	payLtr.payltr(suppID, prdID, qty, unitP, taxCode, payType);
		POR_DlryChallan Delvery = PageFactory.initElements(driver, POR_DlryChallan.class);
	Delvery.FullreceiptDlry(DC);
	BigDecimal Actual = new BigDecimal(POR_DlryChallan.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=9)
public void POR_Vehicle_TC_9() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String suppID = POExcelLib.getExcelData("PO", 4, 8);
	String prdID = POExcelLib.getExcelData("PO", 4, 14);
	String qty = POExcelLib.getExcelData("PO", 4, 17);
	String unitP = POExcelLib.getExcelData("PO", 4, 21);
	String taxCode = POExcelLib.getExcelData("PO", 4, 24);
	String payType = POExcelLib.getExcelData("PO", 4, 28);
	String Total = POExcelLib.getExcelData("Receipt",12, 16);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(com.Actouch.Purchase.generic_Lib.Constant.PurchaseOrder_new);
	driver.navigate().refresh();
	POPaymentLater payLtr = PageFactory.initElements(driver, POPaymentLater.class);
	payLtr.payltr(suppID, prdID, qty, unitP, taxCode, payType);
	POR_vehicleDetail PORV = PageFactory.initElements(driver, POR_vehicleDetail.class);
	PORV.ReceiptVehicle("TransPortName", "VehicleNo", "GCnumber", "Packing_No", "NumberOfPackage", "Package_Weight");
	BigDecimal Actual = new BigDecimal(POR_vehicleDetail.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}

@Test(priority=10)
public void POR_Cash_Disper_TC_10() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
String suppID = POExcelLib.getExcelData("PO", 4, 8);
	String prdID = POExcelLib.getExcelData("PO", 4, 14);
	String qty = POExcelLib.getExcelData("PO", 4, 17);
	String unitP = POExcelLib.getExcelData("PO", 4, 21);
	String taxCode = POExcelLib.getExcelData("PO", 4, 24);
	String payType = POExcelLib.getExcelData("PO", 4, 28);
	 String Dis = POExcelLib.getExcelData("Receipt", 13, 10);
	 String Total = POExcelLib.getExcelData("Receipt",13, 16);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 driver.get(com.Actouch.Purchase.generic_Lib.Constant.PurchaseOrder_new);
		driver.navigate().refresh();
	POPaymentLater payLtr = PageFactory.initElements(driver, POPaymentLater.class);
	payLtr.payltr(suppID, prdID, qty, unitP, taxCode, payType);
	POR_DisPer PORDSP =PageFactory.initElements(driver, POR_DisPer.class);
	PORDSP.FullreceiptDisP(Dis);
	BigDecimal Actual = new BigDecimal(POR_DisPer.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority = 11)
public void POR_cash_DisINR_TC_11() throws Exception
{
WebDriverCommonlib.waitForPageToLoad();
	String suppID = POExcelLib.getExcelData("PO", 4, 8);
	String prdID = POExcelLib.getExcelData("PO", 4, 14);
	String qty = POExcelLib.getExcelData("PO", 4, 17);
	String unitP = POExcelLib.getExcelData("PO", 4, 21);
	String taxCode = POExcelLib.getExcelData("PO", 4, 24);
	String payType = POExcelLib.getExcelData("PO", 4, 28);
	 String Dis = POExcelLib.getExcelData("Receipt", 14, 10);
	 String Total = POExcelLib.getExcelData("Receipt",14, 16);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 driver.get(com.Actouch.Purchase.generic_Lib.Constant.PurchaseOrder_new);
		driver.navigate().refresh();
	POPaymentLater payLtr = PageFactory.initElements(driver, POPaymentLater.class);
	payLtr.payltr(suppID, prdID, qty, unitP, taxCode, payType);
	POR_DisINR DSINR = PageFactory.initElements(driver,POR_DisINR.class);
	DSINR.FullreceiptDisI(Dis);
	BigDecimal Actual = new BigDecimal(POR_DisINR.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=12)
public void POR_ShippingCharges_TC_12() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String suppID = POExcelLib.getExcelData("PO", 4, 8);
	String prdID = POExcelLib.getExcelData("PO", 4, 14);
	String qty = POExcelLib.getExcelData("PO", 4, 17);
	String unitP = POExcelLib.getExcelData("PO", 4, 21);
	String taxCode = POExcelLib.getExcelData("PO", 4, 24);
	String payType = POExcelLib.getExcelData("PO", 4, 28);
	String shpCharge = POExcelLib.getExcelData("Receipt", 15, 11);
	String Total = POExcelLib.getExcelData("Receipt",15, 16);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(com.Actouch.Purchase.generic_Lib.Constant.PurchaseOrder_new);
	driver.navigate().refresh();
	POPaymentLater payLtr = PageFactory.initElements(driver, POPaymentLater.class);
	payLtr.payltr(suppID, prdID, qty, unitP, taxCode, payType);
		POR_shippingCharge PORShpCrg = PageFactory.initElements(driver, POR_shippingCharge.class);
	PORShpCrg.ReceiptShpCharg(shpCharge);
	BigDecimal Actual = new BigDecimal(POR_shippingCharge.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
	
}
@Test(priority=13)
public void POR_roundOff_TC_13() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String suppID = POExcelLib.getExcelData("PO", 4, 8);
	String prdID = POExcelLib.getExcelData("PO", 4, 14);
	String qty = POExcelLib.getExcelData("PO", 4, 17);
	String unitP = POExcelLib.getExcelData("PO", 4, 21);
	String taxCode = POExcelLib.getExcelData("PO", 4, 24);
	String payType = POExcelLib.getExcelData("PO", 4, 28);
	 String roundOff = POExcelLib.getExcelData("Receipt", 16, 12);
	 String Total = POExcelLib.getExcelData("Receipt",16, 16);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 driver.get(com.Actouch.Purchase.generic_Lib.Constant.PurchaseOrder_new);
		driver.navigate().refresh();
	POPaymentLater payLtr = PageFactory.initElements(driver, POPaymentLater.class);
	payLtr.payltr(suppID, prdID, qty, unitP, taxCode, payType);
	POR_RoundOff PORRF= PageFactory.initElements(driver, POR_RoundOff.class);
	PORRF.ReceiptRouindOff(roundOff);
	BigDecimal Actual = new BigDecimal(POR_RoundOff.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=14)
public void POR_ShippingCharges_tax_TC_14() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
String suppID = POExcelLib.getExcelData("PO", 4, 8);
String prdID = POExcelLib.getExcelData("PO", 4, 14);
String qty = POExcelLib.getExcelData("PO", 4, 17);
String unitP = POExcelLib.getExcelData("PO", 4, 21);
String taxCode = POExcelLib.getExcelData("PO", 4, 24);
String payType = POExcelLib.getExcelData("PO", 4, 28);
String shpCharge = POExcelLib.getExcelData("Receipt", 17, 11);
String shpTax = POExcelLib.getExcelData("Receipt", 17, 13);
String Total = POExcelLib.getExcelData("Receipt", 17, 16);
BigDecimal expected = new BigDecimal(Total);
expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
driver.navigate().refresh();
POPaymentLater payLtr = PageFactory.initElements(driver, POPaymentLater.class);
payLtr.payltr(suppID, prdID, qty, unitP, taxCode, payType);
POR_ShippingTax ShippingTax =PageFactory.initElements(driver, POR_ShippingTax.class);
ShippingTax.ReceiptShpChargTAX(shpCharge, "YES",shpTax);
BigDecimal Actual = new BigDecimal(POR_ShippingTax.amt);	
Assert.assertEquals(Actual,expected,"total amount not correct");
 System.out.println("total Amount verified");
}
@Test(priority=15)
public void POR_RejectedQty_TC_15() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
String suppID = POExcelLib.getExcelData("PO", 4, 8);
	String prdID = POExcelLib.getExcelData("PO", 4, 14);
	String qty = POExcelLib.getExcelData("PO", 4, 17);
	String unitP = POExcelLib.getExcelData("PO", 4, 21);
	String taxCode = POExcelLib.getExcelData("PO", 4, 24);
	String payType = POExcelLib.getExcelData("PO", 4, 28);
	String partial = POExcelLib.getExcelData("Receipt", 18, 06);
	String Reject  = POExcelLib.getExcelData("Receipt", 18, 15);
	String Total = POExcelLib.getExcelData("Receipt", 18, 16);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(com.Actouch.Purchase.generic_Lib.Constant.PurchaseOrder_new); 
	driver.navigate().refresh();
	POPaymentLater payLtr = PageFactory.initElements(driver, POPaymentLater.class);
	payLtr.payltr(suppID, prdID, qty, unitP, taxCode, payType);
	POR_RejectedQty PORrej = PageFactory.initElements(driver, POR_RejectedQty.class);
	PORrej.FullreceiptScrab(partial, Reject);
	BigDecimal Actual = new BigDecimal(POR_RejectedQty.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
	
}

}
