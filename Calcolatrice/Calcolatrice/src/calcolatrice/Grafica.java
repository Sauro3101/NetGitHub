/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcolatrice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author matti
 */
public class Grafica implements ActionListener {
    
    private JFrame f = new JFrame("Calcolatrice");
    private JPanel pDisp = new JPanel();
    private JPanel pTasti = new JPanel();
    private Container c = new Container();
    private JButton b1 = new JButton("1");
    private JButton b2 = new JButton("2");
    private JButton b3 = new JButton("3");
    private JButton b4 = new JButton("4");
    private JButton b5 = new JButton("5");
    private JButton b6 = new JButton("6");
    private JButton b7 = new JButton("7");
    private JButton b8 = new JButton("8");
    private JButton b9 = new JButton("9");
    private JButton b0 = new JButton("0");
    private JButton bEq = new JButton("=");
    private JButton bDel = new JButton("C");
    private JButton bP = new JButton("+");
    private JButton bM = new JButton("-");
    private JButton bMol = new JButton("*");
    private JButton bDiv = new JButton("/");
    private JButton bPoint = new JButton(".");
    private JTextField txtfld = new JTextField("                    ");
    private String s1 = "";
    private String s2 = "";
    private String s3 = "";
    private float primo;
    private float secondo;
    private float ris;
    
    public void visualizza(){
        
        pDisp.setSize(txtfld.size());
        pDisp.setBackground(Color.red);
        pDisp.add(txtfld);
        pTasti.setLayout(new GridLayout(4,4));
        
        txtfld.setEditable(false);
        txtfld.setFont(new Font("Arial", 0, 36));
        
        pTasti.add(b1);
        pTasti.add(b2);
        pTasti.add(b3);
        pTasti.add(bP);
        
        pTasti.add(b4);
        pTasti.add(b5);
        pTasti.add(b6);
        pTasti.add(bM);
        
        pTasti.add(b7);
        pTasti.add(b8);
        pTasti.add(b9);
        pTasti.add(bMol);
        
        pTasti.add(b0);
        pTasti.add(bDel);
        pTasti.add(bPoint);
        pTasti.add(bDiv);
        
        pTasti.add(bEq);
        
        f.add(pDisp, BorderLayout.NORTH);
        f.add(pTasti, BorderLayout.SOUTH);
        f.setSize(300, 400);
        f.setLocation(200,100);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        
        b0.addActionListener(this);
        bP.addActionListener(this);
        bM.addActionListener(this);
        
        bDiv.addActionListener(this);
        bMol.addActionListener(this);
        bDel.addActionListener(this);
        bEq.addActionListener(this);
        
        bPoint.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            s1 = s1.concat("1");
            s2 = s2.concat("1");
            txtfld.setText(s1);
            txtfld.updateUI();
        }
        if(e.getSource() == b2){
            s1 = s1.concat("2");
            s2 = s2.concat("2");
            txtfld.setText(s1);
            txtfld.updateUI();
        }
        if(e.getSource() == b3){
            s1 = s1.concat("3");
            s2 = s2.concat("3");
            txtfld.setText(s1);
            txtfld.updateUI();
        }
        if(e.getSource() == b4){
            s1 = s1.concat("4");
            s2 = s2.concat("4");
            txtfld.setText(s1);
            txtfld.updateUI();
        }
        if(e.getSource() == b5){
            s1 = s1.concat("5");
            s2 = s2.concat("5");
            txtfld.setText(s1);
            txtfld.updateUI();
        }
        if(e.getSource() == b6){
            s1 = s1.concat("6");
            s2 = s2.concat("6");
            txtfld.setText(s1);
            txtfld.updateUI();
        }
        if(e.getSource() == b7){
            s1 = s1.concat("7");
            s2 = s2.concat("7");
            txtfld.setText(s1);
            txtfld.updateUI();
        }
        if(e.getSource() == b8){
            s1 = s1.concat("8");
            s2 = s2.concat("8");
            txtfld.setText(s1);
            txtfld.updateUI();
        }
        if(e.getSource() == b9){
            s1 = s1.concat("9");
            s2 = s2.concat("9");
            txtfld.setText(s1);
            txtfld.updateUI();
        }
        if(e.getSource() == b0){
            s1 = s1.concat("0");
            s2 = s2.concat("0");
            txtfld.setText(s1);
            txtfld.updateUI();
        }
        if(e.getSource() == bPoint){
            s1 = s1.concat(".");
            s2 = s2.concat("."
                    + ""
                    + ""
                    + "");
            txtfld.setText(s1);
            txtfld.updateUI();
        }
        if(e.getSource() == bP){
            primo = Float.parseFloat(s1);
            s1 = s1.concat("+");
            s2 = "";
            s3 = "+";
            txtfld.setText(s1);
            txtfld.updateUI();
        }
        if(e.getSource() == bM){
            primo = Float.parseFloat(s1);
            s1 = s1.concat("-");
            s2 = "";
            s3 = "-";
            txtfld.setText(s1);
            txtfld.updateUI();
        }
        if(e.getSource() == bDiv){
            primo = Float.parseFloat(s1);
            s1 = s1.concat("/");
            s2 = "";
            s3 = "/";
            txtfld.setText(s1);
            txtfld.updateUI();
        }
        if(e.getSource() == bMol){
            primo = Float.parseFloat(s1);
            s1 = s1.concat("*");
            s2 = "";
            s3 = "*";
            txtfld.setText(s1);
            txtfld.updateUI();
        }
        if(e.getSource() == bEq){
            secondo = Float.parseFloat(s2);
            s2 = "";
            EseguiCalcoli exx = new EseguiCalcoli();
            ris = exx.calcola(s3, primo, secondo);
            s1 = String.valueOf(ris);
            txtfld.setText(s1);
            txtfld.updateUI();
            s1 = "";
        }
        if(e.getSource() == bDel){
            s1 = s1.substring(0, (s1.length()-1));
            s2 = s2.substring(0, (s2.length()-1));
            txtfld.setText(s1);
            txtfld.updateUI();
        }
    }
    
}
