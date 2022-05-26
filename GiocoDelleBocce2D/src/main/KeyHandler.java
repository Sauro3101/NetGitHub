/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Mattia Checchetto
 */
public class KeyHandler implements KeyListener{

    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed = false, fPressed = false, gPressed = false, mPressed = false;
    
    // DEBUG
    public boolean checkDrawTime = false;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }
    
    
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        if(gp.gameState == gp.titleState){
            
            if(gp.ui.titleScreenState == 0){
            
                if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
                    gp.ui.commandNum--;
                    if(gp.ui.commandNum < 0){
                        gp.ui.commandNum = 3;
                    }
                    //System.out.println("menu su");
                }
                if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
                    gp.ui.commandNum++;
                    if(gp.ui.commandNum > 3){
                        gp.ui.commandNum = 0;
                    }
                    //System.out.println("menu giu");
                }
                if(code == KeyEvent.VK_ENTER){

                    if(gp.ui.commandNum == 0){
                        gp.ui.titleScreenState = 1;
                    }
                    if(gp.ui.commandNum == 1){
                        gp.ui.commandNum = 0;
                        gp.ui.titleScreenState = 3;
                    }
                    if(gp.ui.commandNum == 2){
                        // Add later saving and load
                        // VIEW INSTRUCTION SCREEN
                        gp.ui.commandNum = 0;
                        gp.ui.titleScreenState = 2;
                    }
                    if(gp.ui.commandNum == 3){
                        System.exit(0);
                        gp.gd.uploadData();
                        for(int i = 0; i < gp.saves.size(); i++){
                            GameData gd = (GameData) gp.saves.get(i);
                            if(gd.name.equalsIgnoreCase(gp.gd.name)){
                                gp.saves.set(i, gd);
                                gp.uTool.saveFile(gp);
                            }
                        }
                    }

                    //System.out.println("Select item");
                }
                
            }else if(gp.ui.titleScreenState == 1){
                
                /*
                if(code >= KeyEvent.VK_0 && code <= KeyEvent.VK_Z){
                    gp.saveName.concat(String.valueOf(code));
                }
                */
                
                System.out.println("nome: " + gp.saveName);
                
                if(code == KeyEvent.VK_Q){
                    gp.saveName = gp.saveName.concat("q");
                }
                if(code == KeyEvent.VK_W){
                    gp.saveName = gp.saveName.concat("w");
                }
                if(code == KeyEvent.VK_E){
                    gp.saveName = gp.saveName.concat("e");
                }
                if(code == KeyEvent.VK_R){
                    gp.saveName = gp.saveName.concat("r");
                }
                if(code == KeyEvent.VK_T){
                    gp.saveName = gp.saveName.concat("t");
                }
                if(code == KeyEvent.VK_Y){
                    gp.saveName = gp.saveName.concat("y");
                }
                if(code == KeyEvent.VK_U){
                    gp.saveName = gp.saveName.concat("u");
                }
                if(code == KeyEvent.VK_I){
                    gp.saveName = gp.saveName.concat("i");
                }
                if(code == KeyEvent.VK_O){
                    gp.saveName = gp.saveName.concat("o");
                }
                if(code == KeyEvent.VK_P){
                    gp.saveName = gp.saveName.concat("p");
                }
                if(code == KeyEvent.VK_A){
                    gp.saveName = gp.saveName.concat("a");
                }
                if(code == KeyEvent.VK_S){
                    gp.saveName = gp.saveName.concat("s");
                }
                if(code == KeyEvent.VK_D){
                    gp.saveName = gp.saveName.concat("d");
                }
                if(code == KeyEvent.VK_F){
                    gp.saveName = gp.saveName.concat("f");
                }
                if(code == KeyEvent.VK_G){
                    gp.saveName = gp.saveName.concat("g");
                }
                if(code == KeyEvent.VK_H){
                    gp.saveName = gp.saveName.concat("h");
                }
                if(code == KeyEvent.VK_J){
                    gp.saveName = gp.saveName.concat("j");
                }
                if(code == KeyEvent.VK_K){
                    gp.saveName = gp.saveName.concat("k");
                }
                if(code == KeyEvent.VK_L){
                    gp.saveName = gp.saveName.concat("l");
                }
                if(code == KeyEvent.VK_Z){
                    gp.saveName = gp.saveName.concat("z");
                }
                if(code == KeyEvent.VK_X){
                    gp.saveName = gp.saveName.concat("x");
                }
                if(code == KeyEvent.VK_C){
                    gp.saveName = gp.saveName.concat("c");
                }
                if(code == KeyEvent.VK_V){
                    gp.saveName = gp.saveName.concat("v");
                }
                if(code == KeyEvent.VK_B){
                    gp.saveName = gp.saveName.concat("b");
                }
                if(code == KeyEvent.VK_N){
                    gp.saveName = gp.saveName.concat("n");
                }
                if(code == KeyEvent.VK_M){
                    gp.saveName = gp.saveName.concat("m");
                }
                
                if(code == KeyEvent.VK_MINUS){
                    gp.saveName = gp.saveName.concat("-");
                }
                if(code == KeyEvent.VK_MINUS && code == KeyEvent.VK_SHIFT){
                    gp.saveName = gp.saveName.concat("_");
                }
                if(code == KeyEvent.VK_BACK_SPACE){
                    if(gp.saveName.length() > 1){
                        gp.saveName = gp.saveName.substring(0, gp.saveName.length()-1);
                        //System.out.println("BACKSPACE");
                    }
                }
                if(code == KeyEvent.VK_SPACE){
                    gp.saveName = gp.saveName.concat(" ");
                }
            
                if(code == KeyEvent.VK_UP){
                    gp.ui.commandNum--;
                    if(gp.ui.commandNum < 0){
                        gp.ui.commandNum = 1;
                    }
                    //System.out.println("menu su");
                }
                if(code == KeyEvent.VK_DOWN){
                    gp.ui.commandNum++;
                    if(gp.ui.commandNum > 1){
                        gp.ui.commandNum = 0;
                    }
                    //System.out.println("menu giu");
                }
                if(code == KeyEvent.VK_ENTER){

                    if(gp.ui.commandNum == 0){
                        gp.gameState = gp.playState;
                        gp.gd.uploadData();
                        System.out.println(gp.saves);
                        gp.saves.add(gp.gd);
                        gp.ui.commandNum = 0;
                    }
                    if(gp.ui.commandNum == 1){
                        gp.ui.titleScreenState = 0;
                        gp.ui.commandNum = 0;
                    }

                    //System.out.println("Select item");
                }
                
                //gp.player.getPlayerImage();
                
            }else if(gp.ui.titleScreenState == 2){
            
                if(code == KeyEvent.VK_ENTER || code == KeyEvent.VK_ESCAPE){

                    if(gp.ui.commandNum == 0){
                        gp.ui.commandNum = 1;
                        gp.ui.titleScreenState = 0;
                    }

                    //System.out.println("Select item");
                }
                
                gp.player.getPlayerImage();
            }else if(gp.ui.titleScreenState == 3){
                
                if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
                    gp.ui.commandNum--;
                    if(gp.ui.commandNum < 0){
                        gp.ui.commandNum = 4;
                    }
                    //System.out.println("menu su");
                }
                if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
                    gp.ui.commandNum++;
                    if(gp.ui.commandNum > 4){
                        gp.ui.commandNum = 0;
                    }
                    //System.out.println("menu giu");
                }
                if(code == KeyEvent.VK_ENTER){

                    if(gp.ui.commandNum == 0){
                        // SLOT 1
                        gp.gd = (GameData) gp.saves.get(0);
                        if(!gp.gd.name.equalsIgnoreCase("")){
                            gp.gd.downloadData();
                            gp.gameState = gp.playState;
                        }
                    }
                    if(gp.ui.commandNum == 1){
                        // SLOT 2
                        gp.gd = (GameData) gp.saves.get(0);
                        if(!gp.gd.name.equalsIgnoreCase("")){
                            gp.gd.downloadData();
                            gp.gameState = gp.playState;
                        }
                    }
                    if(gp.ui.commandNum == 2){
                        // SLOT 3
                        gp.gd = (GameData) gp.saves.get(0);
                        if(!gp.gd.name.equalsIgnoreCase("")){
                            gp.gd.downloadData();
                            gp.gameState = gp.playState;
                        }
                    }
                    if(gp.ui.commandNum == 3){
                        // SLOT 4
                        gp.gd = (GameData) gp.saves.get(0);
                        if(!gp.gd.name.equalsIgnoreCase("")){
                            gp.gd.downloadData();
                            gp.gameState = gp.playState;
                        }
                    }
                    if(gp.ui.commandNum == 4){
                        gp.ui.commandNum = 1;
                        gp.ui.titleScreenState = 1;
                    }

                    //System.out.println("Select item");
                }
            }
            
        }else if(gp.gameState == gp.playState){
            
            if(code == KeyEvent.VK_L){
                gp.player.money += 100;
                //System.out.println("su");
            }
            if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
                upPressed = true;
                //System.out.println("su");
            }
            if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
                downPressed = true;
                //System.out.println("giu");
            }
            if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
                leftPressed = true;
                //System.out.println("left");
            }
            if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
                rightPressed = true;
                //System.out.println("right");
            }
            if(code == KeyEvent.VK_P){

                gp.gameState = gp.pauseState;

                //System.out.println("Game paused");
            }
            if(code == KeyEvent.VK_ENTER){

                enterPressed = true;

                //System.out.println("Try to speak");
            }
            if(code == KeyEvent.VK_T){

                if(checkDrawTime){
                    checkDrawTime = false;
                }else if(!checkDrawTime){
                    checkDrawTime = true;
                }

                //System.out.println("Check draw time");
            }
            if(code == KeyEvent.VK_I){

                gp.gameState = gp.inventaryState;

                //System.out.println("Game paused");
            }
            if(code == KeyEvent.VK_F){

                fPressed = true;

                //System.out.println("Check draw time");
            }
            if(code == KeyEvent.VK_G){

                gPressed = true;

                //System.out.println("Check draw time");
            }
            if(code == KeyEvent.VK_M){

                mPressed = true;

                //System.out.println("Check draw time");
            }
        }else if(gp.gameState == gp.pauseState){
            
            if(code == KeyEvent.VK_P || code == KeyEvent.VK_ESCAPE){

                gp.gameState = gp.playState;

                //System.out.println("Game not paused");
            }if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
                gp.ui.commandNum--;
                if(gp.ui.commandNum < 0){
                    gp.ui.commandNum = 1;
                }
                //System.out.println("menu su");
            }
            if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
                gp.ui.commandNum++;
                if(gp.ui.commandNum > 1){
                    gp.ui.commandNum = 0;
                }
                //System.out.println("menu giu");
            }
            if(code == KeyEvent.VK_ENTER){

                if(gp.ui.commandNum == 0){
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 1){
                    gp.gd.uploadData();
                    if(gp.saves.size() > 0){
                        for(int i = 0; i < gp.saves.size(); i++){
                            GameData gd = (GameData) gp.saves.get(i);
                            if(gd.name.equalsIgnoreCase(gp.gd.name)){
                                gp.saves.set(i, gd);
                                gp.uTool.saveFile(gp);
                            }
                        }
                    }
                    gp.gameState = gp.titleState;
                    gp.ui.titleScreenState = 0;
                    gp.ui.commandNum = 0;
                }

                //System.out.println("Select item");
            }
            
        }else if(gp.gameState == gp.dialogueState){
            
            if(code == KeyEvent.VK_ENTER || code == KeyEvent.VK_ESCAPE){
                gp.gameState = gp.playState;
            }
        }else if(gp.gameState == gp.inventaryState){
            
            if(code == KeyEvent.VK_ENTER || code == KeyEvent.VK_ESCAPE || code == KeyEvent.VK_I){
                gp.gameState = gp.playState;
            }
        }else if(gp.gameState == gp.shopState){
            
            if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
                gp.ui.commandNum--;
                if(gp.ui.commandNum < 0){
                    gp.ui.commandNum = 3;
                }
                //System.out.println("menu su");
            }
            if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
                gp.ui.commandNum++;
                if(gp.ui.commandNum > 3){
                    gp.ui.commandNum = 0;
                }
                //System.out.println("menu giu");
            }
            if(code == KeyEvent.VK_ENTER){

                if(gp.ui.commandNum == 0){
                    if(gp.player.money >= gp.waterPrice){
                        //System.out.println("Buy water");
                        gp.ui.addMessage("Water +1!");
                        gp.player.water += 1;
                        gp.player.money -= gp.waterPrice;
                    }else
                    gp.ui.addMessage("You don't have enought money!");
                }
                if(gp.ui.commandNum == 1){
                    if(gp.player.money >= gp.milkPrice){
                        //System.out.println("Buy milk");
                        gp.ui.addMessage("Milk +1!");
                        gp.player.milk += 1;
                        gp.player.money -= gp.milkPrice;
                    }else
                    gp.ui.addMessage("You don't have enought money!");
                }
                if(gp.ui.commandNum == 2){
                    if(gp.player.money >= gp.seedPrice){
                        //System.out.println("Buy seed");
                        gp.ui.addMessage("Seed +1!");
                        gp.player.seed += 1;
                        gp.player.money -= gp.seedPrice;
                    }else
                    gp.ui.addMessage("You don't have enought money!");
                }
                if(gp.ui.commandNum == 3){
                    if(gp.player.money >= gp.cornPrice){
                        //System.out.println("Buy corn");
                        gp.ui.addMessage("Corn +1!");
                        gp.player.corn += 1;
                        gp.player.money -= gp.cornPrice;
                    }else
                    gp.ui.addMessage("You don't have enought money!");
                }

                //System.out.println("Select item");
            }
            
            if(code == KeyEvent.VK_ESCAPE){
                gp.gameState = gp.playState;
            }
        }else if(gp.gameState == gp.chestState){
            
            if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
                gp.ui.commandNum--;
                if(gp.ui.commandNum < 0){
                    gp.ui.commandNum = 3;
                }
                //System.out.println("menu su");
            }
            if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
                gp.ui.commandNum++;
                if(gp.ui.commandNum > 3){
                    gp.ui.commandNum = 0;
                }
                //System.out.println("menu giu");
            }
            if(code == KeyEvent.VK_ENTER){

                if(gp.ui.commandNum == 0){
                    // Controllo se in cesta ci sono abbastanza oggetti, li tolgo dalla cesta, e li do al personaggio
                    if(gp.player.water > 0){
                        //System.out.println("Sell water");
                        gp.ui.addMessage("Water -1!");
                        gp.player.water -= 1;
                        gp.player.money += gp.waterPrice;
                    }else
                    gp.ui.addMessage("You have 0 water!");
                }
                if(gp.ui.commandNum == 1){
                    if(gp.player.milk > 0){
                        //System.out.println("Sell milk");
                        gp.ui.addMessage("Milk -1!");
                        gp.player.milk -= 1;
                        gp.player.money += gp.milkPrice;
                    }else
                    gp.ui.addMessage("You have 0 milk!");
                }
                if(gp.ui.commandNum == 2){
                    if(gp.player.seed > 0){
                        //System.out.println("Sell seed");
                        gp.ui.addMessage("Seed -1!");
                        gp.player.seed -= 1;
                        gp.player.money += gp.seedPrice;
                    }else
                    gp.ui.addMessage("You have 0 seed!");
                }
                if(gp.ui.commandNum == 3){
                    if(gp.player.corn > 0){
                        //System.out.println("Sell corn");
                        gp.ui.addMessage("Corn -1!");
                        gp.player.corn -= 1;
                        gp.player.money += gp.cornPrice;
                    }else
                    gp.ui.addMessage("You have 0 corn!");
                }

                //System.out.println("Select item");
            }

            if(code == KeyEvent.VK_ESCAPE){
                gp.gameState = gp.playState;
            }
        }else if(gp.gameState == gp.cornState){
            
            if(code == KeyEvent.VK_ENTER){
                gp.gameState = gp.playState;
            }
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            downPressed = false;
        }
        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
        if(code == KeyEvent.VK_F){
            fPressed = false;
        }
        if(code == KeyEvent.VK_G){
            gPressed = false;
        }
        if(code == KeyEvent.VK_M){
            mPressed = false;
        }
    }
    
}
