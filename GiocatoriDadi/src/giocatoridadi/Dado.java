/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GiocatoriDadi;

import java.util.Random;
/**
 *
 * @author Mattia Checchetto
 */
public class Dado {

    private int facce;
    private int num;

    public Dado(int facce) {
        this.facce = facce;
    }

    public int getFacce() {
        return facce;
    }

    public void setFacce(int facce) {
        this.facce = facce;
    }

    public int getNum() {
        return num;
    }

    public void lancia() {
        Random x = new Random();
        this.num = x.nextInt(facce)+1;
    }

    @Override
    public String toString() {
        return "Dado{" + "facce=" + facce + ", num=" + num + '}';
    }
    
    

}
