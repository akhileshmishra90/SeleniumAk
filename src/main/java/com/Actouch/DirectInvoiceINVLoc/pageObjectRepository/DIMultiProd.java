package com.Actouch.DirectInvoiceINVLoc.pageObjectRepository;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.SO_Excellib;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
public class DIMultiProd {
	public static String Grossamt;
	public static String totalTaxamt;
	public static String Subtotal;
	public static String amt;
	public static String exp;
	private static Connection connection;
    private static Statement statement;
    private static ResultSet rs;
    public static String CUST_ID;
    public static String CUST_Name; 
    public static BigDecimal TOTAL_AMT;
    public static BigDecimal Total_Tax;
    public static String HiberNate_SeQ;
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
		WebElement qntEdt;
	   @FindBy(xpath=".//*[@id='taxCalc']/tbody/tr[2]/td[5]/span[2]/input")
		WebElement IssueUom;
	   @FindBy(id="secQty")
		WebElement qntedt2;
		@FindBy(xpath="//button[contains(text(),'Ok')]")
		WebElement aftrqntOkEdt;
		@FindBy(xpath ="//div[@class='addbtn']")//xpath="//div[@id='creso-table']/div[1]/div/div[2]/label[contains(text(),'Add Row')]")
		WebElement AddRow;
	   @FindBy(xpath="//label[@data-bind='html: DIInventory.totalAmt']")
	   WebElement TotalEdt;
	   @FindBy(xpath="//label[@data-bind='html: DIInventory.totalTax']")
	   WebElement TotalTaxEdt;
	   @FindBy(xpath="//label[@data-bind='html: DIInventory.grossAmt']")
	   WebElement SubtotalEDt;
	   @FindBy(id="btnSave")
	   WebElement SaveEdt;
	   @FindBy(xpath="html/body/div[9]/div/div[3]/button")
	   WebElement AfterSaveEdt;
	   @FindBy(xpath="//input[@aria-controls='SHP_Table']")
	  WebElement Searchext;
	   @FindBy(xpath=".//*[@id='SHP_Table']/tbody/tr[1]/td[5]")
	   WebElement ResultEdt;
 //	   @FindBy(xpath=".//*[@id='SHP_Table']/tbody/tr[1]/td[15]/div/button")
//	   WebElement ActionEdt;
//	   @FindBy(partialLinkText="View Invoice")
//	   WebElement ViewInvEdt;
	   static   SO_Excellib DI_Excellib = new SO_Excellib("D:\\Selenium\\Direct Invoice.xlsx");
	    public void payltr(String Customer_Id) throws Exception
	   {
		   WebDriverCommonlib.waitForPageToLoad();
		   Actions act = new Actions(Browser.driver);
		   SoftAssert softAssertion= new SoftAssert();
		    exp = SOidEdt.getAttribute("value");
		    Thread.sleep(3000);
		    DSOCustEdt.sendKeys(Customer_Id);
		 Thread.sleep(1000);
		  act.sendKeys(Keys.TAB).perform();
		   JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
		   kl.executeScript("window.scrollBy(0,300)", "");
			int j = 1;
  			int l= 4;
  	        int count = 1;
  	        do {
  	        	
  	        	while (j < 13)
  	   	{
String qty = DI_Excellib.getExcelDat("Multi", l, 13);
  	      			  	      String prdID = DI_Excellib.getExcelDat("Multi", l, 10);
	  	   		Browser.driver.findElement(By.id("prdSo_"+j)).sendKeys(prdID);
  	      			  	      	Thread.sleep(1000);
  	      	act.sendKeys(Keys.TAB).perform();
  	      String unitP = DI_Excellib.getExcelDat("Multi", l, 16);
  	      	Browser.driver.findElement(By.id("unitprice_"+j)).sendKeys(unitP);	
  	      	String taxCode=DI_Excellib.getExcelDat("Multi", l, 19);
  	      	
  	      	String taxAmtExp =DI_Excellib.getExcelDat("Multi", l, 21);
  	      	
  	      	String subTotalExp = DI_Excellib.getExcelDat("Multi", l, 20);	
  	      	//String subTotalAct =Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[10]/input")).getAttribute("value");
  	      if(j == 1)                  //Inventory_product
  	      		{
  	             Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[5]/div/div[2]/span")).click();
		  			roleSelProdEdt.click();
		  			qntEdt.sendKeys(qty);
		  			aftrqntOkEdt.click();
		  			Thread.sleep(1000);
		  			Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[9]/div/div/span[text()='Tax Details']")).click();
		  			 for(int i=1;i<10;i++)
		  	  {
		  	String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
		  		  if(count1.equals(taxCode)){
		  			Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
		  			Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
		  		  
		  		  	break;
		  		  	
		  		  }
		  	  }
		  		BigDecimal taxAmtExp1 =new BigDecimal(taxAmtExp);
		  			taxAmtExp1 = taxAmtExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
		  			BigDecimal subTotalExp1 =new BigDecimal(subTotalExp);
		  			subTotalExp1 = subTotalExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
		  			
		  			String taxAmtAct = Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[9]/div[1]/div/input")).getAttribute("value");
		  			BigDecimal taxAmtAct1= new BigDecimal(taxAmtAct);
		  			
		  			String subTotalAct =Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[10]/input")).getAttribute("value");
		  			BigDecimal subTotalAct1= new BigDecimal(subTotalAct);
		  			softAssertion.assertEquals(subTotalAct1, subTotalExp1,"Subtotal for line no"+j+"wrong");
			  	System.out.println("SubTotal for line no"+j+" Correct");
			  	softAssertion.assertEquals(taxAmtAct1, taxAmtExp1,"Tax Amount for line no"+j+" is wrong");
		  	    System.out.println("Tax Amount for line no"+j+" Correct");
			  	
		  			 j++;
						  
  	      		break;
  	      		
  	      		}
  	    else if (j == 2)             //	non_inventory		  	      			
  	      		{

Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr[2]/td[5]/div/div[1]/input")).sendKeys(qty);
Thread.sleep(1000);
Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[9]/div/div/span[text()='Tax Details']")).click();
 for(int i=1;i<10;i++)
{
String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
if(count1.equals(taxCode)){
Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();

	break;
	
}
}
 BigDecimal taxAmtExp1 =new BigDecimal(taxAmtExp);
	taxAmtExp1 = taxAmtExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
	BigDecimal subTotalExp1 =new BigDecimal(subTotalExp);
	subTotalExp1 = subTotalExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
	
	String taxAmtAct = Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[9]/div[1]/div/input")).getAttribute("value");
	BigDecimal taxAmtAct1= new BigDecimal(taxAmtAct);
	
	String subTotalAct =Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[10]/input")).getAttribute("value");
	BigDecimal subTotalAct1= new BigDecimal(subTotalAct);
	softAssertion.assertEquals(subTotalAct1, subTotalExp1,"Subtotal for line no"+j+"wrong");
System.out.println("SubTotal for line no"+j+" Correct");
softAssertion.assertEquals(taxAmtAct1, taxAmtExp1,"Tax Amount for line no"+j+" is wrong");
System.out.println("Tax Amount for line no"+j+" Correct"); 

j++;
  	      			break;
  	      		  	      }
  	  else if(j == 3)                    //MUOM
      		{
  		  Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[5]/div/div[2]/span")).click();
  		  roleSelProdEdt.click();
  		  	qntEdt.sendKeys(qty);
  		  		Browser.driver.findElement(By.xpath("//input[@class='form-control createPO-suppId ui-autocomplete-input']")).sendKeys("DZ");
  		  			act.sendKeys(Keys.ARROW_DOWN).perform();
  		  				act.sendKeys(Keys.ENTER).perform();
  		  aftrqntOkEdt.click();
  		Thread.sleep(1000);
		Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[9]/div/div/span[text()='Tax Details']")).click();
		 for(int i=1;i<10;i++)
  {
String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
	  if(count1.equals(taxCode)){
		Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
		Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
	  
	  	break;
	  	
	  }
  }
		 BigDecimal taxAmtExp1 =new BigDecimal(taxAmtExp);
			taxAmtExp1 = taxAmtExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
			BigDecimal subTotalExp1 =new BigDecimal(subTotalExp);
			subTotalExp1 = subTotalExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
			
			String taxAmtAct = Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[9]/div[1]/div/input")).getAttribute("value");
			BigDecimal taxAmtAct1= new BigDecimal(taxAmtAct);
			
			String subTotalAct =Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[10]/input")).getAttribute("value");
			BigDecimal subTotalAct1= new BigDecimal(subTotalAct);
			softAssertion.assertEquals(subTotalAct1, subTotalExp1,"Subtotal for line no"+j+"wrong");
	  	System.out.println("SubTotal for line no"+j+" Correct");
	  	softAssertion.assertEquals(taxAmtAct1, taxAmtExp1,"Tax Amount for line no"+j+" is wrong");
	    System.out.println("Tax Amount for line no"+j+" Correct");	 
  		  			j++;
      		break;
      		}
  	else if(j == 4)                            //batchable_item
		{
		
		kl.executeScript("window.scrollBy(0,300)", "");
		Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[5]/div/div[2]/span")).click();
	  				roleSelProdEdt.click();
	  			qntEdt.sendKeys(qty);
	  			aftrqntOkEdt.click();
	  			Thread.sleep(1000);
	  			Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[9]/div/div/span[text()='Tax Details']")).click();
	  			 for(int i=1;i<10;i++)
	  	  {
	  	String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
	  		  if(count1.equals(taxCode)){
	  			Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
	  			Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
	  		  
	  		  	break;
	  		  	
	  		  }
	  	  }
	  			BigDecimal taxAmtExp1 =new BigDecimal(taxAmtExp);
	  			taxAmtExp1 = taxAmtExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
	  			BigDecimal subTotalExp1 =new BigDecimal(subTotalExp);
	  			subTotalExp1 = subTotalExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
	  			
	  			String taxAmtAct = Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[9]/div[1]/div/input")).getAttribute("value");
	  			BigDecimal taxAmtAct1= new BigDecimal(taxAmtAct);
	  			
	  			String subTotalAct =Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[10]/input")).getAttribute("value");
	  			BigDecimal subTotalAct1= new BigDecimal(subTotalAct);
	  			softAssertion.assertEquals(subTotalAct1, subTotalExp1,"Subtotal for line no"+j+"wrong");
		  	System.out.println("SubTotal for line no"+j+" Correct");
		  	softAssertion.assertEquals(taxAmtAct1, taxAmtExp1,"Tax Amount for line no"+j+" is wrong");
	  	    System.out.println("Tax Amount for line no"+j+" Correct");	 
	  			 
j++;
		break;
		
		}
  	else if(j == 5)                                  //MUOMBatchable
		{
		
		kl.executeScript("window.scrollBy(0,300)", "");
		Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[5]/div/div[2]/span")).click();
		for (int i= 1;i<=10;i++)
	 	   {
	 	 String batch =  Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[3]/input")).getAttribute("value");
	 	 if(batch.equals("BQ1"))
	 	 {
	 		 Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[1]/input")).click();
	 		 Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[13]/input")).sendKeys(qty);
	 	Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[14]/div/span/input")).sendKeys("DZ");
	 	act.sendKeys(Keys.ARROW_DOWN).perform();
	 	act.sendKeys(Keys.ENTER).perform();
	 	break;
	 		 }
	 	 i++;
	 	 }
	 	 aftrqntOkEdt.click();
	 	Thread.sleep(1000);
		Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[9]/div/div/span[text()='Tax Details']")).click();
		 for(int i=1;i<10;i++)
  {
String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
	  if(count1.equals(taxCode)){
		Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
		Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
	  
	  	break;
	  	
	  }
  }
		 BigDecimal taxAmtExp1 =new BigDecimal(taxAmtExp);
			taxAmtExp1 = taxAmtExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
			BigDecimal subTotalExp1 =new BigDecimal(subTotalExp);
			subTotalExp1 = subTotalExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
			
			String taxAmtAct = Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[9]/div[1]/div/input")).getAttribute("value");
			BigDecimal taxAmtAct1= new BigDecimal(taxAmtAct);
			
			String subTotalAct =Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[10]/input")).getAttribute("value");
			BigDecimal subTotalAct1= new BigDecimal(subTotalAct);
			softAssertion.assertEquals(subTotalAct1, subTotalExp1,"Subtotal for line no"+j+"wrong");
	  	System.out.println("SubTotal for line no"+j+" Correct");
	  	softAssertion.assertEquals(taxAmtAct1, taxAmtExp1,"Tax Amount for line no"+j+" is wrong");
	    System.out.println("Tax Amount for line no"+j+" Correct");	 
	  		
j++;
		break;
		
		}
  	 else if(j == 6)                                   //AlterProduct  
		{
		

	  		kl.executeScript("window.scrollBy(0,300)", "");
	  		Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[4]/span/input")).sendKeys(Keys.chord(Keys.CONTROL,"a"),"DZ");
			   act.sendKeys(Keys.ARROW_DOWN).perform();
			   act.sendKeys(Keys.ENTER).perform();
	   		Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[5]/div/div[2]/span")).click();
	   		roleSelProdEdt.click();
			 qntEdt.sendKeys(qty);
			   aftrqntOkEdt.click();
			   Browser.driver.findElement(By.id("unitprice_"+j)).sendKeys(unitP);
			   Thread.sleep(1000);
	  			Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[9]/div/div/span[text()='Tax Details']")).click();
		  		 for(int i=1;i<10;i++)
			  {
			String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
				  if(count1.equals(taxCode)){
					Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
					Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
				  
				  	break;
				  	
				  }
			  }
		  		BigDecimal taxAmtExp1 =new BigDecimal(taxAmtExp);
	  			taxAmtExp1 = taxAmtExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
	  			BigDecimal subTotalExp1 =new BigDecimal(subTotalExp);
	  			subTotalExp1 = subTotalExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
	  			
	  			String taxAmtAct = Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[9]/div[1]/div/input")).getAttribute("value");
	  			BigDecimal taxAmtAct1= new BigDecimal(taxAmtAct);
	  			
	  			String subTotalAct =Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[10]/input")).getAttribute("value");
	  			BigDecimal subTotalAct1= new BigDecimal(subTotalAct);
	  			softAssertion.assertEquals(subTotalAct1, subTotalExp1,"Subtotal for line no"+j+"wrong");
		  	System.out.println("SubTotal for line no"+j+" Correct");
		  	softAssertion.assertEquals(taxAmtAct1, taxAmtExp1,"Tax Amount for line no"+j+" is wrong");
	  	    System.out.println("Tax Amount for line no"+j+" Correct"); 
	   		
	   		j++;
   		break;
	  	 }
  	else if(j == 7)                                 //AlterBatchProd
		{
  		kl.executeScript("window.scrollBy(0,300)", "");
  		Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[4]/span/input")).sendKeys(Keys.chord(Keys.CONTROL,"a"),"PK");
		   act.sendKeys(Keys.ARROW_DOWN).perform();
		   act.sendKeys(Keys.ENTER).perform();
   		Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[5]/div/div[2]/span")).click();
   	 for (int i= 1;i<=10;i++)
	   {
		      String batch =  Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[3]/input")).getAttribute("value");
	 if(batch.equals("BQ2"))
	 {
		 Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[1]/input")).click();
		  Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[13]/input")).sendKeys(qty);
	 break;
	 }
	 }
   	aftrqntOkEdt.click();
   	Browser.driver.findElement(By.id("unitprice_"+j)).sendKeys(unitP);
   	Thread.sleep(1000);
		Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[9]/div/div/span[text()='Tax Details']")).click();
		 for(int i=1;i<10;i++)
  {
String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
	  if(count1.equals(taxCode)){
		Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
		Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
	  
	  	break;
	  	
	  }
  }
		 BigDecimal taxAmtExp1 =new BigDecimal(taxAmtExp);
			taxAmtExp1 = taxAmtExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
			BigDecimal subTotalExp1 =new BigDecimal(subTotalExp);
			subTotalExp1 = subTotalExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
			
			String taxAmtAct = Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[9]/div[1]/div/input")).getAttribute("value");
			BigDecimal taxAmtAct1= new BigDecimal(taxAmtAct);
			
			String subTotalAct =Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[10]/input")).getAttribute("value");
			BigDecimal subTotalAct1= new BigDecimal(subTotalAct);
			softAssertion.assertEquals(subTotalAct1, subTotalExp1,"Subtotal for line no"+j+"wrong");
	  	System.out.println("SubTotal for line no"+j+" Correct");
	  	softAssertion.assertEquals(taxAmtAct1, taxAmtExp1,"Tax Amount for line no"+j+" is wrong");
	    System.out.println("Tax Amount for line no"+j+" Correct"); 
   		j++;
  		break; 
  	 }
  	else if(j == 8)                             //non_inventory With TDS
		{
  		Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[5]/div/div[1]/input")).sendKeys(qty);
  		Thread.sleep(1000);
			Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[9]/div/div/span[text()='Tax Details']")).click();
  		 for(int i=1;i<10;i++)
	  {
	String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
		  if(count1.equals(taxCode)){
			Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
			Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
		  
		  	break;
		  	
		  }
	  }
  		BigDecimal taxAmtExp1 =new BigDecimal(taxAmtExp);
			taxAmtExp1 = taxAmtExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
			BigDecimal subTotalExp1 =new BigDecimal(subTotalExp);
			subTotalExp1 = subTotalExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
			
//			String taxAmtAct = Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[9]/div[1]/div/input")).getAttribute("value");
//			BigDecimal taxAmtAct1= new BigDecimal(taxAmtAct);
			
			String subTotalAct =Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[10]/input")).getAttribute("value");
			BigDecimal subTotalAct1= new BigDecimal(subTotalAct);
			softAssertion.assertEquals(subTotalAct1, subTotalExp1,"Subtotal for line no"+j+"wrong");
  	System.out.println("SubTotal for line no"+j+" Correct");
//softAssertion.assertEquals(taxAmtAct1, taxAmtExp1,"Tax Amount for line no"+j+" is wrong");
//	    System.out.println("Tax Amount for line no"+j+" Correct"); 
//	  
 		j++;
  		break;
  	 }
  	else if( j == 9)                        //MUOMS
		{
  		//kl.executeScript("window.scrollBy(0,300)", "");
   		Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[5]/div/div[2]/span")).click();
   	 Browser.driver.findElement(By.name("roleFor")).click();
	  Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr[2]/td[10]/input")).sendKeys(qty);
	IssueUom.sendKeys("DZ" );
	   act.sendKeys(Keys.ARROW_DOWN).perform();
	   act.sendKeys(Keys.ENTER).perform();
	  qntedt2.sendKeys("2");
 aftrqntOkEdt.click();
 Browser.driver.findElement(By.id("unitprice_"+j)).sendKeys(unitP);
 Thread.sleep(1000);
	Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[9]/div/div/span[text()='Tax Details']")).click();
		 for(int i=1;i<10;i++)
  {
String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
	  if(count1.equals(taxCode)){
		Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
		Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
	  
	  	break;
	  	
	  }
  }
		 BigDecimal taxAmtExp1 =new BigDecimal(taxAmtExp);
			taxAmtExp1 = taxAmtExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
			BigDecimal subTotalExp1 =new BigDecimal(subTotalExp);
			subTotalExp1 = subTotalExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
			
			String taxAmtAct = Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[9]/div[1]/div/input")).getAttribute("value");
			BigDecimal taxAmtAct1= new BigDecimal(taxAmtAct);
			
			String subTotalAct =Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[10]/input")).getAttribute("value");
			BigDecimal subTotalAct1= new BigDecimal(subTotalAct);
			softAssertion.assertEquals(subTotalAct1, subTotalExp1,"Subtotal for line no"+j+"wrong");
	  	System.out.println("SubTotal for line no"+j+" Correct");
	  	softAssertion.assertEquals(taxAmtAct1, taxAmtExp1,"Tax Amount for line no"+j+" is wrong");
	    System.out.println("Tax Amount for line no"+j+" Correct");	 
 		j++;
  		break; 
  	 }
  	else if(j == 10)                        //BatchExpiry
		{
  		kl.executeScript("window.scrollBy(0,300)", "");
   		Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[5]/div/div[2]/span")).click();
   		for (int i= 1;i<=10;i++)
		   {
			      String batch =  Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[3]/input")).getAttribute("value");
		 if(batch.equals("BQ1"))
		 {
			 Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[1]/input")).click();
			  Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[13]/input")).sendKeys(qty);
		 break;
		 }
		 }
   		aftrqntOkEdt.click();
   		Thread.sleep(1000);
			Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[9]/div/div/span[text()='Tax Details']")).click();
  		 for(int i=1;i<10;i++)
	  {
	String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
		  if(count1.equals(taxCode)){
			Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
			Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
		  
		  	break;
		  	
		  }
	  }
  		BigDecimal taxAmtExp1 =new BigDecimal(taxAmtExp);
			taxAmtExp1 = taxAmtExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
			BigDecimal subTotalExp1 =new BigDecimal(subTotalExp);
			subTotalExp1 = subTotalExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
			
			String taxAmtAct = Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[9]/div[1]/div/input")).getAttribute("value");
			BigDecimal taxAmtAct1= new BigDecimal(taxAmtAct);
			
			String subTotalAct =Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[10]/input")).getAttribute("value");
			BigDecimal subTotalAct1= new BigDecimal(subTotalAct);
			softAssertion.assertEquals(subTotalAct1, subTotalExp1,"Subtotal for line no"+j+"wrong");
  	System.out.println("SubTotal for line no"+j+" Correct");
  	softAssertion.assertEquals(taxAmtAct1, taxAmtExp1,"Tax Amount for line no"+j+" is wrong");
	    System.out.println("Tax Amount for line no"+j+" Correct");	 
   		j++;
  		break; 
  	 }
  	else if(j == 11)                      //batch(multi Batch)
		{
  		//kl.executeScript("window.scrollBy(0,300)", "");
   		Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[5]/div/div[2]/span")).click();
 		
   	 for (int i= 1;i<=10;i++)
	   {
		      String batch =  Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[3]/input")).getAttribute("value");
	 if(batch.equals("BQ3"))
	 {
		 Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[1]/input")).click();
		  Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[13]/input")).sendKeys(qty);
	 break;
	 }
	 }
   //	aftrqntOkEdt.click();
   	//Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[5]/div/div[2]/span")).click();
   	 for (int i= 1;i<=10;i++)
	   {
		      String batch =  Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[3]/input")).getAttribute("value");
	 if(batch.equals("BQ1"))
	 {
		 Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[1]/input")).click();
		  Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[13]/input")).sendKeys(qty);
	 break;
	 }
	 i++;
	 }
   	aftrqntOkEdt.click();
   	Thread.sleep(1000);
		Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[9]/div/div/span[text()='Tax Details']")).click();
		 for(int i=1;i<10;i++)
  {
String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
	  if(count1.equals(taxCode)){
		Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
		Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
	  
	  	break;
	  	
	  }
  }
		 BigDecimal taxAmtExp1 =new BigDecimal(taxAmtExp);
			taxAmtExp1 = taxAmtExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
			BigDecimal subTotalExp1 =new BigDecimal(subTotalExp);
			subTotalExp1 = subTotalExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
			
			String taxAmtAct = Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[9]/div[1]/div/input")).getAttribute("value");
			BigDecimal taxAmtAct1= new BigDecimal(taxAmtAct);
			
			String subTotalAct =Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[10]/input")).getAttribute("value");
			BigDecimal subTotalAct1= new BigDecimal(subTotalAct);
			softAssertion.assertEquals(subTotalAct1, subTotalExp1,"Subtotal for line no"+j+"wrong");
	  	System.out.println("SubTotal for line no"+j+" Correct");
	  	softAssertion.assertEquals(taxAmtAct1, taxAmtExp1,"Tax Amount for line no"+j+" is wrong");
	    System.out.println("Tax Amount for line no"+j+" Correct");
		 
   		j++;
  		break; 
  	 }
  	else if (j==12)                  //Inventory_product(multi Location)
		{
  		//kl.executeScript("window.scrollBy(0,300)", "");
   		Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[5]/div/div[2]/span")).click();
   		
   	 for (int i= 1;i<=10;i++)
	   {
		      String location =  Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input")).getAttribute("value");
	 if(location.equals("STORES1"))
		 
	 {
		 Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[1]/input")).click();
		  Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[13]/input")).sendKeys(qty);
		  System.out.println(location);
	 break;
	 }
	
	 }
   	for (int i= 1;i<=10;i++)
	   {
		      String batch =  Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input")).getAttribute("value");
	 if(batch.equals("STORES2"))
	 {
		 Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[1]/input")).click();
		  Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr["+i+"]/td[13]/input")).sendKeys(qty);
	 break;
	 }
	 }
 	aftrqntOkEdt.click();
 	Thread.sleep(1000);
		Browser.driver.findElement(By.xpath("//table[@id='SODetailsTable']/tbody/tr["+j+"]/td[9]/div/div/span[text()='Tax Details']")).click();
		 for(int i=1;i<10;i++)
  {
String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
	  if(count1.equals(taxCode)){
		Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
		Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
	  
	  	break;
	  	
	  }
  }
		 BigDecimal taxAmtExp1 =new BigDecimal(taxAmtExp);
			taxAmtExp1 = taxAmtExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
			BigDecimal subTotalExp1 =new BigDecimal(subTotalExp);
			subTotalExp1 = subTotalExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
			
			String taxAmtAct = Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[9]/div[1]/div/input")).getAttribute("value");
			BigDecimal taxAmtAct1= new BigDecimal(taxAmtAct);
			
			String subTotalAct =Browser.driver.findElement(By.xpath(".//*[@id='SODetailsTable']/tbody/tr["+j+"]/td[10]/input")).getAttribute("value");
			BigDecimal subTotalAct1= new BigDecimal(subTotalAct);
			softAssertion.assertEquals(subTotalAct1, subTotalExp1,"Subtotal for line no"+j+"wrong");
	  	System.out.println("SubTotal for line no"+j+" Correct");
	  	softAssertion.assertEquals(taxAmtAct1, taxAmtExp1,"Tax Amount for line no"+j+" is wrong");
	    System.out.println("Tax Amount for line no"+j+" Correct");
 		
   		j++;
  		break;
  	 }
  	   }
  	        	
  	        	
  	     l++;
  	        	      count++;
  	          if(count < 13){
  	        	 Thread.sleep(1000);
  	        	AddRow.click();
  	        	  
  	          }
  	 } while (count < 13);
		  act.sendKeys(Keys.ENTER).perform();
		  totalTaxamt = TotalTaxEdt.getText(); 
 	       Subtotal = SubtotalEDt.getText(); 
 	      Grossamt = TotalEdt.getText();
		   SaveEdt.click();
		   AfterSaveEdt.click();
		  Browser.driver.get(Constant.newShpMain);
		  Thread.sleep(7000);
		  Searchext.sendKeys(exp);
		  Thread.sleep(3000);
		   String act2 = ResultEdt.getText();
		   softAssertion.assertEquals(act2, exp,"payment later after saving case == fail");
	  		System.out.println("payment later after saving case == pass");
	  		softAssertion.assertAll();
		    }
	   public static void payltrDB (String databaseURL,String user,String password,String query,String Column1, String Column2,String Total,String TotalTax) throws SQLException, ClassNotFoundException {
	       connection = null;
		    
		                Class.forName("com.mysql.jdbc.Driver");
		                System.out.println("Connecting to Database...");
		                connection = DriverManager.getConnection(databaseURL, user, password);
		                if (connection != null) {
		                    System.out.println("Connected to the Database...");
		                }
		            statement = connection.createStatement();
		            rs = statement.executeQuery(query);

		            while(rs.next()){
		            	HiberNate_SeQ = rs.getString("HIBERNATE_SEQ");
		            	CUST_ID =rs.getString(Column1) ;
		            	CUST_Name = rs.getString(Column2);
		            	TOTAL_AMT = rs.getBigDecimal(Total);
		            	Total_Tax = rs.getBigDecimal(TotalTax);
		  
		            	}
		            connection.close();
		    }
	   public static void payltrDB1 (String databaseURL,String user,String password,String query,String Prd,String QTY,String UNITPRICE,String LINE_TOTAL) throws Exception 
	   {
		   ArrayList<String> listprd=new ArrayList<String>();
		   ArrayList<String> listQty=new ArrayList<String>();
		   ArrayList<String> listunprice=new ArrayList<String>();
		   ArrayList<String> listlinetotal=new ArrayList<String>();
		   SoftAssert asser = new SoftAssert();
	       connection = null;
		    
		                Class.forName("com.mysql.jdbc.Driver");
		                System.out.println("Connecting to Database...");
		                connection = DriverManager.getConnection(databaseURL, user, password);
		                if (connection != null) {
		                    System.out.println("Connected to the Database...");
		                }
		            statement = connection.createStatement();
		            rs = statement.executeQuery(query);

		            while(rs.next()){
		            	
		            	listprd.add(rs.getString(Prd));
		            	listQty.add(rs.getString(QTY));
		            	listunprice.add(rs.getString(UNITPRICE));
		            	listlinetotal.add(rs.getString(LINE_TOTAL));
		  
		            	}
		            
		            
		            for(int i =0; i<13; i++){       // product verification
		            	
		            		String prdID = DI_Excellib.getExcelDat("Multi", i+26, 2);
					           asser.assertEquals(listprd.get(i), prdID,"prod ID went wrong");
		            	}
		            	
		            
		            
		            for(int i =0; i<13; i++){       // Quantity verification
		            	
		            		String Qty = DI_Excellib.getExcelDat("Multi", i+26, 3);
		            		BigDecimal QtyExp1 =new BigDecimal(Qty);
		            		QtyExp1 = QtyExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
		            		BigDecimal QtyAct1 =new BigDecimal(listQty.get(i));
		            		QtyAct1 = QtyAct1.setScale(2, BigDecimal.ROUND_HALF_UP);
		            		
					           asser.assertEquals(QtyAct1, QtyExp1,"Qty went wrong");
		            	}
		            	
		           
		            for(int i =0; i<13; i++){       // unit price verification verification\
		            	
		            		String unprice = DI_Excellib.getExcelDat("Multi", i+26, 4);
		            		BigDecimal unpriceExp1 =new BigDecimal(unprice);
		            		unpriceExp1 = unpriceExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
		            		BigDecimal unpriceAct1 =new BigDecimal(listunprice.get(i));
		            		unpriceAct1 = unpriceAct1.setScale(2, BigDecimal.ROUND_HALF_UP);
		            		 asser.assertEquals(unpriceAct1, unpriceExp1,"listunprice went wrong");
		            	
		            	
		            }
		            for(int i =0; i<13; i++){       // line total verification
		            	
		            		String linetotal = DI_Excellib.getExcelDat("Multi", i+26, 5);
		            		BigDecimal linetotalExp1 =new BigDecimal(linetotal);
		            		linetotalExp1 = linetotalExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
		            		BigDecimal linetotalAct1 =new BigDecimal(listlinetotal.get(i));
		            		linetotalAct1 = linetotalAct1.setScale(2, BigDecimal.ROUND_HALF_UP);
		            		 asser.assertEquals(linetotalAct1, linetotalExp1,"linetotal went wrong");
		            
		            	
		            }
		            
		           
		           asser.assertAll(); 
		            connection.close();
		    }
	   public static void payltrDB2 (String databaseURL,String user,String password,String query,String TAX_ID,String TAXABLE_AMT,String GROSS_AMT,String SGST_TAX_AMT,String CGST_TAX_AMT) throws Exception
	   {
		   ArrayList<String> listTax=new ArrayList<String>();
		   ArrayList<String> listtaxableAmt=new ArrayList<String>();
		   ArrayList<String> listGrossAmt=new ArrayList<String>();
		   ArrayList<String> listSGST=new ArrayList<String>();
		   ArrayList<String> listCGST=new ArrayList<String>();
		   SoftAssert asser = new SoftAssert();
	       connection = null;
		    
		                Class.forName("com.mysql.jdbc.Driver");
		                System.out.println("Connecting to Database...");
		                connection = DriverManager.getConnection(databaseURL, user, password);
		                if (connection != null) {
		                    System.out.println("Connected to the Database...");
		                }
		            statement = connection.createStatement();
		            rs = statement.executeQuery(query);

		            while(rs.next()){
		            	
		            	listTax.add(rs.getString(TAX_ID));
		            	listtaxableAmt.add(rs.getString(TAXABLE_AMT));
		            	listGrossAmt.add(rs.getString(GROSS_AMT));
		            	listSGST.add(rs.getString(SGST_TAX_AMT));
		            	listCGST.add(rs.getString(CGST_TAX_AMT));
		  
		            	
		            	}
		            for(int i =0; i<11; i++){       // Tax ID verification
		            	
	            		String taxID = DI_Excellib.getExcelDat("Multi", i+42, 2);
				           asser.assertEquals(listTax.get(i), taxID,"taxID went wrong");
	            	}
		            
		            for(int i =0; i<11; i++){       // TaxableAmount verification
		            	
	            		String taxableAmt = DI_Excellib.getExcelDat("Multi", i+42, 3);
	            		BigDecimal taxableAmtExp1 =new BigDecimal(taxableAmt);
	            		taxableAmtExp1 = taxableAmtExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
	            		BigDecimal taxableAmtAct1 =new BigDecimal(listtaxableAmt.get(i));
	            		taxableAmtAct1 = taxableAmtAct1.setScale(2, BigDecimal.ROUND_HALF_UP);
	            		
				           asser.assertEquals(taxableAmtAct1, taxableAmtExp1,"taxableAmt went wrong");
	            	}
	            	
	           
	            for(int i =0; i<11; i++){       // GrossAmt verification verification\
	            	
	            		String GrossAmt = DI_Excellib.getExcelDat("Multi", i+42, 4);
	            		BigDecimal GrossAmtExp1 =new BigDecimal(GrossAmt);
	            		GrossAmtExp1 = GrossAmtExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
	            		BigDecimal GrossAmtAct1 =new BigDecimal(listGrossAmt.get(i));
	            		GrossAmtAct1 = GrossAmtAct1.setScale(2, BigDecimal.ROUND_HALF_UP);
	            		 asser.assertEquals(GrossAmtAct1, GrossAmtExp1,"GrossAmt went wrong");
	            	
	            	
	            }
	            for(int i =0; i<11; i++){       // SGST verification
	            	
	            		String SGST = DI_Excellib.getExcelDat("Multi", i+42, 5);
	            		BigDecimal SGSTExp1 =new BigDecimal(SGST);
	            		SGSTExp1 = SGSTExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
	            		BigDecimal SGSTAct1 =new BigDecimal(listSGST.get(i));
	            		SGSTAct1 = SGSTAct1.setScale(2, BigDecimal.ROUND_HALF_UP);
	            		 asser.assertEquals(SGSTAct1, SGSTExp1,"SGST went wrong");
	            
	            	
	            }
	            for(int i =0; i<11; i++){       // CGST verification
	            	
            		String CGST = DI_Excellib.getExcelDat("Multi", i+42, 6);
            		BigDecimal CGSTExp1 =new BigDecimal(CGST);
            		CGSTExp1 = CGSTExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
            		BigDecimal CGSTAct1 =new BigDecimal(listCGST.get(i));
            		CGSTAct1 = CGSTAct1.setScale(2, BigDecimal.ROUND_HALF_UP);
            		 asser.assertEquals(CGSTAct1, CGSTExp1,"CGST went wrong");
            
            	
            }
	            
	           
	           asser.assertAll(); 
	           connection.close();
		            
	   }
	   }

