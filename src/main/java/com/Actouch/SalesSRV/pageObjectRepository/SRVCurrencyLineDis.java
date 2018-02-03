package com.Actouch.SalesSRV.pageObjectRepository;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
public class SRVCurrencyLineDis {
   public static String amt ;
	@FindBy(id="SoSsoId")
	WebElement SOSIdEdt;
	@FindBy(id="custid_createSOS")
	WebElement CustEdt;
	@FindBy(xpath="//textarea[@placeholder='Enter Service Description (Max 1990 characters)']")
	WebElement DescEdt;
	@FindBy(xpath="//input[@data-bind='selectcontrolExpenseAcSOSInput:prdId']")
	WebElement CategoryEdt;
	@FindBy(id="unitprice")
	WebElement UnitpriceEdt;
	@FindBy(xpath="//span[@data-bind='text: discTypeLine']")
	WebElement discTypeLine;
	@FindBy(xpath="//a[@data-bind='click: discTypeA']/span")
	WebElement DiscType2;
	@FindBy(xpath="//input[@data-bind=' value: lineDisc']")
	WebElement DiscountEdt;
	@FindBy(xpath="//label[@data-bind='html: SOService.totalAmt']")
	WebElement TotalEdt;
	@FindBy(id="btnSaveSO")
	WebElement SaveEdt;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement ConfirmEdt;
	 @FindBy(xpath="//input[@aria-controls='SOTable']")
	    WebElement searchtxt;
	   @FindBy(xpath="//table[@id='SOTable']/tbody/tr/td[2]")
	   WebElement actval;
	public void payLtr(String Cust,String Desc,String Category,String Unitprice,String Discount ) throws InterruptedException
	{
	WebDriverCommonlib.waitForPageToLoad();
	Actions act = new Actions(Browser.driver);
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
	WebDriverCommonlib.waitForElementPresent(discTypeLine);
	 act.moveToElement(discTypeLine).click().perform();
	 WebDriverCommonlib.waitForElementPresent(DiscType2);
	 act.moveToElement(DiscType2).click().perform();
	 DiscountEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Discount);
	act.sendKeys(Keys.ENTER).perform();
	amt=TotalEdt.getText();
	SaveEdt.click();
	ConfirmEdt.click();
	 Browser.driver.get(Constant.SalesMain);
	  Thread.sleep(7000);
	  searchtxt.sendKeys(exp);
	   String act2 = actval.getText();
	    Assert.assertEquals(act2, exp,"payment later after saving case == fail");
 		System.out.println("payment later after saving case == pass");
	   
	
	}

}
