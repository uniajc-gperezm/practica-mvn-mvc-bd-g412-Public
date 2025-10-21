package com.uniajc.vista.swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.uniajc.controlador.ControladorEstudiante;

import java.awt.*;

public class VistaEstudianteSwing extends JFrame {
    // Componentes de la interfaz 
    private JTable tablaEstudiantes;
    private DefaultTableModel modeloTabla;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtNombreOriginal;
    private JTextField txtBusquedaId;
    private JTextField txtBusquedaNombre;

    //Botones
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

    public ControladorEstudiante controlador;

    public void setControlador(ControladorEstudiante controlador) {
        this.controlador = controlador;

        // Aquí puedes agregar los listeners a los botones, por ejemplo:
        // btnAgregar.addActionListener(controlador);
    }

    public void inicializarComponentes() {
        setTitle("Sistema de Gestión de Estudiantes - Swing");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
    }
}
