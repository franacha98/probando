/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zelda;

import java.util.Random;

/**
 *
 * @author Fran
 */
public class CodigoSecreto {
    
    private int numeroSecreto;
    private boolean descubierto;
    
    public CodigoSecreto(){
        Random r = new Random();
        int aux1,aux2,aux3,aux4;
        
        aux1=r.nextInt(9)*1000;
        aux2=r.nextInt(9)*100;
        aux3=r.nextInt(9)*10;
        aux4=r.nextInt(9);
        numeroSecreto = aux1+aux2+aux3+aux4;
        descubierto=false;
    }

    public boolean isDescubierto() {
        return descubierto;
    }

    public int getNumeroSecreto() {
        return numeroSecreto;
    }
    
    
    public void encontrarPergamino(){
        descubierto=true;
    }
}
