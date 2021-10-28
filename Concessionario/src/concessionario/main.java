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
    void start(){
        ConsoleInputConException in = new ConsoleInputConException();
        int i,numeroAuto=1,posti,cilindri,cilindrata,potenza,coppia;
        Auto[] b= new Auto[numeroAuto];
        String marca,modello,colore;
        System.out.println("INIZIALIZZAZIONE CONCESSIONARIO:\nInserire il numero di auto che si intende memorizzare(min 1-max 15):");
        numeroAuto=in.readInt();
        for(i=0;i<numeroAuto;i++){
            System.out.println("Inserisci i dati dell'auto:\nMarca:");
            marca=in.readLine();
            System.out.println("Modello:");
            modello=in.readLine();
            System.out.println("Numero di posti:");
            posti=in.readInt();
            System.out.println("Colore:");
            colore=in.readLine();
            System.out.println("Dati motore:\nNumero di cilindri");
            cilindri=in.readInt();
            System.out.println("Cilindrata:");
            cilindrata=in.readInt();
            System.out.println("Potenza(cv):");
            potenza=in.readInt();
            System.out.println("Coppia(nm):");
            coppia=in.readInt();
            
            
        }
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConsoleInputConException in = new ConsoleInputConException();
        int scelta;
        Concessionario con= new Concessionario(3);
        String colore;
        int i;
        System.out.println("INIZIALIZZAZIONE CONCESSIONARIO:");
        Auto[] a=con.getAuto();
        Auto[] b= new Auto[con.getnAuto()];
        
        System.out.println(a[1].toString());
        
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
                System.out.println("Colore da cercare:");
                colore=in.readLine();
                for(i=0;i<con.getnAuto();i++){
                    if(colore==con.getAuto(i).getColore){
                        con.getAuto(i).toString;
                    }
                }
            case 4:
                //Visualizzare i dati di  tutte le auto del concessionario ordinate per marca
            default:
                System.out.println("ERRORE");
        }
        
    }
    
}
