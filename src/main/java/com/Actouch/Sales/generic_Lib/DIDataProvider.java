package com.Actouch.Sales.generic_Lib;

import java.util.ArrayList;
import org.testng.annotations.DataProvider;

import com.Actouch.Purchase.generic_Lib.DRINVExcellib;

public class DIDataProvider {

	public String ExcelPatha="D:\\Selenium\\Direct InvoiceLOC.xlsx"; 
	DRINVExcellib UserData = new DRINVExcellib(ExcelPatha, "DII");
	 ArrayList<Object[]> dataList = new ArrayList<Object[]>();
	 int i=0;
	 int totalRows = 0;
@DataProvider
public  Object[][] CurrencyLineDiscount()
{
	dataList.clear();
	  i = 47;
	 totalRows = 49;
	 while (i <= totalRows) {
		Browser.driver.navigate().refresh();
		 Object[] dataLine = new Object[6];
	  dataLine[0] = UserData.getCell(i, 3);
	  dataLine[1] = UserData.getCell(i, 4);
	  dataLine[2] = UserData.getCell(i, 5);
	  dataLine[3] = UserData.getCell(i, 6);
	  dataLine[4] = UserData.getCell(i, 7);
	  dataLine[5] = UserData.getCell(i, 8);
	    dataList.add(dataLine);
	i++;
	 }
	 
	 Object[][] data = new Object[dataList.size()][];
	 for (i = 0; i < dataList.size(); i++)
	  data[i] = (Object[]) dataList.get(i);
	 
	 return data;
}
@DataProvider
public  Object[][] PercentLineDiscount()
{
	dataList.clear();
	  i = 51;
	 totalRows = 53;
	 while (i <= totalRows) {
		Browser.driver.navigate().refresh();
		 Object[] dataLine = new Object[6];
	  dataLine[0] = UserData.getCell(i, 3);
	  dataLine[1] = UserData.getCell(i, 4);
	  dataLine[2] = UserData.getCell(i, 5);
	  dataLine[3] = UserData.getCell(i, 6);
	  dataLine[4] = UserData.getCell(i, 7);
	  dataLine[5] = UserData.getCell(i, 8);
	    dataList.add(dataLine);
	i++;
	 }
	 
	 Object[][] data = new Object[dataList.size()][];
	 for (i = 0; i < dataList.size(); i++)
	  data[i] = (Object[]) dataList.get(i);
	 
	 return data;
}

@DataProvider
public  Object[][] InclusiveTaxCurrencyDis()
{
	dataList.clear();
	  i = 55;
	 totalRows = 57;
	 while (i <= totalRows) {
		Browser.driver.navigate().refresh();
		 Object[] dataLine = new Object[11];
	  dataLine[0] = UserData.getCell(i, 3);
	  dataLine[1] = UserData.getCell(i, 4);
	  dataLine[2] = UserData.getCell(i, 5);
	  dataLine[3] = UserData.getCell(i, 6);
	  dataLine[4] = UserData.getCell(i, 7);
	  dataLine[5] = UserData.getCell(i, 8);
	  dataLine[6] = UserData.getCell(i, 9);
	  dataLine[7] = UserData.getCell(i, 10);
	  dataLine[8] = UserData.getCell(i, 11);
	  dataLine[9] = UserData.getCell(i, 12);
	  dataLine[10] = UserData.getCell(i, 13);
	    dataList.add(dataLine);
	i++;
	 }
	 
	 Object[][] data = new Object[dataList.size()][];
	 for (i = 0; i < dataList.size(); i++)
	  data[i] = (Object[]) dataList.get(i);
	 
	 return data;
}
@DataProvider
public  Object[][] InclusiveTaxPercentDis()
{
	dataList.clear();
	  i = 59;
	 totalRows = 61;
	 while (i <= totalRows) {
		Browser.driver.navigate().refresh();
		 Object[] dataLine = new Object[11];
	  dataLine[0] = UserData.getCell(i, 3);
	  dataLine[1] = UserData.getCell(i, 4);
	  dataLine[2] = UserData.getCell(i, 5);
	  dataLine[3] = UserData.getCell(i, 6);
	  dataLine[4] = UserData.getCell(i, 7);
	  dataLine[5] = UserData.getCell(i, 8);
	  dataLine[6] = UserData.getCell(i, 9);
	  dataLine[7] = UserData.getCell(i, 10);
	  dataLine[8] = UserData.getCell(i, 11);
	  dataLine[9] = UserData.getCell(i, 12);
	  dataLine[10] = UserData.getCell(i, 13);
	    dataList.add(dataLine);
	i++;
	 }
	 Object[][] data = new Object[dataList.size()][];
	 for (i = 0; i < dataList.size(); i++)
	  data[i] = (Object[]) dataList.get(i);
	 
	 return data;
}
@DataProvider
public  Object[][] ExclusiveTaxCurrencyDis()
{
	dataList.clear();
	  i = 63;
	 totalRows = 65;
	 while (i <= totalRows) {
		Browser.driver.navigate().refresh();
		 Object[] dataLine = new Object[11];
	  dataLine[0] = UserData.getCell(i, 3);
	  dataLine[1] = UserData.getCell(i, 4);
	  dataLine[2] = UserData.getCell(i, 5);
	  dataLine[3] = UserData.getCell(i, 6);
	  dataLine[4] = UserData.getCell(i, 7);
	  dataLine[5] = UserData.getCell(i, 8);
	  dataLine[6] = UserData.getCell(i, 9);
	  dataLine[7] = UserData.getCell(i, 10);
	  dataLine[8] = UserData.getCell(i, 11);
	  dataLine[9] = UserData.getCell(i, 12);
	  dataLine[10] = UserData.getCell(i, 13);
	    dataList.add(dataLine);
	i++;
	 }
	 
	 Object[][] data = new Object[dataList.size()][];
	 for (i = 0; i < dataList.size(); i++)
	  data[i] = (Object[]) dataList.get(i);
	 
	 return data;
}
@DataProvider
public  Object[][] ExclusiveTaxPercentDis()
{
	dataList.clear();
	  i = 67;
	 totalRows = 69;
	 while (i <= totalRows) {
		Browser.driver.navigate().refresh();
		 Object[] dataLine = new Object[11];
	  dataLine[0] = UserData.getCell(i, 3);
	  dataLine[1] = UserData.getCell(i, 4);
	  dataLine[2] = UserData.getCell(i, 5);
	  dataLine[3] = UserData.getCell(i, 6);
	  dataLine[4] = UserData.getCell(i, 7);
	  dataLine[5] = UserData.getCell(i, 8);
	  dataLine[6] = UserData.getCell(i, 9);
	  dataLine[7] = UserData.getCell(i, 10);
	  dataLine[8] = UserData.getCell(i, 11);
	  dataLine[9] = UserData.getCell(i, 12);
	  dataLine[10] = UserData.getCell(i, 13);
	    dataList.add(dataLine);
	i++;
	 }
	 
	 Object[][] data = new Object[dataList.size()][];
	 for (i = 0; i < dataList.size(); i++)
	  data[i] = (Object[]) dataList.get(i);
	 
	 return data;
}
@DataProvider
public  Object[][] MUOMCurrencyDis()
{
	dataList.clear();
	  i = 71;
	 totalRows = 73;
	 while (i <= totalRows) {
		Browser.driver.navigate().refresh();
		 Object[] dataLine = new Object[8];
	  dataLine[0] = UserData.getCell(i, 3);
	  dataLine[1] = UserData.getCell(i, 4);
	  dataLine[2] = UserData.getCell(i, 5);
	  dataLine[3] = UserData.getCell(i, 6);
	  dataLine[4] = UserData.getCell(i, 7);
	  dataLine[5] = UserData.getCell(i, 8);
	  dataLine[6] = UserData.getCell(i, 9);
	  dataLine[7] = UserData.getCell(i, 10);
	    dataList.add(dataLine);
	i++;
	 }
	 
	 Object[][] data = new Object[dataList.size()][];
	 for (i = 0; i < dataList.size(); i++)
	  data[i] = (Object[]) dataList.get(i);
	 
	 return data;
}
@DataProvider
public  Object[][] MUOMPercentDis()
{
	dataList.clear();
	  i = 75;
	 totalRows = 77;
	 while (i <= totalRows) {
		Browser.driver.navigate().refresh();
		 Object[] dataLine = new Object[8];
	  dataLine[0] = UserData.getCell(i, 3);
	  dataLine[1] = UserData.getCell(i, 4);
	  dataLine[2] = UserData.getCell(i, 5);
	  dataLine[3] = UserData.getCell(i, 6);
	  dataLine[4] = UserData.getCell(i, 7);
	  dataLine[5] = UserData.getCell(i, 8);
	  dataLine[6] = UserData.getCell(i, 9);
	  dataLine[7] = UserData.getCell(i, 10);
	    dataList.add(dataLine);
	i++;
	 }
	 
	 Object[][] data = new Object[dataList.size()][];
	 for (i = 0; i < dataList.size(); i++)
	  data[i] = (Object[]) dataList.get(i);
	 
	 return data;
}
@DataProvider
public  Object[][] BatchCurrencyDis()
{
	dataList.clear();
	  i = 79;
	 totalRows = 81;
	 while (i <= totalRows) {
		Browser.driver.navigate().refresh();
		 Object[] dataLine = new Object[8];
	  dataLine[0] = UserData.getCell(i, 3);
	  dataLine[1] = UserData.getCell(i, 4);
	  dataLine[2] = UserData.getCell(i, 5);
	  dataLine[3] = UserData.getCell(i, 6);
	  dataLine[4] = UserData.getCell(i, 7);
	  dataLine[5] = UserData.getCell(i, 8);
	  dataLine[6] = UserData.getCell(i, 9);
	  dataLine[7] = UserData.getCell(i, 10);
	    dataList.add(dataLine);
	i++;
	 }
	 
	 Object[][] data = new Object[dataList.size()][];
	 for (i = 0; i < dataList.size(); i++)
	  data[i] = (Object[]) dataList.get(i);
	 
	 return data;
}
@DataProvider
public  Object[][] BatchPercentDis()
{
	dataList.clear();
	  i = 83;
	 totalRows = 85;
	 while (i <= totalRows) {
		Browser.driver.navigate().refresh();
		 Object[] dataLine = new Object[8];
	  dataLine[0] = UserData.getCell(i, 3);
	  dataLine[1] = UserData.getCell(i, 4);
	  dataLine[2] = UserData.getCell(i, 5);
	  dataLine[3] = UserData.getCell(i, 6);
	  dataLine[4] = UserData.getCell(i, 7);
	  dataLine[5] = UserData.getCell(i, 8);
	  dataLine[6] = UserData.getCell(i, 9);
	  dataLine[7] = UserData.getCell(i, 10);
	    dataList.add(dataLine);
	i++;
	 }
	 
	 Object[][] data = new Object[dataList.size()][];
	 for (i = 0; i < dataList.size(); i++)
	  data[i] = (Object[]) dataList.get(i);
	 
	 return data;
}
@DataProvider
public  Object[][] MUOMBatchCurrencyDis()
{
	dataList.clear();
	  i = 87;
	 totalRows = 89;
	 while (i <= totalRows) {
		Browser.driver.navigate().refresh();
		 Object[] dataLine = new Object[9];
	  dataLine[0] = UserData.getCell(i, 3);
	  dataLine[1] = UserData.getCell(i, 4);
	  dataLine[2] = UserData.getCell(i, 5);
	  dataLine[3] = UserData.getCell(i, 6);
	  dataLine[4] = UserData.getCell(i, 7);
	  dataLine[5] = UserData.getCell(i, 8);
	  dataLine[6] = UserData.getCell(i, 9);
	  dataLine[7] = UserData.getCell(i, 10);
	  dataLine[8] = UserData.getCell(i, 11);
	    dataList.add(dataLine);
	i++;
	 }
	 
	 Object[][] data = new Object[dataList.size()][];
	 for (i = 0; i < dataList.size(); i++)
	  data[i] = (Object[]) dataList.get(i);
	 
	 return data;
}
}

