
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.text.ParseException;
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
            
            FileInputStream file = new FileInputStream(new File("./src/main/java/AlcoholTAWEB.xlsx"));
            Workbook workbook = new XSSFWorkbook(file);
            
            
            BufferedReader reader = new BufferedReader(new FileReader("./src/main/java/Config.txt"));
            reader.readLine();
            
            DataFormatter dataFormatter = new DataFormatter();
            Iterator<Sheet> sheets = workbook.sheetIterator();
            
            boolean aaa = true;
            
            while(aaa) {
                
                Sheet sh = sheets.next();
                System.out.println("Sheet name is "+sh.getSheetName());
                System.out.println("---------");
                Iterator<Row> iterator = sh.iterator();
                
                
                Row roww = iterator.next();
                
                while(iterator.hasNext()) {
                    
                    Row row = iterator.next();
                    Iterator<Cell> cellIterator = row.iterator();
                    
                    String record = "";
                    
                    while (cellIterator.hasNext()) {
                        
                        Cell cell = cellIterator.next();
                        String cellValue = null;
                        String rigaConfigLetta;
                        int lunghezzaLetta;
                        
                        String output = "";
                        do{
                            rigaConfigLetta = reader.readLine();
                        }while(rigaConfigLetta.isBlank() ||rigaConfigLetta.isEmpty() || rigaConfigLetta.contains("record") || rigaConfigLetta.contains("a") || rigaConfigLetta.contains("h"));
                        
                        
                        lunghezzaLetta = Integer.parseInt(rigaConfigLetta.substring((rigaConfigLetta.indexOf("§") + 1), (rigaConfigLetta.length())));
                        
                        
                        if(cell.getCellType() == CellType.BLANK){
                            
                            //Leggo lunghezza del campo del txt dal file di config e concateno tanti " " quanti riportato da quel numero.
                            
                            for(int i = 0; i <= lunghezzaLetta; i++){
                                output.concat(" ");
                            }
                            
                        }else{
                            
                            cellValue = dataFormatter.formatCellValue(cell);
                            
                            try{
                                Integer.parseInt(cellValue);
                                for(int i = 0; i <= (lunghezzaLetta - cellValue.length()); i++){
                                    output.concat(" ");
                                }
                            }catch(Exception e){
                                for(int i = 0; i <= (lunghezzaLetta - cellValue.length()); i++){
                                    output.concat(" ");
                                }
                            }
                            output.concat(cellValue);
                        }
                        
                        record.concat(output);
                        
                    }
                    
                    System.out.println(record);
                    
                    ScriviTxt scrivi = new ScriviTxt();
                    
                    scrivi.scrivi(record);
                    
                }
                aaa = false;
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
