package com.Actouch.Purchase.generic_Lib;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;

public class DRSRVDataProvider {

	public String ExcelPatha="D:\\ServerCode\\Direct Receipt.xlsx"; 
	DRINVExcellib UserData = new DRINVExcellib(ExcelPatha, "DRS");
	 ArrayList<Object[]> dataList = new ArrayList<Object[]>();
	 int i=0;
	 int totalRows = 0;
@DataProvider
public  Object[][] PaymentLate()
{
	dataList.clear();
	  i = 6;
	 totalRows = 8;
	 while (i <= totalRows) {
		Browser.driver.navigate().refresh();
		 Object[] dataLine = new Object[5];
	  dataLine[0] = UserData.getCell(i, 4);
	  dataLine[1] = UserData.getCell(i, 5);
	  dataLine[2] = UserData.getCell(i, 6);
	  dataLine[3] = UserData.getCell(i, 7);
	  dataLine[4] = UserData.getCell(i, 8);
	   dataList.add(dataLine);
	i++;
	 }
	 Object[][] data = new Object[dataList.size()][];
	 for (i = 0; i < dataList.size(); i++)
	  data[i] = (Object[]) dataList.get(i);
	 
	 return data;

}
}
