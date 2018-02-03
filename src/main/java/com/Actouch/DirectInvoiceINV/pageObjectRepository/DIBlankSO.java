package com.Actouch.DirectInvoiceINV.pageObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class DIBlankSO {
public static String amt;
	@FindBy(xpath="//p[contains(text(),'Customer Id cannot be blank')]")
	WebElement Errormessge;
	   @FindBy(id="btnSave")
	   WebElement SaveEdt;
	   @FindBy(xpath="html/body/div[9]/div/div[3]/button")
	   WebElement AfterSaveEdt;
	   @FindBy(xpath="//input[@aria-controls='SHP_Table']")
	  WebElement Searchext;
	   @FindBy(xpath="//table[@id='SHP_Table']/tbody/tr[1]/td[3]")
	   WebElement ResultEdt;
	   public void payltr() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	   {
		   WebDriverCommonlib.waitForPageToLoad();
		  String exp = "Customer Id cannot be blank";
		  SaveEdt.click();
		   String act2 = Errormessge.getText();
		    Assert.assertEquals(act2, exp,"BlankSO Error message   case == fail");
	  		System.out.println("BlankSO Error message case == pass");
		    }

}
