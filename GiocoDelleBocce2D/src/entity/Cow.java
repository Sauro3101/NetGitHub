/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Random;
import main.GamePanel;

/**
 *
 * @author Greta
 */
public class Cow extends Entity{
    
    public long cont = 0;

    public Cow(GamePanel gp) {
        super(gp);
        water = 0;
        corn = 0;
        
        direction = "down";
        speed = 1;
        
        getImage();
        setDialogue();
    }
    
    public void getImage(){
        
        up1 = setup("/res/npc/oldman_up_1");
        up2 = setup("/res/npc/oldman_up_2");
        down1 = setup("/res/npc/oldman_down_1");
        down2 = setup("/res/npc/oldman_down_2");
        left1 = setup("/res/npc/oldman_left_1");
        left2 = setup("/res/npc/oldman_left_2");
        right1 = setup("/res/npc/oldman_right_1");
        right2 = setup("/res/npc/oldman_right_2");
        
    }
    
    public void setDialogue(){
        
        dialogues[0] = "I need water!";
        dialogues[1] = "I need food!";
        dialogues[2] = "I need water and food!";
        dialogues[3] = "I'm making milk!";
        dialogues[4] = "The milk is ready!";
        
    }
    
    public void setAction(){
        
        actionLockerCounter++;
        
        if(water > 0 && corn > 0){
            cont += 1000000000/gp.FPS;
            if(cont >= (1000000000/gp.FPS)*6000){
                cont = 0;
                milk += 1;
                water -= 1;
                corn -= 1;
            }
        }
        
        if(actionLockerCounter == 100){



            Random random = new Random();
            int i = random.nextInt(100)+1;

            if(i <= 25){
                direction = "up";
            }else if(i > 25 && i <= 50){
                direction = "down";
            }else if(i > 50 && i <= 75){
                direction = "left";
            }else if(i > 75 && i <= 100){
                direction = "right";
            }

            actionLockerCounter = 0;

        }
        
    }
    
    public void chooseDialogue(){
        
        // Character specific stuff
        int i = 0;
        
        if(water == 0 && corn != 0 && milk == 0){
            i = 0;
        }
        if(water != 0 && corn == 0 && milk == 0){
            i = 1;
        }
        if(water == 0 && corn == 0 && milk == 0){
            i = 2;
        }
        if(water != 0 && corn != 0 && milk == 0){
            i = 3;
        }
        if(water == 0 && corn == 0 && milk > 0){
            i = 4;
        }
        
        super.speak(i);
        
    }
    
}
