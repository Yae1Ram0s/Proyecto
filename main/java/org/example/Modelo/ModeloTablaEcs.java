package org.example.Modelo;

import org.example.ConexionSQL.EscritorDAO;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModeloTablaEcs implements TableModel {

    public static final int COLUMNS = 6;
    private ArrayList<Escritores> datos;
    private EscritorDAO ldao;

    public ModeloTablaEcs() {
        ldao = new EscritorDAO();
        datos = new ArrayList<>();
        cargarDatos();

    }

    public ModeloTablaEcs(ArrayList<Escritores> datos) {
        this.datos = datos;
        ldao = new EscritorDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "ID";
            case 1:
                return "Nombre";
            case 2:
                return "Edad";
            case 3:
                return "Genero";
            case 4:
                return "Nacionalidad";
            case 5:
                return "Imagen";


        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return Integer.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Escritores tmp = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tmp.getID();
            case 1:
                return tmp.getNombre();
            case 2:
                return tmp.getEdad();
            case 3:
                return tmp.getGenero();
            case 4:
                return tmp.getNacionalidad();
            case 5:
                return tmp.getImagen();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                //datos.get(rowIndex).getID(0);
                break;
            case 1:
                datos.get(rowIndex).setNombre((String) aValue);
            case 2:
                datos.get(rowIndex).setEdad((Integer) aValue);
            case 3:
                datos.get(rowIndex).setGenero((String) aValue);
            case 4:
                datos.get(rowIndex).setNacionalidad((String) aValue);
            case 5:
                datos.get(rowIndex).setImagen((String) aValue);
        }

    }

    @Override
    public void addTableModelListener(TableModelListener l) {



    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public void cargarDatos() {
        try {
            datos = ldao.obtenerTodo();
        } catch (SQLException sqle) {
            System.out.println("Error al cargar lod datos; " + sqle.getMessage());
        }

    }

    public boolean agregarEscritor(Escritores escritores) {
        boolean resultado = false;
        try {
            if (ldao.insertar(escritores)) {
                datos.add(escritores);
                resultado = true;
            } else {
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

}