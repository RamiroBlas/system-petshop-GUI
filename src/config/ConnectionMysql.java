package config;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMysql {
    private static Connection connection;
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "060694";
    private static final String url = "jdbc:mysql://localhost:3306/petshop";

    public Connection conectar() {
        connection = null;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Conexion Establecida");
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar de tipo " + e);
        }
        return connection;
    }

}
