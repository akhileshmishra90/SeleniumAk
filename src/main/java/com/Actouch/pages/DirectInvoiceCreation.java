package com.Actouch.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class DirectInvoiceCreation {
	  @FindBy(xpath="//input[@data-bind='selectcontrolSiteDI:DIInventory.sitedesc' ]")
	  WebElement SiteEdt;
	   @FindBy(id="SoIsoId")	
	   WebElement SOidEdt;
	   @FindBy(id="createDinvCustId")
	   WebElement DSOCustEdt;
	   @FindBy(id="prdSo_1")
	   WebElement PrDSO;
	   @FindBy(xpath="//div[@data-bind='if:chkLoc']/span[@class='label label-warning']")
	   WebElement peDetailsEdt;
	   @FindBy(xpath=".//*[@id='taxCalc']/tbody/tr[1]/td[1]/input")
	   WebElement roleSelProdEdt;
	   @FindBy(xpath=".//*[@id='taxCalc']/tbody/tr[1]/td[13]/input")
	   WebElement Qnty;
	   @FindBy(xpath="//input[@data-bind='value: sellQty,enable:editQty']")
	   WebElement norQntyEdt;
	   @FindBy(xpath="//button[@data-bind='click: ok']")
	   WebElement SaveProdModel;
	   @FindBy(id="unitprice_1")
	   WebElement UnitPrice;
	   @FindBy(xpath="//label[@data-bind='html: DIInventory.totalAmt']")
	   WebElement TotalEdt;
	   @FindBy(id="btnSave")
	   WebElement SaveEdt;
	   @FindBy(xpath="html/body/div[9]/div/div[3]/button")
	   WebElement AfterSaveEdt;
	   @FindBy(xpath ="//div[@class='addbtn']")//xpath="//div[@id='creso-table']/div[1]/div/div[2]/label[contains(text(),'Add Row')]")
		WebElement AddRow;
	   @FindBy(xpath="//label[@data-bind='html: DIInventory.totalTax']")
	   WebElement TotalTaxEdt;
	   @FindBy(xpath="//label[@data-bind='html: DIInventory.grossAmt']")
	   WebElement SubtotalEDt;
	   @FindBy(xpath=".//*[@id='taxCalc']/tbody/tr[2]/td[5]/span[2]/input")
		WebElement IssueUom;
	   @FindBy(id="secQty")
		WebElement qntedt2;
	  
	   public DirectInvoiceCreation(WebDriver driver )
	   {
		   PageFactory.initElements(driver, this);
	   }
	   public void SiteEdt(String Site)
	   {
		   SiteEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Site);
	   }
	   public String SOidEdt()
	   {
		   String So =  SOidEdt.getAttribute("value");
		   return So;
	   }
	   public void DSOCustEdt(String Customer_Id)
	   {
		   DSOCustEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Customer_Id);
	   }
	   public void PrDSO(String Product_Id)
	   {
		   PrDSO.sendKeys(Keys.chord(Keys.CONTROL,"a"),Product_Id);
	   }
	   public void peDetailsEdt()
	   {
		   peDetailsEdt.click();
	   }
	   public void roleSelProdEdt()
	   {
		   roleSelProdEdt.click();
	   }
	   public void ModelQnty(String Quantity)
	   {
		   Qnty.sendKeys(Quantity);
	   }
	   public void NormQnty(String Quantity)
	   {
		   norQntyEdt.sendKeys(Quantity);
	   }
	   
	   public void SaveProdModel()
	   {
		   SaveProdModel.click();
	   }
	   public void UnitPrice(String unit_price)
	   {
		   UnitPrice.sendKeys(unit_price);
	   }
	   public String TotalEdt()
	   {
		  String To = TotalEdt.getText();
		  return To;
		   
	   }
	   public String TotalTaxEdt()
	   {
		  String To = TotalTaxEdt.getText();
		  return To;
		   
	   }
	   public String SubtotalEDt()
	   {
		  String To = SubtotalEDt.getText();
		  return To;
		   
	   }
	   public void SaveEdt()
	   {
		   SaveEdt.click();
	   }
	   public void AfterSaveEdt()
	   {
		   AfterSaveEdt.click();
	   }
	   public void AddRow()
	   {
		   AddRow.click();
	   }
	   public void IssueUom(String IssueUomEdt)
	   {
		   IssueUom.sendKeys(IssueUomEdt);
	   }
	   public void qntedt2(String qntedt2Edt)
	   {
		   qntedt2.sendKeys(qntedt2Edt);
	   }

}
