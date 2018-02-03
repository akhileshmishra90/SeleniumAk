package com.Actouch.PurchaseINV.TestScript;
import java.math.BigDecimal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.POExcelLib;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;
import com.Actouch.PurchaseINV.pageObjectRepository.PO_BatchableItem;
import com.Actouch.PurchaseINV.pageObjectRepository.POBlankPageSaving;
import com.Actouch.PurchaseINV.pageObjectRepository.Login;
import com.Actouch.PurchaseINV.pageObjectRepository.POMUOMProduct;
import com.Actouch.PurchaseINV.pageObjectRepository.POPayAdvCashOnHand;
import com.Actouch.PurchaseINV.pageObjectRepository.POPayAdvCheque;
import com.Actouch.PurchaseINV.pageObjectRepository.POPayAdvChequeRecp;
import com.Actouch.PurchaseINV.pageObjectRepository.POPayAdvPettyCash;
import com.Actouch.PurchaseINV.pageObjectRepository.POPayAdvPettyRecp;
import com.Actouch.PurchaseINV.pageObjectRepository.POPaymentLater;
import com.Actouch.PurchaseINV.pageObjectRepository.POPaymentLaterRecvnow;
import com.Actouch.PurchaseINV.pageObjectRepository.POPaymentNowCashOnHand;
import com.Actouch.PurchaseINV.pageObjectRepository.POPaymentNowMultiCheque;
import com.Actouch.PurchaseINV.pageObjectRepository.POPaymentNowPettyCash;
import com.Actouch.PurchaseINV.pageObjectRepository.POPaymentNowSingleCheque;
import com.Actouch.PurchaseINV.pageObjectRepository.PO_TaxWithTDS;
import com.Actouch.PurchaseINV.pageObjectRepository.PO_TradeDiscount;
import com.Actouch.PurchaseINV.pageObjectRepository.PO_WithCSTtax;
import com.Actouch.PurchaseINV.pageObjectRepository.PO_WithCreditTerm;
import com.Actouch.PurchaseINV.pageObjectRepository.PO_WithMemoFieldLength;
import com.Actouch.PurchaseINV.pageObjectRepository.PO_WithTandCFieldLength;
import com.Actouch.PurchaseINV.pageObjectRepository.PO_WithoutDETline;
import com.Actouch.PurchaseINV.pageObjectRepository.POProductInclusiveTax;
import com.Actouch.PurchaseINV.pageObjectRepository.POProductMultipleTax;
import com.Actouch.PurchaseINV.pageObjectRepository.POProductTaxDiscount;
import com.Actouch.PurchaseINV.pageObjectRepository.PO_RecieptByAir;
import com.Actouch.PurchaseINV.pageObjectRepository.PO_TaxExclusive;
import com.Actouch.PurchaseINV.pageObjectRepository.PO_WithoutDiscount;
import com.Actouch.PurchaseINV.pageObjectRepository.PO_WithoutTax;
import com.Actouch.PurchaseINV.pageObjectRepository.PoDiscountWithCash;
import com.Actouch.PurchaseINV.pageObjectRepository.PoDiscountWithpercentage;
import com.Actouch.PurchaseINV.pageObjectRepository.PO_BatchMUOMProduct;

public class PurchaseOrder {
	WebDriver driver;
	@Test(priority = 1 )
	public void salesIN_Login_TC_1() throws Exception
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
	public void purchaseIN_payltr_TC2() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		//Required Data for test case.
		String suppID = POExcelLib.getExcelData("PO", 4, 8);
		String prdID = POExcelLib.getExcelData("PO", 4, 14);
		String qty = POExcelLib.getExcelData("PO", 4, 17);
		String unitP = POExcelLib.getExcelData("PO", 4, 21);
		String taxCode = POExcelLib.getExcelData("PO", 4, 24);
		String payType = POExcelLib.getExcelData("PO", 4, 28);
		String Total = POExcelLib.getExcelData("PO", 4, 39);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		POPaymentLater payLtr = PageFactory.initElements(driver, POPaymentLater.class);
		payLtr.payltr(suppID, prdID, qty, unitP, taxCode, payType);
		BigDecimal Actual = new BigDecimal(POPaymentLater.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
		
	}
	//-------------------Test scenario for create PO with payment Later and Receive Now -------------------------- 
	@Test(priority=3)
	public void purchaseIN_payltr_recvNow_TC3() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		 String suppID = POExcelLib.getExcelData("PO", 5, 8);
		 String prodID = POExcelLib.getExcelData("PO", 5, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 5, 17);
		 String unitp = POExcelLib.getExcelData("PO", 5, 21);
		 String taxCode = POExcelLib.getExcelData("PO", 5, 24);
		 String payType = POExcelLib.getExcelData("PO", 5, 28);
		 String Total = POExcelLib.getExcelData("PO", 5, 39);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		 driver.get(Constant.PurchaseOrder_new);
	       driver.navigate().refresh();
			POPaymentLaterRecvnow payLtrShp = PageFactory.initElements(driver, POPaymentLaterRecvnow.class);
			payLtrShp.PayLtrShp(suppID, prodID, Qnty, unitp,taxCode,payType);
			BigDecimal Actual = new BigDecimal(POPaymentLaterRecvnow .amt);	
			Assert.assertEquals(Actual,expected,"total amount not correct");
			 System.out.println("total Amount verified");

	}
	//-------------------Test scenario for create PO with payment Now(single cheque)-------------------------- 
	@Test(priority = 4)
	public void purchaseIN_payNowByChq_singlechq_TC_4() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		 String suppID = POExcelLib.getExcelData("PO", 6, 8);
		 String prodID = POExcelLib.getExcelData("PO", 6, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 6, 17);
		 String unitp = POExcelLib.getExcelData("PO", 6, 21);
		 String payType = POExcelLib.getExcelData("PO", 6, 28);
		 String Bank = POExcelLib.getExcelData("Add_details", 7, 5);
		 String Chequeno = POExcelLib.getExcelData("Add_details", 7, 6);
		 String Total = POExcelLib.getExcelData("PO", 6, 39);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		POPaymentNowSingleCheque payNowcheque = PageFactory.initElements(driver, POPaymentNowSingleCheque.class);
		payNowcheque.payNowCheque(suppID, prodID, Qnty, unitp, payType,Bank,Chequeno);
		BigDecimal Actual = new BigDecimal(POPaymentNowSingleCheque .amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}
	//-------------------Test scenario for create PO with payment Now(multi cheque)-------------------------- 
	@Test(priority = 5)
	public void purchaseIN_payNowByChq_Multichq_TC_5() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		 String suppID = POExcelLib.getExcelData("PO", 7, 8);
		 String prodID = POExcelLib.getExcelData("PO", 7, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 7, 17);
		 String unitp = POExcelLib.getExcelData("PO", 7, 21);
		 String payType = POExcelLib.getExcelData("PO", 7, 28);
		 String Total = POExcelLib.getExcelData("PO", 7, 39);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
POPaymentNowMultiCheque payNowcheque = PageFactory.initElements(driver, POPaymentNowMultiCheque.class);
		payNowcheque.payNowMultiCheque(suppID, prodID, Qnty, unitp, payType, "HDFC", "chq1234", "flj4295dsv");
		BigDecimal Actual = new BigDecimal(POPaymentNowMultiCheque .amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}
	
	@Test(priority = 6)
	public void purchaseIN_payNowByPtty_TC_6() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		 String suppID = POExcelLib.getExcelData("PO", 8, 8);
		 String prodID = POExcelLib.getExcelData("PO", 8, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 8, 17);
		 String unitp = POExcelLib.getExcelData("PO", 8, 21);
		 String payType = POExcelLib.getExcelData("PO", 8, 28);
		 String Total = POExcelLib.getExcelData("PO", 8, 39);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);		
			driver.navigate().refresh();			
		POPaymentNowPettyCash payNowPetty = PageFactory.initElements(driver, POPaymentNowPettyCash.class);
		payNowPetty.payNowPetty(suppID, prodID, Qnty, unitp, payType, "petty cash");
		BigDecimal Actual = new BigDecimal(POPaymentNowPettyCash .amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}
	
	@Test(priority = 7)
	public void purchaseIN_payNowByCashOn_TC_7() throws Exception
	{
       WebDriverCommonlib.waitForPageToLoad();
		 String suppID = POExcelLib.getExcelData("PO", 9, 8);
		 String prodID = POExcelLib.getExcelData("PO", 9, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 9, 17);
		 String unitp = POExcelLib.getExcelData("PO", 9, 21);
		 String payType = POExcelLib.getExcelData("PO", 9, 28);
		 String Total = POExcelLib.getExcelData("PO", 9, 39);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		POPaymentNowCashOnHand payNowCash = PageFactory.initElements(driver, POPaymentNowCashOnHand.class);
		payNowCash.payNowCash(suppID, prodID, Qnty, unitp, payType, "cash on");
		BigDecimal Actual = new BigDecimal(POPaymentNowCashOnHand .amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}
	
		@Test(priority = 8)
		public void purchaseIN_Receive_AdvbyPtty_recv_TC_11() throws Exception
		{
	WebDriverCommonlib.waitForPageToLoad();
		 String suppID = POExcelLib.getExcelData("PO", 13, 8);
		 String prodID = POExcelLib.getExcelData("PO", 13, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 13, 17);
		 String unitp = POExcelLib.getExcelData("PO", 13, 21);
		 String Adv = POExcelLib.getExcelData("PO", 13, 29);
		 String taxCode = POExcelLib.getExcelData("PO", 13, 24);
		 String Total = POExcelLib.getExcelData("PO", 13, 39);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		 driver.get(Constant.PurchaseOrder_new);
	driver.navigate().refresh();
		POPayAdvPettyRecp PayAdvPttyRecp = PageFactory.initElements(driver, POPayAdvPettyRecp.class);
		PayAdvPttyRecp.PayAdvPttyRecp(suppID, prodID, Qnty, unitp, taxCode, Adv);
		BigDecimal Actual = new BigDecimal(POPayAdvPettyRecp.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");

		}

	@Test(priority = 9) 
	public void purchaseIN_Receive_AdvbyPtty_TC_12() throws Exception

	{
WebDriverCommonlib.waitForPageToLoad();
		 String suppID = POExcelLib.getExcelData("PO", 14, 8);
		 String prodID = POExcelLib.getExcelData("PO", 14, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 14, 17);
		 String unitp = POExcelLib.getExcelData("PO", 14, 21);
		 String Adv = POExcelLib.getExcelData("PO", 14, 29);
		 String taxCode = POExcelLib.getExcelData("PO", 14, 24);
		 String Total = POExcelLib.getExcelData("PO", 14, 39);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		 driver.get(Constant.PurchaseOrder_new);		
		 driver.navigate().refresh();
		 POPayAdvPettyCash PayAdvPtty = PageFactory.initElements(driver, POPayAdvPettyCash.class);
		 PayAdvPtty.PayAdvPtty(suppID, prodID,Qnty,unitp,taxCode,Adv);
		 BigDecimal Actual = new BigDecimal(POPayAdvPettyCash.amt);	
			Assert.assertEquals(Actual,expected,"total amount not correct");
			 System.out.println("total Amount verified");

	}
		@Test(priority =10)
		public void purchaseIN_Receive_Advbycheque_recv_TC_13() throws Exception
		{
			WebDriverCommonlib.waitForPageToLoad();
		 String suppID = POExcelLib.getExcelData("PO", 15, 8);
		 String prodID = POExcelLib.getExcelData("PO", 15, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 15, 17);
		 String unitp = POExcelLib.getExcelData("PO", 15, 21);
		 String Adv = POExcelLib.getExcelData("PO", 15, 29);
		 String taxCode = POExcelLib.getExcelData("PO", 15, 24);
		 String Total = POExcelLib.getExcelData("PO", 15, 39);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
			driver.get(Constant.PurchaseOrder_new);
			driver.navigate().refresh();
		POPayAdvChequeRecp RcvAdvCheque = PageFactory.initElements(driver, POPayAdvChequeRecp.class);
			RcvAdvCheque.RcvAdvChequeRecp(suppID, prodID, Qnty, unitp, taxCode,Adv, "@$#sh4y59fs");
			BigDecimal Actual = new BigDecimal(POPayAdvChequeRecp.amt);	
			Assert.assertEquals(Actual,expected,"total amount not correct");
			 System.out.println("total Amount verified");
		}
		
	@Test(priority=11)
	public void purchaseIN_Receive_Advbycheque_TC_14() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String suppID = POExcelLib.getExcelData("PO", 16, 8);
		 String prodID = POExcelLib.getExcelData("PO", 16, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 16, 17);
		 String unitp = POExcelLib.getExcelData("PO", 16, 21);
		 String Adv = POExcelLib.getExcelData("PO", 16, 29);
		 String taxCode = POExcelLib.getExcelData("PO", 16, 24);
		 String Total = POExcelLib.getExcelData("PO", 16, 39);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		POPayAdvCheque RcvAdvCheque = PageFactory.initElements(driver, POPayAdvCheque.class);
		RcvAdvCheque.RcvAdvcheque(suppID, prodID, Qnty, unitp, taxCode,Adv, "jldvn89%$");
		BigDecimal Actual = new BigDecimal(POPayAdvCheque.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}
	@Test(priority=12)
	public void purchaseIN_Receive_AdvbycashOn_TC_15() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String suppID = POExcelLib.getExcelData("PO", 17, 8);
		 String prodID = POExcelLib.getExcelData("PO", 17, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 17, 17);
		 String unitp = POExcelLib.getExcelData("PO", 17, 21);
		 String Adv = POExcelLib.getExcelData("PO", 17, 29);
		 String taxCode = POExcelLib.getExcelData("PO", 17, 24);
		 String Total = POExcelLib.getExcelData("PO", 17, 39);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		POPayAdvCashOnHand RcvAdvcashRecp = PageFactory.initElements(driver, POPayAdvCashOnHand.class);
		RcvAdvcashRecp.RcvAdvcashRecp(suppID, prodID, Qnty, unitp, taxCode,Adv);
		BigDecimal Actual = new BigDecimal(POPayAdvCashOnHand.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}

		@Test(priority =13)
		public void purchaseIN_MultiTax_TC_16() throws Exception

		{
			WebDriverCommonlib.waitForPageToLoad();
			 String suppID = POExcelLib.getExcelData("PO", 18, 8);
			 String prodID = POExcelLib.getExcelData("PO", 18, 14);
			 String Qnty = POExcelLib.getExcelData("PO", 18, 17);
			 String unitp = POExcelLib.getExcelData("PO", 18, 21);
			 String taxCode1= POExcelLib.getExcelData("PO", 18, 24);
			 String taxCode2 = POExcelLib.getExcelData("PO", 18, 25);
			 String Total = POExcelLib.getExcelData("PO", 18, 39);
			 BigDecimal expected = new BigDecimal(Total);
			 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
			driver.get(Constant.PurchaseOrder_new);
			driver.navigate().refresh();
			POProductMultipleTax prodMultiTax = PageFactory.initElements(driver, POProductMultipleTax.class);
			prodMultiTax.ProdMultiTax(suppID, prodID, Qnty, unitp,taxCode1,taxCode2, "Later");
			BigDecimal Actual = new BigDecimal(POProductMultipleTax.amt);	
			Assert.assertEquals(Actual,expected,"total amount not correct");
			 System.out.println("total Amount verified");
		}
		
		@Test(priority =14)
		public void purchaseIN_Tax_Discount_TC_17() throws Exception

		{
			WebDriverCommonlib.waitForPageToLoad();
			String suppID = POExcelLib.getExcelData("PO", 19, 8);
			 String prodID = POExcelLib.getExcelData("PO", 19, 14);
			 String Qnty = POExcelLib.getExcelData("PO", 19, 17);
			 String unitp = POExcelLib.getExcelData("PO", 19, 21);
			 String DIS = POExcelLib.getExcelData("PO", 19, 22);
			 String taxCode1= POExcelLib.getExcelData("PO", 19, 24);
			 String taxCode2 = POExcelLib.getExcelData("PO", 19, 25);
			 String Total = POExcelLib.getExcelData("PO", 19, 39);
			 BigDecimal expected = new BigDecimal(Total);
			 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
			driver.get(Constant.PurchaseOrder_new);
			driver.navigate().refresh();
			POProductTaxDiscount prodTaxDis = PageFactory.initElements(driver, POProductTaxDiscount.class);
			prodTaxDis.ProdTaxDis(suppID, prodID, Qnty,unitp ,DIS,taxCode1,taxCode2, "later");
			BigDecimal Actual = new BigDecimal(POProductTaxDiscount.amt);	
			Assert.assertEquals(Actual,expected,"total amount not correct");
			 System.out.println("total Amount verified");
	}
	@Test(priority=15)
	public void purchaseIN_withoutTax_TC_18() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String suppID = POExcelLib.getExcelData("PO", 20, 8);
		 String prodID = POExcelLib.getExcelData("PO", 20, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 20, 17);
		 String unitp = POExcelLib.getExcelData("PO", 20, 21);
		 String DIS = POExcelLib.getExcelData("PO", 20, 22);
		 String Total = POExcelLib.getExcelData("PO", 20, 39);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		PO_WithoutTax withoutTax = PageFactory.initElements(driver, PO_WithoutTax.class);
	withoutTax.ProdwithoutTax(suppID, prodID, Qnty,unitp,DIS);
	BigDecimal Actual = new BigDecimal(PO_WithoutTax.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
	}
	@Test(priority=16)
	public void purchaseIN_WithoutDiscount_TC_19() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String suppID = POExcelLib.getExcelData("PO", 21, 8);
		 String prodID = POExcelLib.getExcelData("PO", 21, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 21, 17);
		 String unitp = POExcelLib.getExcelData("PO", 21, 21);
		 String Total = POExcelLib.getExcelData("PO", 21, 39);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		PO_WithoutDiscount withoutDis = PageFactory.initElements(driver, PO_WithoutDiscount.class);
	withoutDis.withoutDiscount(suppID, prodID, Qnty,unitp);
	BigDecimal Actual = new BigDecimal(PO_WithoutDiscount.amt);	
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
	}

	@Test(priority=17)
	public void purchaseIN_InclusiveTax_TC_20() throws Exception

	{
		WebDriverCommonlib.waitForPageToLoad();
		String suppID = POExcelLib.getExcelData("PO", 22, 8);
		 String prodID = POExcelLib.getExcelData("PO", 22, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 22, 17);
		 String unitp = POExcelLib.getExcelData("PO", 22, 21);
		 String taxCode1= POExcelLib.getExcelData("PO", 22, 24);
		 String Dis = POExcelLib.getExcelData("PO", 22, 22);
		 String Total = POExcelLib.getExcelData("PO", 22, 39);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		POProductInclusiveTax prodIncluTax = PageFactory.initElements(driver, POProductInclusiveTax.class);
		prodIncluTax.ProdTaxIncl(suppID, prodID, Qnty,unitp,taxCode1,Dis);
		BigDecimal Actual = new BigDecimal(POProductInclusiveTax.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}

	@Test(priority=18)
	public void purchaseIN_Exclusive_Tax_TC_21() throws Exception 

	{
		WebDriverCommonlib.waitForPageToLoad();
		String suppID = POExcelLib.getExcelData("PO", 23, 8);
		 String prodID = POExcelLib.getExcelData("PO", 23, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 23, 17);
		 String unitp = POExcelLib.getExcelData("PO", 23, 21);
		  String taxCode1= POExcelLib.getExcelData("PO", 23, 24);
		  String Dis = POExcelLib.getExcelData("PO", 23, 22);
		  String Total = POExcelLib.getExcelData("PO", 23, 39);
			 BigDecimal expected = new BigDecimal(Total);
			 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		PO_TaxExclusive prodExcluTax = PageFactory.initElements(driver, PO_TaxExclusive.class);
		prodExcluTax.ProdTaxExcl(suppID, prodID, Qnty,unitp,Dis,taxCode1);
		BigDecimal Actual = new BigDecimal(PO_TaxExclusive.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}
		@Test(priority =19)
		public void purchaseIN_CreditTerm_TC_24() throws Exception
		{
			WebDriverCommonlib.waitForPageToLoad();
			 String suppID = POExcelLib.getExcelData("PO", 26, 8);
			 String CreditTerm = POExcelLib.getExcelData("PO", 26, 10);
			 String prodID = POExcelLib.getExcelData("PO", 26, 14);
			 String Qnty = POExcelLib.getExcelData("PO", 26, 17);
			 String unitp = POExcelLib.getExcelData("PO", 26, 21);
			 String taxCode  = POExcelLib.getExcelData("PO", 26, 24);
			 String Total = POExcelLib.getExcelData("PO", 26, 39);
			 BigDecimal expected = new BigDecimal(Total);
			 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
			driver.get(Constant.PurchaseOrder_new);
			driver.navigate().refresh();
			PO_WithCreditTerm PoWCrdTerm =PageFactory.initElements(driver, PO_WithCreditTerm.class);
			PoWCrdTerm.PoWithCrdTerm(suppID, CreditTerm, prodID, Qnty, unitp,taxCode);
			BigDecimal Actual = new BigDecimal(PO_WithCreditTerm.amt);	
			Assert.assertEquals(Actual,expected,"total amount not correct");
			 System.out.println("total Amount verified");
		}
		
	@Test(priority =20)
	public void purchaseIN_RecvByAir_TC_25() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
	String suppID = POExcelLib.getExcelData("PO",28, 8);
		 String prodID = POExcelLib.getExcelData("PO", 28, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 28, 17);
		 String unitp = POExcelLib.getExcelData("PO", 28, 21);
		 String taxCode = POExcelLib.getExcelData("PO", 28, 24);
		 String Total = POExcelLib.getExcelData("PO", 28, 39);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
			driver.navigate().refresh();
			PO_RecieptByAir ShpByAir = PageFactory.initElements(driver,PO_RecieptByAir.class);
	         ShpByAir.ShpByAir(suppID, prodID, Qnty,unitp,taxCode);
	         BigDecimal Actual = new BigDecimal(PO_RecieptByAir.amt);	
				Assert.assertEquals(Actual,expected,"total amount not correct");
				 System.out.println("total Amount verified");
	}
	@Test(priority = 21)
	public void purchaseIN_CashDiscount_Percentage_TC_26() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String suppID = POExcelLib.getExcelData("PO", 28, 8);
		 String prodID = POExcelLib.getExcelData("PO", 28, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 28, 17);
		 String unitp = POExcelLib.getExcelData("PO", 28, 21);
		 String DIS = POExcelLib.getExcelData("PO", 28, 27);
		 String taxCode = POExcelLib.getExcelData("PO", 28, 24);
		 String Total = POExcelLib.getExcelData("PO", 28, 39);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		PoDiscountWithpercentage mstrDis = PageFactory.initElements(driver, PoDiscountWithpercentage.class);
		mstrDis.PoWithDis(suppID,  prodID, Qnty,unitp, taxCode,DIS);
		 BigDecimal Actual = new BigDecimal(PoDiscountWithpercentage.amt);	
			Assert.assertEquals(Actual,expected,"total amount not correct");
			 System.out.println("total Amount verified");
	}
	
	@Test(priority = 22)
	public void purchaseIn_CashDiscount_INR_TC_27() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String suppID = POExcelLib.getExcelData("PO", 29, 8);
		 String prodID = POExcelLib.getExcelData("PO", 29, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 29, 17);
		 String unitp = POExcelLib.getExcelData("PO", 29, 21);
		 String DIS = POExcelLib.getExcelData("PO", 29, 27);
		 String taxCode = POExcelLib.getExcelData("PO", 29, 24);
		 String Total = POExcelLib.getExcelData("PO", 29, 39);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		PoDiscountWithCash mstrDis = PageFactory.initElements(driver, PoDiscountWithCash.class);
		mstrDis.PoWithDis(suppID,  prodID, Qnty,unitp, taxCode,DIS);
		BigDecimal Actual = new BigDecimal(PoDiscountWithCash.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}
	
	@Test(priority = 23)
	public void purchaseIn_TradeDiscount_TC_28() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String suppID = POExcelLib.getExcelData("PO", 30, 8);
		 String prodID = POExcelLib.getExcelData("PO", 30, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 30, 17);
		 String unitp = POExcelLib.getExcelData("PO", 30, 21);
		 String DIS = POExcelLib.getExcelData("PO", 30, 27);
		 String taxCode = POExcelLib.getExcelData("PO", 30, 24);
		 String Total = POExcelLib.getExcelData("PO", 30, 39);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		PO_TradeDiscount mstrDis = PageFactory.initElements(driver, PO_TradeDiscount.class);
		mstrDis.PoWithDis(suppID,prodID, Qnty,unitp, taxCode,DIS);
		BigDecimal Actual = new BigDecimal(PO_TradeDiscount.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}
	
	@Test(priority = 24)
	public void purchaseIN_purchaseTax_TC_29() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String suppID = POExcelLib.getExcelData("PO", 31, 8);
		 String prodID = POExcelLib.getExcelData("PO", 31, 14);
		 String cstEdt = POExcelLib.getExcelData("PO", 31, 12);
		 String cstCode = POExcelLib.getExcelData("PO", 31, 33);
		 String Qnty = POExcelLib.getExcelData("PO", 31, 17);
		 String unitp = POExcelLib.getExcelData("PO", 31, 21);
		 String taxCode = POExcelLib.getExcelData("PO", 31, 24);
		 String Total = POExcelLib.getExcelData("PO", 31, 39);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		PO_WithCSTtax mstrDis = PageFactory.initElements(driver, PO_WithCSTtax.class);
		mstrDis.ProdTaxExcl(suppID,prodID,cstEdt, Qnty,unitp,taxCode,cstCode);
		BigDecimal Actual = new BigDecimal(PO_WithCSTtax.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}
	
	@Test(priority =25)
	public void purchaseIN_TDSWith_OtherTax_TC_30() throws Exception

	{
		WebDriverCommonlib.waitForPageToLoad();
		 String suppID = POExcelLib.getExcelData("PO", 32, 8);
		 String prodID = POExcelLib.getExcelData("PO", 32, 14);
		 String Qnty = POExcelLib.getExcelData("PO", 32, 17);
		 String unitp = POExcelLib.getExcelData("PO", 32, 21);
		 String taxCode1= POExcelLib.getExcelData("PO", 32, 24);
		 String taxCode2 = POExcelLib.getExcelData("PO", 32, 25);
	 driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		PO_TaxWithTDS prodMultiTax = PageFactory.initElements(driver, PO_TaxWithTDS.class);
		prodMultiTax.ProdTaxWithTDS(suppID, prodID, Qnty, unitp,taxCode1,taxCode2);
		
	}

	@Test(priority = 26)
	public void purchaseIN_MUOM_TC_31() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String suppID = POExcelLib.getExcelData("PO", 33, 8);
		 String prodID = POExcelLib.getExcelData("PO", 33, 14);
		 String primQty = POExcelLib.getExcelData("PO", 33, 17);
		 String secUOM = POExcelLib.getExcelData("PO", 33, 18);
		 String secQty = POExcelLib.getExcelData("PO", 33, 20);
		 String unitp = POExcelLib.getExcelData("PO", 33, 21);
		 String taxCode = POExcelLib.getExcelData("PO", 33, 24);
		 String Total = POExcelLib.getExcelData("PO", 33, 39);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
			driver.get(Constant.PurchaseOrder_new);
			driver.navigate().refresh();
			POMUOMProduct muomprod =PageFactory.initElements(driver, POMUOMProduct.class);
			muomprod.muomprod(suppID, prodID, secUOM, secQty, primQty, unitp, taxCode);
			BigDecimal Actual = new BigDecimal(POMUOMProduct.amt);	
			Assert.assertEquals(Actual,expected,"total amount not correct");
			 System.out.println("total Amount verified");
	}
	@Test(priority=27)
	public void purchaseIN_BatchableItem_TC_32() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String suppID = POExcelLib.getExcelData("PO", 34, 8);
		 String prodID = POExcelLib.getExcelData("PO", 34, 14);
		 String batchNO = POExcelLib.getExcelData("PO", 34, 19);
		 String Qnty = POExcelLib.getExcelData("PO", 34, 17);
		 String unitp = POExcelLib.getExcelData("PO", 34, 21);
		 String taxCode = POExcelLib.getExcelData("PO", 34, 24);
		 String Total = POExcelLib.getExcelData("PO", 34, 39);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		 driver.get(Constant.PurchaseOrder_new);
			driver.navigate().refresh();
			PO_BatchableItem Batch = PageFactory.initElements(driver, PO_BatchableItem.class);
			Batch.batchableprod(suppID, prodID,batchNO, Qnty, unitp, taxCode);
			BigDecimal Actual = new BigDecimal(PO_BatchableItem.amt);	
			Assert.assertEquals(Actual,expected,"total amount not correct");
			 System.out.println("total Amount verified");
	}
	
	@Test(priority=28)
	public void purchaseIN_MUOM_Batchableitem_TC_33() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String suppID = POExcelLib.getExcelData("PO", 35, 8);
		 String prodID = POExcelLib.getExcelData("PO", 35, 14);
		 String batchNO = POExcelLib.getExcelData("PO", 35, 19);
		 String primQty = POExcelLib.getExcelData("PO", 35, 17);
		 String secUOM = POExcelLib.getExcelData("PO", 35, 18);
		 String secQty = POExcelLib.getExcelData("PO", 35, 20);
		 String unitp = POExcelLib.getExcelData("PO", 35, 21);
		 String taxCode = POExcelLib.getExcelData("PO", 35, 24);
		 String Total = POExcelLib.getExcelData("PO", 35, 39);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		 driver.get(Constant.PurchaseOrder_new);
			driver.navigate().refresh();
			PO_BatchMUOMProduct Batch = PageFactory.initElements(driver, PO_BatchMUOMProduct.class);
			Batch.muomBatchprod(suppID, prodID, batchNO, secUOM, secQty, primQty, unitp, taxCode);
			BigDecimal Actual = new BigDecimal(PO_BatchMUOMProduct.amt);	
			Assert.assertEquals(Actual,expected,"total amount not correct");
			 System.out.println("total Amount verified");
	}	
			
	@Test(priority=29)
	public void purchaseIN_BlankPo_TC_34() throws InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		POBlankPageSaving BlPgS = PageFactory.initElements(driver, POBlankPageSaving.class);
		BlPgS.Blank_PageSaving();
		
	}
	
	@Test(priority=30)
	public void purchaseIN_BlankDETlevel_TC35() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String suppID = POExcelLib.getExcelData("PO", 37, 8);
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		PO_WithoutDETline PoWithoutDET = PageFactory.initElements(driver, PO_WithoutDETline.class);
		PoWithoutDET.PoDETerr(suppID);
		
	}
	
	@Test(priority=31)
	public void purchaseIN_Memo_Length_TC36() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String suppID = POExcelLib.getExcelData("PO", 38, 8);
		String prdID = POExcelLib.getExcelData("PO", 38, 14);
		String qty = POExcelLib.getExcelData("PO", 38, 17);
		String unitP = POExcelLib.getExcelData("PO", 38, 21);
		String taxCode = POExcelLib.getExcelData("PO", 38, 24);
		String payType = POExcelLib.getExcelData("PO", 38, 28);
		String memo = POExcelLib.getExcelData("PO", 38, 36);
		String Total = POExcelLib.getExcelData("PO", 39, 39);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		PO_WithMemoFieldLength PoMemo = PageFactory.initElements(driver, PO_WithMemoFieldLength.class);
		PoMemo.poWithMemo(suppID, prdID, qty, unitP, taxCode, payType,memo);
		BigDecimal Actual = new BigDecimal(PO_WithMemoFieldLength.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}
	
	@Test(priority=32)
	public void purchaseIN_TC_Length_TC37() throws Exception
	{
	WebDriverCommonlib.waitForPageToLoad();
		//Required Data for test case.
		String suppID = POExcelLib.getExcelData("PO", 39, 8);
		String prdID = POExcelLib.getExcelData("PO", 39, 14);
		String qty = POExcelLib.getExcelData("PO", 39, 17);
		String unitP = POExcelLib.getExcelData("PO", 39, 21);
		String taxCode = POExcelLib.getExcelData("PO", 39, 24);
		String payType = POExcelLib.getExcelData("PO", 39, 28);
		String tc = POExcelLib.getExcelData("PO", 39, 37);
		String Total = POExcelLib.getExcelData("PO", 39, 39);
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.PurchaseOrder_new);
		driver.navigate().refresh();
		PO_WithTandCFieldLength PoWithTC = PageFactory.initElements(driver, PO_WithTandCFieldLength.class);
		PoWithTC.PoWithTC(suppID, prdID, qty, unitP, taxCode, payType,tc);
		BigDecimal Actual = new BigDecimal(PO_WithTandCFieldLength.amt);	
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
		
	}
	
	
	
}

