package com.Actouch.Purchase.generic_Lib;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;

public class UPDRINVDataProvider {

	public String ExcelPatha="D:\\ServerCode\\Direct Receipt.xlsx"; 
	DRINVExcellib UserData = new DRINVExcellib(ExcelPatha, "UPDRI");
	 ArrayList<Object[]> dataList = new ArrayList<Object[]>();
	 int i=0;
	 int totalRows = 0;
@DataProvider
public  Object[][] UpdateSupplier2()
{
	dataList.clear();
	  i = 6;
	 totalRows = 8;
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
public Object[][] UPDRReference3()
{
	dataList.clear();
      i = 10;
      totalRows = 12;
      while(i<=totalRows)
      {
    	  Browser.driver.navigate().refresh();
    	  Object[] dataLine= new Object[10];
    	  dataLine[0] =UserData.getCell(i, 4);
    	  dataLine[1] =UserData.getCell(i, 5);
    	  dataLine[2] =UserData.getCell(i, 6);
    	  dataLine[3] =UserData.getCell(i, 7);
    	  dataLine[4] =UserData.getCell(i, 8);
    	  dataLine[5] =UserData.getCell(i, 9);
    	  dataLine[6] =UserData.getCell(i, 10);
    	  dataLine[7] =UserData.getCell(i, 11);
    	  dataLine[8] =UserData.getCell(i, 12);
    	  dataLine[9] =UserData.getCell(i, 13);
    	  dataList.add(dataLine);
    	  i++;
      }
    	  Object[][] data=new Object[dataList.size()][];
    		for(int i=0;i<dataList.size();i++)
    			data[i]=(Object[])dataList.get(i);
    	  return data;
}
@DataProvider
public  Object[][] UpdateShipAddress4()
{
	dataList.clear();
	  i = 14;
	 totalRows = 16;
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
public  Object[][] UpdateCreditTerm5()
{
	dataList.clear();
	  i = 18;
	 totalRows = 20;
	 while (i <= totalRows) {
		Browser.driver.navigate().refresh();
		 Object[] dataLine = new Object[8];
	  dataLine[0] = UserData.getCell(i, 4);
	  dataLine[1] = UserData.getCell(i, 5);
	  dataLine[2] = UserData.getCell(i, 6);
	  dataLine[3] = UserData.getCell(i, 7);
	  dataLine[4] = UserData.getCell(i, 8);
	  dataLine[5] = UserData.getCell(i, 9);
	  dataLine[6] = UserData.getCell(i, 10);
	  dataLine[7] = UserData.getCell(i, 11);
	    dataList.add(dataLine);
	i++;
	 }
	 
	 Object[][] data = new Object[dataList.size()][];
	 for (i = 0; i < dataList.size(); i++)
	  data[i] = (Object[]) dataList.get(i);
	 
	 return data;
}
@DataProvider
public  Object[][] UpdateProduct6()
{
	dataList.clear();
	  i = 22;
	 totalRows = 24;
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
@DataProvider
public Object [][]UpdateQnty7()
{
	dataList.clear();
	i= 26;
    totalRows=28;                                                         
while(i<=totalRows)
{
	Browser.driver.navigate().refresh();
	Object[] dataLine =new Object[7];
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
public Object [][]UpdateUnitP8()
{
	dataList.clear();
	i= 30;
    totalRows=32;                                                         
while(i<=totalRows)
{
	Browser.driver.navigate().refresh();
	Object[] dataLine =new Object[7];
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
public Object [][]UpdatelineDis9()
{
	dataList.clear();
	i= 34;
    totalRows=36;                                                         
while(i<=totalRows)
{
	Browser.driver.navigate().refresh();
	Object[] dataLine =new Object[9];
	dataLine[0] = UserData.getCell(i, 4);
	dataLine[1] = UserData.getCell(i, 5);
	dataLine[2] = UserData.getCell(i, 6);
	dataLine[3] = UserData.getCell(i, 7);
	dataLine[4] = UserData.getCell(i, 8);
	dataLine[5] = UserData.getCell(i, 9);
	dataLine[6] = UserData.getCell(i, 10);
	dataLine[7] = UserData.getCell(i, 11);
	dataLine[8] = UserData.getCell(i, 12);
      dataList.add(dataLine);
    i++;
}
Object[][] data = new Object[dataList.size()][];
for (i = 0; i < dataList.size(); i++)
 data[i] = (Object[]) dataList.get(i);

return data;
  
}
@DataProvider
public Object [][]UpdateTaxCode10()
{
	dataList.clear();
	i= 38;
    totalRows=40;                                                         
while(i<=totalRows)
{
	Browser.driver.navigate().refresh();
	Object[] dataLine =new Object[7];
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
public Object [][]UpdateTermCond12()
{
	dataList.clear();
	i= 46;
    totalRows=48;                                                         
while(i<=totalRows)
{
	Browser.driver.navigate().refresh();
	Object[] dataLine =new Object[8];
	dataLine[0] = UserData.getCell(i, 4);
	dataLine[1] = UserData.getCell(i, 5);
	dataLine[2] = UserData.getCell(i, 6);
	dataLine[3] = UserData.getCell(i, 7);
	dataLine[4] = UserData.getCell(i, 8);
	dataLine[5] = UserData.getCell(i, 9);
	dataLine[6] = UserData.getCell(i, 10);
	dataLine[7] = UserData.getCell(i, 11);
      dataList.add(dataLine);
    i++;
}
Object[][] data = new Object[dataList.size()][];
for (i = 0; i < dataList.size(); i++)
 data[i] = (Object[]) dataList.get(i);

return data;
  
}
@DataProvider
public  Object[][] UpdateMemo13()
{
	dataList.clear();
	  i = 50;
	 totalRows = 52;
	 while (i <= totalRows) {
		Browser.driver.navigate().refresh();
		 Object[] dataLine = new Object[8];
	  dataLine[0] = UserData.getCell(i, 4);
	  dataLine[1] = UserData.getCell(i, 5);
	  dataLine[2] = UserData.getCell(i, 6);
	  dataLine[3] = UserData.getCell(i, 7);
	  dataLine[4] = UserData.getCell(i, 8);
	  dataLine[5] = UserData.getCell(i, 9);
	  dataLine[6] = UserData.getCell(i, 10);
	  dataLine[7] = UserData.getCell(i, 11);
	    dataList.add(dataLine);
	i++;
	 }
	 
	 Object[][] data = new Object[dataList.size()][];
	 for (i = 0; i < dataList.size(); i++)
	  data[i] = (Object[]) dataList.get(i);
	 
	 return data;
}
@DataProvider
public Object[][] UpdateDisPer14()
{
	dataList.clear();
	i=54;
	totalRows =56;
	while(i<=totalRows)
	{
		Browser.driver.navigate().refresh();
		Object[] dataLine =new Object[8];
		dataLine[0]= UserData.getCell(i, 4);
		dataLine[1]= UserData.getCell(i, 5);
		dataLine[2]= UserData.getCell(i, 6);
		dataLine[3]= UserData.getCell(i, 7);
		dataLine[4]= UserData.getCell(i, 8);
		dataLine[5]= UserData.getCell(i, 9);
		dataLine[6]= UserData.getCell(i, 10);
		dataLine[7]= UserData.getCell(i, 11);
		dataList.add(dataLine);
		i++;
		
	}
	Object[][] data = new Object[dataList.size()][];
	for(i=0;i<dataList.size();i++)
		data[i]=(Object[]) dataList.get(i);
	return data;
		
}
@DataProvider
public Object[][] UpdateDisINR15()
{
	dataList.clear();
	i=58;
	totalRows =60;
	while(i<=totalRows)
	{
		Browser.driver.navigate().refresh();
		Object[] dataLine =new Object[8];
		dataLine[0]= UserData.getCell(i, 4);
		dataLine[1]= UserData.getCell(i, 5);
		dataLine[2]= UserData.getCell(i, 6);
		dataLine[3]= UserData.getCell(i, 7);
		dataLine[4]= UserData.getCell(i, 8);
		dataLine[5]= UserData.getCell(i, 9);
		dataLine[6]= UserData.getCell(i, 10);
		dataLine[7]= UserData.getCell(i, 11);
		dataList.add(dataLine);
		i++;
		
	}
	Object[][] data = new Object[dataList.size()][];
	for(i=0;i<dataList.size();i++)
		data[i]=(Object[]) dataList.get(i);
	return data;
		
}
@DataProvider
public Object[][] UpdateShipCharge16()
{
	dataList.clear();
	i=62;
	totalRows =64;
	while(i<=totalRows)
	{
		Browser.driver.navigate().refresh();
		Object[] dataLine =new Object[8];
		dataLine[0]= UserData.getCell(i, 4);
		dataLine[1]= UserData.getCell(i, 5);
		dataLine[2]= UserData.getCell(i, 6);
		dataLine[3]= UserData.getCell(i, 7);
		dataLine[4]= UserData.getCell(i, 8);
		dataLine[5]= UserData.getCell(i, 9);
		dataLine[6]= UserData.getCell(i, 10);
		dataLine[7]= UserData.getCell(i, 11);
		dataList.add(dataLine);
		i++;
		
	}
	Object[][] data = new Object[dataList.size()][];
	for(i=0;i<dataList.size();i++)
		data[i]=(Object[]) dataList.get(i);
	return data;
		
}
@DataProvider
public Object[][] UpdateShipTax17()
{
	dataList.clear();
	i=66;
	totalRows =68;
	while(i<=totalRows)
	{
		Browser.driver.navigate().refresh();
		Object[] dataLine =new Object[9];
		dataLine[0]= UserData.getCell(i, 4);
		dataLine[1]= UserData.getCell(i, 5);
		dataLine[2]= UserData.getCell(i, 6);
		dataLine[3]= UserData.getCell(i, 7);
		dataLine[4]= UserData.getCell(i, 8);
		dataLine[5]= UserData.getCell(i, 9);
		dataLine[6]= UserData.getCell(i, 10);
		dataLine[7]= UserData.getCell(i, 11);
		dataLine[8]= UserData.getCell(i, 12);
		dataList.add(dataLine);
		i++;
		
	}
	Object[][] data = new Object[dataList.size()][];
	for(i=0;i<dataList.size();i++)
		data[i]=(Object[]) dataList.get(i);
	return data;
		
}
@DataProvider
public Object[][] UpdateRoundOff18()
{
	dataList.clear();
	i=70;
	totalRows =72;
	while(i<=totalRows)
	{
		Browser.driver.navigate().refresh();
		Object[] dataLine =new Object[8];
		dataLine[0]= UserData.getCell(i, 4);
		dataLine[1]= UserData.getCell(i, 5);
		dataLine[2]= UserData.getCell(i, 6);
		dataLine[3]= UserData.getCell(i, 7);
		dataLine[4]= UserData.getCell(i, 8);
		dataLine[5]= UserData.getCell(i, 9);
		dataLine[6]= UserData.getCell(i, 10);
		dataLine[7]= UserData.getCell(i, 11);
		dataList.add(dataLine);
		i++;
		
	}
	Object[][] data = new Object[dataList.size()][];
	for(i=0;i<dataList.size();i++)
		data[i]=(Object[]) dataList.get(i);
	return data;
		
}

}
