package com.Actouch.PurchaseINV.TestScript;
import java.math.BigDecimal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.POExcelLib;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;
import com.Actouch.PurchaseINV.pageObjectRepository.Login;
import com.Actouch.PurchaseINV.pageObjectRepository.POPaymentLaterRecvnow;
import com.Actouch.PurchaseINV.pageObjectRepository.UPRCVDeliveryChallen;
import com.Actouch.PurchaseINV.pageObjectRepository.UPRCVDisINR;
import com.Actouch.PurchaseINV.pageObjectRepository.UPRCVDisPer;
import com.Actouch.PurchaseINV.pageObjectRepository.UPRCVMemo;
import com.Actouch.PurchaseINV.pageObjectRepository.UPRCVQuantity;
import com.Actouch.PurchaseINV.pageObjectRepository.UPRCVReference;
import com.Actouch.PurchaseINV.pageObjectRepository.UPRCVRoundoff;
import com.Actouch.PurchaseINV.pageObjectRepository.UPRCVShipAddress;
import com.Actouch.PurchaseINV.pageObjectRepository.UPRCVShipCharge;
import com.Actouch.PurchaseINV.pageObjectRepository.UPRCVShipTax;
import com.Actouch.PurchaseINV.pageObjectRepository.UPRCVTax;
import com.Actouch.PurchaseINV.pageObjectRepository.UPRCVTermCond;
import com.Actouch.PurchaseINV.pageObjectRepository.UPRCVVehicleDetail;

public class ReceiptUpdateInv {

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
	public void UPRCV_updateReference_TC_2() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		 String suppID = POExcelLib.getExcelData("PO", 5, 8);
		 String prodID = POExcelLib.getExcelData("PO", 5, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
		 String unitp = POExcelLib.getExcelData("PO", 5, 21);
		 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
		 String payType = POExcelLib.getExcelData("PO", 5, 28);
		 String Total = POExcelLib.getExcelData("PO", 5, 39);
		 String UPRef = POExcelLib.getExcelData("UPRCV", 04, 05);
		 String UPRefAmt = POExcelLib.getExcelData("UPRCV", 04, 06);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		 driver.get(Constant.PurchaseOrder_new);
	       driver.navigate().refresh();
			POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
			payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
			UPRCVReference UPRR=PageFactory.initElements(driver, UPRCVReference.class);
			UPRR.ReFerence(UPRef, UPRefAmt);
			

	}
	@Test(priority=3)
	public void UPRCV_updateShipAddress_TC_3() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		 String suppID = POExcelLib.getExcelData("PO", 5, 8);
		 String prodID = POExcelLib.getExcelData("PO", 5, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
		 String unitp = POExcelLib.getExcelData("PO", 5, 21);
		 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
		 String payType = POExcelLib.getExcelData("PO", 5, 28);
		 String Total = POExcelLib.getExcelData("PO", 5, 39);
		 String ShipAddress = POExcelLib.getExcelData("UPRCV", 05, 06);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		 driver.get(Constant.PurchaseOrder_new);
	       driver.navigate().refresh();
			POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
			payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
			UPRCVShipAddress UPRS = PageFactory.initElements(driver, UPRCVShipAddress.class);
			UPRS.ReFerence(ShipAddress);
	}
@Test(priority=4)
public void UPRCV_updateQuantity_TC_4() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String suppID = POExcelLib.getExcelData("PO", 5, 8);
	 String prodID = POExcelLib.getExcelData("PO", 5, 14);
	 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
	 String unitp = POExcelLib.getExcelData("PO", 5, 21);
	 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
	 String payType = POExcelLib.getExcelData("PO", 5, 28);
	 String Total = POExcelLib.getExcelData("PO", 5, 39);
	 String UPQnty = POExcelLib.getExcelData("UPRCV", 06, 07);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 driver.get(Constant.PurchaseOrder_new);
      driver.navigate().refresh();
		POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
		payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
		UPRCVQuantity UPRQ =PageFactory.initElements(driver, UPRCVQuantity.class);
		UPRQ.Quantity(UPQnty);
}
@Test(priority=5)
public void UPRCV_updateTax_TC_5() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String suppID = POExcelLib.getExcelData("PO", 5, 8);
	 String prodID = POExcelLib.getExcelData("PO", 5, 14);
	 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
	 String unitp = POExcelLib.getExcelData("PO", 5, 21);
	 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
	 String payType = POExcelLib.getExcelData("PO", 5, 28);
	 String Total = POExcelLib.getExcelData("PO", 5, 39);
	 String UPTax = POExcelLib.getExcelData("UPRCV", 07, 8);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 driver.get(Constant.PurchaseOrder_new);
     driver.navigate().refresh();
		POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
		payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
		UPRCVTax UPRT=PageFactory.initElements(driver, UPRCVTax.class);
		UPRT.Quantity(UPTax);
}
@Test(priority=6)
public void UPRCV_updateDeliveryChallen_TC_6() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String suppID = POExcelLib.getExcelData("PO", 5, 8);
	 String prodID = POExcelLib.getExcelData("PO", 5, 14);
	 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
	 String unitp = POExcelLib.getExcelData("PO", 5, 21);
	 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
	 String payType = POExcelLib.getExcelData("PO", 5, 28);
	 String Total = POExcelLib.getExcelData("PO", 5, 39);
	 String UPDeliveryChallen = POExcelLib.getExcelData("UPRCV", 8, 9);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 driver.get(Constant.PurchaseOrder_new);
    driver.navigate().refresh();
		POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
		payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
		UPRCVDeliveryChallen UPRDC=PageFactory.initElements(driver, UPRCVDeliveryChallen.class);
		UPRDC.ReFerence(UPDeliveryChallen);
	
	
}
@Test(priority=7)
public void UPRCV_updateVehicleDetails_TC_7() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String suppID = POExcelLib.getExcelData("PO", 5, 8);
	 String prodID = POExcelLib.getExcelData("PO", 5, 14);
	 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
	 String unitp = POExcelLib.getExcelData("PO", 5, 21);
	 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
	 String payType = POExcelLib.getExcelData("PO", 5, 28);
	 String Total = POExcelLib.getExcelData("PO", 5, 39);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 driver.get(Constant.PurchaseOrder_new);
   driver.navigate().refresh();
		POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
		payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
		UPRCVVehicleDetail UPRVD = PageFactory.initElements(driver, UPRCVVehicleDetail.class);
		UPRVD.ReFerence("TransName"," VehicleNo", "GclrNo", "PackingNo", "PackageNo", "packingWgt");
		
}

@Test(priority=8)
public void UPRCV_updateTermCondition_TC_8() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String suppID = POExcelLib.getExcelData("PO", 5, 8);
	 String prodID = POExcelLib.getExcelData("PO", 5, 14);
	 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
	 String unitp = POExcelLib.getExcelData("PO", 5, 21);
	 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
	 String payType = POExcelLib.getExcelData("PO", 5, 28);
	 String Total = POExcelLib.getExcelData("PO", 5, 39);
	 String UPTermCond = POExcelLib.getExcelData("UPRCV", 10, 11);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 driver.get(Constant.PurchaseOrder_new);
  driver.navigate().refresh();
		POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
		payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
		UPRCVTermCond UPRTC = PageFactory.initElements(driver, UPRCVTermCond.class);
		UPRTC.ReFerence(UPTermCond);
}
@Test(priority=9)
public void UPRCV_updateMemo_TC_9() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String suppID = POExcelLib.getExcelData("PO", 5, 8);
	 String prodID = POExcelLib.getExcelData("PO", 5, 14);
	 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
	 String unitp = POExcelLib.getExcelData("PO", 5, 21);
	 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
	 String payType = POExcelLib.getExcelData("PO", 5, 28);
	 String Total = POExcelLib.getExcelData("PO", 5, 39);
	 String UPMemo = POExcelLib.getExcelData("UPRCV", 11, 12);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 driver.get(Constant.PurchaseOrder_new);
   driver.navigate().refresh();
		POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
		payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
		UPRCVMemo UPRM =PageFactory.initElements(driver, UPRCVMemo.class);
		UPRM.ReFerence(UPMemo);
}
@Test(priority=10)
public void UPRCV_updateDiscountPer_TC_10() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String suppID = POExcelLib.getExcelData("PO", 5, 8);
	 String prodID = POExcelLib.getExcelData("PO", 5, 14);
	 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
	 String unitp = POExcelLib.getExcelData("PO", 5, 21);
	 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
	 String payType = POExcelLib.getExcelData("PO", 5, 28);
	 String Total = POExcelLib.getExcelData("PO", 5, 39);
	 String UPDisper = POExcelLib.getExcelData("UPRCV", 12, 13);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 driver.get(Constant.PurchaseOrder_new);
driver.navigate().refresh();
		POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
		payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
		UPRCVDisPer UPRDP=PageFactory.initElements(driver, UPRCVDisPer.class);
		UPRDP.ReFerence(UPDisper);
}
@Test(priority=11)
public void UPRCV_updateDiscountINR_TC_11() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String suppID = POExcelLib.getExcelData("PO", 5, 8);
	 String prodID = POExcelLib.getExcelData("PO", 5, 14);
	 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
	 String unitp = POExcelLib.getExcelData("PO", 5, 21);
	 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
	 String payType = POExcelLib.getExcelData("PO", 5, 28);
	 String Total = POExcelLib.getExcelData("PO", 5, 39);
	 String UPDisINR = POExcelLib.getExcelData("UPRCV", 13, 13);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 driver.get(Constant.PurchaseOrder_new);
driver.navigate().refresh();
		POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
		payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
		UPRCVDisINR UPRI = PageFactory.initElements(driver, UPRCVDisINR.class);
		UPRI.ReFerence(UPDisINR);
}

@Test(priority=12)
public void UPRCV_updateShipCharge_TC_12() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String suppID = POExcelLib.getExcelData("PO", 5, 8);
	 String prodID = POExcelLib.getExcelData("PO", 5, 14);
	 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
	 String unitp = POExcelLib.getExcelData("PO", 5, 21);
	 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
	 String payType = POExcelLib.getExcelData("PO", 5, 28);
	 String Total = POExcelLib.getExcelData("PO", 5, 39);
	 String ShipCharge = POExcelLib.getExcelData("UPRCV", 14, 14);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 driver.get(Constant.PurchaseOrder_new);
 driver.navigate().refresh();
		POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
		payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
		UPRCVShipCharge UPRSC = PageFactory.initElements(driver, UPRCVShipCharge.class);
		UPRSC.ReFerence(ShipCharge);
}

@Test(priority=13)
public void UPRCV_updateRoundOff_TC_13() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String suppID = POExcelLib.getExcelData("PO", 5, 8);
	 String prodID = POExcelLib.getExcelData("PO", 5, 14);
	 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
	 String unitp = POExcelLib.getExcelData("PO", 5, 21);
	 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
	 String payType = POExcelLib.getExcelData("PO", 5, 28);
	 String Total = POExcelLib.getExcelData("PO", 5, 39);
	 String UPRoundOff = POExcelLib.getExcelData("UPRCV", 15, 15);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 driver.get(Constant.PurchaseOrder_new);
  driver.navigate().refresh();
		POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
		payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
		UPRCVRoundoff UPRRO =PageFactory.initElements(driver, UPRCVRoundoff.class);
		UPRRO.ReFerence(UPRoundOff);
}
@Test(priority = 15)
public void UPRCV_updateTaxShipCharge_TC_15() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String suppID = POExcelLib.getExcelData("PO", 5, 8);
	 String prodID = POExcelLib.getExcelData("PO", 5, 14);
	 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
	 String unitp = POExcelLib.getExcelData("PO", 5, 21);
	 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
	 String payType = POExcelLib.getExcelData("PO", 5, 28);
	 String Total = POExcelLib.getExcelData("PO", 5, 39);
	 String ShipCharge = POExcelLib.getExcelData("UPRCV", 17, 14);
	 String ShipTax = POExcelLib.getExcelData("UPRCV", 17, 8);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 driver.get(Constant.PurchaseOrder_new);
 driver.navigate().refresh();
		POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
		payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
		UPRCVShipTax UPRTC=PageFactory.initElements(driver, UPRCVShipTax.class);
		UPRTC.ReFerence(ShipCharge, ShipTax);
		
}

}
