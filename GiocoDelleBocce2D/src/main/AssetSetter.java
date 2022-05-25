/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import entity.Cow;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Field;
import object.OBJ_Key;
import object.OBJ_Shop;

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
        
        gp.obj[0] = new OBJ_Chest();
        gp.obj[0].worldX = gp.tileSize*10;
        gp.obj[0].worldY = gp.tileSize*8;
        
        gp.obj[1] = new OBJ_Field();
        gp.obj[1].worldX = gp.tileSize*38;
        gp.obj[1].worldY = gp.tileSize*9;
        
        gp.obj[2] = new OBJ_Field();
        gp.obj[2].worldX = gp.tileSize*37;
        gp.obj[2].worldY = gp.tileSize*9;
        
        gp.obj[3] = new OBJ_Field();
        gp.obj[3].worldX = gp.tileSize*38;
        gp.obj[3].worldY = gp.tileSize*10;
        
        gp.obj[4] = new OBJ_Field();
        gp.obj[4].worldX = gp.tileSize*37;
        gp.obj[4].worldY = gp.tileSize*10;
        
        gp.obj[5] = new OBJ_Shop();
        gp.obj[5].worldX = gp.tileSize*10;
        gp.obj[5].worldY = gp.tileSize*31;
        
        gp.obj[6] = new OBJ_Shop();
        gp.obj[6].worldX = gp.tileSize*10;
        gp.obj[6].worldY = gp.tileSize*32;
        
        /*
        gp.obj[5] = new OBJ_Letter(s);
        gp.obj[5].worldX = gp.tileSize*9;
        gp.obj[5].worldY = gp.tileSize*30;
        
        gp.obj[6] = new OBJ_Letter(h);
        gp.obj[6].worldX = gp.tileSize*9;
        gp.obj[6].worldY = gp.tileSize*31;
        
        gp.obj[7] = new OBJ_Letter(o);
        gp.obj[7].worldX = gp.tileSize*9;
        gp.obj[7].worldY = gp.tileSize*32;
        
        gp.obj[8] = new OBJ_Letter(p);
        gp.obj[8].worldX = gp.tileSize*9;
        gp.obj[8].worldY = gp.tileSize*33;
        */
    }
    
    public void setNPC(){
        
        gp.npc[0] = new Cow(gp);
        gp.npc[0].worldX = gp.tileSize*29;
        gp.npc[0].worldY = gp.tileSize*17;
        
        /*
        gp.npc[1] = new Cow(gp);
        gp.npc[1].worldX = gp.tileSize*31;
        gp.npc[1].worldY = gp.tileSize*14;
        */
    }
    
}
