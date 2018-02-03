package com.Actouch.DirectReceiptINV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Actouch.Purchase.generic_Lib.Browser;

public class UPDRReference {
       public static String amt;
    @FindBy(xpath="//input[@aria-controls='POR_Table']")
	WebElement SerchPor;
    @FindBy(xpath="//button[text()='Actions']")
    WebElement Action;
    @FindBy(linkText="Update PO Receipt")
    WebElement UpdateReceipt;
    @FindBy(id="PORSoRefno")
    WebElement UPRefEdt;
    @FindBy(id="soRefAmt")
    WebElement soRefAmtEdt;
    @FindBy(xpath="//label[@data-bind='html: DPInventoryUpd.netAmt']")
    WebElement Total;
    @FindBy(id="btnSave")
    WebElement Save;
    @FindBy(xpath="html/body/div[9]/div/div[3]/button")
    WebElement OkEdt;
    @FindBy(linkText="View PO Receipt")
    WebElement ViewReceipt;
    @FindBy(xpath="//label[@data-bind='html:PORInventory.soRefno']")
    WebElement Result;
    public void SuppID (String UPRef,String UPRefAmt) throws InterruptedException
    {
 	   WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
 	   Actions act= new Actions(Browser.driver);
 	   String PORID =SerchPor.getAttribute("value");
 	   wait.until(ExpectedConditions.visibilityOf(Action));
 	   act.moveToElement(Action).click().perform();
 	   wait.until(ExpectedConditions.visibilityOf(UpdateReceipt));
 	   act.moveToElement(UpdateReceipt).click().perform();
 	   UPRefEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),UPRef);
 	 String  Expected =UPRefEdt.getAttribute("value") ;
 	   soRefAmtEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),UPRefAmt);
 	  amt=Total.getText();
 	   Save.click();
 	   OkEdt.click();
 	   wait.until(ExpectedConditions.visibilityOf(SerchPor));
 	   SerchPor.sendKeys(Keys.chord(Keys.CONTROL,"a"),PORID);
 	   wait.until(ExpectedConditions.visibilityOf(Action));
 	   act.moveToElement(Action).click().perform();
 	   wait.until(ExpectedConditions.visibilityOf(ViewReceipt));
 	   act.moveToElement(ViewReceipt).click().perform();
 	   wait.until(ExpectedConditions.visibilityOf(Result));
 	   String Actual = Result.getText();
 	   Assert.assertEquals(Actual, Expected,"Supp Name not updated as Usual");
 	   System.out.println("Supp Name  updated as Usual");
    }
		

}
