/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Mattia Checchetto
 */
public class CorrispondenzaCampi {
    
    private int campoExcel;
    private int campoTesto;

    public CorrispondenzaCampi(int campoExcel, int campoTesto) {
        this.campoExcel = campoExcel;
        this.campoTesto = campoTesto;
    }

    public CorrispondenzaCampi() {
    }

    public int getCampoExcel() {
        return campoExcel;
    }

    public void setCampoExcel(int campoExcel) {
        this.campoExcel = campoExcel;
    }

    public int getCampoTesto() {
        return campoTesto;
    }

    public void setCampoTesto(int campoTesto) {
        this.campoTesto = campoTesto;
    }

    @Override
    public String toString() {
        return "CorrispondenzaCampi{" + "campoExcel=" + campoExcel + ", campoTesto=" + campoTesto + "}\n";
    }
    
    
}
