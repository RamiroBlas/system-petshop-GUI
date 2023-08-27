package service;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AcercaTienda extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JLabel lblTienda;
    private JLabel lblAutores;
    private JLabel Nombre_uno;
    private JButton btnCerrar;


    public AcercaTienda() {
        setTitle("Acerca de Tienda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 440, 355);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblTienda = new JLabel("PET SHOP");
        lblTienda.setHorizontalAlignment(SwingConstants.CENTER);
        lblTienda.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblTienda.setBounds(140, 11, 146, 41);
        contentPane.add(lblTienda);

        ImageIcon imagen = new ImageIcon("img/alimentos.png");
        JLabel etiqueta2 = new JLabel();
        etiqueta2.setBounds(95, 40, 247, 210);
        etiqueta2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta2.getWidth(), etiqueta2.getHeight(), Image.SCALE_SMOOTH)));
        contentPane.add(etiqueta2);

        lblAutores = new JLabel("Autores");
        lblAutores.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblAutores.setHorizontalAlignment(SwingConstants.CENTER);
        lblAutores.setBounds(173, 240, 64, 14);
        contentPane.add(lblAutores);

        Nombre_uno = new JLabel("Ramiro Blas Galicia");
        Nombre_uno.setHorizontalAlignment(SwingConstants.CENTER);
        Nombre_uno.setBounds(135, 260, 146, 14);
        contentPane.add(Nombre_uno);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(this);
        btnCerrar.setBounds(166, 285, 89, 23);
        contentPane.add(btnCerrar);

        this.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        Tienda a = new Tienda();
        a.setVisible(true);
        this.setVisible(false);
    }
}