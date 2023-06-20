package helperMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import config.DefineConstants;

public class ExcelUtils {

	public static List<String> getExcelCellValue(String filePath, String columnHeader) throws IOException {
		List<String> cellValues;
		FileInputStream file = new FileInputStream(DefineConstants.PROJECT_PATH + filePath + ".xlsx");
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		Row row = sheet.getRow(0);
		int count = 0;
		int nameColumn = 0;
		for (; count < row.getLastCellNum(); count++) {
			if (row.getCell(count).toString().equals(columnHeader)) {
				nameColumn = count;
			}
		}
		cellValues = new ArrayList<String>();
		for (int i = 1; i < rowCount + 1; i++) {
			String value = sheet.getRow(i).getCell(nameColumn).getStringCellValue();
			cellValues.add(value);
		}
		workbook.close();
		return cellValues;
	}

	public static String getTetsCaseFlag(String inputTestcaseName) throws IOException {
		String cellValue=null;
		FileInputStream file = new FileInputStream("C:/Users/Admin/workspace/Plumb5/ExecutionFlags.xlsx");
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		int count = 0;
		int testcasename = 0;
		for (; count < rowCount+1; count++) {
			if (sheet.getRow(count).getCell(0).toString().equals(inputTestcaseName)) {
				testcasename = count;								
			}
		}			
		cellValue = sheet.getRow(testcasename).getCell(1).toString();							
		workbook.close();		
		return cellValue;
	}
	
	public static void main(String[] ar) throws IOException {
		List<String> lisvals = ExcelUtils.getExcelCellValue("Keywords", "Actions");

		System.out.println(lisvals);
	}
}
