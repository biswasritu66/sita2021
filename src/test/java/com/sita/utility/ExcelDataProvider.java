package com.sita.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * This class contains methods for reading the data in excel sheet
 * @author Ritu
 *
 */
public class ExcelDataProvider {

	static XSSFWorkbook wb;
	//static XSSFSheet sheet;
	public ExcelDataProvider()
	{
		
		File src=new File("./TestData/Data.xlsx");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		
		}  catch (Exception e)
		{
			
			System.out.println("Unable to read Excel File"+e.getMessage());
		
		} 
		
	}
	public String getStringData(int sheetIndex,int row,int column)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	
	public String getStringData(String sheetName,int row,int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericData(String sheetName,int row,int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}

	
	
}























