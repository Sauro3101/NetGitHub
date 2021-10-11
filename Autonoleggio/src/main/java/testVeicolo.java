/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author matti
 */
public class testVeicolo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Veicolo v1=new Veicolo("FI586V","Renault","Clio",1.2,2018,4);
        Veicolo v2=new Veicolo("EK349D","Opel","Corsa",1.4,2017,5);
        Veicolo v3=new Veicolo("DT856L","Peugeot","106",1.6,2019,5);
        
        System.out.println(v1.toString());
        System.out.println(v2.toString());
        System.out.println(v3.toString());
    }
    
}
