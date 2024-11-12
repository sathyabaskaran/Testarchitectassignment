package FactoryDesignAssignment;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataprovider implements DataProvider{

	private static final Logger logger = Logger.getLogger(ExcelDataprovider.class.getName());
	
	public  String provideData() {
		// TODO Auto-generated method stub
		logger.info("Data supplied from excel");
		String name= "";
		String excelFilePath = "/Users/sbaskaran/testarchitectprojects/01/src/main/resources/data.xlsx"; // Specify the path to your Excel file

        try (FileInputStream fis = new FileInputStream(excelFilePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            // Get the first sheet in the workbook
            Sheet sheet = workbook.getSheetAt(0);

            // Loop through each row in the sheet
            for (Row row : sheet) {
                // Get the cell in the first column (index 0) for the name
                Cell cell = row.getCell(0);
                if (cell != null) {
                    // Print the name
                    System.out.println("Name: " + cell.getStringCellValue());
                     name = cell.getStringCellValue();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return name;
		
	}

}
