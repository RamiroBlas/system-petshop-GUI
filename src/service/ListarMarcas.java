package service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class ListarMarcas extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea txtAreaResultado;
	private JButton btnCerrar, btnListar;


	public ListarMarcas() {
		setTitle("Listar Marcas");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 210);
		contentPane.add(scrollPane);

		txtAreaResultado = new JTextArea();
		txtAreaResultado.setText("");
		scrollPane.setViewportView(txtAreaResultado);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(115, 227, 89, 23);
		contentPane.add(btnCerrar);

		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(222, 227, 89, 23);
		contentPane.add(btnListar);
		this.setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnListar) {
			actionPerformedListar(e);
		}
		if(e.getSource()==btnCerrar) {
			actionPerformedCerrar(e);
		}
	}
	public void actionPerformedListar(ActionEvent e) {
		txtAreaResultado.setText("");
		txtAreaResultado.append(" LISTADO DE MARCAS \n");

		for (int i = 0; i < Tienda.marcas.length; i++) {
			txtAreaResultado.append(" Marca\t:   " + Tienda.marcas[i] + "\n");
			txtAreaResultado.append(" Precio\t:   " + " S/ " + Tienda.precios[i] + "\n");
			txtAreaResultado.append(" Peso\t:   " + Tienda.pesosKg[i] + " Kg " + "\n");
			txtAreaResultado.append(" Tipo Perro\t:   " + Tienda.tiposAlimentos[i] + "\n");
			txtAreaResultado.append(" Tipo Alimento\t:   " + Tienda.tiposPerros[i] + "\n");
			txtAreaResultado.append("-------------------------------------------------------------------------" + "\n");
		}

	}
	public void actionPerformedCerrar(ActionEvent e) {
		Tienda a = new Tienda();
		a.setVisible(true);
		this.setVisible(false);
	}

}
