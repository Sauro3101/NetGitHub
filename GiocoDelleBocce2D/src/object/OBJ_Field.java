/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Mattia Checchetto
 */
public class OBJ_Field  extends SuperObject{
    
    public OBJ_Field(){
        
        name = "field";
        
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/res/object/field.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/res/object/field_corn_1.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/res/object/field_corn_2.png"));
            image4 = ImageIO.read(getClass().getResourceAsStream("/res/object/field_corn_3.png"));
            image5 = ImageIO.read(getClass().getResourceAsStream("/res/object/field_corn_4.png"));
        } catch (IOException ex) {
            Logger.getLogger(OBJ_Door.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        collision = true;
        
    }
    
    @Override
    public void startGrowing(){
        
        name = "corn1";
     
        /*
        long start = System.nanoTime();
        long current;
        long mult = 1000000000;
        
        while(!name.equalsIgnoreCase("corn4")){
            current = System.nanoTime() - start;
            if(current <= 1*mult){
                name = "corn1";
                System.out.println(name);
            }
            if(current > 1*mult && current <= 2*mult){
                name = "corn2";
                System.out.println(name);
            }
            if(current > 2*mult && current <= 3*mult){
                name = "corn3";
                System.out.println(name);
            }
            if(current > 3*mult){
                name = "corn4";
                System.out.println(name);
            }
        }
        */

    }
    
}
