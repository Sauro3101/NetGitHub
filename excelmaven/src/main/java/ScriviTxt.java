
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author matti
 */
public class ScriviTxt {
    
    public void scrivi() throws IOException{
        
        String path = "./src/main/java/scrittura.txt";
        
        try{
            
            File file = new File(path);
            
            if (file.exists())
            System.out.println("Il file " + path + " esiste");
            else if (file.createNewFile())
            System.out.println("Il file " + path + " è stato creato");
            
            FileWriter w = new FileWriter(path);
            

            BufferedWriter b = new BufferedWriter (w);
            

            b.flush();

            w.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
