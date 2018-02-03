package com.Actouch.DirectInvoiceServ.pageObjectRepository;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
public class UPDSRVReference {
   @FindBy(xpath="//input[@aria-controls='SOTable']")
	WebElement TextEdt;
	@FindBy(xpath="//input[@aria-controls='SHP_Table']")
	WebElement SerchTextEdt;
	@FindBy(xpath="//button[text()='Actions']")
	WebElement ClickForUpdate;
	@FindBy(linkText ="Update Invoice")
	WebElement openForUpdatePage;
	@FindBy(id="poRefno")
	WebElement ReferenceEdt;
	@FindBy(id="poRefAmt")
	WebElement ReferenceAmtEdt;
	@FindBy(id="btnSaveSO")
	WebElement UpdateEdt;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement AfterSave;
	@FindBy(linkText="View Invoice")
	WebElement clickforView;
	@FindBy(xpath="//label[@data-bind='html:soShipment.poRefno']")
	WebElement Result;
	public void upadateCust(String Refernce,String RefernceAmt ) throws InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
	    Actions Act = new Actions(Browser.driver);
		String SoId=SerchTextEdt.getAttribute("value");
	    ClickForUpdate.click();
	    openForUpdatePage.click();
	    ReferenceEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Refernce);
	    Act.sendKeys(Keys.ENTER).perform();
	    ReferenceAmtEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),RefernceAmt);
	    Act.sendKeys(Keys.ENTER).perform();
	    String Expected = ReferenceEdt.getAttribute("value");
	    UpdateEdt.click();
	    AfterSave.click();
	    SerchTextEdt.sendKeys(SoId);
	    ClickForUpdate.click();
	    clickforView.click();
	    Thread.sleep(3000);
	   String Actual= Result.getText();
	   Assert.assertEquals(Actual, Expected,"given Reference name is invalid");
	System.out.println("given Reference name is valid");
	}
		

}
