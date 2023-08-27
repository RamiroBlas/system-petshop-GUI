package service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Vender extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JLabel lblMarca, lblPrecios, lblCantidad;
    public static JTextField txtPrecio;
    private JTextField txtCantidad;
    private JButton btnVender, btnCerrar;
    private JScrollPane scrollPane;
    private JTextArea txtAreaResultado;
    public JComboBox cmbMarca;


    public Vender() {

        setTitle("Vender");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblMarca = new JLabel("Marca");
        lblMarca.setBounds(10, 11, 55, 14);
        contentPane.add(lblMarca);

        lblPrecios = new JLabel("Precio (S/)");
        lblPrecios.setBounds(10, 36, 75, 14);
        contentPane.add(lblPrecios);

        lblCantidad = new JLabel("Cantidad");
        lblCantidad.setBounds(10, 61, 55, 14);
        contentPane.add(lblCantidad);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(75, 33, 176, 20);
        contentPane.add(txtPrecio);
        txtPrecio.setColumns(10);
        txtPrecio.setEditable(false);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(75, 58, 176, 20);
        contentPane.add(txtCantidad);
        txtCantidad.setColumns(10);

        cmbMarca = new JComboBox();
        cmbMarca.addActionListener(this);
        cmbMarca.setModel(new DefaultComboBoxModel(new String[]{"Ricocan", "DogChow", "Pedigree", "allkjoy", "Canbo"}));
        cmbMarca.setBounds(75, 7, 176, 22);
        contentPane.add(cmbMarca);

        btnVender = new JButton("Vender");
        btnVender.addActionListener(this);
        btnVender.setBounds(335, 7, 89, 23);
        contentPane.add(btnVender);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(this);
        btnCerrar.setBounds(335, 52, 89, 23);
        contentPane.add(btnCerrar);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 86, 414, 164);
        contentPane.add(scrollPane);

        txtAreaResultado = new JTextArea();
        scrollPane.setViewportView(txtAreaResultado);
        txtAreaResultado.setEditable(false);

        this.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cmbMarca) {
            actionPerformedMarca(e);
        }
        if (e.getSource() == btnVender) {
            actionPerformedVender(e);
        }
        if (e.getSource() == btnCerrar) {
            actionPerformedCerrar(e);
        }
    }

    public void actionPerformedMarca(ActionEvent e) {
        int indiceMarca;
        indiceMarca = cmbMarca.getSelectedIndex();

        if (indiceMarca >= 0 && indiceMarca < 5) {
            txtPrecio.setText(String.valueOf(Tienda.precios[indiceMarca]));
        }

    }

    public void actionPerformedVender(ActionEvent e) {

        int indiceMarca, cantidad, cantidadObsequio = 0;
        double importecompra, importedescuento = 0, importepagar;
        String tipoObsequio = null;

        txtAreaResultado.setText("");
        indiceMarca = cmbMarca.getSelectedIndex();
        cantidad = Integer.parseInt(txtCantidad.getText());

        if (indiceMarca >= 0 && indiceMarca <= 4) {
            importecompra = Tienda.precios[indiceMarca] * cantidad;

            // Calcular importedescuento basado en la cantidad
            if (cantidad >= 1 && cantidad <= 5) {
                importedescuento = (importecompra * Tienda.porcentajes[0]) / 100;
            } else if (cantidad >= 6 && cantidad <= 10) {
                importedescuento = (importecompra * Tienda.porcentajes[1]) / 100;
            } else if (cantidad >= 11 && cantidad <= 15) {
                importedescuento = (importecompra * Tienda.porcentajes[2]) / 100;
            } else if (cantidad > 15) {
                importedescuento = (importecompra * Tienda.porcentajes[3]) / 100;
            }

            importepagar = importecompra - importedescuento;

            // Establecer tipo de Obsequio basado en la cantidad
            if (cantidad >= 1 && cantidad <= 5) {
                tipoObsequio = Tienda.tipoObsequios[0];
                cantidadObsequio = Tienda.cantidadObsequio[0];
            } else if (cantidad >= 6 && cantidad <= 10) {
                tipoObsequio = Tienda.tipoObsequios[1];
                cantidadObsequio = Tienda.cantidadObsequio[1];
            } else if (cantidad > 10) {
                tipoObsequio = Tienda.tipoObsequios[2];
                cantidadObsequio = Tienda.cantidadObsequio[2];
            }

            // Actualizar datos compartidos
            Tienda.importetotal += importepagar;

            // Actualizar datos específicos de la marca
            Tienda.contadorventas[indiceMarca]++;
            Tienda.contadorunidades[indiceMarca] += cantidad;
            Tienda.importestotales[indiceMarca] += importepagar;

            // Mostrar resultados
            txtAreaResultado.append(" Marca\t\t:  " + Tienda.marcas[indiceMarca]);
            txtAreaResultado.append("\n Precio\t\t:  " + "S/ " + Tienda.precios[indiceMarca]);
            txtAreaResultado.append("\n Cantidad adquirida\t:  " + cantidad);
            txtAreaResultado.append("\n Importe compra\t:  " + "S/ " + (float) importecompra);
            txtAreaResultado.append("\n Importe descuento\t:  " + "S/ " + (float) importedescuento);
            txtAreaResultado.append("\n Importe pagar\t\t:  " + "S/ " + (float) importepagar);
            txtAreaResultado.append("\n Tipo de obsequio\t:  " + tipoObsequio);
            txtAreaResultado.append("\n Unidades de obsequio\t:  " + cantidadObsequio);

            Tienda.contador++;
            if (Tienda.contador == 5) {
                JOptionPane.showMessageDialog(null, "Venta Nro. 5" + "\nImporte total general acumulado : S/. " + (float) Tienda.importetotal);
                Tienda.contador = 0;
            }
        }

    }

    public void actionPerformedCerrar(ActionEvent e) {
        Tienda tienda = new Tienda();
        tienda.setVisible(true);
        this.setVisible(false);
    }

}
