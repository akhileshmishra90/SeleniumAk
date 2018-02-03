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
import com.Actouch.SalesINVNorm.pageObjectRepository.SOMutiproduct;
import com.Actouch.SalesINVNorm.pageObjectRepository.ShpMultiProduct;
public class ShipmentNormal {
	WebDriver driver;
	SO_Excellib SO_Excellib = new SO_Excellib("D:\\Selenium\\SaleOrderWSWL.xlsx");
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
			SOMutiproduct SOMultiprod =PageFactory.initElements(driver,SOMutiproduct.class);
			SOMultiprod.multiproduct(custID);
			Thread.sleep(7000);
			ShpMultiProduct MultiProd = PageFactory.initElements(driver, ShpMultiProduct.class);
			MultiProd.fullShipment();
			BigDecimal totalTaxAct = new BigDecimal(ShpMultiProduct.totalTax);
			Assert.assertEquals(totalTaxAct, totalTaxExp,"Total tax is wrong"); 
			System.out.println(totalTaxAct+" "+totalTaxExp);
			BigDecimal GrossAmountAct = new BigDecimal(ShpMultiProduct.grossAmt);
			Assert.assertEquals(GrossAmountAct, GrossAmountExp,"Gross Amount is wrong");
			System.out.println(GrossAmountAct+" "+GrossAmountExp);
			BigDecimal TotalAct = new BigDecimal(ShpMultiProduct.amt);
			Assert.assertEquals(TotalAct, Totalexp,"Total is wrong");
			System.out.println(TotalAct+" "+Totalexp);
		  ShpMultiProduct.payltrDB("jdbc:mysql://178.162.192.40:3306/", "actouchuser", "actouchuser","select * from actouch.shp_mstr where  ENTITY_ID = 261595686 and Invoice_ID ='"+ShpMultiProduct.Excepted+"'", "CUST_ID","CUST_NAME","TOTAL_AMT","TOTAL_TAX");
			Assert.assertEquals(custID,ShpMultiProduct.CUST_ID,"CustID is not correct");
			 BigDecimal Total_TXT = ShpMultiProduct.Total_Tax;
			 Total_TXT = Total_TXT.setScale(2, BigDecimal.ROUND_HALF_UP);
			 Assert.assertEquals(Total_TXT, totalTaxExp,"Total Tax coming as wrong ");
			 System.out.println(Total_TXT+" "+totalTaxExp);
				BigDecimal Total_amt = ShpMultiProduct.TOTAL_AMT;
				Total_amt = Total_amt.setScale(2,BigDecimal.ROUND_HALF_UP);
				Assert.assertEquals(Total_amt,Totalexp,"total amount not correct");
				System.out.println(Total_amt+" "+Totalexp);
		  ShpMultiProduct.payltrDB1("jdbc:mysql://178.162.192.40:3306/", "actouchuser", "actouchuser","select * from actouch.shp_det where Invoice_ID ='"+ShpMultiProduct.HiberNate_SeQ+"'","PRD_ID","QTY","UNITPRICE","LINE_TOTAL");
		  ShpMultiProduct.payltrDB2("jdbc:mysql://178.162.192.40:3306/", "actouchuser", "actouchuser", "select * from actouch.tax_hist where ENTITY_ID = 261595686 and DOC_ID='"+ShpMultiProduct.Excepted+"'order by  sl_no asc", "TAX_ID", "TAXABLE_AMT", "GROSS_AMT", "SGST_TAX_AMT", "CGST_TAX_AMT");
				 Assert.assertAll();
			
			
	}
	

}
