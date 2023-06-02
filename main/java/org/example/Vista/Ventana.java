package org.example.Vista;

import org.example.Controlador.ControladorEcs;
import org.example.Modelo.ModeloTablaEcs;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private JLabel lblID;
    private JLabel lblNombre;
    private JLabel lblEdad;
    private JLabel lblGenero;
    private JLabel lblNacionalidad;
    private JLabel lblImagen;
    private JTextField txtID;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtGenero;
    private JTextField txtNacionalidad;
    private JTextField txtImagen;
    private JTextField txtBuscar;

    private JButton btnAgregar;
    private JButton btnCargar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnBuscar;

    private GridLayout layout;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;

    private JScrollPane scrollPane;
    private JTable tblEscritor;
    private ModeloTablaEcs modelo;


    public Ventana(String title) throws HeadlessException {
        super(title);
        this.setSize(1000, 800);
        layout = new GridLayout(2, 2);
        this.getContentPane().setLayout(layout);


        //PANEL 1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(152, 125, 94));
        lblID = new JLabel("ID");
        txtID = new JTextField(4);
        txtID.setText("0");
        txtID.setEnabled(false);
        panel1.add(lblID);
        panel1.add(txtID);

        lblNombre = new JLabel("Nombre");
        txtNombre = new JTextField(30);
        panel1.add(lblNombre);
        panel1.add(txtNombre);

        lblEdad = new JLabel("Edad:");
        txtEdad = new JTextField(6);
        panel1.add(lblEdad);
        panel1.add(txtEdad);

        lblGenero = new JLabel("Genero:");
        txtGenero = new JTextField(10);
        panel1.add(lblGenero);
        panel1.add(txtGenero);

        lblNacionalidad = new JLabel("Nacionalidad:");
        txtNacionalidad = new JTextField(8);
        panel1.add(lblNacionalidad);
        panel1.add(txtNacionalidad);

        lblImagen = new JLabel("Imagen:");
        txtImagen = new JTextField(8);
        panel1.add(lblImagen);
        panel1.add(txtImagen);

        this.getContentPane().add(panel1, 0);

        btnAgregar = new JButton("Agregar");
        panel1.add(btnAgregar);

        //PANEL 2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(131, 178, 70));
        tblEscritor = new JTable();
        scrollPane = new JScrollPane(tblEscritor);
        btnCargar = new JButton("Cargar");
        panel2.add(btnCargar);
        panel2.add(scrollPane);


        this.getContentPane().add(panel2, 1);

        //PANEL 3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(166, 79, 29));
        lblImagen = new JLabel();
        lblImagen.setPreferredSize(new Dimension(200,200));
        panel3.add(lblImagen);

        this.getContentPane().add(panel3, 2);


        //PANEL 4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(140, 86, 86));



        this.getContentPane().add(panel4, 3);


        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    public JLabel getLblID() {
        return lblID;
    }

    public void setLblID(JLabel lblID) {
        this.lblID = lblID;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JLabel getLblEdad() {
        return lblEdad;
    }

    public void setLblEdad(JLabel lblEdad) {
        this.lblEdad = lblEdad;
    }

    public JLabel getLblGenero() {
        return lblGenero;
    }

    public void setLblGenero(JLabel lblGenero) {
        this.lblGenero = lblGenero;
    }

    public JLabel getLblNacionalidad() {
        return lblNacionalidad;
    }

    public void setLblNacionalidad(JLabel lblNacionalidad) {
        this.lblNacionalidad = lblNacionalidad;
    }

    public JLabel getLblImagen() {
        return lblImagen;
    }

    public void setLblImagen(JLabel lblImagen) {
        this.lblImagen = lblImagen;
    }

    public JTextField getTxtID() {
        return txtID;
    }

    public void setTxtID(JTextField txtID) {
        this.txtID = txtID;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtEdad() {
        return txtEdad;
    }

    public void setTxtEdad(JTextField txtEdad) {
        this.txtEdad = txtEdad;
    }

    public JTextField getTxtGenero() {
        return txtGenero;
    }

    public void setTxtGenero(JTextField txtGenero) {
        this.txtGenero = txtGenero;
    }

    public JTextField getTxtNacionalidad() {
        return txtNacionalidad;
    }

    public void setTxtNacionalidad(JTextField txtNacionalidad) {
        this.txtNacionalidad = txtNacionalidad;
    }

    public JTextField getTxtImagen() {
        return txtImagen;
    }

    public void setTxtImagen(JTextField txtImagen) {
        this.txtImagen = txtImagen;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JTable getTblEscritor() {
        return tblEscritor;
    }


    public JButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(JButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public void setTblEscritor(JTable tblEscritor) {
        this.tblEscritor = tblEscritor;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }
}
