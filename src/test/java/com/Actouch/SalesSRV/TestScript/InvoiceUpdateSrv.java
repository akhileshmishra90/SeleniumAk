package com.Actouch.SalesSRV.TestScript;


import java.math.BigDecimal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.SO_Excellib;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
import com.Actouch.SalesINVLoc.pageObjectRepository.Login;
import com.Actouch.SalesSRV.pageObjectRepository.SRVPaymentlaterDlv;
import com.Actouch.SalesSRV.pageObjectRepository.UPSRVCategory;
import com.Actouch.SalesSRV.pageObjectRepository.UPSRVCreditTerm;
import com.Actouch.SalesSRV.pageObjectRepository.UPSRVCustID;
import com.Actouch.SalesSRV.pageObjectRepository.UPSRVDesc;
import com.Actouch.SalesSRV.pageObjectRepository.UPSRVDiscountINR;
import com.Actouch.SalesSRV.pageObjectRepository.UPSRVDiscountPer;
import com.Actouch.SalesSRV.pageObjectRepository.UPSRVLineDis;
import com.Actouch.SalesSRV.pageObjectRepository.UPSRVMemo;
import com.Actouch.SalesSRV.pageObjectRepository.UPSRVPrice;
import com.Actouch.SalesSRV.pageObjectRepository.UPSRVReference;
import com.Actouch.SalesSRV.pageObjectRepository.UPSRVRoundoff;
import com.Actouch.SalesSRV.pageObjectRepository.UPSRVSalesPerson;
import com.Actouch.SalesSRV.pageObjectRepository.UPSRVShipAddress;
import com.Actouch.SalesSRV.pageObjectRepository.UPSRVTax;
import com.Actouch.SalesSRV.pageObjectRepository.UPSRVTermCond;

public class InvoiceUpdateSrv {

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
	public void UPSRV_updateCustID_TC_2() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String Cust = SO_Excellib.getExcelDat("SOSRV",05, 9);
		String Desc =SO_Excellib.getExcelDat("SOSRV",05, 12);
		String Category = SO_Excellib.getExcelDat("SOSRV",05, 13);
		String Price = SO_Excellib.getExcelDat("SOSRV",05, 14);
		String Total = SO_Excellib.getExcelDat("SOSRV",05, 25);
		String UpCust = SO_Excellib.getExcelDat("UPSRV", 04, 05);
		BigDecimal expected =new BigDecimal(Total);
		expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesService);
		driver.navigate().refresh();
				SRVPaymentlaterDlv payltrDl=PageFactory.initElements(driver, SRVPaymentlaterDlv.class);
		payltrDl.payLtrDlv(Cust,Desc, Category, Price,"Yes");
	    UPSRVCustID UPSC= PageFactory.initElements(driver, UPSRVCustID.class);
	    UPSC.upadateCust(UpCust);
	}
   @Test(priority=3)
        public void UPSRV_updateReference_TC_3() throws Exception
       {
	   String Cust = SO_Excellib.getExcelDat("SOSRV",05, 9);
		String Desc =SO_Excellib.getExcelDat("SOSRV",05, 12);
		String Category = SO_Excellib.getExcelDat("SOSRV",05, 13);
		String Price = SO_Excellib.getExcelDat("SOSRV",05, 14);
		String Total = SO_Excellib.getExcelDat("SOSRV",05, 25);
		String Refernce = SO_Excellib.getExcelDat("UPSRV", 05, 06);
		String RefAmt = SO_Excellib.getExcelDat("UPSRV", 06, 06);
		BigDecimal expected =new BigDecimal(Total);
		expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesService);
		driver.navigate().refresh();
				SRVPaymentlaterDlv payltrDl=PageFactory.initElements(driver, SRVPaymentlaterDlv.class);
		payltrDl.payLtrDlv(Cust,Desc, Category, Price,"Yes");
		UPSRVReference UPSR = PageFactory.initElements(driver, UPSRVReference.class);
		UPSR.upadateCust(Refernce, RefAmt);
	
        }
   @Test(priority=4)
   public void UPSRV_updateCreditTerm_TC_4() throws Exception
   {
	   String Cust = SO_Excellib.getExcelDat("SOSRV",05, 9);
		String Desc =SO_Excellib.getExcelDat("SOSRV",05, 12);
		String Category = SO_Excellib.getExcelDat("SOSRV",05, 13);
		String Price = SO_Excellib.getExcelDat("SOSRV",05, 14);
		String Total = SO_Excellib.getExcelDat("SOSRV",05, 25);
		String Credit = SO_Excellib.getExcelDat("UPSRV", 06, 07);
		BigDecimal expected =new BigDecimal(Total);
		expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesService);
		driver.navigate().refresh();
				SRVPaymentlaterDlv payltrDl=PageFactory.initElements(driver, SRVPaymentlaterDlv.class);
		payltrDl.payLtrDlv(Cust,Desc, Category, Price,"Yes");
		UPSRVCreditTerm UPSCT = PageFactory.initElements(driver, UPSRVCreditTerm.class);
		UPSCT.upadateCust(Credit);
   }
     @Test(priority=5)
     public void UPSRV_updateShipAddress_TC_5() throws Exception
     { 
    	 String Cust = SO_Excellib.getExcelDat("SOSRV",05, 9);
		String Desc =SO_Excellib.getExcelDat("SOSRV",05, 12);
		String Category = SO_Excellib.getExcelDat("SOSRV",05, 13);
		String Price = SO_Excellib.getExcelDat("SOSRV",05, 14);
		String Total = SO_Excellib.getExcelDat("SOSRV",05, 25);
		String ShipAdd = SO_Excellib.getExcelDat("UPSRV", 07, 8);
		BigDecimal expected =new BigDecimal(Total);
		expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesService);
		driver.navigate().refresh();
				SRVPaymentlaterDlv payltrDl=PageFactory.initElements(driver, SRVPaymentlaterDlv.class);
		payltrDl.payLtrDlv(Cust,Desc, Category, Price,"Yes");
		UPSRVShipAddress UPSSA = PageFactory.initElements(driver, UPSRVShipAddress.class);
	     UPSSA.upadateCust(ShipAdd);
    	 
     }
@Test(priority=6)
public void UPSRV_updateSalePerson_TC_6() throws Exception
{
	 String Cust = SO_Excellib.getExcelDat("SOSRV",05, 9);
		String Desc =SO_Excellib.getExcelDat("SOSRV",05, 12);
		String Category = SO_Excellib.getExcelDat("SOSRV",05, 13);
		String Price = SO_Excellib.getExcelDat("SOSRV",05, 14);
		String Total = SO_Excellib.getExcelDat("SOSRV",05, 25);
		String SalesPerson = SO_Excellib.getExcelDat("UPSRV", 8, 9);
		BigDecimal expected =new BigDecimal(Total);
		expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesService);
		driver.navigate().refresh();
				SRVPaymentlaterDlv payltrDl=PageFactory.initElements(driver, SRVPaymentlaterDlv.class);
		payltrDl.payLtrDlv(Cust,Desc, Category, Price,"Yes");
		UPSRVSalesPerson UPSSP = PageFactory.initElements(driver, UPSRVSalesPerson.class);
		UPSSP.upadateCust(SalesPerson);
}
@Test(priority=7)
public void UPSRV_updateDescription_TC_7() throws Exception
{
	String Cust = SO_Excellib.getExcelDat("SOSRV",05, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",05, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",05, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",05, 14);
	String Total = SO_Excellib.getExcelDat("SOSRV",05, 25);
	String Service = SO_Excellib.getExcelDat("UPSRV", 9, 10);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
			SRVPaymentlaterDlv payltrDl=PageFactory.initElements(driver, SRVPaymentlaterDlv.class);
	payltrDl.payLtrDlv(Cust,Desc, Category, Price,"Yes");
	UPSRVDesc UPSD = PageFactory.initElements(driver, UPSRVDesc.class);
	UPSD.upadateCust(Service);
}

@Test(priority=8)
public void UPSRV_updateCategory_TC_8() throws Exception
{
	String Cust = SO_Excellib.getExcelDat("SOSRV",05, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",05, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",05, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",05, 14);
	String Total = SO_Excellib.getExcelDat("SOSRV",05, 25);
	String UpCategory = SO_Excellib.getExcelDat("UPSRV", 10, 11);
	String UpPrice = SO_Excellib.getExcelDat("UPSRV", 10, 12);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
			SRVPaymentlaterDlv payltrDl=PageFactory.initElements(driver, SRVPaymentlaterDlv.class);
	payltrDl.payLtrDlv(Cust,Desc, Category, Price,"Yes");
	UPSRVCategory UPSC = PageFactory.initElements(driver, UPSRVCategory.class);
	UPSC.upadateCust(UpCategory,UpPrice);
}
@Test(priority=9)
public void UPSRV_updateServicePrice_TC_9() throws Exception
{
	String Cust = SO_Excellib.getExcelDat("SOSRV",05, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",05, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",05, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",05, 14);
	String Total = SO_Excellib.getExcelDat("SOSRV",05, 25);
	String UpPrice = SO_Excellib.getExcelDat("UPSRV", 11, 12);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
			SRVPaymentlaterDlv payltrDl=PageFactory.initElements(driver, SRVPaymentlaterDlv.class);
	payltrDl.payLtrDlv(Cust,Desc, Category, Price,"Yes");
	UPSRVPrice UPSP =PageFactory.initElements(driver, UPSRVPrice.class);
	UPSP.upadateCust(UpPrice);
}
@Test(priority=10)
public void UPSRV_updateLineDiscount_TC_10() throws Exception
{
	String Cust = SO_Excellib.getExcelDat("SOSRV",05, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",05, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",05, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",05, 14);
	String Total = SO_Excellib.getExcelDat("SOSRV",05, 25);
	String LineDis = SO_Excellib.getExcelDat("UPSRV", 12, 13);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
			SRVPaymentlaterDlv payltrDl=PageFactory.initElements(driver, SRVPaymentlaterDlv.class);
	payltrDl.payLtrDlv(Cust,Desc, Category, Price,"Yes");
	UPSRVLineDis UPSLD =PageFactory.initElements(driver, UPSRVLineDis.class);
	UPSLD.upadateCust(LineDis);
}
@Test(priority=11)
public void UPSRV_updateTax_TC_11() throws Exception
{
	String Cust = SO_Excellib.getExcelDat("SOSRV",05, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",05, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",05, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",05, 14);
	String Total = SO_Excellib.getExcelDat("SOSRV",05, 25);
	String UPTax = SO_Excellib.getExcelDat("UPSRV", 13, 14);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
     SRVPaymentlaterDlv payltrDl=PageFactory.initElements(driver, SRVPaymentlaterDlv.class);
	payltrDl.payLtrDlv(Cust,Desc, Category, Price,"Yes");
	UPSRVTax UPST=PageFactory.initElements(driver, UPSRVTax.class);
	UPST.upadateCust(UPTax);
}
@Test(priority=12)
public void UPSRV_updateTermCondition_TC_12() throws Exception
{
	String Cust = SO_Excellib.getExcelDat("SOSRV",05, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",05, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",05, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",05, 14);
	String Total = SO_Excellib.getExcelDat("SOSRV",05, 25);
	String UPTermCFondi = SO_Excellib.getExcelDat("UPSRV", 14, 15);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
     SRVPaymentlaterDlv payltrDl=PageFactory.initElements(driver, SRVPaymentlaterDlv.class);
	payltrDl.payLtrDlv(Cust,Desc, Category, Price,"Yes");
	UPSRVTermCond UPSTC = PageFactory.initElements(driver, UPSRVTermCond.class);
	UPSTC.upadateCust(UPTermCFondi);
}

@Test(priority=13)
public void UPSRV_updateMemo_TC_13() throws Exception
{
	String Cust = SO_Excellib.getExcelDat("SOSRV",05, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",05, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",05, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",05, 14);
	String Total = SO_Excellib.getExcelDat("SOSRV",05, 25);
	String UPMemo = SO_Excellib.getExcelDat("UPSRV", 15, 16);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
     SRVPaymentlaterDlv payltrDl=PageFactory.initElements(driver, SRVPaymentlaterDlv.class);
	payltrDl.payLtrDlv(Cust,Desc, Category, Price,"Yes");
	UPSRVMemo UPSMemo = PageFactory.initElements(driver, UPSRVMemo.class);
	UPSMemo.upadateCust(UPMemo);
}
@Test(priority=14)
public void UPSRV_updateDiscountPer_TC_14() throws Exception
{
	String Cust = SO_Excellib.getExcelDat("SOSRV",05, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",05, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",05, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",05, 14);
	String Total = SO_Excellib.getExcelDat("SOSRV",05, 25);
	String UPDisPer = SO_Excellib.getExcelDat("UPSRV", 16, 13);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
     SRVPaymentlaterDlv payltrDl=PageFactory.initElements(driver, SRVPaymentlaterDlv.class);
	payltrDl.payLtrDlv(Cust,Desc, Category, Price,"Yes");
	UPSRVDiscountPer UPSDP = PageFactory.initElements(driver, UPSRVDiscountPer.class);
	UPSDP.upadateCust(UPDisPer);
}
@Test(priority = 15)
public void UPSRV_updateDiscountINR_TC_15() throws Exception
{
	String Cust = SO_Excellib.getExcelDat("SOSRV",05, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",05, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",05, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",05, 14);
	String Total = SO_Excellib.getExcelDat("SOSRV",05, 25);
	String UPDisINR = SO_Excellib.getExcelDat("UPSRV", 17, 13);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
     SRVPaymentlaterDlv payltrDl=PageFactory.initElements(driver, SRVPaymentlaterDlv.class);
	payltrDl.payLtrDlv(Cust,Desc, Category, Price,"Yes");
	UPSRVDiscountINR UPSDI = PageFactory.initElements(driver, UPSRVDiscountINR.class);
	UPSDI.upadateCust(UPDisINR);
}
@Test(priority=16)
public void UPSRV_updateRoundOff_TC_16() throws Exception
{
	String Cust = SO_Excellib.getExcelDat("SOSRV",05, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",05, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",05, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",05, 14);
	String Total = SO_Excellib.getExcelDat("SOSRV",05, 25);
	String UPRoundOff = SO_Excellib.getExcelDat("UPSRV", 18, 17);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2,BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
     SRVPaymentlaterDlv payltrDl=PageFactory.initElements(driver, SRVPaymentlaterDlv.class);
	payltrDl.payLtrDlv(Cust,Desc, Category, Price,"Yes");
	UPSRVRoundoff UPSRF = PageFactory.initElements(driver, UPSRVRoundoff.class);
	UPSRF.upadateCust(UPRoundOff);
}
}
