
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author matti
 */
public class ScriviTxt {
    
    public void scrivi(String s) throws IOException{
        
        String path = "./src/main/java/Prova.txt";
        
        try{
            
            File file = new File(path);
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            br.write(s);

            br.close();
            fr.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
