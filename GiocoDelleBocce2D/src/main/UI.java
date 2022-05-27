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
import java.util.ArrayList;
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
    public ArrayList<String> message = new ArrayList<>();
    public ArrayList<Integer> messageCounter = new ArrayList<>();
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
    
    public void addMessage(String text){
        
        message.add(text);
        messageCounter.add(0);
        
    }
    
    public void draw(Graphics2D g2){
        
        this.g2 = g2;
        g2.setFont(maruMonica);
        g2.setColor(Color.white);
        
        // TITLE STATE
        if(gp.gameState == gp.titleState){
             drawTitleScreen();
        }
        // PLAY STATE
        if(gp.gameState == gp.playState){
            drawPlayerMoney();
            drawMessage();
        }
        // PAUSE STATE
        if(gp.gameState == gp.pauseState){
            drawPlayerMoney();
            drawPauseScreen();
        }
        // DIALOGUE STATE
        if(gp.gameState == gp.dialogueState){
            drawDialogueScreen();
            drawPlayerMoney();
            drawMessage();
        }
        // SHOP STATE
        if(gp.gameState == gp.shopState){
            drawShopScreen();
            drawPlayerMoney();
            drawMessage();
        }
        // CHEST STATE
        if(gp.gameState == gp.chestState){
            drawChestScreen();
            drawPlayerMoney();
            drawMessage();
        }
        // INVENTARY STATE
        if(gp.gameState == gp.inventaryState){
            drawInventaryScreen();
            drawPlayerMoney();
            drawMessage();
        }
        // CORN STATE
        if(gp.gameState == gp.cornState){
            drawCornScreen(gp.eventH.cornX, gp.eventH.cornY);
            drawPlayerMoney();
            drawMessage();
        }
    }
    
    public void drawMessage(){
        
        int messageX = gp.tileSize;
        int messageY = gp.tileSize*4;
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 32F));
        
        for(int i = 0; i < message.size(); i++){
            
            if(message.get(i) != null){
                g2.setColor(Color.white);
                g2.drawString(message.get(i), messageX, messageY);
                
                int counter = messageCounter.get(i) + 1;
                messageCounter.set(i, counter);
                messageY += 50;
                if(messageCounter.get(i) > 180){
                    message.remove(i);
                    messageCounter.remove(i);
                }
            }
            
        }
    }
    
    public void drawCornScreen(int x, int y){
        
        x = x;
        y = y;
        
        if(gp.obj[gp.player.objectCollidedIndex].name.equalsIgnoreCase("field")){
            if(gp.player.seed > 0){
                gp.obj[gp.player.objectCollidedIndex].name = "corn1";
                gp.obj[gp.player.objectCollidedIndex].startGrowing();
                gp.player.seed -= 1;
            }
        }else if(gp.obj[gp.player.objectCollidedIndex].name.equalsIgnoreCase("corn4")){
            gp.obj[gp.player.objectCollidedIndex].name = "field";
            gp.player.corn += 1;
        }
        
        gp.gameState = gp.playState;
        
    }
    
    public void drawPlayerMoney(){
        
        int x = gp.tileSize/2;
        int y = gp.tileSize/2;
        
        // Draw current money
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F));
        g2.drawString(gp.player.money + "$", 80, 59);
        g2.drawImage(coin, x, y, null);
        
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
            y += gp.tileSize;
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

            text = "INSTRUCTIONS";
            x = getCenterX(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 2){
                g2.drawString(">", x-gp.tileSize, y);
            }
            
            text = "QUIT";
            x = getCenterX(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 3){
                g2.drawString(">", x-gp.tileSize, y);
            }
            
        }else if(titleScreenState == 1){
            
            g2.setColor(new Color(255, 128, 0));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

            // TITLE NAME
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
            String text = "Savings";
            int x = getCenterX(text);
            int y = gp.tileSize*2;

            // SHADOW
            g2.setColor(Color.black);
            g2.drawString(text, x+5, y+5);

            // MAIN TEXT
            g2.setColor(Color.white);
            g2.drawString(text, x, y);
            
            // Game name label
            text = "Game name:";
            y += gp.tileSize;
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40F));
            g2.drawString(text, x-gp.tileSize*2, y);
            g2.setStroke(new BasicStroke(5));
            g2.drawRect(gp.screenWidth/2-gp.tileSize*6, y+20, gp.tileSize*12, gp.tileSize*2);
            
            text = gp.saveName;
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 50F));
            x = getCenterX(text);
            y += gp.tileSize*2;
            g2.drawString(text, x, y);
            
            text = "PLAY";
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40F));
            x = getCenterX(text);
            y += gp.tileSize*4;
            g2.drawString(text, x, y);
            if(commandNum == 0){
                g2.drawString(">", x-gp.tileSize, y);
            }
            
            text = "BACK";
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40F));
            x = getCenterX(text);
            y += gp.tileSize*2;
            g2.drawString(text, x, y);
            if(commandNum == 1){
                g2.drawString(">", x-gp.tileSize, y);
            }
            
        }else if(titleScreenState == 2){
            
            g2.setColor(new Color(20, 150, 50));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

            // TITLE NAME
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
            String text = "INSTRUCTIONS";
            int x = getCenterX(text);
            int y = gp.tileSize*2;
            

            // SHADOW
            g2.setColor(Color.black);
            g2.drawString(text, x+5, y+5);

            // MAIN TEXT
            g2.setColor(Color.white);
            g2.drawString(text, x, y);

            // MENU
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F));

            text = "W, A, S, D or direction arrow for moving player";
            x = getCenterX(text);
            y += gp.tileSize*1.7;
            g2.drawString(text, x, y);

            text = "I to open inventory";
            x = getCenterX(text);
            y += gp.tileSize*0.7;
            g2.drawString(text, x, y);

            text = "ENTER next to cow for dialogue";
            x = getCenterX(text);
            y += gp.tileSize*0.7;
            g2.drawString(text, x, y);

            text = "ENTER next to empty field for plant seed";
            x = getCenterX(text);
            y += gp.tileSize*0.7;
            g2.drawString(text, x, y);

            text = "ENTER next to grown corn for pick up";
            x = getCenterX(text);
            y += gp.tileSize*0.7;
            g2.drawString(text, x, y);

            text = "F next to cow for feed cow";
            x = getCenterX(text);
            y += gp.tileSize*0.7;
            g2.drawString(text, x, y);

            text = "G next to cow for water cow";
            x = getCenterX(text);
            y += gp.tileSize*0.7;
            g2.drawString(text, x, y);

            text = "M next to cow for pick up milk";
            x = getCenterX(text);
            y += gp.tileSize*0.7;
            g2.drawString(text, x, y);

            text = "P to pause";
            x = getCenterX(text);
            y += gp.tileSize*0.7;
            g2.drawString(text, x, y);

            text = "ENTER or ESC to exit dialogue and inventory";
            x = getCenterX(text);
            y += gp.tileSize*0.7;
            g2.drawString(text, x, y);
            
            text = "QUIT";
            x = getCenterX(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 0){
                g2.drawString(">", x-gp.tileSize, y);
            }
            
        }else if(titleScreenState == 3){
        
            g2.setColor(new Color(0, 128, 255));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

            // TITLE NAME
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
            String text = "Savings";
            int x = getCenterX(text);
            int y = gp.tileSize*2;

            // SHADOW
            g2.setColor(Color.black);
            g2.drawString(text, x+5, y+5);

            // MAIN TEXT
            g2.setColor(Color.white);
            g2.drawString(text, x, y);
            
            /*
            // PLAYER IMAGE
            x = gp.screenWidth/2 - (gp.tileSize*2)/2;
            y += gp.tileSize;
            g2.drawImage(gp.player.down1, x, y, gp.tileSize*2, gp.tileSize*2, null);
            */

            // MENU
            y += gp.tileSize*0.5;
            
            int totalHeight = 0;

            for(int i = 0; i < gp.maxSaves; i++){
                text = "SLOT " + (i+1);
                g2.setColor(Color.white);
                g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
                x = (int) (getCenterX(text)-(gp.tileSize*1.3));
                y += gp.tileSize*0.4 + getHeight(text);
                totalHeight = y - getHeight(text);
                g2.drawString(text, x, y);
                if(commandNum == i){
                    g2.setColor(new Color(0, 0, 0, 170));
                    g2.drawString("GO!", x+gp.tileSize*3, y+15);
                }
                g2.setFont(g2.getFont().deriveFont(Font.BOLD, 28F));
                g2.setColor(new Color(255, 255, 255, 150));
                
                if(i < gp.saves.size()){
                    GameData save = (GameData) gp.saves.get(i);
                    text = save.name;
                }else{
                    text = "NULL";
                }
                
                y += getHeight(text);
                totalHeight = y - totalHeight + 5;
                g2.drawString(text, x, y);
                g2.setColor(Color.white);
                g2.setStroke(new BasicStroke(5));
                g2.drawRect(x-5, (y-totalHeight), gp.tileSize*5, (totalHeight+5));
            }
            
            text = "BACK";
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F));
            x = getCenterX(text);
            y += gp.tileSize*1.5;
            g2.drawString(text, x, y);
            if(commandNum == 4){
                g2.drawString(">", x-gp.tileSize, y);
            }
            
        }
        
    }
    
    public void drawPauseScreen(){
        
        // Window
        int x = gp.tileSize*2;
        int y = gp.screenHeight/2 - gp.tileSize*3;
        int width = gp.screenWidth - (gp.tileSize*4);
        int height = gp.tileSize*6;
        
        drawItemWindow(x, y, width, height, false);
        
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 60F));
        String text = "PAUSED";
        x = getCenterX(text);
        y = gp.screenHeight/2 - gp.tileSize*1;
        g2.drawString(text, x, y);
        
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 30F));
        
        text = "RESUME";
        x = getCenterX(text);
        y = gp.screenHeight/2 + gp.tileSize*1;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">", x-gp.tileSize, y);
        }
        
        text = "SAVE AND EXIT";
        x = getCenterX(text);
        y += gp.tileSize*1;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">", x-gp.tileSize, y);
        }
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
        int x = gp.tileSize;
        int y = gp.screenHeight/2 - gp.tileSize*6;
        int width = gp.screenWidth - (gp.tileSize*7);
        int height = gp.tileSize*8;
        
        Color c = new Color(0, 0, 0, 210);
        g2.setColor(c);
        g2.fillRoundRect(x, y+gp.tileSize*2, width, height, 35, 35);
        g2.fillRoundRect(x+gp.tileSize+width, y+gp.tileSize*2, gp.tileSize*4, height, 35, 35);

        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+gp.tileSize*2+5, width-10, height-10, 25, 25);
        g2.drawRoundRect(x+gp.tileSize+width+5, y+gp.tileSize*2+5, gp.tileSize*4-10, height-10, 25, 25);

        
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F));
        x += gp.tileSize*0.5;
        y += gp.tileSize*3.6;
        g2.drawString("Prices: ", x, y);
        g2.drawString("Invent: ", x+gp.tileSize+width, y);
        x += 40;
        y += 60;
        g2.drawString("Water:", x, y);
        g2.drawString("+ " + gp.waterPrice, x+gp.tileSize*2, y);
        g2.drawImage(coin, x+gp.tileSize*3, y-gp.tileSize+10+(gp.tileSize/4), gp.tileSize/2, gp.tileSize/2, null);
        g2.drawImage(water, x+gp.tileSize*5, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        if(commandNum == 0){
            g2.drawString("<", x+gp.tileSize*7, y);
        }
        g2.drawString("x" + gp.player.water, x+gp.tileSize+width, y);
        g2.drawImage(water, x+gp.tileSize*2+width, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        
        y += 60;
        g2.drawString("Milk:", x, y);
        g2.drawString("+ " + gp.milkPrice, x+gp.tileSize*2, y);
        g2.drawImage(coin, x+gp.tileSize*3, y-gp.tileSize+10+(gp.tileSize/3), gp.tileSize/2, gp.tileSize/2, null);
        g2.drawImage(milk, x+gp.tileSize*5, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        if(commandNum == 1){
            g2.drawString("<", x+gp.tileSize*7, y);
        }
        g2.drawString("x" + gp.player.milk, x+gp.tileSize+width, y);
        g2.drawImage(milk, x+gp.tileSize*2+width, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        
        y += 60;
        g2.drawString("Seed:", x, y);
        g2.drawString("+ " + gp.seedPrice, x+gp.tileSize*2, y);
        g2.drawImage(coin, x+gp.tileSize*3, y-gp.tileSize+10+(gp.tileSize/2), gp.tileSize/2, gp.tileSize/2, null);
        g2.drawImage(seed, x+gp.tileSize*5, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        if(commandNum == 2){
            g2.drawString("<", x+gp.tileSize*7, y);
        }
        g2.drawString("x" + gp.player.seed, x+gp.tileSize+width, y);
        g2.drawImage(seed, x+gp.tileSize*2+width, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        
        y += 60;
        g2.drawString("Corn:", x, y);
        g2.drawString("+ " + gp.cornPrice, x+gp.tileSize*2, y);
        g2.drawImage(coin, x+gp.tileSize*3, y-gp.tileSize+10+(gp.tileSize/2), gp.tileSize/2, gp.tileSize/2, null);
        g2.drawImage(corn, x+gp.tileSize*5, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        if(commandNum == 3){
            g2.drawString("<", x+gp.tileSize*7, y);
        }
        g2.drawString("x" + gp.player.corn, x+gp.tileSize+width, y);
        g2.drawImage(corn, x+gp.tileSize*2+width, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        
    }
    
    public void drawInventaryScreen(){
        
        // Window
        int x = gp.tileSize*2;
        int y = gp.screenHeight/2 - gp.tileSize*3;
        int width = gp.screenWidth - (gp.tileSize*4);
        int height = gp.tileSize*6;
        
        drawItemWindow(x, y, width, height, false);
        
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F));
        x += gp.tileSize*3;
        y += gp.tileSize*1.3;
        g2.drawString("Water: ", x, y);
        g2.drawImage(water, x+gp.tileSize*3, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        g2.drawString("x " + gp.player.water, x+gp.tileSize*5, y);
        /*if(commandNum == 0){
        g2.drawString("<", x+gp.tileSize*7, y);
        }*/
        y += 60;
        g2.drawString("Milk: ", x, y);
        g2.drawImage(milk, x+gp.tileSize*3, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        g2.drawString("x " + gp.player.milk, x+gp.tileSize*5, y);
        /*if(commandNum == 1){
        g2.drawString("<", x+gp.tileSize*7, y);
        }*/
        y += 60;
        g2.drawString("Seed: ", x, y);
        g2.drawImage(seed, x+gp.tileSize*3, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        g2.drawString("x " + gp.player.seed, x+gp.tileSize*5, y);
        /*if(commandNum == 2){
        g2.drawString("<", x+gp.tileSize*7, y);
        }*/
        y += 60;
        g2.drawString("Corn: ", x, y);
        g2.drawImage(corn, x+gp.tileSize*3, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        g2.drawString("x " + gp.player.corn, x+gp.tileSize*5, y);
        /*if(commandNum == 3){
        g2.drawString("<", x+gp.tileSize*7, y);
        }*/
        
        
    }
    
    public void drawShopScreen(){
        
        // Window
        int x = gp.tileSize;
        int y = gp.screenHeight/2 - gp.tileSize*6;
        int width = gp.screenWidth - (gp.tileSize*7);
        int height = gp.tileSize*8;
        
        Color c = new Color(0, 0, 0, 210);
        g2.setColor(c);
        g2.fillRoundRect(x, y+gp.tileSize*2, width, height, 35, 35);
        g2.fillRoundRect(x+gp.tileSize+width, y+gp.tileSize*2, gp.tileSize*4, height, 35, 35);

        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+gp.tileSize*2+5, width-10, height-10, 25, 25);
        g2.drawRoundRect(x+gp.tileSize+width+5, y+gp.tileSize*2+5, gp.tileSize*4-10, height-10, 25, 25);

        
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F));
        x += gp.tileSize*0.5;
        y += gp.tileSize*3.6;
        g2.drawString("Prices: ", x, y);
        g2.drawString("Invent: ", x+gp.tileSize+width, y);
        x += 40;
        y += 60;
        g2.drawString("Water:", x, y);
        g2.drawString(" " + gp.waterPrice, x+gp.tileSize*2, y);
        g2.drawImage(coin, x+gp.tileSize*3, y-gp.tileSize+10+(gp.tileSize/4), gp.tileSize/2, gp.tileSize/2, null);
        g2.drawImage(water, x+gp.tileSize*5, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        if(commandNum == 0){
            g2.drawString("<", x+gp.tileSize*7, y);
        }
        g2.drawString("x" + gp.player.water, x+gp.tileSize+width, y);
        g2.drawImage(water, x+gp.tileSize*2+width, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        
        y += 60;
        g2.drawString("Milk:", x, y);
        g2.drawString(" " + gp.milkPrice, x+gp.tileSize*2, y);
        g2.drawImage(coin, x+gp.tileSize*3, y-gp.tileSize+10+(gp.tileSize/3), gp.tileSize/2, gp.tileSize/2, null);
        g2.drawImage(milk, x+gp.tileSize*5, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        if(commandNum == 1){
            g2.drawString("<", x+gp.tileSize*7, y);
        }
        g2.drawString("x" + gp.player.milk, x+gp.tileSize+width, y);
        g2.drawImage(milk, x+gp.tileSize*2+width, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        
        y += 60;
        g2.drawString("Seed:", x, y);
        g2.drawString(" " + gp.seedPrice, x+gp.tileSize*2, y);
        g2.drawImage(coin, x+gp.tileSize*3, y-gp.tileSize+10+(gp.tileSize/2), gp.tileSize/2, gp.tileSize/2, null);
        g2.drawImage(seed, x+gp.tileSize*5, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        if(commandNum == 2){
            g2.drawString("<", x+gp.tileSize*7, y);
        }
        g2.drawString("x" + gp.player.seed, x+gp.tileSize+width, y);
        g2.drawImage(seed, x+gp.tileSize*2+width, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        
        y += 60;
        g2.drawString("Corn:", x, y);
        g2.drawString(" " + gp.cornPrice, x+gp.tileSize*2, y);
        g2.drawImage(coin, x+gp.tileSize*3, y-gp.tileSize+10+(gp.tileSize/2), gp.tileSize/2, gp.tileSize/2, null);
        g2.drawImage(corn, x+gp.tileSize*5, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        if(commandNum == 3){
            g2.drawString("<", x+gp.tileSize*7, y);
        }
        g2.drawString("x" + gp.player.corn, x+gp.tileSize+width, y);
        g2.drawImage(corn, x+gp.tileSize*2+width, y-gp.tileSize+10, gp.tileSize, gp.tileSize, null);
        
    }
    
    public void drawItemWindow(int x, int y, int width, int height, boolean inventItems){
        if(inventItems){

            Color c = new Color(0, 0, 0, 210);
            g2.setColor(c);
            g2.fillRoundRect(x, y+gp.tileSize*2, width, height, 35, 35);
            g2.fillRoundRect(x+gp.tileSize*2, y-gp.tileSize*2, width-gp.tileSize*2, gp.tileSize*3, 35, 35);

            c = new Color(255, 255, 255);
            g2.setColor(c);
            g2.setStroke(new BasicStroke(5));
            g2.drawRoundRect(x+5, y+gp.tileSize*2+5, width-10, height-10, 25, 25);
            g2.drawRoundRect(x+gp.tileSize*2+5, y-gp.tileSize*2+5, width-gp.tileSize*2-10, gp.tileSize*3-10, 25, 25);

        }else{
            Color c = new Color(0, 0, 0, 210);
            g2.setColor(c);
            g2.fillRoundRect(x, y, width, height, 35, 35);

            c = new Color(255, 255, 255);
            g2.setColor(c);
            g2.setStroke(new BasicStroke(5));
            g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
        }
        
    }
    
    public int getCenterX(String text){
        
        int lenght = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - lenght/2;
        return x;
        
    }
    
    public int getHeight(String text){

        return (int) g2.getFontMetrics().getStringBounds(text, g2).getHeight();
        
    }
}
