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
        
        name = "Field";
        
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/res/object/field.png"));
        } catch (IOException ex) {
            Logger.getLogger(OBJ_Door.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        collision = true;
        
    }
    
}
