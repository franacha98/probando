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
public class Habitacion {
    private String descripcion;
    private Habitacion salidaNorte;
    private Habitacion salidaSur;
    private Habitacion salidaEste;
    private Habitacion salidaOeste;
    private boolean descubierta;
    
    public Habitacion(String descripcion){
        this.descripcion=descripcion;
        descubierta=false;
    }
    
    public void setSalida(String direccion, Habitacion habitacion){
        if(!comprobarDireccion(direccion)){           
            System.out.println("Direccion incorrecta");
        }else{
            
            if(comprobarSalida(direccion)==1){
                salidaNorte=habitacion;
            }
            if(comprobarSalida(direccion)==2){
                salidaSur=habitacion;
            }
            if(comprobarSalida(direccion)==3){
                salidaEste=habitacion;
            }
            if(comprobarSalida(direccion)==4){
                salidaOeste=habitacion;
            }
        }      
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public void getDescripcionLarga(){
        StringBuilder sb=new StringBuilder();
        sb.append("Estás en "+this.getDescripcion()+" y las salidas posibles son: \n");
        if(salidaNorte!=null){
            sb.append("- Salida norte\n");
        }
        if(salidaSur!=null){
            sb.append("- Salida sur\n");
        }
        if(salidaEste!=null){
            sb.append("- Salida este\n");
        }
        if(salidaOeste!=null){
            sb.append("- Salida oeste\n");
        }
        
        System.out.println(sb.toString());
    }
    
    public String getStringDeSalidas(){
        StringBuilder sb=new StringBuilder();
        
        sb.append("Salidas posibles: \n");
        if(salidaNorte!=null){
            sb.append("-"+salidaNorte.getDescripcion()+"\n");
        }
        if(salidaSur!=null){
            sb.append("-"+salidaSur.getDescripcion()+"\n");
        }
        if(salidaEste!=null){
            sb.append("-"+salidaEste.getDescripcion()+"\n");
        }
        if(salidaOeste!=null){
            sb.append("-"+salidaOeste.getDescripcion()+"\n");
        }
        return sb.toString();
    }
    
    public Habitacion getSalida(String direccion){
        if(comprobarSalida(direccion)==1){
            return salidaNorte;
        }
        if(comprobarSalida(direccion)==2){
            return salidaSur;
        }
        if(comprobarSalida(direccion)==3){
            return salidaEste;
        }
        if(comprobarSalida(direccion)==4){
            return salidaOeste;
        }
        return null;
    }
    
    
    private int comprobarSalida(String direccion){
        if(direccion.equalsIgnoreCase("salidanorte") || direccion.equalsIgnoreCase("norte")){
            return 1;
        }
        if(direccion.equalsIgnoreCase("salidasur") || direccion.equalsIgnoreCase("sur")){
            return 2;
        }
        if(direccion.equalsIgnoreCase("salidaeste") || direccion.equalsIgnoreCase("este")){
            return 3;
        }
        if(direccion.equalsIgnoreCase("salidaoeste") || direccion.equalsIgnoreCase("oeste")){
            return 4;
        }
        return 0;
    }
    public void descubrirHabitacion(){
        descubierta=true;
    }

    public boolean isDescubierta() {
        return descubierta;
    }
    
    private boolean comprobarDireccion(String direccion){
         if(direccion.equalsIgnoreCase("salidanorte")
         || direccion.equalsIgnoreCase("salidasur")
         || direccion.equalsIgnoreCase("salidaoeste")
         || direccion.equalsIgnoreCase("salidaeste")
         || direccion.equalsIgnoreCase("norte")
         || direccion.equalsIgnoreCase("sur")
         || direccion.equalsIgnoreCase("este")
         || direccion.equalsIgnoreCase("oeste")){
            return true;
        }else{
            return false;
        }
    }  
}
