package com.Actouch.DirectInvoiceINV.TestScript;

import java.io.IOException;
import java.math.BigDecimal;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actouch.DirectInvoiceINVsiteLoc.pageObjectRepository.DIMultiProd;
import com.Actouch.DirectInvoiceINVsiteLoc.pageObjectRepository.DIPaymentLater;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.SO_Excellib;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
import com.Actouch.SalesINVLoc.pageObjectRepository.Login;

public class DirectInvoiceSiteLoc {
	static WebDriver driver;
	SO_Excellib DI_Excellib = new SO_Excellib("D:\\Selenium\\DirectInvoiceSiteLoc.xlsx");
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
	@Test(priority= 2)
	public void DIINV_PaymentLater() throws Exception, Exception, IOException
	{
		WebDriverCommonlib.waitForPageToLoad();
		String Site = DI_Excellib.getExcelDat("DII", 04, 6);
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
		DIPltr.payltr(Site,custID,prodID,Qnty,unitp);
		BigDecimal Actual = new BigDecimal(DIPaymentLater.amt);
		Assert.assertEquals(Actual, expected,"amount verification isn't correct");
		System.out.println("Amount verification is correct");
	}
	@Test(priority= 16 )
	public void DIINV_MultiProduct_TC_16() throws Exception, InvalidFormatException, IOException
	{
		WebDriverCommonlib.waitForPageToLoad();
		String Site = DI_Excellib.getExcelDat("Multi", 4, 6);
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
		MultiProd.payltr(Site,custID);
		 BigDecimal GrossAct =new BigDecimal(DIMultiProd.Grossamt);
		 BigDecimal TotaltaxAct =new BigDecimal(DIMultiProd.totalTaxamt);
		 BigDecimal SubTotalAct =new BigDecimal(DIMultiProd.Subtotal);
		 Softass.assertEquals(SubTotalAct, SubtotalExp,"amount verification isn't correct");
		 System.out.println("SubTotalAct verification is correct");
		 Softass.assertEquals(TotaltaxAct, TotalTaxExp,"amount verification isn't correct");
		 System.out.println("TotaltaxAct verification is correct");
		 Softass.assertEquals(GrossAct, GrossTotalExp,"amount verification isn't correct");
		 System.out.println("GrossAct verification is correct");
		 DIMultiProd.payltrDB("jdbc:mysql://178.162.192.40:3306/", "actouchuser", "actouchuser","select * from actouch.shp_mstr where  ENTITY_ID = 399807654 and Invoice_ID ='"+DIMultiProd.exp+"' and site_id= 4 ", "CUST_ID","CUST_NAME","TOTAL_AMT","TOTAL_TAX");
		 Softass.assertEquals(custID,DIMultiProd.CUST_ID,"CustID is not correct");
		 BigDecimal Total_TXT = DIMultiProd.Total_Tax;
		 Total_TXT = Total_TXT.setScale(2, BigDecimal.ROUND_HALF_UP);
		 Softass.assertEquals(Total_TXT, TotalTaxExp,"Total Tax coming as wrong ");
			BigDecimal Total_amt = DIMultiProd.TOTAL_AMT;
			Total_amt = Total_amt.setScale(2,BigDecimal.ROUND_HALF_UP);
			Softass.assertEquals(Total_amt,GrossTotalExp,"total amount not correct");
			 DIMultiProd.payltrDB1("jdbc:mysql://178.162.192.40:3306/", "actouchuser", "actouchuser","select * from actouch.shp_det where Invoice_ID ='"+DIMultiProd.HiberNate_SeQ+"'","PRD_ID","QTY","UNITPRICE","LINE_TOTAL");
			 DIMultiProd.payltrDB2("jdbc:mysql://178.162.192.40:3306/", "actouchuser", "actouchuser", "select * from actouch.tax_hist where ENTITY_ID = 399807654 and DOC_ID='"+DIMultiProd.exp+"' and site_id= 4  order by  sl_no asc", "TAX_ID", "TAXABLE_AMT", "GROSS_AMT", "SGST_TAX_AMT", "CGST_TAX_AMT");
			 Softass.assertAll();
			
	}

}
