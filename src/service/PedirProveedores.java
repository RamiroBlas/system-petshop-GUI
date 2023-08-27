package service;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PedirProveedores extends JFrame implements ActionListener {


    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblModeloN;
    private JLabel lblPrecioN;
    private JLabel lblAnchoN;
    private JLabel lblAltoN;
    private JLabel lblFondoN;
    static JTextField txtPrecioN;
    static JTextField txtPesoKgN;
    static JTextField txtTipoPerroN;
    static JTextField txtTipoAlimentoN;
    private JButton btnPedir;
    private JButton btnCerrar;
    private JTextArea txtAreaR;
    public JComboBox cmbMarcaN;


    public PedirProveedores() {
        setTitle("Nuevos Productos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 551, 407);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblModeloN = new JLabel("Marca :");
        lblModeloN.setBounds(30, 11, 56, 14);
        contentPane.add(lblModeloN);

        lblPrecioN = new JLabel("Precio (S/) :");
        lblPrecioN.setBounds(30, 36, 89, 14);
        contentPane.add(lblPrecioN);

        lblAnchoN = new JLabel("Peso (kg) :");
        lblAnchoN.setBounds(30, 61, 89, 14);
        contentPane.add(lblAnchoN);

        lblAltoN = new JLabel("Tipo Perro :");
        lblAltoN.setBounds(30, 86, 89, 14);
        contentPane.add(lblAltoN);

        lblFondoN = new JLabel("Tipo Alimento :");
        lblFondoN.setBounds(30, 111, 89, 14);
        contentPane.add(lblFondoN);

        cmbMarcaN = new JComboBox();
        cmbMarcaN.addActionListener(this);
        cmbMarcaN.setModel(new DefaultComboBoxModel(new String[]{"Thor", "Nutrican", "Mimaskot", "Royal Canin", "Hills"}));
        cmbMarcaN.setBounds(106, 7, 126, 22);
        contentPane.add(cmbMarcaN);

        txtPrecioN = new JTextField();
        txtPrecioN.setEditable(false);
        txtPrecioN.setBounds(106, 33, 126, 20);
        contentPane.add(txtPrecioN);
        txtPrecioN.setColumns(10);


        txtPesoKgN = new JTextField();
        txtPesoKgN.setEditable(false);
        txtPesoKgN.setBounds(106, 58, 126, 20);
        contentPane.add(txtPesoKgN);
        txtPesoKgN.setColumns(10);


        txtTipoPerroN = new JTextField();
        txtTipoPerroN.setEditable(false);
        txtTipoPerroN.setBounds(106, 83, 126, 20);
        contentPane.add(txtTipoPerroN);
        txtTipoPerroN.setColumns(10);


        txtTipoAlimentoN = new JTextField();
        txtTipoAlimentoN.setEditable(false);
        txtTipoAlimentoN.setBounds(106, 108, 126, 20);
        contentPane.add(txtTipoAlimentoN);
        txtTipoAlimentoN.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 146, 515, 211);
        contentPane.add(scrollPane);

        txtAreaR = new JTextArea();
        txtAreaR.setText("");
        scrollPane.setViewportView(txtAreaR);


        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(this);
        btnCerrar.setBounds(404, 82, 89, 23);
        contentPane.add(btnCerrar);

        btnPedir = new JButton("Pedir");
        btnPedir.addActionListener(this);
        btnPedir.setBounds(404, 32, 89, 23);
        contentPane.add(btnPedir);
        this.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == cmbMarcaN) {
            actionPerformedModeloN(e);
        }
        if (e.getSource() == btnPedir) {
            actionPerformedPedir(e);
        }
        if (e.getSource() == btnCerrar) {
            actionPerformedCerrar(e);
        }
    }

    public void actionPerformedModeloN(ActionEvent e) {
        int indiceMarca;
        indiceMarca = cmbMarcaN.getSelectedIndex();

        if (indiceMarca >= 0 && indiceMarca < 5) {

            actualizarValores(Tienda.preciosNew[indiceMarca], Tienda.pesosKgNew[indiceMarca], Tienda.tiposPerrosNew[indiceMarca], Tienda.tiposAlimentosNew[indiceMarca]);
        }
    }

    private void actualizarValores(double precio, double peso, String tipoPerro, String tipoAlimento) {
        txtPrecioN.setText(String.valueOf(precio));
        txtPesoKgN.setText(String.valueOf(peso));
        txtTipoPerroN.setText(String.valueOf(tipoPerro));
        txtTipoAlimentoN.setText(String.valueOf(tipoAlimento));
    }

    public void actionPerformedPedir(ActionEvent e) {

        txtAreaR.setText("");
        int indiceMarca;
        indiceMarca = cmbMarcaN.getSelectedIndex();

        if (indiceMarca >= 0 && indiceMarca < 5) {
            txtAreaR.append(" Usted a pedido la siguiente Marca" + "\n");
            txtAreaR.append(" Marca	:   " + Tienda.marcasNew[indiceMarca] + "\n");
            txtAreaR.append(" Precio	:   " + " S/ " + Tienda.preciosNew[indiceMarca] + "\n");
            txtAreaR.append(" Peso	:   " + Tienda.pesosKgNew[indiceMarca] + " Kg " + "\n");
            txtAreaR.append(" Tipo Perro	:   " + Tienda.tiposPerrosNew[indiceMarca] + "\n");
            txtAreaR.append(" Tipo Alimento	:   " + Tienda.tiposAlimentosNew[indiceMarca] + "\n");
        }

        String[] nuevaListaMarcas = new String[Tienda.marcas.length + 1];
        double[] nuevaListaPrecios = new double[Tienda.precios.length + 1];
        double[] nuevaListaPesos = new double[Tienda.pesosKg.length + 1];
        String[] nuevaListaTipoPerro = new String[Tienda.tiposPerros.length + 1];
        String[] nuevaListaTipoAlimento= new String[Tienda.tiposAlimentos.length + 1];

        System.arraycopy(Tienda.marcas, 0, nuevaListaMarcas, 0, Tienda.marcas.length);
        System.arraycopy(Tienda.precios, 0, nuevaListaPrecios, 0, Tienda.precios.length);
        System.arraycopy(Tienda.pesosKg, 0, nuevaListaPesos, 0, Tienda.pesosKg.length);
        System.arraycopy(Tienda.tiposPerros, 0, nuevaListaTipoPerro, 0, Tienda.tiposPerros.length);
        System.arraycopy(Tienda.tiposAlimentos, 0, nuevaListaTipoAlimento, 0, Tienda.tiposAlimentos.length);

        nuevaListaMarcas[nuevaListaMarcas.length - 1] = Tienda.marcasNew[indiceMarca];
        nuevaListaPrecios[nuevaListaPrecios.length - 1] = Tienda.preciosNew[indiceMarca];
        nuevaListaPesos[nuevaListaPesos.length - 1] = Tienda.pesosKgNew[indiceMarca];
        nuevaListaTipoPerro[nuevaListaTipoPerro.length - 1] = Tienda.tiposPerrosNew[indiceMarca];
        nuevaListaTipoAlimento[nuevaListaTipoAlimento.length - 1] = Tienda.tiposAlimentosNew[indiceMarca];

        Tienda.marcas = nuevaListaMarcas;
        Tienda.precios = nuevaListaPrecios;
        Tienda.pesosKg = nuevaListaPesos;
        Tienda.tiposPerros = nuevaListaTipoPerro;
        Tienda.tiposAlimentos = nuevaListaTipoAlimento;

    }

    public void actionPerformedCerrar(ActionEvent e) {
        Tienda a = new Tienda();
        a.setVisible(true);
        this.setVisible(false);
    }


}
