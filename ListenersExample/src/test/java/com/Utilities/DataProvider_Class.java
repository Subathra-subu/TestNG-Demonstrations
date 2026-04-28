package com.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProvider_Class {
	
	@DataProvider(name="data")
	public Object[][] ValidData() throws IOException{
		Object[][] arrObj = getData("src\\test\\resources\\InputFile.xlsx","Sheet1");
		return arrObj;
	}
	
	String[][] getData(String fileName,String sheet){
		
		String[][] data = null;
		
		try {
		
		FileInputStream fis = new FileInputStream(fileName);
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		XSSFSheet Worksheet = workBook.getSheet(sheet);
		XSSFRow row = Worksheet.getRow(0);
		int noOfRows = Worksheet.getPhysicalNumberOfRows();
		int noOfCol = row.getLastCellNum();
		
		Cell cell;
		
		data = new String[noOfRows-1][noOfCol];
		
		for(int i=1;i<noOfRows;i++) {
			for(int j=0;j<noOfCol;j++) {
				
				row=Worksheet.getRow(i);
				cell=row.getCell(j);
				data[i-1][j]=cell.getStringCellValue();
				
			}
		}
		
		}
		catch(Exception e) {
			System.out.print(e);
		}
		
		return data;
		
	}

}
