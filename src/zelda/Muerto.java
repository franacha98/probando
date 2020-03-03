/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zelda;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Vespertino
 */
public class Muerto extends JFrame{
    private JPanel panel;
    private JLabel fondo;
    private BorderLayout bl;
    public Muerto(){
        panel=new JPanel();
        fondo=new JLabel();
        bl=new BorderLayout();
        
        getContentPane().setLayout(bl);
        getContentPane().add(panel,bl.CENTER);
        
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("zelda3.gif")));
        panel.add(fondo);
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(new java.awt.Point(780, 280));
        pack();
    }
    
}
