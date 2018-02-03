package com.Actouch.Purchase.generic_Lib;
import java.util.ArrayList;
import org.testng.annotations.DataProvider;
public class DRINVDataProvider {	
		
		public String ExcelPatha="D:\\ServerCode\\Direct Receipt.xlsx"; 
		DRINVExcellib UserData = new DRINVExcellib(ExcelPatha, "DRI");
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
public Object[][] DRSingleCheq()
{
	  dataList.clear();
	 i= 10;
   totalRows=12;
	while (i<= totalRows)
	{
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
public Object[][] DRMultiCheq()
{
	dataList.clear();
   i=14;
	totalRows=16;
	while(i<=totalRows)
	{
		Browser.driver.navigate().refresh();
		Object[] dataLine=new Object[9];
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
Object[][] data =new Object[dataList.size()][];
for(i=0;i < dataList.size();i++)
	data[i]=(Object[])dataList.get(i);
return data;
}
@DataProvider
public Object[][] DRCash()
{
	dataList.clear();
	i=18;
	totalRows =20;
	while(i <= totalRows)
	{
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
   Object[][] data =new Object[dataList.size()][];
  for (int i = 0; i < dataList.size(); i++) 
	  data[i]=(Object[])dataList.get(i);
  return data;
}
@DataProvider 
public Object[][] DRRCVAdv()
{
	dataList.clear();
	i= 22;
	totalRows = 24;
	while(i<= totalRows)
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
	Object[][] data =new Object[dataList.size()][];
	for(int i = 0;i < dataList.size();i++)
		data[i]=(Object[])dataList.get(i);
	return data;
	}
	@DataProvider
	public Object[][] DRAdvChq()
	{
		dataList.clear();
		i=26;
		totalRows = 28;
		while(i<= totalRows)
		{
			Browser.driver.navigate().refresh();
			Object[] dataLine = new Object[9];
			dataLine[0] =UserData.getCell(i, 4);
			dataLine[1] =UserData.getCell(i, 5);
			dataLine[2] =UserData.getCell(i, 6);
			dataLine[3] =UserData.getCell(i, 7);
			dataLine[4] =UserData.getCell(i, 8);
			dataLine[5] =UserData.getCell(i, 9);
			dataLine[6] =UserData.getCell(i, 10);
			dataLine[7] =UserData.getCell(i, 11);
			dataLine[8] =UserData.getCell(i, 12);
			dataList.add(dataLine);
			i++;
		}
		Object[][] data = new Object[dataList.size()][];
		for(int i=0;i< dataList.size();i++)
			data[i] = (Object[])dataList.get(i);
		return data;
	}
	@DataProvider
	public Object[][] DRMultiTax()
	{
		dataList.clear();
		i = 30;
		totalRows=32;
		while(i<=totalRows)
		{
			Browser.driver.navigate().refresh();
			Object[] dataLine =new Object[7];
			dataLine[0] =UserData.getCell(i, 4);
			dataLine[1] =UserData.getCell(i, 5);
			dataLine[2] =UserData.getCell(i, 6);
			dataLine[3] =UserData.getCell(i, 7);
			dataLine[4] =UserData.getCell(i, 8);
			dataLine[5] =UserData.getCell(i, 9);
			dataLine[6] =UserData.getCell(i, 10);
			dataList.add(dataLine);
			i++;
			}
     Object[][] data =new Object[dataList.size()][];
     for(int i=0;i< dataList.size();i++)
    	 data[i] = (Object[])dataList.get(i);
     return data;
	
	}
	
	@DataProvider
	public Object[][] DRTaxDis()
	{
		dataList.clear();
		i =34;
		totalRows =36;
		while(i<=totalRows)
		{
			Browser.driver.navigate().refresh();
			Object[] dataline = new Object[8];
			dataline[0] = UserData.getCell(i, 4);
			dataline[1] = UserData.getCell(i, 5);
			dataline[2] = UserData.getCell(i, 6);
			dataline[3] = UserData.getCell(i, 7);
			dataline[4] = UserData.getCell(i, 8);
			dataline[5] = UserData.getCell(i, 9);
			dataline[6] = UserData.getCell(i, 10);
			dataline[7] = UserData.getCell(i, 11);
			dataList.add(dataline);
			i++;
		}
		Object[][] data=new Object[dataList.size()][];
		for(int i=0;i< dataList.size();i++)
			data[i]=(Object[])dataList.get(i);
		return data;
	}
	@DataProvider
	public Object[][]DRWithoutTAx()
	{
      dataList.clear();
      i = 38;
      totalRows = 40;
      while(i<=totalRows)
      {
    	  Browser.driver.navigate().refresh();
    	  Object[] dataLine= new Object[6];
    	  dataLine[0] =UserData.getCell(i, 4);
    	  dataLine[1] =UserData.getCell(i, 5);
    	  dataLine[2] =UserData.getCell(i, 6);
    	  dataLine[3] =UserData.getCell(i, 7);
    	  dataLine[4] =UserData.getCell(i, 8);
    	  dataLine[5] =UserData.getCell(i, 9);
    	  dataList.add(dataLine);
    	  i++;
      }
    	  Object[][] data=new Object[dataList.size()][];
    		for(int i=0;i<dataList.size();i++)
    			data[i]=(Object[])dataList.get(i);
    	  return data;
	}
	@DataProvider
	public Object[][]DRWithoutDis()
	{
      dataList.clear();
      i = 42;
      totalRows = 44;
      while(i<=totalRows)
      {
    	  Browser.driver.navigate().refresh();
    	  Object[] dataLine= new Object[5];
    	  dataLine[0] =UserData.getCell(i, 4);
    	  dataLine[1] =UserData.getCell(i, 5);
    	  dataLine[2] =UserData.getCell(i, 6);
    	  dataLine[3] =UserData.getCell(i, 7);
    	  dataLine[4] =UserData.getCell(i, 8);
    	  dataList.add(dataLine);
    	  i++;
      }
    	  Object[][] data=new Object[dataList.size()][];
    		for(int i=0;i<dataList.size();i++)
    			data[i]=(Object[])dataList.get(i);
    	  return data;
	}
	@DataProvider
	public Object[][]DRInclusiveTAx()
	{
      dataList.clear();
      i = 46;
      totalRows = 48;
      while(i<=totalRows)
      {
    	  Browser.driver.navigate().refresh();
    	  Object[] dataLine= new Object[6];
    	  dataLine[0] =UserData.getCell(i, 4);
    	  dataLine[1] =UserData.getCell(i, 5);
    	  dataLine[2] =UserData.getCell(i, 6);
    	  dataLine[3] =UserData.getCell(i, 7);
    	  dataLine[4] =UserData.getCell(i, 8);
    	  dataLine[5] =UserData.getCell(i, 9);
    	  dataList.add(dataLine);
    	  i++;
      }
    	  Object[][] data=new Object[dataList.size()][];
    		for(int i=0;i<dataList.size();i++)
    			data[i]=(Object[])dataList.get(i);
    	  return data;
	}
	@DataProvider
	public Object[][]DRExclusiveTAx()
	{
      dataList.clear();
      i = 50;
      totalRows = 52;
      while(i<=totalRows)
      {
    	  Browser.driver.navigate().refresh();
    	  Object[] dataLine= new Object[6];
    	  dataLine[0] =UserData.getCell(i, 4);
    	  dataLine[1] =UserData.getCell(i, 5);
    	  dataLine[2] =UserData.getCell(i, 6);
    	  dataLine[3] =UserData.getCell(i, 7);
    	  dataLine[4] =UserData.getCell(i, 8);
    	  dataLine[5] =UserData.getCell(i, 9);
    	  dataList.add(dataLine);
    	  i++;
      }
    	  Object[][] data=new Object[dataList.size()][];
    		for(int i=0;i<dataList.size();i++)
    			data[i]=(Object[])dataList.get(i);
    	  return data;
	}
	@DataProvider
	public Object[][] DRCrdTerm()
	{
		dataList.clear();
	      i = 54;
	      totalRows = 56;
	      while(i<=totalRows)
	      {
	    	  Browser.driver.navigate().refresh();
	    	  Object[] dataLine= new Object[7];
	    	  dataLine[0] =UserData.getCell(i, 4);
	    	  dataLine[1] =UserData.getCell(i, 5);
	    	  dataLine[2] =UserData.getCell(i, 6);
	    	  dataLine[3] =UserData.getCell(i, 7);
	    	  dataLine[4] =UserData.getCell(i, 8);
	    	  dataLine[5] =UserData.getCell(i, 9);
	    	  dataLine[6] =UserData.getCell(i, 10);
	    	  dataList.add(dataLine);
	    	  i++;
	      }
	    	  Object[][] data=new Object[dataList.size()][];
	    		for(int i=0;i<dataList.size();i++)
	    			data[i]=(Object[])dataList.get(i);
	    	  return data;
		}
	@DataProvider
	public Object[][] DRRecieptMode()
	{
		dataList.clear();
	      i = 58;
	      totalRows = 64;
	      while(i<=totalRows)
	      {
	    	  Browser.driver.navigate().refresh();
	    	  Object[] dataLine= new Object[7];
	    	  dataLine[0] =UserData.getCell(i, 4);
	    	  dataLine[1] =UserData.getCell(i, 5);
	    	  dataLine[2] =UserData.getCell(i, 6);
	    	  dataLine[3] =UserData.getCell(i, 7);
	    	  dataLine[4] =UserData.getCell(i, 8);
	    	  dataLine[5] =UserData.getCell(i, 9);
	    	  dataLine[6] =UserData.getCell(i, 10);
	    	  dataList.add(dataLine);
	    	  i++;
	      }
	    	  Object[][] data=new Object[dataList.size()][];
	    		for(int i=0;i<dataList.size();i++)
	    			data[i]=(Object[])dataList.get(i);
	    	  return data;
		}
	@DataProvider
	public Object[][] DRDisPer()
	{
		dataList.clear();
	      i = 66;
	      totalRows = 68;
	      while(i<=totalRows)
	      {
	    	  Browser.driver.navigate().refresh();
	    	  Object[] dataLine= new Object[7];
	    	  dataLine[0] =UserData.getCell(i, 4);
	    	  dataLine[1] =UserData.getCell(i, 5);
	    	  dataLine[2] =UserData.getCell(i, 6);
	    	  dataLine[3] =UserData.getCell(i, 7);
	    	  dataLine[4] =UserData.getCell(i, 8);
	    	  dataLine[5] =UserData.getCell(i, 9);
	    	  dataLine[6] =UserData.getCell(i, 10);
	    	  dataList.add(dataLine);
	    	  i++;
	      }
	    	  Object[][] data=new Object[dataList.size()][];
	    		for(int i=0;i<dataList.size();i++)
	    			data[i]=(Object[])dataList.get(i);
	    	  return data;
	}
	
	@DataProvider
	public Object[][] DRDisINR()
	{
		dataList.clear();
	      i = 70;
	      totalRows = 72;
	      while(i<=totalRows)
	      {
	    	  Browser.driver.navigate().refresh();
	    	  Object[] dataLine= new Object[7];
	    	  dataLine[0] =UserData.getCell(i, 4);
	    	  dataLine[1] =UserData.getCell(i, 5);
	    	  dataLine[2] =UserData.getCell(i, 6);
	    	  dataLine[3] =UserData.getCell(i, 7);
	    	  dataLine[4] =UserData.getCell(i, 8);
	    	  dataLine[5] =UserData.getCell(i, 9);
	    	  dataLine[6] =UserData.getCell(i, 10);
	    	  dataList.add(dataLine);
	    	  i++;
	      }
	    	  Object[][] data=new Object[dataList.size()][];
	    		for(int i=0;i<dataList.size();i++)
	    			data[i]=(Object[])dataList.get(i);
	    	  return data;
	}
	@DataProvider
	public Object[][] DRTradeDis()
	{
		dataList.clear();
	      i = 74;
	      totalRows = 76;
	      while(i<=totalRows)
	      {
	    	  Browser.driver.navigate().refresh();
	    	  Object[] dataLine= new Object[7];
	    	  dataLine[0] =UserData.getCell(i, 4);
	    	  dataLine[1] =UserData.getCell(i, 5);
	    	  dataLine[2] =UserData.getCell(i, 6);
	    	  dataLine[3] =UserData.getCell(i, 7);
	    	  dataLine[4] =UserData.getCell(i, 8);
	    	  dataLine[5] =UserData.getCell(i, 9);
	    	  dataLine[6] =UserData.getCell(i, 10);
	    	  dataList.add(dataLine);
	    	  i++;
	      }
	    	  Object[][] data=new Object[dataList.size()][];
	    		for(int i=0;i<dataList.size();i++)
	    			data[i]=(Object[])dataList.get(i);
	    	  return data;
	}
	@DataProvider
	public Object[][] DRPurchaseTax()
	{
		dataList.clear();
	      i = 78;
	      totalRows = 80;
	      while(i<=totalRows)
	      {
	    	  Browser.driver.navigate().refresh();
	    	  Object[] dataLine= new Object[8];
	    	  dataLine[0] =UserData.getCell(i, 4);
	    	  dataLine[1] =UserData.getCell(i, 5);
	    	  dataLine[2] =UserData.getCell(i, 6);
	    	  dataLine[3] =UserData.getCell(i, 7);
	    	  dataLine[4] =UserData.getCell(i, 8);
	    	  dataLine[5] =UserData.getCell(i, 9);
	    	  dataLine[6] =UserData.getCell(i, 10);
	    	  dataLine[7] =UserData.getCell(i, 11);
	    	  dataList.add(dataLine);
	    	  i++;
	      }
	    	  Object[][] data=new Object[dataList.size()][];
	    		for(int i=0;i<dataList.size();i++)
	    			data[i]=(Object[])dataList.get(i);
	    	  return data;
	}
	
	@DataProvider
	public Object[][] TDSTax()
	{
		dataList.clear();
		i=82;
		Object[] dataLine =new Object[6];
		dataLine[0] = UserData.getCell(i, 4);
		dataLine[1] = UserData.getCell(i, 5);
		dataLine[2] = UserData.getCell(i, 6);
		dataLine[3] = UserData.getCell(i, 7);
		dataLine[4] = UserData.getCell(i, 8);
		dataLine[5] = UserData.getCell(i, 9);
		dataList.add(dataLine);
		Object[][] data=new Object[dataList.size()][];
		for(int i=0;i<dataList.size();i++)
			data[i]=(Object[])dataList.get(i);
		return data;
	}
	@DataProvider
 	public Object[][] DRMUOM()
	{
		dataList.clear();
		      i = 84;
		      totalRows = 86;
		      while(i<=totalRows)
		      {
		    	  Browser.driver.navigate().refresh();
		    	  Object[] dataLine= new Object[8];
		    	  dataLine[0] =UserData.getCell(i, 4);
		    	  dataLine[1] =UserData.getCell(i, 5);
		    	  dataLine[2] =UserData.getCell(i, 6);
		    	  dataLine[3] =UserData.getCell(i, 7);
		    	  dataLine[4] =UserData.getCell(i, 8);
		    	  dataLine[5] =UserData.getCell(i, 9);
		    	  dataLine[6] =UserData.getCell(i, 10);
		    	  dataLine[7] =UserData.getCell(i, 11);
		    	  dataList.add(dataLine);
		    	  i++;
		      }
		    	  Object[][] data=new Object[dataList.size()][];
		    		for(int i=0;i<dataList.size();i++)
		    			data[i]=(Object[])dataList.get(i);
		    	  return data;
		}
	@DataProvider
	public Object[][] DRBatchable()
	{
		dataList.clear();
	      i = 88;
	      totalRows = 90;
	      while(i<=totalRows)
	      {
	    	  Browser.driver.navigate().refresh();
	    	  Object[] dataLine= new Object[7];
	    	  dataLine[0] =UserData.getCell(i, 4);
	    	  dataLine[1] =UserData.getCell(i, 5);
	    	  dataLine[2] =UserData.getCell(i, 6);
	    	  dataLine[3] =UserData.getCell(i, 7);
	    	  dataLine[4] =UserData.getCell(i, 8);
	    	  dataLine[5] =UserData.getCell(i, 9);
	    	  dataLine[6] =UserData.getCell(i, 10);
	    	  dataList.add(dataLine);
	    	  i++;
	      }
	    	  Object[][] data=new Object[dataList.size()][];
	    		for(int i=0;i<dataList.size();i++)
	    			data[i]=(Object[])dataList.get(i);
	    	  return data;
	}
	@DataProvider
	public Object[][] DRMuomBatchable()
	{
		dataList.clear();
	      i = 92;
	      totalRows = 94;
	      while(i<=totalRows)
	      {
	    	  Browser.driver.navigate().refresh();
	    	  Object[] dataLine= new Object[9];
	    	  dataLine[0] =UserData.getCell(i, 4);
	    	  dataLine[1] =UserData.getCell(i, 5);
	    	  dataLine[2] =UserData.getCell(i, 6);
	    	  dataLine[3] =UserData.getCell(i, 7);
	    	  dataLine[4] =UserData.getCell(i, 8);
	    	  dataLine[5] =UserData.getCell(i, 9);
	    	  dataLine[6] =UserData.getCell(i, 10);
	    	  dataLine[7] =UserData.getCell(i, 11);
	    	  dataLine[8] =UserData.getCell(i, 12);
	    	  dataList.add(dataLine);
	    	  i++;
	      }
	    	  Object[][] data=new Object[dataList.size()][];
	    		for(int i=0;i<dataList.size();i++)
	    			data[i]=(Object[])dataList.get(i);
	    	  return data;
	}
	@DataProvider
	public Object[][] BlankDet()
	{
		dataList.clear();
		i=98;
		Object[] dataLine =new Object[1];
		dataLine[0] = UserData.getCell(i, 4);
	   dataList.add(dataLine);
		Object[][] data=new Object[dataList.size()][];
		i = dataList.size()-1;
	    data[i]=(Object[])dataList.get(i);
		return data;
	}
	@DataProvider
	
		public Object[][] DRMemo()
		{
			dataList.clear();
		      i = 100;
		      totalRows = 102;
		      while(i<=totalRows)
		      {
		    	  Browser.driver.navigate().refresh();
		    	  Object[] dataLine= new Object[7];
		    	  dataLine[0] =UserData.getCell(i, 4);
		    	  dataLine[1] =UserData.getCell(i, 5);
		    	  dataLine[2] =UserData.getCell(i, 6);
		    	  dataLine[3] =UserData.getCell(i, 7);
		    	  dataLine[4] =UserData.getCell(i, 8);
		    	  dataLine[5] =UserData.getCell(i, 9);
		    	  dataLine[6] =UserData.getCell(i, 10);
		    	  dataList.add(dataLine);
		    	  i++;
		      }
		    	  Object[][] data=new Object[dataList.size()][];
		    		for(int i=0;i<dataList.size();i++)
		    			data[i]=(Object[])dataList.get(i);
		    	  return data;
	}
	
	@DataProvider
	
	public Object[][] DRTc()
	{
		dataList.clear();
	      i = 104;
	      totalRows = 106;
	      while(i<=totalRows)
	      {
	    	  Browser.driver.navigate().refresh();
	    	  Object[] dataLine= new Object[7];
	    	  dataLine[0] =UserData.getCell(i, 4);
	    	  dataLine[1] =UserData.getCell(i, 5);
	    	  dataLine[2] =UserData.getCell(i, 6);
	    	  dataLine[3] =UserData.getCell(i, 7);
	    	  dataLine[4] =UserData.getCell(i, 8);
	    	  dataLine[5] =UserData.getCell(i, 9);
	    	  dataLine[6] =UserData.getCell(i, 10);
	    	  dataList.add(dataLine);
	    	  i++;
	      }
	    	  Object[][] data=new Object[dataList.size()][];
	    		for(int i=0;i<dataList.size();i++)
	    			data[i]=(Object[])dataList.get(i);
	    	  return data;
}
	@DataProvider
	public Object[][] DRReference()
	{
		dataList.clear();
	      i = 108;
	      totalRows = 110;
	      while(i<=totalRows)
	      {
	    	  Browser.driver.navigate().refresh();
	    	  Object[] dataLine= new Object[8];
	    	  dataLine[0] =UserData.getCell(i, 4);
	    	  dataLine[1] =UserData.getCell(i, 5);
	    	  dataLine[2] =UserData.getCell(i, 6);
	    	  dataLine[3] =UserData.getCell(i, 7);
	    	  dataLine[4] =UserData.getCell(i, 8);
	    	  dataLine[5] =UserData.getCell(i, 9);
	    	  dataLine[6] =UserData.getCell(i, 10);
	    	  dataLine[7] =UserData.getCell(i, 11);
	    	  dataList.add(dataLine);
	    	  i++;
	      }
	    	  Object[][] data=new Object[dataList.size()][];
	    		for(int i=0;i<dataList.size();i++)
	    			data[i]=(Object[])dataList.get(i);
	    	  return data;
}
	@DataProvider
	public Object[][] DRMultiCurrency()
	{
		dataList.clear();
	      i = 112;
	      totalRows = 114;
	      while(i<=totalRows)
	      {
	    	  Browser.driver.navigate().refresh();
	    	  Object[] dataLine= new Object[8];
	    	  dataLine[0] =UserData.getCell(i, 4);
	    	  dataLine[1] =UserData.getCell(i, 5);
	    	  dataLine[2] =UserData.getCell(i, 6);
	    	  dataLine[3] =UserData.getCell(i, 7);
	    	  dataLine[4] =UserData.getCell(i, 8);
	    	  dataLine[5] =UserData.getCell(i, 9);
	    	  dataLine[6] =UserData.getCell(i, 10);
	    	  dataLine[7] =UserData.getCell(i, 11);
	    	  dataList.add(dataLine);
	    	  i++;
	      }
	    	  Object[][] data=new Object[dataList.size()][];
	    		for(int i=0;i<dataList.size();i++)
	    			data[i]=(Object[])dataList.get(i);
	    	  return data;
}
	@DataProvider
	public Object[][] DRShipCharge()
	{
		dataList.clear();
	      i = 116;
	      totalRows = 118;
	      while(i<=totalRows)
	      {
	    	  Browser.driver.navigate().refresh();
	    	  Object[] dataLine= new Object[7];
	    	  dataLine[0] =UserData.getCell(i, 4);
	    	  dataLine[1] =UserData.getCell(i, 5);
	    	  dataLine[2] =UserData.getCell(i, 6);
	    	  dataLine[3] =UserData.getCell(i, 7);
	    	  dataLine[4] =UserData.getCell(i, 8);
	    	  dataLine[5] =UserData.getCell(i, 9);
	    	  dataLine[6] =UserData.getCell(i, 10);
	    	  dataList.add(dataLine);
	    	  i++;
	      }
	    	  Object[][] data=new Object[dataList.size()][];
	    		for(int i=0;i<dataList.size();i++)
	    			data[i]=(Object[])dataList.get(i);
	    	  return data;
	}
	@DataProvider
	public Object[][] DRShipTax()
	{
		dataList.clear();
	      i = 120;
	      totalRows = 122;
	      while(i<=totalRows)
	      {
	    	  Browser.driver.navigate().refresh();
	    	  Object[] dataLine= new Object[8];
	    	  dataLine[0] =UserData.getCell(i, 4);
	    	  dataLine[1] =UserData.getCell(i, 5);
	    	  dataLine[2] =UserData.getCell(i, 6);
	    	  dataLine[3] =UserData.getCell(i, 7);
	    	  dataLine[4] =UserData.getCell(i, 8);
	    	  dataLine[5] =UserData.getCell(i, 9);
	    	  dataLine[6] =UserData.getCell(i, 10);
	    	  dataLine[7] =UserData.getCell(i, 11);
	    	  dataList.add(dataLine);
	    	  i++;
	      }
	    	  Object[][] data=new Object[dataList.size()][];
	    		for(int i=0;i<dataList.size();i++)
	    			data[i]=(Object[])dataList.get(i);
	    	  return data;
	}
	@DataProvider
	public Object[][] DRVehicleDetail()
	{
		dataList.clear();
	      i = 124;
	      totalRows = 126;
	      while(i<=totalRows)
	      {
	    	  Browser.driver.navigate().refresh();
	    	  Object[] dataLine= new Object[12];
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
	    	  dataLine[10] =UserData.getCell(i, 14);
	    	  dataLine[11] =UserData.getCell(i, 15);
	    	  dataList.add(dataLine);
	    	  i++;
	      }
	    	  Object[][] data=new Object[dataList.size()][];
	    		for(int i=0;i<dataList.size();i++)
	    			data[i]=(Object[])dataList.get(i);
	    	  return data;
	}
	@DataProvider
	public Object[][] DRRoundoff()
	{
		dataList.clear();
	      i = 128;
	      totalRows = 130;
	      while(i<=totalRows)
	      {
	    	  Browser.driver.navigate().refresh();
	    	  Object[] dataLine= new Object[7];
	    	  dataLine[0] =UserData.getCell(i, 4);
	    	  dataLine[1] =UserData.getCell(i, 5);
	    	  dataLine[2] =UserData.getCell(i, 6);
	    	  dataLine[3] =UserData.getCell(i, 7);
	    	  dataLine[4] =UserData.getCell(i, 8);
	    	  dataLine[5] =UserData.getCell(i, 9);
	    	  dataLine[6] =UserData.getCell(i, 10);
	    	  dataList.add(dataLine);
	    	  i++;
	      }
	    	  Object[][] data=new Object[dataList.size()][];
	    		for(int i=0;i<dataList.size();i++)
	    			data[i]=(Object[])dataList.get(i);
	    	  return data;
	}
	}
	
	



	

