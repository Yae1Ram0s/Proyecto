package org.example.Controlador;

import org.example.Modelo.Escritores;
import org.example.Modelo.ModeloTablaEcs;
import org.example.Vista.Ventana;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ControladorEcs extends MouseAdapter {
    private Ventana ventana;
    private ModeloTablaEcs modelo;

    public ControladorEcs(Ventana ventana) {
        this.ventana = ventana;
        this.modelo = new ModeloTablaEcs();
        this.ventana.getTblEscritor().setModel(modelo);
        this.ventana.getBtnCargar().addMouseListener(this);
        this.ventana.getBtnAgregar().addMouseListener(this);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.ventana.getBtnCargar()) {
            modelo = new ModeloTablaEcs();
            modelo.cargarDatos();
            this.ventana.getTblEscritor().setModel(modelo);
            this.ventana.getTblEscritor().updateUI();
        }

        if (e.getSource() == this.ventana.getBtnAgregar()) {
            Escritores escritor = new Escritores();
            escritor.setID(0);
            escritor.setNombre(this.ventana.getTxtNombre().getText());
            escritor.setEdad(Integer.parseInt(this.ventana.getTxtEdad().getText()));
            escritor.setGenero(this.ventana.getTxtGenero().getText());
            escritor.setNacionalidad(this.ventana.getTxtNacionalidad().getText());
            escritor.setImagen(this.ventana.getTxtImagen().getText());
            if (modelo.agregarEscritor(escritor)) {
                JOptionPane.showMessageDialog(ventana, "Se agrego correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.ventana.getTblEscritor().updateUI();
            } else {
                JOptionPane.showMessageDialog(ventana, "No se pudo agregar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}





