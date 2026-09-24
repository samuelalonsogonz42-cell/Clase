package com.dam.mvc.controller;

import com.dam.mvc.model.Gatito;
import com.dam.mvc.view.GatitoVista;
import com.dam.mvc.view.InterfazVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que se encarga de comunicar la Vista con el Modelo.
 * Implementamos la interfaz actionListener porque necesitamos
 * procesar un evento de acción (ActionEvent).
 */
public class GatitoControlador implements ActionListener {

    private final Gatito modelo;
    private final GatitoVista vista;

    public GatitoControlador(Gatito modelo, GatitoVista vista) {
        this.modelo = modelo;
        this.vista = vista;

        /* Le indicamos a la vista con qué controlador se tiene que conectar
         * para lanzarle el evento.
         */
        this.vista.setControlador(this);
    }

    public void iniciar() {
        /*
         * El controlador inicia la vista, pasándole los datos
         * del modelo que la vista necesita (nombre y estado
         * del gatito)
         */
        vista.init(modelo.getNombre(), modelo.getHambre(), modelo.getDiversion(), modelo.getAmor());
    }

    /**
     * Procesa el evento que le llega de la Vista, y decide
     * qué acción correspondiente debe llevar a cabo el modelo.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case InterfazVista.JUGAR -> {
                modelo.jugar();
                vista.mostrarMensaje("Juegas con " + modelo.getNombre() + ". ¡Miau!");
            }
            case InterfazVista.ALIMENTAR -> {
                modelo.alimentar();
                vista.mostrarMensaje("Alimentas a " + modelo.getNombre() + ". ¡Ñam ñam!");
            }
            case InterfazVista.ACARICIAR -> {
                modelo.acariciar();
                vista.mostrarMensaje("Acaricias a " + modelo.getNombre() + ". ¡Mrr!");
            }
            default -> {}
        }
        vista.mostrarMenu(modelo.getNombre(), modelo.getHambre(), modelo.getDiversion(), modelo.getAmor());
    }
}
