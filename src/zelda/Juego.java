/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zelda;

import java.util.Scanner;

/**
 *
 * @author Fran
 */
public class Juego {

    private Transformar transformar;
    private Habitacion habitacionActual;
    private int bucle;
    
    public Juego() {
        bucle=0;
        transformar = new Transformar();
        crearHabitaciones();
    }

    public void crearHabitaciones() {
        Habitacion hab1 = new Habitacion("Salida NORTE 1");
        Habitacion hab2 = new Habitacion("Salida ESTE 1");
        Habitacion hab7 = new Habitacion("Salida OESTE 2");
        Habitacion inicial=new Habitacion("Habitacion inicial");
        Habitacion tesoro=new Habitacion("Salida NORTE 3");
        
        inicial.setSalida("salidaNorte", hab1);
        inicial.setSalida("salidaEste", hab2);
        hab1.setSalida("salidaOeste", hab7);
        hab2.setSalida("salidaOeste", inicial);
        hab7.setSalida("salidaEste", hab1);
        hab1.setSalida("salidaSur", inicial);
        hab7.setSalida("salidaNorte", tesoro);
        tesoro.setSalida("salidaSur", hab7);
        habitacionActual=inicial;
    }

    private void bienvenido() {
        System.out.println();
        System.out.println("Bienvenido a The legend of Zelda!");
        System.out.println("Eres Link y tu mision sera encontrar el tesoro del Castillo de Hyrule para rescatar a la Princesa Zelda.");
        System.out.println("Si necesitas ayuda escribe 'ayuda'.");
        System.out.println();

        habitacionActual.getDescripcionLarga();
    }
    
    public void jugar(){
        bienvenido();
        
        while(bucle==0){
            if(procesarComando(transformar.getCommand())){
                System.out.println("");
                if(habitacionActual.getDescripcion().equals("Salida NORTE 3")){
                    System.out.println("HAS ENCONTRADO EL TESORO!!!!!");
                    break;
                }
            }else{                
                System.out.println("Comando o lugar no es válido.");
            }
            
        }
        
    }
    
    private boolean procesarComando(Comando c){
        PalabrasComando palabra=new PalabrasComando();
           
        if(!palabra.esComando(c.getComando())){
            return false;
        }
        
        if(c.getComando().equalsIgnoreCase("ir")){
            irA(c);
        }
        if(c.getComando().equalsIgnoreCase("ayuda")){
            ayuda();
        }
        if(c.getComando().equalsIgnoreCase("fin")){
            fin(c);
        }
        if(c.getComando().equalsIgnoreCase("ayuda") || c.getComando().equalsIgnoreCase("fin")){
            return true;
        }
        if(!transformar.getLugares().contains(c.getSegundaPalabra())){
            return false;
        }
        return true;
        
    }
    
    private void ayuda(){
        habitacionActual.getDescripcionLarga();
    }
    
    private void irA(Comando c){
        Habitacion aux;
        
            if(c.getSegundaPalabra().equalsIgnoreCase("norte")){
                aux=habitacionActual.getSalida("norte");
                habitacionActual=aux;
            }
            if(c.getSegundaPalabra().equalsIgnoreCase("sur")){
                aux=habitacionActual.getSalida("sur");
                habitacionActual=aux;
            }
            if(c.getSegundaPalabra().equalsIgnoreCase("este")){
                aux=habitacionActual.getSalida("este");
                habitacionActual=aux;
            }
            if(c.getSegundaPalabra().equalsIgnoreCase("oeste")){
                aux=habitacionActual.getSalida("oeste");
                habitacionActual=aux;
            }           
        habitacionActual.getDescripcionLarga();
    }
    
    
    private void fin(Comando c){
        Scanner sc=new Scanner(System.in);
        
        System.out.println("¿Está seguro de que quiere finalizar? S/N");
        if(sc.next().equalsIgnoreCase("s")){
            bucle=1;
        }
        
        
    }
}
