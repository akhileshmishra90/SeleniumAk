package com.Actouch.SalesINV.TestScript;
	import java.io.IOException;
	import java.math.BigDecimal;
	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
	import org.openqa.selenium.WebDriver;
	import org.testng.Assert;
	import org.testng.annotations.Test;
	import org.testng.asserts.SoftAssert;
	import com.Actouch.Pages.Login;
	import com.Actouch.Sales.generic_Lib.Browser;
	import com.Actouch.Sales.generic_Lib.Constant;
	import com.Actouch.Sales.generic_Lib.SO_Excellib;
	import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
import com.Actouch.SalesINVSite.pageObjectRepository.SOMultiproduct;
import com.Actouch.SalesINVSite.pageObjectRepository.SOPaymentLater;
	


	public class SalesOrderSite {
		static WebDriver driver;

		SO_Excellib SO_Excellib = new SO_Excellib("D:\\Selenium\\SaleOrderSite.xlsx");

		@Test(priority = 1 )
		public void salesIN_Login_TC_1() throws Exception
		{
			
			driver = Browser.getbrowser();
			driver.manage().window().maximize();
	 String usrid = SO_Excellib.getExcelDat("SO", 03, 03);
		 String pss = SO_Excellib.getExcelDat("SO", 03, 04);
		 Login lgN = new Login(driver);
			Browser.driver.get(Constant.Url);
			lgN.useredt(usrid);
			lgN.pswedt(pss);
			lgN.loginbtn();
			Thread.sleep(3000);
			
			
		}
		 @Test(priority = 2)
			public void salesIN_payltr_TC_2() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
			{
			 WebDriverCommonlib.waitForPageToLoad();
			 String Site = SO_Excellib.getExcelDat("SO", 04, 6);
				String custID = SO_Excellib.getExcelDat("SO", 04, 8);
				 String prodID = SO_Excellib.getExcelDat("SO", 04, 10);
				 String Qnty = SO_Excellib.getExcelDat("SO", 04, 13);
				 String unitp = SO_Excellib.getExcelDat("SO", 04, 16);
				 String taxCode = SO_Excellib.getExcelDat("SO", 04, 19);
				 String total =SO_Excellib.getExcelDat("SO", 04, 31);
				 BigDecimal expected = new BigDecimal(total);
				 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
				  driver.get(Constant.SalesOrder_new);	
				  SOPaymentLater  payLtr = new SOPaymentLater();
				  payLtr.payltr(Site,custID, prodID, Qnty, unitp, taxCode);
				  BigDecimal Actual = new BigDecimal(SOPaymentLater.amt);
				  Assert.assertEquals(Actual,expected,"total amount not correct");
			}
		 @Test(priority=3)
		 public void SaleIN_MultiProduct_TC_22() throws Exception
		 {
			 WebDriverCommonlib.waitForPageToLoad();
				SoftAssert SfAssert = new SoftAssert();
				String Site = SO_Excellib.getExcelDat("Multi", 4, 6);	
				String custID = SO_Excellib.getExcelDat("Multi", 4, 8);	
				String Subtotal = SO_Excellib.getExcelDat("Multi", 18, 20);
				String TotalTax = SO_Excellib.getExcelDat("Multi", 18, 21); 
				String GrossTotal = SO_Excellib.getExcelDat("Multi", 18, 31); 
				BigDecimal SubtotalExp =new BigDecimal(Subtotal);
				SubtotalExp = SubtotalExp.setScale(2, BigDecimal.ROUND_HALF_UP);
				BigDecimal TotalTaxExp =new BigDecimal(TotalTax);
				TotalTaxExp = TotalTaxExp.setScale(2, BigDecimal.ROUND_HALF_UP);
				BigDecimal GrossTotalExp =new BigDecimal(GrossTotal);
				GrossTotalExp = GrossTotalExp.setScale(2, BigDecimal.ROUND_HALF_UP);
					driver.navigate().to(Constant.SalesOrder_new);		
					driver.navigate().refresh();		
					SOMultiproduct Multiproduct =new SOMultiproduct();
					Multiproduct.multiproduct(Site, custID);
					 BigDecimal GrossAct =new BigDecimal(SOMultiproduct.Grossamt);
					 BigDecimal TotaltaxAct =new BigDecimal(SOMultiproduct.totalTaxamt);
					 BigDecimal SubTotalAct =new BigDecimal(SOMultiproduct.Subtotal);
					 SfAssert.assertEquals(SubTotalAct, SubtotalExp,"amount verification isn't correct");
					  SfAssert.assertEquals(TotaltaxAct, TotalTaxExp,"amount verification isn't correct");
				     SfAssert.assertEquals(GrossAct, GrossTotalExp,"amount verification isn't correct");
				     SOMultiproduct.payltrDB("jdbc:mysql://178.162.192.40:3306/", "actouchuser", "actouchuser","select * from actouch.so_mstr where  ENTITY_ID = 995655148 and so_id ='"+SOMultiproduct.exp+"'", "CUST_ID","CUST_NAME","TOTAL_AMT","TOTAL_TAX");
				     SfAssert.assertEquals(custID,SOMultiproduct.CUST_ID,"CustID is not correct");
					 BigDecimal Total_TXT = SOMultiproduct.Total_Tax;
					 Total_TXT = Total_TXT.setScale(2, BigDecimal.ROUND_HALF_UP);
					 SfAssert.assertEquals(Total_TXT, TotalTaxExp,"Total Tax coming as wrong ");
						BigDecimal Total_amt = SOMultiproduct.TOTAL_AMT;
						Total_amt = Total_amt.setScale(2,BigDecimal.ROUND_HALF_UP);
						SfAssert.assertEquals(Total_amt,GrossTotalExp,"total amount not correct");
						SOMultiproduct.payltrDB1("jdbc:mysql://178.162.192.40:3306/", "actouchuser", "actouchuser","select * from actouch.so_det where so_id ='"+SOMultiproduct.HiberNate_SeQ+"'","PRD_ID","SELL_QTY","UNITPRICE","LINE_TOTAL");
				     SfAssert.assertAll();
		 }

		}




