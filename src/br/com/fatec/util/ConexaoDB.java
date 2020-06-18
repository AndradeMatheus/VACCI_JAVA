package br.com.fatec.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/db2020";
            String usuario = "root";
            String senha = "password";
            return DriverManager.getConnection(url,usuario,senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}