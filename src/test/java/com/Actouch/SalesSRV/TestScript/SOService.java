package com.Actouch.SalesSRV.TestScript;
import java.math.BigDecimal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.SOSRVDataProvider;
import com.Actouch.Sales.generic_Lib.SO_Excellib;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
import com.Actouch.SalesINVLoc.pageObjectRepository.Login;
import com.Actouch.SalesSRV.pageObjectRepository.SRVAdvCOH;
import com.Actouch.SalesSRV.pageObjectRepository.SRVAdvCOHDlv;
import com.Actouch.SalesSRV.pageObjectRepository.SRVAdvCheque;
import com.Actouch.SalesSRV.pageObjectRepository.SRVAdvPettyDlv;
import com.Actouch.SalesSRV.pageObjectRepository.SRVAdvancedPettyCash;
import com.Actouch.SalesSRV.pageObjectRepository.SRVBlankDet;
import com.Actouch.SalesSRV.pageObjectRepository.SRVBlankSO;
import com.Actouch.SalesSRV.pageObjectRepository.SRVAdvChqDlv;
import com.Actouch.SalesSRV.pageObjectRepository.SRVCashOnHand;
import com.Actouch.SalesSRV.pageObjectRepository.SRVCreditTerm;
import com.Actouch.SalesSRV.pageObjectRepository.SRVCurrencyLineDis;
import com.Actouch.SalesSRV.pageObjectRepository.SRVCurrencyLineDisExclusiveTx;
import com.Actouch.SalesSRV.pageObjectRepository.SRVDeliveryMode;
import com.Actouch.SalesSRV.pageObjectRepository.SRVDiscountINR;
import com.Actouch.SalesSRV.pageObjectRepository.SRVDiscountPer;
import com.Actouch.SalesSRV.pageObjectRepository.SRVExclusiveTx;
import com.Actouch.SalesSRV.pageObjectRepository.SRVMemoLength;
import com.Actouch.SalesSRV.pageObjectRepository.SRVMultiCheque;
import com.Actouch.SalesSRV.pageObjectRepository.SRVMultiCurrency;
import com.Actouch.SalesSRV.pageObjectRepository.SRVPaymentLater;
import com.Actouch.SalesSRV.pageObjectRepository.SRVPaymentNowPettyCash;
import com.Actouch.SalesSRV.pageObjectRepository.SRVPaymentNowSingleCheque;
import com.Actouch.SalesSRV.pageObjectRepository.SRVPaymentlaterDlv;
import com.Actouch.SalesSRV.pageObjectRepository.SRVPerLineDis;
import com.Actouch.SalesSRV.pageObjectRepository.SRVPerLineDisExclusiveTx;
import com.Actouch.SalesSRV.pageObjectRepository.SRVRoundOff;
import com.Actouch.SalesSRV.pageObjectRepository.SRVSalesperson;
import com.Actouch.SalesSRV.pageObjectRepository.SRVTCLength;
import com.Actouch.SalesSRV.pageObjectRepository.SRVTDSDeduction;
import com.Actouch.SalesSRV.pageObjectRepository.SRVTDSDeductionDis;
import com.Actouch.SalesSRV.pageObjectRepository.SRVTDSWithanotherTax;
import com.Actouch.SalesSRV.pageObjectRepository.SRVWithoutCategory;

public class SOService extends SOSRVDataProvider{
	static WebDriver driver;
	SO_Excellib SO_Excellib = new SO_Excellib("D:\\Selenium\\SO Service.xlsx");
	@Test(priority = 1)
	public void salesIN_Login_TC_1() throws Exception
	{
		//login
		driver = Browser.getbrowser();
		 String usrid = SO_Excellib.getExcelDat("SOSRV", 03, 04);
		 String pss = SO_Excellib.getExcelDat("SOSRV", 03, 05);
			Browser.driver.get(Constant.Url);
		Login loginpage = PageFactory.initElements(driver, Login.class);
		loginpage.login(usrid, pss);
	
		Thread.sleep(3000);
		
		}
	@Test(priority=2)
	public void SalesSRV_payltr_TC_2()throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String Cust = SO_Excellib.getExcelDat("SOSRV",04, 9);
		String Desc =SO_Excellib.getExcelDat("SOSRV",04, 12);
		String Category = SO_Excellib.getExcelDat("SOSRV",04, 13);
		String Price = SO_Excellib.getExcelDat("SOSRV",04, 14);
		String Total = SO_Excellib.getExcelDat("SOSRV",04, 25);
		BigDecimal expected =new BigDecimal(Total);
		expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesService);
		driver.navigate().refresh();
		SRVPaymentLater paymentLtr = PageFactory.initElements(driver, SRVPaymentLater.class);
		paymentLtr.payLtr(Cust,Desc, Category, Price);
		BigDecimal Actual = new BigDecimal(SRVPaymentLater.amt);
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
		
	}
	@Test(priority=3)
	public void SalesSRV_payltr_shpNow_TC_3() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String Cust = SO_Excellib.getExcelDat("SOSRV",05, 9);
		String Desc =SO_Excellib.getExcelDat("SOSRV",05, 12);
		String Category = SO_Excellib.getExcelDat("SOSRV",05, 13);
		String Price = SO_Excellib.getExcelDat("SOSRV",05, 14);
		String Total = SO_Excellib.getExcelDat("SOSRV",05, 25);
		BigDecimal expected =new BigDecimal(Total);
		expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesService);
		driver.navigate().refresh();
				SRVPaymentlaterDlv payltrDl=PageFactory.initElements(driver, SRVPaymentlaterDlv.class);
		payltrDl.payLtrDlv(Cust,Desc, Category, Price,"Yes");
BigDecimal Actual = new BigDecimal(SRVPaymentlaterDlv.amt);
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
				
	}

	
@Test(priority=4)
public void SalesSRV_payNowByChq_singlechq_TC_4() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",06, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",06, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",06, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",06, 14);
	String Total = SO_Excellib.getExcelDat("SOSRV",06, 25);
	String cheqNo=SO_Excellib.getExcelDat("Additional", 11, 06);
	String bank =SO_Excellib.getExcelDat("Additional", 11, 07);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVPaymentNowSingleCheque PaymentSingleCheque = PageFactory.initElements(driver, SRVPaymentNowSingleCheque.class);
	PaymentSingleCheque.PayNowPettySingleCheque(Cust,Desc, Category, Price, "Now", "HDFC", cheqNo, bank);
	BigDecimal Actual = new BigDecimal(SRVPaymentNowSingleCheque.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=5)
public void SalesSRV_payNowByChq_Multichq_TC_5() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",07, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",07, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",07, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",07, 14);
	String Total = SO_Excellib.getExcelDat("SOSRV",07, 25);
	 String cheqNo=SO_Excellib.getExcelDat("Additional", 12, 06);
		String bank =SO_Excellib.getExcelDat("Additional", 12, 07);
		String cheqNo2 = SO_Excellib.getExcelDat("Additional", 13, 06);
		String bank2 =SO_Excellib.getExcelDat("Additional", 13, 07);
		BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVMultiCheque PaymentSingleCheque = PageFactory.initElements(driver, SRVMultiCheque.class);
	PaymentSingleCheque.PayNowMultiCheque(Cust,Desc, Category, Price, "Now", "HDFC", cheqNo, bank,cheqNo2,bank2);
	BigDecimal Actual = new BigDecimal(SRVMultiCheque.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");


}
@Test(priority=6)
public void SalesSRV_payNowByPtty_TC_6() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",8, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",8, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",8, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",8, 14);
	String Total = SO_Excellib.getExcelDat("SOSRV",8, 25);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVPaymentNowPettyCash paymentNow = PageFactory.initElements(driver, SRVPaymentNowPettyCash.class);
	paymentNow.PayNowPettycash(Cust,Desc, Category, Price, "Now", "0C1000");
	BigDecimal Actual = new BigDecimal(SRVPaymentNowPettyCash.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
	
}
@Test(priority=7)
public void SalesSRV_payNowByCashOn_TC_7() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",9, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",9, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",9, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",9, 14);
	String Total = SO_Excellib.getExcelDat("SOSRV",9, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVCashOnHand paymentNow = PageFactory.initElements(driver, SRVCashOnHand.class);
	paymentNow.PayNowCashonHand(Cust,Desc, Category, Price, "Now", "0C1010");
	BigDecimal Actual = new BigDecimal(SRVCashOnHand.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
	
}
@Test(priority=8)
public void SalesSRV_Receive_AdvbyPtty_TC_8() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",10, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",10, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",10, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",10, 14);
	String Adv = SO_Excellib.getExcelDat("SOSRV",10, 19);
	String Total = SO_Excellib.getExcelDat("SOSRV",10, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVAdvancedPettyCash RcvAdv = PageFactory.initElements(driver, SRVAdvancedPettyCash.class);
	RcvAdv.ReceiveAdvCash(Cust,Desc, Category, Price, Adv,"0C1000");
	BigDecimal Actual = new BigDecimal(SRVAdvancedPettyCash.amt);
	Assert.assertEquals(Actual, expected,"total amount not correct");
	System.out.println("total amount verified");
}
@Test(priority=9)
public void SalesSRV_Receive_AdvbyPtty_Shp_TC_9() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",11, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",11, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",11, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",11, 14);
	String Adv = SO_Excellib.getExcelDat("SOSRV",11, 19);
	String Total = SO_Excellib.getExcelDat("SOSRV",11, 25);
	BigDecimal expected = new BigDecimal(Total);
			expected=expected.setScale(2, BigDecimal.ROUND_HALF_UP);
			driver.get(Constant.SalesService);
			driver.navigate().refresh();
			SRVAdvPettyDlv RcvAdvDlv = PageFactory.initElements(driver, SRVAdvPettyDlv.class);
			RcvAdvDlv.ReceiveAdvCash(Cust,Desc, Category, Price, Adv,"0C1000", "Yes");
			BigDecimal Actual = new BigDecimal(SRVAdvPettyDlv.amt);
			Assert.assertEquals(Actual, expected,"Total Amount is not correct");
			System.out.println("total amount verified");
}
@Test(priority=10)
public void SalesSRV_Receive_Advbycheque_TC_10() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",12, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",12, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",12, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",12, 14);
	String Total = SO_Excellib.getExcelDat("SOSRV",12, 25);
	String Adv = SO_Excellib.getExcelDat("SOSRV",12, 19);
	String cheqNo=SO_Excellib.getExcelDat("Additional", 11, 06);
	String bank =SO_Excellib.getExcelDat("Additional", 11, 07);
      BigDecimal expected = new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVAdvCheque AdvCheque = PageFactory.initElements(driver, SRVAdvCheque.class);
	AdvCheque.ReceiveAdvCash(Cust,Desc, Category, Price, Adv,"HDFC", cheqNo, bank);
	BigDecimal Actual = new BigDecimal(SRVAdvCheque.amt);
	Assert.assertEquals(Actual, expected,"Total amount is not correct");
	System.out.println("total amount verified");
}
@Test(priority=11)
public void SalesSRV_Receive_Advbycheque_Shp_TC_11() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",13, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",13, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",13, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",13, 14);
	String Total = SO_Excellib.getExcelDat("SOSRV",13, 25);
	String Adv = SO_Excellib.getExcelDat("SOSRV",13, 19);
	String cheqNo=SO_Excellib.getExcelDat("Additional", 11, 06);
	String bank =SO_Excellib.getExcelDat("Additional", 11, 07);
	BigDecimal expected =new BigDecimal(Total);
			expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
			driver.get(Constant.SalesService);
			driver.navigate().refresh();
			SRVAdvChqDlv AdvChqDlv =PageFactory.initElements(driver, SRVAdvChqDlv.class);
			AdvChqDlv.ReceiveAdvCash(Cust,"Yes",Desc, Category, Price, Adv,"HDFC", cheqNo, bank);
	BigDecimal Actual = new BigDecimal(SRVAdvChqDlv.amt);
	Assert.assertEquals(Actual, expected,"total Amount is not correct");
	System.out.println("total amount verified");
}

@Test(priority=12)
public void SalesSRV_Receive_AdvbycashOn_TC_12() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",14, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",14, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",14, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",14, 14);
	String Total = SO_Excellib.getExcelDat("SOSRV",14, 25);
	String Adv = SO_Excellib.getExcelDat("SOSRV",14, 19);
	BigDecimal expected = new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVAdvCOH AvdCOH = PageFactory.initElements(driver, SRVAdvCOH.class);
	AvdCOH.ReceiveAdvCash(Cust,Desc, Category, Price, Adv,"0C1010");
	BigDecimal Actual =new BigDecimal(SRVAdvCOH.amt);
	Assert.assertEquals(Actual, expected,"Total Amount is not correct");
System.out.println("total amount verified");
}
@Test(priority=13)
public void SalesSRV_Receive_AdvbycashOn_Shp_TC_13() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",15, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",15, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",15, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",15, 14);
	String Total = SO_Excellib.getExcelDat("SOSRV",15, 25);
	String Adv = SO_Excellib.getExcelDat("SOSRV",15, 19);
	BigDecimal expected = new BigDecimal(Total);
	expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP); 
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVAdvCOHDlv AdvCOHDlv = PageFactory.initElements(driver, SRVAdvCOHDlv.class);
	AdvCOHDlv.ReceiveAdvCash(Cust,Desc, Category, Price, Adv,"0C1010", "Yes");
	BigDecimal Actual = new BigDecimal(SRVAdvCOHDlv.amt);
	Assert.assertEquals(Actual, expected,"total Amount is not correct");
	System.out.println("Total Amount verified");
}
@Test(priority=14)
public void SalesSRV_TDSDeduction_TC_14() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",16, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",16, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",16, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",16, 14);
	String Total = SO_Excellib.getExcelDat("SOSRV",16, 25);
	String Tax = SO_Excellib.getExcelDat("SOSRV",16, 16);
	BigDecimal expected = new BigDecimal(Total);
	expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVTDSDeduction TDSDeduction = PageFactory.initElements(driver, SRVTDSDeduction.class);
	TDSDeduction.TDSDeduction(Cust,Desc, Category, Price, Tax);
	BigDecimal Actual =new BigDecimal(SRVTDSDeduction.amt);
	Assert.assertEquals(Actual, expected,"total Amount is not correct");
	System.out.println("total Amount verified");
}

@Test(priority=15)
public void SalesSRV_TDSDeduction_Dis_TC_15() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",17, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",17, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",17, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",17, 14);
	String Total = SO_Excellib.getExcelDat("SOSRV",17, 25);
	String Tax = SO_Excellib.getExcelDat("SOSRV",17, 16);
	String Dis = SO_Excellib.getExcelDat("SOSRV",17, 15);
	BigDecimal expected =new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVTDSDeductionDis TDSDeductionDis = PageFactory.initElements(driver, SRVTDSDeductionDis.class);
	TDSDeductionDis.TDSDeduction(Cust,Desc, Category, Price, Tax, Dis);
	BigDecimal Actual = new BigDecimal(SRVTDSDeductionDis.amt);
	Assert.assertEquals(Actual, expected,"total Amount is not correct");
	System.out.println("Total Amount verified");
	
}

@Test(priority =16)
public void SalesSRV_WithoutCategory_TC_16() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",18, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",18, 12);
	String Price = SO_Excellib.getExcelDat("SOSRV",18, 14);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVWithoutCategory  WithoutCate = PageFactory.initElements(driver, SRVWithoutCategory.class);
	WithoutCate.BlankCategory(Cust,Desc, Price);
}
@Test(priority=17)
public void SalesSRV_SalesPerson_TC_17() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",19, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",19, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",19, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",19, 14);
	String Total = SO_Excellib.getExcelDat("SOSRV",19, 25);
	String SalePRS = SO_Excellib.getExcelDat("SOSRV",19, 8);
	BigDecimal expected = new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVSalesperson SalesPerson = PageFactory.initElements(driver, SRVSalesperson.class);
	SalesPerson.payLtr(Cust,SalePRS,Desc, Category, Price);
	BigDecimal Actual = new BigDecimal(SRVSalesperson.amt);
	Assert.assertEquals(Actual, expected,"Total Amount is not correct ");
	System.out.println("Total Amount verified");
	
}
@Test(priority=18)
public void SalesSRV_MultiCurrency_TC_18() throws Exception

{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",20, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",20, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",20, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",20, 14);
	String Currency = SO_Excellib.getExcelDat("SOSRV",20, 6);
	String exchange = SO_Excellib.getExcelDat("SOSRV",20, 7);
	String Total = SO_Excellib.getExcelDat("SOSRV",20, 25);
	BigDecimal expected =new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVMultiCurrency multiCurrency =PageFactory.initElements(driver, SRVMultiCurrency.class);
	multiCurrency.payLtr(Cust,Currency,Desc, Category, Price, exchange);
	BigDecimal Actual = new BigDecimal(SRVMultiCurrency.amt);
	Assert.assertEquals(Actual, expected,"Total Amount is not correct ");
	System.out.println("total Amount verified");
	
}
@Test(priority=19)
public void SalesSRV_CreditTerm_TC_19() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",21, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",21, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",21, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",21, 14);
	String Total = SO_Excellib.getExcelDat("SOSRV",21, 25);
	String Crediterm = SO_Excellib.getExcelDat("SOSRV",21, 10);
	BigDecimal expected = new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVCreditTerm CRDTerm = PageFactory.initElements(driver, SRVCreditTerm.class);
	CRDTerm.payLtr(Cust,Crediterm,Desc, Category, Price);
	BigDecimal Actual = new BigDecimal(SRVCreditTerm.amt);
	Assert.assertEquals(Actual, expected,"Total Amount is not Correct");
	System.out.println("Total Amount verified");
}
@Test(priority=20)
public void SalesSRV_DeliverMode_TC_20() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",22, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",22,12);
	String Category = SO_Excellib.getExcelDat("SOSRV",22, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",22, 14);
	String Total = SO_Excellib.getExcelDat("SOSRV",22, 25);
	String CreditTerm = SO_Excellib.getExcelDat("SOSRV",22, 20);
	BigDecimal expected =new BigDecimal(Total);
			expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVDeliveryMode DeliveryMode=PageFactory.initElements(driver, SRVDeliveryMode.class);
	DeliveryMode.payLtr(Cust,Desc, Category, Price,CreditTerm);
	BigDecimal Actual =new BigDecimal(SRVDeliveryMode.amt);
	Assert.assertEquals(Actual, expected,"Total Amount is not correct");
	System.out.println("total Amount verified");
			
}
@Test(priority=21)
public void SalesSRV_DisPercentage_TC_21() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",23, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",23,12);
	String Category = SO_Excellib.getExcelDat("SOSRV",23, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",23, 14);
	String Total = SO_Excellib.getExcelDat("SOSRV",23, 25);
	String Dis = SO_Excellib.getExcelDat("SOSRV",23, 21);
	BigDecimal expected = new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVDiscountPer DisPer = PageFactory.initElements(driver, SRVDiscountPer.class);
DisPer.payLtr(Cust,Desc, Category, Price,Dis);
BigDecimal Actual =new BigDecimal(SRVDiscountPer.amt);
Assert.assertEquals(Actual, expected,"total Amount is not correct");
System.out.println("total Amount verified");
}
@Test(priority=22)
public void SalesSRV_DisINR_TC_22() throws Exception
{
WebDriverCommonlib.waitForPageToLoad();
String Cust = SO_Excellib.getExcelDat("SOSRV",24, 9);
String Desc =SO_Excellib.getExcelDat("SOSRV",24,12);
String Category = SO_Excellib.getExcelDat("SOSRV",24, 13);
String Price = SO_Excellib.getExcelDat("SOSRV",24, 14);
String Total = SO_Excellib.getExcelDat("SOSRV",24, 25);
String Dis = SO_Excellib.getExcelDat("SOSRV",24, 21);
BigDecimal expected =new BigDecimal(Total);
expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
driver.get(Constant.SalesService);
driver.navigate().refresh();
SRVDiscountINR DisINR = PageFactory.initElements(driver, SRVDiscountINR.class);
DisINR.payLtr(Cust,Desc, Category, Price,Dis);
BigDecimal Actual = new BigDecimal(SRVDiscountINR.amt);
Assert.assertEquals(Actual, expected,"Total Amount is not correct");
System.out.println("Total amount is verified");

}
@Test(priority=23)
public void SalesSRV_diffTaxwithTDS_TC_23() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",25, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",25,12);
	String Category = SO_Excellib.getExcelDat("SOSRV",25, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",25, 14);
	String Tax = SO_Excellib.getExcelDat("SOSRV",25, 16);
	String Tax1 = SO_Excellib.getExcelDat("SOSRV",25, 17);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVTDSWithanotherTax TDSDeduction = PageFactory.initElements(driver, SRVTDSWithanotherTax.class);
TDSDeduction.TDSDeduction(Cust,Desc, Category, Price, Tax,Tax1);


}
@Test(priority=24)
public void salesSRV_BlankSO_TC_24() throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVBlankSO BlankSO = PageFactory.initElements(driver, SRVBlankSO.class);
	BlankSO.BlankSO();
	
}
@Test(priority=25)
public void SalesSRV_BlankDET_TC_25() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",27, 9);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVBlankDet BlankDET =PageFactory.initElements(driver, SRVBlankDet.class);
	BlankDET.BlankDET(Cust);
}
@Test(priority=26)
public void SalesSRV_MemoLength_TC_26() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",28, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",28,12);
	String Category = SO_Excellib.getExcelDat("SOSRV",28, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",28, 14);
	String Total = SO_Excellib.getExcelDat("SOSRV",28, 25);
	BigDecimal expected =new BigDecimal(Total);
	expected=expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVMemoLength MemoLenght = PageFactory.initElements(driver, SRVMemoLength.class);
	MemoLenght.payLtr(Cust,Desc, Category, Price, "Memojdfhdkjhds");
	BigDecimal Actual = new BigDecimal(SRVMemoLength.amt);
	Assert.assertEquals(Actual, expected,"total value is not correct");
	System.out.println("Total Amount is verified");
}
@Test(priority=27)
public void SalesSRV_TCLength_TC_27() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",29, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",29,12);
	String Category = SO_Excellib.getExcelDat("SOSRV",29, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",29, 14);
	String Total = SO_Excellib.getExcelDat("SOSRV",29, 25);
	BigDecimal expected =new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVTCLength TCLength =PageFactory.initElements(driver, SRVTCLength.class);
	TCLength.payLtr(Cust,Desc, Category, Price, "Memojdfhdkjhds");
	BigDecimal Actual = new BigDecimal(SRVTCLength.amt);
	Assert.assertEquals(Actual, expected,"total value is not correct");
	System.out.println("Total Amount is verified");
}
@Test(priority=28)
public void Sales_Roundoff_TC_28() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",30, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",30,12);
	String Category = SO_Excellib.getExcelDat("SOSRV",30,13);
	String Price = SO_Excellib.getExcelDat("SOSRV",30,14);
	String Total = SO_Excellib.getExcelDat("SOSRV",30,25);
	String Roundoff = SO_Excellib.getExcelDat("SOSRV",30,25);
	BigDecimal expected =new BigDecimal(Total);
	expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVRoundOff TCLength =PageFactory.initElements(driver, SRVRoundOff.class);
	TCLength.payLtr(Cust,Desc, Category, Price,Roundoff);
	BigDecimal Actual = new BigDecimal(SRVRoundOff.amt);
	Assert.assertEquals(Actual, expected,"total value is not correct");
	System.out.println("Total Amount is verified");
}
 @Test(dataProvider="PerLineDis_TC_29",priority=29)
 public void SalesSRV_PerLineDis_TC_29(String Cust,String Desc,String Category,String Price,String LineDisc,String Total) throws InterruptedException
 {
	 BigDecimal expected =new BigDecimal(Total);
	 expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 driver.get(Constant.SalesService);
	 driver.navigate().refresh(); 
	 SRVPerLineDis PLS = PageFactory.initElements(driver, SRVPerLineDis.class);
	 PLS.payLtr(Cust, Desc, Category, Price, LineDisc);
	 BigDecimal Actual = new BigDecimal(SRVPerLineDis.amt);
		Assert.assertEquals(Actual, expected,"total value is not correct");
		System.out.println("Total Amount is verified");
	 
 }
 @Test(dataProvider="CurrencyLineDis_TC_30",priority=30)
 public void SalesSRV_CurrencyLineDis_TC_30(String Cust,String Desc,String Category,String Price,String LineDisc,String Total) throws InterruptedException
 {
	 BigDecimal expected =new BigDecimal(Total);
	 expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 driver.get(Constant.SalesService);
	 driver.navigate().refresh();
	 SRVCurrencyLineDis CLS = PageFactory.initElements(driver, SRVCurrencyLineDis.class);
	 CLS.payLtr(Cust, Desc, Category, Price, LineDisc);
	 BigDecimal Actual = new BigDecimal(SRVCurrencyLineDis.amt);
		Assert.assertEquals(Actual, expected,"total value is not correct");
		System.out.println("Total Amount is verified");
 }
 
 @Test(dataProvider="PerLineDisExclusiveTx_TC_31",priority=31)
 public void SalesSRV_PerLineDisExclusiveTx_TC_31(String Cust,String Desc,String Category,String Price,String Discount,String TaxCode,String Total) throws InterruptedException
 {
	 BigDecimal expected =new BigDecimal(Total);
	 expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 driver.get(Constant.SalesService);
	 driver.navigate().refresh();
	 SRVPerLineDisExclusiveTx PLDE = PageFactory.initElements(driver, SRVPerLineDisExclusiveTx.class);
	 PLDE.payLtr(Cust, Desc, Category, Price, Discount, TaxCode);
	 BigDecimal Actual = new BigDecimal(SRVPerLineDisExclusiveTx.amt);
		Assert.assertEquals(Actual, expected,"total value is not correct");
		System.out.println("Total Amount is verified");
 }
 @Test(dataProvider="CurrencyLineDisExclusiveTx_TC_32",priority=32)
 public void SalesSRV_CurrencyLineDisExclusiveTx_TC_32(String Cust,String Desc,String Category,String Price,String Discount,String TaxCode,String Total) throws InterruptedException
 {
	 BigDecimal expected =new BigDecimal(Total);
	 expected =expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 driver.get(Constant.SalesService);
	 driver.navigate().refresh();
	 SRVCurrencyLineDisExclusiveTx CLDE = PageFactory.initElements(driver, SRVCurrencyLineDisExclusiveTx.class);
	 CLDE.payLtr(Cust, Desc, Category, Price, Discount, TaxCode);
	 BigDecimal Actual = new BigDecimal(SRVCurrencyLineDisExclusiveTx.amt);
		Assert.assertEquals(Actual, expected,"total value is not correct");
		System.out.println("Total Amount is verified");
	 
 }
 @Test(dataProvider="ExclusiveTx_TC_33",priority=33)
 public void SalesSRV_ExclusiveTx_TC_33(String Cust,String Desc,String Category,String Price,String TaxCode,String Total,String CGST,String SGST,String IGST,String UGST) throws InterruptedException
 {
	 WebDriverCommonlib.waitForPageToLoad();
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal CGSTEdt = new BigDecimal(CGST);
	 CGSTEdt = CGSTEdt.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal SGSTEdt = new BigDecimal(SGST);
	 SGSTEdt = SGSTEdt.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal IGSTEdt = new BigDecimal(IGST);
	 IGSTEdt = IGSTEdt.setScale(2, BigDecimal.ROUND_HALF_UP);
	 BigDecimal UGSTEdt = new BigDecimal(UGST);
	 UGSTEdt = UGSTEdt.setScale(2, BigDecimal.ROUND_HALF_UP);
	 driver.get(Constant.SalesService);
	 driver.navigate().refresh();
	 SRVExclusiveTx ET = PageFactory.initElements(driver, SRVExclusiveTx.class);
	 ET.payLtr(Cust, Desc, Category, Price, TaxCode);
	 BigDecimal Actual = new BigDecimal(SRVExclusiveTx.amt);
     BigDecimal CGSTEdtA = new BigDecimal(SRVExclusiveTx.cgstAmt);
     CGSTEdtA = CGSTEdtA.setScale(2, BigDecimal.ROUND_HALF_UP);
     BigDecimal SGSTEdtA = new BigDecimal(SRVExclusiveTx.sgstAmt);
     SGSTEdtA = SGSTEdtA.setScale(2, BigDecimal.ROUND_HALF_UP);
     BigDecimal IGSTEdtA = new BigDecimal(SRVExclusiveTx.igstAmt);
     IGSTEdtA = IGSTEdtA.setScale(2, BigDecimal.ROUND_HALF_UP);
     BigDecimal UGSTEdtA = new BigDecimal(SRVExclusiveTx.ugstAmt);
     UGSTEdtA = UGSTEdtA.setScale(2, BigDecimal.ROUND_HALF_UP);
     	Assert.assertEquals(Actual,expected,"total amount not correct");
     	Assert.assertEquals(CGSTEdtA,CGSTEdt,"CGST amount not correct");
     	Assert.assertEquals(SGSTEdtA,SGSTEdt,"SGST amount not correct");
     	Assert.assertEquals(IGSTEdtA,IGSTEdt,"IGST amount not correct");
     	Assert.assertEquals(UGSTEdtA,UGSTEdt,"UGST amount not correct");
 }
 


}
