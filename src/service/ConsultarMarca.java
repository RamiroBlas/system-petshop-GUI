package service;

import config.ConnectionMysql;
import entity.Productos;
import repository.MysqlConnectionRepository;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ConsultarMarca extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JLabel lblMarca, lblPrecio, lblAncho, lblAlto, lblFondo;
    public static JTextField txtTipoPerro, txtPrecio, txtPesoKg, txtTipoAlimento;
    private JButton btnCerrar;
    public JComboBox cmbMarca;
    MysqlConnectionRepository connectiondb = new MysqlConnectionRepository();
    Productos productos = new Productos();

    public ConsultarMarca() {
        setTitle("Consultar Marca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 203);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblMarca = new JLabel("Marca");
        lblMarca.setBounds(10, 31, 90, 14);
        contentPane.add(lblMarca);

        lblPrecio = new JLabel("Precio (S/)");
        lblPrecio.setBounds(10, 56, 90, 14);
        contentPane.add(lblPrecio);

        lblAncho = new JLabel("Peso (Kg)");
        lblAncho.setBounds(10, 81, 90, 14);
        contentPane.add(lblAncho);

        lblAlto = new JLabel("Tipo Perro ");
        lblAlto.setBounds(10, 106, 90, 14);
        contentPane.add(lblAlto);

        lblFondo = new JLabel("Tipo Alimento ");
        lblFondo.setBounds(10, 131, 90, 14);
        contentPane.add(lblFondo);

        cmbMarca = new JComboBox();
        cmbMarca.addActionListener(this);
        connectiondb.rellenarComboBox("productos", "marca", cmbMarca);
        //cmbMarca.setModel(new DefaultComboBoxModel(new String[]{"Ricocan", "Dog-Chow", "Pedigree", "allkjoy", "Canbo"}));
        cmbMarca.setBounds(110, 27, 198, 22);
        contentPane.add(cmbMarca);

        txtPrecio = new JTextField();
        txtPrecio.setText("0.0");
        txtPrecio.setColumns(10);
        txtPrecio.setBounds(110, 53, 198, 20);
        contentPane.add(txtPrecio);
        txtPrecio.setEditable(false);

        txtPesoKg = new JTextField();
        txtPesoKg.setText("0.0");
        txtPesoKg.setColumns(10);
        txtPesoKg.setBounds(110, 78, 198, 20);
        contentPane.add(txtPesoKg);
        txtPesoKg.setEditable(false);

        txtTipoPerro = new JTextField();
        txtTipoPerro.setText("-/-");
        txtTipoPerro.setBounds(110, 103, 198, 20);
        contentPane.add(txtTipoPerro);
        txtTipoPerro.setColumns(10);
        txtTipoPerro.setEditable(false);

        txtTipoAlimento = new JTextField();
        txtTipoAlimento.setText("-/-");
        txtTipoAlimento.setColumns(10);
        txtTipoAlimento.setBounds(110, 128, 198, 20);
        contentPane.add(txtTipoAlimento);
        txtTipoAlimento.setEditable(false);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(this);
        btnCerrar.setBounds(335, 27, 89, 23);
        contentPane.add(btnCerrar);
        this.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cmbMarca) {
            actionPerformedMarca(e);
        }
        if (e.getSource() == btnCerrar) {
            actionperformedCerrar(e);
        }
    }

    public void actionPerformedMarca(ActionEvent e) {

        int indiceMarca = cmbMarca.getSelectedIndex();

       if (indiceMarca >= 0 && indiceMarca < cmbMarca.getItemCount()) {

           int codigo = indiceMarca + 1;

            productos = connectiondb.consultarMarca("productos", codigo);

        }
       mostrarValores(productos);
    }

    private void mostrarValores(Productos productos) {
        txtPrecio.setText(String.valueOf(productos.getPrecio()));
        txtPesoKg.setText(String.valueOf(productos.getPeso()));
        txtTipoPerro.setText(productos.getTipoPerro());
        txtTipoAlimento.setText(productos.getTipoAlimento());
    }

    public void actionperformedCerrar(ActionEvent e) {
        Tienda tienda = new Tienda();
        tienda.setVisible(true);
        this.setVisible(false);
    }

}
