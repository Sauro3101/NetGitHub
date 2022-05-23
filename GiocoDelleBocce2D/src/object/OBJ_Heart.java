/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import main.GamePanel;

/**
 *
 * @author Studente Turno B
 */
public class OBJ_Heart extends SuperObject{
    
    GamePanel gp;
    
    public OBJ_Heart(GamePanel gp){
        
        this.gp = gp;
        
        name = "Heart";
        
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/res/object/heart_full.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/res/object/heart_half.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/res/object/heart_void.png"));
            image = uTool.scaleimage(image, gp.tileSize, gp.tileSize);
            image2 = uTool.scaleimage(image2, gp.tileSize, gp.tileSize);
            image3 = uTool.scaleimage(image3, gp.tileSize, gp.tileSize);
            
        } catch (IOException ex) {
            Logger.getLogger(OBJ_Key.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
