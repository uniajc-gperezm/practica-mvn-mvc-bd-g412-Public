package com.uniajc.vista.swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import com.uniajc.controlador.ControladorEstudiante;


public class VistaEstudianteSwing extends JFrame {

// Componentes de la interfaz    
private JTable tablaEstudiantes;
private DefaultTableModel modeloTabla;
private JTextField txtNombre;
private JTextField txtEdad;
private JTextField txtNombreOriginal;
private JTextField txtBusquedaId;
private JTextField txtBusquedaNombre;

// Botones
private JButton btnAgregar;
private JButton btnActualizar;
private JButton btnEliminar;
private JButton btnBuscarId;
private JButton btnBuscarNombre;
private JButton btnRefrescar;
private JButton btnLimpiar;

public VistaEstudianteSwing() {
 inicializarComponentes();
}

// public void setControlador(ControladorEstudiante controlador) {

    private void inicializarComponentes() {
    setTitle("Sistema de Gestión de Estudiantes - Swing");
    setSize(900, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout(10, 10));

    // ======= PANEL SUPERIOR: título =======
    JLabel lblTitulo = new JLabel("Gestión de Estudiantes", SwingConstants.CENTER);
    lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
    add(lblTitulo, BorderLayout.NORTH);

    // ======= PANEL CENTRAL: tabla =======
    modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre", "Edad"}, 0);
    tablaEstudiantes = new JTable(modeloTabla);
    JScrollPane scrollTabla = new JScrollPane(tablaEstudiantes);
    add(scrollTabla, BorderLayout.CENTER);

    // ======= PANEL IZQUIERDO: formulario =======
    JPanel panelFormulario = new JPanel(new GridLayout(6, 1, 5, 5));
    panelFormulario.setBorder(BorderFactory.createTitledBorder("Datos del Estudiante"));
    
    txtNombre = new JTextField();
    txtEdad = new JTextField();
    txtNombreOriginal = new JTextField();
    txtNombreOriginal.setVisible(false); // Campo oculto si es solo para actualizar
    
    panelFormulario.add(new JLabel("Nombre:"));
    panelFormulario.add(txtNombre);
    panelFormulario.add(new JLabel("Edad:"));
    panelFormulario.add(txtEdad);

    add(panelFormulario, BorderLayout.WEST);

    // ======= PANEL INFERIOR: botones =======
    JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

    btnAgregar = new JButton("Agregar");
    btnActualizar = new JButton("Actualizar");
    btnEliminar = new JButton("Eliminar");
    btnRefrescar = new JButton("Refrescar");
    btnLimpiar = new JButton("Limpiar");

    panelBotones.add(btnAgregar);
    panelBotones.add(btnActualizar);
    panelBotones.add(btnEliminar);
    panelBotones.add(btnRefrescar);
    panelBotones.add(btnLimpiar);

    add(panelBotones, BorderLayout.SOUTH);

    // ======= PANEL DERECHO: búsquedas =======
    JPanel panelBusqueda = new JPanel(new GridLayout(6, 1, 5, 5));
    panelBusqueda.setBorder(BorderFactory.createTitledBorder("Buscar Estudiante"));

    txtBusquedaId = new JTextField();
    txtBusquedaNombre = new JTextField();
    btnBuscarId = new JButton("Buscar por ID");
    btnBuscarNombre = new JButton("Buscar por Nombre");

    panelBusqueda.add(new JLabel("ID:"));
    panelBusqueda.add(txtBusquedaId);
    panelBusqueda.add(btnBuscarId);
    panelBusqueda.add(new JLabel("Nombre:"));
    panelBusqueda.add(txtBusquedaNombre);
    panelBusqueda.add(btnBuscarNombre);

    add(panelBusqueda, BorderLayout.EAST);

    // ======= MOSTRAR VENTANA =======
    setVisible(true);
}

    }
// }


