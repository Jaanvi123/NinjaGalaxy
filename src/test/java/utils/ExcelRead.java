package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelRead {

	private static final String FILE_PATH = "src/test/resources/TestData/TestData.xlsx"; // Path to the Excel file

	public List<Map<String, String>> readExcelSheet(String sheetName) throws IOException {
		List<Map<String, String>> excelData = new ArrayList<>();

		FileInputStream fileInputStream = new FileInputStream(new File(FILE_PATH));
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);

		if (sheet == null) {
			workbook.close();
			throw new IOException("Sheet " + sheetName + " not found in " + FILE_PATH);
		}

		Row headerRow = sheet.getRow(0); // First row contains column headers
		int totalColumns = headerRow.getLastCellNum();

		for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Start from row 1 (Skipping headers)
			Row row = sheet.getRow(i);
			if (row == null)
				continue;

			Map<String, String> rowData = new HashMap<>();
			for (int j = 0; j < totalColumns; j++) {
				Cell headerCell = headerRow.getCell(j);
				Cell dataCell = row.getCell(j);

				String header = headerCell.getStringCellValue().trim();
				String value = (dataCell != null) ? dataCell.toString().trim() : ""; // Avoid null cells

				rowData.put(header, value);
			}
			excelData.add(rowData);
		}

		workbook.close();
		fileInputStream.close();
		return excelData;
	}
}
