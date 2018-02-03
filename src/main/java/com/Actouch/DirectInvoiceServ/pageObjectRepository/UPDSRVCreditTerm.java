package com.Actouch.DirectInvoiceServ.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
public class UPDSRVCreditTerm {
   @FindBy(xpath="//input[@aria-controls='SOTable']")
	WebElement TextEdt;
	@FindBy(xpath="//input[@aria-controls='SHP_Table']")
	WebElement SerchTextEdt;
	@FindBy(xpath="//button[text()='Actions']")
	WebElement ClickForUpdate;
	@FindBy(linkText ="Update Invoice")
	WebElement openForUpdatePage;
	@FindBy(id="SoScrdtTerm-select")
	WebElement CreditEdt;
	@FindBy(id="btnSaveSO")
	WebElement UpdateEdt;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement AfterSave;
	@FindBy(linkText="View Invoice")
	WebElement clickforView;
	@FindBy(xpath="//label[@data-bind='html:soShipment.crdtId']")
	WebElement Result;
	public void upadateCust(String Credit) throws InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
	    Actions Act = new Actions(Browser.driver);
		String SoId=SerchTextEdt.getAttribute("value");
	    ClickForUpdate.click();
	    openForUpdatePage.click();
	    CreditEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Credit);
	    Act.sendKeys(Keys.ARROW_DOWN).perform();
	    Act.sendKeys(Keys.ENTER).perform();
	    String Expected = CreditEdt.getAttribute("value");
        UpdateEdt.click();
	    AfterSave.click();
	    SerchTextEdt.sendKeys(SoId);
	    ClickForUpdate.click();
	    clickforView.click();
	    Thread.sleep(3000);
	   String Actual= Result.getText();
	   Assert.assertEquals(Actual, Expected,"given customer name is invalid");
	System.out.println("given Customer name is valid");
	}
		

}
