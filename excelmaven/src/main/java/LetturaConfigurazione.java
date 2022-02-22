/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Mattia Checchetto
 */
public class LetturaConfigurazione {
    
    private boolean stampa = false;
    
    public void leggiFileConfig() throws FileNotFoundException, IOException{

        BufferedReader reader = new BufferedReader(new FileReader("./src/main/java/Config.txt"));

        
        ArrayList tracciatoLetturaRecordC = new ArrayList();
        ArrayList tracciatoLetturaRecordB = new ArrayList();
        ArrayList tracciatoLetturaRecordMD = new ArrayList();
        ArrayList tracciatoLetturaConfigurazione = new ArrayList();
        
        CorrispondenzaCampi cc = new CorrispondenzaCampi();
;
        
        String lettura = null;
        String s;
        String interfaccia;
        
        int cont = 1;
        int i;
        
        interfaccia = reader.readLine();
        if(!stampa){
            System.out.println("Interfaccia: " + interfaccia + "\n");
        }
        
        s = reader.readLine();
        
        /*
        String codiceAccisa = reader.readLine();
        String dataElaborazione = reader.readLine();
        String oraElaborazione = reader.readLine();
        String versione = reader.readLine();
        String recordErrato = reader.readLine();
        String tipoRecord = reader.readLine();
        reader.readLine();*/   
        
        while(!s.isBlank()){
            CorrispondenzaCampi ccrc = new CorrispondenzaCampi();
            ccrc.setCampoExcel(Integer.parseInt(s.substring(0, s.indexOf("Â"))));
            ccrc.setCampoTesto(Integer.parseInt(s.substring(s.indexOf("§") + 1)));
            tracciatoLetturaConfigurazione.add(ccrc);
            s = reader.readLine();
            if(s == null || s.isBlank()){
                s = " ";
            }
        }

        
        
        s = interfaccia;
        
        while(s!=null) {
            s = reader.readLine();
            
            if(s != null){
                
                if(s.compareToIgnoreCase("recordc") == 0){
                    
                    s = reader.readLine();
                    
                    while(!s.isBlank()){
                        CorrispondenzaCampi ccrc = new CorrispondenzaCampi();
                        ccrc.setCampoExcel(Integer.parseInt(s.substring(0, s.indexOf("Â"))));
                        ccrc.setCampoTesto(Integer.parseInt(s.substring(s.indexOf("§") + 1)));
                        tracciatoLetturaRecordC.add(ccrc);
                        s = reader.readLine();
                        if(s == null){
                            s = " ";
                        }
                    }
                }
                if(s.compareToIgnoreCase("recordb") == 0){
                    
                    s = reader.readLine();
                    
                    while(!s.isBlank()){
                        CorrispondenzaCampi ccrb = new CorrispondenzaCampi();
                        ccrb.setCampoExcel(Integer.parseInt(s.substring(0, s.indexOf("Â"))));
                        ccrb.setCampoTesto(Integer.parseInt(s.substring(s.indexOf("§") + 1)));
                        tracciatoLetturaRecordB.add(ccrb);
                        s = reader.readLine();
                        if(s == null){
                            s = " ";
                        }
                    }
                }
                if(s.compareToIgnoreCase("recordmd") == 0){
                    
                    s = reader.readLine();
                    
                    while(!s.isBlank()){
                        CorrispondenzaCampi ccrmd = new CorrispondenzaCampi();
                        ccrmd.setCampoExcel(Integer.parseInt(s.substring(0, s.indexOf("Â"))));
                        ccrmd.setCampoTesto(Integer.parseInt(s.substring(s.indexOf("§") + 1)));
                        tracciatoLetturaRecordMD.add(ccrmd);
                        s = reader.readLine();
                        if(s == null){
                            s = " ";
                        }
                    }
                }
                
                
                
                cont++;
                
                /*
                if(stampa){
                System.out.println("Riga " + cont + ": " + s);
                
                System.out.println("Riga " + cont + ": Excel: " + ee.getCampoExcel() + " Testo: " + ee.getCampoTesto());
                }
                */
                
            }
        }
        
        if(stampa){
            System.out.println("\n\n\n");
        
            for(i = 0; i < cont; i++){
                cc = (CorrispondenzaCampi) tracciatoLetturaRecordC.get(i);
                System.out.println("Riga " + (i+1) + ": Excel: " + cc.getCampoExcel() + " Testo: " + cc.getCampoTesto());

            }
        }
        tracciatoLetturaConfigurazione = ordinaExcel(tracciatoLetturaConfigurazione);
        tracciatoLetturaRecordC = ordinaExcel(tracciatoLetturaRecordC);
        tracciatoLetturaRecordB = ordinaExcel(tracciatoLetturaRecordB);
        tracciatoLetturaRecordMD = ordinaExcel(tracciatoLetturaRecordMD);
        
        if(!stampa){
            
            System.out.println("\n\n\nCONFIGURAZIONE");
            
        
            for(i = 0; i < tracciatoLetturaConfigurazione.size(); i++){
                
                CorrispondenzaCampi ccs;
                ccs = (CorrispondenzaCampi) tracciatoLetturaConfigurazione.get(i);
                System.out.println("Riga " + (i+1) + ": Excel: " + ccs.getCampoExcel() + " Testo: " + ccs.getCampoTesto());

            }
            System.out.println("\n\n\nRECORD C");
            
        
            for(i = 0; i < tracciatoLetturaRecordC.size(); i++){
                
                CorrispondenzaCampi ccs;
                ccs = (CorrispondenzaCampi) tracciatoLetturaRecordC.get(i);
                System.out.println("Riga " + (i+1) + ": Excel: " + ccs.getCampoExcel() + " Testo: " + ccs.getCampoTesto());

            }
            System.out.println("\n\n\nRECORD B");
            
            for(i = 0; i < tracciatoLetturaRecordB.size(); i++){
                
                CorrispondenzaCampi ccs;
                ccs = (CorrispondenzaCampi) tracciatoLetturaRecordB.get(i);
                System.out.println("Riga " + (i+1) + ": Excel: " + ccs.getCampoExcel() + " Testo: " + ccs.getCampoTesto());

            }
            System.out.println("\n\n\nRECORD MD");
        
            for(i = 0; i < tracciatoLetturaRecordMD.size(); i++){
                
                CorrispondenzaCampi ccs;
                ccs = (CorrispondenzaCampi) tracciatoLetturaRecordMD.get(i);
                System.out.println("Riga " + (i+1) + ": Excel: " + ccs.getCampoExcel() + " Testo: " + ccs.getCampoTesto());

            }
            
        }
        
        
    }
    
    public ArrayList ordinaExcel(ArrayList a){
        
        for(int i = 0; i < a.size(); i++){
            
            for(int j = i+1; j < a.size(); j++){
                
                CorrispondenzaCampi primo = (CorrispondenzaCampi) a.get(i);
                CorrispondenzaCampi secondo = (CorrispondenzaCampi) a.get(j);
                CorrispondenzaCampi appo;
                
                if(primo.getCampoTesto() > secondo.getCampoTesto()){
                    appo = primo;
                    a.set(i, secondo);
                    a.set(j, primo);
                }
                
                
            }

        }
        
        return a;
    }
}
