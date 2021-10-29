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
        int scelta,i;
        String findColore;
        
        System.out.println("INIZIALIZZAZIONE CONCESSIONARIO:\nSono state inizializzate 4 auto");
        Concessionario con= new Concessionario(4);
        Auto[] a= new Auto[con.getnAuto()];
        con.iniAuto();
        do{
            System.out.println("\n\nDigitare il numero corrispondente all'opzione scelta:\n" + "1. Inserire una nuova auto\n" + "2. Visualizzare tutte le auto\n" + "3. Visualizzare i dati della prima auto che abbia il colore passato per parametro\n" + "4. Visualizzare i dati di  tutte le auto del concessionario ordinate per marca\n" + "0. Exit");
            scelta=in.readInt();
            
            switch(scelta){
                case 0 -> {
                }
                case 1 -> //Inserire una nuova auto
                    con.addAuto();
                case 2 -> {
                    //Visualizzare tutte le auto
                    a=con.getAuto();
                    for(i=0;i<con.getnAuto();i++){
                        System.out.println(a[i].toString());
                    }
                }
                case 3 -> {
                    //Visualizzare i dati della prima auto che abbia il colore passato per parametro
                    System.out.println("\n\nColore da cercare:");
                    findColore=in.readLine();
                    System.out.println(con.findColore(findColore));
                }
                case 4 -> {
                    //Visualizzare i dati di  tutte le auto del concessionario ordinate per marca
                    a=con.ordinaMarca();
                    for(i=0;i<con.getnAuto();i++){
                        System.out.println(a[i].toString()+"\n\n");
                    }
                }
                default -> System.out.println("ERRORE\n");
            }
        }while(scelta!=0);
        
        
        
    }
    
}
