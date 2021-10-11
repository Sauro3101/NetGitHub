/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author matti
 */
public class testProgramma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Programma p1=new Programma("NetBeans","Apache","12.5","Windows 10",2020);
        Programma p2=new Programma("JDK","Oracle","16.0.2","Windows 7",2019);
        Programma p3=new Programma("StarUML","MKLabs","4.1.5","Windows 10",2020);
        
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        
        System.out.println(p1.compareAnno(p2.getAnno(), p2.getDenominazione()));
        System.out.println(p2.compareAnno(p3.getAnno(), p3.getDenominazione()));
        System.out.println(p3.compareAnno(p1.getAnno(), p1.getDenominazione()));
        
        
    }
    
}
