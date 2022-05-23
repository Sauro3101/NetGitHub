/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.OBJ_Items;
import object.OBJ_Key;
import object.SuperObject;

/**
 *
 * @author Mattia Checchetto
 */
public class UI {
    
    GamePanel gp;
    Graphics2D g2;
    Font maruMonica, purisaB;
    BufferedImage coin, water, milk, corn, seed;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public String currentDialogue = "";
    public int commandNum = 0;
    public int titleScreenState = 0;
    

    public UI(GamePanel gp) {
        this.gp = gp;
        
        try {
            InputStream is = getClass().getResourceAsStream("/res/font/x12y16pxMaruMonica.ttf");
            maruMonica = Font.createFont(Font.TRUETYPE_FONT, is);
            is = getClass().getResourceAsStream("/res/font/Purisa Bold.ttf");
            purisaB = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        // CREATE HUD OBJECT
        SuperObject items = new OBJ_Items(gp);
        coin = items.image;
        water = items.image2;
        milk = items.image3;
        corn = items.image4;
        seed = items.image5;
        
    }
    
    public void showMessage(String text){
        
        message = text;
        messageOn = true;
        
    }
    
    public void draw(Graphics2D g2){
        
        this.g2 = g2;
        g2.setFont(maruMonica);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setColor(Color.white);
        
        // TITLE STATE
        if(gp.gameState == gp.titleState){
             drawTitleScreen();
        }
        // PLAY STATE
        if(gp.gameState == gp.playState){
            drawPlayerMoney();
        }
        // PAUSE STATE
        if(gp.gameState == gp.pauseState){
            drawPlayerMoney();
            drawPauseScreen();
        }
        // DIALOGUE STATE
        if(gp.gameState == gp.dialogueState){
            drawPlayerMoney();
            drawDialogueScreen();
        }
        // SHOP STATE
        if(gp.gameState == gp.shopState){
            drawShopScreen();
            drawPlayerMoney();
        }
        // CHEST STATE
        if(gp.gameState == gp.chestState){
            drawChestScreen();
        }
        
        
    }
    
    public void drawPlayerMoney(){
        
        int x = gp.tileSize/2;
        int y = gp.tileSize/2;
        
        // Draw current money
        g2.setFont(maruMonica);
        g2.setColor(Color.white);
        g2.drawImage(coin, x, y, null);
        g2.drawString("$", 74, 65);
        
    }
    
    public void drawTitleScreen(){
        
        if(titleScreenState == 0){
        
            g2.setColor(new Color(20, 150, 50));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

            // TITLE NAME
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
            String text = "Farming Game";
            int x = getCenterX(text);
            int y = gp.tileSize*3;

            // SHADOW
            g2.setColor(Color.black);
            g2.drawString(text, x+5, y+5);

            // MAIN TEXT
            g2.setColor(Color.white);
            g2.drawString(text, x, y);

            // PLAYER IMAGE
            x = gp.screenWidth/2 - (gp.tileSize*2)/2;
            y += gp.tileSize*2;
            g2.drawImage(gp.player.down1, x, y, gp.tileSize*2, gp.tileSize*2, null);

            // MENU
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));

            text = "NEW GAME";
            x = getCenterX(text);
            y += gp.tileSize*3.5;
            g2.drawString(text, x, y);
            if(commandNum == 0){
                g2.drawString(">", x-gp.tileSize, y);
            }

            text = "LOAD GAME";
            x = getCenterX(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 1){
                g2.drawString(">", x-gp.tileSize, y);
            }

            text = "QUIT";
            x = getCenterX(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 2){
                g2.drawString(">", x-gp.tileSize, y);
            }
        }else if(titleScreenState == 1){
            
            // CLASS SELECTION SCREEN
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(42F));
            
            String text = "Select your player color!";
            int x = getCenterX(text);
            int y = gp.tileSize*3;
            g2.drawString(text, x, y);
            
            text = "Red";
            x = getCenterX(text);
            y += gp.tileSize*2;
            g2.drawString(text, x, y);
            if(commandNum == 0){
                g2.drawString(">", x-gp.tileSize, y);
            }
            
            text = "Blue";
            x = getCenterX(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 1){
                g2.drawString(">", x-gp.tileSize, y);
            }
            
            text = "Green";
            x = getCenterX(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 2){
                g2.drawString(">", x-gp.tileSize, y);
            }
            
            text = "Back";
            x = getCenterX(text);
            y += gp.tileSize*2;
            g2.drawString(text, x, y);
            if(commandNum == 3){
                g2.drawString(">", x-gp.tileSize, y);
            }
            
        }
    }
    
    public void drawPauseScreen(){
        
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
        String text = "PAUSED";
        int x = getCenterX(text);
        int y = gp.screenHeight/2;
        
        g2.drawString(text, x, y);
    }
    
    public void drawDialogueScreen(){
        
        // Window
        int x = gp.tileSize*2;
        int y = gp.tileSize/2;
        int width = gp.screenWidth - (gp.tileSize*4);
        int height = gp.tileSize*4;
        
        drawSubWindow(x, y, width, height);
        
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F));
        x += gp.tileSize;
        y += gp.tileSize;
        
        for(String line : currentDialogue.split("\n")){
            g2.drawString(line, x, y);
            y += 40;
        }
        
    }
    
    public void drawSubWindow(int x, int y, int width, int height){
        
        Color c = new Color(0, 0, 0, 210);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);
        
        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
        
    }
    
    public void drawChestScreen(){
        
        // Window
        int x = gp.tileSize*2;
        int y = gp.screenHeight/2 - gp.tileSize*3;
        int width = gp.screenWidth - (gp.tileSize*4);
        int height = gp.tileSize*6;
        
        drawItemWindow(x, y, width, height);
        
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F));
        x += gp.tileSize*3;
        y += gp.tileSize*1.3;
        g2.drawString("Water: ", x, y);
        g2.drawImage(water, x+gp.tileSize*5, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        if(commandNum == 0){
            g2.drawString("<", x+gp.tileSize*7, y);
        }
        y += 60;
        g2.drawString("Milk: ", x, y);
        g2.drawImage(milk, x+gp.tileSize*5, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        if(commandNum == 1){
            g2.drawString("<", x+gp.tileSize*7, y);
        }
        y += 60;
        g2.drawString("Seed: ", x, y);
        g2.drawImage(seed, x+gp.tileSize*5, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        if(commandNum == 2){
            g2.drawString("<", x+gp.tileSize*7, y);
        }
        y += 60;
        g2.drawString("Corn: ", x, y);
        g2.drawImage(corn, x+gp.tileSize*5, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        if(commandNum == 3){
            g2.drawString("<", x+gp.tileSize*7, y);
        }
        
        
    }
    
    public void drawShopScreen(){
        
        // Window
        int x = gp.tileSize*2;
        int y = gp.screenHeight/2 - gp.tileSize*3;
        int width = gp.screenWidth - (gp.tileSize*4);
        int height = gp.tileSize*8;
        
        drawItemWindow(x, y, width, height);
        
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F));
        x += gp.tileSize*1.5;
        y += gp.tileSize*1.6;
        g2.drawString("Prices: ", x, y);
        x += 40;
        y += 60;
        g2.drawString("Water:", x, y);
        g2.drawString(" " + gp.waterPrice, x+gp.tileSize*2, y);
        g2.drawImage(coin, x+gp.tileSize*3, y-gp.tileSize+10+(gp.tileSize/4), gp.tileSize/2, gp.tileSize/2, null);
        g2.drawImage(water, x+gp.tileSize*5, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        if(commandNum == 0){
            g2.drawString("<", x+gp.tileSize*7, y);
        }
        y += 60;
        g2.drawString("Milk:", x, y);
        g2.drawString(" " + gp.milkPrice, x+gp.tileSize*2, y);
        g2.drawImage(coin, x+gp.tileSize*3, y-gp.tileSize+10+(gp.tileSize/3), gp.tileSize/2, gp.tileSize/2, null);
        g2.drawImage(milk, x+gp.tileSize*5, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        if(commandNum == 1){
            g2.drawString("<", x+gp.tileSize*7, y);
        }
        y += 60;
        g2.drawString("Seed:", x, y);
        g2.drawString(" " + gp.seedPrice, x+gp.tileSize*2, y);
        g2.drawImage(coin, x+gp.tileSize*3, y-gp.tileSize+10+(gp.tileSize/2), gp.tileSize/2, gp.tileSize/2, null);
        g2.drawImage(seed, x+gp.tileSize*5, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        if(commandNum == 2){
            g2.drawString("<", x+gp.tileSize*7, y);
        }
        y += 60;
        g2.drawString("Corn:", x, y);
        g2.drawString(" " + gp.cornPrice, x+gp.tileSize*2, y);
        g2.drawImage(coin, x+gp.tileSize*3, y-gp.tileSize+10+(gp.tileSize/2), gp.tileSize/2, gp.tileSize/2, null);
        g2.drawImage(corn, x+gp.tileSize*5, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        if(commandNum == 3){
            g2.drawString("<", x+gp.tileSize*7, y);
        }
        
    }
    
    public void drawItemWindow(int x, int y, int width, int height){
        
        Color c = new Color(0, 0, 0, 210);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);
        
        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
        
    }
    
    public int getCenterX(String text){
        
        int lenght = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - lenght/2;
        return x;
        
    }
}
