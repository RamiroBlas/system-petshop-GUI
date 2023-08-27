package service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ConfigurarDescuentos extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JLabel lblCantidadObsequioUnoCinco;
    private JLabel lblCantidadObsequioSeisDiez;
    private JLabel lblCabtidadObsequioOnceQuince;
    private JLabel lblCatidadObsequiosQuinceMas;
    private JLabel lblPorcentajeSimboloUno;
    private JLabel lblPorcentajeSimboloDos;
    private JLabel lblPorcentajeSimboloTres;
    private JLabel lblPorcentajeSimboloCuatro;
    private JButton btnCancelar;
    private JButton btnAceptar;
    public static JTextField txtCantidadPorcentajeUnoCinco;
    public static JTextField txtCantidadPorcentajeSeisDiez;
    public static JTextField txtCantidadPorcentajeOnceQuince;
    public static JTextField txtCatidadPorcentajeQuinceMas;


    public ConfigurarDescuentos() {
        setTitle("Configurar porcentajes de descuentos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 153);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblCantidadObsequioUnoCinco = new JLabel("1 a 5 unidades");
        lblCantidadObsequioUnoCinco.setBounds(10, 11, 104, 14);
        contentPane.add(lblCantidadObsequioUnoCinco);

        lblCantidadObsequioSeisDiez = new JLabel("6 a 10 unidades");
        lblCantidadObsequioSeisDiez.setBounds(10, 36, 104, 14);
        contentPane.add(lblCantidadObsequioSeisDiez);

        lblCabtidadObsequioOnceQuince = new JLabel("11 a 15 unidades");
        lblCabtidadObsequioOnceQuince.setBounds(10, 61, 104, 14);
        contentPane.add(lblCabtidadObsequioOnceQuince);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        btnCancelar.setBounds(335, 32, 89, 23);
        contentPane.add(btnCancelar);

        lblCatidadObsequiosQuinceMas = new JLabel("Mas de 15 unidades");
        lblCatidadObsequiosQuinceMas.setBounds(10, 86, 120, 14);
        contentPane.add(lblCatidadObsequiosQuinceMas);

        lblPorcentajeSimboloUno = new JLabel("%");
        lblPorcentajeSimboloUno.setBounds(185, 11, 18, 14);
        contentPane.add(lblPorcentajeSimboloUno);

        lblPorcentajeSimboloDos = new JLabel("%");
        lblPorcentajeSimboloDos.setBounds(185, 36, 18, 14);
        contentPane.add(lblPorcentajeSimboloDos);

        lblPorcentajeSimboloTres = new JLabel("%");
        lblPorcentajeSimboloTres.setBounds(185, 61, 18, 14);
        contentPane.add(lblPorcentajeSimboloTres);

        lblPorcentajeSimboloCuatro = new JLabel("%");
        lblPorcentajeSimboloCuatro.setBounds(185, 86, 18, 14);
        contentPane.add(lblPorcentajeSimboloCuatro);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(this);
        btnAceptar.setBounds(335, 2, 89, 23);
        contentPane.add(btnAceptar);

        txtCantidadPorcentajeUnoCinco = new JTextField();
        txtCantidadPorcentajeUnoCinco.setBounds(130, 8, 50, 20);
        contentPane.add(txtCantidadPorcentajeUnoCinco);
        txtCantidadPorcentajeUnoCinco.setColumns(10);

        txtCantidadPorcentajeSeisDiez = new JTextField();
        txtCantidadPorcentajeSeisDiez.setBounds(130, 33, 50, 20);
        contentPane.add(txtCantidadPorcentajeSeisDiez);
        txtCantidadPorcentajeSeisDiez.setColumns(10);

        txtCantidadPorcentajeOnceQuince = new JTextField();
        txtCantidadPorcentajeOnceQuince.setBounds(130, 58, 50, 20);
        contentPane.add(txtCantidadPorcentajeOnceQuince);
        txtCantidadPorcentajeOnceQuince.setColumns(10);

        txtCatidadPorcentajeQuinceMas = new JTextField();
        txtCatidadPorcentajeQuinceMas.setBounds(130, 86, 50, 20);
        contentPane.add(txtCatidadPorcentajeQuinceMas);
        txtCatidadPorcentajeQuinceMas.setColumns(10);
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

        Tienda.porcentajes[0] = Double.parseDouble(txtCantidadPorcentajeUnoCinco.getText());
        Tienda.porcentajes[1] = Double.parseDouble(txtCantidadPorcentajeSeisDiez.getText());
        Tienda.porcentajes[2] = Double.parseDouble(txtCantidadPorcentajeOnceQuince.getText());
        Tienda.porcentajes[3] = Double.parseDouble(txtCatidadPorcentajeQuinceMas.getText());

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
