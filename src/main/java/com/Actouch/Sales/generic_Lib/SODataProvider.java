package com.Actouch.Sales.generic_Lib;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;

import com.Actouch.Purchase.generic_Lib.DRINVExcellib;

public class SODataProvider {

	public String ExcelPatha="D:\\Selenium\\SaleOrderLOC.xlsx"; 
	DRINVExcellib UserData = new DRINVExcellib(ExcelPatha, "SO");
	 ArrayList<Object[]> dataList = new ArrayList<Object[]>();
	 int i=0;
	 int totalRows = 0;
//	 @DataProvider Object[][] payltr_TC_2()
//	 {
//		 dataList.clear();
//		 
//	 }
@DataProvider 
public  Object[][] CurrencyLineDiscount()
{
	dataList.clear();
	  i = 54;
	 totalRows = 56;
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
	  i = 58;
	 totalRows = 60;
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
	  i = 62;
	 totalRows = 64;
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
	  i = 66;
	 totalRows = 68;
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
	  i = 70;
	 totalRows = 72;
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
	i = 74;
	 totalRows = 76;
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
	  i = 78;
	 totalRows = 80;
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
	  i = 82;
	 totalRows = 84;
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
	i = 86;
	 totalRows = 88;
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
	  i = 90;
	 totalRows = 92;
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
	i = 94;
	 totalRows = 96;
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
@DataProvider
public  Object[][] MUOMBatchPerCentDis()
{
	dataList.clear();
	i = 98;
	 totalRows = 100;
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
