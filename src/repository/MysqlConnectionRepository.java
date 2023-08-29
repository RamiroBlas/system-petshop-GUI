package repository;

import config.ConnectionMysql;
import entity.Productos;
import service.ConsultarMarca;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class MysqlConnectionRepository {

    Statement statement;
    PreparedStatement preparedStatement;
    ConnectionMysql connectionMysql = new ConnectionMysql();
    Connection connection;
    ResultSet resultSet;
    Productos productos;

    public void rellenarComboBox(String tabla, String valor, JComboBox cmbMarca){
        String sql = "SELECT * FROM " + tabla;

        try{
            connection = connectionMysql.conectar();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
            while (resultSet.next()){
                String item = resultSet.getString(valor);
                if(item != null) {
                    comboBoxModel.addElement(item);
                }
            }
            cmbMarca.setModel(comboBoxModel);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
    }

    public Productos consultarMarca(String tabla, int codigo){

        productos = new Productos();
        String sql = "SELECT * FROM " + tabla + " WHERE codigo = " + codigo;

        try {
            connection = connectionMysql.conectar();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
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

    public void modificarMarca(String tabla, int codigo,double nuevoPrecio, double nuevoPeso, String nuevoTipoPerro, String nuevoTipoAlimento) {
        String sql = "UPDATE " + tabla + " SET precio = ?, peso = ?, tipoPerro = ?, tipoAlimento = ? WHERE codigo = ?";

        try {
            connection = connectionMysql.conectar();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, nuevoPrecio);
            preparedStatement.setDouble(2, nuevoPeso);
            preparedStatement.setString(3, nuevoTipoPerro);
            preparedStatement.setString(4, nuevoTipoAlimento);
            preparedStatement.setInt(5, codigo);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null ,"Actualización exitosa.");
            } else {
                JOptionPane.showMessageDialog(null ,"No se encontró el registro a actualizar.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }


}
