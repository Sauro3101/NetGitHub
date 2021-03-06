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
    public String playerColor = "red";
    public int objectCollidedIndex = 999;
    int cont = 0;

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
        
        // Inizialize water and money
        water = 3;
        corn = 3;
        money = 0;
        seed = 3;
        weed = 0;
    }
    
    public void getPlayerImage(){
        
        up1 = setup("/res/player/" + playerColor + "-up-run-1");
        up2 = setup("/res/player/" + playerColor + "-up-run-2");
        down1 = setup("/res/player/" + playerColor + "-down-run-1");
        down2 = setup("/res/player/" + playerColor + "-down-run-2");
        left1 = setup("/res/player/" + playerColor + "-left-run-1");
        left2 = setup("/res/player/" + playerColor + "-left-run-2");
        right1 = setup("/res/player/" + playerColor + "-right-run-1");
        right2 = setup("/res/player/" + playerColor + "-right-run-2");
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
            gp.ui.commandNum = 0;
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);
            
            // Check NPC collision
            int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
            interactNPC(npcIndex);
            
            // Check event
            gp.eventH.checkEvent();
            
            gp.keyH.enterPressed = false;
            
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
        
        objectCollidedIndex = i;
        
        if(i != 999){
            
            String objectName = gp.obj[i].name;
            
            switch(objectName){
                case "Chest":
                    if(gp.keyH.enterPressed){
                        gp.gameState = gp.chestState;
                    }
                    break;
                case "field":
                    //System.out.println("field collision");
                    if(gp.keyH.enterPressed){
                        gp.gameState = gp.cornState;
                    }
                    break;
                case "corn4":
                    //System.out.println("corn collision");
                    if(gp.keyH.enterPressed){
                        gp.gameState = gp.cornState;
                    }
                    break;
                case "shop":
                    System.out.println("shop collision");
                    if(gp.keyH.enterPressed){
                        gp.gameState = gp.shopState;
                    }
            }
        }
        
    }
    
    public void interactNPC(int i){
        
        cont++;
        if(i != 999){
            //System.out.println("NPC hitten");
            if(gp.keyH.enterPressed){
                gp.gameState = gp.dialogueState;
                gp.npc[i].chooseDialogue();
            }
            if(gp.keyH.gPressed && cont > 10){
                cont = 0;
                if(gp.npc[i].water == 0 && gp.player.water > 0){
                    gp.ui.addMessage("You water the " + gp.npc[i].name + "!");
                    gp.keyH.gPressed = false;
                    gp.npc[i].water++;
                    gp.player.water--;
                }else
                gp.ui.addMessage("You can't water the " + gp.npc[i].name + "!");
            }
            if(gp.keyH.fPressed && cont > 10){
                cont = 0;
                if(gp.npc[i].corn == 0 && gp.player.corn > 0){
                    gp.ui.addMessage("You feed the " + gp.npc[i].name + "!");
                    gp.keyH.fPressed = false;
                    gp.npc[i].corn++;
                    gp.player.corn--;
                }else
                gp.ui.addMessage("You can't feed the " + gp.npc[i].name + "!");
            }
            if(gp.keyH.mPressed && cont > 10){
                cont = 0;
                if(gp.npc[i].milk > 0){
                    gp.ui.addMessage("You pick 1 milk!");
                    gp.npc[i].milk -= 1;
                    gp.player.milk += 1;
                }else
                gp.ui.addMessage("Milk isn't ready!");
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
        
        g2.drawImage(image, screenX, screenY, null);
        
    }
}
