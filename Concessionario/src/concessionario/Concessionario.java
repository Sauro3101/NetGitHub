/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concessionario;

/**
 *
 * @author Mattia Checchetto
 */
public class Concessionario {
    private int nAuto;
    private Auto[] auto=new Auto[nAuto];
    private static int maxAuto=15;

    public Concessionario(int nAuto) {
        this.nAuto = nAuto;
    }

    public int getnAuto() {
        return nAuto;
    }

    public void setnAuto(int nAuto) {
        this.nAuto = nAuto;
    }

    public Auto[] getAuto() {
        return auto;
    }

    public void setAuto(Auto[] auto) {
        this.auto = auto;
    }

    public static int getMaxAuto() {
        return maxAuto;
    }

    public static void setMaxAuto(int maxAuto) {
        Concessionario.maxAuto = maxAuto;
    }
}
