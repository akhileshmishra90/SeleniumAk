package com.Actouch.PurchaseINV.TestScript;



import java.io.IOException;
import java.math.BigDecimal;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.POExcelLib;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;
import com.Actouch.PurchaseINV.pageObjectRepository.Login;
import com.Actouch.PurchaseINV.pageObjectRepository.PRR_CashDisINR;
import com.Actouch.PurchaseINV.pageObjectRepository.PRR_CashDisPer;
import com.Actouch.PurchaseINV.pageObjectRepository.PRR_CustRef;
import com.Actouch.PurchaseINV.pageObjectRepository.PRR_FullReturn;
import com.Actouch.PurchaseINV.pageObjectRepository.PRR_FullTax;
import com.Actouch.PurchaseINV.pageObjectRepository.PRR_PartialReturn;
import com.Actouch.PurchaseINV.pageObjectRepository.PRR_PartialTAX;
import com.Actouch.PurchaseINV.pageObjectRepository.PRR_RoundOff;
import com.Actouch.PurchaseINV.pageObjectRepository.PRR_ShipCharge;
import com.Actouch.PurchaseINV.pageObjectRepository.PRR_ShipTax;
import com.Actouch.PurchaseINV.pageObjectRepository.PRR_ValidPO;
import com.Actouch.PurchaseINV.pageObjectRepository.PRR_ValidateSupp;
import com.Actouch.PurchaseINV.pageObjectRepository.PRR_Vehicle;
import com.Actouch.PurchaseINV.pageObjectRepository.POPaymentLaterRecvnow;


public class PurchaseReturn {
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
public void PRR_Vldt_Supplier_TC_2() throws Exception
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
		PRR_ValidateSupp PRRVS=PageFactory.initElements(driver, PRR_ValidateSupp.class);
		PRRVS.validateSupp();
}
@Test(priority=3)
public void PRR_Vldt_PO_TC_3() throws Exception
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
		PRR_ValidPO PRRVP = PageFactory.initElements(driver, PRR_ValidPO.class);
		PRRVP.ReceiptvalidatePO();
}


	@Test(priority=4)
	public void PRR_Partial_TC_4() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String suppID = POExcelLib.getExcelData("PO", 5, 8);
		 String prodID = POExcelLib.getExcelData("PO", 5, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
		 String unitp = POExcelLib.getExcelData("PO", 5, 21);
		 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
		 String payType = POExcelLib.getExcelData("PO", 5, 28);
		 String ReturnQnty = POExcelLib.getExcelData("PRR", 05, 06);
		 String Reason = POExcelLib.getExcelData("PRR", 05, 9);
		 String Total = POExcelLib.getExcelData("PRR", 05, 15);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		 driver.get(Constant.PurchaseOrder_new);
			driver.navigate().refresh();
			POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
			payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
			PRR_PartialReturn PRRP = PageFactory.initElements(driver, PRR_PartialReturn.class);
			PRRP.FullReturn(Reason, ReturnQnty);
			BigDecimal Actual = new BigDecimal(PRR_PartialReturn.amt);	
			Assert.assertEquals(Actual,expected,"total amount not correct");
			 System.out.println("total Amount verified");
	}

	@Test(priority=5)
	public void  PRR_Full_TC_5() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
	 String suppID = POExcelLib.getExcelData("PO", 5, 8);
		 String prodID = POExcelLib.getExcelData("PO", 5, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
		 String unitp = POExcelLib.getExcelData("PO", 5, 21);
		 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
		 String payType = POExcelLib.getExcelData("PO", 5, 28);
		 String Reason = POExcelLib.getExcelData("PRR", 06, 9);
		 String Total = POExcelLib.getExcelData("PRR", 06, 15);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		 driver.get(Constant.PurchaseOrder_new);
			driver.navigate().refresh();
			POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
			payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
			PRR_FullReturn PRRFR=PageFactory.initElements(driver, PRR_FullReturn.class);
			PRRFR.FullReturn(Reason);
			BigDecimal Actual = new BigDecimal(PRR_FullReturn.amt);	
			Assert.assertEquals(Actual,expected,"total amount not correct");
			 System.out.println("total Amount verified");
	}
	@Test(priority =6)
public void PRR_partialTax_TC_6() throws Exception
{
		WebDriverCommonlib.waitForPageToLoad();
		 String suppID = POExcelLib.getExcelData("PO", 5, 8);
		 String prodID = POExcelLib.getExcelData("PO", 5, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
		 String unitp = POExcelLib.getExcelData("PO", 5, 21);
		 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
		 String payType = POExcelLib.getExcelData("PO", 5, 28);
		 String ReturnQnty = POExcelLib.getExcelData("PRR", 07, 06);
		 String Reason = POExcelLib.getExcelData("PRR", 07, 9);
		 String Total = POExcelLib.getExcelData("PRR", 07, 15);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		 driver.get(Constant.PurchaseOrder_new);
			driver.navigate().refresh();
			POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
			payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
				PRR_PartialTAX PRRPT =PageFactory.initElements(driver, PRR_PartialTAX.class);
			PRRPT.FullReturnTax(Reason, ReturnQnty);
			BigDecimal Actual = new BigDecimal(PRR_PartialTAX.amt);	
			Assert.assertEquals(Actual,expected,"total amount not correct");
			 System.out.println("total Amount verified");
}

@Test(priority = 7)
public void PRR_FullTAX_TC_7() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String suppID = POExcelLib.getExcelData("PO", 5, 8);
	 String prodID = POExcelLib.getExcelData("PO", 5, 14);
	 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
	 String unitp = POExcelLib.getExcelData("PO", 5, 21);
	 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
	 String payType = POExcelLib.getExcelData("PO", 5, 28);
	 String Reason = POExcelLib.getExcelData("PRR", 8, 9);
	 String Total = POExcelLib.getExcelData("PRR", 8, 15);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 driver.get(Constant.PurchaseOrder_new);
	driver.navigate().refresh();
		POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
		payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
	PRR_FullTax PRRFT = PageFactory.initElements(driver, PRR_FullTax.class);
		PRRFT.FullReturnTax(Reason);
		BigDecimal Actual = new BigDecimal(PRR_FullTax.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
}
@Test(priority=8)
public void PRR_CustRef_TC_8() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String suppID = POExcelLib.getExcelData("PO", 5, 8);
	 String prodID = POExcelLib.getExcelData("PO", 5, 14);
	 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
	 String unitp = POExcelLib.getExcelData("PO", 5, 21);
	 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
	 String payType = POExcelLib.getExcelData("PO", 5, 28);
	 String Referenc = POExcelLib.getExcelData("PRR", 9, 07);
	 String refno = POExcelLib.getExcelData("PRR",9, 8);
	 String Reason = POExcelLib.getExcelData("PRR", 9, 9);
	 String Total = POExcelLib.getExcelData("PRR", 9, 15);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
		payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
		PRR_CustRef PRRCR = PageFactory.initElements(driver, PRR_CustRef.class);
		PRRCR.FullReturnCustRef(Reason,Referenc,refno);
		BigDecimal Actual = new BigDecimal(PRR_CustRef.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");

	
}
@Test(priority=9)
public void PRR_vehicle_TC_9() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String suppID = POExcelLib.getExcelData("PO", 5, 8);
	 String prodID = POExcelLib.getExcelData("PO", 5, 14);
	 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
	 String unitp = POExcelLib.getExcelData("PO", 5, 21);
	 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
	 String payType = POExcelLib.getExcelData("PO", 5, 28);
	 String Reason = POExcelLib.getExcelData("PRR", 10, 9);
	 String Total = POExcelLib.getExcelData("PRR", 10, 15);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
		payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
		PRR_Vehicle PRRV = PageFactory.initElements(driver, PRR_Vehicle.class);
		PRRV.FullReturnVehicle(Reason, "TransPorter", "vehicleNo", "gcNo", "packingNo", "noOfPackage", "packingWeight");
		BigDecimal Actual = new BigDecimal(PRR_Vehicle.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
}
 

@Test(priority=10)
public void PRR_Cash_DisPer_TC_10() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String suppID = POExcelLib.getExcelData("PO", 5, 8);
	 String prodID = POExcelLib.getExcelData("PO", 5, 14);
	 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
	 String unitp = POExcelLib.getExcelData("PO", 5, 21);
	 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
	 String payType = POExcelLib.getExcelData("PO", 5, 28);
	 String Reason = POExcelLib.getExcelData("PRR", 11, 9);
	 String DIS = POExcelLib.getExcelData("PRR", 11, 10);
	 String Total = POExcelLib.getExcelData("PRR",11, 15);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
		payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
		PRR_CashDisPer PRRCDSP = PageFactory.initElements(driver, PRR_CashDisPer.class);
		PRRCDSP.FullReturnDisp(Reason, DIS);
		BigDecimal Actual = new BigDecimal(PRR_CashDisPer.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
	
}
@Test(priority =11)
public void PRR_cash_DisINR_TC_11() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String suppID = POExcelLib.getExcelData("PO", 5, 8);
	 String prodID = POExcelLib.getExcelData("PO", 5, 14);
	 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
	 String unitp = POExcelLib.getExcelData("PO", 5, 21);
	 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
	 String payType = POExcelLib.getExcelData("PO", 5, 28);
	 String DISINR = POExcelLib.getExcelData("PRR", 12, 10);
	 String Reason = POExcelLib.getExcelData("PRR", 12, 9);
	 String Total = POExcelLib.getExcelData("PRR", 12, 15);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
		payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
		PRR_CashDisINR PRRCDSI = PageFactory.initElements(driver, PRR_CashDisINR.class);
		PRRCDSI.FullReturnDisI(Reason, DISINR);
		BigDecimal Actual = new BigDecimal(PRR_CashDisINR.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
	
}

@Test(priority=12)
public void PRR_ShippingCharges_TC_12() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String suppID = POExcelLib.getExcelData("PO", 5, 8);
	 String prodID = POExcelLib.getExcelData("PO", 5, 14);
	 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
	 String unitp = POExcelLib.getExcelData("PO", 5, 21);
	 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
	 String payType = POExcelLib.getExcelData("PO", 5, 28);
	 String ShipChage = POExcelLib.getExcelData("PRR", 13, 11);
	 String Reason = POExcelLib.getExcelData("PRR", 13, 9);
	 String Total = POExcelLib.getExcelData("PRR", 13, 15);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
		payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
		PRR_ShipCharge PRRSC= PageFactory.initElements(driver, PRR_ShipCharge.class);
		PRRSC.FullReturnShpC(Reason, ShipChage);
		BigDecimal Actual = new BigDecimal(PRR_ShipCharge.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
}

@Test(priority=13)
public void PRR_roundOff_TC_13() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String suppID = POExcelLib.getExcelData("PO", 5, 8);
	 String prodID = POExcelLib.getExcelData("PO", 5, 14);
	 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
	 String unitp = POExcelLib.getExcelData("PO", 5, 21);
	 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
	 String payType = POExcelLib.getExcelData("PO", 5, 28);
	 String Roundoff = POExcelLib.getExcelData("PRR", 14, 12);
	 String Reason = POExcelLib.getExcelData("PRR", 14, 9);
	 String Total = POExcelLib.getExcelData("PRR", 14, 15);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
		payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
		PRR_RoundOff PRRR = PageFactory.initElements(driver, PRR_RoundOff.class);
		PRRR.FullReturnRoundoff(Reason,Roundoff);
		BigDecimal Actual = new BigDecimal(PRR_RoundOff.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
		
}
 
@Test(priority=14)
public void PRR_ShippingCharges_tax_TC_14() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String suppID = POExcelLib.getExcelData("PO", 5, 8);
	 String prodID = POExcelLib.getExcelData("PO", 5, 14);
	 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
	 String unitp = POExcelLib.getExcelData("PO", 5, 21);
	 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
	 String payType = POExcelLib.getExcelData("PO", 5, 28);
	 String shippingCharge = POExcelLib.getExcelData("PRR", 15, 11);
	 String shipTax = POExcelLib.getExcelData("PRR", 15, 13);
	 String Reason = POExcelLib.getExcelData("PRR", 15, 9);
	 String Total = POExcelLib.getExcelData("PRR", 15, 15);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
		payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
		PRR_ShipTax PRRST = PageFactory.initElements(driver, PRR_ShipTax.class);
		PRRST.FullReturnShpC(Reason, shippingCharge, "Yes", shipTax);
		BigDecimal Actual = new BigDecimal(PRR_ShipTax.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
}

}
