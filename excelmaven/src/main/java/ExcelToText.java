/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import java.io.IOException;

/**
 *
 * @author Mattia Checchetto
 */
public class ExcelToText {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        LetturaConfigurazione  lc = new LetturaConfigurazione();
        
        lc.leggiFileConfig();
    }
    
}
