package service;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.Arrays;

public class GenerarReportes extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JLabel lblGenerarReportes;
    private JButton btnCerrar;
    public JComboBox cmbGenerarReportes;
    private JScrollPane scrollPane;
    private JTextArea txtAreaResultado;


    public GenerarReportes() {
        setTitle("Generar Reportes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 490, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(this);
        btnCerrar.setBounds(375, 11, 89, 23);
        contentPane.add(btnCerrar);

        lblGenerarReportes = new JLabel("Generar Reportes");
        lblGenerarReportes.setBounds(10, 15, 108, 14);
        contentPane.add(lblGenerarReportes);

        cmbGenerarReportes = new JComboBox();
        cmbGenerarReportes.setFont(new Font("Tahoma", Font.PLAIN, 10));
        cmbGenerarReportes.addActionListener(this);
        cmbGenerarReportes.setModel(new DefaultComboBoxModel(new String[]{"Ventas por modelo", "Razón de precios en relación al precio mayor", "Estadística sobre la cantidad Óptima", "Estadística sobre el precio"}));
        cmbGenerarReportes.setBounds(128, 11, 237, 22);
        contentPane.add(cmbGenerarReportes);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 40, 454, 210);
        contentPane.add(scrollPane);

        txtAreaResultado = new JTextArea();
        txtAreaResultado.setText("");
        scrollPane.setViewportView(txtAreaResultado);
        txtAreaResultado.setEditable(false);

        this.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cmbGenerarReportes) {
            actionPerformedGenerar(e);
        }
        if (e.getSource() == btnCerrar) {
            actionPerformedCerrar(e);
        }
    }

    public void actionPerformedGenerar(ActionEvent e) {
        txtAreaResultado.setText("");

        int indicegenerar, contadorsupera = 0, contadorigual = 0, contadormenor = 0;
        indicegenerar = cmbGenerarReportes.getSelectedIndex();

        if (indicegenerar == 0) {
            int recorrido;

            txtAreaResultado.append("VENTAS POR MARCA");

            for (recorrido = 0; recorrido < Tienda.marcas.length; recorrido++) {

                txtAreaResultado.append("\n");
                txtAreaResultado.append("\n Marca\t\t:   " + Tienda.marcas[recorrido]);
                txtAreaResultado.append("\n Cantidad de ventas\t:   " + Tienda.contadorventas[recorrido]);
                txtAreaResultado.append("\n Cantidad de und vendidas\t:   " + Tienda.contadorunidades[recorrido]);
                txtAreaResultado.append("\n Importe total vendido\t:   S/." + Tienda.importestotales[recorrido]);
                txtAreaResultado.append("\n Acumulacion al bono diari\t:   " + Math.round(Tienda.aportes[recorrido]) + "%");
            }
        }

        if (indicegenerar == 1) {

            double[] razon = new double[5];
            double preciomayorazon = 0;

            DecimalFormat formato1 = new DecimalFormat("#.##");

            for (int indPrecios = 0; indPrecios < 5; indPrecios++) {
                if (Tienda.precios[indPrecios] > preciomayorazon) {
                    preciomayorazon = Tienda.precios[indPrecios];
                }
            }

            for (int indRazon = 0; indRazon < 5; indRazon++) {
                razon[indRazon] = Tienda.precios[indRazon] / preciomayorazon;
                txtAreaResultado.append("\n Marca\t:   " + Tienda.marcas[indRazon]);
                txtAreaResultado.append("\n Precio\t:   " + Tienda.precios[indRazon]);
                txtAreaResultado.append("\n Razon\t:   " + formato1.format(razon[indRazon]));
                txtAreaResultado.append("\n");
            }

        }

        if (indicegenerar == 2) {

            for (int indContador = 0; indContador < 5; indContador++) {

                if (Tienda.contadorunidades[indContador] > Tienda.cantidadOptima) {
                    contadorsupera += 1;
                }
                if (Tienda.contadorunidades[indContador] < Tienda.cantidadOptima) {
                    contadormenor += 1;
                }
                if (Tienda.contadorunidades[indContador] == Tienda.cantidadOptima) {
                    contadorigual += 1;
                }
            }

            txtAreaResultado.append(" ESTADISTICA SOBRE LA CANTIDAD OPTIMA" + "\n");
            txtAreaResultado.append("\n");
            txtAreaResultado.append(" Cantidad de marcas que superaron la cantidad optima : " + contadorsupera);
            txtAreaResultado.append("\n Cantidad de marcas que no superaron la cantidad optima : " + contadormenor);
            txtAreaResultado.append("\n Cantidad de marcas que igualaron la cantidad optima : " + contadorigual);
        }

        if (indicegenerar == 3) {
            double preciopromedio;

            preciopromedio = (Arrays.stream(Tienda.precios).sum()) / 5;

            txtAreaResultado.append("ESTADISTICA SOBRE EL PRECIO" + "\n");
            txtAreaResultado.append("\n");
            txtAreaResultado.append("Precio promedio : S/." + preciopromedio + "\n");
            txtAreaResultado.append("Precio mayor : S/." + Arrays.stream(Tienda.precios).max().getAsDouble() + "\n");
            txtAreaResultado.append("Precio menor : S/." + Arrays.stream(Tienda.precios).min().getAsDouble() + "\n");
        }
    }

    public void actionPerformedCerrar(ActionEvent e) {
        Tienda a = new Tienda();
        a.setVisible(true);
        this.setVisible(false);
    }
}
