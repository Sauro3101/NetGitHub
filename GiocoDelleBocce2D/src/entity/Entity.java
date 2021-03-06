/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.UtilityTool;

/**
 *
 * @author Mattia Checchetto
 */
public class Entity {
    
    GamePanel gp;
    public int worldX, worldY;
    public int speed;
    public String name = "";
    public String direction;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    public int actionLockerCounter = 0;
    String dialogues[] = new String[20];
    int dialogueIndex = 0;
    public int water;
    public int milk;
    public int weed;
    public int corn;
    public int seed;
    public int money;
    public long cont = 0;
    
    public Entity(GamePanel gp) {
        this.gp = gp;
    }
    
    public void setAction(){}
    public void chooseDialogue(){}
    public void speak(int i){
        
        if(dialogues[i] == null){
            i = 0;
        }
        gp.ui.currentDialogue = dialogues[i];
        
        switch(gp.player.direction){
            case "up":
                direction = "down";
                break;
            case "down":
                direction = "up";
                break;
            case "left":
                direction = "right";
                break;
            case "right":
                direction = "left";
                break;
        }
    
    }
    public void update(){
        
        setAction();
        
        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false);
        gp.cChecker.checkPlayer(this);
        
        // Check collision
        if(!collisionOn){
            switch(direction){
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
            }
        }

        // Change image for walk
        spriteCounter++;
        if(spriteCounter > 12){
            if(spriteNum == 1){
                spriteNum = 2;
            }else if(spriteNum == 2){
                spriteNum = 1;
            }
            spriteCounter = 0;
        }

    }

    public void draw(Graphics2D g2) {
        
        BufferedImage image = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && worldX - gp.tileSize < gp.player.worldX + gp.player.screenX && worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){

            switch(direction){
            case "up":
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }
                break;
            }
            
            double oneScale = (double) gp.tileSize/(gp.FPS*20);
            double milkBarValue = oneScale*cont;
            
            if(name.equals("cow")){
                if(water > 0 && corn > 0){
                    g2.setColor(new Color(35, 35, 35));
                    g2.fillRect(screenX-1, screenY-16, gp.tileSize+2, 12);
                    g2.setColor(new Color(128, 255, 255));
                    g2.fillRect(screenX, screenY-15, (int) milkBarValue, 10);
                }
            }
            
            g2.drawImage(image, screenX, screenY,  gp.tileSize, gp.tileSize, null);
            

        }
    }
    
    public BufferedImage setup(String imagePath){
        
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        
        try{
            
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
            image = uTool.scaleimage(image, gp.tileSize, gp.tileSize);
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
        return image;
        
    }
    
}