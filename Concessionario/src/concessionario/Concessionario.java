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
        auto[0]= new Auto("Ferrari","488GTB",2,"Rosso",8,4300,800,750);
        auto[1]= new Auto("Lamborghini","Huracan STO",2,"Azzurro",10,6500,700,750);
        auto[2]= new Auto("Ferrari","F8 Tributo",2,"Rosso",8,4300,820,770);
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
