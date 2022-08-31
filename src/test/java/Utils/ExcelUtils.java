package Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtils {

    public static Object[][] getTableArray(String fileName, String sheetName) throws Exception {
        String[][] data = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            XSSFRow row = sheet.getRow(0);
            int numOfRows = sheet.getPhysicalNumberOfRows();
            int numOfCols = row.getLastCellNum();
            XSSFCell cell;
            data = new String[numOfRows - 1][numOfCols];
            for (int i = 1; i < numOfRows; i++) {
                row = sheet.getRow(i);
                for (int j = 0; j < numOfCols; j++) {
                    cell = row.getCell(j);
                    String value = new DataFormatter().formatCellValue(cell);
                    data[i - 1][j] = value;
                }
            }
            workbook.close();
            fis.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

}
