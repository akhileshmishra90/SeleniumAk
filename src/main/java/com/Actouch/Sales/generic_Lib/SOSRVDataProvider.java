package com.Actouch.Sales.generic_Lib;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;

import com.Actouch.Purchase.generic_Lib.DRINVExcellib;

public class SOSRVDataProvider {

	public String ExcelPatha="D:\\ServerCode\\SO Service .xlsx"; 
	DRINVExcellib UserData = new DRINVExcellib(ExcelPatha, "SOSRV");
	 ArrayList<Object[]> dataList = new ArrayList<Object[]>();
	 int i=0;
	 int totalRows = 0;
@DataProvider
public  Object[][] PerLineDis_TC_29()
{
	dataList.clear();
	  i = 32;
	 totalRows = 34;
	 while (i <= totalRows) {
		Browser.driver.navigate().refresh();
		 Object[] dataLine = new Object[6];
	  dataLine[0] = UserData.getCell(i, 4);
	  dataLine[1] = UserData.getCell(i, 5);
	  dataLine[2] = UserData.getCell(i, 6);
	  dataLine[3] = UserData.getCell(i, 7);
	  dataLine[4] = UserData.getCell(i, 8);
	  dataLine[5] = UserData.getCell(i, 9);
	    dataList.add(dataLine);
	i++;
	 }
	 
	 Object[][] data = new Object[dataList.size()][];
	 for (i = 0; i < dataList.size(); i++)
	  data[i] = (Object[]) dataList.get(i);
	 
	 return data;
}	
@DataProvider
public  Object[][] CurrencyLineDis_TC_30()
{
	dataList.clear();
	  i = 36;
	 totalRows = 38;
	 while (i <= totalRows) {
		Browser.driver.navigate().refresh();
		 Object[] dataLine = new Object[6];
	  dataLine[0] = UserData.getCell(i, 4);
	  dataLine[1] = UserData.getCell(i, 5);
	  dataLine[2] = UserData.getCell(i, 6);
	  dataLine[3] = UserData.getCell(i, 7);
	  dataLine[4] = UserData.getCell(i, 8);
	  dataLine[5] = UserData.getCell(i, 9);
	    dataList.add(dataLine);
	i++;
	 }
	 
	 Object[][] data = new Object[dataList.size()][];
	 for (i = 0; i < dataList.size(); i++)
	  data[i] = (Object[]) dataList.get(i);
	 
	 return data;
}	

@DataProvider
public  Object[][] PerLineDisExclusiveTx_TC_31()
{
	dataList.clear();
	  i = 40;
	 totalRows = 42;
	 while (i <= totalRows) {
		Browser.driver.navigate().refresh();
		 Object[] dataLine = new Object[7];
	  dataLine[0] = UserData.getCell(i, 4);
	  dataLine[1] = UserData.getCell(i, 5);
	  dataLine[2] = UserData.getCell(i, 6);
	  dataLine[3] = UserData.getCell(i, 7);
	  dataLine[4] = UserData.getCell(i, 8);
	  dataLine[5] = UserData.getCell(i, 9);
	  dataLine[6] = UserData.getCell(i, 10);
	    dataList.add(dataLine);
	i++;
	 }
	 
	 Object[][] data = new Object[dataList.size()][];
	 for (i = 0; i < dataList.size(); i++)
	  data[i] = (Object[]) dataList.get(i);
	 
	 return data;
}	
@DataProvider
public  Object[][] CurrencyLineDisExclusiveTx_TC_32()
{
	dataList.clear();
	  i = 44;
	 totalRows = 46;
	 while (i <= totalRows) {
		Browser.driver.navigate().refresh();
		 Object[] dataLine = new Object[7];
	  dataLine[0] = UserData.getCell(i, 4);
	  dataLine[1] = UserData.getCell(i, 5);
	  dataLine[2] = UserData.getCell(i, 6);
	  dataLine[3] = UserData.getCell(i, 7);
	  dataLine[4] = UserData.getCell(i, 8);
	  dataLine[5] = UserData.getCell(i, 9);
	  dataLine[6] = UserData.getCell(i, 10);
	    dataList.add(dataLine);
	i++;
	 }
	 
	 Object[][] data = new Object[dataList.size()][];
	 for (i = 0; i < dataList.size(); i++)
	  data[i] = (Object[]) dataList.get(i);
	 
	 return data;
}	

@DataProvider
public  Object[][] ExclusiveTx_TC_33()
{
	dataList.clear();
	  i = 48;
	 totalRows = 50;
	 while (i <= totalRows) {
		Browser.driver.navigate().refresh();
		 Object[] dataLine = new Object[10];
	  dataLine[0] = UserData.getCell(i, 4);
	  dataLine[1] = UserData.getCell(i, 5);
	  dataLine[2] = UserData.getCell(i, 6);
	  dataLine[3] = UserData.getCell(i, 7);
	  dataLine[4] = UserData.getCell(i, 8);
	  dataLine[5] = UserData.getCell(i, 9);
	  dataLine[6] = UserData.getCell(i, 10);
	  dataLine[7] = UserData.getCell(i, 11);
	  dataLine[8] = UserData.getCell(i, 12);
	  dataLine[9] = UserData.getCell(i, 13);
	    dataList.add(dataLine);
	i++;
	 }
	 
	 Object[][] data = new Object[dataList.size()][];
	 for (i = 0; i < dataList.size(); i++)
	  data[i] = (Object[]) dataList.get(i);
	 
	 return data;
}	

}
