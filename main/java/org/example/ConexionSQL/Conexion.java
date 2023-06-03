package org.example.ConexionSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
    private String baseDatos;
    public static Conexion _instance;
    private Connection connection;


    private Conexion(String database) {
        Connection con;
        this.baseDatos = database;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:"+ baseDatos);
        } catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Conexion getInstance(String baseDatos) {
        if(_instance == null){
            _instance = new Conexion(baseDatos);
        }else{
            System.out.println("Ya fué creada.");
        }
        return _instance;
    }


    public Connection getConnection() {
        return connection;
    }


}
