/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GiocatoriDadi;

/**
 *
 * @author Mattia Checchetto
 */
public class Giocatore {
    private String nome;
    private int punteggio;

    public Giocatore(String nome) {
        this.nome = nome;
        this.punteggio = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void addPunteggio() {
        this.punteggio = punteggio+1;
    }

    @Override
    public String toString() {
        return "Giocatore{" + "nome=" + nome + ", punteggio=" + punteggio + '}';
    }
    
    
    
}
