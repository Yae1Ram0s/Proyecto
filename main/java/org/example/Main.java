package org.example;

import org.example.Controlador.ControladorEcs;
import org.example.Vista.Ventana;

public class Main {

    public static void main(String[] arg) {

        Ventana ventana = new Ventana("ESCRITORES");
        ControladorEcs control = new ControladorEcs(ventana);

    }
}

