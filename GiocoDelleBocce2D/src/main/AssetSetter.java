/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;

/**
 *
 * @author Mattia Checchetto
 */
public class AssetSetter {
    
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }
    
    public void setObject(){
        
        gp.obj[0] = new OBJ_Key();
        gp.obj[0].worldX = 16 * gp.tileSize;
        gp.obj[0].worldY = 14 * gp.tileSize;
        
        gp.obj[1] = new OBJ_Key();
        gp.obj[1].worldX = 30 * gp.tileSize;
        gp.obj[1].worldY = 27 * gp.tileSize;
        
        gp.obj[2] = new OBJ_Door();
        gp.obj[2].worldX = 26 * gp.tileSize;
        gp.obj[2].worldY = 13 * gp.tileSize;
        
        gp.obj[3] = new OBJ_Door();
        gp.obj[3].worldX = 37 * gp.tileSize;
        gp.obj[3].worldY = 18 * gp.tileSize;
        
        gp.obj[4] = new OBJ_Chest();
        gp.obj[4].worldX = 35 * gp.tileSize;
        gp.obj[4].worldY = 21 * gp.tileSize;
        
    }
}
