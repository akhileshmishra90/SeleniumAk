package com.Actouch.PurchaseSRV.TestScript;

import java.io.IOException;
import java.math.BigDecimal;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.POSRVExcellLib;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;
import com.Actouch.PurchaseINV.pageObjectRepository.Login;
import com.Actouch.PurchaseSRV.pageObjectRepository.POSRVPayLtrShpNow;
import com.Actouch.PurchaseSRV.pageObjectRepository.UPSRVRCVTermCondi;
import com.Actouch.PurchaseSRV.pageObjectRepository.UPSRVRCVCreditTerm;
import com.Actouch.PurchaseSRV.pageObjectRepository.UPSRVRCVDisINR;
import com.Actouch.PurchaseSRV.pageObjectRepository.UPSRVRCVDisLine;
import com.Actouch.PurchaseSRV.pageObjectRepository.UPSRVRCVDisPer;
import com.Actouch.PurchaseSRV.pageObjectRepository.UPSRVRCVMemo;
import com.Actouch.PurchaseSRV.pageObjectRepository.UPSRVRCVReference;
import com.Actouch.PurchaseSRV.pageObjectRepository.UPSRVRCVRoundOff;
import com.Actouch.PurchaseSRV.pageObjectRepository.UPSRVRCVServicePrice;
import com.Actouch.PurchaseSRV.pageObjectRepository.UPSRVRCVShipAddress;
import com.Actouch.PurchaseSRV.pageObjectRepository.UPSRVRCVSupplier;
import com.Actouch.PurchaseSRV.pageObjectRepository.UPSRVRCVTax;

public class ReceiptUpdateSrv {
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
	public void UPSRVRCV_updateSupplier_TC_2() throws Exception
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
		UPSRVRCVSupplier UPSRS = PageFactory.initElements(driver, UPSRVRCVSupplier.class);
		UPSRS.Supplier("SUPP4");
	}
@Test(priority=3)
         public void UPSRVRCV_updateReference_TC_3() throws Exception
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
             UPSRVRCVReference UPSRR=PageFactory.initElements(driver, UPSRVRCVReference.class);
             UPSRR.Supplier("Reference", "4");
             
            }
    @Test(priority=4)
    public void UPSRVRCV_updateShipAddress_TC_4() throws Exception
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
           UPSRVRCVShipAddress UPSRSH = PageFactory.initElements(driver, UPSRVRCVShipAddress.class);
           UPSRSH.Supplier("KUNDALHALLI, BANGLORE, KARNATAKA, IND, 560037");
           
    }
@Test(priority=5)
         public void UPSRVRCV_updateCreditTerm_TC_5() throws Exception
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
       UPSRVRCVCreditTerm UPSRCT = PageFactory.initElements(driver, UPSRVRCVCreditTerm.class);
       UPSRCT.Supplier("15 Days");
	
         }
@Test(priority=6)
public void UPSRVRCV_updateServicePrice_TC_6() throws Exception
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
       UPSRVRCVServicePrice UPSRSP =PageFactory.initElements(driver, UPSRVRCVServicePrice.class);
       UPSRSP.Supplier("200"); 
}
@Test(priority=7)
public void UPSRVRCV_updateLineDiscount_TC_7() throws Exception
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
       UPSRVRCVDisLine UPSRDL =PageFactory.initElements(driver, UPSRVRCVDisLine.class);
       UPSRDL.Supplier("4");
       }
@Test(priority=8)
public void UPSRVRCV_updateTax_TC_8() throws Exception
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
       UPSRVRCVTax UPSRT = PageFactory.initElements(driver, UPSRVRCVTax.class);
       UPSRT.Supplier("CST 10");
}
@Test(priority=9)
public void UPSRVRCV_updateTermCondition_TC_9() throws Exception
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
       UPSRVRCVTermCondi UPSRTC = PageFactory.initElements(driver, UPSRVRCVTermCondi.class);
       UPSRTC.Supplier("sdfsdfdsfsdfdsf");
}
@Test(priority=10)
public void UPSRVRCV_updateMemo_TC_10() throws Exception
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
       UPSRVRCVMemo UPSRM = PageFactory.initElements(driver, UPSRVRCVMemo.class);
       UPSRM.Supplier("fhsdudgugudyu");
}
@Test(priority=11)
public void UPSRVRCV_updateDiscountPer_TC_11() throws Exception
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
       UPSRVRCVDisPer UPSRDP =PageFactory.initElements(driver, UPSRVRCVDisPer.class);
       UPSRDP.Supplier("2");
       
}
@Test(priority=12)
public void UPSRVRCV_updateDiscountINR_TC_12() throws Exception
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
       UPSRVRCVDisINR UPSRDI = PageFactory.initElements(driver, UPSRVRCVDisINR.class);
       UPSRDI.Supplier("2");
}
@Test(priority=13)
public void UPSRVRCV_updateRoundOff_TC_13() throws Exception
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
       UPSRVRCVRoundOff UPSRR = PageFactory.initElements(driver, UPSRVRCVRoundOff.class);
       UPSRR.Supplier("2");
}


                }
