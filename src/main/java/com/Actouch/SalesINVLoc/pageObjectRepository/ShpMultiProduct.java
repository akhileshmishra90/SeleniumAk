
package com.Actouch.SalesINVLoc.pageObjectRepository;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.SO_Excellib;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
public class ShpMultiProduct {
	public static String Excepted;
	public static String amt;
	public static String totalTax;
	public static String grossAmt;
	private static Connection connection;
    private static Statement statement;
    private static ResultSet rs;
    public static String CUST_ID;
    public static String CUST_Name; 
    public static BigDecimal TOTAL_AMT;
    public static BigDecimal Total_Tax;
    public static String HiberNate_SeQ;
	 @FindBy(xpath="//input[@aria-controls='SOTable']")
	    WebElement searchtxt;
	@FindBy(id="invoiceId")
	WebElement InvoiceId;
	@FindBy(id="custIdForShp")
	WebElement CustIdShpedt;
	@FindBy(xpath="//div[@id='SOTable_filter']/label/input")
	WebElement SearchforSo;
	@FindBy(xpath="//table[@id='SOTable']/tbody/tr/td[2]/a")
	WebElement chooseSoId;
	@FindBy(xpath="//table[@id='PODetailsTable']/tbody/tr/td[1]/input")
	WebElement selecProd;
    @FindBy(xpath="//table[@id='PODetailsTable']/tbody/tr/td[7]/label")
	WebElement RemainQnty;
    @FindBy(xpath="//span[contains(text(),'Product')]")
    WebElement productDetail;
    @FindBy(xpath="//table[@id='taxCalc']/tbody/tr/td[12]/input")
 WebElement issueQnty;
 @FindBy(xpath="//button[contains(text(),'Ok')]")
 WebElement aftrsavingQnty;
 @FindBy(xpath="//input[@class='form-control createPO-suppId ui-autocomplete-input']")
 WebElement uomEdt;
 @FindBy(xpath="//table[@id='SOTable']/tbody/tr/td[5]")
 WebElement CustId;
 @FindBy(id="btnSave")
 WebElement shipsaving;
 @FindBy(xpath="html/body/div[9]/div/div[3]/button")
 WebElement aftSavingShp;
 @FindBy(xpath="//div[@id='crsobtn']/a")
 WebElement viewInvoice;
 @FindBy(xpath="//div[@id='SHP_Table_filter']/label/input")
 WebElement InvSearch;
 @FindBy(xpath=".//*[@id='SHP_Table']/tbody/tr/td[5]")
 WebElement Result;
 @FindBy(xpath="//label[@data-bind='html: soShipment.totalTax']")
 WebElement TotalTaxEdt;
 @FindBy(xpath="//label[@data-bind='html: soShipment.grossAmt']")
 WebElement grossAmtEdt;
 @FindBy(xpath="//table[@id='PODetailsTable']/tbody/tr/td[12]/span[contains(text(),'Tax Details')]")
 WebElement taxModel;
 @FindBy(xpath="//label[@data-bind='html: soShipment.totalAmt']")
 WebElement TotalEdt;
 static SO_Excellib SO_Excellib = new SO_Excellib("D:\\Selenium\\SaleOrderLOC.xlsx");

 public void fullShipment() throws InterruptedException
 {
	 WebDriverCommonlib.waitForPageToLoad(); 
	 String exp=searchtxt.getAttribute("value"); 
 	String Cust= CustId.getText();
 	 Browser.driver.get(Constant.shpMain);
 CustIdShpedt.sendKeys(Cust);
 	Actions act = new Actions(Browser.driver);
 	act.sendKeys(Keys.TAB).perform();
 	Thread.sleep(2000);
    SearchforSo.sendKeys(exp);
 	chooseSoId.click();
 	 Excepted = InvoiceId.getAttribute("value");
 	Thread.sleep(2000);
 	List<WebElement> els = Browser.driver.findElements( By.xpath("//input[@data-bind='checked: chkSelectAll']"));
 	int i = 1;
 for ( WebElement el : els ) {

    	Thread.sleep(1000);
 	    	el.click();
 	    	
 	    	if(i== 2 || i == 8)
 	    	{
 	    		String RF = Browser.driver.findElement( By.xpath("//table[@id='PODetailsTable']/tbody/tr["+i+"]/td[7]/label")).getText();
 	    		Browser.driver.findElement(By.id("soldQty_"+i+"")).sendKeys(RF);
 	    	}
 	    	else if (i==3 || i==5) {
 	    		//String RF = Browser.driver.findElement( By.xpath("//table[@id='PODetailsTable']/tbody/tr["+i+"]/td[7]/label")).getText();
				 Browser.driver.findElement(By.xpath(".//*[@id='PODetailsTable']/tbody/tr["+i+"]/td[9]/div[3]/span")).click(); 
 		          Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr[1]/td[13]/input")).sendKeys("1"); 
 	    	Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr[1]/td[14]/div/span/input")).sendKeys("DZ");
 	    	act.sendKeys(Keys.ARROW_DOWN).perform();
				act.sendKeys(Keys.ENTER).perform();
				Browser.driver.findElement(By.xpath("html/body/div[9]/form/div/div[3]/button[1]")).click();
				
 	    	}
 	    	else if(i==7 || i==10)
 	    	{
 	    		String RF = Browser.driver.findElement( By.xpath("//table[@id='PODetailsTable']/tbody/tr["+i+"]/td[7]/label")).getText();
	                Browser.driver.findElement(By.xpath(".//*[@id='PODetailsTable']/tbody/tr["+i+"]/td[9]/div[3]/span")).click(); 
	                Browser.driver.findElement(By.id("serInp1")).sendKeys("BQ2");
	                Browser.driver.findElement(By.xpath("//input[@data-bind='value: soldQty,enable: chkRjct']")).sendKeys(RF);
	                Browser.driver.findElement(By.xpath("html/body/div[9]/form/div/div[3]/button[1]")).click();
 	    	}
 		
 	    	else if (i == 9)
 	    	{
 	    		String RF = Browser.driver.findElement( By.xpath("//table[@id='PODetailsTable']/tbody/tr["+i+"]/td[7]/label")).getText();
 	    		Browser.driver.findElement(By.xpath(".//*[@id='PODetailsTable']/tbody/tr["+i+"]/td[9]/div[3]/span")).click(); 
 	    		Browser.driver.findElement(By.xpath("//input[@class='form-control uomformodal ui-autocomplete-input']")).sendKeys("DZ");
 	    		 Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr[2]/td[9]/input")).sendKeys(RF); 
	                Browser.driver.findElement(By.xpath("html/body/div[9]/form/div/div[3]/button[1]")).click();
 	    	}
 	    	else if(i == 11)
 	    	{
 	    		Browser.driver.findElement(By.xpath(".//*[@id='PODetailsTable']/tbody/tr["+i+"]/td[9]/div[3]/span")).click();
 	    		Browser.driver.findElement(By.id("serInp1")).sendKeys(Keys.chord(Keys.CONTROL,"a"),"BQ1"); 
 	    		Browser.driver.findElement(By.xpath("//input[@data-bind='value: soldQty,enable: chkRjct']")).sendKeys("1"); 
 	    		Browser.driver.findElement(By.id("serInp1")).sendKeys(Keys.chord(Keys.CONTROL,"a"),"BQ3");
 	    		Browser.driver.findElement(By.xpath("//input[@data-bind='value: soldQty,enable: chkRjct']")).sendKeys("1");
 	    		Browser.driver.findElement(By.xpath("html/body/div[9]/form/div/div[3]/button[1]")).click();
 	    	}
 	    	else if(i == 12)
 	    	{
 	    		Browser.driver.findElement(By.xpath(".//*[@id='PODetailsTable']/tbody/tr["+i+"]/td[9]/div[3]/span")).click(); 
 	    		Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr[2]/td[13]/input")).sendKeys("1");
 	    		Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr[3]/td[13]/input")).sendKeys("1");
 	    		 Browser.driver.findElement(By.xpath("html/body/div[9]/form/div/div[3]/button[1]")).click();

 	    	}
 	    	else
 	    	{
 		String RF = Browser.driver.findElement( By.xpath("//table[@id='PODetailsTable']/tbody/tr["+i+"]/td[7]/label")).getText();
 	                Browser.driver.findElement(By.xpath(".//*[@id='PODetailsTable']/tbody/tr["+i+"]/td[9]/div[3]/span")).click(); 
 		          Browser.driver.findElement(By.xpath(".//*[@id='taxCalc']/tbody/tr[1]/td[13]/input")).sendKeys(RF); 
 	                Browser.driver.findElement(By.xpath("html/body/div[9]/form/div/div[3]/button[1]")).click();
 	                
 		System.out.println(RF);
 	    	}
 	i++;
 	 }
 grossAmt=grossAmtEdt.getText();
 	totalTax= TotalTaxEdt.getText();
 amt = TotalEdt.getText();
	shipsaving.click();
	aftSavingShp.click();
	WebDriverCommonlib.waitForElementPresent(viewInvoice);
	Thread.sleep(3000);
	viewInvoice.click();
	Thread.sleep(6000);
	InvSearch.sendKeys(Excepted);
	Thread.sleep(2000);
	String actual = Result.getText() ;
	Assert.assertEquals(actual, Excepted, "full shipment ==fail");
	System.out.println("full shipment ==pass");
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
	            
	            
	            for(int i =0; i<13; i++)    // product verification
	            {      
	            	
	            		String prdID = SO_Excellib.getExcelDat("Multi", i+46, 2);
				           asser.assertEquals(listprd.get(i), prdID,"prod ID went wrong");
	            	}
	            	
	            
	            
	            for(int i =0; i<13; i++){       // Quantity verification
	            	
	            		String Qty = SO_Excellib.getExcelDat("Multi", i+46, 3);
	            		BigDecimal QtyExp1 =new BigDecimal(Qty);
	            		QtyExp1 = QtyExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
	            		BigDecimal QtyAct1 =new BigDecimal(listQty.get(i));
	            		QtyAct1 = QtyAct1.setScale(2, BigDecimal.ROUND_HALF_UP);
	            		
				           asser.assertEquals(QtyAct1, QtyExp1,"Qty went wrong");
	            	}
	            	
	           
	            for(int i =0; i<13; i++){       // unit price verification verification
	            	
	            		String unprice = SO_Excellib.getExcelDat("Multi", i+46, 4);
	            		BigDecimal unpriceExp1 =new BigDecimal(unprice);
	            		unpriceExp1 = unpriceExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
	            		BigDecimal unpriceAct1 =new BigDecimal(listunprice.get(i));
	            		unpriceAct1 = unpriceAct1.setScale(2, BigDecimal.ROUND_HALF_UP);
	            		 asser.assertEquals(unpriceAct1, unpriceExp1,"listunprice went wrong");
	            	
	            	
	            }
	            for(int i =0; i<13; i++)
	            {       // line total verification
	            	
	            		String linetotal = SO_Excellib.getExcelDat("Multi", i+46, 5);
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
	            	
          		String taxID = SO_Excellib.getExcelDat("Multi", i+62, 2);
			           asser.assertEquals(listTax.get(i), taxID,"taxID went wrong");
          	}
	            
	            for(int i =0; i<11; i++){       // TaxableAmount verification
	            	
          		String taxableAmt = SO_Excellib.getExcelDat("Multi", i+62, 3);
          		BigDecimal taxableAmtExp1 =new BigDecimal(taxableAmt);
          		taxableAmtExp1 = taxableAmtExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
          		BigDecimal taxableAmtAct1 =new BigDecimal(listtaxableAmt.get(i));
          		taxableAmtAct1 = taxableAmtAct1.setScale(2, BigDecimal.ROUND_HALF_UP);
          		
			           asser.assertEquals(taxableAmtAct1, taxableAmtExp1,"taxableAmt went wrong");
          	}
          	
         
          for(int i =0; i<11; i++){       // GrossAmt verification verification\
          	
          		String GrossAmt = SO_Excellib.getExcelDat("Multi", i+62, 4);
          		BigDecimal GrossAmtExp1 =new BigDecimal(GrossAmt);
          		GrossAmtExp1 = GrossAmtExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
          		BigDecimal GrossAmtAct1 =new BigDecimal(listGrossAmt.get(i));
          		GrossAmtAct1 = GrossAmtAct1.setScale(2, BigDecimal.ROUND_HALF_UP);
          		 asser.assertEquals(GrossAmtAct1, GrossAmtExp1,"GrossAmt went wrong");
          	
          	
          }
          for(int i =0; i<11; i++){       // SGST verification
          	
          		String SGST = SO_Excellib.getExcelDat("Multi", i+62, 5);
          		BigDecimal SGSTExp1 =new BigDecimal(SGST);
          		SGSTExp1 = SGSTExp1.setScale(2, BigDecimal.ROUND_HALF_UP);
          		BigDecimal SGSTAct1 =new BigDecimal(listSGST.get(i));
          		SGSTAct1 = SGSTAct1.setScale(2, BigDecimal.ROUND_HALF_UP);
          		 asser.assertEquals(SGSTAct1, SGSTExp1,"SGST went wrong");
          
          	
          }
          for(int i =0; i<11; i++){       // CGST verification
          	
      		String CGST = SO_Excellib.getExcelDat("Multi", i+62, 6);
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





