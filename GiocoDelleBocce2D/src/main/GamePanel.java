/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import entity.Entity;
import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import main.tile.TileManager;
import object.SuperObject;

/**
 *
 * @author Mattia Checchetto
 */
public class GamePanel extends JPanel implements Runnable{
    
    //Screen Settings
    final int originalTileSize = 16;
    final int scale = 3;
    
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;
    
    //World Settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;
    
    //FPS
    public int FPS = 60;
    public long cont;
    
    TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    public EventHandler eventH = new EventHandler(this);
    Thread gameThread;
    
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    
    // Entity & Object
    public Player player = new Player(this, keyH);
    public SuperObject obj[] = new SuperObject[10];
    public Entity npc[] = new Entity[10];
    
    // Game state
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int shopState = 4;
    public final int chestState = 5;
    public final int cornState = 6;
    public final int inventaryState = 7;
    
    // Shop items prices
    public final int waterPrice = 3;
    public final int milkPrice = 8;
    public final int seedPrice = 3;
    public final int cornPrice = 6;
    //public final int applePrice = 10;
    
    // Saving settings
    public final int maxSaves = 4;
    public ArrayList saves = new ArrayList();
    
    // SAVING INFOS
    public String saveName = "";
    // SAVING INFOS
    
    UtilityTool uTool = new UtilityTool();
    GameData gd;
    
    
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    
    public void setupGame(){
        
        aSetter.setObject();
        aSetter.setNPC();
        gameState = titleState;
        
    }
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @Override
    public void run() {
        
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        
        saves = uTool.readFile();
        
        //GAME LOOP
        while(gameThread != null){
            
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / drawInterval;
            timer +=(currentTime -lastTime);
            lastTime = currentTime;
            
            if(delta >= 1){
                
                update();
                repaint();
                delta--;
                drawCount++;
                
            }
            
            if(timer >= 1000000000){
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
                cont = timer;
            }
            
        }
    }
    
    public void update(){
        
        if(gameState == playState){
            
            // PLAYER
            player.update();

            // NPC
            for(int i = 0; i < npc.length; i++){
                if(npc[i] != null){
                    if(npc[i].milk > 0){
                        //npc stop when milk ready
                    }else{
                        npc[i].update();
                    }
                }
            }
            
        }
        if(gameState == pauseState){
            // Nothing
        }
        
    }
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        // DEBUG
        long drawStart = 0;
        if(keyH.checkDrawTime){
            drawStart = System.nanoTime();
        }
        
        // TITLE SCREEN
        if(gameState == titleState){
            
            ui.draw(g2);
            
        }else{
            
            // TILE
            tileM.draw(g2);

            // OBJECT
            for(int i = 0; i < obj.length; i++){
                if(obj[i] != null){
                    obj[i].draw(g2, this);
                }
            }

            // NPC
            for(int i = 0; i < npc.length; i++){
                if(npc[i] != null){
                    npc[i].draw(g2);
                }
            }

            // PLAYER
            player.draw(g2);

            // UI
            ui.draw(g2);

        }
        
        // DEBUG
        if(keyH.checkDrawTime){
            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;
            g2.setColor(Color.red);
            g2.drawString("Draw time: " + passed, 10, 400);
            System.out.println("Draw time: " + passed);
        }
        
        g2.dispose();
    }
}
