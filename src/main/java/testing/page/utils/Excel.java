package testing.page.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.util.NumberToTextConverter;

public class Excel {
    public Excel() {
    }

    public List<Map<String, String>> getData(String excelFilePath, String sheetName) throws InvalidFormatException, IOException {
        Sheet sheet = this.getSheetByName(excelFilePath, sheetName);
        return this.readSheet(sheet);
    }

    public List<Map<String, String>> getData(String excelFilePath, int sheetNumber) throws InvalidFormatException, IOException {
        Sheet sheet = this.getSheetByIndex(excelFilePath, sheetNumber);
        return this.readSheet(sheet);
    }

    private Sheet getSheetByName(String excelFilePath, String sheetName) throws IOException, InvalidFormatException {
        Sheet sheet = this.getWorkBook(excelFilePath).getSheet(sheetName);
        return sheet;
    }

    private Sheet getSheetByIndex(String excelFilePath, int sheetNumber) throws IOException, InvalidFormatException {
        Sheet sheet = this.getWorkBook(excelFilePath).getSheetAt(sheetNumber);
        return sheet;
    }

    private Workbook getWorkBook(String excelFilePath) throws IOException, InvalidFormatException {
        return WorkbookFactory.create(new File(excelFilePath));
    }

    private List<Map<String, String>> readSheet(Sheet sheet) {
        int totalRow = sheet.getPhysicalNumberOfRows();
        List<Map<String, String>> excelRows = new ArrayList();
        int headerRowNumber = this.getHeaderRowNumber(sheet);
        if (headerRowNumber != -1) {
            int totalColumn = sheet.getRow(headerRowNumber).getLastCellNum();
            int setCurrentRow = 1;

            for(int currentRow = setCurrentRow; currentRow <= totalRow; ++currentRow) {
                Row row = this.getRow(sheet, sheet.getFirstRowNum() + currentRow);
                LinkedHashMap<String, String> columnMapdata = new LinkedHashMap();

                for(int currentColumn = 0; currentColumn < totalColumn; ++currentColumn) {
                    columnMapdata.putAll(this.getCellValue(sheet, row, currentColumn));
                }

                excelRows.add(columnMapdata);
            }
        }

        return excelRows;
    }

    private int getHeaderRowNumber(Sheet sheet) {
        int totalRow = sheet.getLastRowNum();

        for(int currentRow = 0; currentRow <= totalRow + 1; ++currentRow) {
            Row row = this.getRow(sheet, currentRow);
            if (row != null) {
                int totalColumn = row.getLastCellNum();

                for(int currentColumn = 0; currentColumn < totalColumn; ++currentColumn) {
                    Cell cell = row.getCell(currentColumn, MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    if (cell.getCellType() == CellType.STRING) {
                        return row.getRowNum();
                    }

                    if (cell.getCellType() == CellType.NUMERIC) {
                        return row.getRowNum();
                    }

                    if (cell.getCellType() == CellType.BOOLEAN) {
                        return row.getRowNum();
                    }

                    if (cell.getCellType() == CellType.ERROR) {
                        return row.getRowNum();
                    }
                }
            }
        }

        return -1;
    }

    private Row getRow(Sheet sheet, int rowNumber) {
        return sheet.getRow(rowNumber);
    }

    private LinkedHashMap<String, String> getCellValue(Sheet sheet, Row row, int currentColumn) {
        LinkedHashMap<String, String> columnMapdata = new LinkedHashMap();
        String columnHeaderName;
        if (row == null) {
            if (sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn, MissingCellPolicy.CREATE_NULL_AS_BLANK).getCellType() != CellType.BLANK) {
                columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn).getStringCellValue();
                columnMapdata.put(columnHeaderName, "");
            }
        } else {
            Cell cell = row.getCell(currentColumn, MissingCellPolicy.CREATE_NULL_AS_BLANK);
            if (cell.getCellType() == CellType.STRING) {
                if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), MissingCellPolicy.CREATE_NULL_AS_BLANK).getCellType() != CellType.BLANK) {
                    columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex()).getStringCellValue();
                    columnMapdata.put(columnHeaderName, cell.getStringCellValue());
                }
            } else if (cell.getCellType() == CellType.NUMERIC) {
                if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), MissingCellPolicy.CREATE_NULL_AS_BLANK).getCellType() != CellType.BLANK) {
                    columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex()).getStringCellValue();
                    columnMapdata.put(columnHeaderName, NumberToTextConverter.toText(cell.getNumericCellValue()));
                }
            } else if (cell.getCellType() == CellType.BLANK) {
                if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), MissingCellPolicy.CREATE_NULL_AS_BLANK).getCellType() != CellType.BLANK) {
                    columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex()).getStringCellValue();
                    columnMapdata.put(columnHeaderName, "");
                }
            } else if (cell.getCellType() == CellType.BOOLEAN) {
                if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), MissingCellPolicy.CREATE_NULL_AS_BLANK).getCellType() != CellType.BLANK) {
                    columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex()).getStringCellValue();
                    columnMapdata.put(columnHeaderName, Boolean.toString(cell.getBooleanCellValue()));
                }
            } else if (cell.getCellType() == CellType.ERROR && sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), MissingCellPolicy.CREATE_NULL_AS_BLANK).getCellType() != CellType.BLANK) {
                columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex()).getStringCellValue();
                columnMapdata.put(columnHeaderName, Byte.toString(cell.getErrorCellValue()));
            }
        }

        return columnMapdata;
    }
}