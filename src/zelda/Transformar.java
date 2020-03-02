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
public class Transformar {

    private Comando palabraComando;
    private HashSet<String> lugares;

    public Transformar() {
        lugares = new HashSet();
        añadirLugares();
        palabraComando = null;
    }

    public Comando getCommand() {
        String auxCom, auxLug;
        Scanner sc = new Scanner(System.in);
        
        
        System.out.print("Introduce un comando: "
                + "[Ir - Ayuda - Fin]: ");
        auxCom = sc.next();
        
        if(!auxCom.equalsIgnoreCase("ir")){         
            palabraComando = new Comando(auxCom,null);
            return palabraComando; 
        }
        System.out.print("Introduce el lugar al que te quieres dirigir: "
                + "[norte - sur - este - oeste]: ");
        auxLug = sc.next();

        

        palabraComando = new Comando(auxCom, auxLug);
        return palabraComando;
    }

    private void añadirLugares() {
        lugares.add("norte");
        lugares.add("sur");
        lugares.add("este");
        lugares.add("oeste");
    }
    
    public HashSet<String> getLugares(){
        return lugares;
    }
}
