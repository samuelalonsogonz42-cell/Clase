package com.dam.mvc.model;

/*
 * En esta clase tendremos toda la lógica de programa.
 * Aquí, y solo aquí, se llevan a cabo las acciones
 * que modifican los datos del programa.
 */
public class Gatito {

    public static final int VALOR_INICIAL = 20;
    public static final int VALOR_MAXIMO = 100;
    public static final int VALOR_MINIMO = 0;

    private final String nombre;
    private int hambre;
    private int diversion;
    private int amor;

    public Gatito() {
        // Valores iniciales; a criterio vuestro
        this.nombre = "Manchas";
        this.hambre = VALOR_INICIAL;
        this.diversion = VALOR_INICIAL;
        this.amor = VALOR_INICIAL;
    }

    /*
     * Getters de los datos para usar en el Controlador
     */
    public String getNombre() {
        return nombre;
    }

    public int getHambre() {
        return hambre;
    }

    public int getDiversion() {
        return diversion;
    }

    public int getAmor() {
        return amor;
    }

    /**
     * Jugar con el gatito. Aumenta la diversión,
     * pero reduce el hambre y el amor.
     */
    public void jugar() {
        diversion = ajustar(diversion + 10);
        hambre = ajustar(hambre - 5);
        amor = ajustar(amor - 3);
    }

    /**
     * Alimentar al gatito. Aumenta el hambre,
     * pero reduce la diversión y el amor.
     */
    public void alimentar() {
        hambre = ajustar(hambre + 10);
        amor = ajustar(amor - 5);
        diversion = ajustar(diversion - 3);
    }

    /**
     * Acariciar al gatito. Aumenta el amor,
     * pero reduce el hambre y la diversión.
     */
    public void acariciar() {
        amor = ajustar(amor + 10);
        diversion = ajustar(diversion - 5);
        hambre = ajustar(hambre - 3);
    }

    /* Ningún atributo puede salir del rango 0-100,
     * no asesinéis a Manchitas :(
     */
    private int ajustar(int valor) {
        if (valor > VALOR_MAXIMO) {
            return VALOR_MAXIMO;
        }
        if (valor < VALOR_MINIMO) {
            return VALOR_MINIMO;
        }
        return valor;
    }
}
