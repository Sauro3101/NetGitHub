/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author matti
 */
public class testCD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CD cd1=new CD("Saints of los angeles","Motley Crue",13,44.08);
        CD cd2=new CD("÷ (Deluxe)","Ed Sheeran",16,59.33);
        CD cd3=new CD("Playlist","Salmo",13,38.23);
        
        System.out.println(cd1.toString());
        System.out.println(cd2.toString());
        System.out.println(cd3.toString());
        
        System.out.println(cd1.compareDurata(cd2.getDurata(), cd2.getTitolo()));
        System.out.println(cd2.compareDurata(cd3.getDurata(), cd3.getTitolo()));
        System.out.println(cd3.compareDurata(cd1.getDurata(), cd1.getTitolo()));
        
        
    }
    
}
