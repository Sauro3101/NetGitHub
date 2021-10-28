package concessionario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mattia Checchetto
 */
public class ConsoleInputConException {

    BufferedReader reader;
    /**
     * Costruisce un oggetto di tipo BufferedReader sopra lo standard input
     * (System.in).
     */
    public ConsoleInputConException(){
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Legge una riga in input e la converte in un valore intero: la linea deve
     * contenere un solo valore intero eventualmente preceduto dal segno, ma
     * senza altri caratteri.
     *
     * @return valore intero digitato
     */
    public int readInt()  {
        try {
            return Integer.parseInt(reader.readLine());
        } catch (Exception ex) {
            System.out.println("ERROR nel formato del numero "+ex.getMessage());
            System.exit(-1);
            return 0;
        }
    }

    /**
     * Legge una riga in input e la converte in un valore floating-point: la
     * linea deve contenere un solo valore decimale eventualmente preceduto dal
     * segno, ma senza altri caratteri.
     *
     * @return valore decimale digitato
     */
    public double readDouble()  {
        try {
            return Double.parseDouble(reader.readLine());
        } catch (IOException ex) {
            Logger.getLogger(ConsoleInputConException.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    /**
     * Legge una riga di testo in input.
     *
     * @return stringa digitata
     */
    public String readLine()  {
        try {
            return reader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(ConsoleInputConException.class.getName()).log(Level.SEVERE, null, ex);
            return " ";
        }
    }

    /**
     * Legge una riga di testo in input.
     *
     * @return il primo carattere della stringa letta
     */

    public char readChar()  {
        try {
            return reader.readLine().charAt(0);
        } catch (IOException ex) {
            Logger.getLogger(ConsoleInputConException.class.getName()).log(Level.SEVERE, null, ex);
            return ' ';
        }
    }
}
