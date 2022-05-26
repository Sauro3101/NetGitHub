/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Greta
 */
public class UtilityTool {
    
    public BufferedImage scaleimage(BufferedImage original, int width, int height){
        BufferedImage scaledImage = new BufferedImage(width, height, original.getType());
        Graphics2D g2 = scaledImage.createGraphics();
        g2.drawImage(original, 0, 0, width, height, null);
        g2.dispose();
        
        return scaledImage;
    }
    
    public void saveFile(GamePanel gp){
        ObjectOutputStream fbinarioOut = null;
        try {
            fbinarioOut = new ObjectOutputStream(new FileOutputStream("GameData.bin"));
            fbinarioOut.writeObject(gp.saves);
            fbinarioOut.flush();
            fbinarioOut.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UtilityTool.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UtilityTool.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fbinarioOut.close();
            } catch (IOException ex) {
                Logger.getLogger(UtilityTool.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public ArrayList readFile(){
        ObjectInputStream fin = null;
        ArrayList a = null;
        try {
            fin = new ObjectInputStream(new FileInputStream("GameData.bin"));
            a = (ArrayList) fin.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("file non trovato");
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        try {
            fin.close();
        } catch (Exception ex) {
            System.out.println("non posso chiudere");
        }
        
        return a;
    }
    
}
