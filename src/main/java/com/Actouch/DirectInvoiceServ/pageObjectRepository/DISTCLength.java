package com.Actouch.DirectInvoiceServ.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class DISTCLength {
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
		@FindBy(xpath="//div[@data-bind='click: DIService.showTermsConditionModal']")
		WebElement TermCondEnable;
		@FindBy(xpath="//textarea[@placeholder='Terms and Conditions']")
		WebElement TermCondEdt;
		@FindBy(xpath="//button[@data-bind='click: ok']")
		WebElement SaveTCEdt;
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
	public void payLtr(String Cust,String Desc,String Category,String Unitprice,String TermCond ) throws InterruptedException
	{
	WebDriverCommonlib.waitForPageToLoad();
	int kh=4950;
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
	
	TermCondEnable.click();
	TermCondEdt.sendKeys(TermCond);
	 String fh =  TermCondEdt.getAttribute("value");
		int n = fh.length();
		System.out.println(n);
		 Assert.assertTrue(kh>=n, "Memo lenth is less than equal to 5000 == fail");
		 SaveEdt.click();
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
