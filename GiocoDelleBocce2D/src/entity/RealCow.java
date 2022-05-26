/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Random;
import main.GamePanel;

/**
 *
 * @author Studente Turno B
 */
public class RealCow  extends Entity{
    

    public RealCow(GamePanel gp) {
        super(gp);
        milk = 0;
        name = "pretty";
        
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
        
        dialogues[0] = "You have to pay me!";
        dialogues[1] = "I do everything you want!";
        dialogues[2] = "Ohhh yess!";
        dialogues[3] = "I'm horny!";
        dialogues[4] = "Fuck me!";
        
    }
    
    public void setAction(){
        
        actionLockerCounter++;
        
        if(water > 0 && corn > 0){
            cont += 1;
            if(cont >= gp.FPS*20){
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
        
        if(milk == 0){
            i = 0;
        }
        /*
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
        */
        
        super.speak(i);
        
    }
    
}
