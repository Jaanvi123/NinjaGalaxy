package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelRead {

	 public  String filepath = "src/test/resources/TestData/TestingData.xlsx"; // Path to the Excel file

	public List<Map<String, String>> readExcelSheet(String filepath , String sheetName) throws IOException {
		List<Map<String, String>> excelData = new ArrayList<>();

		FileInputStream fileInputStream = new FileInputStream(new File(filepath));
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);

		if (sheet == null) {
			workbook.close();
			throw new IOException("Sheet " + sheetName + " not found in " + filepath);
		}

		Row headerRow = sheet.getRow(0);
		int totalColumns = headerRow.getLastCellNum();
		

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			if (row == null)
				continue;

			Map<String, String> rowData = new HashMap<>();
			for (int j = 0; j < totalColumns; j++) {
				Cell headerCell = headerRow.getCell(j);
				Cell dataCell = row.getCell(j);

				String header = headerCell.getStringCellValue().trim();
				String value = (dataCell != null) ? dataCell.toString().trim() : ""; 

				rowData.put(header, value);
			}
			excelData.add(rowData);
		}

		workbook.close();
		fileInputStream.close();
		return excelData;
	} 
	
	//new
	/*	public List<Map<String, String>> readFromExcel(String filePath, String sheetName)
			throws IOException {
		
		FileInputStream fis = new FileInputStream(new File(filePath));

		
		Workbook workbook = new XSSFWorkbook(fis);
		
		Sheet sheet = workbook.getSheet(sheetName);
		
		Row row;
		Cell cell;
		int totalRow = sheet.getLastRowNum();
		List<Map<String, String>> excelRows = new ArrayList<>();

		for (int currentRow = 1; currentRow <= totalRow; currentRow++) { 
			row = sheet.getRow(currentRow);
			int totalColumn = row.getLastCellNum();
			
			LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<>();

			String data = null;

			for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) { 
																						
				cell = row.getCell(currentColumn);

				String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
						.getStringCellValue(); 
				

				if (cell != null) {
					if (cell.getCellType() == CellType.STRING) {
						data = cell.getStringCellValue();
					} else if (cell.getCellType() == CellType.NUMERIC) {
						data = String.valueOf(cell.getNumericCellValue());
					} else if (cell.getCellType() == CellType.BLANK) {
						data = String.valueOf(cell.getStringCellValue());
					}
				} else {
					data = "";

				}
				columnMapdata.put(columnHeaderName, data);
			}

			excelRows.add(columnMapdata);
		}

		return excelRows;

	}
	

	*/
	
}
