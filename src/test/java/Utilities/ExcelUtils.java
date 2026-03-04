package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static Object[][] getSheetData(String filePath, String sheetName) throws IOException {

        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            workbook.close();
            fis.close();
            throw new RuntimeException("Sheet '" + sheetName + "' does not exist.");
        }

        int totalRows = sheet.getPhysicalNumberOfRows();

        if (totalRows <= 1) {
            workbook.close();
            fis.close();
            return new Object[0][0];
        }

        int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[totalRows - 1][totalCols];

        DataFormatter formatter = new DataFormatter();

        for (int i = 1; i < totalRows; i++) {

            Row row = sheet.getRow(i);

            for (int j = 0; j < totalCols; j++) {

                if (row == null) {
                    data[i - 1][j] = "";
                } else {
                    Cell cell = row.getCell(j);
                    data[i - 1][j] = (cell == null) ? "" : formatter.formatCellValue(cell);
                }
            }
        }

        workbook.close();
        fis.close();

        return data;
    }
}
