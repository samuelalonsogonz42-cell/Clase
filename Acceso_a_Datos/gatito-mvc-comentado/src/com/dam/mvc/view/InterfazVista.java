package com.dam.mvc.view;

import com.dam.mvc.controller.GatitoControlador;

public interface InterfazVista {

    void setControlador(GatitoControlador c);
    void mostrarMensaje(String mensaje);
    void init(String nombre, int hambre, int diversion, int amor);
    void mostrarMenu(String nombre, int hambre, int diversion, int amor);

    static final String JUGAR = "Jugar con gatito";
    static final String ALIMENTAR = "Alimentar gatito";
    static final String ACARICIAR = "Acariciar gatito";
}
