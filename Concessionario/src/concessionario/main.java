/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package concessionario;

/**
 *
 * @author Mattia Checchetto
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConsoleInputConException in = new ConsoleInputConException();
        int scelta;
        do{
            System.out.println("Digitare il numero corrispondente all'opzione scelta:\n 1. Inserire una nuova auto\n" +
            "2. Visualizzare tutte le auto\n" +
            "3. Visualizzare i dati della prima auto che abbia il colore passato per parametro\n" +
            "4. Visualizzare i dati di  tutte le auto del concessionario ordinate per marca\n0. Exit");
            scelta=in.readInt();
            
        }while(scelta!=0);
        
        switch(scelta){
            case 0:
            case 1:
                //Inserire una nuova auto
            case 2:
                //Visualizzare tutte le auto
            case 3:
                //Visualizzare i dati della prima auto che abbia il colore passato per parametro
            case 4:
                //Visualizzare i dati di  tutte le auto del concessionario ordinate per marca
            default:
                System.out.println("ERRORE");
        }
    }
    
}
