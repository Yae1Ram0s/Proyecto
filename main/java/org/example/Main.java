package org.example;

import org.example.ConexionSQL.EscritorDAO;
import org.example.Controlador.ControladorEcs;
import org.example.Modelo.ModeloTablaEcs;
import org.example.Vista.Ventana;

import javax.swing.*;

public class Main {

    public static void main(String[] arg) {

        Ventana ventana = new Ventana("ESCRITORES");
        ControladorEcs control = new ControladorEcs(ventana);

    }
}
