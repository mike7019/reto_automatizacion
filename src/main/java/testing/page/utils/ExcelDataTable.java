package testing.page.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ExcelDataTable {

    private XSSFWorkbook book;
    private FileInputStream file;

    public String ReadDataSheet(String page, String path, int rowValue, int cellValue) throws IOException {
        String pointer;
        file = new FileInputStream(new File(path));
        book = new XSSFWorkbook(file);
        Sheet sheet = book.getSheet(page);
        Row row = sheet.getRow(rowValue);
        Cell cell = row.getCell(cellValue);
        pointer = cell.getStringCellValue();
        book.close();
        file.close();
        return pointer;
    }

    public static ArrayList<Map<String, String>> ReadData(String excelPath, String excelSheet) throws IOException {
        ArrayList<Map<String, String>> arrayListWorkPlanData = new ArrayList<Map<String, String>>();
        Map<String, String> projectInformation = new HashMap<String, String>();
        File file = new File(excelPath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkbook.getSheet(excelSheet);
        Iterator<Row> rowIterator = newSheet.iterator();
        Row tiles = rowIterator.next();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                cell.getColumnIndex();
                switch (cell.getCellTypeEnum()) {
                    case STRING:
                        projectInformation.put(tiles.getCell(cell.getColumnIndex()).toString(), cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        projectInformation.put(tiles.getCell(cell.getColumnIndex()).toString(), String.valueOf((long) cell.getNumericCellValue()));
                        break;
                    case BLANK:
                        projectInformation.put(tiles.getCell(cell.getColumnIndex()).toString(), "");
                        break;
                    default:
                }
            }
            arrayListWorkPlanData.add(projectInformation);
            projectInformation = new HashMap<String, String>();
        }
        return arrayListWorkPlanData;
    }
}
