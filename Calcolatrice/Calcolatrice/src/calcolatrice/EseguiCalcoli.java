/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcolatrice;

/**
 *
 * @author Studente Turno B
 */
public class EseguiCalcoli {
    public float calcola(String s3, float primo, float secondo){
        
        float ris = 0;
        
        switch (s3) {
            case "+":
                ris = primo + secondo;
                break;
            case "-":
                ris = primo - secondo;
                break;
            case "/":
                ris = primo / secondo;
                break;
            case "*":
                ris = primo * secondo;
                break;
            default:
                break;
        }
        return ris;
    }
}
