package com.sause.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public Object stringValue;
    FileInputStream fis;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;
    String rowHeadString;
    int RequiredRow;

    public ExcelReader getSheetByName(String sheetName) throws IOException {
        fis = new FileInputStream("C:\\Users\\Manjunath Butna\\eclipse-workspace\\BusinessAdmin\\ExcelFiles\\BA_Portal_Excel.xlsx");
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        return this;
    }

    public ExcelReader getSheetByIndex(int sheetNumber) throws IOException {
        fis = new FileInputStream("C:/Users/Manjunath Butna/eclipse-workspace/BusinessAdmin/ExcelFiles/BA_Portal_Excel.xlsx");
        workbook = new XSSFWorkbook(fis);
        int currentSheet = sheetNumber - 1;
        sheet = workbook.getSheetAt(currentSheet);
        return this;
    }

    public ExcelReader getRequiredRow(int rowNumber) {
        RequiredRow = rowNumber - 1;
        System.out.println(RequiredRow);
        row = sheet.getRow(RequiredRow);
        return this;
    }

    public ExcelReader getRequiredColumn(int columnNumber) {
        int currentColumn = columnNumber - 1;
        cell = row.getCell(currentColumn);
        if (cell.getCellType() == CellType.STRING) {
            stringValue = cell.getStringCellValue();
            // System.out.println(stringValue);
            return this;
        } else if (cell.getCellType() == CellType.NUMERIC) {
            stringValue = cell.getNumericCellValue();
            return this;
        } else if (cell.getCellType() == CellType.BOOLEAN) {
            stringValue = cell.getBooleanCellValue();
            return this;
        } else if (cell.getCellType() == CellType.ERROR) {
            stringValue = cell.getErrorCellString();
            return this;
        }
        stringValue = cell.getStringCellValue();
        return this;
    }

    public ExcelReader getByRowHeading(String rowHeader) {
        rowHeadString = rowHeader;
        int totalRow = sheet.getLastRowNum();
        for (int currentRow = 0; currentRow <= totalRow; currentRow++) {
            row = sheet.getRow(currentRow);
            if (row != null) {
                int totalColumn = row.getLastCellNum();
                for (int currentColumn = 0; currentColumn <= totalColumn; currentColumn++) {
                    cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().equals(rowHeader)) {
                        if (cell.getCellType() == CellType.STRING) {
                            // System.out.println(currentRow);
                            cell = row.getCell(currentColumn);
                            stringValue = cell.getStringCellValue();
                            // System.out.println(stringValue);
                            return this;
                        } else if (cell.getCellType() == CellType.NUMERIC) {
                            stringValue = cell.getNumericCellValue();
                            return this;
                        } else if (cell.getCellType() == CellType.BOOLEAN) {
                            stringValue = cell.getBooleanCellValue();
                            return this;
                        } else if (cell.getCellType() == CellType.BLANK) {
                            stringValue = cell.getStringCellValue();
                            return this;
                        }
                        return this;
                    }
                }
            }
        }
        return this;
    }

    public ExcelReader getByColumnHeading(String columnHeading) {
        int totalRow = sheet.getLastRowNum();
        for (int currentRow = 0; currentRow <= totalRow; currentRow++) {
            row = sheet.getRow(currentRow);
            if (row != null) {
                int totalColumn = row.getLastCellNum();
                for (int currentColumn = 0; currentColumn <= totalColumn; currentColumn++) {
                    cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    // System.out.println("charan");
                    if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().equals(rowHeadString)) {
                        int rowNumberFetched = row.getRowNum();
                        // System.out.println(rowNumberFetched);
                        // getCellValue(rowNumberFetched, columnHeading);
                        row = sheet.getRow(0);
                        if (row != null) {
                            int totalColumns = row.getLastCellNum();
                            // System.out.println(totalColumns);
                            for (int currentColumns = 0; currentColumns <= totalColumns; currentColumns++) {
                                // System.out.println(currentColumns);
                                cell = row.getCell(currentColumns, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                                cell = row.getCell(currentColumns);
                                stringValue = cell.getStringCellValue();
                                // System.out.println(stringValue);
                                if (cell.getCellType() == CellType.STRING
                                        && cell.getStringCellValue().equals(columnHeading)) {
                                    // System.out.println("charan");
                                    if (cell.getCellType() == CellType.STRING) {
                                        // System.out.println("kumar");
                                        cell = row.getCell(currentColumns);
                                        stringValue = cell.getStringCellValue();
                                        int cellNumberFetched = cell.getColumnIndex();
                                        // System.out.println(cellNumberFetched);
                                        getRequiredRow(rowNumberFetched + 1).getRequiredColumn(cellNumberFetched + 1);
                                        return this;
                                    } else if (cell.getCellType() == CellType.NUMERIC) {
                                        // System.out.println("kumar");
                                        cell = row.getCell(currentColumns);
                                        stringValue = cell.getStringCellValue();
                                        int cellNumberFetched = cell.getColumnIndex();
                                        // System.out.println(cellNumberFetched);
                                        getRequiredRow(rowNumberFetched + 1).getRequiredColumn(cellNumberFetched + 1);
                                        return this;

                                    }
                                    return this;
                                }
                            }
                        }
                        return this;
                    } else {
                        row = sheet.getRow(0);
                        // System.out.println(row.getRowNum());
                        if (row != null) {
                            int totalColumns = row.getLastCellNum();
                            // System.out.println(totalColumns);
                            for (int currentColumns = 0; currentColumns <= totalColumns; currentColumns++) {
                                // System.out.println(currentColumns);
                                cell = row.getCell(currentColumns, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                                cell = row.getCell(currentColumns);
                                stringValue = cell.getStringCellValue();
                                // System.out.println(stringValue);
                                if (cell.getCellType() == CellType.STRING
                                        && cell.getStringCellValue().equals(columnHeading)) {
                                    // System.out.println("charan");
                                    if (cell.getCellType() == CellType.STRING) {
                                        // System.out.println("kumar");
                                        cell = row.getCell(currentColumns);
                                        stringValue = cell.getStringCellValue();
                                        int cellNumberFetched = cell.getColumnIndex();
                                        System.out.println(cellNumberFetched);
                                        int requiredRow = RequiredRow;
                                        System.out.println(requiredRow);
                                        getRequiredRow(requiredRow + 1).getRequiredColumn(cellNumberFetched + 1);
                                        return this;
                                    } else if (cell.getCellType() == CellType.NUMERIC) {
                                        // System.out.println("kumar");
                                        cell = row.getCell(currentColumns);
                                        stringValue = cell.getStringCellValue();
                                        int cellNumberFetched = cell.getColumnIndex();
                                        System.out.println(cellNumberFetched);
                                        int requiredRow = RequiredRow;
                                        System.out.println(requiredRow);
                                        getRequiredRow(requiredRow + 1).getRequiredColumn(cellNumberFetched + 1);
                                        return this;

                                    }
                                    return this;
                                }
                            }
                        }
                    }
                }
            }
        }
        return this;
    }

}
