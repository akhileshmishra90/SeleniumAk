package com.Actouch.Purchase.generic_Lib;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class POSRVExcellLib {

	static String filepath ="D:\\ServerCode\\PO Service.xlsx";
	public static String getExcellData(String SheetName ,int RowName,int ColName) throws Exception
	{
		FileInputStream fis = new FileInputStream(filepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row row = sh.getRow(RowName);
		String data = row.getCell(ColName).getStringCellValue();
		return (data);
	}
}
