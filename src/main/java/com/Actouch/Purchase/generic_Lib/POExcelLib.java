package com.Actouch.Purchase.generic_Lib;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class POExcelLib {

static String filePath = "D:\\Selenium\\Purchase Order.xlsx";
	
	
public static String getExcelData(String sheetName, int rowNum, int colNum) throws Exception{
		
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		
		String data = row.getCell(colNum).getStringCellValue();
		
		
		return data;
		
	}
	
/*	public int getExcelNumericData(String sheetName, int rowNum, int colNum) throws EncryptedDocumentException, InvalidFormatException, IOException{
		
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		
		//String data = row.getCell(colNum).getStringCellValue();
		int pa = (int) row.getCell(colNum).getNumericCellValue();
		
		return pa;
		
	}

	public void setExcelData(String sheetName, int rowNum, int colNum, String data) throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		
		Cell cel = row.createCell(colNum);
		cel.setCellType(Cell.CELL_TYPE_STRING);
		cel.setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(filePath);
		
		wb.write(fos);
		wb.close();
			
	}*/
	

}




