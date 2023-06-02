package org.example.ConexionSQL;

import java.sql.SQLException;
import java.util.ArrayList;

public interface InterfazDAO {
    boolean insertar(Object obj) throws SQLException;
    boolean update(Object obj) throws SQLException;
    boolean delete(String ID) throws SQLException;
    ArrayList obtenerTodo() throws SQLException;
    Object buscarPorID(String ID) throws SQLException;

}
