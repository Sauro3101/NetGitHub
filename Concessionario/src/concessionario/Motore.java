/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concessionario;

/**
 *
 * @author Mattia Checchetto
 */
public class Motore {
    private int nCilindri;
    private int cilindrata;
    private int cv;
    private int nm;

    public Motore(int nCilindri, int cilindrata, int cv, int nm) {
        this.nCilindri = nCilindri;
        this.cilindrata = cilindrata;
        this.cv = cv;
        this.nm = nm;
    }

    public int getnCilindri() {
        return nCilindri;
    }

    public void setnCilindri(int nCilindri) {
        this.nCilindri = nCilindri;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public int getNm() {
        return nm;
    }

    public void setNm(int nm) {
        this.nm = nm;
    }

    @Override
    public String toString() {
        return "Motore{" + "nCilindri=" + nCilindri + ", cilindrata=" + cilindrata + ", cv=" + cv + ", nm=" + nm + '}';
    }
    
}
