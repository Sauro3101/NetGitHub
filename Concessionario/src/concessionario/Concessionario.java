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
    public void addAuto(){
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
        Auto[nAuto] = new Auto();
        nAuto++;
    }
    public void ordinaMarca(){
        Auto tmp;
        for (int i = 0; i < auto.length; i++){  
            for (int j = i + 1; j < auto.length; j++){
                if (auto[i].compareToIgnoreCase(auto[j])>0){
                    tmp = auto[i];
                    auto[i] = auto[j];  
                    auto[j] = tmp;
                }
            }
        }
    }
}
