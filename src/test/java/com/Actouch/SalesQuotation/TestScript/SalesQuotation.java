package com.Actouch.SalesQuotation.TestScript;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Actouch.SalesQuotation.generic_Lib.Browser;
import com.Actouch.SalesQuotation.generic_Lib.Constant;
import com.Actouch.SalesQuotation.generic_Lib.SalesQuotationExcellib;
import com.Actouch.SalesQuotation.pageObjectRepository.SQview;
import com.Actouch.SalesQuotation.pageObjectRepository.SqBlankDETlevel;
import com.Actouch.SalesQuotation.pageObjectRepository.SqBlankPageSaving;
import com.Actouch.SalesQuotation.pageObjectRepository.SqCustomSQid;
import com.Actouch.SalesQuotation.pageObjectRepository.SqDiffSite;
import com.Actouch.SalesQuotation.pageObjectRepository.Login;
import com.Actouch.SalesQuotation.pageObjectRepository.SqProposalPrint;
import com.Actouch.SalesQuotation.pageObjectRepository.SqQtyValidation;
import com.Actouch.SalesQuotation.pageObjectRepository.SqSAVEmethod;
import com.Actouch.SalesQuotation.pageObjectRepository.SqSAVEprintMethod;
import com.Actouch.SalesQuotation.pageObjectRepository.SqProductTaxDiscount;
import com.Actouch.SalesQuotation.pageObjectRepository.SqToSoProduct;
import com.Actouch.SalesQuotation.pageObjectRepository.SqWithRefField;
import com.Actouch.SalesQuotation.pageObjectRepository.SqMemoLentgh;
import com.Actouch.SalesQuotation.pageObjectRepository.SqMultiCurrCust;
import com.Actouch.SalesQuotation.pageObjectRepository.SqTDSWithOtherTax;
import com.Actouch.SalesQuotation.pageObjectRepository.SqTaxOnMRP;
import com.Actouch.SalesQuotation.pageObjectRepository.SQwithTradeDis;
import com.Actouch.SalesQuotation.pageObjectRepository.ShipmentLength;
import com.Actouch.SalesQuotation.pageObjectRepository.SqDiscountINR;
import com.Actouch.SalesQuotation.pageObjectRepository.SqDiscountWithpercentage;
import com.Actouch.SalesQuotation.pageObjectRepository.SqIDvalidation;
import com.Actouch.SalesQuotation.pageObjectRepository.SqLineDisc;
import com.Actouch.SalesQuotation.pageObjectRepository.SqMultiproduct;
import com.Actouch.SalesQuotation.pageObjectRepository.SqNIprd;
import com.Actouch.SalesQuotation.pageObjectRepository.SqTCLenth;
import com.Actouch.SalesQuotation.pageObjectRepository.SQWithSaleTax;
import com.Actouch.SalesQuotation.pageObjectRepository.Sqclose;
import com.Actouch.SalesQuotation.pageObjectRepository.SqcustIDvalidation;
import com.Actouch.SalesQuotation.pageObjectRepository.SQTaxExclusive;
import com.Actouch.SalesQuotation.pageObjectRepository.SQTaxInclusive;
public class SalesQuotation {
	
	static WebDriver driver;

	@Test(priority = 1)
	public void sqIN_Login_TC_01() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		//login
		
		driver = Browser.getbrowser();
		Browser.driver.get(Constant.Url);
		
		 String usrid = SalesQuotationExcellib.getExcelDat("SQ", 03, 03);
		 String pss = SalesQuotationExcellib.getExcelDat("SQ", 03, 04);
		
		Login loginpage = PageFactory.initElements(driver, Login.class);
		loginpage.login(usrid, pss);
	
		Thread.sleep(3000);
		
		}
	
	@Test(priority =02)
	public void SqIN_NIprd_TC_02() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException

	{

		String custID = SalesQuotationExcellib.getExcelDat("SQ", 04, 8);
		 String prodID = SalesQuotationExcellib.getExcelDat("SQ", 04, 12);
		 String Qnty = SalesQuotationExcellib.getExcelDat("SQ", 04, 14);
		 String unitp = SalesQuotationExcellib.getExcelDat("SQ", 04, 17);
		 String taxCode = SalesQuotationExcellib.getExcelDat("SQ", 04, 20);
		 String total =SalesQuotationExcellib.getExcelDat("SQ", 04, 30);
		 
		 BigDecimal expected = new BigDecimal(total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		driver.get(Constant.SqNew);
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(7000);
		SqNIprd sqNIprd = PageFactory.initElements(driver, SqNIprd.class);
		sqNIprd.sqNIprd(custID, prodID, Qnty, unitp,taxCode);
	
	BigDecimal Actual = new BigDecimal(SqNIprd.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
	
	}
	
	@Test(priority=03)
	public void SqIN_saveMethod_TC_03() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		String custID = SalesQuotationExcellib.getExcelDat("SQ", 05, 8);
		 String prodID = SalesQuotationExcellib.getExcelDat("SQ", 05, 12);
		 String Qnty = SalesQuotationExcellib.getExcelDat("SQ", 05, 14);
		 String unitp = SalesQuotationExcellib.getExcelDat("SQ", 05, 17);
		 String taxCode = SalesQuotationExcellib.getExcelDat("SQ", 05, 20);
		 String total =SalesQuotationExcellib.getExcelDat("SQ", 05, 30);
		 BigDecimal expected = new BigDecimal(total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		driver.get(Constant.SqNew);
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(7000);
		SqSAVEmethod saveMethod = PageFactory.initElements(driver, SqSAVEmethod.class);
		saveMethod.saveMethod(custID, prodID, Qnty,unitp ,taxCode);
		BigDecimal Actual = new BigDecimal(SqSAVEmethod.amt);
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}

	@Test(priority=04)
	public void SqIN_savePrintMethod_TC_04() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		 String custID = SalesQuotationExcellib.getExcelDat("SQ", 06, 8);
		 String prodID = SalesQuotationExcellib.getExcelDat("SQ", 06, 12);
		 String Qnty = SalesQuotationExcellib.getExcelDat("SQ", 06, 14);
		 String unitp = SalesQuotationExcellib.getExcelDat("SQ", 06, 17);
		 String taxCode = SalesQuotationExcellib.getExcelDat("SQ", 06, 20);
		 String total =SalesQuotationExcellib.getExcelDat("SQ", 06, 30);
		 
		 BigDecimal expected = new BigDecimal(total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		driver.get(Constant.SqNew);
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(7000);
		SqSAVEprintMethod savePrintMethod = PageFactory.initElements(driver, SqSAVEprintMethod.class);
		savePrintMethod.savePrintMethod(custID, prodID, Qnty,unitp ,taxCode);
		BigDecimal Actual = new BigDecimal(SqSAVEprintMethod.amt);
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}

	@Test(priority=05)
	public void SqIN_lineTaxOnMRP_TC_05() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		String custID = SalesQuotationExcellib.getExcelDat("SQ", 07, 8);
		 String prodID = SalesQuotationExcellib.getExcelDat("SQ", 07, 12);
		 String Qnty = SalesQuotationExcellib.getExcelDat("SQ", 07, 14);
		 String mrp = SalesQuotationExcellib.getExcelDat("SQ", 07, 17);
		 String taxCode = SalesQuotationExcellib.getExcelDat("SQ", 07, 20);
		 String total =SalesQuotationExcellib.getExcelDat("SQ", 07, 30);
		 
		 BigDecimal expected = new BigDecimal(total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		driver.get(Constant.SqNew);
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(7000);
		SqTaxOnMRP taxOnMRP = PageFactory.initElements(driver, SqTaxOnMRP.class);
		taxOnMRP.taxOnMRP(custID, prodID, Qnty,mrp ,taxCode);
		BigDecimal Actual = new BigDecimal(SqTaxOnMRP.amt);
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}
	
	@Test(priority=06)
	public void SqIN_SalesTax_TC_06() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		 String custID = SalesQuotationExcellib.getExcelDat("SQ", 8, 8);
		 String prodID = SalesQuotationExcellib.getExcelDat("SQ", 8, 12);
		 String Qnty = SalesQuotationExcellib.getExcelDat("SQ", 8, 14);
		 String unitp = SalesQuotationExcellib.getExcelDat("SQ", 8, 17);
		
		 String taxCode = SalesQuotationExcellib.getExcelDat("SQ", 8, 20);
		 String cstTax = SalesQuotationExcellib.getExcelDat("SQ", 8, 26);    
		 String total =SalesQuotationExcellib.getExcelDat("SQ", 8, 30);
		 
		 BigDecimal expected = new BigDecimal(total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		 
		driver.get(Constant.SqNew);
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(7000);
		SQWithSaleTax CSTtax = PageFactory.initElements(driver, SQWithSaleTax.class);
		CSTtax.salesTax (custID,prodID, Qnty,unitp, taxCode,cstTax);
		
		BigDecimal Actual = new BigDecimal(SQWithSaleTax.amt);
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}
	
	@Test(priority=07)
	public void SqIN_lineDisc_TC_07() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		String custID = SalesQuotationExcellib.getExcelDat("SQ", 9, 8);
		 String prodID = SalesQuotationExcellib.getExcelDat("SQ", 9, 12);
		 String Qnty = SalesQuotationExcellib.getExcelDat("SQ", 9, 14);
		 String unitp = SalesQuotationExcellib.getExcelDat("SQ", 9, 17);
		 String disc = SalesQuotationExcellib.getExcelDat("SQ", 9, 18);
		 String taxCode = SalesQuotationExcellib.getExcelDat("SQ", 9, 20);
		 String total =SalesQuotationExcellib.getExcelDat("SQ", 9, 30);
		 
		 BigDecimal expected = new BigDecimal(total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		driver.get(Constant.SqNew);
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(7000);
		SqLineDisc sqLineDisc = PageFactory.initElements(driver, SqLineDisc.class);
		sqLineDisc.sqLineDisc(custID, prodID, Qnty,unitp,disc, taxCode);
		BigDecimal Actual = new BigDecimal(SqLineDisc.amt);
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}
	
	@Test(priority=8)
	public void SqIN_CashDiscount_INR_TC_08() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		String custID = SalesQuotationExcellib.getExcelDat("SQ", 10, 8);
		 String prodID = SalesQuotationExcellib.getExcelDat("SQ", 10, 12);
		 String Qnty = SalesQuotationExcellib.getExcelDat("SQ", 10, 14);
		 String unitp = SalesQuotationExcellib.getExcelDat("SQ", 10, 17);
		 String taxCode = SalesQuotationExcellib.getExcelDat("SQ", 10, 20);
		 String disc = SalesQuotationExcellib.getExcelDat("SQ", 10, 23);
		 String total =SalesQuotationExcellib.getExcelDat("SQ", 10, 30);
		 
		 BigDecimal expected = new BigDecimal(total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SqNew);
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(7000);
		SqDiscountINR SqDis = PageFactory.initElements(driver, SqDiscountINR.class);
		SqDis.discountINR(custID,  prodID, Qnty,unitp, taxCode,disc);
		BigDecimal Actual = new BigDecimal(SqDiscountINR.amt);
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
	}
	

@Test(priority = 9)
public void SqIN_CashDiscount_Percentage_TC_09() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	String custID = SalesQuotationExcellib.getExcelDat("SQ", 11, 8);
	 String prodID = SalesQuotationExcellib.getExcelDat("SQ", 11, 12);
	 String Qnty = SalesQuotationExcellib.getExcelDat("SQ", 11, 14);
	 String unitp = SalesQuotationExcellib.getExcelDat("SQ", 11, 17);
	 String taxCode = SalesQuotationExcellib.getExcelDat("SQ", 11, 20);
	 String disc = SalesQuotationExcellib.getExcelDat("SQ", 11, 23);
	 String total =SalesQuotationExcellib.getExcelDat("SQ", 11, 30);
	 
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SqNew);
	Thread.sleep(2000);
	driver.navigate().refresh();
	Thread.sleep(7000);
	SqDiscountWithpercentage SqDis = PageFactory.initElements(driver, SqDiscountWithpercentage.class);
	SqDis.SqWithDis(custID,  prodID, Qnty,unitp, taxCode,disc);
	BigDecimal Actual = new BigDecimal(SqDiscountWithpercentage.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}



@Test(priority=10)
public void SqIN_TradeDiscount_TC_10() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	String custID = SalesQuotationExcellib.getExcelDat("SQ", 12, 8);
	 String prodID = SalesQuotationExcellib.getExcelDat("SQ", 12, 12);
	 String Qnty = SalesQuotationExcellib.getExcelDat("SQ", 12, 14);
	 String unitp = SalesQuotationExcellib.getExcelDat("SQ", 12, 17);
	 String taxCode = SalesQuotationExcellib.getExcelDat("SQ", 12, 20);
	 String discTrade = SalesQuotationExcellib.getExcelDat("SQ", 12, 23);
	 String total =SalesQuotationExcellib.getExcelDat("SQ", 12, 30);
	 
	 
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SqNew);
	Thread.sleep(2000);
	driver.navigate().refresh();
	Thread.sleep(7000);
	SQwithTradeDis SqTradeDis = PageFactory.initElements(driver, SQwithTradeDis.class);
	SqTradeDis.SqWithTradeDis(custID,prodID, Qnty,unitp, taxCode,discTrade);
	BigDecimal Actual = new BigDecimal(SQwithTradeDis.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}

@Test(priority =11)
public void SqIN_MultiCurrCust_TC_11() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	 String custID = SalesQuotationExcellib.getExcelDat("SQ", 13, 8);
	 String prodID = SalesQuotationExcellib.getExcelDat("SQ", 13, 12);
	 String Qnty = SalesQuotationExcellib.getExcelDat("SQ", 13, 14);
	 String unitp = SalesQuotationExcellib.getExcelDat("SQ", 13, 17);
	 String taxCode  = SalesQuotationExcellib.getExcelDat("SQ", 13, 20);
	 String total =SalesQuotationExcellib.getExcelDat("SQ", 13, 30);
 
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	driver.get(Constant.SqNew);
	Thread.sleep(2000);
	driver.navigate().refresh();
	Thread.sleep(7000);
	
	SqMultiCurrCust SqMultiCur =PageFactory.initElements(driver, SqMultiCurrCust.class);
	SqMultiCur.sqMultiCurr(custID, prodID, Qnty, unitp,taxCode);
	
	BigDecimal Actual = new BigDecimal(SqMultiCurrCust.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}

@Test(priority=12)
public void SqIN_customSqId_TC_12() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	 String sqID = SalesQuotationExcellib.getExcelDat("SQ", 14, 7);
	 String custID = SalesQuotationExcellib.getExcelDat("SQ", 14, 8);
	 String prodID = SalesQuotationExcellib.getExcelDat("SQ", 14, 12);
	 String Qnty = SalesQuotationExcellib.getExcelDat("SQ", 14, 14);
	 String unitp = SalesQuotationExcellib.getExcelDat("SQ", 14, 17);
	 String taxCode  = SalesQuotationExcellib.getExcelDat("SQ", 14, 20);
	 String total = SalesQuotationExcellib.getExcelDat("SQ", 14, 30);
	 
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);

	driver.get(Constant.SqNew);
	Thread.sleep(2000);
	driver.navigate().refresh();
	Thread.sleep(7000);
	SqCustomSQid sqCustomID = PageFactory.initElements(driver, SqCustomSQid.class);
	sqCustomID.sqCustID(sqID,custID, prodID, Qnty,unitp,taxCode);

	BigDecimal Actual = new BigDecimal(SqCustomSQid.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	System.out.println("total Amount verified");
}

@Test(priority=13)
public void SqIN_diffSite_TC_13() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	String siteID = SalesQuotationExcellib.getExcelDat("SQ", 15, 6);
	 String custID = SalesQuotationExcellib.getExcelDat("SQ", 15, 8);
	 String prodID = SalesQuotationExcellib.getExcelDat("SQ", 15, 12);
	 String Qnty = SalesQuotationExcellib.getExcelDat("SQ", 15, 14);
	 String unitp = SalesQuotationExcellib.getExcelDat("SQ", 15, 17);
	 String taxCode = SalesQuotationExcellib.getExcelDat("SQ", 15, 20);
	 String total =SalesQuotationExcellib.getExcelDat("SQ", 15, 30);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	
	driver.get(Constant.SqNew);
	Thread.sleep(2000);
	driver.navigate().refresh();
	Thread.sleep(7000);
	SqDiffSite saveMethod = PageFactory.initElements(driver, SqDiffSite.class);
	saveMethod.diffSite(siteID,custID, prodID, Qnty,unitp ,taxCode);
	BigDecimal Actual = new BigDecimal(SqDiffSite.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}

@Test(priority=15)
public void SqIN_custIDvalidation_TC_15() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	String custID = SalesQuotationExcellib.getExcelDat("SQ", 17, 8);
	 
	driver.get(Constant.SqNew);
	Thread.sleep(2000);
	driver.navigate().refresh();
	Thread.sleep(7000);
	SqcustIDvalidation sqIDMsg = PageFactory.initElements(driver, SqcustIDvalidation.class);
	sqIDMsg.custIDvalid(custID);
	
}

@Test(priority=14)
public void SqIN_sqIDvalidation_TC_14() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	String sqID = SalesQuotationExcellib.getExcelDat("SQ", 16, 7);
	
	driver.get(Constant.SqNew);
	Thread.sleep(2000);
	driver.navigate().refresh();
	Thread.sleep(7000);
	
	SqIDvalidation sqIdValid = PageFactory.initElements(driver, SqIDvalidation.class);
	sqIdValid.sqIdValid(sqID);
	
}

@Test(priority=16)
public void SqIN_qtyValidation_TC_16() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	String custID = SalesQuotationExcellib.getExcelDat("SQ", 18, 8);
	 String prodID = SalesQuotationExcellib.getExcelDat("SQ", 18, 12);
	 String Qnty = SalesQuotationExcellib.getExcelDat("SQ", 18, 14);
	 
	driver.get(Constant.SqNew);
	Thread.sleep(2000);
	driver.navigate().refresh();
	Thread.sleep(7000);
	SqQtyValidation sqQtyValid = PageFactory.initElements(driver, SqQtyValidation.class);
	sqQtyValid.qtyValid(custID, prodID, Qnty);
	
}


	@Test(priority =17)
	public void SqIN_Tax_Discount_TC_17() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException

	{

		String custID = SalesQuotationExcellib.getExcelDat("SQ", 19, 8);
		 String prodID = SalesQuotationExcellib.getExcelDat("SQ", 19, 10);
		 String Qnty = SalesQuotationExcellib.getExcelDat("SQ", 19, 13);
		 String unitp = SalesQuotationExcellib.getExcelDat("SQ", 19, 16);
		 String DIS = SalesQuotationExcellib.getExcelDat("SQ", 19, 17);
		 String taxCode1= SalesQuotationExcellib.getExcelDat("SQ", 19, 19);
		 String taxCode2 = SalesQuotationExcellib.getExcelDat("SQ", 19, 20);
		 String total =SalesQuotationExcellib.getExcelDat("SQ", 19, 31);
		 BigDecimal expected = new BigDecimal(total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		 driver.get(Constant.SqNew);
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(7000);
		SqProductTaxDiscount prodTaxDis = PageFactory.initElements(driver, SqProductTaxDiscount.class);
	prodTaxDis.ProdTaxDis(custID, prodID, Qnty,unitp ,DIS,taxCode1,taxCode2, "late");
	BigDecimal Actual = new BigDecimal(SqProductTaxDiscount.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	 System.out.println("total Amount verified");
}




@Test(priority=18)
public void SqIN_InclusiveTax_TC_18() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException

{
	 String custID = SalesQuotationExcellib.getExcelDat("SQ", 20, 8);
	 String prodID = SalesQuotationExcellib.getExcelDat("SQ", 20, 12);
	 String Qnty = SalesQuotationExcellib.getExcelDat("SQ", 20, 14);
	 String unitp = SalesQuotationExcellib.getExcelDat("SQ", 20, 17);
	 String taxCode= SalesQuotationExcellib.getExcelDat("SQ", 20, 20);
	 
	 String total =SalesQuotationExcellib.getExcelDat("SQ", 20, 30);
	 
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);

	driver.get(Constant.SqNew);
	Thread.sleep(2000);
	driver.navigate().refresh();
	Thread.sleep(7000);
	SQTaxInclusive prodInCLu = PageFactory.initElements(driver, SQTaxInclusive.class);
	prodInCLu.sqTaxIncl(custID, prodID, Qnty,unitp,taxCode);
	BigDecimal Actual = new BigDecimal(SQTaxInclusive.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	System.out.println("total Amount verified");

}

@Test(priority=19)
public void SqIN_Exclusive_Tax_TC_19() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException 

{
	 String custID = SalesQuotationExcellib.getExcelDat("SQ", 21, 8);
	 String prodID = SalesQuotationExcellib.getExcelDat("SQ", 21, 12);
	 String Qnty = SalesQuotationExcellib.getExcelDat("SQ", 21, 14);
	 String unitp = SalesQuotationExcellib.getExcelDat("SQ", 21, 17);
	  String taxcode = SalesQuotationExcellib.getExcelDat("SQ", 21, 20);
	  String total =SalesQuotationExcellib.getExcelDat("SQ", 21, 30);
	  
	  BigDecimal expected = new BigDecimal(total);
	  expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	
	driver.get(Constant.SqNew);
	Thread.sleep(2000);
	driver.navigate().refresh();
	Thread.sleep(7000);
	SQTaxExclusive prodExTax = PageFactory.initElements(driver, SQTaxExclusive.class);
	prodExTax.sqTaxExc(custID, prodID, Qnty,unitp, taxcode);
	BigDecimal Actual = new BigDecimal(SQTaxExclusive.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	System.out.println("total Amount verified");
	
}
@Test(priority=20)
public void SqIN_MultiProduct_TC_20() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	String custID = SalesQuotationExcellib.getExcelDat("SQ", 22, 8);

	  String taxCode = SalesQuotationExcellib.getExcelDat("SQ", 22, 20);
	  String total =SalesQuotationExcellib.getExcelDat("SQ", 22, 30);
	  
	  BigDecimal expected = new BigDecimal(total);
		 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		driver.get(Constant.SqNew);
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(7000);
		SqMultiproduct sqMultiprod =PageFactory.initElements(driver,SqMultiproduct.class);
		sqMultiprod.multiproduct(custID, taxCode);
		BigDecimal Actual = new BigDecimal(SqMultiproduct.amt);
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
		
}

	
@Test(priority =21)
public void SqIN_TDSWith_OtherTax_TC_21() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	 String custID = SalesQuotationExcellib.getExcelDat("SQ", 26, 8);
	 String prodID = SalesQuotationExcellib.getExcelDat("SQ", 26, 12);
	 String Qnty = SalesQuotationExcellib.getExcelDat("SQ", 26, 14);
	 String unitp = SalesQuotationExcellib.getExcelDat("SQ", 26, 17);
	 String taxCode1= SalesQuotationExcellib.getExcelDat("SQ", 26, 20);
	 String taxCode2 = SalesQuotationExcellib.getExcelDat("SQ", 26, 21);
	
	driver.get(Constant.SqNew);
	Thread.sleep(2000);
	driver.navigate().refresh();
	Thread.sleep(7000);
	SqTDSWithOtherTax prodMultiTax = PageFactory.initElements(driver, SqTDSWithOtherTax.class);
	prodMultiTax.TDSProdMultTax(custID, prodID, Qnty, unitp,taxCode1,taxCode2);


}

@Test(priority = 22)
public void SqIN_proposalPrint_TC_22() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	 String custID = SalesQuotationExcellib.getExcelDat("SQ", 43, 8);
	 String prodID = SalesQuotationExcellib.getExcelDat("SQ", 43, 12);
	 String Qnty = SalesQuotationExcellib.getExcelDat("SQ", 43, 14);
	 
	 String unitp = SalesQuotationExcellib.getExcelDat("SQ", 43, 17);
	 String taxCode = SalesQuotationExcellib.getExcelDat("SQ", 43, 20);
	 String total =SalesQuotationExcellib.getExcelDat("SQ", 43, 30);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 
		driver.get(Constant.SqNew);
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(7000);
		SqProposalPrint muomprod =PageFactory.initElements(driver, SqProposalPrint.class);
		muomprod.sqPropPdf(custID,  prodID, Qnty,unitp,taxCode);
		BigDecimal Actual = new BigDecimal(SqProposalPrint.amt);
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
}
@Test(priority=23)
public void SqIN_viewSQ_TC_23() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	 String sqID = SalesQuotationExcellib.getExcelDat("SQ", 28, 8);
	 
	 String total =SalesQuotationExcellib.getExcelDat("SQ", 28, 30);
	 
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 
	 	driver.get(Constant.SqMain);
		Thread.sleep(2000);
		
		SQview viewSQ = PageFactory.initElements(driver, SQview.class);
		viewSQ.viewSQ(sqID);
		BigDecimal Actual = new BigDecimal(SQview.amt);
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
}


@Test(priority=24)
public void SqIN_closeSQ_TC_24() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	 String custID = SalesQuotationExcellib.getExcelDat("SQ", 29, 8);
	 String prodID = SalesQuotationExcellib.getExcelDat("SQ", 29, 12);
	 String Qnty = SalesQuotationExcellib.getExcelDat("SQ", 29, 14);
	 String unitp = SalesQuotationExcellib.getExcelDat("SQ", 29, 17);
	 String taxCode = SalesQuotationExcellib.getExcelDat("SQ", 29, 20);
	 String total =SalesQuotationExcellib.getExcelDat("SQ", 29, 30);
	
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 
	 	driver.get(Constant.SqNew);
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(7000);
		Sqclose Close = PageFactory.initElements(driver, Sqclose.class);
		Close.MUOMbatchableprod(custID, prodID, Qnty, unitp, taxCode);
		BigDecimal Actual = new BigDecimal(Sqclose.amt);
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
}

@Test(priority=25)
public void SqIN_SqToSo_TC_25() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	 String custID = SalesQuotationExcellib.getExcelDat("SQ", 30, 8);
	 String prodID = SalesQuotationExcellib.getExcelDat("SQ", 30, 12);
	 String Qnty = SalesQuotationExcellib.getExcelDat("SQ", 30, 14);
	 
	 String unitp = SalesQuotationExcellib.getExcelDat("SQ", 30, 16);
	 String taxCode = SalesQuotationExcellib.getExcelDat("SQ", 30, 20);
	 String total =SalesQuotationExcellib.getExcelDat("SQ", 30, 30);
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	 
		driver.get(Constant.SqNew);
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(7000);
		SqToSoProduct sqtoSO =PageFactory.initElements(driver, SqToSoProduct.class);
		sqtoSO.sqtoSO(custID,  prodID, Qnty,unitp,taxCode);
		BigDecimal Actual = new BigDecimal(SqToSoProduct.amt);
		Assert.assertEquals(Actual,expected,"total amount not correct");
		 System.out.println("total Amount verified");
}

@Test(priority =26)
public void SqIN_RefField_TC_26() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException

{

	 String custID = SalesQuotationExcellib.getExcelDat("SQ", 31, 8);
	 String ref = SalesQuotationExcellib.getExcelDat("SQ", 31, 9);
	 String prodID = SalesQuotationExcellib.getExcelDat("SQ", 31, 12);
	 String Qnty = SalesQuotationExcellib.getExcelDat("SQ", 31, 14);
	 String unitp = SalesQuotationExcellib.getExcelDat("SQ", 31, 17);
	 String taxCode = SalesQuotationExcellib.getExcelDat("SQ", 31, 20);
	 String total =SalesQuotationExcellib.getExcelDat("SQ", 31, 30);
	 
	 BigDecimal expected = new BigDecimal(total);
	 expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
	
	driver.get(Constant.SqNew);
	Thread.sleep(2000);
	driver.navigate().refresh();
	Thread.sleep(7000);
	SqWithRefField sqRef = PageFactory.initElements(driver, SqWithRefField.class);
	sqRef.sqRefField(custID,ref, prodID, Qnty, unitp,taxCode);

	BigDecimal Actual = new BigDecimal(SqWithRefField.amt);
	Assert.assertEquals(Actual,expected,"total amount not correct");
	System.out.println("total Amount verified");

}


@Test(priority=27)
public void SqIN_BlankSq_TC_27() throws InterruptedException
{
	driver.get(Constant.SqNew);
	Thread.sleep(2000);
	driver.navigate().refresh();
	Thread.sleep(7000);
	SqBlankPageSaving BlPgS = PageFactory.initElements(driver, SqBlankPageSaving.class);
	BlPgS.Blank_PageSaving();
	
}

@Test(priority=28)
public void SqIN_BlankDETlevel_TC_28() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	String custID = SalesQuotationExcellib.getExcelDat("SQ", 34, 8);
	driver.get(Constant.SqNew);
	Thread.sleep(2000);
	driver.navigate().refresh();
	Thread.sleep(7000);
	SqBlankDETlevel BlPgS = PageFactory.initElements(driver, SqBlankDETlevel.class);
	BlPgS.BlankDETSaving(custID);
	
}

@Test(priority=29)
public void SQshipmentLength_TC_29() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	String custID = SalesQuotationExcellib.getExcelDat("SQ", 35, 8);
	
	driver.get(Constant.SqNew);
	Thread.sleep(5000);
	//driver.navigate().refresh();
	//Thread.sleep(7000);
	ShipmentLength shpLngth =PageFactory.initElements(driver, ShipmentLength.class);
	shpLngth.ShipLength(custID);
}

@Test(priority=30)
public void SaleIN_Memo_Length_TC_30() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	String custID = SalesQuotationExcellib.getExcelDat("SQ", 36, 8);
	 String prodID = SalesQuotationExcellib.getExcelDat("SQ", 36, 10);
	 String Qnty = SalesQuotationExcellib.getExcelDat("SQ", 36, 13);
	 String unitp = SalesQuotationExcellib.getExcelDat("SQ", 36, 16);
	 String memo = SalesQuotationExcellib.getExcelDat("SQ", 36, 28);
	
		driver.get(Constant.SqNew);
		Thread.sleep(7000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		SqMemoLentgh MEMOlentgh = PageFactory.initElements(driver, SqMemoLentgh.class);
		MEMOlentgh.memoLentgh(custID, prodID, Qnty, unitp, memo);
	
}

@Test(priority=31)
public void SqIN_TC_Length_TC_31() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
   {
	 String custID = SalesQuotationExcellib.getExcelDat("SQ", 37, 8);
	 String prodID = SalesQuotationExcellib.getExcelDat("SQ", 37, 10);
	 String Qnty = SalesQuotationExcellib.getExcelDat("SQ", 37, 13);
	 String unitp = SalesQuotationExcellib.getExcelDat("SQ", 37, 16);
	 String tc = SalesQuotationExcellib.getExcelDat("SQ", 37, 29);
	    driver.get(Constant.SqNew);
		Thread.sleep(7000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		SqTCLenth TClentgh = PageFactory.initElements(driver, SqTCLenth.class);
		TClentgh.tcLentgh(custID, prodID, Qnty, unitp,tc);
		
   }
			
}



