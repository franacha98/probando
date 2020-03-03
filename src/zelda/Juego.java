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
    private int princesa;
    private CodigoSecreto codigo;

    public Juego() {
        bucle = 0;
        princesa = 0;
        codigo = new CodigoSecreto();
        transformar = new Transformar();
        crearHabitaciones();
    }

    public void crearHabitaciones() {
        Habitacion hab1 = new Habitacion("Habitacion 1");
        Habitacion hab2 = new Habitacion("Habitacion 2");
        Habitacion hab7 = new Habitacion("Habitacion 3");
        Habitacion hab5 = new Habitacion("Habitacion 5");
        Habitacion salida = new Habitacion("Salida");
        Habitacion inicial = new Habitacion("Habitacion inicial");
        Habitacion tesoro = new Habitacion("Habitacion 4");
        Habitacion hab6 = new Habitacion("Habitacion 6");
        Habitacion monstruo = new Habitacion("GAME OVER");
        Habitacion hab8 = new Habitacion("Habitacion 7");

        inicial.setSalida("salidaNorte", hab1);
        inicial.setSalida("salidaOeste", hab2);

        inicial.setSalida("salidaSur", salida);

        hab1.setSalida("salidaOeste", hab7);
        hab1.setSalida("salidaEste", hab5);
        hab5.setSalida("salidaOeste", hab1);
        hab5.setSalida("salidaEste", hab6);
        hab6.setSalida("salidaOeste", hab5);
        hab6.setSalida("salidaNorte", monstruo);
        monstruo.setSalida("salidaSur", hab6);
        hab6.setSalida("salidaSur", hab8);
        hab8.setSalida("salidaNorte", hab6);

        hab2.setSalida("salidaEste", inicial);
        hab2.setSalida("salidaNorte", hab7);
        hab7.setSalida("salidaSur", hab2);

        hab7.setSalida("salidaEste", hab1);
        hab1.setSalida("salidaSur", inicial);
        hab7.setSalida("salidaNorte", tesoro);
        tesoro.setSalida("salidaSur", hab7);
        habitacionActual = inicial;
    }

    private void bienvenido() {
        System.out.println();
        System.out.println("Bienvenido a The legend of Zelda!");
        System.out.println("Eres Link y te acabas de despertar. Te das cuenta de que estás atrapado en el castillo de Hyrule.");
        System.out.println("Estás rodeado por varias puertas, y una de ellas tiene un panel númerico que impide ser abierta. ¿Será la salida?");
        System.out.println("La princesa Zelda se encuentra encerrada en el castillo.");
        
        System.out.println("Tu misión será encontrar y rescatar a la princesa Zelda.");
        System.out.println("Una vez que la encuentes, debes volver a la entrada del castillo.");
        System.out.println("¡¡ Y ten mucho cuidado con las habitaciones monstruos !!");
        System.out.println("Si necesitas ayuda escribe 'ayuda'.");
        System.out.println();

        habitacionActual.getDescripcionLarga();
    }

    public void jugar() {
        bienvenido();

        while (bucle == 0) {
            if (procesarComando(transformar.getCommand())) {
                System.out.println("");
                if (habitacionActual.getDescripcion().equals("Habitacion 4")) {
                    rescatar();
                }
                if (habitacionActual.getDescripcion().equals("GAME OVER")) {
                    System.out.println("OH NO!! UN MOBLIN TE HA ATACADO");
                    System.out.println("GAME OVER");
                    Muerto m = new Muerto();
                    break;
                }
                if (habitacionActual.getDescripcion().equals("Habitacion 7")) {
                    descubrirCodigo();
                }
            } else {
                System.out.println("Comando o lugar no es válido.");
            }

        }

    }

    private void rescatar() {
        if (princesa == 0) {
            System.out.println("HAS ENCONTRADO A LA PRINCESA ZELDA!!!!!");
            System.out.println("Ahora vuelve a la habitación inicial para escapar del castillo");
            princesa = 1;
        }
        ayuda();
    }

    private void descubrirCodigo() {
        System.out.println("HAS ENCONTRADO UN PERGAMINO");
        System.out.println("..." + codigo.getNumeroSecreto() + "...");
        System.out.println("¿Para qué será este número?");
    }

    private boolean procesarComando(Comando c) {
        PalabrasComando palabra = new PalabrasComando();

        if (!palabra.esComando(c.getComando())) {
            return false;
        }

        if (c.getComando().equalsIgnoreCase("ir")) {
            irA(c);
        }
        if (c.getComando().equalsIgnoreCase("ayuda")) {
            ayuda();
        }
        if (c.getComando().equalsIgnoreCase("fin")) {
            fin(c);
        }
        if (c.getComando().equalsIgnoreCase("ayuda") || c.getComando().equalsIgnoreCase("fin")) {
            return true;
        }
        if (!transformar.getLugares().contains(c.getSegundaPalabra())) {
            return false;
        }
        return true;

    }

    private void ayuda() {
        habitacionActual.getDescripcionLarga();
    }

    private void irA(Comando c) {
        Habitacion aux;

        if (c.getSegundaPalabra().equalsIgnoreCase("norte")) {

            aux = habitacionActual.getSalida("norte");
            if (aux == null) {
                System.out.println("Salida incorrecta");
            } else {
                habitacionActual = aux;
            }

        }
        if (c.getSegundaPalabra().equalsIgnoreCase("sur")
                && !habitacionActual.getDescripcion().equals("Habitacion inicial")) {
            aux = habitacionActual.getSalida("sur");
            if (aux == null) {
                System.out.println("Salida incorrecta");
            } else {
                habitacionActual = aux;
            }
        }
        if (c.getSegundaPalabra().equalsIgnoreCase("este")) {
            aux = habitacionActual.getSalida("este");
            if (aux == null) {
                System.out.println("Salida incorrecta");
            } else {
                habitacionActual = aux;
            }
        }
        if (c.getSegundaPalabra().equalsIgnoreCase("oeste")) {
            aux = habitacionActual.getSalida("oeste");
            if (aux == null) {
                System.out.println("Salida incorrecta");
            } else {
                habitacionActual = aux;
            }
        }
        if (habitacionActual.getDescripcion().equals("Habitacion inicial")
                && c.getSegundaPalabra().equalsIgnoreCase("sur")) {

            if (introduceCodigo()) {
                if (princesa == 1) {
                    System.out.println("HAS COMPLETADO LA MISIÓN DE RESCATAR A LA PRINCESA ZELDA");
                    bucle = 1;
                    Ganar g = new Ganar();
                    return;
                } else {
                    System.out.println("Aún no he terminado mi misión aquí... Mejor vuelvo a buscar a la princesa");
                }

            } else {
                System.out.println("Codigo incorrecto");
            }
        }
        habitacionActual.getDescripcionLarga();
    }

    private boolean introduceCodigo() {
        Scanner sc = new Scanner(System.in);
        int code;

        System.out.println("Vaya, parece que hace falta un codigo de 4 digitos para entrar");
        System.out.print("Prueba un codigo: ");
        code = sc.nextInt();
        if (code == codigo.getNumeroSecreto()) {
            return true;
        } else {
            return false;
        }
    }

    private void fin(Comando c) {
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Está seguro de que quiere finalizar? S/N");
        if (sc.next().equalsIgnoreCase("s")) {
            bucle = 1;
        }

    }
}
