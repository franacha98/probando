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
public class Mapa extends JFrame{
    private GridLayout g;
    private BorderLayout bl;
    private JLabel fondo;
    private JPanel panel;
    
    public Mapa(){
        fondo=new JLabel();
        panel=new JPanel();
        g=new GridLayout(1,1);
        bl=new BorderLayout();
        
        getContentPane().setLayout(bl);
        
        getContentPane().add(panel,bl.CENTER);
        panel.setLayout(g);
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("mapa.png")));
        fondo.setBounds(270,10,200,70);
        panel.add(fondo);
        
        setVisible(true);
        
        pack();
    }
    
}
