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
import com.Actouch.SalesINV.pageObjectRepository.SOBatchCurrencyDis;
import com.Actouch.SalesINV.pageObjectRepository.SOBatchPercentDis;
import com.Actouch.SalesINV.pageObjectRepository.SOBatchableItem;
import com.Actouch.SalesINV.pageObjectRepository.SOBlankDETlevel;
import com.Actouch.SalesINV.pageObjectRepository.SOBlankPageSaving;
import com.Actouch.SalesINV.pageObjectRepository.SOCurrencyLineDiscount;
import com.Actouch.SalesINV.pageObjectRepository.SODiscountINR;
import com.Actouch.SalesINV.pageObjectRepository.SODiscountWithpercentage;
import com.Actouch.SalesINV.pageObjectRepository.SOExclusiveTaxCurrencyDis;
import com.Actouch.SalesINV.pageObjectRepository.SOExclusiveTaxPercentDis;
import com.Actouch.SalesINV.pageObjectRepository.SOInclusiveTaxPercentDis;
import com.Actouch.SalesINV.pageObjectRepository.SOMUOMBatchCurrencyDis;
import com.Actouch.SalesINV.pageObjectRepository.SOMUOMBatchPercentDis;
import com.Actouch.SalesINV.pageObjectRepository.SOMUOMBatchable;
import com.Actouch.SalesINV.pageObjectRepository.SOMUOMCurrencyDis;
import com.Actouch.SalesINV.pageObjectRepository.SOMUOMPercentDis;
import com.Actouch.SalesINV.pageObjectRepository.SOMUOMProduct;
import com.Actouch.SalesINV.pageObjectRepository.SOMUOMSProduct;
import com.Actouch.SalesINV.pageObjectRepository.SOMemoLentgh;
import com.Actouch.SalesINV.pageObjectRepository.SOMutiproduct;
import com.Actouch.SalesINV.pageObjectRepository.SOPaymentLater;
import com.Actouch.SalesINV.pageObjectRepository.SOPaymentLaterShipnow;
import com.Actouch.SalesINV.pageObjectRepository.SOPaymentNowCashOnHand;
import com.Actouch.SalesINV.pageObjectRepository.SOPaymentNowMultiCheque;
import com.Actouch.SalesINV.pageObjectRepository.SOPaymentNowPettyCash;
import com.Actouch.SalesINV.pageObjectRepository.SOPaymentNowSingleCheque;
import com.Actouch.SalesINV.pageObjectRepository.SOPercentDiscount;
import com.Actouch.SalesINV.pageObjectRepository.SOProductInclusiveTax;
import com.Actouch.SalesINV.pageObjectRepository.SOProductMultipleTax;
import com.Actouch.SalesINV.pageObjectRepository.SOProductTaxDiscount;
import com.Actouch.SalesINV.pageObjectRepository.SOReceiveAdvCashOnHand;
import com.Actouch.SalesINV.pageObjectRepository.SOReceiveAdvCheque;
import com.Actouch.SalesINV.pageObjectRepository.SOReceiveAdvChequeShp;
import com.Actouch.SalesINV.pageObjectRepository.SOReceiveAdvPettyCash;
import com.Actouch.SalesINV.pageObjectRepository.SOReceiveAdvPettyShp;
import com.Actouch.SalesINV.pageObjectRepository.SOShipmentByAir;
import com.Actouch.SalesINV.pageObjectRepository.SOShipmentByCargo;
import com.Actouch.SalesINV.pageObjectRepository.SOShipmentByCourier;
import com.Actouch.SalesINV.pageObjectRepository.SOShipmentByHand;
import com.Actouch.SalesINV.pageObjectRepository.SOShipmentByRail;
import com.Actouch.SalesINV.pageObjectRepository.SOShipmentByRoad;
import com.Actouch.SalesINV.pageObjectRepository.SOShipmentByTruck;
import com.Actouch.SalesINV.pageObjectRepository.SOShipmentLength;
import com.Actouch.SalesINV.pageObjectRepository.SOTCLenth;
import com.Actouch.SalesINV.pageObjectRepository.SOTDSWithOtherTax;
import com.Actouch.SalesINV.pageObjectRepository.SOTaxExclusive;
import com.Actouch.SalesINV.pageObjectRepository.SOWithCreditTerm;
import com.Actouch.SalesINV.pageObjectRepository.SOWithSaleTax;
import com.Actouch.SalesINV.pageObjectRepository.SOWithoutDiscount;
import com.Actouch.SalesINV.pageObjectRepository.SOWithoutTax;
import com.Actouch.SalesINV.pageObjectRepository.SOwithTradeDis;
import com.Actouch.SalesINV.pageObjectRepository.SoInclusiveTaxCurrencyDis;

public class SaleOrder {
	static WebDriver driver; 
	SO_Excellib SO_Excellib = new SO_Excellib("E:\\ServerCode\\SaleOrder.xlsx");
	@Test(priority=1)
	public void salesIN_Login_TC_1() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException 
	{
				driver = Browser.getbrowser();
				driver.manage().window().maximize();
		String usrid = SO_Excellib.getExcelDat("SO", 03, 03);
		String pss = SO_Excellib.getExcelDat("SO", 03, 04);
			Browser.driver.get(Constant.Url);
		Login loginpage = PageFactory.initElements(driver, Login.class);
		loginpage.login(usrid, pss);
		Thread.sleep(3000);
	}
	@Test(priority = 2)
	public void salesIN_payltr_TC_2() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
	 WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 04, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 04, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 04, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 04, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 04, 19);
	 String total =SO_Excellib.getExcelDat("SO", 04, 31);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
	  driver.navigate().to(Constant.SalesOrder_new);	
		SOPaymentLater payLtr = PageFactory.initElements(driver, SOPaymentLater.class);
	payLtr.payltr(custID, prodID, Qnty, unitp, taxCode,"later");
	BigDecimal Actual = new BigDecimal(SOPaymentLater.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority = 3)
public void salesIN_payltr_shpNow_TC_3() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	 WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 05, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 05, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 05, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 05, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 05, 19);
	 String total =SO_Excellib.getExcelDat("SO", 05, 31);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOPaymentLaterShipnow payLtrShp = PageFactory.initElements(driver, SOPaymentLaterShipnow.class);
	payLtrShp.PayLtrShp(custID, prodID, Qnty, unitp,taxCode,"late");
	BigDecimal Actual = new BigDecimal(SOPaymentLaterShipnow.amt);
	//String exp1 = SOPaymentLaterShipnow.exp;
  Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");	
}
@Test(priority = 4)
public void salesIN_payNowByChq_singlechq_TC_4() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 06, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 06, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 06, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 06, 16);
	String total =SO_Excellib.getExcelDat("SO", 06, 31);
	String cheqNo=SO_Excellib.getExcelDat("Additional", 11, 06);
	String bank =SO_Excellib.getExcelDat("Additional", 11, 07);	
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesOrder_new);	
		driver.navigate().refresh();	
	SOPaymentNowSingleCheque payNowcheque = PageFactory.initElements(driver, SOPaymentNowSingleCheque.class);
	payNowcheque.payNowCheque(custID, prodID, Qnty, unitp, "now", "HDFC",cheqNo , bank);	
	BigDecimal Actual = new BigDecimal(SOPaymentNowSingleCheque.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority = 5)
public void salesIN_payNowByChq_Multichq_TC_5() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 07, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 07, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 07, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 07, 16);
	 String cheqNo=SO_Excellib.getExcelDat("Additional", 12, 06);
		String bank =SO_Excellib.getExcelDat("Additional", 12, 07);
		String cheqNo2 = SO_Excellib.getExcelDat("Additional", 13, 06);
		String bank2 =SO_Excellib.getExcelDat("Additional", 13, 07);
		String total =SO_Excellib.getExcelDat("SO", 07, 31);
		BigDecimal expected = new BigDecimal(total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);		
	driver.get(Constant.SalesOrder_new);	
		driver.navigate().refresh();	
	SOPaymentNowMultiCheque payNowcheque = PageFactory.initElements(driver, SOPaymentNowMultiCheque.class);
	payNowcheque.payNowMultCheque(custID, prodID, Qnty, unitp, "now", "HDFC", cheqNo, bank,cheqNo2,bank2);	
	BigDecimal Actual = new BigDecimal(SOPaymentNowMultiCheque.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");	
}
@Test(priority = 6)
public void salesIN_payNowByPtty_TC_6() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 8, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 8, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 8, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 8, 16);
	 String total =SO_Excellib.getExcelDat("SO", 8, 31);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
	driver.get(Constant.SalesOrder_new);	
		driver.navigate().refresh();		
	SOPaymentNowPettyCash payNowPetty = PageFactory.initElements(driver, SOPaymentNowPettyCash.class);
	payNowPetty.payNowPetty(custID, prodID, Qnty, unitp, "now", "petty cash");	
	BigDecimal Actual = new BigDecimal(SOPaymentNowPettyCash.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority = 7)
public void salesIN_payNowByCashOn_TC_7() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 9, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 9, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 9, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 9, 16);
	 String total =SO_Excellib.getExcelDat("SO", 9, 31);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
	driver.get(Constant.SalesOrder_new);	
	driver.navigate().refresh();	
	SOPaymentNowCashOnHand payNowPetty = PageFactory.initElements(driver, SOPaymentNowCashOnHand.class);
	payNowPetty.payNowcashOnHand(custID, prodID, Qnty, unitp, "now", "cash on");	
	BigDecimal Actual = new BigDecimal(SOPaymentNowCashOnHand.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
	@Test(priority = 8)
	public void saleIN_Receive_AdvbyPtty_shp_TC_11() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 13, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 13, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 13, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 13, 16);
	 String Adv = SO_Excellib.getExcelDat("SO", 13, 22);
	 String taxCode = SO_Excellib.getExcelDat("SO", 13, 19);
	 String total =SO_Excellib.getExcelDat("SO", 13, 31);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	 
	driver.get(Constant.SalesOrder_new);	
	driver.navigate().refresh();	
	SOReceiveAdvPettyShp RcvAdvPttyshp = PageFactory.initElements(driver, SOReceiveAdvPettyShp.class);
	RcvAdvPttyshp.RcvAdvPttyshp(custID, prodID, Qnty,unitp,taxCode,Adv);	
	BigDecimal Actual = new BigDecimal(SOReceiveAdvPettyShp.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
	}
  @Test(priority = 9) 
public void saleIN_Receive_AdvbyPtty_TC_12() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	  WebDriverCommonlib.waitForPageToLoad();
String custID = SO_Excellib.getExcelDat("SO", 14, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 14, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 14, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 14, 16);
	 String Adv = SO_Excellib.getExcelDat("SO", 14, 22);
	 String taxCode = SO_Excellib.getExcelDat("SO", 14, 19);
	 String total =SO_Excellib.getExcelDat("SO", 14, 31);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	 
driver.get(Constant.SalesOrder_new);
driver.navigate().refresh();
SOReceiveAdvPettyCash RcvAdvPtty = PageFactory.initElements(driver, SOReceiveAdvPettyCash.class);
RcvAdvPtty.RcvAdvPtty(custID, prodID,Qnty,unitp,taxCode,Adv);
BigDecimal Actual = new BigDecimal(SOReceiveAdvPettyCash.amt);
Assert.assertEquals(Actual,expected,"total amount not correct");
 System.out.println("total Amount verified");
}
	@Test(priority =10)
	public void saleIN_Receive_Advbycheque_Shp_TC_13() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
		String custID = SO_Excellib.getExcelDat("SO", 15, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 15, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 15, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 15, 16);
	 String Adv = SO_Excellib.getExcelDat("SO", 15, 22);
	 String taxCode = SO_Excellib.getExcelDat("SO", 15, 19);
	 String total =SO_Excellib.getExcelDat("SO", 15, 31);
	 String cheqNo=SO_Excellib.getExcelDat("Additional", 11, 06);
		String bank =SO_Excellib.getExcelDat("Additional", 11, 07);
		 BigDecimal expected = new BigDecimal(total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	 
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOReceiveAdvChequeShp RcvAdvCheque = PageFactory.initElements(driver, SOReceiveAdvChequeShp.class);
		RcvAdvCheque.RcvAdvchequeshp(custID, prodID, Qnty, unitp, taxCode,Adv, cheqNo, bank);
		BigDecimal Actual = new BigDecimal(SOReceiveAdvChequeShp.amt);
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}	
@Test(priority=11)
public void saleIN_Receive_Advbycheque_TC_14() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 16, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 16, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 16, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 16, 16);
	 String Adv = SO_Excellib.getExcelDat("SO", 16, 22);
	 String taxCode = SO_Excellib.getExcelDat("SO", 16, 19);
	 String cheqNo=SO_Excellib.getExcelDat("Additional", 11, 06);
		String bank =SO_Excellib.getExcelDat("Additional", 11, 07);
		String total =SO_Excellib.getExcelDat("SO", 16, 31);
		 BigDecimal expected = new BigDecimal(total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesOrder_new);	
	driver.navigate().refresh();	
	SOReceiveAdvCheque RcvAdvCheque = PageFactory.initElements(driver, SOReceiveAdvCheque.class);
	RcvAdvCheque.RcvAdvcheque(custID, prodID, Qnty, unitp, taxCode,Adv,cheqNo, bank);
	BigDecimal Actual = new BigDecimal(SOReceiveAdvCheque.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=12)
public void saleIN_Receive_AdvbycashOn_TC_15() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 17, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 17, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 17, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 17, 16);
	 String Adv = SO_Excellib.getExcelDat("SO", 17, 22);
	 String taxCode = SO_Excellib.getExcelDat("SO", 17, 19);
	 String total =SO_Excellib.getExcelDat("SO", 17, 31);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	 
	driver.get(Constant.SalesOrder_new);	
	driver.navigate().refresh();	
	SOReceiveAdvCashOnHand RcvAdvCashshp = PageFactory.initElements(driver, SOReceiveAdvCashOnHand.class);
	RcvAdvCashshp.RcvAdvcashshp(custID, prodID, Qnty, unitp, taxCode,Adv);
	BigDecimal Actual = new BigDecimal(SOReceiveAdvCashOnHand.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}

	@Test(priority =13)
	public void SaleIN_Multitax_TC_16() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
		String custID = SO_Excellib.getExcelDat("SO", 18, 8);
		 String prodID = SO_Excellib.getExcelDat("SO", 18, 10);
		 String Qnty = SO_Excellib.getExcelDat("SO", 18, 13);
		 String unitp = SO_Excellib.getExcelDat("SO", 18, 16);
		 String taxCode1= SO_Excellib.getExcelDat("SO", 18, 19);
		 String taxCode2 = SO_Excellib.getExcelDat("SO", 18, 20);
		 String total =SO_Excellib.getExcelDat("SO", 18, 31);
		 BigDecimal expected = new BigDecimal(total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);		
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOProductMultipleTax prodMultTax = PageFactory.initElements(driver, SOProductMultipleTax.class);
	prodMultTax.ProdMultTax(custID, prodID, Qnty, unitp,taxCode1,taxCode2, "late");
	
	BigDecimal Actual = new BigDecimal(SOProductMultipleTax.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");	
	}
	@Test(priority =14)
	public void SaleIN_Tax_Discount_TC_17() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();

		String custID = SO_Excellib.getExcelDat("SO", 19, 8);
		 String prodID = SO_Excellib.getExcelDat("SO", 19, 10);
		 String Qnty = SO_Excellib.getExcelDat("SO", 19, 13);
		 String unitp = SO_Excellib.getExcelDat("SO", 19, 16);
		 String DIS = SO_Excellib.getExcelDat("SO", 19, 17);
		 String taxCode1= SO_Excellib.getExcelDat("SO", 19, 19);
		 String taxCode2 = SO_Excellib.getExcelDat("SO", 19, 20);
		 String total =SO_Excellib.getExcelDat("SO", 19, 31);
		 BigDecimal expected = new BigDecimal(total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		 driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOProductTaxDiscount prodTaxDis = PageFactory.initElements(driver, SOProductTaxDiscount.class);
	prodTaxDis.ProdTaxDis(custID, prodID, Qnty,unitp ,DIS,taxCode1,taxCode2, "late");
	BigDecimal Actual = new BigDecimal(SOProductTaxDiscount.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=15)
public void SaleIN_withoutTax_TC_18() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 20, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 20, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 20, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 20, 16);
	 String DIS = SO_Excellib.getExcelDat("SO", 20, 17);
	 String total =SO_Excellib.getExcelDat("SO", 20, 31);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
	driver.get(Constant.SalesOrder_new);	
	driver.navigate().refresh();	
	SOWithoutTax withoutTax = PageFactory.initElements(driver, SOWithoutTax.class);
withoutTax.ProdwithoutTax(custID, prodID, Qnty,unitp ,DIS);
BigDecimal Actual = new BigDecimal(SOWithoutTax.amt);
Assert.assertEquals(Actual,expected,"total amount not correct");
 System.out.println("total Amount verified");
}
@Test(priority=16)
public void SaleIN_WithoutDiscount_TC_19() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 21, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 21, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 21, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 21, 16);
String total =SO_Excellib.getExcelDat("SO", 21, 31);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesOrder_new);	
	driver.navigate().refresh();	
	SOWithoutDiscount withoutDis = PageFactory.initElements(driver, SOWithoutDiscount.class);
withoutDis.withoutDiscount(custID, prodID, Qnty,unitp );
BigDecimal Actual = new BigDecimal(SOWithoutDiscount.amt);
Assert.assertEquals(Actual,expected,"total amount not correct");
 System.out.println("total Amount verified");
}

@Test(priority=17)
public void SaleIN_InclusiveTax_TC_20() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 22, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 22, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 22, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 22, 16);
	 String taxCode1= SO_Excellib.getExcelDat("SO", 22, 19);
	 String Dis = SO_Excellib.getExcelDat("SO", 22, 17);
	 String total =SO_Excellib.getExcelDat("SO", 22, 31);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesOrder_new);	
	driver.navigate().refresh();	
	SOProductInclusiveTax prodInCLu = PageFactory.initElements(driver, SOProductInclusiveTax.class);
prodInCLu.ProdTaxIncl(custID, prodID, Qnty,unitp,taxCode1,Dis );
BigDecimal Actual = new BigDecimal(SOProductInclusiveTax.amt);
Assert.assertEquals(Actual,expected,"total amount not correct");
 System.out.println("total Amount verified");
}

@Test(priority=18)
public void SaleIN_Exclusive_Tax_TC_21() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException 

{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 23, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 23, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 23, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 23, 16);
	  String taxCode1= SO_Excellib.getExcelDat("SO", 23, 19);
	  String Dis = SO_Excellib.getExcelDat("SO", 23, 17);
	  String total =SO_Excellib.getExcelDat("SO", 23, 31);
	  BigDecimal expected = new BigDecimal(total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
	driver.get(Constant.SalesOrder_new);	
	driver.navigate().refresh();	
	SOTaxExclusive prodExCLu = PageFactory.initElements(driver, SOTaxExclusive.class);
prodExCLu.ProdTaxExcl( custID, prodID, Qnty,unitp, Dis,taxCode1);
BigDecimal Actual = new BigDecimal(SOTaxExclusive.amt);
Assert.assertEquals(Actual,expected,"total amount not correct");
 System.out.println("total Amount verified");
}
@Test(priority=19)
public void SaleIN_MultiProduct_TC_22() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
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
		BigDecimal Actual = new BigDecimal(SOMutiproduct.amt);
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");		
}

	@Test(priority =20)
	public void SaleIN_CreditTerm_TC_24() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
		String custID = SO_Excellib.getExcelDat("SO", 30, 8);
		String CreditTerm = SO_Excellib.getExcelDat("SO", 30, 9);
	 String prodID = SO_Excellib.getExcelDat("SO", 30, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 30, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 30, 16);
	 String taxCode  = SO_Excellib.getExcelDat("SO", 30, 19);
	 String total =SO_Excellib.getExcelDat("SO", 30, 31);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOWithCreditTerm SoWCrdTerm =PageFactory.initElements(driver, SOWithCreditTerm.class);
		SoWCrdTerm.SoWithCrdTerm(custID, CreditTerm, prodID, Qnty, unitp,taxCode);
		BigDecimal Actual = new BigDecimal(SOWithCreditTerm.amt);
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}
	
@Test(priority =21)
public void SaleIN_ShpByAir_TC_25() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
String custID = SO_Excellib.getExcelDat("SO",31, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 31, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 31, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 31, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 31, 19);
	 String total =SO_Excellib.getExcelDat("SO", 31, 31);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOShipmentByAir ShpByAir = PageFactory.initElements(driver,SOShipmentByAir.class);
         ShpByAir.ShpByAir(custID, prodID, Qnty,unitp,taxCode);
         BigDecimal Actual = new BigDecimal(SOShipmentByAir.amt);
 		Assert.assertEquals(Actual,expected,"total amount not correct");
 		 System.out.println("total Amount verified");
}

@Test(priority =22)
public void SaleIN_ShpByCargo_TC_26() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 32, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 32, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 32, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 32, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 32, 19);
	 String total =SO_Excellib.getExcelDat("SO", 32, 31);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	 
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOShipmentByCargo ShpByCrg = PageFactory.initElements(driver,SOShipmentByCargo.class);
         ShpByCrg.ShpByCargo(custID, prodID, Qnty,unitp,taxCode);
         BigDecimal Actual = new BigDecimal(SOShipmentByCargo.amt);
  		Assert.assertEquals(Actual,expected,"total amount not correct");
  		 System.out.println("total Amount verified");
}

@Test(priority =23)
public void SaleIN_ShpByCourier_TC_28() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 33, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 33, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 33, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 33, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 33, 19);
	 String total =SO_Excellib.getExcelDat("SO", 33, 31);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	 
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOShipmentByCourier ShpByCour = PageFactory.initElements(driver,SOShipmentByCourier.class);
         ShpByCour.ShpByCourier(custID, prodID, Qnty,unitp,taxCode);
         BigDecimal Actual = new BigDecimal(SOShipmentByCourier.amt);
   		Assert.assertEquals(Actual,expected,"total amount not correct");
   		 System.out.println("total Amount verified");
}
@Test(priority =24)
public void SaleIN_ShpByHand_TC_29() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 34, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 34, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 34, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 34, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 34, 19);
	 String total =SO_Excellib.getExcelDat("SO", 34, 31);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOShipmentByHand ShpByHand = PageFactory.initElements(driver,SOShipmentByHand.class);
  ShpByHand.ShpByHand(custID, prodID, Qnty,unitp,taxCode);
  BigDecimal Actual = new BigDecimal(SOShipmentByHand.amt);
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
  
}
@Test(priority =25)
public void SaleIN_ShpByRail_TC_27() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 35, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 35, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 35, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 35, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 35, 19);
	 String total =SO_Excellib.getExcelDat("SO", 35, 31);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	 
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOShipmentByRail ShpByRail = PageFactory.initElements(driver,SOShipmentByRail.class);
  ShpByRail.ShpByRail(custID, prodID, Qnty,unitp,taxCode);
  BigDecimal Actual = new BigDecimal(SOShipmentByRail.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=26)
public void SaleIN_ShpByRoad_TC_30() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 36, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 36, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 36, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 36, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 36, 19);
	 String total =SO_Excellib.getExcelDat("SO", 36, 31);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOShipmentByRoad ShpByRoad = PageFactory.initElements(driver,SOShipmentByRoad.class);
  ShpByRoad.ShpByRoad(custID, prodID, Qnty,unitp,taxCode);
  BigDecimal Actual = new BigDecimal(SOShipmentByRoad.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=27)
public void SaleIN_ShpByTruck_TC_31() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 37, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 37, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 37, 13);
	 String unitp = SO_Excellib.getExcelDat("SO",37, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 37, 19);
	 String total =SO_Excellib.getExcelDat("SO", 37, 31);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOShipmentByTruck ShpBytruck = PageFactory.initElements(driver,SOShipmentByTruck.class);
  ShpBytruck.ShpByTruck(custID, prodID, Qnty,unitp,taxCode);
  BigDecimal Actual = new BigDecimal(SOShipmentByTruck.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}

@Test(priority = 28)
public void SaleIN_CashDiscount_Percentage_TC_32() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 38, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 38, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 38, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 38, 16);
	 String DIS = SO_Excellib.getExcelDat("SO", 38, 23);
	 String taxCode = SO_Excellib.getExcelDat("SO", 38, 19);
	 String total =SO_Excellib.getExcelDat("SO", 38, 31);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesOrder_new);	
	driver.navigate().refresh();	
	SODiscountWithpercentage SoDis = PageFactory.initElements(driver, SODiscountWithpercentage.class);
	SoDis.SoWithDis(custID,  prodID, Qnty,unitp, taxCode,DIS);
	BigDecimal Actual = new BigDecimal(SODiscountWithpercentage.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}

@Test(priority=29)
public void SaleIN_CashDiscount_INR_TC_33() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 39, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 39, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 39, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 39, 16);
	 String DIS = SO_Excellib.getExcelDat("SO", 39, 23);
	 String taxCode = SO_Excellib.getExcelDat("SO", 39, 19);
	 String total =SO_Excellib.getExcelDat("SO", 39, 31);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesOrder_new);	
	driver.navigate().refresh();	
	SODiscountINR SoDis = PageFactory.initElements(driver, SODiscountINR.class);
	SoDis.SoWithDisINR(custID,  prodID, Qnty,unitp, taxCode,DIS);
	BigDecimal Actual = new BigDecimal(SODiscountINR.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}

@Test(priority=30)
public void SaleIN_TradeDiscount_TC_34() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 40, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 40, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 40, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 40, 16);
	 String DIS = SO_Excellib.getExcelDat("SO", 40, 23);	 
	 String taxCode = SO_Excellib.getExcelDat("SO", 40, 19);
	 String total =SO_Excellib.getExcelDat("SO", 40, 31);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesOrder_new);	
	driver.navigate().refresh();	
	SOwithTradeDis SoDis = PageFactory.initElements(driver, SOwithTradeDis.class);
	SoDis.SoWithTrade(custID,  prodID, Qnty,unitp, taxCode,DIS);
	BigDecimal Actual = new BigDecimal(SOwithTradeDis.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=31)
public void SaleIN_SalesTax_TC_35() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 41, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 41, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 41, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 41, 16);
	 String DIS = SO_Excellib.getExcelDat("SO", 41, 23);	 
	 String taxCode = SO_Excellib.getExcelDat("SO", 41, 19);
	String CST = SO_Excellib.getExcelDat("SO", 41, 26);    
	 String total =SO_Excellib.getExcelDat("SO", 41, 31);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesOrder_new);
	
	driver.navigate().refresh();
	
	SOWithSaleTax SoDis = PageFactory.initElements(driver, SOWithSaleTax.class);
	SoDis.SoWithSalesTax(custID,  prodID, Qnty,unitp, taxCode,DIS,CST);
	BigDecimal Actual = new BigDecimal(SOWithSaleTax.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority =32)
public void SaleIN_TDSWith_OtherTax_TC_36() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 42, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 42, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 42, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 42, 16);
	 String taxCode1= SO_Excellib.getExcelDat("SO", 42, 19);
	 String taxCode2 = SO_Excellib.getExcelDat("SO", 42, 20);
	driver.get(Constant.SalesOrder_new);	
	driver.navigate().refresh();	
	SOTDSWithOtherTax prodMultTax = PageFactory.initElements(driver, SOTDSWithOtherTax.class);
prodMultTax.TDSProdMultTax(custID, prodID, Qnty, unitp,taxCode1,taxCode2, "late");
}
@Test(priority = 33)
public void SaleIN_MUOM_TC_37() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 43, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 43, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 43, 13);
	 String SUOM = SO_Excellib.getExcelDat("SO", 43, 14);
	 String unitp = SO_Excellib.getExcelDat("SO", 43, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 43, 19);
	 String total =SO_Excellib.getExcelDat("SO", 43, 31);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	 
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOMUOMProduct muomprod =PageFactory.initElements(driver, SOMUOMProduct.class);
		muomprod.muomprod(custID,  prodID, Qnty,unitp,SUOM,taxCode);
		BigDecimal Actual = new BigDecimal(SOMUOMProduct.amt);
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
}
@Test(priority=34)
public void SaleIN_BatchableItem_TC_38() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 44, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 44, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 44, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 44, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 44, 19);
	 String batch =SO_Excellib.getExcelDat("SO", 44, 15);
	 String total =SO_Excellib.getExcelDat("SO", 44, 31);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	 
	 driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOBatchableItem Batch = PageFactory.initElements(driver, SOBatchableItem.class);
		Batch.batchableprod(custID, prodID, Qnty, unitp, taxCode,batch);
		BigDecimal Actual = new BigDecimal(SOBatchableItem.amt);
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
}


@Test(priority=35)
public void SaleIN_MUOM_Batchableitem_TC_39() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 45, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 45, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 45, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 45, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 45, 19);
	 String batch =SO_Excellib.getExcelDat("SO", 45, 15);
	 String issu = SO_Excellib.getExcelDat("SO", 45, 14);
	 String total =SO_Excellib.getExcelDat("SO", 45, 31);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	 
	 driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOMUOMBatchable Batch = PageFactory.initElements(driver, SOMUOMBatchable.class);
		Batch.MUOMbatchableprod(custID, prodID, Qnty, unitp, taxCode,batch,issu);
		BigDecimal Actual = new BigDecimal(SOMUOMBatchable.amt);
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
}

@Test(priority=36)
public void SaleIN_MUOMS_TC_40() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 46, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 46, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 46, 13);
	 String SUOM = SO_Excellib.getExcelDat("SO", 46, 14);
	 String unitp = SO_Excellib.getExcelDat("SO", 46, 16);
	 String taxCode = SO_Excellib.getExcelDat("SO", 46, 19);
	 String total =SO_Excellib.getExcelDat("SO", 46, 31);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	 
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOMUOMSProduct muomprod =PageFactory.initElements(driver, SOMUOMSProduct.class);
		muomprod.muomsprod(custID,  prodID, Qnty,"1",unitp,SUOM,taxCode);
		BigDecimal Actual = new BigDecimal(SOMUOMSProduct.amt);
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
}


@Test(priority=37)
public void SaleIN_BlankSo_TC_41() throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	driver.get(Constant.SalesOrder_new);	
	driver.navigate().refresh();	
	SOBlankPageSaving BlPgS = PageFactory.initElements(driver, SOBlankPageSaving.class);
	BlPgS.Blank_PageSaving();
	
}

@Test(priority=38)
public void SaleIN_BlankDETlevel_TC_42() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 48, 8);
	driver.get(Constant.SalesOrder_new);	
	driver.navigate().refresh();	
	SOBlankDETlevel BlPgS = PageFactory.initElements(driver, SOBlankDETlevel.class);
	BlPgS.BlankDETSaving(custID);	
}

@Test(priority=39)
public void shipmentLength_TC43() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = SO_Excellib.getExcelDat("SO", 49, 8);
	driver.get(Constant.SalesOrder_new);	
	driver.navigate().refresh();	
	SOShipmentLength shpLngth =PageFactory.initElements(driver, SOShipmentLength.class);
	shpLngth.ShipLength(custID, "ghjhkhknjhgjjhbjhbngvhjmghjhbjhh");
}

@Test(priority=40)
public void SaleIN_Memo_Length_TC_44() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 50, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 50, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 50, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 50, 16);	
		driver.get(Constant.SalesOrder_new);				
		SOMemoLentgh MEMOlentgh = PageFactory.initElements(driver, SOMemoLentgh.class);
		MEMOlentgh.memoLentgh(custID, prodID, Qnty, unitp, "ghdsncvxmzv,mxnzvn");
	
}

@Test(priority=41)
public void SaleIN_TC_Length_TC_45() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = SO_Excellib.getExcelDat("SO", 50, 8);
	 String prodID = SO_Excellib.getExcelDat("SO", 50, 10);
	 String Qnty = SO_Excellib.getExcelDat("SO", 50, 13);
	 String unitp = SO_Excellib.getExcelDat("SO", 50, 16);
		driver.get(Constant.SalesOrder_new);
		SOTCLenth TClentgh = PageFactory.initElements(driver, SOTCLenth.class);
		TClentgh.tcLentgh(custID, prodID, Qnty, unitp, "ghdsncvxmzv,mxnzvn");
		
}

@Test(dataProvider="CurrencyLineDiscount",priority=42)
public void SaleIN_CurrencyLineDiscount_TC_47(String CustId,String ProdId,String Quantity,String unitPrice,String Discount,String total) throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOCurrencyLineDiscount ShpBytruck = PageFactory.initElements(driver,SOCurrencyLineDiscount.class);
  ShpBytruck.ProdTaxDis(CustId, ProdId, Quantity, unitPrice, Discount);
  BigDecimal Actual = new BigDecimal(SOCurrencyLineDiscount.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
	
}
@Test(dataProvider="PercentLineDiscount",priority=43)
public void SaleIN_PercentLineDiscount_TC_48(String CustId,String  ProdId,String  Quantity,String  unitPrice,String Discount,String total) throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOPercentDiscount ShpBytruck = PageFactory.initElements(driver,SOPercentDiscount.class);
 ShpBytruck.ProdTaxDis(CustId, ProdId, Quantity, unitPrice, Discount);
 BigDecimal Actual = new BigDecimal(SOPercentDiscount.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(dataProvider="InclusiveTaxCurrencyDis",priority=44)
public void SaleIN_InclusiveTaxCurrencyDis_TC_49(String CustId,String  ProdId,String  Quantity,String  unitPrice,String Discount,String TaxCode1,String total) throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SoInclusiveTaxCurrencyDis ShpBytruck = PageFactory.initElements(driver,SoInclusiveTaxCurrencyDis.class);
ShpBytruck.ProdTaxDis(CustId, ProdId, Quantity, unitPrice, Discount,TaxCode1);
BigDecimal Actual = new BigDecimal(SoInclusiveTaxCurrencyDis.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(dataProvider="InclusiveTaxPercentDis",priority=45)
public void SaleIN_InclusiveTaxPercentDis_TC_50(String CustId,String  ProdId,String  Quantity,String  unitPrice,String Discount,String TaxCode1,String total) throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOInclusiveTaxPercentDis ShpBytruck = PageFactory.initElements(driver,SOInclusiveTaxPercentDis.class);
ShpBytruck.ProdTaxDis(CustId, ProdId, Quantity, unitPrice, Discount,TaxCode1);
BigDecimal Actual = new BigDecimal(SOInclusiveTaxPercentDis.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(dataProvider="ExclusiveTaxCurrencyDis",priority=46)
public void SaleIN_ExclusiveTaxCurrencyDis_TC_51(String CustId,String  ProdId,String  Quantity,String  unitPrice,String Discount,String TaxCode1,String total) throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOExclusiveTaxCurrencyDis ShpBytruck = PageFactory.initElements(driver,SOExclusiveTaxCurrencyDis.class);
       ShpBytruck.ProdTaxDis(CustId, ProdId, Quantity, unitPrice, Discount,TaxCode1);
     BigDecimal Actual = new BigDecimal(SOExclusiveTaxCurrencyDis.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(dataProvider="ExclusiveTaxPercentDis",priority=47)
public void SaleIN_ExclusiveTaxPercentDis_TC_52(String CustId,String  ProdId,String  Quantity,String  unitPrice,String Discount,String TaxCode1,String total) throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOExclusiveTaxPercentDis ShpBytruck = PageFactory.initElements(driver,SOExclusiveTaxPercentDis.class);
       ShpBytruck.ProdTaxDis(CustId, ProdId, Quantity, unitPrice, Discount,TaxCode1);
     BigDecimal Actual = new BigDecimal(SOExclusiveTaxPercentDis.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(dataProvider="MUOMCurrencyDis",priority=48)
public void SaleIN_MUOMCurrencyDis_TC_53(String CustId,String  ProdId,String  Quantity,String SecUOM,String  unitPrice,String Discount,String TaxCode1,String total) throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOMUOMCurrencyDis ShpBytruck = PageFactory.initElements(driver,SOMUOMCurrencyDis.class);
       ShpBytruck.ProdTaxDis(CustId, ProdId, Quantity,SecUOM ,unitPrice, Discount,TaxCode1);
     BigDecimal Actual = new BigDecimal(SOMUOMCurrencyDis.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(dataProvider="MUOMPercentDis",priority=49)
public void SaleIN_MUOMPercentDis_TC_54(String CustId,String  ProdId,String  Quantity,String SecUOM,String  unitPrice,String Discount,String TaxCode1,String total) throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOMUOMPercentDis ShpBytruck = PageFactory.initElements(driver,SOMUOMPercentDis.class);
       ShpBytruck.ProdTaxDis(CustId, ProdId, Quantity,SecUOM ,unitPrice, Discount,TaxCode1);
     BigDecimal Actual = new BigDecimal(SOMUOMPercentDis.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(dataProvider="BatchCurrencyDis",priority=50)
public void SaleIN_BatchCurrencyDis_TC_55(String CustId,String  ProdId,String Batch,String  Quantity,String  unitPrice,String Discount,String TaxCode1,String total) throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOBatchCurrencyDis ShpBytruck = PageFactory.initElements(driver,SOBatchCurrencyDis.class);
       ShpBytruck.ProdTaxDis(CustId, ProdId, Batch, Quantity, unitPrice, Discount);
     BigDecimal Actual = new BigDecimal(SOBatchCurrencyDis.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
	 
}
@Test(dataProvider="BatchPercentDis",priority=51)
public void SaleIN_BatchPercentDis_TC_56(String CustId,String  ProdId,String Batch,String  Quantity,String  unitPrice,String Discount,String TaxCode1,String total) throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOBatchPercentDis ShpBytruck = PageFactory.initElements(driver,SOBatchPercentDis.class);
      ShpBytruck.ProdTaxDis(CustId, ProdId, Batch, Quantity, unitPrice, Discount);
    BigDecimal Actual = new BigDecimal(SOBatchPercentDis.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(dataProvider="MUOMBatchCurrencyDis",priority=52)
public void SaleIN_MUOM_BatchCurrencyDis_TC_57(String CustId,String  ProdId,String Batch,String  Quantity,String UOM,String  unitPrice,String Discount,String TaxCode1,String total) throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOMUOMBatchCurrencyDis ShpBytruck = PageFactory.initElements(driver,SOMUOMBatchCurrencyDis.class);
      ShpBytruck.ProdTaxDis(CustId, ProdId, Batch, Quantity, UOM ,unitPrice, Discount);
    BigDecimal Actual = new BigDecimal(SOMUOMBatchCurrencyDis.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(dataProvider="MUOMBatchPerCentDis",priority=53)
public void SaleIN_MUOM_BatchPercentDis_TC_58(String CustId,String  ProdId,String Batch,String  Quantity,String UOM,String  unitPrice,String Discount,String TaxCode1,String total) throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
{
	WebDriverCommonlib.waitForPageToLoad();
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesOrder_new);		
		driver.navigate().refresh();		
		SOMUOMBatchPercentDis ShpBytruck = PageFactory.initElements(driver,SOMUOMBatchPercentDis.class);
      ShpBytruck.ProdTaxDis(CustId, ProdId, Batch, Quantity, UOM ,unitPrice, Discount);
    BigDecimal Actual = new BigDecimal(SOMUOMBatchPercentDis.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}

}
