package actions.commons;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public  ReadExcelFile(String excelPath, String sheetName) {
        try{

            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);
            workbook.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static int getRowCount(){
        int rowCount=0;
        try{
            rowCount = sheet.getPhysicalNumberOfRows();
        }catch (Exception exp){
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return rowCount;
    }

    public static int getColCount(){
        int colCount=0;
        try{
            colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        }catch (Exception exp){
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return colCount;
    }

    public static String getCellDataString(int rowNum, int colNum){
        Cell cellData=null;
        String value = null;
        try{
            cellData = sheet.getRow(rowNum).getCell(colNum);
            DataFormatter dataFormatter = new DataFormatter();
            value = dataFormatter.formatCellValue(cellData);

        }catch (Exception exp){
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return value;
    }

    public static double getCellDataNumber(int rowNum, int colNum){
        double cellData=0;
        try{
            cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
        }catch (Exception exp){
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return cellData;
    }

    public static Object[][] testData(String excelPath, String sheetName) {
        new ReadExcelFile(excelPath, sheetName);

        int rowCount = getRowCount();
//        System.out.println(rowCount);
        int colCount = getColCount();
//        System.out.println(colCount);

        Object[][] data = new Object[rowCount-1][colCount];
        for(int i=1; i<rowCount; i++){
            for(int j=0; j<colCount; j++){
                String cellData = getCellDataString(i,j);
                data[i-1][j] = cellData;
            }
        }
        return data;
    }


}