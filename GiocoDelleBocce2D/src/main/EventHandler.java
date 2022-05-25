/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Rectangle;

/**
 *
 * @author Mattia Checchetto
 */
public class EventHandler {
    
    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;
    int cornX, cornY;

    public EventHandler(GamePanel gp) {
        this.gp = gp;
        
        eventRect = new Rectangle();
        eventRect.x = 23;
        eventRect.y = 23;
        eventRect.width = 2;
        eventRect.height = 2;
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;
    }
    
    public void checkEvent(){
        
        if(hit(27, 16, "right")){
            enterCowFence(gp.dialogueState);
        }
        if(hit(29, 16, "left")){
            exitCowFence(gp.dialogueState);
        }
        if(hit(23, 12, "up")){
            pickWater();
        }
        /*
        if(hit(10, 30, "any")){
        enterShop(gp.shopState);
        }
        if(hit(11, 30, "any")){
        enterShop(gp.shopState);
        }
        if(hit(12, 30, "any")){
        enterShop(gp.shopState);
        }
        if(hit(10, 31, "any")){
        enterShop(gp.shopState);
        }
        if(hit(11, 31, "any")){
        enterShop(gp.shopState);
        }
        if(hit(12, 31, "any")){
        enterShop(gp.shopState);
        }
        if(hit(10, 32, "any")){
        enterShop(gp.shopState);
        }
        if(hit(11, 32, "any")){
        enterShop(gp.shopState);
        }
        if(hit(12, 32, "any")){
        enterShop(gp.shopState);
        }
        if(hit(10, 33, "any")){
        enterShop(gp.shopState);
        }
        if(hit(11, 33, "any")){
        enterShop(gp.shopState);
        }
        if(hit(12, 33, "any")){
        enterShop(gp.shopState);
        }
        */
        /*
        if(hit(38, 9, "left")){
        plantCorn(gp.cornState, 38, 9);
        }
        if(hit(37, 9, "right")){
        plantCorn(gp.cornState, 37, 9);
        }
        if(hit(38, 10, "left")){
        plantCorn(gp.cornState, 38, 10);
        }
        if(hit(37, 10, "right")){
        plantCorn(gp.cornState, 37, 10);
        }
        */
        
    }
    
    public boolean hit(int eventCol, int eventRow, String reqDirection){
        
        boolean hit = false;
        
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRect.x = eventCol*gp.tileSize + eventRect.x;
        eventRect.y = eventRow*gp.tileSize + eventRect.y;
        
        if(gp.player.solidArea.intersects(eventRect)){
            if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")){
                hit = true;
            }
        }
        
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect.x = eventRectDefaultX;
        eventRect.y = eventRectDefaultX;
        
        return hit;
    }
    
    /*
    public void plantCorn(int gameState, int x, int y){
    
    if(gp.keyH.enterPressed){
    gp.gameState = gameState;
    cornX = x;
    cornY = y;
    }
    
    }
    
    public void enterShop(int gameState){
    
    if(gp.keyH.enterPressed){
    gp.gameState = gameState;
    }
    
    }
    */
    
    public void enterCowFence(int gameState){
        
        if(gp.keyH.enterPressed){
            
            gp.gameState = gameState;
            gp.ui.currentDialogue = "You're in the cow fence!";
            gp.player.worldX = gp.tileSize*29;
            gp.player.worldY = gp.tileSize*16;
            
        }
    }
    
    public void exitCowFence(int gameState){
        
        if(gp.keyH.enterPressed){
            
            gp.gameState = gameState;
            gp.ui.currentDialogue = "You're out the cow fence!";
            gp.player.worldX = gp.tileSize*27;
            gp.player.worldY = gp.tileSize*16;
            
        }
    }
    
    public void pickWater(){
        
        if(gp.keyH.enterPressed){
            
            gp.ui.addMessage("You pick 1 water!");
            gp.player.water += 1;
        }
        
    }
    
}
