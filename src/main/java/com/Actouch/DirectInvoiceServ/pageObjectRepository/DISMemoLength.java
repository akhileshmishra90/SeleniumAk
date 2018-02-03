package com.Actouch.DirectInvoiceServ.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class DISMemoLength {
	public static String amt;
	@FindBy(xpath="//label[@data-bind='html: NewSHPMain.OrderTypeSelected'] ")
	WebElement changeType;
	@FindBy(linkText="Service")
	WebElement Service;
	  @FindBy(id ="SoSsoId")
	  WebElement SOSIdEdt;
	  @FindBy(id="custid_createSOS")
	  WebElement CustEdt;
	  @FindBy(xpath="//textarea[@data-bind='value: prdDesc']")
	  WebElement DescEdt;
	   @FindBy(xpath="//input[@data-bind='selectcontrolExpenseAcSOSInput:prdId']")
	  WebElement CategoryEdt;
	  @FindBy(id="unitprice")
	  WebElement UnitpriceEdt;
	   @FindBy(id="memo")
	   WebElement MemoEdt;
		@FindBy(xpath="//label[@data-bind ='html: DIService.totalAmt']")
		WebElement TotalEdt;
		@FindBy(id="btnSaveSO")
	   WebElement 	SaveEdt;
		 @FindBy(xpath="html/body/div[9]/div/div[3]/button")
		   WebElement ConfirmEdt;
		   @FindBy(xpath="//input[@aria-controls='SHP_Table']")
		  WebElement Searchext;
		   @FindBy(xpath="//table[@id='SHP_Table']/tbody/tr[1]/td[3]")
		   WebElement ResultEdt;
	public void payLtr(String Cust,String Desc,String Category,String Unitprice,String Memo ) throws InterruptedException
	{
	WebDriverCommonlib.waitForPageToLoad();
	 int kh = 495;
	Actions act = new Actions(Browser.driver);
	changeType.click();
	Thread.sleep(4000);
	Service.click();
	String exp = SOSIdEdt.getAttribute("value");
	Thread.sleep(3000);
	CustEdt.sendKeys(Cust);
	Thread.sleep(1000);
	act.sendKeys(Keys.TAB).perform();
	DescEdt.sendKeys(Desc);
   CategoryEdt.sendKeys(Category);
	act.sendKeys(Keys.ARROW_DOWN).perform();
	act.sendKeys(Keys.ENTER).perform();
	UnitpriceEdt.sendKeys(Unitprice);
	MemoEdt.sendKeys(Memo);
	 String fh =  MemoEdt.getAttribute("value");
		int n = fh.length();
		Assert.assertTrue(kh>=n, "Memo lenth is less than equal to 495 == fail");
		 amt=TotalEdt.getText();
	SaveEdt.click();
	ConfirmEdt.click();
	 Browser.driver.get(Constant.SalesMain);
	  Thread.sleep(7000);
	   // saleConfirmMsgedt.getText();
	  Searchext.sendKeys(exp);
	   String act2 = ResultEdt.getText();
	    Assert.assertEquals(act2, exp,"payment later after saving case == fail");
 		System.out.println("payment later after saving case == pass");
	   
	
	}


}
