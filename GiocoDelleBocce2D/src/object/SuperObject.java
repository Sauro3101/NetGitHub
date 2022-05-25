/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import main.GamePanel;
import main.UtilityTool;

/**
 *
 * @author Mattia Checchetto
 */
public class SuperObject {
    public BufferedImage image, image2, image3, image4, image5;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    public long cont = 0;
    UtilityTool uTool = new UtilityTool();
    
    public void draw(Graphics2D g2, GamePanel gp){
        
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && worldX - gp.tileSize < gp.player.worldX + gp.player.screenX && worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){

            if(name.equalsIgnoreCase("corn1")){
                System.out.println("Cont: " + cont);
                g2.drawImage(image2, screenX, screenY,  gp.tileSize, gp.tileSize, null);
                cont += 1000000000/gp.FPS;
                if(cont >= (1000000000/gp.FPS)*300){
                    name = "corn2";
                    cont = 0;
                }
                
            }else if(name.equalsIgnoreCase("corn2")){
                System.out.println("Cont: " + cont);
                g2.drawImage(image3, screenX, screenY,  gp.tileSize, gp.tileSize, null);
                cont += 1000000000/gp.FPS;
                if(cont >= (1000000000/gp.FPS)*300){
                    name = "corn3";
                    cont = 0;
                }
            }else if(name.equalsIgnoreCase("corn3")){
                System.out.println("Cont: " + cont);
                g2.drawImage(image4, screenX, screenY,  gp.tileSize, gp.tileSize, null);
                cont += 1000000000/gp.FPS;
                if(cont >= (1000000000/gp.FPS)*300){
                    name = "corn4";
                    cont = 0;
                }
            }else if(name.equalsIgnoreCase("corn4")){
                g2.drawImage(image5, screenX, screenY,  gp.tileSize, gp.tileSize, null);
            }else{
                g2.drawImage(image, screenX, screenY,  gp.tileSize, gp.tileSize, null);
            }

        }
        
    }
    
    public void startGrowing(){}
    
}
