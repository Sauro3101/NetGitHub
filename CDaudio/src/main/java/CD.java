/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author matti
 */
public class CD {
    private String titolo;
    private String autore;
    private int numero_brani;
    private double durata;

    public CD(String titolo, String autore, int numero_brani, double durata) {
        this.titolo = titolo;
        this.autore = autore;
        this.numero_brani = numero_brani;
        this.durata = durata;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public int getNumero_brani() {
        return numero_brani;
    }

    public void setNumero_brani(int numero_brani) {
        this.numero_brani = numero_brani;
    }

    public double getDurata() {
        return durata;
    }

    public void setDurata(double durata) {
        this.durata = durata;
    }
    
    @Override
    public String toString(){
        return("Titolo: "+titolo+"\nAutore: "+autore+"\nNumero brani: "+numero_brani+"\nDurata: "+durata+" minuti");
    }
    
    public String compareDurata(double durata,String titolo){
        if(this.durata>durata){
            return("Il CD "+this.titolo+" dura di più del CD "+titolo);
        }else if(this.durata<durata){
            return("Il CD "+this.titolo+" dura di meno del CD "+titolo);
        }else if(this.durata==durata){
            return("Il CD "+this.titolo+" dura quanto il CD "+titolo);
        }else{
            return("ERRORE");
        }
    }
    
    
}
