package com.henryxi.poi.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ReadBookExcelClient {
    private static final String url = "jdbc:postgresql://10.232.29.78:5432/blog";

    public static void main(String[] args) throws Exception {
        FileInputStream excelFile = new FileInputStream(new File("E:\\11.xlsx"));
        Workbook workbook = new XSSFWorkbook(excelFile);
        int numberOfSheets = workbook.getNumberOfSheets();
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(url, "postgres", "postgres");
        PreparedStatement st = conn.prepareStatement("INSERT INTO book (title, score, readers_num, author, publisher, category) VALUES(?,?,?,?,?,?)");
        for (int i = 0; i < numberOfSheets; i++) {
            List<Book> sheetBooks = new ArrayList<>();
            Sheet currentSheet = workbook.getSheetAt(i);
            String sheetName = currentSheet.getSheetName();
            for (Row currentRow : currentSheet) {
                Book book = new Book();
                Cell titleCell = currentRow.getCell(1);
                if ("书名".equals(titleCell.getStringCellValue())) continue;
                Cell scoreCell = currentRow.getCell(2);
                Cell readerNumCell = currentRow.getCell(3);
                Cell authorCell = currentRow.getCell(4);
                Cell publisherCell = currentRow.getCell(5);
                book.setTitle(titleCell.getStringCellValue());
                book.setAuthor(authorCell.getStringCellValue());
                book.setCategory(sheetName);
                book.setScore((int) scoreCell.getNumericCellValue() * 10);
                book.setPublisher(publisherCell.getStringCellValue());
                book.setReader_num((int) readerNumCell.getNumericCellValue());
                sheetBooks.add(book);
            }
            insert(sheetBooks, st);
        }
        conn.close();
    }

    private static void insert(List<Book> books, PreparedStatement statement) throws Exception {
        for (Book book : books) {
            statement.setString(1, book.getTitle());
            statement.setInt(2, book.getScore());
            statement.setInt(3, book.getReader_num());
            statement.setString(4, book.getAuthor());
            statement.setString(5, book.getPublisher());
            statement.setString(6, book.getCategory());
            statement.executeUpdate();
        }
    }
}
