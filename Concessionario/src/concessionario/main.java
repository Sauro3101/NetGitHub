/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package concessionario;

import java.util.Arrays;

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
        String findColore;
        int i,numeroAuto,posti,cilindri,cilindrata,potenza,coppia;
        String marca,modello,colore;
        
        System.out.println("INIZIALIZZAZIONE CONCESSIONARIO:\nInserire il numero di auto che si intende memorizzare(min 1-max 15):");
        numeroAuto=in.readInt();
        Auto[] b= new Auto[numeroAuto];
        Concessionario con= new Concessionario(numeroAuto);
        b[0]= new Auto("Ferrari","488GTB",2,"Rosso",8,4300,800,750);
        b[1]= new Auto("Lamborghini","Huracan STO",2,"Azzurro",10,6500,700,750);
        b[2]= new Auto("Ferrari","F8 Tributo",2,"Rosso",8,4300,820,770);
        for(i=3;i<numeroAuto;i++){
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
            b[i]= new Auto(marca,modello,posti,colore,cilindri,cilindrata,potenza,coppia);
            
        }
        con.setAuto(b);
        Auto[] a=con.getAuto();
        System.out.println(a[1].toString()+"\n\n");
        
        do{
            System.out.println("Digitare il numero corrispondente all'opzione scelta:\n 1. Inserire una nuova auto\n" +
            "2. Visualizzare tutte le auto\n" +
            "3. Visualizzare i dati della prima auto che abbia il colore passato per parametro\n" +
            "4. Visualizzare i dati di  tutte le auto del concessionario ordinate per marca\n0. Exit");
            scelta=in.readInt();
            
            switch(scelta){
                case 0:
                    break;
                case 1:
                    //Inserire una nuova auto
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
                    numeroAuto++;
                    con.setnAuto(numeroAuto);
                    b = java.util.Arrays.copyOf(b, b.length +1);
                    b[con.getnAuto()-1]= new Auto(marca,modello,posti,colore,cilindri,cilindrata,potenza,coppia);
                    con.setAuto(b);
                    a=con.getAuto();
                    break;
                case 2:
                    //Visualizzare tutte le auto
                    for(i=0;i<con.getnAuto();i++){
                        System.out.println(a[i].toString());
                    }
                    break;
                case 3:
                    //Visualizzare i dati della prima auto che abbia il colore passato per parametro
                    System.out.println("Colore da cercare:");
                    findColore=in.readLine();
                    for(i=0;i<con.getnAuto();i++){
                        if(findColore.equals(a[i].getColore())){
                            System.out.println(a[i].toString());
                            i=con.getnAuto();
                        }
                    }
                    break;
                case 4:
                    //Visualizzare i dati di  tutte le auto del concessionario ordinate per marca
                    String[] nomi=new String[con.getnAuto()];
                    for(i=0;i<con.getnAuto();i++){
                        nomi[i]=a[i].getMarca();
                        for (int i = 0; i < nomi.length; i++){  
                            for (int j = i + 1; j < nomi.length; j++){  
                            String tmp;  
                                if (nomi[i].compareToIgnoreCase(nomi[j])>0){
                                    tmp = nomi[i];
                                    nomi[i] = nomi[j];  
                                    nomi[j] = tmp;
                                }
                            }
                        }
                    }
                    for(i=0;i<con.getnAuto();i++){
                        System.out.println(a[i].toString());
                    }
                    break;
                default:
                    System.out.println("ERRORE");
                    break;
            }
        }while(scelta!=0);
        
        
        
    }
    
}
