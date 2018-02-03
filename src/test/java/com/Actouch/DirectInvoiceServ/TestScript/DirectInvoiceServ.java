package com.Actouch.DirectInvoiceServ.TestScript;
import java.math.BigDecimal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.DISBlankDET;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.DISBlankDI;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.DISCashDisINR;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.DISCashDisPer;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.DISCreditTerm;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.DISMemoLength;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.DISMultiCurrency;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.DISPayNowMultiChq;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.DISPayNowPettyCash;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.DISPayNowSingleChq;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.DISPaymentlater;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.DISRcvByAdv;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.DISRcvbyChq;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.DISRoundoff;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.DISSaleperson;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.DISShipmode;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.DISTCLength;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.DISTDS;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.DISTDSDifferTax;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.DISTDSWithDiscount;
import com.Actouch.DirectInvoiceServ.pageObjectRepository.DISWithoutCategory;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.SO_Excellib;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
import com.Actouch.SalesINVLoc.pageObjectRepository.Login;
import com.Actouch.SalesINVLoc.pageObjectRepository.Logout;

public class DirectInvoiceServ {
	static WebDriver driver;
	SO_Excellib DI_Excellib = new SO_Excellib("D:\\Selenium\\Direct Invoice.xlsx");
	@Test(priority=1)
	public void DIINV_Login_TC_1() throws Exception
	{
		driver = Browser.getbrowser();
		
		 String usrid = DI_Excellib.getExcelDat("DISRV", 03, 04);
		 String pss = DI_Excellib.getExcelDat("DISRV", 03, 05);
			Browser.driver.get(Constant.Url);
		Login loginpage = PageFactory.initElements(driver, Login.class);
		loginpage.login(usrid, pss);
	
		Thread.sleep(3000);
	}
	@Test(priority=2)
	public void DISRV_payltr_TC_2() throws Exception
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
		BigDecimal Actual = new BigDecimal(DISPaymentlater.amt);
		Assert.assertEquals(Actual, expected,"amount verification isn't correct");
		System.out.println("Amount verification is correct");
	}

	@Test(priority=3)
	public void DISRV_payNowByChq_singlechq_TC_3() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String Cust = DI_Excellib.getExcelDat("DISRV",05, 9);
		String Desc =DI_Excellib.getExcelDat("DISRV",05, 12);
		String Category = DI_Excellib.getExcelDat("DISRV",05, 13);
		String Price = DI_Excellib.getExcelDat("DISRV",05, 14);
		String Total = DI_Excellib.getExcelDat("DISRV",05, 25);
		BigDecimal expected =new BigDecimal(Total);
		expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.NewDirectInvoiceMain);
		driver.navigate().refresh();
		DISPayNowSingleChq SingChq =PageFactory.initElements(driver, DISPayNowSingleChq.class);
		SingChq.payLtr(Cust,Desc, Category, Price, "Now","HDFC","ChequeNo","RecvdbankName");
		BigDecimal Actual = new BigDecimal(DISPayNowSingleChq.amt);
		Assert.assertEquals(Actual, expected,"amount verification isn't correct");
		System.out.println("Amount verification is correct");
	}
@Test(priority=4)
public void DISRV_payNowByChq_Multichq_TC_4() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",06, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",06, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",06, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",06, 14);
	String Total = DI_Excellib.getExcelDat("DISRV",06, 25);
	BigDecimal expected =new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISPayNowMultiChq Multichq = PageFactory.initElements(driver, DISPayNowMultiChq.class);
	Multichq.payLtr(Cust, Desc,Category,Price, "Now","HDFC","ChequeNo","RecvdbankName","ChequeNo2","Recvbank2");
	BigDecimal Actual = new BigDecimal(DISPayNowMultiChq.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
}

@Test(priority=5)
public void DISRV_payNowByPtty_TC_5() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",07, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",07, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",07, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",07, 14);
	String Total = DI_Excellib.getExcelDat("DISRV",07, 25);
	BigDecimal expected =new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISPayNowPettyCash pettyCash = PageFactory.initElements(driver, DISPayNowPettyCash.class);
	pettyCash.payLtr(Cust,Desc, Category,Price, "Now", "0C1000");
	BigDecimal Actual = new BigDecimal(DISPayNowPettyCash.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
}
@Test(priority=6)
public void DISRV_payNowByCashOn_TC_6() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",8, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",8, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",8, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",8, 14);
	String Total = DI_Excellib.getExcelDat("DISRV",8, 25);
	BigDecimal expected =new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISPayNowPettyCash pettyCash = PageFactory.initElements(driver, DISPayNowPettyCash.class);
	pettyCash.payLtr(Cust,Desc,Category,Price, "Now", "0C1010");
	BigDecimal Actual = new BigDecimal(DISPayNowPettyCash.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
}
@Test(priority=7)
public void DISRV_Receive_AdvbyPtty_TC_7() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",9, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",9, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",9, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",9,14);
	String Total = DI_Excellib.getExcelDat("DISRV",9, 25);
	String Advanced =DI_Excellib.getExcelDat("DISRV",9, 19);
	BigDecimal expected =new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISRcvByAdv PettyCash=PageFactory.initElements(driver, DISRcvByAdv.class);
	PettyCash.payLtr(Cust,Desc,Category, Price,Advanced, "0C1000");
	BigDecimal Actual = new BigDecimal(DISRcvByAdv.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
	
}
@Test(priority=8)
public void DISRV_Receive_Advbycheque_TC_8() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",10, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",10, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",10, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",10, 14);
	String Advanced =DI_Excellib.getExcelDat("DISRV",10, 19);
	String Total = DI_Excellib.getExcelDat("DISRV",10, 25);
	BigDecimal expected =new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISRcvbyChq Cheque = PageFactory.initElements(driver, DISRcvbyChq.class);
	Cheque.payLtr(Cust, Desc, Category, Price, Advanced, "HDFC","ChequeNo","RecvdbankName");
	BigDecimal Actual = new BigDecimal(DISRcvbyChq.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
}
@Test(priority=9)
public void  DISRV_Receive_AdvbycashOn_TC_9() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",11, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",11, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",11, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",11, 14);
	String Total = DI_Excellib.getExcelDat("DISRV",11, 25);
	String Advanced =DI_Excellib.getExcelDat("DISRV",11, 19);
	BigDecimal expected =new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISRcvByAdv CashOnhand=PageFactory.initElements(driver, DISRcvByAdv.class);
	CashOnhand.payLtr(Cust, Desc, Category, Price,Advanced, "0C1010");
	BigDecimal Actual = new BigDecimal(DISRcvByAdv.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
}
@Test(priority=10)
public void DISRV_TDSDeduction_TC_10() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",12, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",12, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",12, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",12, 14);
	String TaxID = DI_Excellib.getExcelDat("DISRV",12, 16);
	String Total = DI_Excellib.getExcelDat("DISRV",12, 25);
	BigDecimal expected =new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISTDS Tax = PageFactory.initElements(driver, DISTDS.class);
	Tax.payLtr(Cust, Desc, Category, Price,TaxID);
	BigDecimal Actual =new BigDecimal(DISTDS.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
	
}
@Test(priority=11)
public void DISRV_TDSDeduction_Dis_TC_11() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",13, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",13, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",13, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",13, 14);
	String TaxID = DI_Excellib.getExcelDat("DISRV",13, 16);
	String Discount = DI_Excellib.getExcelDat("DISRV",13, 15);
	String Total = DI_Excellib.getExcelDat("DISRV",13, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISTDSWithDiscount Tax = PageFactory.initElements(driver, DISTDSWithDiscount.class);
	Tax.payLtr(Cust, Desc, Category, Price,Discount,TaxID);
	BigDecimal Actual =new BigDecimal(DISTDSWithDiscount.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
	
}
@Test(priority=12)
public void DISRV_WithoutCategory_TC_12() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",14, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",14, 12);
	String Price = DI_Excellib.getExcelDat("DISRV",14, 14);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISWithoutCategory Tax = PageFactory.initElements(driver, DISWithoutCategory.class);
	Tax.BlankCategory(Cust, Desc, Price);
}

@Test(priority=13)
public void DISRV_SalesPerson_TC_13() throws Exception
{
WebDriverCommonlib.waitForPageToLoad();
String Cust = DI_Excellib.getExcelDat("DISRV",15, 9);
String Desc =DI_Excellib.getExcelDat("DISRV",15, 12);
String Category = DI_Excellib.getExcelDat("DISRV",15, 13);
String Price = DI_Excellib.getExcelDat("DISRV",15, 14);
String Saleperson = DI_Excellib.getExcelDat("DISRV",15, 8);
String Total = DI_Excellib.getExcelDat("DISRV",15, 25);
BigDecimal expected = new BigDecimal(Total);
expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
driver.get(Constant.NewDirectInvoiceMain);
driver.navigate().refresh();
DISSaleperson Tax = PageFactory.initElements(driver, DISSaleperson.class);
Tax.payLtr(Cust,Desc,Category,Price,Saleperson);
BigDecimal Actual =new BigDecimal(DISSaleperson.amt);
Assert.assertEquals(Actual, expected,"amount verification isn't correct");
System.out.println("Amount verification is correct");
}
@Test(priority =14)
public void DISRV_MultiCurrency_TC_14() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",16, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",16, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",16, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",16, 14);
	String MultiCurr = DI_Excellib.getExcelDat("DISRV",16, 6);
	String Exchange = DI_Excellib.getExcelDat("DISRV",16,7);
	String Total = DI_Excellib.getExcelDat("DISRV",16, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISMultiCurrency Tax = PageFactory.initElements(driver, DISMultiCurrency.class);
	Tax.payLtr(Cust,Desc,Category,Price,MultiCurr,Exchange);
	BigDecimal Actual =new BigDecimal(DISMultiCurrency.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
}
@Test(priority =15)
public void DISRV_CreditTerm_TC_15() throws Exception
{
		WebDriverCommonlib.waitForPageToLoad();
		String Cust = DI_Excellib.getExcelDat("DISRV",17, 9);
		String Desc =DI_Excellib.getExcelDat("DISRV",17, 12);
		String Category = DI_Excellib.getExcelDat("DISRV",17, 13);
		String Price = DI_Excellib.getExcelDat("DISRV",17, 14);
		String CreditTerm = DI_Excellib.getExcelDat("DISRV",17, 10);
		String Total = DI_Excellib.getExcelDat("DISRV",17, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISCreditTerm CrTerm = PageFactory.initElements(driver, DISCreditTerm.class);
	CrTerm.payLtr(Cust,Desc,Category,Price,CreditTerm);
	BigDecimal Actual =new BigDecimal(DISCreditTerm.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
}
@Test(priority=16)
public void DISRV_ShipByAir_TC_16() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",18, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",18, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",18, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",18, 14);
	String Total = DI_Excellib.getExcelDat("DISRV",18, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISShipmode ByAir = PageFactory.initElements(driver, DISShipmode.class);
	ByAir.payLtr(Cust,Desc,Category,Price,"By Air");
	BigDecimal Actual =new BigDecimal(DISShipmode.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
}
@Test(priority=17)
public void DISRV_ShipByCargo_TC_17() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",19, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",19, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",19, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",19, 14);
	String Total = DI_Excellib.getExcelDat("DISRV",19, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISShipmode ByCargo = PageFactory.initElements(driver, DISShipmode.class);
	ByCargo.payLtr(Cust,Desc,Category,Price,"By Cargo");
	BigDecimal Actual =new BigDecimal(DISShipmode.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
}
@Test(priority=18)
public void DISRV_ShipByRail_TC_18() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",20, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",20, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",20, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",20, 14);
	String Total = DI_Excellib.getExcelDat("DISRV",20, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISShipmode ByRail = PageFactory.initElements(driver, DISShipmode.class);
	ByRail.payLtr(Cust,Desc,Category,Price,"By Rail");
	BigDecimal Actual =new BigDecimal(DISShipmode.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
}
@Test(priority=19)
public void DISRV_ShipByCourier_TC_19() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",21, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",21, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",21, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",21, 14);
	String Total = DI_Excellib.getExcelDat("DISRV",21, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISShipmode ByCourier = PageFactory.initElements(driver, DISShipmode.class);
	ByCourier.payLtr(Cust,Desc,Category,Price,"By Courier");
	BigDecimal Actual =new BigDecimal(DISShipmode.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
}
@Test(priority=20)
public void DISRV_ShipByHand_TC_20() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",22, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",22, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",22, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",22, 14);
	String Total = DI_Excellib.getExcelDat("DISRV",22, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISShipmode ByHand = PageFactory.initElements(driver, DISShipmode.class);
	ByHand.payLtr(Cust,Desc,Category,Price,"By Hand");
	BigDecimal Actual =new BigDecimal(DISShipmode.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
}
@Test(priority=21)
public void DISRV_ShipByRoad_TC_21() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",23, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",23, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",23, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",23, 14);
	String Total = DI_Excellib.getExcelDat("DISRV",23, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISShipmode ByRoad = PageFactory.initElements(driver, DISShipmode.class);
	ByRoad.payLtr(Cust,Desc,Category,Price,"By Road");
	BigDecimal Actual =new BigDecimal(DISShipmode.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
}
@Test(priority=22)
public void DISRV_ShipByTruck_TC_22() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",24, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",24, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",24, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",24, 14);
	String Total = DI_Excellib.getExcelDat("DISRV",24, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISShipmode ByTruck = PageFactory.initElements(driver, DISShipmode.class);
	ByTruck.payLtr(Cust,Desc,Category,Price,"By Truck");
	BigDecimal Actual =new BigDecimal(DISShipmode.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
}
@Test(priority=23)
public void DISRV_DisPercentage_TC_23() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",25, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",25, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",25, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",25, 14);
	String Dis = DI_Excellib.getExcelDat("DISRV",25, 21);
	String Total = DI_Excellib.getExcelDat("DISRV",25, 25);
	BigDecimal expected = new BigDecimal(Total); 
	expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISCashDisPer DisPer = PageFactory.initElements(driver, DISCashDisPer.class);
	DisPer.payLtr(Cust,Desc,Category,Price,Dis);
	BigDecimal Actual =new BigDecimal(DISCashDisPer.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
}
@Test(priority=24)
public void DISRV_DisINR_TC_24() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",26, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",26, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",26, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",26, 14);
	String Dis = DI_Excellib.getExcelDat("DISRV",26, 21);
	String Total = DI_Excellib.getExcelDat("DISRV",26, 25);
	BigDecimal expected = new BigDecimal(Total); 
	expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISCashDisINR DisINR = PageFactory.initElements(driver, DISCashDisINR.class);
	DisINR.payLtr(Cust,Desc,Category,Price,Dis);
	BigDecimal Actual =new BigDecimal(DISCashDisPer.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
}
@Test(priority=25)
public void DISRV_diffTaxwithTDS_TC_25() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",27, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",27, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",27, 13);
	String TaxID = DI_Excellib.getExcelDat("DISRV",27, 16);
	String TaxID2 = DI_Excellib.getExcelDat("DISRV",27, 17);
	String Price = DI_Excellib.getExcelDat("DISRV",27, 14);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISTDSDifferTax DisPer = PageFactory.initElements(driver, DISTDSDifferTax.class);
	DisPer.TDSDeduction(Cust,Desc,Category,Price,TaxID,TaxID2);
}
@Test(priority=26)
public void DISRV_BlankSO_TC_26() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISBlankDI DisPer = PageFactory.initElements(driver, DISBlankDI.class);
	DisPer.payltr();
}
@Test(priority=27)
public void DISRV_BlankDET_TC_27() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",06, 9);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISBlankDET DisPer = PageFactory.initElements(driver, DISBlankDET.class);
	DisPer.BlankDET(Cust);
}
@Test(priority=28)
public void DISRV_MemoLength_TC_28() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",30, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",30, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",30, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",30, 14);
	String Memo1 = DI_Excellib.getExcelDat("DISRV",30,23);
	String Total = DI_Excellib.getExcelDat("DISRV",30, 25);
	BigDecimal expected = new BigDecimal(Total); 
	expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISMemoLength Memo =PageFactory.initElements(driver, DISMemoLength.class);
	Memo.payLtr(Cust,Desc,Category,Price,Memo1);
	BigDecimal Actual =new BigDecimal(DISMemoLength.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
}
@Test(priority=29)
public void	DISRV_TCLength_TC_29() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",31, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",31, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",31, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",31, 14);
	String TermCond = DI_Excellib.getExcelDat("DISRV",31, 24);
	String Total = DI_Excellib.getExcelDat("DISRV",31, 25);
	BigDecimal expected = new BigDecimal(Total); 
	expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISTCLength Tclength= PageFactory.initElements(driver, DISTCLength.class);
	Tclength.payLtr(Cust,Desc,Category,Price,TermCond);
	BigDecimal Actual =new BigDecimal(DISTCLength.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
}
@Test(priority=30)
public void DISRV_Roundoff_TC_30() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = DI_Excellib.getExcelDat("DISRV",32, 9);
	String Desc =DI_Excellib.getExcelDat("DISRV",32, 12);
	String Category = DI_Excellib.getExcelDat("DISRV",32, 13);
	String Price = DI_Excellib.getExcelDat("DISRV",32, 14);
	String Roundoff = DI_Excellib.getExcelDat("DISRV",32,22);
	String Total = DI_Excellib.getExcelDat("DISRV",32, 25);
	BigDecimal expected = new BigDecimal(Total); 
	expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DISRoundoff Tclength= PageFactory.initElements(driver, DISRoundoff.class);
	Tclength.payLtr(Cust,Desc,Category,Price,Roundoff);
	BigDecimal Actual =new BigDecimal(DISRoundoff.amt);
	Assert.assertEquals(Actual, expected,"amount verification isn't correct");
	System.out.println("Amount verification is correct");
}
@Test(priority=31)
public void SaleIN_Logout_TC_45() throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	Logout LG = PageFactory.initElements(driver, Logout.class);
	LG.logout();
}
}
