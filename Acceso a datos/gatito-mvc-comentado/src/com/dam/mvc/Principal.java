package com.dam.mvc;

import com.dam.mvc.controller.GatitoControlador;
import com.dam.mvc.model.Gatito;
import com.dam.mvc.view.GatitoVista;

public class Principal {
    public static void main(String[] args) {
        /* Creamos una instancia del modelo y otra de la vista.
         * Si quisiéramos usar otra vista (p.e. una ventana gráfica),
         * lo cambiaríamos aquí.
         */
        Gatito modelo = new Gatito();
        GatitoVista vista = new GatitoVista();

        /*
         * El controlador necesita saber cuál es el modelo y la vista
         * que estamos usando para comunicarse con ellos (llamar a sus
         * métodos)
         */
        GatitoControlador controlador = new GatitoControlador(modelo, vista);

        // Iniciamos el controlador
        controlador.iniciar();
    }
}
