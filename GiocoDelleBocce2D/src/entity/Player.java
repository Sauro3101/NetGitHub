/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;

/**
 *
 * @author Mattia Checchetto
 */
public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;
    public int hasKey = 0;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);
        
        solidArea = new Rectangle();
        solidArea.x = 8; //(gp.tileSize - 32) / 2;
        solidArea.y = 16; //gp.tileSize - 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultX = solidArea.y;
        solidArea.width = 16;
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
        
        try{
            
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/red-up-run-1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/red-up-run-2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/red-down-run-1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/red-down-run-2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/red-left-run-1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/red-left-run-2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/red-right-run-1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/red-right-run-2.png"));
            
        }catch(IOException e){
            System.out.println("errore");
            //e.printStackTrace();
        }
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
            
            //Check tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);
            
            //Check object collision
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);
            
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
            
            String objectName = gp.obj[i].name;
            
            switch(objectName){
                case "Key":
                    hasKey++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("You got a key!");
                    break;
                case "Door":
                    if(hasKey > 0){
                        gp.obj[i] = null;
                        hasKey--;
                        gp.ui.showMessage("You opened the door!");
                    }else{
                        gp.ui.showMessage("You need a key!");
                    }
                    break;
            }
        }
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
        
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        
    }
}
