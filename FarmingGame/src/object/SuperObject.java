/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.awt.Color;
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
    public int cont = 0;
    double oneScale = 0;
    double growBarValue = 0;
    UtilityTool uTool = new UtilityTool();
    
    public void draw(Graphics2D g2, GamePanel gp){
        
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && worldX - gp.tileSize < gp.player.worldX + gp.player.screenX && worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){

            if(name.equalsIgnoreCase("corn1")){
                g2.drawImage(image2, screenX, screenY,  gp.tileSize, gp.tileSize, null);
                cont += 1;
                drawGrowBar(g2, gp);
                if(cont >= gp.FPS*10 && cont < gp.FPS*20){
                    name = "corn2";
                }
                
            }else if(name.equalsIgnoreCase("corn2")){
                g2.drawImage(image3, screenX, screenY,  gp.tileSize, gp.tileSize, null);
                cont += 1;
                drawGrowBar(g2, gp);
                if(cont >= gp.FPS*20 && cont < gp.FPS*30){
                    name = "corn3";
                }
            }else if(name.equalsIgnoreCase("corn3")){
                g2.drawImage(image4, screenX, screenY,  gp.tileSize, gp.tileSize, null);
                cont += 1;
                drawGrowBar(g2, gp);
                if(cont >= gp.FPS*30){
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
    
    public void drawGrowBar(Graphics2D g2, GamePanel gp){
        
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        
        oneScale = (double) gp.tileSize/(gp.FPS*30);
        growBarValue = oneScale*cont;
        g2.setColor(new Color(35, 35, 35));
        g2.fillRect(screenX-1, screenY+(gp.tileSize/2)-1, gp.tileSize+2, 12);
        g2.setColor(new Color(0, 255, 64));
        g2.fillRect(screenX, screenY+(gp.tileSize/2), (int) growBarValue, 10);
        
    }
    
}
