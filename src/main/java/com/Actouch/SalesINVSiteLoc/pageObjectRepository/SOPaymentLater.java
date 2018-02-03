package com.Actouch.SalesINVSiteLoc.pageObjectRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.Actouch.Pages.SODashBoard;
import com.Actouch.Pages.SalesOrderCreation;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class SOPaymentLater {
	public static String amt;
	public static String exp;
	private Connection connection;
	   private static Statement statement;
	   private static ResultSet rs;
    public static String CUST_ID;
    public static String CUST_Name; 
    public static BigDecimal TOTAL_AMT;
    public static BigDecimal Total_Tax;
	  public void payltr(String Site,String Customer_Id,String Product_Id,String Quantity,String unit_price,String taxCode,String PayMentType  ) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	   {
		 WebDriverCommonlib.waitForPageToLoad();
		 SalesOrderCreation So = new SalesOrderCreation(Browser.driver);
		 SODashBoard SOD = new SODashBoard(Browser.driver);
		Actions act = new Actions(Browser.driver);
		So.SiteEdt(Site);
		act.sendKeys(Keys.TAB).perform();
		     exp = So.SOidEdt();
		   Thread.sleep(3000);
		   So.SoCustIdEdt(Customer_Id);
		 Thread.sleep(1000);
		  act.sendKeys(Keys.TAB).perform();
		   JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
		   kl.executeScript("window.scrollBy(0,300)", "");
		So.prdSo_1Edt(Product_Id);
		  Thread.sleep(2000);
	     	act.sendKeys(Keys.TAB).perform();
	   	 Thread.sleep(1000);
	   	 So.prDetailsEdt();
		    So.roleSelProdEdt();
		  So.qntEdt(Quantity);
		   So.aftrqntOkEdt();
		  So.unitprice_1edt(unit_price);
		  Thread.sleep(2000);
		  So.taxEdt();
		  		 for(int i=1;i<10;i++)
			  {
			String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
				  if(count1.equals(taxCode)){
					Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
					Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
				  
				  	break;
				  	
				  }
			  }
		 
		   amt = So.gettingTotalAmount();
		   Thread.sleep(1000);
				So.btnSaveEdt();
		   So.ConfirmSaveedt();
		  Browser.driver.get(Constant.SalesMain);
		  SOD.SiteEdt(Site);
		  act.sendKeys(Keys.TAB).perform();
		  SOD.Setsearchtxt(exp);
		  Thread.sleep(1000);
		   String act2 = SOD.actval();
		    Assert.assertEquals(act2, exp,"payment later after saving case == fail");
	  		System.out.println("payment later after saving case == pass");
		    }
	   
	   
	   public void payltrDB (String databaseURL,String user,String password,String query,String Column1, String Column2,String Total,String TotalTax) throws SQLException, ClassNotFoundException {
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
		                
		            	CUST_ID   = rs.getString(Column1) ;
		            	CUST_Name = rs.getString(Column2);
		            	TOTAL_AMT = rs.getBigDecimal(Total);
		            	Total_Tax = rs.getBigDecimal(TotalTax);
		  
		            	}
		            connection.close();
		    }
	   
	}


