/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import main.GamePanel;
import main.KeyHandler;

/**
 *
 * @author Mattia Checchetto
 */
public class Player extends Entity {
    
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH) {
        
        super(gp);
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);
        
        solidArea = new Rectangle();
        solidArea.x = 8; //(gp.tileSize - 32) / 2;
        solidArea.y = 16; //gp.tileSize - 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultX = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;
        
        setDefaultValues();
        getPlayerImage();
        
    }
    
    public void setDefaultValues(){
        worldX = gp.tileSize * 24;
        worldY = gp.tileSize * 16;
        speed = 4;
        direction = "down";
    }
    
    public void getPlayerImage(){
        
        up1 = setup("/res/player/red-up-run-1");
        up2 = setup("/res/player/red-up-run-2");
        down1 = setup("/res/player/red-down-run-1");
        down2 = setup("/res/player/red-down-run-2");
        left1 = setup("/res/player/red-left-run-1");
        left2 = setup("/res/player/red-left-run-2");
        right1 = setup("/res/player/red-right-run-1");
        right2 = setup("/res/player/red-right-run-2");
    }
    
    
    public void update(){
        
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){

            if(keyH.upPressed){
                direction = "up";
            }else if(keyH.downPressed){
                direction = "down";
            }else if(keyH.leftPressed){
                direction = "left";
            }else if(keyH.rightPressed){
                direction = "right";
            }
            
            // Check tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);
            
            // Check object collision
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);
            
            // Check NPC collision
            int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
            interactNPC(npcIndex);
            
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
        
    }
    
    public void pickUpObject(int i){
        
        if(i != 999){
            
        }
        
    }
    
    public void interactNPC(int i){
        
        if(i != 999){
            //System.out.println("NPC hitten");
            if(gp.keyH.enterPressed){
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
            }
            
        }
        gp.keyH.enterPressed = false;
        
    }
    
    public void draw(Graphics2D g2){
        
        //g2.setColor(Color.white);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        
        BufferedImage image = null;
        
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
        
        g2.drawImage(image, screenX, screenY, null);
        
    }
}
