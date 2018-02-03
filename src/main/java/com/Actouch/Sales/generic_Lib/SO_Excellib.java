package com.Actouch.Sales.generic_Lib;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SO_Excellib {
final String filePath;

	public SO_Excellib(String filepat)
	{
		 this.filePath=filepat;
	}
	
	public int getExcelData(String sheetName, int rowNum, int colNum) throws EncryptedDocumentException, InvalidFormatException, IOException 
	{
		
		FileInputStream fis = new FileInputStream(filePath);
		System.out.println(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		
		//String data = row.getCell(colNum).getStringCellValue();
		int pa = (int) row.getCell(colNum).getNumericCellValue();
		
		return pa;
		
	}

	public void setExcelData(String sheetName, int rowNum, int colNum, String data) throws EncryptedDocumentException, InvalidFormatException, IOException  {
		
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
			
	}
	
public   String getExcelDat(String sheetName, int rowNum, int colNum) throws EncryptedDocumentException, InvalidFormatException, IOException 
{
		
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		
		String data = row.getCell(colNum).getStringCellValue();
		
		
		return data;
		
	}
}
