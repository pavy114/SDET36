package com.crm.concasttt.Genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author Pavithra
 * 
 */

public class ExcelUtility implements IConstants{
	
	
	
	/**
	 *  its used read the data from excel base don below arguments 
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return Data
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName , int rowNum, int celNum) throws Throwable {
		FileInputStream fis  = new FileInputStream(EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}
	/**
	 * used to get the last used row number on specified Sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis  = new FileInputStream(EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	}
	
	public void setDataExcel(String sheetName , int rowNum, int celNum ,String data) throws Throwable {
		FileInputStream fis  = new FileInputStream(EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(celNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(EXCELPATH);
		wb.write(fos);
		wb.close();
		
	}
}
	
	
	
	
	
	/**
	 * @throws Throwable 
	 * 
	 */
	
	//public getDataFromEXcel(Sring sheetname,int row,int col)
//	{
	//	FileInputStream fis= new FileInputStream("./Testdata/Exceldata.xlsx");
	//	Workbook wb = WorkbookFactory.create(fis);
	//	Sheet sh = wb.getSheet("Vtiger");
		//Row row1 = sh.getRow(0);
	//	Cell c1 = row1.getCell(1);
	//	String url = c1.getStringCellValue();
	//}


