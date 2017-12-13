package com.henryxi.poi.word;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;

import java.io.File;
import java.io.FileOutputStream;

public class HideWordClient {
    public static void main(String[] args) throws Exception {
        XWPFDocument document = new XWPFDocument();
        FileOutputStream out = new FileOutputStream(new File("D:\\create_table.docx"));
        XWPFParagraph para = document.createParagraph();
        XWPFRun run = para.createRun();
        run.setText("hide words in table example");
        XWPFTable table = document.createTable();
        XWPFTableRow tableRowOne = table.getRow(0);
        tableRowOne.getCell(0).setText("col one, row one");
        tableRowOne.addNewTableCell().setText("col two, row one");
        XWPFTableCell xwpfTableCell = tableRowOne.addNewTableCell();
        CTTc ctTc = xwpfTableCell.getCTTc();
        CTP ctP = (ctTc.sizeOfPArray() == 0) ? ctTc.addNewP() : ctTc.getPArray(0);
        XWPFParagraph par = new XWPFParagraph(ctP, xwpfTableCell);
        XWPFRun run1 = par.createRun();
        run1.setText("hide");
        XWPFTableRow tableRowTwo = table.createRow();
        tableRowTwo.getCell(0).setText("col one, row two");
        tableRowTwo.getCell(1).setText("col two, row two");
        tableRowTwo.getCell(2).setText("col three, row two");
        XWPFTableRow tableRowThree = table.createRow();
        tableRowThree.getCell(0).setText("col one, row three");
        tableRowThree.getCell(1).setText("col two, row three");
        tableRowThree.getCell(2).setText("col three, row three");
        XWPFParagraph para2 = document.createParagraph();
        XWPFRun run2 = para2.createRun();
        run2.setText("Bye");
        document.write(out);
        out.close();
        System.out.println("finish");
    }
}
