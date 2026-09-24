package com.dam.mvc.view;

import com.dam.mvc.controller.GatitoControlador;

import java.awt.event.ActionEvent;
import java.util.Scanner;

/*
 * La Vista de nuestro MVC. Implementa la interfaz InterfazVista
 * para asegurarnos de que es intercambiable con otras vistas
 * si así se necesita (todas las Vistas implementan esta
 * interfaz = los métodos públicos son los mismos = el programa
 * no se rompe cuando cambias de Vista.
 */
public class GatitoVista implements InterfazVista {

    private final Scanner teclado = new Scanner(System.in);
    private GatitoControlador controlador;

    /*
     * Le indicamos a la Vista qué controlador usaremos
     * para poder pasarle el evento cuando el usuario
     * haga algo.
     */
    public void setControlador(GatitoControlador c) {
        this.controlador = c;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /*
     * Iniciar la vista. Muestra la bienvenida al programa,
     * y entra en el bucle de menú.
     */
    public void init(String nombre, int hambre, int diversion, int amor) {
        mostrarBienvenida(nombre);
        mostrarMenu(nombre, hambre, diversion, amor);
    }

    /*
     * Muestra el estado actual del gatito, y luego se queda
     * esperando a que el usuario elija una opción. Cuando lo haga,
     * se envía un evento tipo ActionEvent al Controlador, que
     * está esperándolo y tiene un metodo para recogerlo
     * y actuar en consecuencia.
     * Notese que necesita ciertos datos del Modelo (nombre, hambre,
     * diversion, amor) y que recibe desde el Controlador.
     */
    public void mostrarMenu(String nombre, int hambre, int diversion, int amor) {
        mostrarEstado(hambre, diversion, amor);

        int opcion = mostrarYLeerOpciones();

        switch (opcion) {
            case 1:
                controlador.actionPerformed(new ActionEvent(this, opcion, JUGAR));
                break;
            case 2:
                controlador.actionPerformed(new ActionEvent(this, opcion, ALIMENTAR));
                break;
            case 3:
                controlador.actionPerformed(new ActionEvent(this, opcion, ACARICIAR));
                break;
            case 0:
                mostrarDespedida(nombre);
                cerrar();
                break;
            default:
                mostrarMensaje("Opción no válida, elige entre 0 y 3.");
                mostrarMenu(nombre, hambre, diversion, amor);
        }
    }

    /*
     * Imprime el menú de opciones y valida el input del usuario.
     */
    private int mostrarYLeerOpciones() {
        System.out.println();
        System.out.println("¿Qué quieres hacer?");
        System.out.println("1. Jugar");
        System.out.println("2. Alimentar");
        System.out.println("3. Acariciar");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");

        while (!teclado.hasNextInt()) {
            System.out.print("Eso no es un número. Elige una opción: ");
            teclado.next();
        }
        return teclado.nextInt();
    }

    /*
     * Da la bienvenida a la app
     */
    private void mostrarBienvenida(String nombreGatito) {
        System.out.println("========================================");
        System.out.println(" ¡Hola! Este es " + nombreGatito);
        System.out.println("========================================");
    }

    /*
     * Pinta el estado actual del gatito. Notese que necesita
     * datos del modelo (hambre, diversión, amor), que le vienen
     * dados desde el Controlador.
     */
    private void mostrarEstado(int hambre, int diversion, int amor) {
        System.out.println();
        System.out.println(" /\\_/\\");
        System.out.println("( o.o )");
        System.out.println(" > ^ <");
        System.out.println("----------------------------------------");
        System.out.println("Hambre    : " + hambre + " / 100");
        System.out.println("Diversión : " + diversion + " / 100");
        System.out.println("Amor      : " + amor + " / 100");
        System.out.println("----------------------------------------");
    }

    /*
     * Muestra mensaje de despedida.
     */
    private void mostrarDespedida(String nombreGatito) {
        System.out.println();
        System.out.println("¡Hasta luego! " + nombreGatito + " te espera para la próxima.");
    }

    /*
     * Deja de escuchar el input de teclado.
     */
    private void cerrar() {
        teclado.close();
    }


}
