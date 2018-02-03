package com.Actouch.SalesINV.TestScript;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.SO_Excellib;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
import com.Actouch.SalesINVLoc.pageObjectRepository.Login;
import com.Actouch.SalesINVLoc.pageObjectRepository.SOPaymentLaterShipnow;
import com.Actouch.SalesINVLoc.pageObjectRepository.UPINVCustID;
import com.Actouch.SalesINVLoc.pageObjectRepository.UPINVDeleveryChallen;
import com.Actouch.SalesINVLoc.pageObjectRepository.UPINVDisINR;
import com.Actouch.SalesINVLoc.pageObjectRepository.UPINVESugam;
import com.Actouch.SalesINVLoc.pageObjectRepository.UPINVMemo;
import com.Actouch.SalesINVLoc.pageObjectRepository.UPINVQuantity;
import com.Actouch.SalesINVLoc.pageObjectRepository.UPINVReference;
import com.Actouch.SalesINVLoc.pageObjectRepository.UPINVRoundOff;
import com.Actouch.SalesINVLoc.pageObjectRepository.UPINVSDisPer;
import com.Actouch.SalesINVLoc.pageObjectRepository.UPINVSalesPerson;
import com.Actouch.SalesINVLoc.pageObjectRepository.UPINVShipAddress;
import com.Actouch.SalesINVLoc.pageObjectRepository.UPINVShipCharge;
import com.Actouch.SalesINVLoc.pageObjectRepository.UPINVTax;
import com.Actouch.SalesINVLoc.pageObjectRepository.UPINVTaxShipCharge;
import com.Actouch.SalesINVLoc.pageObjectRepository.UPINVTermCond;
public class InvoiceUpdateInv {
static WebDriver driver;
SO_Excellib SO_Excellib = new SO_Excellib("D:\\Selenium\\SaleOrderWSWL.xlsx");
@Test(priority=1)
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
public void UPINV_updateCustID_TC_2() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String upCustID = SO_Excellib.getExcelDat("UPINV", 04,06);
	 driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
	UPINVCustID UPIA = PageFactory.initElements(driver, UPINVCustID.class);
	UPIA.UpdateAmount(upCustID);
}
@Test(priority=3)
public void UPINV_updateReference_TC_3() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String Ref = SO_Excellib.getExcelDat("UPINV", 05,07);
	 String RefAmt= SO_Excellib.getExcelDat("UPINV", 06,07);
	 driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
	UPINVReference UPIR = PageFactory.initElements(driver, UPINVReference.class);
	UPIR.UpdateAmount(Ref,RefAmt);
}
@Test(priority=4)
public void UPINV_updateShipAddress_TC_4() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String ShipAdd= SO_Excellib.getExcelDat("UPINV", 06,8);
	 driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
	UPINVShipAddress UPIS = PageFactory.initElements(driver, UPINVShipAddress.class);
	UPIS.UpdateAmount(ShipAdd);
}
@Test(priority =5)
public void UPINV_updateSalePerson_TC_5() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String SalesPerson= SO_Excellib.getExcelDat("UPINV", 07,9);
	 driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
	UPINVSalesPerson UPISP = PageFactory.initElements(driver, UPINVSalesPerson.class);
	UPISP.UpdateAmount(SalesPerson);
}
@Test(priority=6)
public void UPINV_updateQuantity_TC_6() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String UpQnty = SO_Excellib.getExcelDat("UPINV", 8,10);
	 driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
	UPINVQuantity UPIPQ =PageFactory.initElements(driver, UPINVQuantity.class);
	UPIPQ.UpdateAmount(UpQnty);
}
@Test(priority=7)
public void UPINV_updateTax_TC_7() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String UpTax = SO_Excellib.getExcelDat("UPINV", 9,11);
	 driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
	UPINVTax UPIT = PageFactory.initElements(driver, UPINVTax.class);
	UPIT.UpdateAmount(UpTax);
}
@Test(priority=8)
public void UPINV_updateDeliveryChallen_TC_8() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String DelChallen = SO_Excellib.getExcelDat("UPINV", 10,12);
	 driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
	UPINVDeleveryChallen UPID = PageFactory.initElements(driver, UPINVDeleveryChallen.class);
	UPID.UpdateAmount(DelChallen);
}
@Test(priority=9)
public void UPINV_updateESugam_TC_9() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String DelChallen = SO_Excellib.getExcelDat("UPINV", 11,13);
	 driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
	UPINVESugam UPIES=PageFactory.initElements(driver, UPINVESugam.class);
	UPIES.UpdateAmount(DelChallen);
}
@Test(priority=11)
public void UPINV_updateTermCondition_TC_11() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String TermCond = SO_Excellib.getExcelDat("UPINV",13,15);
	 driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
	UPINVTermCond UPITC = PageFactory.initElements(driver, UPINVTermCond.class);
	UPITC.UpdateAmount(TermCond);
}

@Test(priority=12)
public void UPINV_updateMemo_TC_12() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String Memo = SO_Excellib.getExcelDat("UPINV",14,16);
	 driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
	UPINVMemo UPINVM = PageFactory.initElements(driver, UPINVMemo.class);
	UPINVM.UpdateAmount(Memo);
}
@Test(priority=13)
public void UPINV_updateDiscountPer_TC_13() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String Dis = SO_Excellib.getExcelDat("UPINV",15,17);
	 driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
	UPINVSDisPer UPINVDP =PageFactory.initElements(driver, UPINVSDisPer.class);
	UPINVDP.UpdateAmount(Dis);
}
@Test(priority=14)
public void UPINV_updateDiscountINR_TC_14() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String Dis = SO_Excellib.getExcelDat("UPINV",16,17);
	 driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
	UPINVDisINR UPINVDI =PageFactory.initElements(driver, UPINVDisINR.class);
	UPINVDI.UpdateAmount(Dis);
}
@Test(priority=15)
public void UPINV_updateShipCharge_TC_15() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String ShipCharge = SO_Excellib.getExcelDat("UPINV",17,18);
	 driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
	UPINVShipCharge UPISC = PageFactory.initElements(driver, UPINVShipCharge.class);
	UPISC.UpdateAmount(ShipCharge);
}
@Test(priority=16)
public void UPINV_updateRoundOff_TC_16() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String Roundoff = SO_Excellib.getExcelDat("UPINV",18,19);
	 driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
	UPINVRoundOff UPIR =PageFactory.initElements(driver, UPINVRoundOff.class);
	UPIR.UpdateAmount(Roundoff);
}
@Test(priority=18)
public void UPINV_updateTaxShipCharge_TC_18() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String ShipCharge = SO_Excellib.getExcelDat("UPINV",20,18);
	 String UpTax = SO_Excellib.getExcelDat("UPINV", 20,11);
	 driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
	UPINVTaxShipCharge UPITSC = PageFactory.initElements(driver, UPINVTaxShipCharge.class);
	UPITSC.UpdateAmount(ShipCharge, "Yes",UpTax);
}

}
