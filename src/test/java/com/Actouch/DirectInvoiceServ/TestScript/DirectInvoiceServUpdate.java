package com.Actouch.DirectInvoiceServ.TestScript;

import java.math.BigDecimal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.DISPaymentlater;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.UPDSRVCategory;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.UPDSRVCreditTerm;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.UPDSRVCustID;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.UPDSRVDesc;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.UPDSRVDiscountINR;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.UPDSRVDiscountPer;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.UPDSRVLineDis;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.UPDSRVMemo;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.UPDSRVPrice;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.UPDSRVReference;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.UPDSRVRoundoff;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.UPDSRVSalesPerson;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.UPDSRVShipAddress;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.UPDSRVTax;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.UPDSRVTermCond;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;

import com.Actouch.Sales.generic_Lib.SO_Excellib;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
import com.Actouch.SalesINVLoc.pageObjectRepository.Login;
import com.Actouch.SalesINVLoc.pageObjectRepository.Logout;
public class DirectInvoiceServUpdate {

	static WebDriver driver;
	SO_Excellib DI_Excellib = new SO_Excellib("D:\\Selenium\\Direct Invoice.xlsx");
	@Test(priority = 1)
	public void salesIN_Login_TC_1() throws Exception
	{
		//login
		driver = Browser.getbrowser();
		 String usrid = DI_Excellib.getExcelDat("SO", 03, 03);
		 String pss = DI_Excellib.getExcelDat("SO", 03, 04);
			Browser.driver.get(Constant.Url);
		Login loginpage = PageFactory.initElements(driver, Login.class);
		loginpage.login(usrid, pss);
	
		Thread.sleep(3000);
		
		}
@Test(priority =2)
public void UPDSRV_updateCustID_TC_2() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",04, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",04, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",04, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",04, 14);
	String Total = DI_Excellib.getExcelDat("DISRV",04, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected=expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISPaymentlater payltr = PageFactory.initElements(driver, DISPaymentlater.class);
	payltr.payLtr(Cust, Desc, Category, Price);
	UPDSRVCustID UPDSC =PageFactory.initElements(driver, UPDSRVCustID.class);
	UPDSC.upadateCust("CUST4");
}
@Test(priority=3)
public void UPDSRV_updateReference_TC_3() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",04, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",04, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",04, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",04, 14);
	String Total = DI_Excellib.getExcelDat("DISRV",04, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected=expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISPaymentlater payltr = PageFactory.initElements(driver, DISPaymentlater.class);
	payltr.payLtr(Cust, Desc, Category, Price);
	UPDSRVReference UPDSR = PageFactory.initElements(driver, UPDSRVReference.class);
	UPDSR.upadateCust("0Refernce", "10");
}
@Test(priority=4)
public void UPDSRV_updateCreditTerm_TC_4() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",04, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",04, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",04, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",04, 14);
	String Total = DI_Excellib.getExcelDat("DISRV",04, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected=expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISPaymentlater payltr = PageFactory.initElements(driver, DISPaymentlater.class);
	payltr.payLtr(Cust, Desc, Category, Price);
	UPDSRVCreditTerm UPDSCT = PageFactory.initElements(driver, UPDSRVCreditTerm.class);
	UPDSCT.upadateCust("10 Days");
}
@Test(priority=5)
public void UPDSRV_updateShipAddress_TC_5() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",04, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",04, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",04, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",04, 14);
	String Total = DI_Excellib.getExcelDat("DISRV",04, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected=expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISPaymentlater payltr = PageFactory.initElements(driver, DISPaymentlater.class);
	payltr.payLtr(Cust, Desc, Category, Price);
	UPDSRVShipAddress UPDSSP = PageFactory.initElements(driver, UPDSRVShipAddress.class);
	UPDSSP.upadateCust("dfgdgdgddg");
}
@Test(priority=6)
public void UPDSRV_updateSalePerson_TC_6() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",04, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",04, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",04, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",04, 14);
	String Total = DI_Excellib.getExcelDat("DISRV",04, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected=expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISPaymentlater payltr = PageFactory.initElements(driver, DISPaymentlater.class);
	payltr.payLtr(Cust, Desc, Category, Price);
	UPDSRVSalesPerson UPDSSL = PageFactory.initElements(driver, UPDSRVSalesPerson.class);
	UPDSSL.upadateCust("E001");
}
@Test(priority=7)
public void UPDSRV_updateDescription_TC_7() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",04, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",04, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",04, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",04, 14);
	String Total = DI_Excellib.getExcelDat("DISRV",04, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected=expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISPaymentlater payltr = PageFactory.initElements(driver, DISPaymentlater.class);
	payltr.payLtr(Cust, Desc, Category, Price);
	UPDSRVDesc UPDSD = PageFactory.initElements(driver, UPDSRVDesc.class);
	UPDSD.upadateCust("Bike Servicing");
}
@Test(priority=8)
public void UPDSRV_updateCategory_TC_8() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",04, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",04, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",04, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",04, 14);
	String Total = DI_Excellib.getExcelDat("DISRV",04, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected=expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISPaymentlater payltr = PageFactory.initElements(driver, DISPaymentlater.class);
	payltr.payLtr(Cust, Desc, Category, Price);
	UPDSRVCategory UPDSCT = PageFactory.initElements(driver, UPDSRVCategory.class);
	UPDSCT.upadateCust("Sales Account","200");
}
@Test(priority=9)
public void UPDSRV_updateServicePrice_TC_9() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",04, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",04, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",04, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",04, 14);
	String Total = DI_Excellib.getExcelDat("DISRV",04, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected=expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISPaymentlater payltr = PageFactory.initElements(driver, DISPaymentlater.class);
	payltr.payLtr(Cust, Desc, Category, Price);
	UPDSRVPrice UPDSP = PageFactory.initElements(driver, UPDSRVPrice.class);
	UPDSP.upadateCust("200");
	
}
@Test(priority=10)
public void UPDSRV_updateLineDiscount_TC_10() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",04, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",04, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",04, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",04, 14);
	String Total = DI_Excellib.getExcelDat("DISRV",04, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected=expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISPaymentlater payltr = PageFactory.initElements(driver, DISPaymentlater.class);
	payltr.payLtr(Cust, Desc, Category, Price);
	UPDSRVLineDis UPDSLD = PageFactory.initElements(driver, UPDSRVLineDis.class);
	UPDSLD.upadateCust("2");
}
@Test(priority=11)
public void  UPDSRV_updateTax_TC_11() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",04, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",04, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",04, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",04, 14);
	String Total = DI_Excellib.getExcelDat("DISRV",04, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected=expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISPaymentlater payltr = PageFactory.initElements(driver, DISPaymentlater.class);
	payltr.payLtr(Cust, Desc, Category, Price);
	UPDSRVTax UPDST =PageFactory.initElements(driver, UPDSRVTax.class);
	UPDST.upadateCust("CST 2");
}
@Test(priority=12)
public void UPDSRV_updateTermCondition_TC_12() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",04, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",04, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",04, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",04, 14);
	String Total = DI_Excellib.getExcelDat("DISRV",04, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected=expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISPaymentlater payltr = PageFactory.initElements(driver, DISPaymentlater.class);
	payltr.payLtr(Cust, Desc, Category, Price);
	UPDSRVTermCond UPDSTC = PageFactory.initElements(driver, UPDSRVTermCond.class);
	UPDSTC.upadateCust("hfkshhdhjdhgd dfghdhgkdgdg");
	
}
@Test(priority=13)
public void UPDSRV_updateMemo_TC_13() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",04, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",04, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",04, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",04, 14);
	String Total = DI_Excellib.getExcelDat("DISRV",04, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected=expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISPaymentlater payltr = PageFactory.initElements(driver, DISPaymentlater.class);
	payltr.payLtr(Cust, Desc, Category, Price);
	UPDSRVMemo UPDSM = PageFactory.initElements(driver, UPDSRVMemo.class);
	UPDSM.upadateCust("dvdvdvdvdfgvg");
}
@Test(priority=14)
public void UPDSRV_updateDiscountPer_TC_14() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",04, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",04, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",04, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",04, 14);
	String Total = DI_Excellib.getExcelDat("DISRV",04, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected=expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISPaymentlater payltr = PageFactory.initElements(driver, DISPaymentlater.class);
	payltr.payLtr(Cust, Desc, Category, Price);
	UPDSRVDiscountPer UPDSDP = PageFactory.initElements(driver, UPDSRVDiscountPer.class);
	UPDSDP.upadateCust("2");
}
@Test(priority=15)
public void UPDSRV_updateDiscountINR_TC_15() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",04, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",04, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",04, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",04, 14);
	String Total = DI_Excellib.getExcelDat("DISRV",04, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected=expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISPaymentlater payltr = PageFactory.initElements(driver, DISPaymentlater.class);
	payltr.payLtr(Cust, Desc, Category, Price);
	UPDSRVDiscountINR UPDSDI = PageFactory.initElements(driver, UPDSRVDiscountINR.class);
	UPDSDI.upadateCust("2");
}
@Test(priority=16)
public void UPDSRV_updateRoundOff_TC_16() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",04, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",04, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",04, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",04, 14);
	String Total = DI_Excellib.getExcelDat("DISRV",04, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected=expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISPaymentlater payltr = PageFactory.initElements(driver, DISPaymentlater.class);
	payltr.payLtr(Cust, Desc, Category, Price);
	UPDSRVRoundoff UPDSR = PageFactory.initElements(driver, UPDSRVRoundoff.class);
	UPDSR.upadateCust("2");
}
@Test(priority=17)
public void SaleIN_Logout_TC_45() throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	Logout LG = PageFactory.initElements(driver, Logout.class);
	LG.logout();
}

}
