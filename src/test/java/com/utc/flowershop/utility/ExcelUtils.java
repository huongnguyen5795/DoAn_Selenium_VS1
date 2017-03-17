package com.utc.flowershop.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static XSSFSheet excelWSheet;
	private static XSSFWorkbook excelWBook;
	private static XSSFCell cell;
	private static XSSFRow row;

	public static void setExcelFile(String path, String sheetName) throws Exception {
		try {
			// Open the Excel file
			FileInputStream excelFile = new FileInputStream(path);
			// Access the required test data sheet
			excelWBook = new XSSFWorkbook(excelFile);
			excelWSheet = excelWBook.getSheet(sheetName);
			Log.info("Excel sheet opened");
		} catch (Exception e) {
			throw (e);
		}
	}

	public static String getCellData(int rowNum, int colNum) throws Exception {
		try {
			cell = excelWSheet.getRow(rowNum).getCell(colNum);
			String cellData = cell.getStringCellValue();
			return cellData;
		} catch (Exception e) {
			return "";
		}
	}
	

	// This method is to write in the Excel cell, Row num and Col num are the
	// parameters
	@SuppressWarnings("static-access")
	public static void setCellData(String result, int rowNum, int colNum) throws Exception {
		try {
			row = excelWSheet.getRow(rowNum);
			cell = row.getCell(colNum, row.RETURN_BLANK_AS_NULL);
			if (cell == null) {
				cell = row.createCell(colNum);
				cell.setCellValue(result);
			} else {
				cell.setCellValue(result);
			}
			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(Constant.pathTestData + Constant.fileTestData);
			excelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}

	public static int getRowContains(String sTestCaseName, int colNum) throws Exception {
		int i;
		try {
			int rowCount = ExcelUtils.getRowUsed();
			for (i = 0; i < rowCount; i++) {
				if (ExcelUtils.getCellData(i, colNum).equalsIgnoreCase(sTestCaseName)) {
					break;
				}
			}
			return i;
		} catch (Exception e) {
			Log.error("Class ExcelUtil | Method getRowContains | Exception desc : " + e.getMessage());
			throw (e);
		}
	}

	public static int getRowUsed() throws Exception {
		try {
			int RowCount = excelWSheet.getLastRowNum();
			Log.info("Total number of Row used return as < " + RowCount + " >.");
			return RowCount;
		} catch (Exception e) {
			Log.error("Class ExcelUtil | Method getRowUsed | Exception desc : " + e.getMessage());
			System.out.println(e.getMessage());
			throw (e);
		}

	}

//	public static int getRow_Register(XSSFSheet sheet,int rowIndex) throws Exception{
//		try {
//			XSSFRow row = sheet.getRow(rowIndex - 1);
//			if (row == null) {
//				row = sheet.createRow(rowIndex - 1);
//			}
////			int RowCount = excelWSheet.getLastRowNum();
//			int colCount = excelWSheet.getColumnWidth(8);
//			for (int i = 2; i < colCount; i++) {
//				if(colCount ==2){
//					
//				}
//				
//			}
//			Log.info("Total number of Row used return as < " + RowCount + " >.");
//			return RowCount;
//		} catch (Exception e) {
//			Log.error("Class ExcelUtil | Method getRowUsed | Exception desc : " + e.getMessage());
//			System.out.println(e.getMessage());
//			throw (e);
//		}

//	}
}
