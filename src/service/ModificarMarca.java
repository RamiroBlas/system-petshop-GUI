package service;

import entity.Productos;
import repository.MysqlConnectionRepository;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ModificarMarca extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JLabel lblMarca, lblPrecio, lblPesoKg, lblTipoPerro, lblTipoAlimento;
    public static JTextField txtPrecio, txtPesoKg, txtTipoPerro, txtTipoAlimento;
    public JComboBox cmbMarca;
    private JButton btnGrabar, btnCerrar;
    MysqlConnectionRepository connectiondb = new MysqlConnectionRepository();
    Productos productos = new Productos();

    public ModificarMarca() {

        setTitle("Modificar Marca");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 174);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblMarca = new JLabel("Marca");
        lblMarca.setBounds(10, 11, 73, 14);
        contentPane.add(lblMarca);

        lblPrecio = new JLabel("Precio (S/)");
        lblPrecio.setBounds(10, 36, 73, 14);
        contentPane.add(lblPrecio);

        lblPesoKg = new JLabel("Peso (Kg)");
        lblPesoKg.setBounds(10, 61, 73, 14);
        contentPane.add(lblPesoKg);

        lblTipoPerro = new JLabel("Tipo Perro");
        lblTipoPerro.setBounds(10, 86, 73, 14);
        contentPane.add(lblTipoPerro);

        lblTipoAlimento = new JLabel("Tipo Alimento");
        lblTipoAlimento.setBounds(10, 111, 90, 14);
        contentPane.add(lblTipoAlimento);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(120, 33, 180, 20);
        contentPane.add(txtPrecio);
        txtPrecio.setColumns(10);

        txtPesoKg = new JTextField();
        txtPesoKg.setBounds(120, 58, 180, 20);
        contentPane.add(txtPesoKg);
        txtPesoKg.setColumns(10);

        txtTipoPerro = new JTextField();
        txtTipoPerro.setBounds(120, 83, 180, 20);
        contentPane.add(txtTipoPerro);
        txtTipoPerro.setColumns(10);

        txtTipoAlimento = new JTextField();
        txtTipoAlimento.setBounds(120, 108, 180, 20);
        contentPane.add(txtTipoAlimento);
        txtTipoAlimento.setColumns(10);

        cmbMarca = new JComboBox();
        cmbMarca.addActionListener(this);
        connectiondb.rellenarComboBox("productos", "marca", cmbMarca);
        cmbMarca.setBounds(120, 7, 180, 22);
        contentPane.add(cmbMarca);

        btnGrabar = new JButton("Grabar");
        btnGrabar.addActionListener(this);
        btnGrabar.setBounds(335, 7, 89, 23);
        contentPane.add(btnGrabar);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(this);
        btnCerrar.setBounds(335, 32, 89, 23);
        contentPane.add(btnCerrar);
        this.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cmbMarca) {
            actionPerformedModelo(e);
        }
        if (e.getSource() == btnGrabar) {
            actionPerformedGrabar(e);
        }
        if (e.getSource() == btnCerrar) {
            actionPerformedCerrar(e);
        }
    }

    public void actionPerformedModelo(ActionEvent e) {

        int indiceMarca = cmbMarca.getSelectedIndex();

        if (indiceMarca >= 0 && indiceMarca < cmbMarca.getItemCount()) {
            int codigo = indiceMarca + 1;
            productos = connectiondb.consultarMarca("productos", codigo);
            mostrarValores(productos);
        }
    }

    private void mostrarValores(Productos productos) {
        txtPrecio.setText(String.valueOf(productos.getPrecio()));
        txtPesoKg.setText(String.valueOf(productos.getPeso()));
        txtTipoPerro.setText(productos.getTipoPerro());
        txtTipoAlimento.setText(productos.getTipoAlimento());
    }

    public void actionPerformedGrabar(ActionEvent e) {
        int indiceMarca = cmbMarca.getSelectedIndex();

        if (indiceMarca >= 0 && indiceMarca < cmbMarca.getItemCount()) {
            Tienda tienda = new Tienda();
            tienda.setVisible(true);
            this.setVisible(false);

            int codigo = indiceMarca + 1;
            double newPrecio = Double.parseDouble(txtPrecio.getText());
            double newPesoKg = Double.parseDouble(txtPesoKg.getText());
            String newTipoPerro = txtTipoPerro.getText();
            String newTipoAlimento = txtTipoAlimento.getText();

            connectiondb.modificarMarca("productos", codigo, newPrecio, newPesoKg, newTipoPerro, newTipoAlimento);
        }
    }

    public void actionPerformedCerrar(ActionEvent e) {
        Tienda tienda = new Tienda();
        tienda.setVisible(true);
        this.setVisible(false);
    }

}
