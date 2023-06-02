package org.example.Modelo;

import java.net.URL;

public class Escritores {
    private int ID;
    private String Nombre;
    private int Edad;
    private String Genero;
    private String Nacionalidad;
    private String Imagen;

    public Escritores() {
    }

    public Escritores(int ID, String nombre, int edad, String genero, String nacionalidad, String imagen) {
        this.ID = ID;
        Nombre = nombre;
        Edad = edad;
        Genero = genero;
        Nacionalidad = nacionalidad;
        Imagen = imagen;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        Nacionalidad = nacionalidad;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }

    @Override
    public String toString() {
        return "Escritores{" +
                "ID=" + ID +
                ", Nombre='" + Nombre + '\'' +
                ", Edad=" + Edad +
                ", Genero='" + Genero + '\'' +
                ", Nacionalidad='" + Nacionalidad + '\'' +
                ", Imagen='" + Imagen + '\'' +
                '}';
    }
}