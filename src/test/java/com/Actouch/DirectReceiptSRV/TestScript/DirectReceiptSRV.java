package com.Actouch.DirectReceiptSRV.TestScript;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Actouch.DirectReceiptServ.pageObjectRepository.DRSPayLtr;
import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.DRSRVDataProvider;
import com.Actouch.Purchase.generic_Lib.POExcelLib;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;
import com.Actouch.PurchaseINV.pageObjectRepository.Login;
public class DirectReceiptSRV extends DRSRVDataProvider {
	static WebDriver driver;
	@Test(priority = 1)
	public void DRINV_Login_TC_1() throws Exception
	{
		driver = Browser.getbrowser();
		String usrId = POExcelLib.getExcelData("PO", 03, 03);
				 String psw = POExcelLib.getExcelData("PO", 03, 04);
				 driver.get(Constant.Url);
				Login loginpage = PageFactory.initElements(driver, Login.class);
				loginpage.login(usrId, psw);
				Thread.sleep(5000);		
	}
	@Test(dataProvider="PaymentLate",priority=2)
	public void DRSRV_payltr_TC_2(String SuppID,String Desc,String Category,String  SerPrice,String Total) throws InterruptedException, ClassNotFoundException, SQLException
	{
		WebDriverCommonlib.waitForPageToLoad();
		 BigDecimal expected = new BigDecimal(Total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);	
	      driver.get(Constant.directPorMain);	
		  driver.navigate().refresh();
		  DRSPayLtr PyLtr = PageFactory.initElements(driver, DRSPayLtr.class);
		  PyLtr.payltr(SuppID, Desc, Category, SerPrice);
		  BigDecimal Actual = new BigDecimal(DRSPayLtr.Amt);
			 Assert.assertEquals(Actual,expected,"total amount not correct Data");
			 System.out.println("total Amount verified");
		 PyLtr.payltrDB("jdbc:mysql://178.162.192.70:3306/", "actouchuser", "actouchuser","select * from actouch.por_mstr where  ENTITY_ID = 399807654 and por_id='"+DRSPayLtr.Exp+"'", "supp_id", "TOTAL_AMT");
		   Assert.assertEquals(DRSPayLtr.Supp_ID, SuppID,"DB has not as usual SuppID");
			Assert.assertEquals(DRSPayLtr.TOTAL_AMT, expected,"DB has not correct Data");
	
	}
     
	@Test(dataProvider="",priority=3)
    public void DRSRV_payNowByChq_singlechq_TC_3()
    {
		
    }

	

	
	
}
