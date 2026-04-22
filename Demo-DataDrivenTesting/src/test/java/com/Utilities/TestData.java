package com.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name="ValidLoginData",parallel = true)
	public Object[][] ValidexcelDataProvider() throws IOException{
		Object[][] arrObj = getData("src\\test\\resources\\InputFile.xlsx","Sheet1");
		return arrObj;
	}
	
	@DataProvider(name="InValidLoginData",parallel = true)
	public Object[][] InvalidexcelDataProvider() throws IOException{
		Object[][] arrObj = getData("src\\test\\resources\\InputFile.xlsx","Sheet2");
		return arrObj;
	}
	
	@DataProvider(name="SearchData",parallel = true)
	public Object[][] SearchDataProvider() throws IOException{
		Object[][] arrObj = getData("src\\test\\resources\\InputFile.xlsx","Sheet3");
		return arrObj;
	}
	
	@DataProvider(name="InvalidSearchData",parallel = true)
	public Object[][] InvalidSearchDataProvider() throws IOException{
		Object[][] arrObj = getData("src\\test\\resources\\InputFile.xlsx","Sheet4");
		return arrObj;
	}
	

	private String[][] getData(String FileName, String SheetName) {
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
