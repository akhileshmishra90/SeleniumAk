package com.Actouch.SalesINV.pageObjectRepository;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
public class ARPartialChequeReceivable {
	public static String amt; 
	@FindBy(xpath="//input[@aria-controls='SOTable']")
    WebElement searchtxt;
@FindBy(xpath="//table[@id='SOTable']/tbody/tr/td[5]")
WebElement CustId;
@FindBy(id="custId_AR")
WebElement CustEdt;
@FindBy(id="salesOrderList-select")
WebElement SOidEdt;
@FindBy(xpath="//input[@placeholder='Voucher Number']")
WebElement Voucher;
@FindBy(xpath=".//*[@id='ReceibaleTable']/tbody/tr/td[1]/input")
WebElement Selectprod;
@FindBy(id="amtTopay")
WebElement Receive;
@FindBy(id="arpayMode-select")
WebElement paytype;
@FindBy(xpath="//input[@data-bind='value: ChequeNo,hasfocus:true']")
   WebElement chequeNo;
@FindBy(xpath="//input[@data-bind='value: recvdbankName,enable: hasColumn']")
WebElement recvdbankName;
@FindBy(xpath="//label[@data-bind='html: AccountReceivable.totalAmt']")
WebElement gettingTotalAmount;
@FindBy(xpath="//input[@data-bind='value: Amount']")
WebElement puttingTotalAmount;
@FindBy(xpath="//button[@data-bind='click: ok']")
WebElement savingcheq;
@FindBy(id="btnSave")
WebElement saveEdt;
@FindBy(xpath="html/body/div[9]/div/div[3]/button")
WebElement AfterSaving;
@FindBy(id="custIDAR")
WebElement DashCustEdt;
@FindBy(xpath=".//*[@id='APTable_filter']/label/input")
WebElement SearchAR;
@FindBy(xpath="//table[@id='APTable']/tbody/tr/td[2]/a")
WebElement Result;
public void ChequePartialReceivable(String Amount,String BankName,String ChequeNo,String RecvdbankName) throws InterruptedException
{
WebDriverCommonlib.waitForPageToLoad();
	String exp=searchtxt.getAttribute("value"); 
String Cust= CustId.getText();
 Browser.driver.get(Constant.AccountsReceivable);
 CustEdt.sendKeys(Cust);
Actions act = new Actions(Browser.driver);
act.sendKeys(Keys.ARROW_DOWN).perform();
act.sendKeys(Keys.ENTER).perform();
SOidEdt.sendKeys(exp);
act.sendKeys(Keys.ARROW_DOWN).perform();
act.sendKeys(Keys.ENTER).perform();
String Excepted = Voucher.getAttribute("value");
Thread.sleep(1000);
Selectprod.click();
Receive.sendKeys(Amount);
act.sendKeys(Keys.ENTER).perform();
amt = gettingTotalAmount.getText();
paytype.clear();
paytype.sendKeys(BankName);
act.sendKeys(Keys.ARROW_DOWN).perform();
act.sendKeys(Keys.ENTER).perform();
chequeNo.sendKeys(ChequeNo);
recvdbankName.sendKeys(RecvdbankName);
puttingTotalAmount.clear();
	puttingTotalAmount.sendKeys(amt);
	savingcheq.click();
saveEdt.click();
AfterSaving.click();
Browser.driver.get(Constant.ARDashBoard);
DashCustEdt.sendKeys(Cust);
act.sendKeys(Keys.ARROW_DOWN).perform();
act.sendKeys(Keys.ENTER).perform();
Thread.sleep(2000);
SearchAR.sendKeys(Excepted );
	String actual = Result.getText();
	 Assert.assertEquals(actual, Excepted, "partial Receivable ==fail");
	 System.out.println("partial Receivable == pass");
}


}
