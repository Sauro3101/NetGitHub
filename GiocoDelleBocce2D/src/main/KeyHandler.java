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
                        gp.ui.commandNum = 2;
                    }
                    //System.out.println("menu su");
                }
                if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
                    gp.ui.commandNum++;
                    if(gp.ui.commandNum > 2){
                        gp.ui.commandNum = 0;
                    }
                    //System.out.println("menu giu");
                }
                if(code == KeyEvent.VK_ENTER){

                    if(gp.ui.commandNum == 0){
                        gp.ui.titleScreenState = 1;
                    }
                    if(gp.ui.commandNum == 1){
                        // Add later saving and load
                        // VIEW INSTRUCTION SCREEN
                        gp.ui.commandNum = 0;
                        gp.ui.titleScreenState = 2;
                    }
                    if(gp.ui.commandNum == 2){
                        System.exit(0);
                    }

                    //System.out.println("Select item");
                }
                
            }else if(gp.ui.titleScreenState == 1){
            
                if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
                    gp.ui.commandNum--;
                    if(gp.ui.commandNum < 0){
                        gp.ui.commandNum = 2;
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
                        System.out.println("Color red");
                        gp.player.playerColor = "red";
                        gp.gameState = gp.playState;
                        gp.ui.commandNum = 0;
                    }
                    if(gp.ui.commandNum == 1){
                        System.out.println("Color blue");
                        gp.player.playerColor = "blue";
                        gp.gameState = gp.playState;
                        gp.ui.commandNum = 0;
                    }
                    if(gp.ui.commandNum == 2){
                        System.out.println("Color green");
                        gp.player.playerColor = "green";
                        gp.gameState = gp.playState;
                        gp.ui.commandNum = 0;
                    }
                    if(gp.ui.commandNum == 3){
                        gp.ui.titleScreenState = 0;
                        gp.ui.commandNum = 0;
                    }

                    //System.out.println("Select item");
                }
                
                gp.player.getPlayerImage();
            }else if(gp.ui.titleScreenState == 2){
            
                if(code == KeyEvent.VK_ENTER || code == KeyEvent.VK_ESCAPE){

                    if(gp.ui.commandNum == 0){
                        gp.ui.commandNum = 1;
                        gp.ui.titleScreenState = 0;
                    }

                    //System.out.println("Select item");
                }
                
                gp.player.getPlayerImage();
            }
            
        }else if(gp.gameState == gp.playState){
        
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
            }
            if(code == KeyEvent.VK_ENTER){

                if(gp.ui.commandNum == 0){
                    gp.gameState = gp.titleState;
                    gp.ui.titleScreenState = 0;
                }

                //System.out.println("Game not paused");
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
                            System.out.println("Buy water");
                            gp.player.water += 1;
                            gp.player.money -= gp.waterPrice;
                        }
                    }
                    if(gp.ui.commandNum == 1){
                        if(gp.player.money >= gp.milkPrice){
                            System.out.println("Buy milk");
                            gp.player.milk += 1;
                            gp.player.money -= gp.milkPrice;
                        }
                    }
                    if(gp.ui.commandNum == 2){
                        if(gp.player.money >= gp.seedPrice){
                            System.out.println("Buy seed");
                            gp.player.seed += 1;
                            gp.player.money -= gp.seedPrice;
                        }
                    }
                    if(gp.ui.commandNum == 3){
                        if(gp.player.money >= gp.cornPrice){
                            System.out.println("Buy corn");
                            gp.player.corn += 1;
                            gp.player.money -= gp.cornPrice;
                        }
                    }

                    //System.out.println("Select item");
                }
            
            if(code == KeyEvent.VK_ENTER){
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
                            System.out.println("Sell water");
                            gp.player.water -= 1;
                            gp.player.money += gp.waterPrice;
                        }
                    }
                    if(gp.ui.commandNum == 1){
                        if(gp.player.milk > 0){
                            System.out.println("Sell milk");
                            gp.player.milk -= 1;
                            gp.player.money += gp.milkPrice;
                        }
                    }
                    if(gp.ui.commandNum == 2){
                        if(gp.player.seed > 0){
                            System.out.println("Sell seed");
                            gp.player.seed -= 1;
                            gp.player.money += gp.seedPrice;
                        }
                    }
                    if(gp.ui.commandNum == 3){
                        if(gp.player.corn > 0){
                            System.out.println("Sell corn");
                            gp.player.corn -= 1;
                            gp.player.money += gp.cornPrice;
                        }
                    }

                    //System.out.println("Select item");
                }
            
            if(code == KeyEvent.VK_ENTER){
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
