package com.Utilities;

import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {
	
	@DataProvider(name="ValidexcelData",parallel = true)
	public Object[][] ValidexcelDataProvider() throws IOException{
		Object[][] arrObj = getExcelData("src\\test\\resources\\Files.xlsx","Sheet1");
		return new Object[][] { arrObj[0]};
	}
	
	@DataProvider(name="InValidexcelData",parallel = true)
	public Object[][] InvalidexcelDataProvider() throws IOException{
		Object[][] arrObj = getExcelData("src\\test\\resources\\Files.xlsx","Sheet1");
		return new Object[][] { arrObj[1],arrObj[2]};
	}

	private String[][] getExcelData(String FileName, String SheetName) {
		String[][] data = null;
		
		try {
			
			FileInputStream fis = new FileInputStream(FileName);
			XSSFWorkbook workBook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workBook.getSheet(SheetName);
			XSSFRow row = sheet.getRow(0);
			int noOfRows = sheet.getPhysicalNumberOfRows();
			int noOfCol = row.getLastCellNum();
			
			Cell cell;
			
			data = new String[noOfRows-1][noOfCol];
			
			for(int i=1;i<noOfRows;i++) {
				for(int j=0;j<noOfCol;j++) {
					row=sheet.getRow(i);
					cell=row.getCell(j);
					data[i-1][j]=cell.getStringCellValue();
				}
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return data;
	}

}
