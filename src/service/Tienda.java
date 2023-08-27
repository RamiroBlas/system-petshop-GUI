package service;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Tienda extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JMenu mnArchivo, mnAyuda, mnConfiguracion, mnVentas, mnProductos, mnPedirProducto;
    private JMenuItem mntmSalir, mntmConsultarMarca, mntmModificarMarca, mntmListarMarca, mntmVender, mntmGenerarReportes, mntmConfigurarDescuentos,
            mntmConfigurarObsequios, mntmConfigurarCantidadOptima, mntmConfigurarCuotaDiaria, mntmPedirProductos, mntmAcercaDeTienda;
    private ImageIcon imagen;
    private JLabel etiqueta1;
    private JMenuBar menuBar;
    public static int contador = 0;
    public static double importetotal = 0;

    //GenerarReportes
    //Indice0
    //Primera0
    public static int[] contadorventas = {
            0,
            0,
            0,
            0,
            0
    };

    public static int[] contadorunidades = {
            0,
            0,
            0,
            0,
            0
    };

    public static double[] importestotales = {
            0,
            0,
            0,
            0,
            0
    };

    public static double[] aportes = {
            0,
            0,
            0,
            0,
            0
    };

    public static String[] marcas = {
            "Ricocan",
            "DogChow",
            "Pedigree",
            "allkjoy",
            "Canbo"
    };

    public static double[] precios = {
            104.9,
            134.9,
            159.9,
            179.9,
            201.9
    };

    public static double[] pesosKg = {
            15.0,
            15.0,
            15.0,
            15.0,
            15.0
    };

    public static String[] tiposPerros = {
            "GRANDES",
            "MEDIANA",
            "MEDIANA",
            "PEQUEÑA",
            "MEDIANA"
    };

    public static String[] tiposAlimentos = {
            "CORDERO",
            "POLLO",
            "CORDERO Y POLLO",
            "LECHE Y POLLO",
            "HIPOALERGENO"
    };

    // Porcentajes de descuento
    public static double[] porcentajes = {
            7.5,
            10.0,
            12.5,
            15.0
    };

    // Obsequios
    public static String[] tipoObsequios = {
            "Snack de pollo",
            "Plato de aluminio",
            "Vale para Baño y Corte "
    };

    public static int[] cantidadObsequio = {
            2,
            3,
            4
    };

    // Cantidad optima de unidades vendidas por dia
    public static int cantidadOptima = 10;

    // Nuevas Marcas
    public static String[] marcasNew = {
            "Nutrican",
            "Thor",
            "Mimaskot",
            "Royal Canin",
            "Hills"
    };

    public static double[] preciosNew = {
            74.9,
            65.9,
            89.9,
            199.9,
            210.9
    };

    public static double[] pesosKgNew = {
            15.0,
            15.0,
            15.0,
            15.0,
            15.0
    };

    public static String[] tiposPerrosNew = {
            "GRANDES",
            "MEDIANA",
            "MEDIANA",
            "PEQUEÑA",
            "MEDIANA"
    };

    public static String[] tiposAlimentosNew = {
            "CORDERO",
            "POLLO",
            "CORDERO Y POLLO",
            "LECHE Y POLLO",
            "HIPOALERGENO"
    };


    public Tienda() {
        setSize(700, 420);
        setTitle("PET SHOP");
        setLocationRelativeTo(null);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void iniciarComponentes() {
        panel();
        menu();
        etiquetas();
    }

    private void panel() {
        contentPane = new JPanel();
        contentPane.setLayout(null);
        this.getContentPane().add(contentPane);
    }

    private void menu() {

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        mnArchivo = new JMenu("Inicio");
        menuBar.add(mnArchivo);

        mntmSalir = new JMenuItem("Salir");
        mnArchivo.add(mntmSalir);
        mntmSalir.addActionListener(this);

        mnProductos = new JMenu("Productos");
        menuBar.add(mnProductos);

        mntmConsultarMarca = new JMenuItem("Consultar Marca");
        mnProductos.add(mntmConsultarMarca);
        mntmConsultarMarca.addActionListener(this);

        mntmModificarMarca = new JMenuItem("Modificar Marca");
        mnProductos.add(mntmModificarMarca);
        mntmModificarMarca.addActionListener(this);

        mntmListarMarca = new JMenuItem("Listar Marcas");
        mnProductos.add(mntmListarMarca);
        mntmListarMarca.addActionListener(this);

        mnVentas = new JMenu("Ventas");
        menuBar.add(mnVentas);

        mntmVender = new JMenuItem("Vender");
        mnVentas.add(mntmVender);
        mntmVender.addActionListener(this);

        mntmGenerarReportes = new JMenuItem("Generar reportes");
        mnVentas.add(mntmGenerarReportes);
        mntmGenerarReportes.addActionListener(this);

        mnConfiguracion = new JMenu("Configuracion");
        menuBar.add(mnConfiguracion);

        mntmConfigurarDescuentos = new JMenuItem("Configurar descuentos");
        mnConfiguracion.add(mntmConfigurarDescuentos);
        mntmConfigurarDescuentos.addActionListener(this);

        mntmConfigurarObsequios = new JMenuItem("Configurar obsequios");
        mnConfiguracion.add(mntmConfigurarObsequios);
        mntmConfigurarObsequios.addActionListener(this);

        mntmConfigurarCantidadOptima = new JMenuItem("Configurar cantidad optima");
        mnConfiguracion.add(mntmConfigurarCantidadOptima);
        mntmConfigurarCantidadOptima.addActionListener(this);

        mnPedirProducto = new JMenu("Proveedores");
        menuBar.add(mnPedirProducto);

        mntmPedirProductos = new JMenuItem("Pedir Productos");
        mnPedirProducto.add(mntmPedirProductos);
        mntmPedirProductos.addActionListener(this);

        mnAyuda = new JMenu("Mas");
        menuBar.add(mnAyuda);

        mntmAcercaDeTienda = new JMenuItem("Acerca de Tienda");
        mnAyuda.add(mntmAcercaDeTienda);
        mntmAcercaDeTienda.addActionListener(this);
    }

    private void etiquetas() {
        imagen = new ImageIcon("img/portada.png");
        etiqueta1 = new JLabel();
        etiqueta1.setBounds(0, 0, 690, 370);
        etiqueta1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
        contentPane.add(etiqueta1);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mntmSalir) {
            actionPerformedSalir(e);
        }
        if (e.getSource() == mntmConsultarMarca) {
            actionPerformedConsultarMarca(e);
        }
        if (e.getSource() == mntmModificarMarca) {
            actionPerformedModificarMarca(e);
        }
        if (e.getSource() == mntmListarMarca) {
            actionPerformedListarMarca(e);
        }
        if (e.getSource() == mntmVender) {
            actionPerformedVender(e);
        }
        if (e.getSource() == mntmGenerarReportes) {
            actionPerformedGenerarReportes(e);
        }
        if (e.getSource() == mntmConfigurarDescuentos) {
            actionPerformedConfigurarDescuentos(e);
        }
        if (e.getSource() == mntmConfigurarObsequios) {
            actionPerformedConfigurarObsequios(e);
        }
        if (e.getSource() == mntmConfigurarCantidadOptima) {
            actionPerformedConfigurarCantidadOptima(e);
        }
        if (e.getSource() == mntmPedirProductos) {
            actionPerformedNuevasMarcas(e);
        }
        if (e.getSource() == mntmAcercaDeTienda) {
            actionPerformedAcercaDeTienda(e);
        }
    }

    public void actionPerformedSalir(ActionEvent e) {
        System.exit(0);
    }

    public void actionPerformedConsultarMarca(ActionEvent e) {
        ConsultarMarca consultarMarca = new ConsultarMarca();
        consultarMarca.setVisible(true);
        this.setVisible(false);

        consultarMarca.cmbMarca.setSelectedIndex(-1);
        consultarMarca.txtPrecio.setText("0.0");
        consultarMarca.txtPesoKg.setText("0.0");
        consultarMarca.txtTipoPerro.setText("-/-");
        consultarMarca.txtTipoAlimento.setText("-/-");
    }

    public void actionPerformedModificarMarca(ActionEvent e) {
        ModificarMarca modificarMarca = new ModificarMarca();
        modificarMarca.setVisible(true);
        this.setVisible(false);

        modificarMarca.cmbMarca.setSelectedIndex(-1);
        modificarMarca.txtPrecio.setText("0.0");
        modificarMarca.txtPesoKg.setText("0.0");
        modificarMarca.txtTipoPerro.setText("-/-");
        modificarMarca.txtTipoAlimento.setText("-/-");

    }

    public void actionPerformedListarMarca(ActionEvent e) {
        ListarMarcas listarMarcas = new ListarMarcas();
        listarMarcas.setVisible(true);
        this.setVisible(false);
    }

    public void actionPerformedVender(ActionEvent e) {
        Vender vender = new Vender();
        vender.setVisible(true);
        this.setVisible(false);

        vender.cmbMarca.setSelectedIndex(-1);
        vender.txtPrecio.setText(" --/-- ");
    }

    public void actionPerformedGenerarReportes(ActionEvent e) {
        GenerarReportes generarReportes = new GenerarReportes();
        generarReportes.setVisible(true);
        this.setVisible(false);

        generarReportes.cmbGenerarReportes.setSelectedIndex(-1);
    }

    public void actionPerformedConfigurarDescuentos(ActionEvent e) {
        ConfigurarDescuentos a = new ConfigurarDescuentos();
        a.setVisible(true);
        this.setVisible(false);
        ConfigurarDescuentos.txtCantidadPorcentajeUnoCinco.setText(String.valueOf(porcentajes[0]));
        ConfigurarDescuentos.txtCantidadPorcentajeSeisDiez.setText(String.valueOf(porcentajes[1]));
        ConfigurarDescuentos.txtCantidadPorcentajeOnceQuince.setText(String.valueOf(porcentajes[2]));
        ConfigurarDescuentos.txtCatidadPorcentajeQuinceMas.setText(String.valueOf(porcentajes[3]));
    }

    public void actionPerformedConfigurarObsequios(ActionEvent e) {
        ConfigurarObsequios configurarObsequios = new ConfigurarObsequios();
        configurarObsequios.setVisible(true);
        this.setVisible(false);
        configurarObsequios.txtTipoObsequio1.setText(tipoObsequios[0]);
        configurarObsequios.txtTipoObsequio2.setText(tipoObsequios[1]);
        configurarObsequios.txtTipoObsequio3.setText(tipoObsequios[02]);
        configurarObsequios.txtCantidadObsequioUnoCinco.setText(String.valueOf(cantidadObsequio[0]));
        configurarObsequios.txtCantidadObsequioSeisDiez.setText(String.valueOf(cantidadObsequio[1]));
        configurarObsequios.txtCantidadObsequioOnceMas.setText(String.valueOf(cantidadObsequio[2]));

    }

    public void actionPerformedConfigurarCantidadOptima(ActionEvent e) {
        ConfigurarCantidadOptima a = new ConfigurarCantidadOptima();
        a.setVisible(true);
        this.setVisible(false);
        ConfigurarCantidadOptima.txtCantidadOptimaUnidadesVendidas.setText(String.valueOf(cantidadOptima));
    }

    public void actionPerformedAcercaDeTienda(ActionEvent e) {
        AcercaTienda a = new AcercaTienda();
        a.setVisible(true);
        this.setVisible(false);
    }

    public void actionPerformedNuevasMarcas(ActionEvent e) {
        PedirProveedores pedirProveedores = new PedirProveedores();
        pedirProveedores.setVisible(true);
        this.setVisible(false);

        pedirProveedores.cmbMarcaN.setSelectedIndex(-1);
        pedirProveedores.txtPrecioN.setText("0.0");
        pedirProveedores.txtPesoKgN.setText("0.0");
        pedirProveedores.txtTipoPerroN.setText("-/-");
        pedirProveedores.txtTipoAlimentoN.setText("-/-");
    }

}
