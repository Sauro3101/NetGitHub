





import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cinzi
 */
public class InputEx {

    BufferedReader reader;
    /**
     * Costruisce un oggetto di tipo BufferedReader sopra lo standard input
     * (System.in).
     */
    public InputEx(){
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
            //System.out.println("ERROR nel formato del numero "+ex.getMessage());
            //System.exit(0);
            //return 0;
            return -1;
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
            Logger.getLogger(InputEx.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(InputEx.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(InputEx.class.getName()).log(Level.SEVERE, null, ex);
            return ' ';
        }
    }
    public Date getDdaInput(String s) throws ParseException {
        Date d;
        do {
            //si procura la data sotto forma di una stringa nel formato SHORT
            //System.out.println("Inserisci la data [gg/mm/yy]: ");
            try {
                //converte la stringa della data in un oggetto di classe Date
                SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
                d = formato.parse(s);
                //crea un oggetto 'formattatore' fissando un pattern
                formato = new SimpleDateFormat("dd/MM/yyyy");
                //visualizza la data formattata secondo il pattern fissato
                //System.out.println("OUTPUT: " + formato.format(d));
                break; //esce dal ciclo       

            } catch (ParseException e) {
                return null;
            }

        } while (true);
        return d;
    }
    
    
    public Date getHdaInput(String s) throws ParseException {
        Date d;
        do {
            //si procura la data sotto forma di una stringa nel formato SHORT
            //System.out.println("Inserisci la data [gg/mm/yy]: ");
            try {
                //converte la stringa della data in un oggetto di classe Date
                SimpleDateFormat formato = new SimpleDateFormat("HHmmss");
                d = formato.parse(s);
                //crea un oggetto 'formattatore' fissando un pattern
                formato = new SimpleDateFormat("hh:mm:ss");
                //visualizza la data formattata secondo il pattern fissato
                //System.out.println("OUTPUT: " + formato.format(d));
                break; //esce dal ciclo       

            } catch (ParseException e) {
                return null;
            }

        } while (true);
        return d;
    }
    
    public int controlloInteri(String s){
        
        if(s.isBlank()){
            return -0;
        }
        try{
            return Integer.parseInt(s);
        }catch(NumberFormatException e){
            return -1;
        }
    }
    
    public String verificoSN(String s){
        
        if(s.compareToIgnoreCase("n") == 0 || s.compareToIgnoreCase("s") == 0){
            return s;
        }else{
            return "-1";
        }
    }
    
    public String verificoTipoRecord(String s){
        
        if(s.compareToIgnoreCase("recordc ") == 0 || s.compareToIgnoreCase("recordb ") == 0 || s.compareToIgnoreCase("recordmd") == 0){
            return s;
        }else{
            return "-1";
        }
    }
    
    public String verificoIA(String s){
        
        if(s.isBlank()){
            return "0";
        }
        
        if(s.compareToIgnoreCase("A") == 0 || s.compareToIgnoreCase("I") == 0){
            return s;
        }else{
            return "-1";
        }
        
    }
    
    public String verificoIT(String s){
        
        if(s.isBlank()){
            return "0";
        }
        
        if(s.compareToIgnoreCase("T") == 0 || s.compareToIgnoreCase("I") == 0){
            return s;
        }else{
            return "-1";
        }
        
    }
    
    public String verificoTipoRichiesta(String s){
        if(s.compareToIgnoreCase("C") == 0 || s.compareToIgnoreCase("I") == 0){
            return s;
        }else{
            return "-1";
        }
    }
    
    public double convertoDecimale(String s, int x, int y){
        if(s.isBlank()){
            return -0;
        }
        try{
            String intero = s.substring(0, x);
            String decimale = "0.".concat(s.substring(x));
            double parteIntera = Integer.parseInt(intero);
            double parteDecimale = Double.parseDouble(decimale);
            double tot = parteIntera + parteDecimale;
            //System.out.println(intero + " " + decimale + " " + parteIntera + " " + parteDecimale + " " + tot);
            return tot;
        }catch(Exception e){
            return -1;
        }
    }
    
    public String verificoTipoMittenteDestinatario(String s){
        
        if(s.compareToIgnoreCase("M ") == 0 || s.compareToIgnoreCase("D ") == 0 || s.compareToIgnoreCase("E") == 0){
            return s;
        }else{
            return "-1";
        }
    }
    
    public int verificoStringObbligatorio(String s){
        
        if(s.isBlank()){
            return -1;
        }
        
        return 1;
    }
    
    public int verificoNumeroObbligatorio(double s){
        
        if(s == 0){
            return -1;
        }
        
        return 1;
    }
    
    public int verificoStringObbligatorioSe(String n, String s){
        
        if(verificoStringObbligatorio(s) == 1){
            if(n.isBlank()){
                return -1;
            }

            return 1;
        }
        
        return 1;
        
    }
    
    public int verificoNumeroObbligatorioSe(double n, double s){
        
        if(verificoNumeroObbligatorio(s) == 1){
            if(n == 0){
                return -1;
            }

            return 1;
        }
        
        return 1;
    }
    
    public int verificoStringAssente(String s){
        
        if(!s.isBlank()){
            return -1;
        }
        
        return 1;
    }

}
