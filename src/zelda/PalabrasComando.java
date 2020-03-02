/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zelda;

import java.util.*;

/**
 *
 * @author Fran
 */
public class PalabrasComando {
    private HashSet<String> comandos;
    
    public PalabrasComando(){
        comandos=new HashSet();
        añadirComandos();
    }
    
    public boolean esComando(String s){
       return comandos.contains(s.toLowerCase()); 
    }
    
    public void mostrarTodos(){
        System.out.println(comandos.toString());
       
    }
    
    private void añadirComandos(){
        comandos.add("ir");
        comandos.add("ayuda");
        comandos.add("fin");
    }
}
