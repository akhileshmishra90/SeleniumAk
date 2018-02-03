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
import com.Actouch.SalesINVLoc.pageObjectRepository.Login;
import com.Actouch.SalesINVLoc.pageObjectRepository.SOPaymentLaterShipnow;
import com.Actouch.SalesINVLoc.pageObjectRepository.SRCustRef;
import com.Actouch.SalesINVLoc.pageObjectRepository.SRFull;
import com.Actouch.SalesINVLoc.pageObjectRepository.SRFullTax;
import com.Actouch.SalesINVLoc.pageObjectRepository.SRPartial;
import com.Actouch.SalesINVLoc.pageObjectRepository.SRValidateCustomer;
import com.Actouch.SalesINVLoc.pageObjectRepository.SRValidateINV;
import com.Actouch.SalesINVLoc.pageObjectRepository.SR_CashDisPer;
import com.Actouch.SalesINVLoc.pageObjectRepository.SR_CashINR;
import com.Actouch.SalesINVLoc.pageObjectRepository.SR_Esugam;
import com.Actouch.SalesINVLoc.pageObjectRepository.SR_Roundoff;
import com.Actouch.SalesINVLoc.pageObjectRepository.SR_ShippingCharge;
import com.Actouch.SalesINVLoc.pageObjectRepository.SR_shippingTax;
import com.Actouch.SalesINVLoc.pageObjectRepository.SR_vehicle;
import com.Actouch.SalesINVLoc.pageObjectRepository.SRpartialTax;
public class SalesReturns {
	//-------
	WebDriver driver;
	SO_Excellib SO_Excellib = new SO_Excellib("D:\\Selenium\\SaleOrderWSWL.xlsx");
	@Test(priority = 1 )
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
	@Test(priority = 2)
	public void SR_Vldt_Customer_TC_2() throws Exception
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
		SRValidateCustomer SRV = PageFactory.initElements(driver, SRValidateCustomer.class);
		SRV.CustomerValidate();
	}
@Test(priority =3)
public void SR_Vldt_Inv_TC_3() throws Exception
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
	SRValidateINV SRI = PageFactory.initElements(driver,SRValidateINV .class);
	SRI.InvoiceValidate();
}
@Test(priority=4)
public void SR_Partial_TC_4() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String ReturnQnty = SO_Excellib.getExcelDat("SOR", 05, 06);
	 String total = SO_Excellib.getExcelDat("SOR", 05, 15);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");	
	SRPartial SRP =PageFactory.initElements(driver, SRPartial.class);
			SRP.partialReturn(ReturnQnty);
	BigDecimal Actual =new BigDecimal(SRPartial.amt);
			 Assert.assertEquals(Actual, expected,"Total calclulation is incorrect");
			 System.out.println("total Amount verified");
}
@Test(priority=5)
public void SR_Full_TC_5() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String total = SO_Excellib.getExcelDat("SOR", 06, 15);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();		
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");	
	SRFull SRF =PageFactory.initElements(driver, SRFull.class);
	SRF.fullReturn();
	BigDecimal Actual =new BigDecimal(SRFull.amt);
	 Assert.assertEquals(Actual, expected,"Total calclulation is incorrect");
	 System.out.println("total Amount verified");
}

@Test(priority=6)
public void SR_partialTax_TC_6() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String ReturnQnty = SO_Excellib.getExcelDat("SOR", 07, 06);
	 String total = SO_Excellib.getExcelDat("SOR", 07, 15);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");	
	SRpartialTax SRPT =PageFactory.initElements(driver, SRpartialTax.class);
			SRPT.partialTax(ReturnQnty);
			BigDecimal Actual =new BigDecimal(SRpartialTax.amt);
			 Assert.assertEquals(Actual, expected,"Total calclulation is incorrect");
			 System.out.println("total Amount verified");
}
@Test(priority=7)
public void SR_FullTAX_TC_7() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String total = SO_Excellib.getExcelDat("SOR", 8, 15);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");	
	SRFullTax SRFT =PageFactory.initElements(driver, SRFullTax.class);
	SRFT.fullRetTax();
	BigDecimal Actual =new BigDecimal(SRFullTax.amt);
	 Assert.assertEquals(Actual, expected,"Total calclulation is incorrect");
	 System.out.println("total Amount verified");
}
@Test(priority=8)
public void SR_CustRef_TC_8() throws Exception
	{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String Referenc = SO_Excellib.getExcelDat("SOR", 9, 07);
	 String refno = SO_Excellib.getExcelDat("SOR", 9, 8);
	 String total = SO_Excellib.getExcelDat("SOR", 9, 15);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
		payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");		
	SRCustRef SRCusf = PageFactory.initElements(driver, SRCustRef.class);
	SRCusf.CustRef(Referenc, refno);
	BigDecimal Actual =new BigDecimal(SRCustRef.amt);
	 Assert.assertEquals(Actual, expected,"Total calclulation is incorrect");
	 System.out.println("total Amount verified");
	}

@Test(priority = 9)
public void SR_Esugam_TC_9() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String ESugam = SO_Excellib.getExcelDat("SOR", 10, 9);
	 String total = SO_Excellib.getExcelDat("SOR", 10, 15);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
		payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");		
	SR_Esugam SRE = PageFactory.initElements(driver,SR_Esugam.class);
	SRE.ESugsm(ESugam);
	BigDecimal Actual =new BigDecimal(SR_Esugam.amt);
	 Assert.assertEquals(Actual, expected,"Total calclulation is incorrect");
	 System.out.println("total Amount verified");
}
 @Test(priority=10)
 public void SR_vehicle_TC_10() throws Exception
 {
	 WebDriverCommonlib.waitForPageToLoad(); 
	 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String transPotar =SO_Excellib.getExcelDat("Additional", 20, 04);
	 String vehicleNo=SO_Excellib.getExcelDat("Additional", 20, 05);	
	 String GCNo = SO_Excellib.getExcelDat("Additional", 20, 06);
	 String packingNo= SO_Excellib.getExcelDat("Additional", 20, 07);	 
	String NOOfPackage = SO_Excellib.getExcelDat("Additional", 20, 8);	
	String packingWeight = SO_Excellib.getExcelDat("Additional", 20, 9);
	 String total = SO_Excellib.getExcelDat("SOR", 11, 15);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
		payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");		
	 SR_vehicle SRV = PageFactory.initElements(driver, SR_vehicle.class);
	 SRV.VehicleDetail(transPotar,vehicleNo, GCNo, packingNo, NOOfPackage, packingWeight);	
	 BigDecimal Actual =new BigDecimal(SR_vehicle.amt);
	 Assert.assertEquals(Actual, expected,"Total calclulation is incorrect");
	 System.out.println("total Amount verified");
 }
 @Test(priority=11)
 public void SR_Cash_DisPer_TC_11() throws Exception
 {
	 WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String DIS = SO_Excellib.getExcelDat("SOR", 12, 10);
	 String total = SO_Excellib.getExcelDat("SOR", 12, 15);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
		payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");		
	SR_CashDisPer SRCDP = PageFactory.initElements(driver, SR_CashDisPer.class);
	SRCDP.SR_CashDis(DIS);
	BigDecimal Actual =new BigDecimal(SR_CashDisPer.amt);
	 Assert.assertEquals(Actual, expected,"Total calclulation is incorrect");
	 System.out.println("total Amount verified");
 }
@Test(priority=12)
public void SR_Cash_DisINR_TC_12() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String DISINR = SO_Excellib.getExcelDat("SOR", 13, 10);
	 String total = SO_Excellib.getExcelDat("SOR", 13, 15);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
		payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");		
	SR_CashINR  SRCDC = PageFactory.initElements(driver, SR_CashINR.class);
	SRCDC.SR_CashDisINR(DISINR);
	BigDecimal Actual =new BigDecimal(SR_CashINR.amt);
	 Assert.assertEquals(Actual, expected,"Total calclulation is incorrect");
	 System.out.println("total Amount verified");
}
@Test(priority=13)
public void SR_ShippingCharges_TC_13() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String ShipChage = SO_Excellib.getExcelDat("SOR", 14, 11);	 
	 String total = SO_Excellib.getExcelDat("SOR", 14, 15);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
		payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");		
	SR_ShippingCharge SRSC = PageFactory.initElements(driver,SR_ShippingCharge.class);
	SRSC.ShipChage(ShipChage);
	BigDecimal Actual =new BigDecimal(SR_ShippingCharge.amt);
	 Assert.assertEquals(Actual, expected,"Total calclulation is incorrect");
	 System.out.println("total Amount verified");
}
@Test(priority=14)
public void SR_roundOff_TC_14() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String Roundoff = SO_Excellib.getExcelDat("SOR", 15, 12);
	 String total = SO_Excellib.getExcelDat("SOR", 15, 15);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
		payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");		
	SR_Roundoff SRR = PageFactory.initElements(driver, SR_Roundoff.class);
	SRR.SRRoundOff(Roundoff);
	BigDecimal Actual =new BigDecimal(SR_Roundoff.amt);
	 Assert.assertEquals(Actual, expected,"Total calclulation is incorrect");
	 System.out.println("total Amount verified");
}
@Test(priority=15)
public void SR_ShippingCharges_tax_TC_15() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String shippingCharge = SO_Excellib.getExcelDat("SOR", 16, 11);
	 String shipTax = SO_Excellib.getExcelDat("SOR", 16, 13);
	 String total = SO_Excellib.getExcelDat("SOR", 16, 15);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
		payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");		
	SR_shippingTax SRST =PageFactory.initElements(driver, SR_shippingTax.class);
	SRST.SRShippingTax(shippingCharge,shipTax);
	BigDecimal Actual =new BigDecimal(SR_shippingTax.amt);
	 Assert.assertEquals(Actual, expected,"Total calclulation is incorrect");
	 System.out.println("total Amount verified");
	
}
}
