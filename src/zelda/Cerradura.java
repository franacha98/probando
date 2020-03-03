/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zelda;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Fran
 */
public class Cerradura extends JFrame{
    private int codigo;
    private JButton tecla7;
    private JButton tecla8;
    private JButton tecla9;
    private JButton tecla4;
    private JButton tecla5;
    private JButton tecla6;
    private JButton tecla3;
    private JButton tecla0;
    private JButton tecla1;
    private JButton tecla2;
    private JTextField texto;
    private BorderLayout bl;
    private GridLayout grid;
    private GridLayout grid2;
    private JPanel norte;
    private JPanel central;
    
    public Cerradura(int numero){
        tecla7 = new JButton("7");
        tecla8 = new JButton("8");
        tecla9 = new JButton("9");
        tecla4 = new JButton("4");
        tecla5 = new JButton("5");
        tecla6 = new JButton("6");
        tecla3 = new JButton("3");
        tecla2 = new JButton("2");
        tecla1 = new JButton("1");
        tecla0 = new JButton("0");
        norte=new JPanel();
        central=new JPanel();
        bl=new BorderLayout();
        texto=new JTextField("0");
        grid=new GridLayout(3,3);
        grid2=new GridLayout(1,1);
        
        getContentPane().setLayout(bl);
        getContentPane().add(norte,bl.NORTH);
        getContentPane().add(central,bl.CENTER);
        
        norte.setLayout(grid2);
        central.setLayout(grid);
        
        norte.add(texto);
        
        central.add(tecla7);
        central.add(tecla8);
        central.add(tecla9);
        central.add(tecla4);
        central.add(tecla5);
        central.add(tecla6);
        central.add(tecla1);
        central.add(tecla2);
        central.add(tecla3);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }
    
}
