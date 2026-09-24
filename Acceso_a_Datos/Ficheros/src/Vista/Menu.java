package Vista;

import Controlador.FicheroControlador;

import java.util.Scanner;

public class Menu implements InterfazMenu{

    private final Scanner input = new Scanner(System.in);
    private FicheroControlador controlador;
    @Override
    public void init() {

    }

    @Override
    public void setControlador() {

    }

    @Override
    public void mostrarMenu() {

    }

    private void saliendoMenu(){
        System.out.println("Saliendo...");
        System.out.println("Hasta luego, "+System.getProperty("user.name"));
    }
    private void cerrar(){input.close();}
}
