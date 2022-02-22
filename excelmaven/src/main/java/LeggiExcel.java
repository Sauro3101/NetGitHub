
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author matti
 */
public class LeggiExcel {
    
    public void leggiE(){
        try{
            
            FileInputStream file = new FileInputStream(new File("./AlcoholTAWEB.xlsx"));
            Workbook workbook = new XSSFWorkbook(file);
            
            
            BufferedReader reader = new BufferedReader(new FileReader("./src/main/java/Config.txt"));
            
            
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
                    
                    String record = "";
                    
                    while (cellIterator.hasNext()) {
                        
                        Cell cell = cellIterator.next();
                        String cellValue = null;
                        
                        String output = "";
                        
                        if(cell.getCellType() == CellType.BLANK){
                            
                            //Leggo lunghezza del campo del txt dal file di config e concateno tanti " " quanti riportato da quel numero.
                            int lunghezzaLetta = 5;
                            for(int i = 0; i <= lunghezzaLetta; i++){
                                output.concat(" ");
                            }
                            
                        }else{
                            
                            cellValue = dataFormatter.formatCellValue(cell);
                            int lunghezzaLetta = 5;
                            for(int i = 0; i <= (lunghezzaLetta - cellValue.length()); i++){
                                output.concat(" ");
                            }
                            output.concat(cellValue);
                        }
                        System.out.print(cellValue+"\t");
                        
                        record.concat(output);
                        
                    }
                    
                    ScriviTxt scrivi = new ScriviTxt();
                    
                    scrivi.scrivi(record);
                    
                    System.out.println();
                    
                }
                
            }
            
            workbook.close();
            
        }catch(Exception e){
            
            e.printStackTrace();
            
        }
    }
}

/*

Leggo dove trovo il dato in excel da mettere in quella posizione del txt e leggo cosa contiene corrispondente a quella posizione

Leggo la lunghezza del campo da compilare e completo il campo con " " o "0"

Concateno tutto il record e stampo sulla riga del file txt

*/
