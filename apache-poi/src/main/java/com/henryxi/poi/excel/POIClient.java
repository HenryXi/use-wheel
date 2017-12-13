package com.henryxi.poi.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class POIClient {
    public static void main(String[] args) throws Exception {
        FileInputStream excelFile = new FileInputStream(new File("D:\\test.xlsx"));
        Workbook workbook = new XSSFWorkbook(excelFile);
        //if there are multiple sheet use workbook.getNumberOfSheets()
        Sheet currentSheet = workbook.getSheetAt(0);
        String sheetName = currentSheet.getSheetName();
        System.out.println("the sheet name:" + sheetName);
        for (Row currentRow : currentSheet) {
            Cell nameCell = currentRow.getCell(0);
            Cell ageCell = currentRow.getCell(1);
            System.out.println("name:" + nameCell.getStringCellValue() + ",age:" + ageCell.getNumericCellValue());
        }
    }
}
