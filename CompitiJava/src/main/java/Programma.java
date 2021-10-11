/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author matti
 */
public class Programma {
    private String denominazione;
    private String produttore;
    private String versione;
    private String os;
    private int anno;

    public Programma(String denominazione, String produttore, String versione, String os, int anno) {
        this.denominazione = denominazione;
        this.produttore = produttore;
        this.versione = versione;
        this.os = os;
        this.anno = anno;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public String getProduttore() {
        return produttore;
    }

    public void setProduttore(String produttore) {
        this.produttore = produttore;
    }

    public String getVersione() {
        return versione;
    }

    public void setVersione(String versione) {
        this.versione = versione;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }
    
    @Override
    public String toString(){
        return("Denominazione: "+denominazione+"\nProduttore: "+produttore+"\nVersione: "+versione+"\nSistema operativo: "+os+"\nAnno: "+anno);
    }
    
    public String compareAnno(int anno,String denominazione){
        if(this.anno>anno){
            return("Il programma "+this.denominazione+" è più recente del programma "+denominazione);
        }else if(this.anno<anno){
            return("Il programma "+this.denominazione+" è più vecchio del programma "+denominazione);
        }else if(this.anno==anno){
            return("Il programma "+this.denominazione+" è dello stesso anno del programma "+denominazione);
        }else{
            return("ERRORE");
        }
    }
}
