package com.Actouch.PurchaseSRV.TestScript;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.POSRVExcellLib;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;
import com.Actouch.PurchaseINV.pageObjectRepository.Login;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVAdvChq;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVAdvChqShp;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVAdvancedCashOnHand;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVAdvancedPetty;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVAdvancedPettyShp;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVBlankDet;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVBlankPO;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVMultiCurrency;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVPayLtrShpNow;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVPayNowCashOnHand;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVPayNowMultiCheque;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVPayNowPettyCash;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVPayNowSingleCheque;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVPaymentLater;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVRefInvoice;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVRoundOff;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVTCLenth;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVTDSDeduction;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVTDSDis;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVWithoutCategory;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVCreditTerm;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVDeliveryMode;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVDiffTDS;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVDisINR;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVDisPer;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVMemoLenth;
public class POService {
	WebDriver driver;
	@Test(priority = 1 )
	public void salesIN_Login_TC_1() throws Exception
	{
		//login
		
		driver = Browser.getbrowser();
String usrId = POSRVExcellLib.getExcellData("POSRV",03, 04);
		 String psw = POSRVExcellLib.getExcellData("POSRV",03, 05);
		 driver.get(Constant.Url);
		Login loginpage = PageFactory.initElements(driver, Login.class);
		loginpage.login(usrId, psw);
		Thread.sleep(5000);		
	}
	@Test(priority = 2)
	public void purchaseSRV_payltr_TC_2() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String Supp = POSRVExcellLib.getExcellData("POSRV",04, 9);
		String Des = POSRVExcellLib.getExcellData("POSRV",04, 12);
		String Category = POSRVExcellLib.getExcellData("POSRV",04, 13);
		String Amount = POSRVExcellLib.getExcellData("POSRV",04, 14);
		String Total = POSRVExcellLib.getExcellData("POSRV",04, 25);
				BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.POService_new);
		driver.navigate().refresh();
		POSRVPaymentLater payLtr = PageFactory.initElements(driver, POSRVPaymentLater.class);
		payLtr.payltr(Supp, Des, Category, Amount);
		BigDecimal Actual = new BigDecimal(POSRVPaymentLater.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}

@Test(priority = 3)
public void purchaseSRV_payltr_shpNow_TC_3() throws Exception
{
WebDriverCommonlib.waitForPageToLoad();
String Supp = POSRVExcellLib.getExcellData("POSRV",05, 9);
String Des = POSRVExcellLib.getExcellData("POSRV",05, 12);
String Category = POSRVExcellLib.getExcellData("POSRV",05, 13);
String Amount = POSRVExcellLib.getExcellData("POSRV",05, 14);
String Total = POSRVExcellLib.getExcellData("POSRV",05, 25);
BigDecimal expected = new BigDecimal(Total);
expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
driver.get(Constant.POService_new);
driver.navigate().refresh();
POSRVPayLtrShpNow payLtr = PageFactory.initElements(driver, POSRVPayLtrShpNow.class);
payLtr.payltrshp(Supp, Des, Category, Amount,"Yes");
BigDecimal Actual = new BigDecimal(POSRVPayLtrShpNow.amt);	
Assert.assertEquals(Actual,expected,"total amount not correct");
System.out.println("total Amount verified");

}
@Test(priority = 4)
public void purchaseSRV_payNowByChq_singlechq_TC_4() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",06, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",06, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",06, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",06, 14);
	String Total = POSRVExcellLib.getExcellData("POSRV",06, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVPayNowSingleCheque paychq = PageFactory.initElements(driver, POSRVPayNowSingleCheque.class);
	paychq.payNowSChq(Supp,Des,Category, Amount, "Now","HDFC", "ChequeNo", "RecvdbankName");
	BigDecimal Actual = new BigDecimal(POSRVPayNowSingleCheque.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	System.out.println("total Amount verified");
}
@Test(priority=5)
public void purchaseSRV_payNowByChq_Multichq_TC_5() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",07, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",07, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",07, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",07, 14);
	String Total = POSRVExcellLib.getExcellData("POSRV",07, 25);
	
	BigDecimal expected = new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVPayNowMultiCheque paychq = PageFactory.initElements(driver, POSRVPayNowMultiCheque.class);
	paychq.payNowSChq(Supp,Des,Category, Amount, "Now", "HDFC", "ChequeNo","ChequeNo2", "RecvdbankName");
	BigDecimal Actual = new BigDecimal(POSRVPayNowMultiCheque.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	System.out.println("total Amount verified");
}
@Test(priority=6)
public void purchaseSRV_payNowByPtty_TC_6() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",8, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",8, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",8, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",8, 14);
	String Total = POSRVExcellLib.getExcellData("POSRV",8, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVPayNowPettyCash paycsh = PageFactory.initElements(driver, POSRVPayNowPettyCash.class);
	paycsh.payNowSCash(Supp,Des,Category, Amount, "Now", "0C1000");
	BigDecimal Actual = new BigDecimal(POSRVPayNowPettyCash.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	System.out.println("total Amount verified");
}
@Test(priority = 7)
public void purchaseSRV_payNowByCashOn_TC_7() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",9, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",9, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",9, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",9, 14);
	String Total = POSRVExcellLib.getExcellData("POSRV",9, 25);
	BigDecimal expected = new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVPayNowCashOnHand paycsh = PageFactory.initElements(driver, POSRVPayNowCashOnHand.class);
	paycsh.payNowSCash(Supp,Des,Category, Amount, "Now", "0C1010");
	BigDecimal Actual = new BigDecimal(POSRVPayNowCashOnHand.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	System.out.println("total Amount verified");
}
@Test(priority = 8)
public void purchaseSRV_AdvbyPtty_TC_8() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",10, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",10, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",10, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",10, 14);
	String Total = POSRVExcellLib.getExcellData("POSRV",10, 25);
	String Adv = POSRVExcellLib.getExcellData("POSRV",10, 19);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVAdvancedPetty paycsh = PageFactory.initElements(driver, POSRVAdvancedPetty.class);
	paycsh.AdvPetty(Supp,Des,Category, Amount, Adv, "0C1000");
	BigDecimal Actual = new BigDecimal(POSRVAdvancedPetty.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	System.out.println("total Amount verified");
	
			
}
@Test(priority=9)
public void purchaseSRV_AdvbyPtty_Shp_TC_9() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",11, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",11, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",11, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",11, 14);
	String Total = POSRVExcellLib.getExcellData("POSRV",11, 25);
	String Adv = POSRVExcellLib.getExcellData("POSRV",11, 19);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVAdvancedPettyShp paycsh = PageFactory.initElements(driver, POSRVAdvancedPettyShp.class);
	paycsh.AdvPetty(Supp,Des,Category, Amount, Adv, "0C1000","Yes");
	BigDecimal Actual = new BigDecimal(POSRVAdvancedPettyShp.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	System.out.println("total Amount verified");
}
@Test(priority=10)
public void purchaseSRV_Advbycheque_TC_10() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",12, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",12, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",12, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",12, 14);
	String Total = POSRVExcellLib.getExcellData("POSRV",12, 25);
	String Adv = POSRVExcellLib.getExcellData("POSRV",12, 19);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVAdvChq paycsh = PageFactory.initElements(driver, POSRVAdvChq.class);
	paycsh.AdvPetty(Supp,Des,Category, Amount, Adv, "SBI","ChequeNo");
	BigDecimal Actual = new BigDecimal(POSRVAdvChq.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	System.out.println("total Amount verified");
}

@Test(priority=11)
public void purchaseSRV_Advbycheque_Shp_TC_11() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",13, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",13, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",13, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",13, 14);
	String Total = POSRVExcellLib.getExcellData("POSRV",13, 25);
	String Adv = POSRVExcellLib.getExcellData("POSRV",13, 19);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVAdvChqShp paycsh = PageFactory.initElements(driver, POSRVAdvChqShp.class);
	paycsh.AdvPetty(Supp,Des,Category, Amount, Adv, "SBI","ChequeNo","Yes");
	BigDecimal Actual = new BigDecimal(POSRVAdvChqShp.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	System.out.println("total Amount verified");
}

@Test(priority=12)
public void purchaseSRV_AdvbycashOn_TC_12() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",14, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",14, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",14, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",14, 14);
	String Total = POSRVExcellLib.getExcellData("POSRV",14, 25);
	String Adv = POSRVExcellLib.getExcellData("POSRV",14, 19);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVAdvancedCashOnHand paycsh = PageFactory.initElements(driver, POSRVAdvancedCashOnHand.class);
	paycsh.AdvPetty(Supp,Des,Category, Amount, Adv, "0C1010");
	BigDecimal Actual = new BigDecimal(POSRVAdvancedCashOnHand.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	System.out.println("total Amount verified");
}
@Test(priority=13)

public void purchaseSRV_AdvbycashOn_Shp_TC_13()throws Exception
{
WebDriverCommonlib.waitForPageToLoad();
String Supp = POSRVExcellLib.getExcellData("POSRV",15, 9);
String Des = POSRVExcellLib.getExcellData("POSRV",15, 12);
String Category = POSRVExcellLib.getExcellData("POSRV",15, 13);
String Amount = POSRVExcellLib.getExcellData("POSRV",15, 14);
String Total = POSRVExcellLib.getExcellData("POSRV",15, 25);
String Adv = POSRVExcellLib.getExcellData("POSRV",15, 19);
BigDecimal expected =new BigDecimal(Total);
expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
driver.get(Constant.POService_new);
driver.navigate().refresh();
POSRVAdvancedPettyShp paycsh = PageFactory.initElements(driver, POSRVAdvancedPettyShp.class);
paycsh.AdvPetty(Supp,Des,Category, Amount,Adv, "0C1010","Yes");
BigDecimal Actual = new BigDecimal(POSRVAdvancedPettyShp.amt);	
Assert.assertEquals(Actual,expected,"total amount not correct");
System.out.println("total Amount verified");

}
@Test(priority=14)
public void purchaseSRV_TDSDeduction_TC_14() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",16, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",16, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",16, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",16, 14);
	String Total = POSRVExcellLib.getExcellData("POSRV",16, 25);
	String Tax = POSRVExcellLib.getExcellData("POSRV",16, 16);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVTDSDeduction payLtr = PageFactory.initElements(driver, POSRVTDSDeduction.class);
	payLtr.TDSDedution(Supp, Des, Category, Amount,Tax);
	BigDecimal Actual = new BigDecimal(POSRVTDSDeduction.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=15)
public void purchaseSRV_TDSDeduction_Dis_TC_15() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",17, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",17, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",17, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",17, 14);
	String Total = POSRVExcellLib.getExcellData("POSRV",17, 25);
	String Tax = POSRVExcellLib.getExcellData("POSRV",17, 16);
	String Dis = POSRVExcellLib.getExcellData("POSRV",17, 15);
	BigDecimal expected =new BigDecimal(Total);
	expected =expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVTDSDis payLtr = PageFactory.initElements(driver, POSRVTDSDis.class);
	payLtr.TDSDis(Supp, Des, Category, Amount,Tax,Dis);
	BigDecimal Actual = new BigDecimal(POSRVTDSDis.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=16)
public void purchaseSRV_WithoutCategory_TC_16() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",18, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",18, 12);
	String Amount = POSRVExcellLib.getExcellData("POSRV",18, 14);
driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVWithoutCategory payLtr = PageFactory.initElements(driver, POSRVWithoutCategory.class);
	payLtr.BlankCategory(Supp, Des,Amount);
}
@Test(priority=17)
public void purchaseSRV_MultiCurrency_TC_17() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",19, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",19, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",19, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",19, 14);
	String Total = POSRVExcellLib.getExcellData("POSRV",19, 25);
	String Currency = POSRVExcellLib.getExcellData("POSRV",19, 6);
	String exchange = POSRVExcellLib.getExcellData("POSRV",19, 7);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVMultiCurrency MultiCurrency = PageFactory.initElements(driver, POSRVMultiCurrency.class);
	MultiCurrency.payMulti(Supp, Des, Category, Amount, Currency, exchange);
	BigDecimal Actual = new BigDecimal(POSRVMultiCurrency.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=18)
public void purchaseSRV_CreditTerm_TC_18() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",20, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",20, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",20, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",20, 14);
	String Total = POSRVExcellLib.getExcellData("POSRV",20, 25);
	String CreditTerm = POSRVExcellLib.getExcellData("POSRV",20, 10);
	BigDecimal Expected =new BigDecimal(Total);
	Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVCreditTerm Crdstrm = PageFactory.initElements(driver, POSRVCreditTerm.class);
	Crdstrm.CreditTerm(Supp, Des, Category, Amount, CreditTerm);
	BigDecimal Actual =new BigDecimal(POSRVCreditTerm.amt);
	Assert.assertEquals(Actual, Expected,"Total Amount not Correct");
}

@Test(priority=19)
public void purchaseSRV_DeliverMode_TC_19() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",21, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",21, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",21, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",21, 14);
	String Total = POSRVExcellLib.getExcellData("POSRV",21, 25);
	String DlvMode = POSRVExcellLib.getExcellData("POSRV",21, 20);
	BigDecimal Expected =new BigDecimal(Total);
	Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVDeliveryMode Crdstrm = PageFactory.initElements(driver, POSRVDeliveryMode.class);
	Crdstrm.DeliverMode(Supp, Des, Category, Amount, DlvMode);
	BigDecimal Actual =new BigDecimal(POSRVDeliveryMode.amt);
	Assert.assertEquals(Actual, Expected,"Total Amount not Correct");
}
@Test(priority=20)
public void purchaseSRV_DisPercentage_TC_20() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",22, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",22, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",22, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",22, 14);
	String Total = POSRVExcellLib.getExcellData("POSRV",22, 25);
	String Dis = POSRVExcellLib.getExcellData("POSRV",22, 21);
	BigDecimal Expected =new BigDecimal(Total);
	Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVDisPer Crdstrm = PageFactory.initElements(driver, POSRVDisPer.class);
	Crdstrm.PayDisPer(Supp, Des, Category, Amount, Dis);
	BigDecimal Actual =new BigDecimal(POSRVDisPer.amt);
	Assert.assertEquals(Actual, Expected,"Total Amount not Correct");
}
@Test(priority=21)
public void purchaseSRV_DisINR_TC_21()throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",23, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",23, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",23, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",23, 14);
	String Total = POSRVExcellLib.getExcellData("POSRV",23, 25);
	String Dis = POSRVExcellLib.getExcellData("POSRV",23, 21);
	BigDecimal Expected =new BigDecimal(Total);
	Expected = Expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVDisINR Crdstrm = PageFactory.initElements(driver, POSRVDisINR.class);
	Crdstrm.PayDisINR(Supp, Des, Category, Amount, Dis);
	BigDecimal Actual =new BigDecimal(POSRVDisINR.amt);
	Assert.assertEquals(Actual, Expected,"Total Amount not Correct");
}
@Test(priority =22)
public void purchaseSRV_diffTaxwithTDS_TC_22() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",24, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",24, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",24, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",24, 14);
	String Tax1 = POSRVExcellLib.getExcellData("POSRV",24, 16);
	String Tax2 = POSRVExcellLib.getExcellData("POSRV",24, 17);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVDiffTDS Crdstrm = PageFactory.initElements(driver, POSRVDiffTDS.class);
	Crdstrm.payTDSDiff(Supp, Des, Category, Amount, Tax1, Tax2);
}
@Test(priority=23)
public void purchaseSRV_BlankPO_TC_23() throws InterruptedException
{
	WebDriverCommonlib.waitForPageToLoad();
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVBlankPO Crdstrm = PageFactory.initElements(driver, POSRVBlankPO.class);
	Crdstrm.BlankPo();
}

@Test(priority=24)
public void purchaseSRV_BlankDET_TC_24() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",26, 9);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVBlankDet Crdstrm = PageFactory.initElements(driver, POSRVBlankDet.class);
	Crdstrm.BlankPo(Supp);
}
@Test(priority=25)
public void purchaseSRV_MemoLength_TC_25() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",27, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",27, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",27, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",27, 14);
	String Total = POSRVExcellLib.getExcellData("POSRV",27, 25);
	String Memo = POSRVExcellLib.getExcellData("POSRV",27, 25);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVMemoLenth payLtr = PageFactory.initElements(driver, POSRVMemoLenth.class);
	payLtr.payMemo(Supp, Des, Category, Amount,Memo);
	BigDecimal Actual = new BigDecimal(POSRVMemoLenth.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority =26)
public void purchaseSRV_TCLength_TC_26() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",28, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",28, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",28, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",28, 14);
	String Total = POSRVExcellLib.getExcellData("POSRV",28, 25);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVTCLenth payLtr = PageFactory.initElements(driver, POSRVTCLenth.class);
	payLtr.payTC(Supp, Des, Category, Amount,"memoxsc");
	BigDecimal Actual = new BigDecimal(POSRVTCLenth.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority = 27)
public void purchaseSRV_Roundoff_TC_27() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",29, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",29, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",29, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",29, 14);
	String Total = POSRVExcellLib.getExcellData("POSRV",29, 25);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVRoundOff payLtr = PageFactory.initElements(driver, POSRVRoundOff.class);
	payLtr.PayRoundoff(Supp, Des, Category, Amount,"2");
	BigDecimal Actual = new BigDecimal(POSRVRoundOff.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}
@Test(priority=28)
public void purchaseSRV_InvoiceReference_TC_28() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Supp = POSRVExcellLib.getExcellData("POSRV",30, 9);
	String Des = POSRVExcellLib.getExcellData("POSRV",30, 12);
	String Category = POSRVExcellLib.getExcellData("POSRV",30, 13);
	String Amount = POSRVExcellLib.getExcellData("POSRV",30, 14);
	String Total = POSRVExcellLib.getExcellData("POSRV",30, 25);
	 BigDecimal expected = new BigDecimal(Total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.POService_new);
	driver.navigate().refresh();
	POSRVRefInvoice payLtr = PageFactory.initElements(driver, POSRVRefInvoice.class);
	payLtr.payRefAmt(Supp, Des, Category, Amount,"2ddfd","2");
	BigDecimal Actual = new BigDecimal(POSRVRefInvoice.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}


}
