
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Mattia Checchetto
 */
public class NewMain {
    private static final String NAME = "C:/Users/Mattia Checchetto/Documents/NetGitHub/excelmaven/src/main/java/AlcoholTAWEB.xlsx";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        LetturaConfigurazione  lc = new LetturaConfigurazione();
        
        lc.leggiFileConfig();
        try{
            FileInputStream file = new FileInputStream(new File(NAME));
            Workbook workbook = new XSSFWorkbook(file);
            DataFormatter dataFormatter = new DataFormatter();
            Iterator<Sheet> sheets = workbook.sheetIterator();
            while(sheets.hasNext()) {
                    Sheet sh = sheets.next();
                    System.out.println("Sheet name is "+sh.getSheetName());
                    System.out.println("---------");
                    Iterator<Row> iterator = sh.iterator();
                    while(iterator.hasNext()) {
                            Row row = iterator.next();
                            Iterator<Cell> cellIterator = row.iterator();
                            while (cellIterator.hasNext()) {
                                    Cell cell = cellIterator.next();
                                    String cellValue = dataFormatter.formatCellValue(cell);
                                    //if(cell.getCellType() == CellType.STRING) {
                                    //	
                                    //}
                                    System.out.print(cellValue+"\t");
                            }
                            System.out.println();
                    }
            }
            workbook.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
