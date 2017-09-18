#Java POI read excel example
It's easy to use `Apache POI` read excel file. Let's say you have an excel file. The path of it is `D:\test.xlsx`.
The content is like following.

|name   |age|
|:---:  |:--|
|henry  | 28|
|justin | 27|
|charles| 30|

Before using POI we need import the jars. The content of pom file is here.
```xml
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>3.15</version>
</dependency>
```
The code of reading excel file.
```java
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
```
The output.
```
the sheet name:Sheet1
name:henry,age:28.0
name:justin,age:27.0
name:charles,age:30.0
```
EOF