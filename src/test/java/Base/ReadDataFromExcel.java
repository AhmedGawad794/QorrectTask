package Base;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    //region Constructor for the class

    /**
     *
     * @param filePath the directory of the excel file
     * @param sheetName the sheet name inside that excel file, default is "Sheet1"
     */
    public ReadDataFromExcel(String filePath, String sheetName) {
        try {
            workbook = new XSSFWorkbook(filePath);
            sheet = workbook.getSheet(sheetName);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
            System.out.println(ex.getStackTrace());
        }
    }
    //endregion

    //region Methods to manipulate excel sheet

    /**
     * This Method helps in looping throw the Excel sheet
     */
    public static void GetRowCount(){
        try{
            int rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("number of rows is: " + rowCount);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
            System.out.println(ex.getStackTrace());
        }
    }

    /**
     * This method gets the cell data if and only if the cell data is string not numeric values
     * @param rowNumber cell row number starting from 0
     * @param columnNumber cell column number starting from 0
     * @return
     */
    public static String GetCellDataAsString(int rowNumber, int columnNumber){
        try {
            String cellData = sheet.getRow(rowNumber).getCell(columnNumber).getStringCellValue();
            return cellData;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
            System.out.println(ex.getStackTrace());
            return null;
        }

    }
    /**
     * This method gets the cell data if and only if the cell data is numeric not string values
     * @param rowNumber cell row number starting from 0
     * @param columnNumber cell column number starting from 0
     * @return
     */
    public static double GetCellDataAsNumericValues(int rowNumber, int columnNumber){
        try {
            double cellData = sheet.getRow(rowNumber).getCell(columnNumber).getNumericCellValue();
            return cellData;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
            System.out.println(ex.getStackTrace());
            return 0;
        }
    }
    //endregion
}
