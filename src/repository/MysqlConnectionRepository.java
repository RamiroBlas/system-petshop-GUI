package repository;

import config.ConnectionMysql;
import entity.Productos;
import service.ConsultarMarca;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConnectionRepository {

    public Productos consultaMarca(){
        Productos productos = new Productos();
        String sql = "SELECT * FROM productos";
        Statement statement;
        ConnectionMysql connectionMysql = new ConnectionMysql();
        Connection connection = connectionMysql.conectar();
        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                productos.setCodigo(resultSet.getInt("codigo"));
                productos.setMarca(resultSet.getString("marca"));
                productos.setPrecio(resultSet.getFloat("precio"));
                productos.setPeso(resultSet.getInt("peso"));
                productos.setTipoPerro(resultSet.getString("tipoPerro"));
                productos.setTipoAlimento(resultSet.getString("tipoAlimento"));
            }

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
        return productos;
    }
}
