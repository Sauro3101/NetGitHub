/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import main.GamePanel;

/**
 *
 * @author Greta
 */
public class NPC_OldMan extends Entity{

    public NPC_OldMan(GamePanel gp) {
        super(gp);
        
        direction = "down";
        speed = 2;
    }
    
}
