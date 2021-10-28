/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package GiocatoriDadi;

/**
 *
 * @author Mattia Checchetto
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConsoleInputConException in = new ConsoleInputConException();
        Dado d1;
        
        System.out.println("Inserisci quante facce avra' il dado: ");
        d1 = new Dado(in.readInt());  
    }   
}
    
