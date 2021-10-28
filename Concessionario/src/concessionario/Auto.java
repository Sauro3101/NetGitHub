/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concessionario;

/**
 *
 * @author Mattia Checchetto
 */
public class Auto {
    private String marca;
    private String modello;
    private int posti;
    private String colore;
    private Motore motore;

    public Auto(String marca, String modello, int posti, String colore, int nCilindri, int cilindrata, int cv, int nm) {
        this.marca = marca;
        this.modello = modello;
        this.posti = posti;
        this.colore = colore;
        this.motore=new Motore(nCilindri,cilindrata,cv,nm);
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

    public int getPosti() {
        return posti;
    }

    public void setPosti(int posti) {
        this.posti = posti;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    @Override
    public String toString() {
        return "Auto{" + "\nmarca=" + marca + "\nmodello=" + modello + "\nposti=" + posti + "\ncolore=" + colore + "\n" + motore.toString() + '}';
    }
    
}
