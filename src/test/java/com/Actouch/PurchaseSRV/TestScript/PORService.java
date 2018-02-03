package com.Actouch.PurchaseSRV.TestScript;
import java.math.BigDecimal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.POExcelLib;
import com.Actouch.Purchase.generic_Lib.POSRVExcellLib;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;
import com.Actouch.PurchaseINV.pageObjectRepository.Login;
import com.Actouch.PurchaseSRV.pageObjectRepository.PORSRVDC;
import com.Actouch.PurchaseSRV.pageObjectRepository.PORSRVDisINR;
import com.Actouch.PurchaseSRV.pageObjectRepository.PORSRVDisPer;
import com.Actouch.PurchaseSRV.pageObjectRepository.PORSRVFullReceipt;
import com.Actouch.PurchaseSRV.pageObjectRepository.PORSRVFullTax;
import com.Actouch.PurchaseSRV.pageObjectRepository.PORSRVMemo;
import com.Actouch.PurchaseSRV.pageObjectRepository.PORSRVPartialReceipt;
import com.Actouch.PurchaseSRV.pageObjectRepository.PORSRVPartialTax;
import com.Actouch.PurchaseSRV.pageObjectRepository.PORSRVReference;
import com.Actouch.PurchaseSRV.pageObjectRepository.PORSRVRoundoff;
import com.Actouch.PurchaseSRV.pageObjectRepository.PORSRVTC;
import com.Actouch.PurchaseSRV.pageObjectRepository.PORSRVValidateCustomer;
import com.Actouch.PurchaseSRV.pageObjectRepository.PORSRVValidateSO;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVPaymentLater;


public class PORService {

	
	WebDriver driver;
	@Test(priority = 1 )
	public void PORSRV_Login_TC_1() throws Exception
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
public void PORSRV_Vldt_Customer_TC_2() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
String Supp = POSRVExcellLib.getExcellData("POSRV",04, 9);
String Des = POSRVExcellLib.getExcellData("POSRV",04, 12);
String Category = POSRVExcellLib.getExcellData("POSRV",04, 13);
String Amount = POSRVExcellLib.getExcellData("POSRV",04, 14);
driver.get(Constant.POService_new);
driver.navigate().refresh();
POSRVPaymentLater payLtr = PageFactory.initElements(driver, POSRVPaymentLater.class);
payLtr.payltr(Supp, Des, Category, Amount);
PORSRVValidateCustomer Customer = PageFactory.initElements(driver, PORSRVValidateCustomer.class);
Customer.CustomerValidate();
		
}
@Test(priority=3)
public void Dlv_Vldt_So_TC_3() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",04, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",04, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",04, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",04, 14);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVPaymentLater payLtr = PageFactory.initElements(driver, POSRVPaymentLater.class);
	payLtr.payltr(Supp, Des, Category, Amount);
PORSRVValidateSO PO = PageFactory.initElements(driver, PORSRVValidateSO.class);
PO.ReceiptvalidatePO();
}
	@Test(priority=4)
	public void PORSRV_partial_TC_4() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String Supp = POSRVExcellLib.getExcellData("POSRV",04, 9);
		String Des = POSRVExcellLib.getExcellData("POSRV",04, 12);
		String Category = POSRVExcellLib.getExcellData("POSRV",04, 13);
		String Amount = POSRVExcellLib.getExcellData("POSRV",04, 14);
		String Total = POSRVExcellLib.getExcellData("PORSRV",8, 16);
		String PartialQty = POSRVExcellLib.getExcellData("PORSRV",8,7);
				BigDecimal Expected = new BigDecimal(Total);
				Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.POService_new);
		driver.navigate().refresh();
		POSRVPaymentLater payLtr = PageFactory.initElements(driver, POSRVPaymentLater.class);
		payLtr.payltr(Supp, Des, Category, Amount);
		PORSRVPartialReceipt PORSPartial = PageFactory.initElements(driver, PORSRVPartialReceipt.class);
		PORSPartial.Partialreceipt(PartialQty);
		BigDecimal Actual = new BigDecimal(PORSRVPartialReceipt.amt);	
		Assert.assertEquals(Actual,Expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}

	@Test(priority = 5)
	public void PORSRV_Full_TC_5() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String Supp = POSRVExcellLib.getExcellData("POSRV",04, 9);
		String Des = POSRVExcellLib.getExcellData("POSRV",04, 12);
		String Category = POSRVExcellLib.getExcellData("POSRV",04, 13);
		String Amount = POSRVExcellLib.getExcellData("POSRV",04, 14);
		String Total = POSRVExcellLib.getExcellData("PORSRV",9, 16);
				BigDecimal Expected = new BigDecimal(Total);
				Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.POService_new);
		driver.navigate().refresh();
		POSRVPaymentLater payLtr = PageFactory.initElements(driver, POSRVPaymentLater.class);
		payLtr.payltr(Supp, Des, Category, Amount);
		PORSRVFullReceipt PORSFull = PageFactory.initElements(driver, PORSRVFullReceipt.class);
		PORSFull.Fullreceipt();
		BigDecimal Actual = new BigDecimal(PORSRVFullReceipt.amt);	
		Assert.assertEquals(Actual,Expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}
@Test(priority = 6)
public void PORSRV_partial_Tax_TC_6() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",04, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",04, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",04, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",04, 14);
	String Total = POSRVExcellLib.getExcellData("PORSRV",10, 16);
	String PartialQty = POSRVExcellLib.getExcellData("PORSRV",10,7);
	String Tax = POSRVExcellLib.getExcellData("PORSRV",10,8);
			BigDecimal Expected = new BigDecimal(Total);
			Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVPaymentLater payLtr = PageFactory.initElements(driver, POSRVPaymentLater.class);
	payLtr.payltr(Supp, Des, Category, Amount);
	PORSRVPartialTax PORSPartial = PageFactory.initElements(driver, PORSRVPartialTax.class);
	PORSPartial.Partialreceipt(PartialQty,Tax);
	BigDecimal Actual = new BigDecimal(PORSRVPartialTax.amt);	
	Assert.assertEquals(Actual,Expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority = 7)
public void PORSRV_Full_Tax_TC_7() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",04, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",04, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",04, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",04, 14);
	String Total = POSRVExcellLib.getExcellData("PORSRV",11, 16);
	String Tax = POSRVExcellLib.getExcellData("PORSRV",11,8);
			BigDecimal Expected = new BigDecimal(Total);
			Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVPaymentLater payLtr = PageFactory.initElements(driver, POSRVPaymentLater.class);
	payLtr.payltr(Supp, Des, Category, Amount);
	PORSRVFullTax PORSPartial = PageFactory.initElements(driver, PORSRVFullTax.class);
	PORSPartial.Fullreceipt(Tax);
	BigDecimal Actual = new BigDecimal(PORSRVFullTax.amt);	
	Assert.assertEquals(Actual,Expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority = 8)
public void PORSRV_DeliveryChallan_TC_8() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",04, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",04, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",04, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",04, 14);
	String Total = POSRVExcellLib.getExcellData("PORSRV",12, 16);
	String DelChallen = POSRVExcellLib.getExcellData("PORSRV",12,9);
			BigDecimal Expected = new BigDecimal(Total);
			Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVPaymentLater payLtr = PageFactory.initElements(driver, POSRVPaymentLater.class);
	payLtr.payltr(Supp, Des, Category, Amount);
	PORSRVDC PORSPartial = PageFactory.initElements(driver, PORSRVDC.class);
	PORSPartial.FullreceiptDC(DelChallen);
	BigDecimal Actual = new BigDecimal(PORSRVDC.amt);	
	Assert.assertEquals(Actual,Expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=9)
public void PORSRV_Cash_DisperTC_9() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",04, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",04, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",04, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",04, 14);
	String Total = POSRVExcellLib.getExcellData("PORSRV",13, 16);
	String Discount = POSRVExcellLib.getExcellData("PORSRV",13,10);
			BigDecimal Expected = new BigDecimal(Total);
			Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVPaymentLater payLtr = PageFactory.initElements(driver, POSRVPaymentLater.class);
	payLtr.payltr(Supp, Des, Category, Amount);
	PORSRVDisPer PORSPartial = PageFactory.initElements(driver, PORSRVDisPer.class);
	PORSPartial.FullreceiptDisper(Discount);
	BigDecimal Actual = new BigDecimal(PORSRVDisPer.amt);	
	Assert.assertEquals(Actual,Expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority = 10)
public void PORSRV_cash_DisINR_TC_10() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",04, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",04, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",04, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",04, 14);
	String Total = POSRVExcellLib.getExcellData("PORSRV",14, 16);
	String Discount = POSRVExcellLib.getExcellData("PORSRV",14,10);
			BigDecimal Expected = new BigDecimal(Total);
			Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVPaymentLater payLtr = PageFactory.initElements(driver, POSRVPaymentLater.class);
	payLtr.payltr(Supp, Des, Category, Amount);
	PORSRVDisINR PORSPartial = PageFactory.initElements(driver, PORSRVDisINR.class);
	PORSPartial.FullreceiptDisper(Discount);
	BigDecimal Actual = new BigDecimal(PORSRVDisINR.amt);	
	Assert.assertEquals(Actual,Expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=11)
public void PORSRV_roundOff_TC_11() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",04, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",04, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",04, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",04, 14);
	String Total = POSRVExcellLib.getExcellData("PORSRV",15, 16);
	String Roundoff = POSRVExcellLib.getExcellData("PORSRV",15,15);
			BigDecimal Expected = new BigDecimal(Total);
			Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVPaymentLater payLtr = PageFactory.initElements(driver, POSRVPaymentLater.class);
	payLtr.payltr(Supp, Des, Category, Amount);
PORSRVRoundoff PORSRVRounOff = PageFactory.initElements(driver, PORSRVRoundoff.class);
PORSRVRounOff.Fullreceipt(Roundoff);
BigDecimal Actual = new BigDecimal(PORSRVRoundoff.amt);	
Assert.assertEquals(Actual,Expected,"total amount not correct");
 System.out.println("total Amount verified");

}
@Test(priority=12)
public void PORSRV_Reference_TC_12() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",04, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",04, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",04, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",04, 14);
	String Total = POSRVExcellLib.getExcellData("PORSRV",16, 16);
	String Rereference = POSRVExcellLib.getExcellData("PORSRV",16,11);
	String RereferenceAmt = POSRVExcellLib.getExcellData("PORSRV",16,12);
			BigDecimal Expected = new BigDecimal(Total);
			Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVPaymentLater payLtr = PageFactory.initElements(driver, POSRVPaymentLater.class);
	payLtr.payltr(Supp, Des, Category, Amount);
	PORSRVReference PORSRVRef = PageFactory.initElements(driver, PORSRVReference.class);
	PORSRVRef.ServiceReference(Rereference,RereferenceAmt);
	BigDecimal Actual = new BigDecimal(PORSRVReference.amt);	
	Assert.assertEquals(Actual,Expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority =13)
public void PORSRV_Memo_TC_13() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",04, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",04, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",04, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",04, 14);
	String Total = POSRVExcellLib.getExcellData("PORSRV",17, 16);
	String Memo = POSRVExcellLib.getExcellData("PORSRV",17,14);
			BigDecimal Expected = new BigDecimal(Total);
			Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVPaymentLater payLtr = PageFactory.initElements(driver, POSRVPaymentLater.class);
	payLtr.payltr(Supp, Des, Category, Amount);
	PORSRVMemo PORSRVRef = PageFactory.initElements(driver, PORSRVMemo.class);
	PORSRVRef.FullreceiptMemo(Memo);
	BigDecimal Actual = new BigDecimal(PORSRVMemo.amt);	
	Assert.assertEquals(Actual,Expected,"total amount not correct");
	 System.out.println("total Amount verified");	
}
@Test(priority =14)
public void PORSRV_TermCondition_TC_14() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",04, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",04, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",04, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",04, 14);
	String Total = POSRVExcellLib.getExcellData("PORSRV",18, 16);
	String TermCond = POSRVExcellLib.getExcellData("PORSRV",18,13);
			BigDecimal Expected = new BigDecimal(Total);
			Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVPaymentLater payLtr = PageFactory.initElements(driver, POSRVPaymentLater.class);
	payLtr.payltr(Supp, Des, Category, Amount);
	PORSRVTC PORSRVRef = PageFactory.initElements(driver, PORSRVTC.class);
	PORSRVRef.FullTC(TermCond);
	BigDecimal Actual = new BigDecimal(PORSRVTC.amt);	
	Assert.assertEquals(Actual,Expected,"total amount not correct");
	 System.out.println("total Amount verified");
}

}
