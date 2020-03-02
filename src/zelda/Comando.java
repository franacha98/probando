/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zelda;

/**
 *
 * @author Fran
 */
public class Comando {
    private String comando;
    private String segundaPalabra;
    
    public Comando(String comando, String segundaPalabra){
        this.comando=comando;
        this.segundaPalabra=segundaPalabra;
    }

    public String getComando() {
        return comando;
    }

    public String getSegundaPalabra() {
        return segundaPalabra;
    }
    
    public boolean hayComando(){
        return comando==null;
    }
    
    public boolean haySegundaPalabra(){
        return segundaPalabra==null;
    }
    
}
