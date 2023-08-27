package service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ConfigurarCantidadOptima extends JFrame implements ActionListener {

    private JPanel contentPane;
    public static JTextField txtCantidadOptimaUnidadesVendidas;
    private JLabel lblCantidadOptimaUnidadesVendidas;
    private JButton btnAceptar;
    private JButton btnCancelar;


    public ConfigurarCantidadOptima() {
        setTitle("Configurar cantidad optima");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 114);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblCantidadOptimaUnidadesVendidas = new JLabel("Cantidad óptima de unidades vendidas");
        lblCantidadOptimaUnidadesVendidas.setBounds(10, 11, 221, 14);
        contentPane.add(lblCantidadOptimaUnidadesVendidas);

        txtCantidadOptimaUnidadesVendidas = new JTextField();
        txtCantidadOptimaUnidadesVendidas.setBounds(246, 8, 43, 20);
        contentPane.add(txtCantidadOptimaUnidadesVendidas);
        txtCantidadOptimaUnidadesVendidas.setColumns(10);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(this);
        btnAceptar.setBounds(335, 11, 89, 23);
        contentPane.add(btnAceptar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        btnCancelar.setBounds(335, 45, 89, 23);
        contentPane.add(btnCancelar);
        this.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAceptar) {
            actionPerformedAceptar(e);
        }
        if (e.getSource() == btnCancelar) {
            actionPerformedCancelar(e);
        }
    }

    public void actionPerformedAceptar(ActionEvent e) {
        Tienda.cantidadOptima = Integer.parseInt(txtCantidadOptimaUnidadesVendidas.getText());
        Tienda a = new Tienda();
        a.setVisible(true);
        this.setVisible(false);
    }

    public void actionPerformedCancelar(ActionEvent e) {
        Tienda a = new Tienda();
        a.setVisible(true);
        this.setVisible(false);

    }
}
