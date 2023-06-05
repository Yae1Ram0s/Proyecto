package org.example.ConexionSQL;

import org.example.Modelo.Escritores;

import java.sql.*;
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
        String sql = "SELECT * FROM Escritores";
        ArrayList<Escritores> resultado = new ArrayList<>();
        Statement stm = Conexion.getInstance("EscritoresDB.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()){
            resultado.add(new Escritores (rst.getInt(1), rst.getString(2),
                    rst.getInt(3), rst.getString(4),
                    rst.getString(5), rst.getString(6)));
        }
        return resultado;
    }

    @Override
    public Object buscarPorID(String ID) throws SQLException {
        String slq = "SELECT * FROM Escritores WHERE ID = ?;";
        PreparedStatement pstm = Conexion.getInstance("EscritoresDB.db").getConnection().prepareStatement(slq);
        pstm.setInt(1, Integer.parseInt(ID));
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            Escritores ecs = new Escritores(rst.getInt(1), rst.getString(2),
                    rst.getInt(3), rst.getString(4),
                    rst.getString(5), rst.getString(6));
            return ecs;

        }

        return null;
    }


}


