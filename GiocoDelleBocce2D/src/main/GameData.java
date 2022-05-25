/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 *
 * @author Mattia Checchetto
 */
public class GameData implements Serializable {
    
    GamePanel gp;
    
    
    public int worldX;
    public int worldY;
    public int speed;
    public String name;
    public String direction;
    public Rectangle solidArea;
    public int solidAreaDefaultX;
    public int solidAreaDefaultY;
    public int water;
    public int milk;
    public int corn;
    public int seed;
    public int money;
    

    public GameData(GamePanel gp, String name) {
        this.gp = gp;
        this.name = name;
    }
    
    public void uploadData(){
        
        worldX = gp.player.worldX;
        worldY = gp.player.worldY;
        speed = gp.player.speed;
        direction = gp.player.direction;
        solidArea = gp.player.solidArea;
        solidAreaDefaultX = gp.player.solidAreaDefaultX;
        solidAreaDefaultY = gp.player.solidAreaDefaultY;
        water = gp.player.water;
        milk = gp.player.milk;
        corn = gp.player.corn;
        seed = gp.player.seed;
        money = gp.player.money;
        
    }
    
    public void downloadData(){
        
        gp.player.worldX = worldX;
        gp.player.worldY = worldY;
        gp.player.speed = speed;
        gp.player.direction = direction;
        gp.player.solidArea = solidArea;
        gp.player.solidAreaDefaultX = solidAreaDefaultX;
        gp.player.solidAreaDefaultY = solidAreaDefaultY;
        gp.player.water = water;
        gp.player.milk = milk;
        gp.player.corn = corn;
        gp.player.seed = seed;
        gp.player.money = money;
        
    }
    
}
