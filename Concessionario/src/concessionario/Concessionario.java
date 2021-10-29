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
    
    public void iniAuto(){
        auto = java.util.Arrays.copyOf(auto, auto.length +4);
        auto[0]= new Auto("Ferrari","488 Pista",2,"Rosso",8,3902,720,770);
        auto[1]= new Auto("Lamborghini","Huracan STO",2,"Azzurro",10,5204,640,565);
        auto[2]= new Auto("Ferrari","F8 Tributo",2,"Rosso",8,3902,720,770);
        auto[3]= new Auto("Lamborghini","Aventador SVJ",2,"Verde",12,6498,770,720);
    }
    public void addAuto(){
        ConsoleInputConException in = new ConsoleInputConException();
        int posti,cilindri,cilindrata,potenza,coppia;
        String marca,modello,colore;
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
        auto = java.util.Arrays.copyOf(auto, auto.length +1);
        auto[nAuto] = new Auto(marca,modello,posti,colore,cilindri,cilindrata,potenza,coppia);
        nAuto++;
    }
    public String findColore(String colore){
        for(int i=0;i<nAuto;i++){
            if(colore.equals(auto[i].getColore())){
                return auto[i].toString();
            }
        }
        return "ERROR";
    }
    public Auto[] ordinaMarca(){
        Auto tmp;
        for (int i = 0; i < auto.length; i++){  
            for (int j = i + 1; j < auto.length; j++){
                if (auto[i].getMarca().compareToIgnoreCase(auto[j].getMarca())>0){
                    tmp = auto[i];
                    auto[i] = auto[j];  
                    auto[j] = tmp;
                }
            }
        }
        return auto;
    }
}
