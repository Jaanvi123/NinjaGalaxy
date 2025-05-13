package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
<<<<<<< Updated upstream
import java.util.ArrayList;
import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

public class ExcelRead {

    private static final String FILE_PATH = "Users/dineshdeshmukh/eclipse-workspace/NinjaGalaxy-Jaanvi-branch/src/test/resources/TestData/TestingData.xlsx"; 

    public static List<Map<String, String>> readExcelSheet(String filePath, String sheetName) throws IOException {
        List<Map<String, String>> excelData = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            workbook.close();
            throw new IOException("Sheet " + sheetName + " not found in " + filePath);
        }

        Row headerRow = sheet.getRow(0);
        int totalColumns = headerRow.getLastCellNum();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;

            Map<String, String> rowData = new HashMap<>();
            boolean isEmptyRow = true;

            for (int j = 0; j < totalColumns; j++) {
                Cell headerCell = headerRow.getCell(j);
                Cell dataCell = row.getCell(j);

                String header = (headerCell != null) ? headerCell.getStringCellValue().trim() : "Column" + j;
                String value = "";

                if (dataCell != null) {
                    switch (dataCell.getCellType()) {
                        case STRING:
                            value = dataCell.getStringCellValue().trim();
                            break;
                        case NUMERIC:
                            value = String.valueOf(dataCell.getNumericCellValue()).trim();
                            break;
                        case BOOLEAN:
                            value = String.valueOf(dataCell.getBooleanCellValue()).trim();
                            break;
                        case FORMULA:
                            value = dataCell.getCellFormula().trim();
                            break;
                        default:
                            value = "";
                            break;
                    }
                    isEmptyRow = false;
                }

                rowData.put(header, value);
            }

            if (!isEmptyRow) {
                excelData.add(rowData);
            }
        }

        workbook.close();
        fileInputStream.close();
        return excelData;
    }

	
}
=======
import java.util.*;

public class ExcelRead {

    private static final String FILE_PATH = "src/test/resources/TestData/TestingData.xlsx";

    public List<Map<String, String>> readExcelSheet(String sheetName) throws IOException {
        List<Map<String, String>> excelData = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream(new File(FILE_PATH));
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            workbook.close();
            throw new IOException("Sheet " + sheetName + " not found in " + FILE_PATH);
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
}
>>>>>>> Stashed changes
