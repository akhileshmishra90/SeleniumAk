package com.Actouch.SalesINV.TestScript;
import java.io.IOException;
import java.math.BigDecimal;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.SO_Excellib;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
import com.Actouch.SalesINV.pageObjectRepository.Login;
import com.Actouch.SalesINV.pageObjectRepository.SOPaymentLater;
import com.Actouch.SalesINV.pageObjectRepository.ShpCashDisPer;
import com.Actouch.SalesINV.pageObjectRepository.ShpCashINR;
import com.Actouch.SalesINV.pageObjectRepository.ShpDlryChallan;
import com.Actouch.SalesINV.pageObjectRepository.ShpFull;
import com.Actouch.SalesINV.pageObjectRepository.ShpPartial;
import com.Actouch.SalesINV.pageObjectRepository.ShpPartialTax;
import com.Actouch.SalesINV.pageObjectRepository.ShpRoundOff;
import com.Actouch.SalesINV.pageObjectRepository.ShpShippingCharge;
import com.Actouch.SalesINV.pageObjectRepository.ShpTaxFull;
import com.Actouch.SalesINV.pageObjectRepository.ShpValidateSo;
import com.Actouch.SalesINV.pageObjectRepository.ShpVehicle;
import com.Actouch.SalesINV.pageObjectRepository.ShpshippingTax;
import com.Actouch.SalesINV.pageObjectRepository.ShpvaliadateCustomer;



public class Shipment {
	WebDriver driver;
	SO_Excellib SO_Excellib = new SO_Excellib("E:\\ServerCode\\SaleOrder.xlsx");
	@Test(priority = 1 )
	public void salesIN_Login_TC_1() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
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
	public void Shp_Vldt_Customer_TC_2() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{ 
		WebDriverCommonlib.waitForPageToLoad();
		String custID = SO_Excellib.getExcelDat("SO", 04, 8);
		 String prodID = SO_Excellib.getExcelDat("SO", 04, 10);
		 String Qnty = SO_Excellib.getExcelDat("SO", 04, 13);
		 String unitp = SO_Excellib.getExcelDat("SO", 04, 16);
		 String taxCode = SO_Excellib.getExcelDat("SO", 04, 19);
	driver.get(Constant.SalesOrder_new);
		SOPaymentLater payLtr = PageFactory.initElements(driver, SOPaymentLater.class);
		payLtr.payltr(custID, prodID, Qnty, unitp, taxCode,"late");
		 ShpvaliadateCustomer CustValid =PageFactory.initElements(driver, ShpvaliadateCustomer.class);
		CustValid.CustomerValidate();
	}

	@Test(priority=3)
	public void Shp_Vldt_So_TC_3() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		WebDriverCommonlib.waitForPageToLoad();
		 String custID = SO_Excellib.getExcelDat("SO", 04, 8);
		 String prodID = SO_Excellib.getExcelDat("SO", 04, 10);
		 String Qnty = SO_Excellib.getExcelDat("SO", 04, 13);
		 String unitp = SO_Excellib.getExcelDat("SO", 04, 16);
		 String taxCode = SO_Excellib.getExcelDat("SO", 04, 19);
		driver.get(Constant.SalesOrder_new);
			driver.navigate().refresh();
			SOPaymentLater payLtr = PageFactory.initElements(driver, SOPaymentLater.class);
		payLtr.payltr(custID, prodID, Qnty, unitp, taxCode,"late");
		ShpValidateSo soValid = PageFactory.initElements(driver, ShpValidateSo.class);
		soValid.SoValidate();
		
	}
@Test(priority = 4)
public void Shp_partial_TC_4() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 04, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 04, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 04, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 04, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 04, 19);
	 String partial = SO_Excellib.getExcelDat("Shipment", 07, 06);
	 String total = SO_Excellib.getExcelDat("Shipment", 07, 15);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();
		SOPaymentLater payLtr = PageFactory.initElements(driver, SOPaymentLater.class);
	payLtr.payltr(custID, prodID, Qnty, unitp, taxCode,"late");
	ShpPartial partialShp =PageFactory.initElements(driver, ShpPartial.class);
	partialShp.partialShipment(partial);
	BigDecimal Actual =new BigDecimal(ShpPartial.amt);
	 Assert.assertEquals(Actual, expected,"Total calclulation is incorrect");
	 System.out.println("total Amount verified");
	 
}
@Test(priority=5)
public void Shp_Full_TC_5() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 04, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 04, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 04, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 04, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 04, 19);
	 String total = SO_Excellib.getExcelDat("Shipment", 8, 15);
	 BigDecimal expected =new BigDecimal(total);
	 expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 	driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();
		SOPaymentLater payLtr = PageFactory.initElements(driver, SOPaymentLater.class);
	payLtr.payltr(custID, prodID, Qnty, unitp, taxCode,"late");
	ShpFull fullship =PageFactory.initElements(driver, ShpFull.class);
	fullship.fullShipment();
	BigDecimal Actual =new BigDecimal(ShpFull.amt);
	 Assert.assertEquals(Actual, expected,"Total calclulation is incorrect");
	 System.out.println("total Amount verified");
}

@Test(priority=6)
public void shp_partial_Tax_TC_6() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 04, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 04, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 04, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 04, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 04, 19);
	 String partial = SO_Excellib.getExcelDat("Shipment", 9, 06);
	 String newTaxCode = SO_Excellib.getExcelDat("Shipment", 9, 8);
	 String total = SO_Excellib.getExcelDat("Shipment", 9, 15);
	 BigDecimal expected =new BigDecimal(total);
	 expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 	driver.get(Constant.SalesOrder_new);
			driver.navigate().refresh();
		SOPaymentLater payLtr = PageFactory.initElements(driver, SOPaymentLater.class);
	payLtr.payltr(custID, prodID, Qnty, unitp, taxCode,"late");
		ShpPartialTax partialtax =PageFactory.initElements(driver, ShpPartialTax.class);
	partialtax.partialTax(partial,taxCode,newTaxCode);
	BigDecimal Actual =new BigDecimal(ShpPartialTax.amt);
	 Assert.assertEquals(Actual, expected,"Total calclulation is incorrect");
	 System.out.println("total Amount verified");
}

@Test(priority=7)
public void Shp_Full_Tax_TC_7() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 04, 8);
String prodID = SO_Excellib.getExcelDat("SO", 04, 10);
String Qnty = SO_Excellib.getExcelDat("SO", 04, 13);
String unitp = SO_Excellib.getExcelDat("SO", 04, 16);
String taxCode = SO_Excellib.getExcelDat("SO", 04, 19);
String newTaxCode = SO_Excellib.getExcelDat("Shipment", 10, 8);
String total = SO_Excellib.getExcelDat("Shipment", 10, 15);
BigDecimal expected =new BigDecimal(total);
expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();
	SOPaymentLater payLtr = PageFactory.initElements(driver, SOPaymentLater.class);
payLtr.payltr(custID, prodID, Qnty, unitp, taxCode,"late");
ShpTaxFull fullshiptax =PageFactory.initElements(driver, ShpTaxFull.class);
	fullshiptax.fullShipTax(taxCode,newTaxCode);
	BigDecimal Actual =new BigDecimal(ShpTaxFull.amt);
	 Assert.assertEquals(Actual, expected,"Total calclulation is incorrect");
	 System.out.println("total Amount verified");
}
@Test(priority=8)
public void shp_DiliveryChallan_TC_8() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 04, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 04, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 04, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 04, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 04, 19);
	 String DC = SO_Excellib.getExcelDat("Shipment", 11, 9);
	 String total = SO_Excellib.getExcelDat("Shipment", 11, 15);
	 BigDecimal expected =new BigDecimal(total);
	 expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);
				driver.navigate().refresh();
		SOPaymentLater payLtr = PageFactory.initElements(driver, SOPaymentLater.class);
	payLtr.payltr(custID, prodID, Qnty, unitp, taxCode,"late");
	ShpDlryChallan shipDC =PageFactory.initElements(driver, ShpDlryChallan.class);
	shipDC.DeliveryChallan(DC);
	BigDecimal Actual =new BigDecimal(ShpDlryChallan.amt);
	 Assert.assertEquals(Actual, expected,"Total calclulation is incorrect");
	 System.out.println("total Amount verified");
	
}
@Test(priority=9)
public void Shp_Vehicle_TC_9() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 04, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 04, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 04, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 04, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 04, 19);
	String transPotar =SO_Excellib.getExcelDat("Additional", 20, 04);
	 String vehicleNo=SO_Excellib.getExcelDat("Additional", 20, 05);	
	 String GCNo = SO_Excellib.getExcelDat("Additional", 20, 06);
	 String packingNo= SO_Excellib.getExcelDat("Additional", 20, 07);	 
	String NOOfPackage = SO_Excellib.getExcelDat("Additional", 20, 8);	
	String packingWeight = SO_Excellib.getExcelDat("Additional", 20, 9);
	 String DC = SO_Excellib.getExcelDat("Shipment", 12, 9);
	 String total = SO_Excellib.getExcelDat("Shipment", 12, 15);
	 BigDecimal expected =new BigDecimal(total);
	 expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 	driver.get(Constant.SalesOrder_new);
			driver.navigate().refresh();
		SOPaymentLater payLtr = PageFactory.initElements(driver, SOPaymentLater.class);
	payLtr.payltr(custID, prodID, Qnty, unitp, taxCode,"late");
	ShpVehicle shipvehicle =PageFactory.initElements(driver, ShpVehicle.class);
	shipvehicle.vehicle(DC, transPotar, vehicleNo,GCNo, packingNo, NOOfPackage,packingWeight);
	BigDecimal Actual =new BigDecimal(ShpVehicle.amt);
	 Assert.assertEquals(Actual, expected,"Total calclulation is incorrect");
	 System.out.println("total Amount verified");
}
@Test(priority=10)
public void Shp_Cash_DisPer_TC_10() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 04, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 04, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 04, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 04, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 04, 19);
	 String Dis = SO_Excellib.getExcelDat("Shipment", 13, 10);
	 String total = SO_Excellib.getExcelDat("Shipment", 13, 15);
	 BigDecimal expected =new BigDecimal(total);
	 expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
			driver.get(Constant.SalesOrder_new);
			driver.navigate().refresh();
		SOPaymentLater payLtr = PageFactory.initElements(driver, SOPaymentLater.class);
	payLtr.payltr(custID, prodID, Qnty, unitp, taxCode,"late");
	ShpCashDisPer shipDisPer =PageFactory.initElements(driver, ShpCashDisPer.class);
	shipDisPer.ShipDisPer(Dis);
	BigDecimal Actual =new BigDecimal(ShpCashDisPer.amt);
	 Assert.assertEquals(Actual, expected,"Total calclulation is incorrect");
	 System.out.println("total Amount verified");	
}
@Test(priority=11)
public void shp_cash_DisINR_TC_11() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 04, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 04, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 04, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 04, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 04, 19);
	 String Dis = SO_Excellib.getExcelDat("Shipment", 14, 10);
	 String total = SO_Excellib.getExcelDat("Shipment", 14, 15);
	 BigDecimal expected =new BigDecimal(total);
	 expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);
		driver.navigate().refresh();
			SOPaymentLater payLtr = PageFactory.initElements(driver, SOPaymentLater.class);
	payLtr.payltr(custID, prodID, Qnty, unitp, taxCode,"late");
	ShpCashINR shipDisInr =PageFactory.initElements(driver, ShpCashINR.class);
	shipDisInr.ShipDisINR(Dis);
	BigDecimal Actual =new BigDecimal(ShpCashINR.amt);
	 Assert.assertEquals(Actual, expected,"Total calclulation is incorrect");
	 System.out.println("total Amount verified");
}
@Test(priority=12)
public void Shp_ShippingCharges_TC_12() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 04, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 04, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 04, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 04, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 04, 19);
	 String shpCharge = SO_Excellib.getExcelDat("Shipment", 15, 11);
	 String total = SO_Excellib.getExcelDat("Shipment", 15, 15);
	 BigDecimal expected =new BigDecimal(total);
	 expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 		driver.get(Constant.SalesOrder_new);
			driver.navigate().refresh();
		SOPaymentLater payLtr = PageFactory.initElements(driver, SOPaymentLater.class);
	payLtr.payltr(custID, prodID, Qnty, unitp, taxCode,"late");
	ShpShippingCharge shipcharge =PageFactory.initElements(driver, ShpShippingCharge.class);
	shipcharge.ShipShippingCharges(shpCharge);
	BigDecimal Actual =new BigDecimal(ShpShippingCharge.amt);
	 Assert.assertEquals(Actual, expected,"Total calclulation is incorrect");
	 System.out.println("total Amount verified");
}
@Test(priority=13)
public void Shp_roundOff_TC_13() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 04, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 04, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 04, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 04, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 04, 19);
	 String roundOff = SO_Excellib.getExcelDat("Shipment", 16, 12);
	 String total = SO_Excellib.getExcelDat("Shipment", 16, 15);
	 BigDecimal expected =new BigDecimal(total);
	 expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
			driver.get(Constant.SalesOrder_new);
			driver.navigate().refresh();
		SOPaymentLater payLtr = PageFactory.initElements(driver, SOPaymentLater.class);
	payLtr.payltr(custID, prodID, Qnty, unitp, taxCode,"late");
	ShpRoundOff shipRound =PageFactory.initElements(driver, ShpRoundOff.class);
	shipRound.ShipRoundOff(roundOff);
	BigDecimal Actual =new BigDecimal(ShpRoundOff.amt);
	 Assert.assertEquals(Actual, expected,"Total calclulation is incorrect");
	 System.out.println("total Amount verified");
}
@Test(priority=14)
public void shp_ShippingCharges_tax_TC_14()throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 04, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 04, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 04, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 04, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 04, 19);
	 String shpCharge = SO_Excellib.getExcelDat("Shipment", 17, 11);
	 String shpTax = SO_Excellib.getExcelDat("Shipment", 17, 13);
	 String total = SO_Excellib.getExcelDat("Shipment", 17, 15);
	 BigDecimal expected =new BigDecimal(total);
	 expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 		driver.get(Constant.SalesOrder_new);
			driver.navigate().refresh();
		SOPaymentLater payLtr = PageFactory.initElements(driver, SOPaymentLater.class);
	payLtr.payltr(custID, prodID, Qnty, unitp, taxCode,"late");
	ShpshippingTax ship_Tax =PageFactory.initElements(driver, ShpshippingTax.class);
	ship_Tax.ShipTax(shpCharge,shpTax);
	BigDecimal Actual =new BigDecimal(ShpshippingTax.amt);
	 Assert.assertEquals(Actual, expected,"Total calclulation is incorrect");
	 System.out.println("total Amount verified");

}
/*@Test(priority =15)
public void Shp_Multiproduct() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 24, 8);
	
	 String issueQnty = SO_Excellib.getExcelDat("SO", 26, 14);
	 
	  String taxCode1= SO_Excellib.getExcelDat("SO", 24, 19);
	  String total =SO_Excellib.getExcelDat("SO", 24, 31);
	  
	  BigDecimal expected = new BigDecimal(total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);
		
		driver.navigate().refresh();
		
		SOMutiproduct SOMultiprod =PageFactory.initElements(driver,SOMutiproduct.class);
		SOMultiprod.multiproduct(custID, taxCode1, issueQnty);
	driver.get("http://178.162.192.70:8080/AcTouchWeb/resources/home.html#salesMain");
		ShpMultiProduct MultiProd = PageFactory.initElements(driver, ShpMultiProduct.class);
		MultiProd.fullShipment();
		
}*/
}
