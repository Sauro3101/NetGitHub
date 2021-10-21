/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provaleggo;

import java.io.*;

/**
 *
 * @author cinzi
 */

public class ConsoleInput {
  BufferedReader reader;
/**
* Costruisce un oggetto di tipo BufferedReader sopra lo
* standard input (System.in).
*/
 public ConsoleInput() {
  reader = new BufferedReader(new InputStreamReader(System.in));
 }
/**
* Legge una riga in input e la converte in un valore intero:
* la linea deve contenere un solo valore intero eventualmente
* preceduto dal segno, ma senza altri caratteri.
* @return valore intero digitato
*/
 public int readInt() throws IOException {
  return Integer.parseInt(reader.readLine());
 }
/**
* Legge una riga in input e la converte in un valore
* floating-point: la linea deve contenere un solo valore
* decimale eventualmente preceduto dal segno, ma senza
* altri caratteri.
* @return valore decimale digitato
*/
 public double readDouble() throws IOException {
  return Double.parseDouble(reader.readLine());
 }
/**
* Legge una riga di testo in input.
* @return stringa digitata
*/
 public String readLine() throws IOException {
  return reader.readLine();
 }
 /**
* Legge una riga di testo in input.
* @return il primo carattere della stringa letta
*/
 
 public char readChar() throws IOException {
  return reader.readLine().charAt(0);
 }
}

