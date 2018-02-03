package com.Actouch.SalesSRV.TestScript;

import java.io.IOException;
import java.math.BigDecimal;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.SO_Excellib;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
import com.Actouch.SalesINVLoc.pageObjectRepository.Login;
import com.Actouch.SalesSRV.pageObjectRepository.DLVDeliveryChallen;
import com.Actouch.SalesSRV.pageObjectRepository.DLVDiscountINR;
import com.Actouch.SalesSRV.pageObjectRepository.DLVDiscountPer;
import com.Actouch.SalesSRV.pageObjectRepository.DLVFull;
import com.Actouch.SalesSRV.pageObjectRepository.DLVFullTax;
import com.Actouch.SalesSRV.pageObjectRepository.DLVMemo;
import com.Actouch.SalesSRV.pageObjectRepository.DLVPartial;
import com.Actouch.SalesSRV.pageObjectRepository.DLVPartialTax;
import com.Actouch.SalesSRV.pageObjectRepository.DLVReference;
import com.Actouch.SalesSRV.pageObjectRepository.DLVRoundOff;
import com.Actouch.SalesSRV.pageObjectRepository.DLVSalesPerson;
import com.Actouch.SalesSRV.pageObjectRepository.DLVValidateCustomer;
import com.Actouch.SalesSRV.pageObjectRepository.DLVValidateSO;
import com.Actouch.SalesSRV.pageObjectRepository.DlVTermCondition;
import com.Actouch.SalesSRV.pageObjectRepository.SRVPaymentLater;

public class DeliverService {
	static WebDriver driver;
	SO_Excellib SO_Excellib = new SO_Excellib("D:\\Selenium\\SO Service .xlsx");
	
	
	@Test(priority=1)
	public void salesIN_Login_TC_1() throws Exception, InvalidFormatException, IOException 
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
	public void Dlv_Vldt_Customer_TC_2() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String Cust = SO_Excellib.getExcelDat("SOSRV",04, 9);
		String Desc = SO_Excellib.getExcelDat("SOSRV",04, 12);
		String Category = SO_Excellib.getExcelDat("SOSRV",04, 13);
		String Price = SO_Excellib.getExcelDat("SOSRV",04, 14);
		String Total = SO_Excellib.getExcelDat("DLV",06, 17);
		BigDecimal expected =new BigDecimal(Total);
		expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesService);
		driver.navigate().refresh();
		SRVPaymentLater paymentLtr = PageFactory.initElements(driver, SRVPaymentLater.class);
		paymentLtr.payLtr(Cust,Desc, Category, Price);
		DLVValidateCustomer Customer = PageFactory.initElements(driver, DLVValidateCustomer.class);
		Customer.CustomerValidate();
				
		}
@Test(priority=3)
public void Dlv_Vldt_So_TC_3() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",04, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",04, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",04, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",04, 14);
	String Total = SO_Excellib.getExcelDat("DLV",7, 17);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVPaymentLater paymentLtr = PageFactory.initElements(driver, SRVPaymentLater.class);
	paymentLtr.payLtr(Cust,Desc, Category, Price);
	DLVValidateSO SO = PageFactory.initElements(driver, DLVValidateSO.class);
	SO.SoValidate();
}

	@Test(priority =4)
	public void Dlv_partial_TC_4() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String Cust = SO_Excellib.getExcelDat("SOSRV",04, 9);
		String Desc =SO_Excellib.getExcelDat("SOSRV",04, 12);
		String Category = SO_Excellib.getExcelDat("SOSRV",04, 13);
		String Price = SO_Excellib.getExcelDat("SOSRV",04, 14);
		String Total = SO_Excellib.getExcelDat("DLV",8, 17);
		String PartialQnty = SO_Excellib.getExcelDat("DLV",8,7);
		BigDecimal expected =new BigDecimal(Total);
		expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesService);
		driver.navigate().refresh();
		SRVPaymentLater paymentLtr = PageFactory.initElements(driver, SRVPaymentLater.class);
		paymentLtr.payLtr(Cust,Desc, Category, Price);
		DLVPartial PartialDlv = PageFactory.initElements(driver, DLVPartial.class);
		PartialDlv.PartialServ(PartialQnty);
		BigDecimal Actaul =new BigDecimal(DLVPartial.amt);
		Assert.assertEquals(Actaul, expected,"Total Amount isn't correct");
		System.out.println("Total Amount is correct");
		
	}

	@Test(priority=5)
	public void Dlv_Full_TC_5()throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String Cust = SO_Excellib.getExcelDat("SOSRV",04, 9);
		String Desc =SO_Excellib.getExcelDat("SOSRV",04, 12);
		String Category = SO_Excellib.getExcelDat ("SOSRV",04, 13);
		String Price = SO_Excellib.getExcelDat("SOSRV",04, 14);
		String Total = SO_Excellib.getExcelDat("DLV",9, 17);
		BigDecimal expected =new BigDecimal(Total);
		expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesService);
		driver.navigate().refresh();
		SRVPaymentLater paymentLtr = PageFactory.initElements(driver, SRVPaymentLater.class);
		paymentLtr.payLtr(Cust,Desc, Category, Price);
			DLVFull fullDlv = PageFactory.initElements(driver, DLVFull.class);
		fullDlv.FullServ();
		BigDecimal Actaul =new BigDecimal(DLVFull.amt);
		Assert.assertEquals(Actaul, expected,"Total Amount isn't correct");
		System.out.println("Total Amount is correct");

}
	@Test(priority=6)
	public void Dlv_partial_Tax_TC_6() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String Cust = SO_Excellib.getExcelDat("SOSRV",04, 9);
		String Desc =SO_Excellib.getExcelDat("SOSRV",04, 12);
		String Category = SO_Excellib.getExcelDat("SOSRV",04, 13);
		String Price = SO_Excellib.getExcelDat("SOSRV",04, 14);
		String Total = SO_Excellib.getExcelDat("DLV",10, 17);
		String Partial = SO_Excellib.getExcelDat("DLV",10, 7);
		String Tax = SO_Excellib.getExcelDat("DLV",10, 8);
		BigDecimal expected =new BigDecimal(Total);
		expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesService);
		driver.navigate().refresh();
		SRVPaymentLater paymentLtr = PageFactory.initElements(driver, SRVPaymentLater.class);
		paymentLtr.payLtr(Cust,Desc, Category, Price);
		DLVPartialTax PartialTax=PageFactory.initElements(driver, DLVPartialTax.class);
		PartialTax.PartialServ(Partial, Tax);
		BigDecimal Actaul =new BigDecimal(DLVPartialTax.amt);
		Assert.assertEquals(Actaul, expected,"Total Amount isn't correct");
		System.out.println("Total Amount is correct");
	}

	@Test(priority=7)
	public void Dlv_Full_Tax_TC_7() throws Exception
	{
	WebDriverCommonlib.waitForPageToLoad();
		String Cust = SO_Excellib.getExcelDat("SOSRV",04, 9);
		String Desc =SO_Excellib.getExcelDat("SOSRV",04, 12);
		String Category = SO_Excellib.getExcelDat("SOSRV",04, 13);
		String Price = SO_Excellib.getExcelDat("SOSRV",04, 14);
		String Total = SO_Excellib.getExcelDat("DLV",11, 17);
		String TAx = SO_Excellib.getExcelDat("DLV",11, 8);
		BigDecimal expected =new BigDecimal(Total);
		expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesService);
		driver.navigate().refresh();
		SRVPaymentLater paymentLtr = PageFactory.initElements(driver, SRVPaymentLater.class);
		paymentLtr.payLtr(Cust,Desc, Category, Price);
		DLVFullTax FullTax =PageFactory.initElements(driver, DLVFullTax.class);
		FullTax.FullServ(TAx);
		BigDecimal Actaul =new BigDecimal(DLVFullTax.amt);
		Assert.assertEquals(Actaul, expected,"Total Amount isn't correct");
		System.out.println("Total Amount is correct");
	}
@Test(priority=8)
public void Dlv_DiliveryChallan_TC_8() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",04, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",04, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",04, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",04, 14);
	String Total = SO_Excellib.getExcelDat("DLV",12, 17);
	String Delivery = SO_Excellib.getExcelDat("DLV",12, 9);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVPaymentLater paymentLtr = PageFactory.initElements(driver, SRVPaymentLater.class);
	paymentLtr.payLtr(Cust,Desc, Category, Price);
	DLVDeliveryChallen DC = PageFactory.initElements(driver, DLVDeliveryChallen.class);
	DC.FullServ(Delivery);
	BigDecimal Actaul =new BigDecimal(DLVDeliveryChallen.amt);
	Assert.assertEquals(Actaul, expected,"Total Amount isn't correct");
	System.out.println("Total Amount is correct");
}
@Test(priority=9)
public void Dlv_Cash_DisPer_TC_9() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",04, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",04, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",04, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",04, 14);
	String Total = SO_Excellib.getExcelDat("DLV",13, 17);
	String Dis = SO_Excellib.getExcelDat("DLV",13, 10);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVPaymentLater paymentLtr = PageFactory.initElements(driver, SRVPaymentLater.class);
	paymentLtr.payLtr(Cust,Desc, Category, Price);
	DLVDiscountPer Disper = PageFactory.initElements(driver, DLVDiscountPer.class);
	Disper.FullServ(Dis);
	BigDecimal Actaul =new BigDecimal(DLVDiscountPer.amt);
	Assert.assertEquals(Actaul, expected,"Total Amount isn't correct");
	System.out.println("Total Amount is correct");
}
@Test(priority =10)
public void Dlv_cash_DisINR_TC_10() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",04, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",04, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",04, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",04, 14);
	String Total = SO_Excellib.getExcelDat("DLV",14, 17);
	String Dis = SO_Excellib.getExcelDat("DLV",14, 10);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVPaymentLater paymentLtr = PageFactory.initElements(driver, SRVPaymentLater.class);
	paymentLtr.payLtr(Cust,Desc, Category, Price);
	DLVDiscountINR DisINR = PageFactory.initElements(driver, DLVDiscountINR.class);
	DisINR.FullServ(Dis);
	BigDecimal Actaul =new BigDecimal(DLVDiscountINR.amt);
	Assert.assertEquals(Actaul, expected,"Total Amount isn't correct");
	System.out.println("Total Amount is correct");
}
	@Test(priority=11)
	public void Dlv_roundOff_TC_11() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String Cust = SO_Excellib.getExcelDat("SOSRV",04, 9);
		String Desc =SO_Excellib.getExcelDat("SOSRV",04, 12);
		String Category = SO_Excellib.getExcelDat("SOSRV",04, 13);
		String Price = SO_Excellib.getExcelDat("SOSRV",04, 14);
		String Total = SO_Excellib.getExcelDat("DLV",15, 17);
		String RoundOFF = SO_Excellib.getExcelDat("DLV",15, 15);
		BigDecimal expected =new BigDecimal(Total);
		expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesService);
		driver.navigate().refresh();
		SRVPaymentLater paymentLtr = PageFactory.initElements(driver, SRVPaymentLater.class);
		paymentLtr.payLtr(Cust,Desc, Category, Price);
		DLVRoundOff FullTax =PageFactory.initElements(driver, DLVRoundOff.class);
		FullTax.FullServ(RoundOFF);
		BigDecimal Actaul =new BigDecimal(DLVRoundOff.amt);
		Assert.assertEquals(Actaul, expected,"Total Amount isn't correct");
		System.out.println("Total Amount is correct");
	}
	@Test(priority=12)
	public void Dlv_Reference_TC_12() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String Cust = SO_Excellib.getExcelDat("SOSRV",04, 9);
		String Desc =SO_Excellib.getExcelDat("SOSRV",04, 12);
		String Category = SO_Excellib.getExcelDat("SOSRV",04, 13);
		String Price = SO_Excellib.getExcelDat("SOSRV",04, 14);
		String Total = SO_Excellib.getExcelDat("DLV",16, 17);
		String Referenc = SO_Excellib.getExcelDat("DLV",16, 11);
		String ReferenceAmt = SO_Excellib.getExcelDat("DLV",16, 12);
		BigDecimal expected =new BigDecimal(Total);
		expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SalesService);
		driver.navigate().refresh();
		SRVPaymentLater paymentLtr = PageFactory.initElements(driver, SRVPaymentLater.class);
		paymentLtr.payLtr(Cust,Desc, Category, Price);
		DLVReference Reference =PageFactory.initElements(driver, DLVReference.class);
		Reference.FullServ(Referenc, ReferenceAmt);
		BigDecimal Actaul =new BigDecimal(DLVReference.amt);
		Assert.assertEquals(Actaul, expected,"Total Amount isn't correct");
		System.out.println("Total Amount is correct");
	}

@Test(priority=13)
public void Dlv_SalesPerson_TC_13() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",04, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",04, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",04, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",04, 14);
	String Total = SO_Excellib.getExcelDat("DLV",17, 17);
	String Sales = SO_Excellib.getExcelDat("DLV",17, 15);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVPaymentLater paymentLtr = PageFactory.initElements(driver, SRVPaymentLater.class);
	paymentLtr.payLtr(Cust,Desc, Category, Price);
	DLVSalesPerson SalesPerson = PageFactory.initElements(driver, DLVSalesPerson.class);
	SalesPerson.FullServ(Sales);
	BigDecimal Actaul =new BigDecimal(DLVSalesPerson.amt);
	Assert.assertEquals(Actaul, expected,"Total Amount isn't correct");
	System.out.println("Total Amount is correct");


}
@Test(priority =14)
public void Dlv_Memo_TC_14() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",04, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",04, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",04, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",04, 14);
	String Total = SO_Excellib.getExcelDat("DLV",18, 17);
	String Memo = SO_Excellib.getExcelDat("DLV",18, 14);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVPaymentLater paymentLtr = PageFactory.initElements(driver, SRVPaymentLater.class);
	paymentLtr.payLtr(Cust,Desc, Category, Price);
	DLVMemo memo = PageFactory.initElements(driver, DLVMemo.class);
	memo.FullServ(Memo);
	BigDecimal Actaul =new BigDecimal(DLVMemo.amt);
	Assert.assertEquals(Actaul, expected,"Total Amount isn't correct");
	System.out.println("Total Amount is correct");
	
}
@Test(priority =15)
public void Dlv_TermCondition_TC_15() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String Cust = SO_Excellib.getExcelDat("SOSRV",04, 9);
	String Desc =SO_Excellib.getExcelDat("SOSRV",04, 12);
	String Category = SO_Excellib.getExcelDat("SOSRV",04, 13);
	String Price = SO_Excellib.getExcelDat("SOSRV",04, 14);
	String Total = SO_Excellib.getExcelDat("DLV",19, 17);
	String TC = SO_Excellib.getExcelDat("DLV",19, 13);
	BigDecimal expected =new BigDecimal(Total);
	expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SalesService);
	driver.navigate().refresh();
	SRVPaymentLater paymentLtr = PageFactory.initElements(driver, SRVPaymentLater.class);
	paymentLtr.payLtr(Cust,Desc, Category, Price);
	DlVTermCondition DTC = PageFactory.initElements(driver, DlVTermCondition.class);
	DTC.FullServ(TC);
	BigDecimal Actaul =new BigDecimal(DlVTermCondition.amt);
	Assert.assertEquals(Actaul, expected,"Total Amount isn't correct");
	System.out.println("Total Amount is correct");
}

}
