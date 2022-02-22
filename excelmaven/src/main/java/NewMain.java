
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
        
        //lc.leggiFileConfig();
        
        ScriviTxt t = new ScriviTxt();
        
        t.scrivi();
    }
    
}
