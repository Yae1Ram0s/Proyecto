package org.example.Vista;

import org.example.Controlador.ControladorEcs;
import org.example.Modelo.ModeloTablaEcs;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private JLabel lblID;
    private JLabel lbl2ID;
    private JLabel lblNombre;
    private JLabel lbl2Nombre;
    private JLabel lblEdad;
    private JLabel lbl2Edad;
    private JLabel lblGenero;
    private JLabel lbl2Genero;
    private JLabel lblNacionalidad;
    private JLabel lbl2Nacionalidad;
    private JLabel lblImagen;
    private JLabel ApartadoEliminar;
    private JLabel lblElimar;
    private JLabel lbl2Imagen;

    private JTextField txtEliminar;
    private JTextField txtID;
    private JTextField txt2ID;
    private JTextField txtNombre;
    private JTextField txt2Nombre;
    private JTextField txtEdad;
    private JTextField txt2Edad;
    private JTextField txtGenero;
    private JTextField txt2Genero;
    private JTextField txtNacionalidad;
    private JTextField txt2Nacionalidad;
    private JTextField txtImagen;
    private JTextField txt2Imagen;

    private JButton btnAgregar;
    private JButton btnCargar;
    private JButton btnActualizar;
    private JButton btnEliminar;

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
        lblImagen = new JLabel("Imagen");
        panel3.add(lblImagen);


        this.getContentPane().add(panel3, 2);


        //PANEL 4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(140, 86, 86));

        lbl2ID = new JLabel("ID");
        txt2ID = new JTextField(3);
        panel4.add(lbl2ID);
        panel4.add(txt2ID);

        lbl2Nombre = new JLabel("Nombre");
        txt2Nombre = new JTextField(10);
        panel4.add(lbl2Nombre);
        panel4.add(txt2Nombre);

        lbl2Edad = new JLabel("Edad:");
        txt2Edad = new JTextField(3);
        panel4.add(lbl2Edad);
        panel4.add(txt2Edad);

        lbl2Genero = new JLabel("Genero:");
        txt2Genero = new JTextField(10);
        panel4.add(lbl2Genero);
        panel4.add(txt2Genero);

        lbl2Nacionalidad = new JLabel("Nacionalidad:");
        txt2Nacionalidad = new JTextField(10);
        panel4.add(lbl2Nacionalidad);
        panel4.add(txt2Nacionalidad);

        lbl2Imagen = new JLabel("Imagen:");
        txt2Imagen = new JTextField(10);
        panel4.add(lbl2Imagen);
        panel4.add(txt2Imagen);


        btnActualizar = new JButton("Actualizar");
        panel4.add(btnActualizar);

        ApartadoEliminar = new JLabel("_________________________________________________________________________________________________________");

        lblElimar = new JLabel("Eliminar ID");
        txtEliminar = new JTextField(4);
        btnEliminar = new JButton("Eliminar");

        panel4.add(ApartadoEliminar);
        panel4.add(lblElimar);
        panel4.add(txtEliminar);
        panel4.add(btnEliminar);





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

    public JLabel getLbl2ID() {
        return lbl2ID;
    }

    public void setLbl2ID(JLabel lbl2ID) {
        this.lbl2ID = lbl2ID;
    }

    public JLabel getLbl2Nombre() {
        return lbl2Nombre;
    }

    public void setLbl2Nombre(JLabel lbl2Nombre) {
        this.lbl2Nombre = lbl2Nombre;
    }

    public JLabel getLbl2Edad() {
        return lbl2Edad;
    }

    public void setLbl2Edad(JLabel lbl2Edad) {
        this.lbl2Edad = lbl2Edad;
    }

    public JLabel getLbl2Genero() {
        return lbl2Genero;
    }

    public void setLbl2Genero(JLabel lbl2Genero) {
        this.lbl2Genero = lbl2Genero;
    }

    public JLabel getLbl2Nacionalidad() {
        return lbl2Nacionalidad;
    }

    public void setLbl2Nacionalidad(JLabel lbl2Nacionalidad) {
        this.lbl2Nacionalidad = lbl2Nacionalidad;
    }

    public JLabel getApartadoEliminar() {
        return ApartadoEliminar;
    }

    public void setApartadoEliminar(JLabel apartadoEliminar) {
        ApartadoEliminar = apartadoEliminar;
    }

    public JLabel getLblElimar() {
        return lblElimar;
    }

    public void setLblElimar(JLabel lblElimar) {
        this.lblElimar = lblElimar;
    }

    public JLabel getLbl2Imagen() {
        return lbl2Imagen;
    }

    public void setLbl2Imagen(JLabel lbl2Imagen) {
        this.lbl2Imagen = lbl2Imagen;
    }

    public JTextField getTxtEliminar() {
        return txtEliminar;
    }

    public void setTxtEliminar(JTextField txtEliminar) {
        this.txtEliminar = txtEliminar;
    }

    public JTextField getTxt2ID() {
        return txt2ID;
    }

    public void setTxt2ID(JTextField txt2ID) {
        this.txt2ID = txt2ID;
    }

    public JTextField getTxt2Nombre() {
        return txt2Nombre;
    }

    public void setTxt2Nombre(JTextField txt2Nombre) {
        this.txt2Nombre = txt2Nombre;
    }

    public JTextField getTxt2Edad() {
        return txt2Edad;
    }

    public void setTxt2Edad(JTextField txt2Edad) {
        this.txt2Edad = txt2Edad;
    }

    public JTextField getTxt2Genero() {
        return txt2Genero;
    }

    public void setTxt2Genero(JTextField txt2Genero) {
        this.txt2Genero = txt2Genero;
    }

    public JTextField getTxt2Nacionalidad() {
        return txt2Nacionalidad;
    }

    public void setTxt2Nacionalidad(JTextField txt2Nacionalidad) {
        this.txt2Nacionalidad = txt2Nacionalidad;
    }

    public JTextField getTxt2Imagen() {
        return txt2Imagen;
    }

    public void setTxt2Imagen(JTextField txt2Imagen) {
        this.txt2Imagen = txt2Imagen;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public ModeloTablaEcs getModelo() {
        return modelo;
    }

    public void setModelo(ModeloTablaEcs modelo) {
        this.modelo = modelo;
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

    public void limpiar(){
        txtNombre.setText("");
        txtEdad.setText("");
        txtGenero.setText("");
        txtNacionalidad.setText("");
        txtImagen.setText("");
    }

    public void LimparPanel4(){
        txt2Nombre.setText("");
        txt2Edad.setText("");
        txt2Genero.setText("");
        txt2Nacionalidad.setText("");
        txt2Imagen.setText("");
    }

    public void LimpiarID(){
        txtID.setText("");
    }

}
