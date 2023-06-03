package org.example.ConexionSQL;

import org.example.Modelo.Escritores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EscritorDAO implements InterfazDAO {


    public EscritorDAO() {
    }


    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO Escritores(Nombre, Edad, Genero, Nacionalidad, Imagen) VALUES(?, ?, ?, ?, ?)";
        int rowCount = 0;
        PreparedStatement psmt = Conexion.getInstance("EscritoresDB.db").getConnection().prepareStatement(sqlInsert);
        psmt.setString(1, ((Escritores) obj).getNombre());
        psmt.setInt(2, ((Escritores) obj).getEdad());
        psmt.setString(3, ((Escritores) obj).getGenero());
        psmt.setString(4, ((Escritores) obj).getNacionalidad());
        psmt.setString(5, ((Escritores) obj).getImagen());
        rowCount = psmt.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE Escritores SET Nombre = ?, Edad = ?, Genero = ?, Nacionalidad = ?, Imagen = ? WHERE ID = ? ; ";
        int rowCount = 0;
        PreparedStatement psmt = Conexion.getInstance("EscritoresDB.db").getConnection().prepareStatement(sqlUpdate);
        psmt.setString(1, ((Escritores) obj).getNombre());
        psmt.setInt(2, ((Escritores) obj).getEdad());
        psmt.setString(3, ((Escritores) obj).getGenero());
        psmt.setString(4, ((Escritores) obj).getNacionalidad());
        psmt.setString(5, ((Escritores) obj).getImagen());
        psmt.setInt(6, ((Escritores) obj).getID());
        rowCount = psmt.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean delete(String ID) throws SQLException {
        String sqlDelete = "DELETE FROM Escritores WHERE ID = ? ; ";
        int rowCount = 0;
        PreparedStatement psmt = Conexion.getInstance("EscritoresDB.db").getConnection().prepareStatement(sqlDelete);
        psmt.setInt(1, Integer.parseInt(ID));
        rowCount = psmt.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        ArrayList<Object> escritores = new ArrayList<>();
        String sqlSelect = "SELECT * FROM Escritores";
        PreparedStatement psmt = Conexion.getInstance("EscritoresDB.db").getConnection().prepareStatement(sqlSelect);
        ResultSet rs = psmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("ID");
            String nombre = rs.getString("Nombre");
            int edad = rs.getInt("Edad");
            String genero = rs.getString("Genero");
            String nacionalidad = rs.getString("Nacionalidad");
            String imagen = rs.getString("Imagen");

            Escritores escritor = new Escritores(id, nombre, edad, genero, nacionalidad, imagen);
            escritores.add(escritor);
        }

        return escritores;
    }

    @Override
    public Object buscarPorID(String ID) throws SQLException {
        return null;
    }

    public boolean actualizar(Escritores escritor) throws SQLException {
        String sql = "UPDATE escritores SET nombre = ?, edad = ?, genero = ?, nacionalidad = ?, imagen = ? WHERE id = ?";
        PreparedStatement stmt = Conexion.getInstance("EscritoresDB.db").getConnection().prepareStatement(sql);
        try {
            stmt.setString(1, escritor.getNombre());
            stmt.setInt(2, escritor.getEdad());
            stmt.setString(3, escritor.getGenero());
            stmt.setString(4, escritor.getNacionalidad());
            stmt.setString(5, escritor.getImagen());
            stmt.setInt(6, escritor.getID());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }catch (SQLException e){
            System.out.println("Error al actualizar el escritor: " + e.getMessage());
        }
        return false;
    }
}


