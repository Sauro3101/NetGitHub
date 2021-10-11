/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author matti
 */
public class testComputer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int a=1;
        
        Computer c1=new Computer(a,"Acer","Swift",1.1,4096,131072,14,2018);
        a++;
        Computer c2=new Computer(a,"Huawei","MateBook",2.1,8192,262144,15,2019);
        a++;
        Computer c3=new Computer(a,"HP","Pavillon",2,8192,262144,14,2017);
        
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
        
    }
    
    
}
