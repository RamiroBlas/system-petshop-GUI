package service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ConfigurarObsequios extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblTipoObsequio1;
    private JLabel lblTipoObsequio2;
    private JLabel lblTipoObsequio3;
    private JLabel lblCantidadObsequioUnoCinco;
    private JLabel lblCantidadObsequioSeisDiez;
    private JLabel lblCabtidadObsequioOnceMas;
    public static JTextField txtTipoObsequio1;
    public static JTextField txtTipoObsequio2;
    public static JTextField txtTipoObsequio3;
    public static JTextField txtCantidadObsequioUnoCinco;
    public static JTextField txtCantidadObsequioSeisDiez;
    public static JTextField txtCantidadObsequioOnceMas;
    private JButton btnCancelar;
    private JButton btnAceptar;


    public ConfigurarObsequios() {
        setTitle("Configurar obsequios");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 257);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblTipoObsequio1 = new JLabel("Tipo de obsequio 1");
        lblTipoObsequio1.setBounds(10, 10, 119, 20);
        contentPane.add(lblTipoObsequio1);

        lblTipoObsequio2 = new JLabel("Tipo de obsequio 2");
        lblTipoObsequio2.setBounds(10, 40, 119, 20);
        contentPane.add(lblTipoObsequio2);

        lblTipoObsequio3 = new JLabel("Tipo de obsequio 3");
        lblTipoObsequio3.setBounds(10, 70, 119, 20);
        contentPane.add(lblTipoObsequio3);

        lblCantidadObsequioUnoCinco = new JLabel("1 a 5 unidades");
        lblCantidadObsequioUnoCinco.setBounds(10, 100, 89, 20);
        contentPane.add(lblCantidadObsequioUnoCinco);

        lblCantidadObsequioSeisDiez = new JLabel("6 a 10 unidades");
        lblCantidadObsequioSeisDiez.setBounds(10, 130, 89, 20);
        contentPane.add(lblCantidadObsequioSeisDiez);

        lblCabtidadObsequioOnceMas = new JLabel("11 a mas unidades");
        lblCabtidadObsequioOnceMas.setBounds(10, 160, 109, 20);
        contentPane.add(lblCabtidadObsequioOnceMas);

        txtTipoObsequio1 = new JTextField();
        txtTipoObsequio1.setBounds(129, 10, 140, 20);
        contentPane.add(txtTipoObsequio1);
        txtTipoObsequio1.setColumns(10);

        txtTipoObsequio2 = new JTextField();
        txtTipoObsequio2.setBounds(129, 40, 140, 20);
        contentPane.add(txtTipoObsequio2);
        txtTipoObsequio2.setColumns(10);

        txtTipoObsequio3 = new JTextField();
        txtTipoObsequio3.setBounds(129, 70, 140, 20);
        contentPane.add(txtTipoObsequio3);
        txtTipoObsequio3.setColumns(10);

        txtCantidadObsequioUnoCinco = new JTextField();
        txtCantidadObsequioUnoCinco.setBounds(129, 100, 30, 20);
        contentPane.add(txtCantidadObsequioUnoCinco);
        txtCantidadObsequioUnoCinco.setColumns(10);

        txtCantidadObsequioSeisDiez = new JTextField();
        txtCantidadObsequioSeisDiez.setBounds(129, 130, 30, 20);
        contentPane.add(txtCantidadObsequioSeisDiez);
        txtCantidadObsequioSeisDiez.setColumns(10);

        txtCantidadObsequioOnceMas = new JTextField();
        txtCantidadObsequioOnceMas.setBounds(129, 160, 30, 20);
        contentPane.add(txtCantidadObsequioOnceMas);
        txtCantidadObsequioOnceMas.setColumns(10);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(this);
        btnAceptar.setBounds(335, 11, 89, 23);
        contentPane.add(btnAceptar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        btnCancelar.setBounds(335, 36, 89, 23);
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

        Tienda.tipoObsequios[0] = txtTipoObsequio1.getText();
        Tienda.tipoObsequios[1] = txtTipoObsequio2.getText();
        Tienda.tipoObsequios[2] = txtTipoObsequio3.getText();

        Tienda.cantidadObsequio[0] = Integer.parseInt(txtCantidadObsequioUnoCinco.getText());
        Tienda.cantidadObsequio[1] = Integer.parseInt(txtCantidadObsequioSeisDiez.getText());
        Tienda.cantidadObsequio[2] = Integer.parseInt(txtCantidadObsequioOnceMas.getText());

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
