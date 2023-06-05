package org.example.Controlador;

import org.example.ConexionSQL.Conexion;
import org.example.ConexionSQL.EscritorDAO;
import org.example.Modelo.Escritores;
import org.example.Modelo.ModeloTablaEcs;
import org.example.Vista.Ventana;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ControladorEcs extends MouseAdapter {
    private Ventana ventana;
    private ModeloTablaEcs modelo;

    public ControladorEcs(Ventana ventana) {
        this.ventana = ventana;
        this.modelo = new ModeloTablaEcs();
        this.ventana.getTblEscritor().setModel(modelo);
        this.ventana.getBtnCargar().addMouseListener(this);
        this.ventana.getBtnAgregar().addMouseListener(this);
        this.ventana.getBtnEliminar().addMouseListener(this);
        this.ventana.getBtnActualizar().addMouseListener(this);

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
            this.ventana.limpiar();

        }

        if (e.getSource() == this.ventana.getBtnActualizar()) {
            int respuesta = JOptionPane.showConfirmDialog(ventana, "¿Esta seguro de actualizar?", "Actualizar datos", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {
                Escritores ects = new Escritores();
                ects.setID(Integer.parseInt((String) this.ventana.getTxt2ID().getText()));
                ects.setNombre(this.ventana.getTxt2Nombre().getText());
                ects.setEdad(Integer.parseInt((String) this.ventana.getTxt2Edad().getText()));
                ects.setGenero(this.ventana.getTxt2Genero().getText());
                ects.setNacionalidad(this.ventana.getTxt2Nacionalidad().getText());
                ects.setImagen(this.ventana.getTxt2Imagen().getText());
                this.ventana.getTblEscritor().updateUI();
                if (modelo.actualizarEscritores(ects)) {
                    JOptionPane.showMessageDialog(ventana, "Se actualizo correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    this.ventana.getTblEscritor().updateUI();
                } else {
                    JOptionPane.showMessageDialog(ventana, "Error al actualizar", "Aviso", JOptionPane.ERROR_MESSAGE);
                }
                this.ventana.LimparPanel4();
            } else {
                this.ventana.LimparPanel4();
            }
        }

        if (e.getSource() == this.ventana.getBtnEliminar()) {
            int respuesta = JOptionPane.showConfirmDialog(ventana, "¿Esta Seguro?", "Eliminar", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {
                String sqlDelete = "DELETE FROM Escritores WHERE ID=?;";
                PreparedStatement pstm = null;
                try {
                    pstm = Conexion.getInstance("EscritoresDB.db").getConnection().prepareStatement(sqlDelete);
                } catch (SQLException sqle) {
                    throw new RuntimeException(sqle);
                }
                try {
                    pstm.setInt(1, Integer.parseInt(this.ventana.getTxtEliminar().getText()));
                    this.ventana.getTblEscritor().updateUI();
                    JOptionPane.showMessageDialog(ventana, "Se elimino correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException a) {
                    JOptionPane.showMessageDialog(ventana, "Error al eliminar", "Aviso", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                try {
                    pstm.executeUpdate();
                } catch (SQLException sqle) {
                    JOptionPane.showMessageDialog(ventana, "Error en Id", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    throw new RuntimeException(sqle);
                } finally {
                    this.ventana.LimparPanel4();
                }

            }
        }



        if (e.getSource() == this.ventana.getTblEscritor()) {
            int rowIndex = this.ventana.getTblEscritor().getSelectedRow();
            modelo.obtenerEscritor(rowIndex);
            Escritores temp = modelo.obtenerEscritor(rowIndex);
            this.ventana.getLbl2Imagen().setText("");
            this.ventana.getLbl2Imagen().setIcon(temp.createIcon());


        }
    }




}








