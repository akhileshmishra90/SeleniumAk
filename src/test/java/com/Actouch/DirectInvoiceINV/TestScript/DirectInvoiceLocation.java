package com.Actouch.DirectInvoiceINV.TestScript;


import java.math.BigDecimal;
import java.sql.SQLException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIAdvbyPtty;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIAvdChq;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIBatchCurrencyDis;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIBatchPercentDis;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIBatchable;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIBlankDETItem;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIBlankSO;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DICSTSalesTax;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DICashDisPer;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DICreaditTerm;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DICurrencyLineDis;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIExclusiveCurrencyDis;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIExclusivePercentDis;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIExclusiveTax;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIInclusiveCurrencyDis;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIInclusivePercentDis;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIInclusiveTax;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DILineDiscount;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIMUOM;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIMUOMBatchCurrencyDis;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIMUOMBatchable;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIMUOMCurrencyDis;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIMUOMPercentDis;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIMUOMSales;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIMemo;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIMultiProd;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIMultiTax;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIPayNowMultiChq;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIPayNowPettyCash;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIPayNowSingleChq;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIPaymentLater;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIPercentLineDis;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DISalesPerson;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIShipMode;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIShippingAddress;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DITDSOthTax;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DITaxDiscount;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DITermCondition;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DITradeDis;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIcashDisINR;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.DIDataProvider;
import com.Actouch.Sales.generic_Lib.SO_Excellib;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
import com.Actouch.SalesINVLoc.pageObjectRepository.Login;
import com.Actouch.SalesINVLoc.pageObjectRepository.Logout;
public class DirectInvoiceLocation extends DIDataProvider {
static WebDriver driver;
SO_Excellib DI_Excellib = new SO_Excellib("D:\\Selenium\\Direct InvoiceLOC.xlsx");
	@Test(priority=1)
	public void DIINV_Login_TC_1() throws Exception
	{
		driver = Browser.getbrowser();
		
		 String usrid = DI_Excellib.getExcelDat("DII", 03, 03);
		 String pss = DI_Excellib.getExcelDat("DII", 03, 04);
			Browser.driver.get(Constant.Url);
		Login loginpage = PageFactory.initElements(driver, Login.class);
		loginpage.login(usrid, pss);
	
		Thread.sleep(3000);
	}
@Test(priority=2)
public void DIINV_payltr_TC_2() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = DI_Excellib.getExcelDat("DII", 04, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 04, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 04, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 04, 16);
	 String total =DI_Excellib.getExcelDat("DII", 04, 31);
	BigDecimal expected = new BigDecimal(total);
	expected=expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIPaymentLater DIPltr = PageFactory.initElements(driver, DIPaymentLater.class);
	DIPltr.payltr(custID,prodID,Qnty,unitp);
	BigDecimal Actual = new BigDecimal(DIPaymentLater.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
	
}
@Test(priority=3)
public void DIINV_payNowByChq_singlechq_TC_3() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 05, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 05, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 05, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 05, 16);
	 String total =DI_Excellib.getExcelDat("DII", 05, 31);
	BigDecimal expected = new BigDecimal(total);
	expected=expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIPayNowSingleChq DISigChq =PageFactory.initElements(driver, DIPayNowSingleChq.class);
	DISigChq.paySgChq(custID,prodID,Qnty,unitp,"Now","SBI","ChequeNo","RecvdbankName");
	BigDecimal Actual = new BigDecimal(DIPayNowSingleChq.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
}
@Test(priority = 4)
public void DIINV_payNowByChq_Multichq_TC_4() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 06, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 06, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 06, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 06, 16);
	 String total =DI_Excellib.getExcelDat("DII", 06, 31);
	BigDecimal expected = new BigDecimal(total);
	expected=expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIPayNowMultiChq DIMulChq=PageFactory.initElements(driver, DIPayNowMultiChq.class);
   DIMulChq.paySgChq(custID,prodID,Qnty,unitp,"Now","SBI","ChequeNo","RecvdbankName","ChequeNo2","Recvbank2");
   BigDecimal Actual = new BigDecimal(DIPayNowMultiChq.amt);
   Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
   
}
@Test(priority=5)
public void DIINV_payNowByPtty_TC_5() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 07, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 07, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 07, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 07, 16);
	 String total =DI_Excellib.getExcelDat("DII", 07, 31);
	BigDecimal expected =new BigDecimal(total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIPayNowPettyCash DIPettyCash=PageFactory.initElements(driver, DIPayNowPettyCash.class);
	DIPettyCash.payltr(custID,prodID,Qnty,unitp,"Now","0C1000");
	 BigDecimal Actual = new BigDecimal(DIPayNowPettyCash.amt);
	   Assert.assertEquals(Actual, expected,"amount verification isn't correct");
		System.out.println("Amount verification is correct");
}
@Test(priority=6)
public void DIINV_payNowByCashOn_TC_6() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 8, 8);
	 String prodID = DI_Excellib.getExcelDat("DII",8, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 8, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 8, 16);
	 String total =DI_Excellib.getExcelDat("DII", 8, 31);
	BigDecimal expected =new BigDecimal(total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIPayNowPettyCash DIPettyCash=PageFactory.initElements(driver, DIPayNowPettyCash.class);
	DIPettyCash.payltr(custID,prodID,Qnty,unitp,"Now","0C1010");
	 BigDecimal Actual = new BigDecimal(DIPayNowPettyCash.amt);
	   Assert.assertEquals(Actual, expected,"amount verification isn't correct");
		System.out.println("Amount verification is correct");
}
@Test(priority=7)
public void DIINV_Receive_AdvbyPtty_TC_7() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 9, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 9, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 9, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 9, 16);
	 String Adv = DI_Excellib.getExcelDat("DII", 9, 22);
	 String total =DI_Excellib.getExcelDat("DII", 9, 31);
BigDecimal expected =new BigDecimal(total);
expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
driver.get(Constant.NewDirectInvoiceMain);
driver.navigate().refresh();
DIAdvbyPtty DIpetty = PageFactory.initElements(driver, DIAdvbyPtty.class);
DIpetty.payltr(custID,prodID,Qnty,unitp,Adv,"0C1000");
BigDecimal Actual =new BigDecimal(DIAdvbyPtty.amt);
Assert.assertEquals(Actual, expected,"amount verification isn't correct");
System.out.println("Amount verification is correct");

}
@Test(priority=8)
 public void DIINV_Receive_Advbycheque_TC_8() throws Exception
 {
	 WebDriverCommonlib.waitForPageToLoad();
	 String custID = DI_Excellib.getExcelDat("DII", 10, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 10, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 10, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 10, 16);
	 String Adv = DI_Excellib.getExcelDat("DII", 10, 22);
	 String total =DI_Excellib.getExcelDat("DII", 10, 31);
	 BigDecimal expected =new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 driver.get(Constant.NewDirectInvoiceMain);
	 driver.navigate().refresh();
	 DIAvdChq AdvChq=PageFactory.initElements(driver, DIAvdChq.class);
	 AdvChq.payltr(custID,prodID,Qnty,unitp,Adv,"HDFC","ChequeNo","RecvdbankName");
	 BigDecimal Actual =new BigDecimal(DIAvdChq.amt);
		Assert.assertEquals(Actual, expected,"amount verification isn't correct");
		System.out.println("Amount verification is correct");
 }
@Test(priority=9)
public void DIINV_Receive_AdvbycashOn_TC_9() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 11, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 11, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 11, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 11, 16);
	 String Adv = DI_Excellib.getExcelDat("DII", 11, 22);
	 String total =DI_Excellib.getExcelDat("DII", 11, 31);
	BigDecimal expected =new BigDecimal(total);
	expected = expected.setScale(2, BigDecimal.ROUND_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIAdvbyPtty DIpetty = PageFactory.initElements(driver, DIAdvbyPtty.class);
	DIpetty.payltr(custID,prodID,Qnty,unitp,Adv,"0C1010");
	BigDecimal Actual =new BigDecimal(DIAdvbyPtty.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
}
@Test(priority=10)
public void DIINV_MultiTax_TC_10() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 12, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 12, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 12, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 12, 16);
	 String Tax1 = DI_Excellib.getExcelDat("DII", 12, 19);
	 String Tax2 = DI_Excellib.getExcelDat("DII", 12, 20);
	 String total =DI_Excellib.getExcelDat("DII", 12, 31);
	BigDecimal expected =new BigDecimal(total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIMultiTax Multitax=PageFactory.initElements(driver, DIMultiTax.class);
	Multitax.payltr(custID,prodID,Qnty,unitp,Tax1,Tax2);
	BigDecimal Actual =new BigDecimal(DIMultiTax.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
	
}
@Test(priority=11)
public void DIINV_Tax_Discount_TC_11() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 13, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 13, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 13, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 13, 16);
	 String Tax = DI_Excellib.getExcelDat("DII", 13, 19);
	 String Disc = DI_Excellib.getExcelDat("DII", 13, 17);
	 String total =DI_Excellib.getExcelDat("DII", 13, 31);
	BigDecimal expected =new BigDecimal(total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DITaxDiscount TaxDiscount=PageFactory.initElements(driver, DITaxDiscount.class);
	TaxDiscount.payltr(custID,prodID,Qnty,unitp,Tax,Disc);
	BigDecimal Actual =new BigDecimal(DITaxDiscount.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
	
	
}
@Test(priority =12)
public void DIINV_LneDiscount_TC_12() throws Exception
{
 WebDriverCommonlib.waitForPageToLoad();
 String custID = DI_Excellib.getExcelDat("DII", 14, 8);
 String prodID = DI_Excellib.getExcelDat("DII", 14, 10);
 String Qnty = DI_Excellib.getExcelDat("DII", 14, 13);
 String unitp = DI_Excellib.getExcelDat("DII", 14, 16);
 String total =DI_Excellib.getExcelDat("DII", 14, 31);
 String Disc =DI_Excellib.getExcelDat("DII", 14,17);
 BigDecimal expected = new BigDecimal(total);
expected = expected.setScale(2, BigDecimal.ROUND_UP);
driver.get(Constant.NewDirectInvoiceMain);
driver.navigate().refresh();
DILineDiscount lineDisCount = PageFactory.initElements(driver, DILineDiscount.class);
lineDisCount.payltr(custID,prodID,Qnty,unitp,Disc);
BigDecimal Actual =new BigDecimal(DILineDiscount.amt);
Assert.assertEquals(Actual, expected,"amount verification isn't correct");
System.out.println("Amount verification is correct");

}
@Test(priority=13)
public void DIINV_SalesPerson_TC_13() throws Exception
{
	 WebDriverCommonlib.waitForPageToLoad();
	 String custID = DI_Excellib.getExcelDat("DII", 15, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 15, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 15, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 15, 16);
	 String Salesp = DI_Excellib.getExcelDat("DII", 15,05);
	 String total =DI_Excellib.getExcelDat("DII", 15, 31);
	 driver.get(Constant.NewDirectInvoiceMain);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_UP);
	 driver.get(Constant.NewDirectInvoiceMain);
	 driver.navigate().refresh();
	 DISalesPerson SalesPerson = PageFactory.initElements(driver, DISalesPerson.class);
	 SalesPerson.payltr(custID,prodID,Qnty,unitp,Salesp);
	 BigDecimal Actual =new BigDecimal(DISalesPerson.amt);
	 Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	 System.out.println("Amount verification is correct");
	 
}
@Test(priority=14)
public void DIINV_Inclusive_Tax_TC_14() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 16, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 16, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 16, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 16, 16);
	 String Tax = DI_Excellib.getExcelDat("DII", 16, 19);
	 String total =DI_Excellib.getExcelDat("DII", 16, 31);
 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_UP);
	 driver.get(Constant.NewDirectInvoiceMain);
	 driver.navigate().refresh();
	 DIInclusiveTax InclusiveTax = PageFactory.initElements(driver, DIInclusiveTax.class);
	 InclusiveTax.payltr(custID,prodID,Qnty,unitp,Tax);
	 BigDecimal Actual =new BigDecimal(DIInclusiveTax.amt);
	 Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	 System.out.println("Amount verification is correct");
	 
	
}

@Test(priority=15)
public void DIINV_Exclusive_Tax_TC_15() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 17, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 17, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 17, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 17, 16);
	 String Tax = DI_Excellib.getExcelDat("DII", 17, 19);
	 String total =DI_Excellib.getExcelDat("DII", 17, 31);
	  BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_UP);
	 driver.get(Constant.NewDirectInvoiceMain);
	 driver.navigate().refresh();
	 DIExclusiveTax ExclusiveTax= PageFactory.initElements(driver, DIExclusiveTax.class);
	 ExclusiveTax.payltr(custID,prodID,Qnty,unitp,Tax);
	 BigDecimal Actual =new BigDecimal(DIExclusiveTax.amt);
	 Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	 System.out.println("Amount verification is correct");
}
@Test(priority=16)
public void DIINV_MultiProduct_TC_16() throws Exception, ClassNotFoundException, SQLException
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("Multi", 4, 8);
	String Subtotal = DI_Excellib.getExcelDat("Multi", 18, 20);
	String TotalTax = DI_Excellib.getExcelDat("Multi", 18, 21); 
	String GrossTotal = DI_Excellib.getExcelDat("Multi", 18, 31); 
	BigDecimal SubtotalExp =new BigDecimal(Subtotal);
	SubtotalExp = SubtotalExp.setScale(2, BigDecimal.ROUND_HALF_UP);
	BigDecimal TotalTaxExp =new BigDecimal(TotalTax);
	TotalTaxExp = TotalTaxExp.setScale(2, BigDecimal.ROUND_HALF_UP);
	BigDecimal GrossTotalExp =new BigDecimal(GrossTotal);
	GrossTotalExp = GrossTotalExp.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	SoftAssert Softass = new SoftAssert();
	DIMultiProd MultiProd=PageFactory.initElements(driver, DIMultiProd.class);
	MultiProd.payltr(custID);
	 BigDecimal GrossAct =new BigDecimal(DIMultiProd.Grossamt);
	 BigDecimal TotaltaxAct =new BigDecimal(DIMultiProd.totalTaxamt);
	 BigDecimal SubTotalAct =new BigDecimal(DIMultiProd.Subtotal);
	 Softass.assertEquals(SubTotalAct, SubtotalExp,"amount verification isn't correct");
	 System.out.println("SubTotalAct verification is correct");
	 Softass.assertEquals(TotaltaxAct, TotalTaxExp,"amount verification isn't correct");
	 System.out.println("TotaltaxAct verification is correct");
	 Softass.assertEquals(GrossAct, GrossTotalExp,"amount verification isn't correct");
	 System.out.println("GrossAct verification is correct");
	 DIMultiProd.payltrDB("jdbc:mysql://178.162.192.40:3306/", "actouchuser", "actouchuser","select * from actouch.shp_mstr where  ENTITY_ID = 987139910 and Invoice_ID ='"+DIMultiProd.exp+"'", "CUST_ID","CUST_NAME","TOTAL_AMT","TOTAL_TAX");
	 Softass.assertEquals(custID,DIMultiProd.CUST_ID,"CustID is not correct");
	 BigDecimal Total_TXT = DIMultiProd.Total_Tax;
	 Total_TXT = Total_TXT.setScale(2, BigDecimal.ROUND_HALF_UP);
	 Softass.assertEquals(Total_TXT, TotalTaxExp,"Total Tax coming as wrong ");
		BigDecimal Total_amt = DIMultiProd.TOTAL_AMT;
		Total_amt = Total_amt.setScale(2,BigDecimal.ROUND_HALF_UP);
		Softass.assertEquals(Total_amt,GrossTotalExp,"total amount not correct");
		 DIMultiProd.payltrDB1("jdbc:mysql://178.162.192.40:3306/", "actouchuser", "actouchuser","select * from actouch.shp_det where Invoice_ID ='"+DIMultiProd.HiberNate_SeQ+"'","PRD_ID","QTY","UNITPRICE","LINE_TOTAL");
		 DIMultiProd.payltrDB2("jdbc:mysql://178.162.192.40:3306/", "actouchuser", "actouchuser", "select * from actouch.tax_hist where ENTITY_ID = 987139910 and DOC_ID='"+DIMultiProd.exp+"'order by  sl_no asc", "TAX_ID", "TAXABLE_AMT", "GROSS_AMT", "SGST_TAX_AMT", "CGST_TAX_AMT");
		 Softass.assertAll();
		
}
 @Test(priority=17)
public void DIINV_CreditTerm_TC_18() throws Exception
{
	 WebDriverCommonlib.waitForPageToLoad();
	 String custID = DI_Excellib.getExcelDat("DII", 23, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 23, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 23, 13);
	 String unitp = DI_Excellib.getExcelDat("DII",23, 16);
	 String Credit = DI_Excellib.getExcelDat("DII",23, 9);
	 String total =DI_Excellib.getExcelDat("DII", 23, 31);
	 BigDecimal expected =new BigDecimal(total);
		expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.NewDirectInvoiceMain);
		driver.navigate().refresh();
	DICreaditTerm CreditTerm= PageFactory.initElements(driver, DICreaditTerm.class);
	CreditTerm.payltr(custID,Credit,prodID,Qnty,unitp);
	BigDecimal Actual =new BigDecimal(DICreaditTerm.amt);
	 Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	 System.out.println("Amount verification is correct");
}
@Test(priority=18)
public void DIINV_ShpByAir_TC_19() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 24, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 24, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 24, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 24, 16);
	 String total =DI_Excellib.getExcelDat("DII", 24, 31);
	BigDecimal expected=new BigDecimal(total);
	expected =expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIShipMode ShpAir =PageFactory.initElements(driver, DIShipMode.class);
	ShpAir.payltr(custID,prodID,Qnty,unitp, "By Air");
BigDecimal Actual=new BigDecimal(DIShipMode.amt);
Assert.assertEquals(Actual, expected,"amount verification isn't correct");
System.out.println("Amount verification is correct");

}
@Test(priority=19)
public void DIINV_ShpByCargo_TC_20() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 25, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 25, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 25, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 25, 16);
	 String total =DI_Excellib.getExcelDat("DII", 25, 31);
	BigDecimal expected=new BigDecimal(total);
	expected =expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIShipMode ShpAir =PageFactory.initElements(driver, DIShipMode.class);
	ShpAir.payltr(custID,prodID,Qnty,unitp, "By Cargo");
BigDecimal Actual=new BigDecimal(DIShipMode.amt);
Assert.assertEquals(Actual, expected,"amount verification isn't correct");
System.out.println("Amount verification is correct");
}
@Test(priority=20)
public void DIINV_ShpByRail_TC_21() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 26, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 26, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 26, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 26, 16);
	 String total =DI_Excellib.getExcelDat("DII", 26, 31);
	BigDecimal expected=new BigDecimal(total);
	expected =expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIShipMode ShpAir =PageFactory.initElements(driver, DIShipMode.class);
	ShpAir.payltr(custID,prodID,Qnty,unitp, "By Rail");
BigDecimal Actual=new BigDecimal(DIShipMode.amt);
Assert.assertEquals(Actual, expected,"amount verification isn't correct");
System.out.println("Amount verification is correct");
}
@Test(priority=21)
public void DIINV_ShpByCourier_TC_22() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 27, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 27, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 27, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 27, 16);
	 String total =DI_Excellib.getExcelDat("DII", 27, 31);
	BigDecimal expected=new BigDecimal(total);
	expected =expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIShipMode ShpAir =PageFactory.initElements(driver, DIShipMode.class);
	ShpAir.payltr(custID,prodID,Qnty,unitp, "By Courier");
BigDecimal Actual=new BigDecimal(DIShipMode.amt);
Assert.assertEquals(Actual, expected,"amount verification isn't correct");
System.out.println("Amount verification is correct");
}
@Test(priority=22)
public void DIINV_ShpByHand_TC_23() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 28, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 28, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 28, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 28, 16);
	 String total =DI_Excellib.getExcelDat("DII", 28, 31);
	BigDecimal expected=new BigDecimal(total);
	expected =expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIShipMode ShpAir =PageFactory.initElements(driver, DIShipMode.class);
	ShpAir.payltr(custID,prodID,Qnty,unitp, "By Hand");
BigDecimal Actual=new BigDecimal(DIShipMode.amt);
Assert.assertEquals(Actual, expected,"amount verification isn't correct");
System.out.println("Amount verification is correct");

}
@Test(priority=23)
public void DIINV_ShpByRoad_TC_24() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 29, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 29, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 29, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 29, 16);
	 String total =DI_Excellib.getExcelDat("DII", 29, 31);
	BigDecimal expected=new BigDecimal(total);
	expected =expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIShipMode ShpAir =PageFactory.initElements(driver, DIShipMode.class);
	ShpAir.payltr(custID,prodID,Qnty,unitp, "By Road");
BigDecimal Actual=new BigDecimal(DIShipMode.amt);
Assert.assertEquals(Actual, expected,"amount verification isn't correct");
System.out.println("Amount verification is correct");

}
@Test(priority=24)
public void DIINV_ShpByTruck_TC_25() throws Exception 
{
WebDriverCommonlib.waitForPageToLoad();
String custID = DI_Excellib.getExcelDat("DII", 30, 8);
String prodID = DI_Excellib.getExcelDat("DII", 30, 10);
String Qnty = DI_Excellib.getExcelDat("DII", 30, 13);
String unitp = DI_Excellib.getExcelDat("DII", 30, 16);
String total =DI_Excellib.getExcelDat("DII", 30, 31);
BigDecimal expected=new BigDecimal(total);
expected =expected.setScale(2,BigDecimal.ROUND_HALF_UP);
driver.get(Constant.NewDirectInvoiceMain);
driver.navigate().refresh();
DIShipMode ShpAir =PageFactory.initElements(driver, DIShipMode.class);
ShpAir.payltr(custID,prodID,Qnty,unitp, "By Truck");
BigDecimal Actual=new BigDecimal(DIShipMode.amt);
Assert.assertEquals(Actual, expected,"amount verification isn't correct");
System.out.println("Amount verification is correct");
}
@Test(priority=25)
public void DIINV_CashDiscount_Percentage_TC_26() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 31, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 31, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 31, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 31, 16);
	 String Dis = DI_Excellib.getExcelDat("DII", 31, 23);
	 String total =DI_Excellib.getExcelDat("DII", 31, 31);
	BigDecimal expected = new BigDecimal(total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DICashDisPer DisPer=PageFactory.initElements(driver, DICashDisPer.class);
	DisPer.payltr(custID,prodID,Qnty,unitp,Dis);
	BigDecimal Actual=new BigDecimal(DICashDisPer.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
}
@Test(priority=26)
public void DIINV_CashDiscount_INR_TC_27() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 32, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 32, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 32, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 32, 16);
	 String Dis = DI_Excellib.getExcelDat("DII", 32, 23);
	 String total =DI_Excellib.getExcelDat("DII", 32, 31);
	BigDecimal expected = new BigDecimal(total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIcashDisINR DisINR = PageFactory.initElements(driver, DIcashDisINR.class);
	DisINR.payltr(custID,prodID,Qnty,unitp, Dis);
	BigDecimal Actual=new BigDecimal(DIcashDisINR.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
}
@Test(priority=27)
public void DIINV_TradeDiscount_TC_28() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 33, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 33, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 33, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 33, 16);
	 String Dis = DI_Excellib.getExcelDat("DII", 33, 23);
	 String total =DI_Excellib.getExcelDat("DII", 33, 31);
	BigDecimal expected = new BigDecimal(total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DITradeDis TradeDis=PageFactory.initElements(driver, DITradeDis.class);
	TradeDis.payltr(custID,prodID,Qnty,unitp,Dis);
	BigDecimal Actual=new BigDecimal(DITradeDis.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
}
@Test(priority=28)
public void DIINV_SalesTax_TC_29() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 34, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 34, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 34, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 34, 16);
	 String Salestax = DI_Excellib.getExcelDat("DII", 34, 26);
	 String total =DI_Excellib.getExcelDat("DII", 34, 31);
	BigDecimal expected =new BigDecimal(total);
	expected= expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DICSTSalesTax SalesTax = PageFactory.initElements(driver, DICSTSalesTax.class);
	SalesTax.payltr(custID,prodID,Qnty,unitp, "Yes", Salestax);
	BigDecimal Actual=new BigDecimal(DICSTSalesTax.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
}
@Test(priority=29)
public void DIINV_TDSWith_OtherTax_TC_30() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad(); 
	String custID = DI_Excellib.getExcelDat("DII", 35, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 35, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 35, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 35, 16);
	 String Tax1 = DI_Excellib.getExcelDat("DII", 35, 19);
	 String Tax2 = DI_Excellib.getExcelDat("DII", 35, 20);
	 String total =DI_Excellib.getExcelDat("DII", 35, 31);
	BigDecimal expected =new BigDecimal(total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DITDSOthTax OtherTax = PageFactory.initElements(driver, DITDSOthTax.class);
	OtherTax.payltr(custID,prodID,Qnty,unitp, Tax1,Tax2);
}
@Test(priority=30)
public void DIINV_MUOM_TC_31() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 36, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 36, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 36, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 36, 16);
	 String Secuom = DI_Excellib.getExcelDat("DII", 36, 14);
	 String total =DI_Excellib.getExcelDat("DII", 36, 31);
	BigDecimal expected =new BigDecimal(total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIMUOM MUOM = PageFactory.initElements(driver, DIMUOM.class);
	MUOM.payltr(custID,prodID,Qnty,unitp, Secuom);
	BigDecimal Actual = new BigDecimal(DIMUOM.amt);
	Assert.assertEquals(Actual, expected,"amount verification is not Correct");
	System.out.println("Amount verification is Correct" );
}
@Test(priority=31)
public void DIINV_BatchableItem_TC_32() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 37, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 37, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 37, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 37, 16);
	 String Batchp = DI_Excellib.getExcelDat("DII", 37, 15);
	 String total =DI_Excellib.getExcelDat("DII", 37, 31);
	BigDecimal expected =new BigDecimal(total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIBatchable Batch= PageFactory.initElements(driver, DIBatchable.class);
	Batch.payltr(custID,prodID,Qnty,unitp, Batchp);
	BigDecimal Actual =new BigDecimal(DIBatchable.amt);
	Assert.assertEquals(Actual, expected,"Amount verification is not correct");
	System.out.println("Amount verification is correct");
	
}
@Test(priority=32)
public void DIINV_MUOM_Batchableitem_TC_33() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 38, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 38, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 38, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 38, 16);
	 String Secuom = DI_Excellib.getExcelDat("DII", 38, 14);
	 String Batchp = DI_Excellib.getExcelDat("DII", 38, 15);
	 String total =DI_Excellib.getExcelDat("DII", 38, 31);
	BigDecimal expected =new BigDecimal(total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
driver.get(Constant.NewDirectInvoiceMain);
driver.navigate().refresh();
DIMUOMBatchable MuomBatch = PageFactory.initElements(driver, DIMUOMBatchable.class);
MuomBatch.payltr(custID,prodID,Qnty,unitp,Batchp, Secuom);
BigDecimal Actual =new BigDecimal(DIMUOMBatchable.amt);
Assert.assertEquals(Actual, expected,"Amount verification is not correct");
System.out.println("Amount verification is correct");
}
@Test(priority=33)
public void DIINV_MUOMS_TC_34() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 39, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 39, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 39, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 39, 16);
	 String Secuom = DI_Excellib.getExcelDat("DII", 39, 14);
	 String total =DI_Excellib.getExcelDat("DII", 39, 31);
	BigDecimal expected =new BigDecimal(total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
driver.get(Constant.NewDirectInvoiceMain);
driver.navigate().refresh(); 
DIMUOMSales MUOMSales=PageFactory.initElements(driver, DIMUOMSales.class);
MUOMSales.payltr(custID,prodID,Qnty,unitp, Secuom, "1");
BigDecimal Actual=new BigDecimal(DIMUOMSales.amt);
Assert.assertEquals(Actual, expected,"Amount verification is not correct");
System.out.println("Amount verification is correct");
}
@Test(priority=34)
public void DIINV_BlankSo_TC_36() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIBlankSO BlankSo = PageFactory.initElements(driver, DIBlankSO.class);
	BlankSo.payltr();
	
}
@Test(priority=35)
public void DIINV_BlankDETlevel_TC_37() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIBlankDETItem DETitem =PageFactory.initElements(driver, DIBlankDETItem.class);
	DETitem.payltr("CUST4");
}
@Test(priority=36)
public void DIINV_Shipment_Length_TC_38() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 43, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 43, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 43, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 43, 16);
	 //String Shipping  = DI_Excellib.getExcelDat("DII", 43, 16);
	 String total =DI_Excellib.getExcelDat("DII", 43, 31);
	BigDecimal expected = new BigDecimal(total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIShippingAddress ShipAdd = PageFactory.initElements(driver, DIShippingAddress.class);
	ShipAdd.payltr(custID,prodID,Qnty,unitp, "ShipAddressgsdsgj");
	BigDecimal Actual = new BigDecimal(DIShippingAddress.amt);
	Assert.assertEquals(Actual, expected,"Total Amount is not Correct");
	System.out.println("Total Amount is correct");
}

@Test(priority =37)
public void DIINV_Memo_Length_TC_39() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 44, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 44, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 44, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 44, 16);
	 String total =DI_Excellib.getExcelDat("DII", 44, 31);
	BigDecimal expected =new BigDecimal(total);
    expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
    driver.get(Constant.NewDirectInvoiceMain);
    driver.navigate().refresh();
    DIMemo memo = PageFactory.initElements(driver, DIMemo.class);
    memo.payltr(custID,prodID,Qnty,unitp, "ShipAddressgsdsgjdsgfjds");
    BigDecimal Actual =new BigDecimal(DIMemo.amt);
    Assert.assertEquals(Actual, expected,"Total Amount is not Correct");
	System.out.println("Total Amount is correct");
    }
@Test(priority=38)
public void DIINV_TC_Length_TC_40() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String custID = DI_Excellib.getExcelDat("DII", 45, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 45, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 45, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 45, 16);
	 String total =DI_Excellib.getExcelDat("DII", 45, 31);
	BigDecimal expected =new BigDecimal(total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DITermCondition TermCond = PageFactory.initElements(driver, DITermCondition.class);
	TermCond.payltr(custID,prodID,Qnty,unitp, "ShipAddressgsdsgjdsgfjds");
	 BigDecimal Actual =new BigDecimal(DIMemo.amt);
	    Assert.assertEquals(Actual, expected,"Total Amount is not Correct");
		System.out.println("Total Amount is correct");
}
@Test(dataProvider="CurrencyLineDiscount",priority=39)
public void DIINV_CurrencyLineDiscount_TC_41(String Customer_Id,String Product_Id,String Quantity,String unit_price,String LineDis,String total) throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected =new BigDecimal(total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DICurrencyLineDis LinDis= PageFactory.initElements(driver, DICurrencyLineDis.class);
	LinDis.payltr(Customer_Id, Product_Id, Quantity, unit_price, LineDis);
	 BigDecimal Actual =new BigDecimal(DICurrencyLineDis.amt);
	    Assert.assertEquals(Actual, expected,"Total Amount is not Correct");
		System.out.println("Total Amount is correct");
}
@Test(dataProvider="PercentLineDiscount",priority=40)
public void DIINV_PercentLineDiscount_TC_42(String Customer_Id,String Product_Id,String Quantity,String unit_price,String LineDis,String total) throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected =new BigDecimal(total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIPercentLineDis LinDis= PageFactory.initElements(driver, DIPercentLineDis.class);
	LinDis.payltr(Customer_Id, Product_Id, Quantity, unit_price, LineDis);
	 BigDecimal Actual =new BigDecimal(DIPercentLineDis.amt);
	    Assert.assertEquals(Actual, expected,"Total Amount is not Correct");
		System.out.println("Total Amount is correct");
}
@Test(dataProvider="InclusiveTaxCurrencyDis",priority=41)
public void DIINV_InclusiveTaxCurrencyDis_TC_43(String Customer_Id,String Product_Id,String Quantity,String unit_price,String LineDis,String taxCode1,String total,String CGST,String SGST,String IGST,String UGST) throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal CGSTEdt = new BigDecimal(CGST);
	 CGSTEdt = CGSTEdt.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal SGSTEdt = new BigDecimal(SGST);
	 SGSTEdt = SGSTEdt.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal IGSTEdt = new BigDecimal(IGST);
	 IGSTEdt = IGSTEdt.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal UGSTEdt = new BigDecimal(UGST);
	 UGSTEdt = UGSTEdt.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIInclusiveCurrencyDis LinDis= PageFactory.initElements(driver, DIInclusiveCurrencyDis.class);
	LinDis.payltr(Customer_Id, Product_Id, Quantity, unit_price, LineDis, taxCode1);
	 BigDecimal Actual =new BigDecimal(DIInclusiveCurrencyDis.amt);
	 BigDecimal CGSTEdtA = new BigDecimal(DIInclusiveCurrencyDis.cgstAmt);
	 CGSTEdtA = CGSTEdtA.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal SGSTEdtA = new BigDecimal(DIInclusiveCurrencyDis.sgstAmt);
	 SGSTEdtA = SGSTEdtA.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal IGSTEdtA = new BigDecimal(DIInclusiveCurrencyDis.igstAmt);
	 IGSTEdtA = IGSTEdtA.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal UGSTEdtA = new BigDecimal(DIInclusiveCurrencyDis.ugstAmt);
	 UGSTEdtA = UGSTEdtA.setScale(2, BigDecimal.ROUND_HALF_UP);
	 	Assert.assertEquals(Actual,expected,"total amount not correct");
	 	Assert.assertEquals(CGSTEdtA,CGSTEdt,"CGST amount not correct");
	  	Assert.assertEquals(SGSTEdtA,SGSTEdt,"SGST amount not correct");
	  	Assert.assertEquals(IGSTEdtA,IGSTEdt,"IGST amount not correct");
	 	Assert.assertEquals(UGSTEdtA,UGSTEdt,"UGST amount not correct");
}
@Test(dataProvider="InclusiveTaxPercentDis",priority=42)
public void DIINV_InclusiveTaxPercentDisTC_44(String Customer_Id,String Product_Id,String Quantity,String unit_price,String LineDis,String taxCode1,String total,String CGST,String SGST,String IGST,String UGST) throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal CGSTEdt = new BigDecimal(CGST);
	 CGSTEdt = CGSTEdt.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal SGSTEdt = new BigDecimal(SGST);
	 SGSTEdt = SGSTEdt.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal IGSTEdt = new BigDecimal(IGST);
	 IGSTEdt = IGSTEdt.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal UGSTEdt = new BigDecimal(UGST);
	 UGSTEdt = UGSTEdt.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIInclusivePercentDis LinDis= PageFactory.initElements(driver, DIInclusivePercentDis.class);
	LinDis.payltr(Customer_Id, Product_Id, Quantity, unit_price, LineDis, taxCode1);
	 BigDecimal Actual =new BigDecimal(DIInclusivePercentDis.amt);
	 BigDecimal CGSTEdtA = new BigDecimal(DIInclusivePercentDis.cgstAmt);
	 CGSTEdtA = CGSTEdtA.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal SGSTEdtA = new BigDecimal(DIInclusivePercentDis.sgstAmt);
	 SGSTEdtA = SGSTEdtA.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal IGSTEdtA = new BigDecimal(DIInclusivePercentDis.igstAmt);
	 IGSTEdtA = IGSTEdtA.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal UGSTEdtA = new BigDecimal(DIInclusivePercentDis.ugstAmt);
	 UGSTEdtA = UGSTEdtA.setScale(2, BigDecimal.ROUND_HALF_UP);
	 	Assert.assertEquals(Actual,expected,"total amount not correct");
	 	Assert.assertEquals(CGSTEdtA,CGSTEdt,"CGST amount not correct");
	  	Assert.assertEquals(SGSTEdtA,SGSTEdt,"SGST amount not correct");
	  	Assert.assertEquals(IGSTEdtA,IGSTEdt,"IGST amount not correct");
	 	Assert.assertEquals(UGSTEdtA,UGSTEdt,"UGST amount not correct");
}

@Test(dataProvider="ExclusiveTaxCurrencyDis",priority=43)
public void DIINV_ExclusiveTaxCurrencyDisTC_45(String Customer_Id,String Product_Id,String Quantity,String unit_price,String LineDis,String taxCode1,String total,String CGST,String SGST,String IGST,String UGST) throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal CGSTEdt = new BigDecimal(CGST);
	 CGSTEdt = CGSTEdt.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal SGSTEdt = new BigDecimal(SGST);
	 SGSTEdt = SGSTEdt.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal IGSTEdt = new BigDecimal(IGST);
	 IGSTEdt = IGSTEdt.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal UGSTEdt = new BigDecimal(UGST);
	 UGSTEdt = UGSTEdt.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIExclusiveCurrencyDis LinDis= PageFactory.initElements(driver, DIExclusiveCurrencyDis.class);
	LinDis.payltr(Customer_Id, Product_Id, Quantity, unit_price, LineDis, taxCode1);
	 BigDecimal Actual =new BigDecimal(DIExclusiveCurrencyDis.amt);
	 BigDecimal CGSTEdtA = new BigDecimal(DIExclusiveCurrencyDis.cgstAmt);
	 CGSTEdtA = CGSTEdtA.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal SGSTEdtA = new BigDecimal(DIExclusiveCurrencyDis.sgstAmt);
	 SGSTEdtA = SGSTEdtA.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal IGSTEdtA = new BigDecimal(DIExclusiveCurrencyDis.igstAmt);
	 IGSTEdtA = IGSTEdtA.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal UGSTEdtA = new BigDecimal(DIExclusiveCurrencyDis.ugstAmt);
	 UGSTEdtA = UGSTEdtA.setScale(2, BigDecimal.ROUND_HALF_UP);
	 	Assert.assertEquals(Actual,expected,"total amount not correct");
	 	Assert.assertEquals(CGSTEdtA,CGSTEdt,"CGST amount not correct");
	  	Assert.assertEquals(SGSTEdtA,SGSTEdt,"SGST amount not correct");
	  	Assert.assertEquals(IGSTEdtA,IGSTEdt,"IGST amount not correct");
	 	Assert.assertEquals(UGSTEdtA,UGSTEdt,"UGST amount not correct");
}
@Test(dataProvider="ExclusiveTaxPercentDis",priority=44)
public void DIINV_ExclusiveTaxPercentDisTC_46(String Customer_Id,String Product_Id,String Quantity,String unit_price,String LineDis,String taxCode1,String total,String CGST,String SGST,String IGST,String UGST) throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal CGSTEdt = new BigDecimal(CGST);
	 CGSTEdt = CGSTEdt.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal SGSTEdt = new BigDecimal(SGST);
	 SGSTEdt = SGSTEdt.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal IGSTEdt = new BigDecimal(IGST);
	 IGSTEdt = IGSTEdt.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal UGSTEdt = new BigDecimal(UGST);
	 UGSTEdt = UGSTEdt.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIExclusivePercentDis LinDis= PageFactory.initElements(driver, DIExclusivePercentDis.class);
	LinDis.payltr(Customer_Id, Product_Id, Quantity, unit_price, LineDis, taxCode1);
	 BigDecimal Actual =new BigDecimal(DIExclusivePercentDis.amt);
	 BigDecimal CGSTEdtA = new BigDecimal(DIExclusivePercentDis.cgstAmt);
	 CGSTEdtA = CGSTEdtA.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal SGSTEdtA = new BigDecimal(DIExclusivePercentDis.sgstAmt);
	 SGSTEdtA = SGSTEdtA.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal IGSTEdtA = new BigDecimal(DIExclusivePercentDis.igstAmt);
	 IGSTEdtA = IGSTEdtA.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal UGSTEdtA = new BigDecimal(DIExclusivePercentDis.ugstAmt);
	 UGSTEdtA = UGSTEdtA.setScale(2, BigDecimal.ROUND_HALF_UP);
	 	Assert.assertEquals(Actual,expected,"total amount not correct");
	 	Assert.assertEquals(CGSTEdtA,CGSTEdt,"CGST amount not correct");
	  	Assert.assertEquals(SGSTEdtA,SGSTEdt,"SGST amount not correct");
	  	Assert.assertEquals(IGSTEdtA,IGSTEdt,"IGST amount not correct");
	 	Assert.assertEquals(UGSTEdtA,UGSTEdt,"UGST amount not correct");
}
@Test(dataProvider="MUOMCurrencyDis",priority=45)
public void DIINV_MUOMCurrencyDis_TC_47(String Customer_Id,String Product_Id,String Quantity,String IssuedUOM,String unit_price,String LineDis,String taxCode1,String total) throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected =new BigDecimal(total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIMUOMCurrencyDis LinDis= PageFactory.initElements(driver, DIMUOMCurrencyDis.class);
	LinDis.payltr(Customer_Id, Product_Id, Quantity,IssuedUOM ,unit_price, LineDis, taxCode1);
	 BigDecimal Actual =new BigDecimal(DIMUOMCurrencyDis.amt);
	    Assert.assertEquals(Actual, expected,"Total Amount is not Correct");
		System.out.println("Total Amount is correct");
}
@Test(dataProvider="MUOMCurrencyDis",priority=46)
public void DIINV_MUOMPercentDis_TC_48(String Customer_Id,String Product_Id,String Quantity,String IssuedUOM,String unit_price,String LineDis,String taxCode1,String total) throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected =new BigDecimal(total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIMUOMPercentDis LinDis= PageFactory.initElements(driver, DIMUOMPercentDis.class);
	LinDis.payltr(Customer_Id, Product_Id, Quantity,IssuedUOM ,unit_price, LineDis, taxCode1);
	 BigDecimal Actual =new BigDecimal(DIMUOMPercentDis.amt);
	    Assert.assertEquals(Actual, expected,"Total Amount is not Correct");
		System.out.println("Total Amount is correct");
}
@Test(dataProvider="BatchCurrencyDis",priority=47)
public void DIINV_BatchCurrencyDis_TC_49(String Customer_Id,String Product_Id,String Batch,String Quantity,String unit_price,String LineDis,String taxCode1,String total) throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected =new BigDecimal(total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIBatchCurrencyDis LinDis= PageFactory.initElements(driver, DIBatchCurrencyDis.class);
	LinDis.payltr(Customer_Id, Product_Id,Batch , Quantity,unit_price, LineDis, taxCode1);
	 BigDecimal Actual =new BigDecimal(DIBatchCurrencyDis.amt);
	    Assert.assertEquals(Actual, expected,"Total Amount is not Correct");
		System.out.println("Total Amount is correct");
}
@Test(dataProvider="BatchPercentDis",priority=48)
public void DIINV_BatchPercentDis_TC_50(String Customer_Id,String Product_Id,String Batch,String Quantity,String unit_price,String LineDis,String taxCode1,String total) throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected =new BigDecimal(total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIBatchPercentDis LinDis= PageFactory.initElements(driver, DIBatchPercentDis.class);
	LinDis.payltr(Customer_Id, Product_Id,Batch , Quantity,unit_price, LineDis, taxCode1);
	 BigDecimal Actual =new BigDecimal(DIBatchPercentDis.amt);
	    Assert.assertEquals(Actual, expected,"Total Amount is not Correct");
		System.out.println("Total Amount is correct");
}
@Test(dataProvider="MUOMBatchCurrencyDis",priority=49)
public void DIINV_MUOM_BatchCurrencyDis_TC_51(String Customer_Id,String Product_Id,String Batch,String Quantity,String SecUOM,String unit_price,String LineDis,String taxCode1,String total) throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	BigDecimal expected = new BigDecimal(total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIMUOMBatchCurrencyDis LinDiscount= PageFactory.initElements(driver, DIMUOMBatchCurrencyDis.class);
	LinDiscount.payltr(Customer_Id, Product_Id, Batch, Quantity, SecUOM, unit_price, LineDis, taxCode1);
	BigDecimal Actual =new BigDecimal(DIBatchPercentDis.amt);
    Assert.assertEquals(Actual, expected,"Total Amount is not Correct");
	System.out.println("Total Amount is correct");
}
@Test(priority = 50)
public void DIINV_Logout_TC_53() throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	driver.navigate().refresh();
	Logout LG = PageFactory.initElements(driver, Logout.class);
	LG.logout();
	driver.quit();
}

}
