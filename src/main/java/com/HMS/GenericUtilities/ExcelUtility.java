package com.HMS.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

/**
 * @author user Prasad J
 */
public class ExcelUtility {
	/**
	 * This method will help to read data from Excel file
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fis = new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		String value = sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
	}

	/**
	 * This method will to write data into Excel file
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param value
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String sheetName, int rowNum, int cellNum, String value) throws Throwable {
		FileInputStream fis = new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		sh.createRow(rowNum).createCell(cellNum).setCellValue(value);
		FileOutputStream fos = new FileOutputStream(IConstantUtility.excelFilePath);
		wb.write(fos);
		wb.close();
	}

	/**
	 * This method will fetch rows count created in excel sheet
	 * 
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		return lastRow;
	}

	public HashMap<String, String> getMultipleDataFromExcel(String sheetName, int keyColumn, int valueColumn,
			WebDriver driver) throws Throwable {
		// fetching data from excel
		FileInputStream fis = new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		HashMap<String, String> map = new HashMap<String, String>();// empty map

		for (int i = 1; i <= count; i++) {
			String key = sh.getRow(i).getCell(keyColumn).getStringCellValue();
			String value = sh.getRow(i).getCell(valueColumn).getStringCellValue();
			map.put(key, value);
		}

		return map;
	}

	/**
	 * This method will fetch  set of data from excel
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] getMultipleSetOfData(String sheetName) throws Throwable {

		FileInputStream fis = new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastRow + 1][lastCell];

		for (int i = 1; i <= lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
}
