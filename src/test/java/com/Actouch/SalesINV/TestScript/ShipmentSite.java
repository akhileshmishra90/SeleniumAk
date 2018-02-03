package com.Actouch.SalesINV.TestScript;
import java.math.BigDecimal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.SO_Excellib;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
import com.Actouch.SalesINVLoc.pageObjectRepository.Login;
import com.Actouch.SalesINVSite.pageObjectRepository.SHPMultiproduct;
import com.Actouch.SalesINVSite.pageObjectRepository.SOMultiproduct;
public class ShipmentSite {
	WebDriver driver;
	SO_Excellib SO_Excellib = new SO_Excellib("D:\\Selenium\\SaleOrderSite.xlsx");
	@Test(priority = 1 )
	public void salesIN_Login_TC_1()  throws Exception
	{
		//login
				driver = Browser.getbrowser();
	 String usrid = SO_Excellib.getExcelDat("SO", 03, 03);
		 String pss = SO_Excellib.getExcelDat("SO", 03, 04);
			Browser.driver.get(Constant.Url);
		Login loginpage = PageFactory.initElements(driver, Login.class);
		loginpage.login(usrid, pss);
	
		Thread.sleep(3000);
		
		}
	@Test(priority =15)
	public void Shp_Multiproduct() throws Exception
	{
		WebDriverCommonlib.waitForPageToLoad();
		String Site = SO_Excellib.getExcelDat("SO", 24, 6);
		String custID = SO_Excellib.getExcelDat("SO", 24, 8);
		  String total =SO_Excellib.getExcelDat("Shipment", 18, 15);
		  String taxTotal =SO_Excellib.getExcelDat("Shipment", 18, 16);
				  String GrossAmount= SO_Excellib.getExcelDat("Shipment", 18, 17);
		  BigDecimal Totalexp = new BigDecimal(total);
		  Totalexp = Totalexp.setScale(2, BigDecimal.ROUND_HALF_UP);
		  BigDecimal totalTaxExp = new BigDecimal(taxTotal);
		  totalTaxExp=totalTaxExp.setScale(2, BigDecimal.ROUND_HALF_UP);
		  BigDecimal GrossAmountExp = new BigDecimal(GrossAmount);
		  GrossAmountExp = GrossAmountExp.setScale(2, BigDecimal.ROUND_HALF_UP);
		  SoftAssert Assert = new SoftAssert();
			driver.get(Constant.SalesOrder_new);
			driver.navigate().refresh();
			SOMultiproduct SOMultiprod =PageFactory.initElements(driver,SOMultiproduct.class);
			SOMultiprod.multiproduct(Site, custID);
			Thread.sleep(7000);
			SHPMultiproduct MultiProd = PageFactory.initElements(driver, SHPMultiproduct.class);
			MultiProd.fullShipment();
			BigDecimal totalTaxAct = new BigDecimal(SHPMultiproduct.totalTax);
			Assert.assertEquals(totalTaxAct, totalTaxExp,"Total tax is wrong"); 
			BigDecimal GrossAmountAct = new BigDecimal(SHPMultiproduct.grossAmt);
			Assert.assertEquals(GrossAmountAct, GrossAmountExp,"Gross Amount is wrong");
			BigDecimal TotalAct = new BigDecimal(SHPMultiproduct.amt);
			Assert.assertEquals(TotalAct, Totalexp,"Total is wrong");
			SHPMultiproduct.payltrDB("jdbc:mysql://178.162.192.40:3306/", "actouchuser", "actouchuser","select * from actouch.shp_mstr where  ENTITY_ID = 651298674 and Invoice_ID ='"+SHPMultiproduct.Excepted+"'", "CUST_ID","CUST_NAME","TOTAL_AMT","TOTAL_TAX");
			Assert.assertEquals(custID,SHPMultiproduct.CUST_ID,"CustID is not correct");
			 BigDecimal Total_TXT = SHPMultiproduct.Total_Tax;
			 Total_TXT = Total_TXT.setScale(2, BigDecimal.ROUND_HALF_UP);
			 Assert.assertEquals(Total_TXT, totalTaxExp,"Total Tax coming as wrong ");
				BigDecimal Total_amt = SHPMultiproduct.TOTAL_AMT;
				Total_amt = Total_amt.setScale(2,BigDecimal.ROUND_HALF_UP);
				Assert.assertEquals(Total_amt,Totalexp,"total amount not correct");
				SHPMultiproduct.payltrDB1("jdbc:mysql://178.162.192.40:3306/", "actouchuser", "actouchuser","select * from actouch.shp_det where Invoice_ID ='"+SHPMultiproduct.HiberNate_SeQ+"'","PRD_ID","QTY","UNITPRICE","LINE_TOTAL");
				SHPMultiproduct.payltrDB2("jdbc:mysql://178.162.192.40:3306/", "actouchuser", "actouchuser", "select * from actouch.tax_hist where ENTITY_ID = 651298674 and DOC_ID='"+SHPMultiproduct.Excepted+"'order by  sl_no asc", "TAX_ID", "TAXABLE_AMT", "GROSS_AMT", "SGST_TAX_AMT", "CGST_TAX_AMT");
				 Assert.assertAll();
			
			
	}
	

}
