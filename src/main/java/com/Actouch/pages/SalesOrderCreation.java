package com.Actouch.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesOrderCreation {
	@FindBy(xpath="//input[@data-bind='selectcontrolSiteSO:SOInventory.sitedesc']")
     private WebElement SiteEdt;
	@FindBy(id ="SoIsoId")
	private WebElement SOidEdt;
	@FindBy(id ="createSoCustId")
	private WebElement SoCustIdEdt;
	@FindBy(id ="SoIshipMaterials-select")
	private WebElement ShipNow;
	@FindBy(id="prdSo_1")
	private WebElement prdSo_1Edt;
	@FindBy(xpath="//div[@data-bind='if:chkLoc']/span")
	private WebElement prDetailsEdt;
	@FindBy(xpath=".//*[@id='taxCalc']/tbody/tr/td[1]/input[@data-bind ='checked: chkSelectAll ']")
	private WebElement roleSelProdEdt;
	@FindBy(xpath=".//*[@id='taxCalc']/tbody/tr/td[13]/input")
	private WebElement qntEdt;
	@FindBy(xpath="//input[@ data-bind='value: sellQty,enable:editQty']")
	private WebElement qntnormEdt;
	@FindBy(xpath="//button[contains(text(),'Ok')]")
	private WebElement aftrqntOkEdt;
	@FindBy(id="unitprice_1")
	private WebElement unitprice_1edt;
	@FindBy(xpath="//table[@id='SODetailsTable']/tbody/tr/td[9]/div/div/span[text()='Tax Details']")
	private WebElement taxEdt;
	@FindBy(xpath="//label[@data-bind='html: SOInventory.totalAmt']")
    private WebElement gettingTotalAmount;
	@FindBy(id ="btnSave")
	private WebElement btnSaveEdt;
	@FindBy(xpath="//p[contains(text(),'Sales Order')]")
	private WebElement saleConfirmMsgedt;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	private WebElement ConfirmSaveedt;
	@FindBy(xpath=".//*[@id='taxCalc']/tbody/tr[2]/td[5]/span[2]/input")
	private WebElement IssueUom;
	@FindBy(id="secQty")
	private WebElement qntedt2;
	@FindBy(xpath="//div[@id='creso-table']/div[1]/div/div[2]/label[contains(text(),'Add Row')]")
	private WebElement AddRowEdt;
		 @FindBy(xpath="//label[@data-bind='html: SOInventory.grossAmt']")
		   private WebElement SubTotalEdt;
		   @FindBy(xpath="//label[@data-bind='html: SOInventory.totalTax']")
		   private WebElement totalTaxEdt;
		   @FindBy(id="payType")
		   private WebElement payTypeEdt;
		   @FindBy(xpath="//table[@id='SODetailsTable']/tbody/tr/td[9]/div/div/span[text()='Tax Details']")
			private WebElement TaxDetails;
		   @FindBy(xpath="//input[@data-bind='value: ChequeNo,hasfocus:true']")
		  private WebElement chequeNoEdt;
		@FindBy(xpath="//input[@data-bind='value: recvdbankName,enable: hasColumn']")
		private WebElement recvdbankName;
		@FindBy(xpath="//input[@data-bind='value: Amount']")
	   private WebElement puttingTotalAmount;
	    @FindBy(xpath="//button[@data-bind='click: ok']")
		private WebElement savingcheq;
	    @FindBy(id="SoIpayMode-select")
	    private WebElement PaymodeEdt;
	    @FindBy(xpath="//input[@data-bind='checked: SOInventory.chkAdv1']")
		private WebElement SelectAdv;
	    @FindBy(id="advAmt")
		private WebElement AdvAmountEdt;
	    @FindBy(xpath="//input[@data-bind=' value: lineDisc']")
		private WebElement lineDiscountEdt;
	    @FindBy(id="SoIcrdtTerm-select")
		private WebElement CreditTermEdt;
	    @FindBy(id ="overAllDisc")
	   private WebElement soDiscountEdt;
	    @FindBy(xpath="(//button[@class='btn btn-default dropdown-toggle'])[4]")
	   private WebElement discountType;
	    @FindBy(xpath=".//*[@id='table1']/tbody/tr[3]/td[2]/div/div[2]/ul/li[2]/a/span")
		private WebElement INR; 
	    @FindBy(xpath="//button[contains(.,'Cash')]")
		private WebElement cashtype;
	    @FindBy(xpath = ".//*[@id='table1']/tbody/tr[3]/td[2]/div/div[1]/ul/li[2]/a/span")
	   private WebElement CashDisType;
	    @FindBy(id ="tcs-select")
		private WebElement EnableTCS;
	    @FindBy(id ="tcsTax-select")
		private WebElement SelectTCSEdt;
	   public SalesOrderCreation(WebDriver driver)
	   {
		   PageFactory.initElements(driver, this);
	   }
	   public void SiteEdt(String Site)
	   {
		   SiteEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Site);
	   }
	   public String SOidEdt()
	   {
		  String So= SOidEdt.getAttribute("value");
		  return So;
	   }
	   public void SoCustIdEdt(String Customer_Id)
	   {
		   SoCustIdEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Customer_Id);
	   }
	   
	   public void prdSo_1Edt(String Product_Id)
	   {
		   prdSo_1Edt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Product_Id);
	   }
	   public void prDetailsEdt()
	   {
		   prDetailsEdt.click();
	   }
	   public void roleSelProdEdt()
	   {
		   roleSelProdEdt.click();
	   }
	   public void qntEdt(String Quantity)
	   {
		   qntEdt.sendKeys(Quantity);
	   }
	   public void qntnormEdt(String Quantity)
	   {
		   qntnormEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Quantity);
	   }
	   public void aftrqntOkEdt()
	   {
		   aftrqntOkEdt.click();
	   }
	   public void taxEdt()
	   {
		   taxEdt.click();
	   }
	 public void unitprice_1edt(String unit_price)
	 {
		 unitprice_1edt.sendKeys(unit_price);
	 }
	 public String gettingTotalAmount()
	 {
		 String amt =  gettingTotalAmount.getText();
		 return amt;
	 }
	 
	 public void btnSaveEdt()
	 {
		 btnSaveEdt.click();
	 }
	 public void ConfirmSaveedt()
	 {
		 ConfirmSaveedt.click();
	 }
	 public void IssueUom(String Issuom) {
	
		 IssueUom.sendKeys(Keys.chord(Keys.CONTROL,"a"),Issuom); 
	 }
	 public void qntedt2(String Qnt2) 
	 {
		 qntedt2.sendKeys(Keys.chord(Keys.CONTROL,"a"),Qnt2); ;
	 }
	 public void AddRowEdt()
	 {
		 AddRowEdt.click();
	 }
	 public String SubTotalEdt()
	 {
		String ST= SubTotalEdt.getText();
		return ST;
	 }
	 public String totalTaxEdt()
	 {
		 String ST= totalTaxEdt.getText();
					return ST;
		 }
		 public void ShipNow(String ShipNowedt)
		 {
			 ShipNow.sendKeys(Keys.chord(Keys.CONTROL,"a"),ShipNowedt);
		 }
		 public void payTypeEdt(String payType)
		 {
			 payTypeEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),payType);
		 }
		 public void TaxDetails()
		 {
			 TaxDetails.click();
		 }
		 public void chequeNo(String ChequeNo)
		 {
		 chequeNoEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),ChequeNo);
		 }
		 public void recvdbankName(String RcvBN)
		 {
			 recvdbankName.sendKeys(Keys.chord(Keys.CONTROL,"a"),RcvBN);
		 }
		 public void puttingTotalAmount(String arg)
		 {
		 puttingTotalAmount.sendKeys(Keys.chord(Keys.CONTROL,"a"),arg);
		 }
		 public void savingcheq()
		 {
			 savingcheq.click();
		 }
		 public void PaymodeEdt(String Paymode)
		 {
			 PaymodeEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Paymode);
		 }
		 public void SelectAdv()
		 {
			 SelectAdv.click();
		 }
		 public void AdvAmountEdt(String AdvAmt)
		 {
			 AdvAmountEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),AdvAmt);
		 }
		 public void lineDiscountEdt(String lineDiscount)
		 {
			 lineDiscountEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),lineDiscount);
		 }
		 public void CreditTermEdt(String CreditTerm)
		 {
			 CreditTermEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),CreditTerm);
		 }
		 public void soDiscountEdt(String soDiscount)
		 {
			 soDiscountEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),soDiscount);
		 }
		 public void discountType()
		 {
			 discountType.click();
		 }
		 public void INR()
		 {
			  INR.click();
		 }
		 public void cashtype()
		 {
			 cashtype.click();
		 }
		 public void CashDisType()
		 {
			 CashDisType.click();
		 }
		 public void EnableTCS(String TCS)
		 {
			 EnableTCS.sendKeys(Keys.chord(Keys.CONTROL,"a"),TCS);
		 }
		 public void SelectTCSEdt(String SelectTCS)
		 {
			 SelectTCSEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),SelectTCS);
		}
}
