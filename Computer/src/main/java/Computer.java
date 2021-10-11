/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author matti
 */
public class Computer {
    private int codice;
    private String marca;
    private String modello;
    private double velocitaP;
    private int dimensioniRAM;
    private int dimensioniDisco;
    private int dimensioniMonitor;
    private int annoAcquisto;

    public Computer(int codice, String marca, String modello, double velocitaP, int dimensioniRAM, int dimensioniDisco, int dimensioniMonitor, int annoAcquisto) {
        this.codice = codice;
        this.marca = marca;
        this.modello = modello;
        this.velocitaP = velocitaP;
        this.dimensioniRAM = dimensioniRAM;
        this.dimensioniDisco = dimensioniDisco;
        this.dimensioniMonitor = dimensioniMonitor;
        this.annoAcquisto = annoAcquisto;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public double getVelocitaP() {
        return velocitaP;
    }

    public void setVelocitaP(double velocitaP) {
        this.velocitaP = velocitaP;
    }

    public int getDimensioniRAM() {
        return dimensioniRAM;
    }

    public void setDimensioniRAM(int dimensioniRAM) {
        this.dimensioniRAM = dimensioniRAM;
    }

    public int getDimensioniDisco() {
        return dimensioniDisco;
    }

    public void setDimensioniDisco(int dimensioniDisco) {
        this.dimensioniDisco = dimensioniDisco;
    }

    public int getDimensioniMonitor() {
        return dimensioniMonitor;
    }

    public void setDimensioniMonitor(int dimensioniMonitor) {
        this.dimensioniMonitor = dimensioniMonitor;
    }

    public int getAnnoAcquisto() {
        return annoAcquisto;
    }

    public void setAnnoAcquisto(int annoAcquisto) {
        this.annoAcquisto = annoAcquisto;
    }
    
    @Override
    public String toString(){
        return("Codice: "+codice+"\nMarca: "+marca+"\nModello: "+modello+"\nVelocità processore: "+velocitaP+" GHz\nDimensioni della memoria RAM: "+dimensioniRAM+" MB\nDimensioni del disco: "+dimensioniDisco+" MB\nDimensioni del monitor: "+dimensioniMonitor+"\"\nAnno di acquisto: "+annoAcquisto);
    }
    
}
