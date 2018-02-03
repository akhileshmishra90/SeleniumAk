package com.Actouch.DirectInvoiceINV.TestScript;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.DIPaymentLater;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.UPDAddNewLine;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.UPDINVCreditTem;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.UPDINVCustID;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.UPDINVDisINR;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.UPDINVESugam;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.UPDINVMemo;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.UPDINVProduct;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.UPDINVQuantity;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.UPDINVReference;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.UPDINVRoundOff;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.UPDINVSDisPer;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.UPDINVSalesPerson;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.UPDINVSalesTax;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.UPDINVShipAddress;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.UPDINVShipCharge;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.UPDINVTax;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.UPDINVTaxShipCharge;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.UPDINVTermCond;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.UPDINVUnitPrice;
import com.Actouch.DirectInvoiceINVLoc.pageObjectRepository.UPDINVlineDiscount;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.SO_Excellib;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
import com.Actouch.SalesINVLoc.pageObjectRepository.Login;

public class DirectInvoiceUpdate {

	static WebDriver driver;
	SO_Excellib DI_Excellib = new SO_Excellib("D:\\Selenium\\Direct Invoice.xlsx");
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
@Test(priority=2)
public void UPDINV_updateCustID_TC_2() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = DI_Excellib.getExcelDat("DII", 04, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 04, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 04, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 04, 16);
	 String CustUp = DI_Excellib.getExcelDat("UPDII", 04,06);
	 driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIPaymentLater DIPltr = PageFactory.initElements(driver, DIPaymentLater.class);
	DIPltr.payltr(custID,prodID,Qnty,unitp);
	UPDINVCustID UPDIC =PageFactory.initElements(driver, UPDINVCustID.class);
	UPDIC.UpdateAmount(CustUp);
	}
@Test(priority=3)
public void UPDINV_updateReference_TC_3() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	 String custID = DI_Excellib.getExcelDat("DII", 04, 8);
	 String prodID = DI_Excellib.getExcelDat("DII", 04, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 04, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 04, 16);
	 String Ref = DI_Excellib.getExcelDat("UPDII", 05,07);
	 String RefAmt = DI_Excellib.getExcelDat("UPDII", 06,07);
	 driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIPaymentLater DIPltr = PageFactory.initElements(driver, DIPaymentLater.class);
	DIPltr.payltr(custID,prodID,Qnty,unitp);
	UPDINVReference UPDIR =PageFactory.initElements(driver, UPDINVReference.class);
	UPDIR.UpdateAmount(Ref,RefAmt);
}
@Test(priority=4)
public void UPDINV_updateShipAddress_TC_4() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String CustID = DI_Excellib.getExcelDat("DII",04,8);
	 String prodID = DI_Excellib.getExcelDat("DII", 04, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 04, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 04, 16);
	 String ShipAddress = DI_Excellib.getExcelDat("UPDII",  06,8);
	 driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIPaymentLater DIPltr = PageFactory.initElements(driver, DIPaymentLater.class);
	DIPltr.payltr(CustID,prodID,Qnty,unitp);
	UPDINVShipAddress UPDIS = PageFactory.initElements(driver, UPDINVShipAddress.class);
	UPDIS.UpdateAmount(ShipAddress);
}
@Test(priority=5)
public void UPDINV_updateSalePerson_TC_5() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String CustID = DI_Excellib.getExcelDat("DII",04,8);
	 String prodID = DI_Excellib.getExcelDat("DII", 04, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 04, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 04, 16);
	 String SalePerson = DI_Excellib.getExcelDat("UPDII",  07,9);
	 driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIPaymentLater DIPltr = PageFactory.initElements(driver, DIPaymentLater.class);
	DIPltr.payltr(CustID,prodID,Qnty,unitp);
	UPDINVSalesPerson UPDISP = PageFactory.initElements(driver, UPDINVSalesPerson.class);
	UPDISP.UpdateAmount(SalePerson);
}
@Test(priority=6)
public void UPDINV_updateQuantity_TC_6() throws Exception
{
	WebDriverCommonlib.waitForPageToLoad();
	String CustID = DI_Excellib.getExcelDat("DII",04,8);
	 String prodID = DI_Excellib.getExcelDat("DII", 04, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 04, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 04, 16);
	 String upQty = DI_Excellib.getExcelDat("UPDII",  8,10);
	 driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIPaymentLater DIPltr = PageFactory.initElements(driver, DIPaymentLater.class);
	DIPltr.payltr(CustID,prodID,Qnty,unitp);
	UPDINVQuantity UPDIQ = PageFactory.initElements(driver, UPDINVQuantity.class);
	UPDIQ.UpdateAmount(upQty);
}
@Test(priority=7)
public void UPDINV_updateTax_TC_7() throws Exception
{
	String CustID = DI_Excellib.getExcelDat("DII",04,8);
	 String prodID = DI_Excellib.getExcelDat("DII", 04, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 04, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 04, 16);
	 String UpTax = DI_Excellib.getExcelDat("UPDII",9,11);
	 driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIPaymentLater DIPltr = PageFactory.initElements(driver, DIPaymentLater.class);
	DIPltr.payltr(CustID,prodID,Qnty,unitp);
	UPDINVTax UPDIT =PageFactory.initElements(driver, UPDINVTax.class);
	UPDIT.UpdateAmount(UpTax);
}
@Test(priority=8)
public void UPDINV_updateESugam_TC_8() throws Exception
{
	String CustID = DI_Excellib.getExcelDat("DII",04,8);
	 String prodID = DI_Excellib.getExcelDat("DII", 04, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 04, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 04, 16);
	 String Esugam = DI_Excellib.getExcelDat("UPDII",10,12);
	 driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIPaymentLater DIPltr = PageFactory.initElements(driver, DIPaymentLater.class);
	DIPltr.payltr(CustID,prodID,Qnty,unitp);
	UPDINVESugam UPDID =PageFactory.initElements(driver, UPDINVESugam.class);
	UPDID.UpdateAmount(Esugam);
}
@Test(priority=9)
public void UPDINV_updateVehicleDetails_TC_9()
{
}
@Test(priority=10)
public void UPDINV_updateTermCondition_TC_10() throws Exception
{
	String CustID = DI_Excellib.getExcelDat("DII",04,8);
	 String prodID = DI_Excellib.getExcelDat("DII", 04, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 04, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 04, 16);
	 String TermCond = DI_Excellib.getExcelDat("UPDII",12,15);
	 driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIPaymentLater DIPltr = PageFactory.initElements(driver, DIPaymentLater.class);
	DIPltr.payltr(CustID,prodID,Qnty,unitp);
	UPDINVTermCond UPDITC = PageFactory.initElements(driver, UPDINVTermCond.class);
	UPDITC.UpdateAmount(TermCond);

}
@Test(priority=11)
public void UPDINV_updateMemo_TC_11() throws Exception
{
	String CustID = DI_Excellib.getExcelDat("DII",04,8);
	 String prodID = DI_Excellib.getExcelDat("DII", 04, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 04, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 04, 16);
	 String Memo = DI_Excellib.getExcelDat("UPDII",13,16);
	 driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIPaymentLater DIPltr = PageFactory.initElements(driver, DIPaymentLater.class);
	DIPltr.payltr(CustID,prodID,Qnty,unitp);
	UPDINVMemo UPDIM =PageFactory.initElements(driver, UPDINVMemo.class);
	UPDIM.UpdateAmount(Memo);
}
@Test(priority = 12)
public void UPDINV_updateDiscountPer_TC_12() throws Exception
{
	String CustID = DI_Excellib.getExcelDat("DII",04,8);
	 String prodID = DI_Excellib.getExcelDat("DII", 04, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 04, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 04, 16);
	 String Dis = DI_Excellib.getExcelDat("UPDII",14,17);
	 driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIPaymentLater DIPltr = PageFactory.initElements(driver, DIPaymentLater.class);
	DIPltr.payltr(CustID,prodID,Qnty,unitp);
	UPDINVSDisPer UPDIDP =PageFactory.initElements(driver, UPDINVSDisPer.class);
	UPDIDP.UpdateAmount(Dis);
}

@Test(priority=13)
public void UPDINV_updateDiscountINR_TC_13() throws Exception
{
	String CustID = DI_Excellib.getExcelDat("DII",04,8);
	 String prodID = DI_Excellib.getExcelDat("DII", 04, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 04, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 04, 16);
	 String Dis = DI_Excellib.getExcelDat("UPDII",15,17);
	 driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIPaymentLater DIPltr = PageFactory.initElements(driver, DIPaymentLater.class);
	DIPltr.payltr(CustID,prodID,Qnty,unitp);
	UPDINVDisINR UPDIDI =PageFactory.initElements(driver, UPDINVDisINR.class);
	UPDIDI.UpdateAmount(Dis);
}
@Test(priority=14)
public void UPDINV_updateShipCharge_TC_14() throws Exception
{
	String CustID = DI_Excellib.getExcelDat("DII",04,8);
	 String prodID = DI_Excellib.getExcelDat("DII", 04, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 04, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 04, 16);
	 String ShipCharge = DI_Excellib.getExcelDat("UPDII",16,18);
	 driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIPaymentLater DIPltr = PageFactory.initElements(driver, DIPaymentLater.class);
	DIPltr.payltr(CustID,prodID,Qnty,unitp);
	UPDINVShipCharge UPDISC = PageFactory.initElements(driver, UPDINVShipCharge.class);
	UPDISC.UpdateAmount(ShipCharge);	
}
@Test(priority=15)
public void UPDINV_updateRoundOff_TC_15() throws Exception
{
	String CustID = DI_Excellib.getExcelDat("DII",04,8);
	 String prodID = DI_Excellib.getExcelDat("DII", 04, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 04, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 04, 16);
	 String Roundoff = DI_Excellib.getExcelDat("UPDII",17,19);
	 driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIPaymentLater DIPltr = PageFactory.initElements(driver, DIPaymentLater.class);
	DIPltr.payltr(CustID,prodID,Qnty,unitp);
	UPDINVRoundOff UPDIR =PageFactory.initElements(driver, UPDINVRoundOff.class);
	UPDIR.UpdateAmount(Roundoff);
}
@Test(priority=17)
public void UPDINV_updateTaxShipCharge_TC_17() throws Exception
{
	String CustID = DI_Excellib.getExcelDat("DII",04,8);
	 String prodID = DI_Excellib.getExcelDat("DII", 04, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 04, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 04, 16);
	 String shipCharge = DI_Excellib.getExcelDat("UPDII",19,18);
	 String ShipTax = DI_Excellib.getExcelDat("UPDII",19,11);
	 driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIPaymentLater DIPltr = PageFactory.initElements(driver, DIPaymentLater.class);
	DIPltr.payltr(CustID,prodID,Qnty,unitp);
	UPDINVTaxShipCharge UPDITS =PageFactory.initElements(driver, UPDINVTaxShipCharge.class);
	UPDITS.UpdateAmount(shipCharge, "Yes", ShipTax);
}
@Test(priority=18)
public void UPDINV_CreditTerm_TC_18() throws Exception
{
	String CustID = DI_Excellib.getExcelDat("DII",04,8);
	 String prodID = DI_Excellib.getExcelDat("DII", 04, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 04, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 04, 16);
	 String CreditTerm = DI_Excellib.getExcelDat("UPDII",20,13);
	 driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIPaymentLater DIPltr = PageFactory.initElements(driver, DIPaymentLater.class);
	DIPltr.payltr(CustID,prodID,Qnty,unitp);
	UPDINVCreditTem UPDICT =PageFactory.initElements(driver, UPDINVCreditTem.class);
	UPDICT.UpdateAmount(CreditTerm);
}
@Test(priority=19)
public void UPDINV_Product_TC_19() throws Exception
{
	String CustID = DI_Excellib.getExcelDat("DII",04,8);
	 String prodID = DI_Excellib.getExcelDat("DII", 04, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 04, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 04, 16);
	 String upprodID = DI_Excellib.getExcelDat("UPDII",21,21);
	 String upQnty = DI_Excellib.getExcelDat("UPDII",21,11);
	 String upUnitp = DI_Excellib.getExcelDat("UPDII",21,20);
	 driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIPaymentLater DIPltr = PageFactory.initElements(driver, DIPaymentLater.class);
	DIPltr.payltr(CustID,prodID,Qnty,unitp);
	UPDINVProduct UPDIP=PageFactory.initElements(driver, UPDINVProduct.class);
	UPDIP.UpdateAmount(upprodID,upQnty,upUnitp);
}
@Test(priority=20)
public void UPDINV_UnitPrice_TC_20() throws Exception
{
	String CustID = DI_Excellib.getExcelDat("DII",04,8);
	 String prodID = DI_Excellib.getExcelDat("DII", 04, 10);
	 String Qnty = DI_Excellib.getExcelDat("DII", 04, 13);
	 String unitp = DI_Excellib.getExcelDat("DII", 04, 16);
	 String upUnitp = DI_Excellib.getExcelDat("UPDII",22,20);
	 driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIPaymentLater DIPltr = PageFactory.initElements(driver, DIPaymentLater.class);
	DIPltr.payltr(CustID,prodID,Qnty,unitp);
	UPDINVUnitPrice UPDIUP =PageFactory.initElements(driver, UPDINVUnitPrice.class);
	UPDIUP.UpdateAmount(upUnitp);
}
@Test(priority=21)
public void UPDINV_LineItemDisCount_TC_21() throws Exception
{
String CustID = DI_Excellib.getExcelDat("DII",04,8);
String prodID = DI_Excellib.getExcelDat("DII", 04, 10);
String Qnty = DI_Excellib.getExcelDat("DII", 04, 13);
String unitp = DI_Excellib.getExcelDat("DII", 04, 16);
String liDis = DI_Excellib.getExcelDat("UPDII",23,17);
driver.get(Constant.NewDirectInvoiceMain);
driver.navigate().refresh();
DIPaymentLater DIPltr = PageFactory.initElements(driver, DIPaymentLater.class);
DIPltr.payltr(CustID,prodID,Qnty,unitp);
UPDINVlineDiscount UPDLD = PageFactory.initElements(driver, UPDINVlineDiscount.class);
UPDLD.UpdateAmount(liDis);
}
@Test(priority=22)
public void UPDINV_AddlineItem_TC_22() throws Exception
{
	String CustID = DI_Excellib.getExcelDat("DII",04,8);
	String prodID = DI_Excellib.getExcelDat("DII", 04, 10);
	String Qnty = DI_Excellib.getExcelDat("DII", 04, 13);
	String unitp = DI_Excellib.getExcelDat("DII", 04, 16);
	 String upprodID = DI_Excellib.getExcelDat("UPDII",24,21);
	 String upQnty = DI_Excellib.getExcelDat("UPDII",24,11);
	 String upUnitp = DI_Excellib.getExcelDat("UPDII",24,20);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIPaymentLater DIPltr = PageFactory.initElements(driver, DIPaymentLater.class);
	DIPltr.payltr(CustID,prodID,Qnty,unitp);
	UPDAddNewLine UPDANL = PageFactory.initElements(driver, UPDAddNewLine.class);
	UPDANL.UpdateAmount(upprodID,upQnty,upUnitp);
}
@Test(priority=23)
public void UPDINV_SaleTax_TC_23() throws Exception
{
	String CustID = DI_Excellib.getExcelDat("DII",04,8);
	String prodID = DI_Excellib.getExcelDat("DII", 04, 10);
	String Qnty = DI_Excellib.getExcelDat("DII", 04, 13);
	String unitp = DI_Excellib.getExcelDat("DII", 04, 16);
	String salesTax = DI_Excellib.getExcelDat("UPDII",25,11);
	driver.get(Constant.NewDirectInvoiceMain);
	driver.navigate().refresh();
	DIPaymentLater DIPltr = PageFactory.initElements(driver, DIPaymentLater.class);
	DIPltr.payltr(CustID,prodID,Qnty,unitp);
	UPDINVSalesTax UPIST = PageFactory.initElements(driver, UPDINVSalesTax.class);
	UPIST.UpdateAmount(salesTax);
}

}
